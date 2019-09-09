package com.servlet;

import java.io.IOException;  
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.beanclass.AddPojo;
//import com.beanclass.vechiclepojo;
import com.dao.AddDao;
import com.logger.Welcome;
//import com.dao.vechicleDao;  
@WebServlet("/ViewAdd")  
public class ViewAdd extends HttpServlet {  
    /**
	 * used to display the values in the web 
	 */
	static Logger log = Logger.getLogger(ViewAdd.class);
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
//		request.getRequestDispatcher("link.html").forward(request, response);
		
		response.setContentType("text/html");
        PrintWriter out=response.getWriter();  
        RequestDispatcher rd=request.getRequestDispatcher("link.html");  
        rd.include(request, response);//method may be include or forward  
        out.println("<a href='AddAdvertisement.html'>Add New Advertisement</a>");  
        out.println("<h1>Add Advertisement</h1>");  
        String id=request.getParameter("id");  
//        System.out.println("View: "+id);
          
        List<AddPojo> list = null;
		try {
			list = AddDao.getAllAdd();
			   out.print("<table border='1' width='100%'");  
		        out.print("<tr><th>Id</th><th>Name</th><th>Kilometer</th><th>User Posted</th><th>Edit</th><th>Delete</th></tr>");  
		        for(AddPojo e:list){  
		         out.print("<tr><td>"+e.getId()+"</td>"
		        		 	+ "<td>"+e.getName()+"</td>"
		        		 			+ "<td>"+e.getKilometer()+"</td>"
		        		 					+ "<td>"+e.getUser_posted()+"</td>"
//		        		 							+ "<td>"+e.getNumber_plate()+"</td>"
//		                 +"<td>"+e.getEmail()+"</td><td>"+e.getCountry()+"</td>
		        		 +"<td><a href='UpdateAdd1?id="+e.getId()+"'>Update</a></td>  "
		                 +"<td><a href='DeleteAdd?id="+e.getId()+"'>delete</a></td></tr>");  
		        }  
		        out.print("</table><br><br>");  
		        out.print("<a href='ProfileServlet'>Back to Profile</a>");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			log.error("View Add: Connection failed");
		}  
          
     
        out.close();  
    }  
}  
