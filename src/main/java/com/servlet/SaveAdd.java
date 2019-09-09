package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.beanclass.AddPojo;
import com.dao.AddDao;
import com.logger.Welcome;

/**
 * Servlet implementation class SaveAdd and used to store the values to db.
 */
@WebServlet("/SaveAdd")
public class SaveAdd extends HttpServlet {
	static Logger log = Logger.getLogger(SaveAdd.class);
//	 Logger log = Logger.getLogger(SaveAdd.class);
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 PrintWriter out=response.getWriter();  
		 RequestDispatcher rd=request.getRequestDispatcher("link.html");  
	        rd.include(request, response);//method may be include or forward  
//       String id=request.getParameter("v_id"); 
//       int v_id = Integer.parseInt(id);
       String name=request.getParameter("name");  
       String id=request.getParameter("id");
       int idInt=Integer.parseInt(id);
       String kilometer=request.getParameter("kilometer");
//       int seatsInt=Integer.parseInt(seats);
       String user_posted=request.getParameter("user_posted");  
       AddPojo a =new AddPojo();
//       v.setId(v_id);
       a.setName(name);
       a.setId(idInt);
       a.setKilometer(kilometer);
       a.setUser_posted(user_posted);
       int status=0;
	try {
		status = AddDao.save(a);
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		log.error("Cannot add Try again");
	}  
       if(status>0){  
    	   log.info("Successfully saved");
           out.print("<p>Record saved successfully!</p>");  
           request.getRequestDispatcher("AddAdvertisement.html").include(request, response);  
           out.print("<a href='ProfileServlet'>Back to Profile</a>");
//           out.print("<a href='ProfileServlet'>Back to Profile</a>");
       }else{  
           out.println("Sorry! unable to save record. Try giving differnt id");  
       }  
         
       out.close();  
	}

}
