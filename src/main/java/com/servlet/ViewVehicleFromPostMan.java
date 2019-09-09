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
@WebServlet("/ViewVehicleFromPostman")  
/**
* used to display the values in the web 
*/
@SuppressWarnings("unchecked")
public class ViewVehicleFromPostMan extends HttpServlet {  
	static Logger log = Logger.getLogger(ViewVehicle.class);
	private Gson gson = new Gson();
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
    		doPost(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
        PrintWriter out=response.getWriter();  
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        List<vechiclepojo> list = null;
		try {
			list = vechicleDao.getAllVehicle();
//			String employeeJsonString = this.gson.toJson(list);
	        JSONArray jsArray = new JSONArray();
	        int i=0;
	        for(vechiclepojo e:list){ 
	        	JSONObject  jsObj = new JSONObject();
	        	jsObj.put("name", e.getName());
	        	jsObj.put("id", e.getId());
	        	jsObj.put("dateOfPurchase", e.getDateOfPurchase());
	        	jsObj.put("number_plate", e.getNumber_plate());
	        	jsObj.put("seats", e.getSeats());
	        	jsObj.put("wheels", e.getWheels());
	        	jsArray.add(jsObj);
	     	 }
	        response.setStatus(HttpServletResponse.SC_OK);
	        out.print(jsArray); 
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			log.error("View Vehicle: Connection failed");
			out.print("Data is not retrieved");
			 response.setStatus(HttpServletResponse.SC_BAD_GATEWAY);
			
		}  
        out.close();  
    }  
}  
