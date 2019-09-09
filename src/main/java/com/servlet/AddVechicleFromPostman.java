package com.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
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
@WebServlet("/AddVehicleFromPostman")
public class AddVechicleFromPostman extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(SaveVechicle.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddVechicleFromPostman() {
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
		JSONParser parser = new JSONParser();
		Reader reader = request.getReader();
//		String payloadRequest = getBody(request);
//		System.out.println(payloadRequest);
		Object jsonObj = null;
		try {
			jsonObj = parser.parse(reader);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JSONObject jsonObject = (JSONObject) jsonObj;
//		System.out.println(jsonObj);
		int status=0;
		try {
			String name = (String) jsonObject.get("name");
			String wheels = (String) jsonObject.get("wheels");
			int wheelsInt=Integer.parseInt(wheels);
			String seats = (String) jsonObject.get("seats");
			int seatsInt=Integer.parseInt(seats);
			String number_plate = (String) jsonObject.get("number_plate");
			String date_of_purchase = (String) jsonObject.get("dateOfPurchase");
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
			log.error(e.getMessage());
		}  
        if(status>0){  
            out.print("<p>Record saved successfully!</p>");  
            response.setStatus(HttpServletResponse.SC_OK);
        } else{  
            out.println("Sorry! unable to save record. Try giving differnt id");  
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }  
        out.flush();
	}
	}
