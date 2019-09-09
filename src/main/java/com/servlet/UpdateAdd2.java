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

import com.beanclass.AddPojo;
import com.dao.AddDao;
import com.logger.Welcome;
@WebServlet("/UpdateAdd2")  
public class UpdateAdd2 extends HttpServlet {  
    /**
	 * get the values and update in the db 
	 */
	static Logger log = Logger.getLogger(UpdateAdd2.class);
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)   
          throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String id=request.getParameter("id");  
        int v_id=Integer.parseInt(id);  
        String name=request.getParameter("name"); 
//        System.out.println("update 2"+ name);
        String kilometer=request.getParameter("kilometer");  
//        int wheelsInt=Integer.parseInt(wheels);  
        String user_posted=request.getParameter("user_posted");
//        int seatsInt =Integer.parseInt(seats);  
//        String number_plate=request.getParameter("number_plate");  
          
        AddPojo e=new AddPojo();  
        e.setId(v_id);  
        e.setName(name);  
        e.setKilometer(kilometer);
        e.setUser_posted(user_posted);
//        e.setNumber_plate(number_plate);  
          
        int status=0;
		try {
			status = AddDao.update(e);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			log.error("Update Add2: Connection failed");
		}  
        if(status>0){  
        	log.info("Updated successfully");
            response.sendRedirect("ViewAdd");  
        }else{  
            out.println("Sorry! unable to update record");  
        }  
          
        out.close();  
    }  
  
}  