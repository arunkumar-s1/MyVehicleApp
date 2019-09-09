package com.servlet;

import java.io.IOException;  
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.beanclass.vechiclepojo;
import com.dao.vechicleDao;
import com.logger.Welcome;  
@WebServlet("/SaveVechicle")  
public class SaveVechicle extends HttpServlet {  
    /**
	 *  used to store the  vehicle values to the db
	 */
	static Logger log = Logger.getLogger(SaveVechicle.class);
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)   
         throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        RequestDispatcher rd=request.getRequestDispatcher("link.html");  
        rd.include(request, response);//method may be include or forward  
//        String id=request.getParameter("v_id"); 
//        int v_id = Integer.parseInt(id);
        int status=0;
		try {
			String name=request.getParameter("v_name");  
	        String wheels=request.getParameter("wheels");
	        int wheelsInt=Integer.parseInt(wheels);
	        String seats=request.getParameter("seats");
	        int seatsInt=Integer.parseInt(seats);
	        String number_plate=request.getParameter("number_plate");  
	        String date_of_purchase=request.getParameter("date_of_purchase");  
	        Date date_of_purchase1=new SimpleDateFormat("yyyy-MM-dd").parse(date_of_purchase);  
	        vechiclepojo v=new vechiclepojo();  
//	        v.setId(v_id);
	        v.setName(name);
	        v.setWheels(wheelsInt);
	        v.setSeats(seatsInt);
	        v.setNumber_plate(number_plate);
	        v.setDateOfPurchase(date_of_purchase1);
	        status = vechicleDao.save(v);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Save Vehicle: Connection failed");
		}  
        if(status>0){  
            out.print("<p>Record saved successfully!</p>");  
            request.getRequestDispatcher("AddVechicle.html").include(request, response);  
            out.print("<a href='ProfileServlet'>Back to Profile</a>");
//            out.print("<a href='ProfileServlet'>Back to Profile</a>");
        }else{  
            out.println("Sorry! unable to save record. Try giving differnt id");  
        }  
          
        out.close();  
    }  
  
}  
