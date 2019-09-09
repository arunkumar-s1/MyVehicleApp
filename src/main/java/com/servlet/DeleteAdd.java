package com.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.dao.AddDao;
import com.logger.Welcome;
/*
 * It reads the id from the user and delete the specific id from advertisement table
 */
@WebServlet("/DeleteAdd")  
public class DeleteAdd extends HttpServlet {  
    /**
	 * 
	 */
	static Logger log = Logger.getLogger(DeleteAdd.class);
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)   
             throws ServletException, IOException {  
        String id=request.getParameter("id");  
        int v_id=Integer.parseInt(id);  
        try {
			AddDao.delete(v_id);
		} catch (SQLException e) {
			log.error(e.getMessage());
			// TODO Auto-generated catch block
			
		}  
        response.sendRedirect("ViewAdd");  
    }  
}  