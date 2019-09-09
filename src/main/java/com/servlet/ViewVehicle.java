package com.servlet;

import java.io.IOException;  
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.beanclass.vechiclepojo;
import com.dao.vechicleDao;
import com.google.gson.Gson;
import com.logger.Welcome;  
@WebServlet("/ViewVehicle")  
/**
* used to display the values in the web 
*/
public class ViewVehicle extends HttpServlet {  
	static Logger log = Logger.getLogger(ViewVehicle.class);
	private Gson gson = new Gson();
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
//		vechiclepojo employee = new vechiclepojo();
//		employee.setId(1);
    		doPost(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
//		response.setContentType("text/html");
        PrintWriter out=response.getWriter();  
        RequestDispatcher rd=request.getRequestDispatcher("link.html");  
        rd.include(request, response);//method may be include or forward  
        out.println("<a href='AddVechicle.html'></a>");  
        out.println("<a href='AddVechicle.html'>Add New Vehicle</a>");  
        out.println("<h1>Vehicle List</h1>");  
          
        List<vechiclepojo> list = null;
		try {
			list = vechicleDao.getAllVehicle();
//			String jsonText = JSONValue.toJSONString(list);  
//			out.print(jsonText);;
//			String employeeJsonString = this.gson.toJson(list);
//			 
//	        response.setContentType("application/json");
//	        response.setCharacterEncoding("UTF-8");
//	        out.print(employeeJsonString);
//	        out.flush();   
			if(list!=null) {
			  out.print("<table border='1' width='100%'");  
		        out.print("<tr><th>Id</th><th>Name</th><th><Wheels</th><th>Seats</th><th>Number plate</th><th>Year Of Purchase</th><th>Edit</th><th>Delete</th></tr>");  
		        for(vechiclepojo e:list){  
		         out.print("<tr><td>"+e.getId()+"</td>"
		        		 	+ "<td>"+e.getName()+"</td>"
		        		 			+ "<td>"+e.getWheels()+"</td>"
		        		 					+ "<td>"+e.getSeats()+"</td>"
		        		 							+ "<td>"+e.getNumber_plate()+"</td>"
		        		 									+ "<td>"+e.getDateOfPurchase()+"</td>"
//		                 +"<td>"+e.getEmail()+"</td><td>"+e.getCountry()+"</td>
//		        		 +"<td><a href='ViewAdd?id="+e.getId()+"'>View Advertisement</a></td>  "  
//		        		 +"<td><a href='AddAdvertisement.jsp?id="+e.getId()+"'>Add Advertisement</a></td>  "        		 							
		        		 +"<td><a href='UpdateVehicle1?id="+e.getId()+"'>Update</a></td>  "
		                 +"<td><a href='DeleteVehicle?id="+e.getId()+"'>delete</a></td></tr>");  
		        }  
		        out.print("</table><br><br>");
			}
			else {
				 out.print("Connection Problem occurs Try Again");
			}
		        out.print("<a href='ProfileServlet'>Back to Profile</a>");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			log.error("View Vehicle: Connection failed");
			
		}  
          
      
        out.close();  
    }  
}  
