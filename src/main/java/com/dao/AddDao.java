package com.dao;
import java.util.*;

import org.apache.log4j.Logger;

import com.beanclass.AddPojo;
//import com.beanclass.vechiclepojo;
import com.database.connection.DatabaseConnection;
import com.logger.Welcome;

import java.sql.*;
/*
 * this class represent the database operation(CRUD) for advertisement 
 */
public class AddDao {
	static Logger log = Logger.getLogger(AddDao.class);
	    public static int save(AddPojo a) throws SQLException{  
	        int status=0;  
	        Connection con=null;
	        try{  
	            con=DatabaseConnection.getConnection();  
	            PreparedStatement ps=con.prepareStatement(  
	                         "insert into advertisement values (?,?,?,?)");  
//	            ps.setInt(1, v.getId());
	            ps.setString(1,a.getName()); 
	            ps.setInt(2, a.getId());
	            ps.setString(3, a.getKilometer());
	            ps.setString(4, a.getUser_posted());
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
	    public static int update(AddPojo e) throws SQLException{  
	        int status=0;  
	        Connection con=null;
	        try{  
	            con=DatabaseConnection.getConnection();  
	            PreparedStatement ps=con.prepareStatement(  
	                         "update advertisement set name=?,kilometer=?,user_posted=? where id=?");  
	            ps.setString(1,e.getName());  
	            ps.setString(2,e.getKilometer());  
	            ps.setString(3,e.getUser_posted());  
//	            ps.setInt(4,e.getNumber_plate());  
	            ps.setInt(4,e.getId());  
	              
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
	            PreparedStatement ps=con.prepareStatement("delete from advertisement where id=?");  
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
	    public static AddPojo getAddById(int id) throws SQLException{  
	    	AddPojo e=new AddPojo();  
	    	Connection con=null;
	          
	        try{  
	            con=DatabaseConnection.getConnection();  
	            PreparedStatement ps=con.prepareStatement("select * from advertisement where id=?");  
	            ps.setInt(1,id);  
//	            System.out.println(id);
	            ResultSet rs=ps.executeQuery();  
	            if(rs.next()){  
	                e.setId(rs.getInt(2));  
	                e.setName(rs.getString(1));  
	                e.setKilometer(rs.getString(3));  
	                e.setUser_posted((rs.getString(4)));  
	                
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
	    public static List<AddPojo> getAllAdd() throws SQLException{  
	        List<AddPojo> list=new ArrayList<AddPojo>();  
	        Connection con=null;
	          
	        try{  
	            con=DatabaseConnection.getConnection();  
	            PreparedStatement ps=con.prepareStatement ("select * from advertisement");
	            ResultSet rs=ps.executeQuery();  
	            while(rs.next()){  
//	            	System.out.println(rs.getString(3));
	                AddPojo v=new AddPojo();  
	                v.setName(rs.getString(1));
	                v.setId(rs.getInt(2));
	                v.setKilometer((rs.getString(3)));
	                v.setUser_posted((rs.getString(4)));
	                list.add(v);  
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
