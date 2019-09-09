package com.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.beanclass.vechiclepojo;
import com.dao.vechicleDao;

/**
 * Servlet implementation class AddVechicleFromPostman
 */
@WebServlet("/DeleteVehicleFromPostman")
public class DeleteVehicleFromPostMan extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(SaveVechicle.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteVehicleFromPostMan() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	      doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();  
   	    response.setContentType("application/json");
   	    response.setCharacterEncoding("UTF-8");
	 	String id=request.getParameter("id");  
        int v_id=Integer.parseInt(id);  
        try {
			vechicleDao.delete(v_id);
			response.setStatus(HttpServletResponse.SC_OK);
			out.print("Deleted successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.error(e.getMessage());
			out.print("Not Deleted");
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}  
	}
	
}
