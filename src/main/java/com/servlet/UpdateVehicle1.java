package com.servlet;

import java.io.IOException;  
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.beanclass.vechiclepojo;
import com.dao.vechicleDao;
import com.logger.Welcome;  
@WebServlet("/UpdateVehicle1")  
public class UpdateVehicle1 extends HttpServlet {  
	static Logger log = Logger.getLogger(UpdateVehicle1.class);
	/*
	 * used to get the values from the user and sent the data to updateVehicle2
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)   
           throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<h1>Update Vehicle</h1>");  
        String id=request.getParameter("id");  
        int v_id=Integer.parseInt(id);  
          
        vechiclepojo e = null;
		try {
				e = vechicleDao.getVehicleById(v_id);
				if(e.getId()!=0) {
			  out.print("<form action='UpdateVehicle2' method='post'>");  
			  
			  
		        out.print("<table>");  
		        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+e.getId()+"'/></td></tr>");  
		        out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+e.getName()+"'/></td></tr>");  
		        out.print("<tr><td>Number of Wheels:</td><td><input type='number' name='wheels' value='"+e.getWheels()+"'/></td></tr>");  
		        out.print("<tr><td>Number of Seats:</td><td><input type='number' name='seats' value='"+e.getSeats()+"'/></td></tr>");  
		        out.print("<tr><td>Number Plate:</td><td><input type='text' name='number_plate' value='"+e.getNumber_plate()+"'/></td></tr>"); 
		        out.print("<tr><td>Date Of Purchase:</td><td><input type='text' name='date_of_purchase' value='"+e.getDateOfPurchase()+"'/></td></tr>"); 
//		        out.print("<tr><td>Country:</td><td>");  
//		        out.print("<select name='country' style='width:150px'>");  
//		        out.print("<option>India</option>");  
//		        out.print("<option>USA</option>");  
//		        out.print("<option>UK</option>");  
//		        out.print("<option>Other</option>");  
//		        out.print("</select>");  
//		        out.print("</td></tr>");  
		        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
		        out.print("</table>");  
		        out.print("</form>");
				}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			log.error("Update Vehicle1: Connection failed");
		}  
          
       
          
        out.close();  
    }  
}  