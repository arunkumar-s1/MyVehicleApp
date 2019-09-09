package com.dao;
import java.util.*;

import org.apache.log4j.Logger;

import com.beanclass.vechiclepojo;
import com.database.connection.DatabaseConnection;
import com.logger.Welcome;

import java.sql.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
/*
 * this class represent the database operation(CRUD) for Vehicle 
 */
public class vechicleDao {
		static Logger log = Logger.getLogger(vechicleDao.class);
	    public static int save(vechiclepojo v) throws SQLException{  
	        int status=0;  
	        Connection con=null;
	        try{  
	            con=DatabaseConnection.getConnection();  
	            PreparedStatement ps=con.prepareStatement(  
	                         "insert into vehicle values (seq_person.nextval,?,?,?,?,?)");  
//	            ps.setInt(1, v.getId());
	            ps.setString(1,v.getName()); 
	            ps.setInt(2, v.getWheels());
	            ps.setInt(3, v.getSeats());
	            ps.setString(4, v.getNumber_plate());
	            java.sql.Date sqlDate = new java.sql.Date(v.getDateOfPurchase().getTime());
	            ps.setDate(5, sqlDate);
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(SQLException se){
	            //Handle errors for JDBC
	        	log.error(se.getMessage());
	 	        log.error("Connection failed");
	         }catch(Exception e){
	        	 	log.error(e.getMessage());
		 	        log.error("Connection failed");
	        	 //Handle errors for Class.forName
	         }finally{
	            //finally block used to close resources
	            try{
	               if(con!=null)
	                  con.close();
	            }catch(SQLException se){
	            	log.error(se.getMessage());
		 	        log.error("Connection failed");
	            }//end finally try
	         }
	          
	        return status;  
	    }  
	    public static int update(vechiclepojo e) throws SQLException{  
	        int status=0;  
	        Connection con=null;
	        try{  
	            con=DatabaseConnection.getConnection();  
	            PreparedStatement ps=con.prepareStatement(  
	                         "update vehicle set v_name=?,wheels=?,seats=?,number_plate=?,date_of_purchase=? where v_id=?");  
	            ps.setString(1,e.getName());  
	            ps.setInt(2,e.getWheels());  
	            ps.setInt(3,e.getSeats());  
	            ps.setString(4,e.getNumber_plate());  
	            java.sql.Date sqlDate = new java.sql.Date(e.getDateOfPurchase().getTime());
	            ps.setDate(5, sqlDate);
	            ps.setInt(6,e.getId());  
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(SQLException se){
	            //Handle errors for JDBC
	        	log.error(se.getMessage());
	 	        log.error("Connection failed");
	         }catch(Exception ex){
	        	 log.error(ex.getMessage());
		 	        log.error("Connection failed");
	        	 //Handle errors for Class.forName
	         }finally{
	            //finally block used to close resources
	            try{
	               if(con!=null)
	                  con.close();
	            }catch(SQLException se){
	            	log.error(se.getMessage());
		 	        log.error("Connection failed");
	            }//end finally try
	         } 
	          
	        return status;  
	    }  
	    public static int delete(int id) throws SQLException{  
	        int status=0;  
	        Connection con=null;
	        try{  
	            con=DatabaseConnection.getConnection();  
	            PreparedStatement ps=con.prepareStatement("delete from vehicle where v_id=?");  
	            ps.setInt(1,id);  
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(SQLException se){
	            //Handle errors for JDBC
	        	log.error(se.getMessage());
	 	        log.error("Connection failed");
	         }catch(Exception e){
	        	 log.error(e.getMessage());
		 	        log.error("Connection failed");
	        	 //Handle errors for Class.forName
	         }finally{
	            //finally block used to close resources
	            try{
	               if(con!=null)
	                  con.close();
	            }catch(SQLException se){
	            	log.error(se.getMessage());
		 	        log.error("Connection failed");
	            }//end finally try
	         }
	        return status;  
	    }  
	    public static vechiclepojo getVehicleById(int id) throws SQLException{  
	    	vechiclepojo e=new vechiclepojo();  
	    	
	    	Connection con=null;
	        try{  
	            con=DatabaseConnection.getConnection();  
	            PreparedStatement ps=con.prepareStatement("select * from vehicle where v_id=?");  
	            ps.setInt(1,id);  
	            ResultSet rs=ps.executeQuery();  
	            if(rs.next()){  
	                e.setId(rs.getInt(1));  
	                e.setName(rs.getString(2));  
	                e.setWheels(rs.getInt(3));  
	                e.setSeats(rs.getInt(4));  
	                e.setNumber_plate(rs.getString(5));  
	                e.setDateOfPurchase(rs.getDate(6));
	            }  
	            con.close();  
	        }catch(SQLException se){
	            //Handle errors for JDBC
	        	log.error(se.getMessage());
	 	        log.error("Connection failed");
	         }catch(Exception ex){
	        	 log.error(ex.getMessage());
		 	        log.error("Connection failed");
	        	 //Handle errors for Class.forName
	         }finally{
	            //finally block used to close resources
	            try{
	               if(con!=null)
	                  con.close();
	            }catch(SQLException se){
	            	log.error(se.getMessage());
		 	        log.error("Connection failed");
	            }//end finally try
	         }
	          
	        return e;  
	    }  
	    public static List<vechiclepojo> getAllVehicle() throws SQLException{  
	        List<vechiclepojo> list=new ArrayList<vechiclepojo>();  
	        Connection con=null;
	        try{  
	            con=DatabaseConnection.getConnection();  
	            PreparedStatement ps=con.prepareStatement("select * from vehicle");  
	            ResultSet rs=ps.executeQuery();  
	            while(rs.next()){  
//	            	System.out.println(rs.getInt(3));
//	            	java.sql.Timestamp ts = rs.getTimestamp("date_time");
//	            	System.out.println("Ts : "+ts);
//	            	java.sql.Date  date      = new java.sql.Date(ts.getTime());  
//	            	System.out.println("Date : "+date);
//	            	java.util.Date dd = new java.util.Date(date.getTime());
//	            	SimpleDateFormat sdf=new SimpleDateFormat("dd-mm-yy HH:mm:ss");
//	            	System.out.println("Date : "+sdf.format(dd));
	                vechiclepojo v=new vechiclepojo();
	                v.setId(rs.getInt(1));
	                v.setName(rs.getString(2));
	                v.setWheels(rs.getInt(3));
	                v.setSeats(rs.getInt(4));
	                v.setNumber_plate(rs.getString(5));
	                v.setDateOfPurchase(rs.getDate(6));
	                
	                list.add(v);  
//	                System.out.println("Connection failed");
	            }  
	            con.close();  
	        }catch(SQLException se){
	            //Handle errors for JDBC
	        	log.error(se.getMessage());
	 	        log.error("Connection failed");
	         }catch(Exception e){
	        	 log.error(e.getMessage());
		 	        log.error("Connection failed");
	        	 //Handle errors for Class.forName
	         }finally{
	            //finally block used to close resources
	            try{
	               if(con!=null)
	                  con.close();
	            }catch(SQLException se){
	            	log.error(se.getMessage());
		 	        log.error("Connection failed");
	            }//end finally try
	         }
	        return list;  
	    }  
}
