package com.database.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource; 
/*
 * this class represent the database connection with oracle. 
 */
// This class can be used to initialize the database connection 
public class DatabaseConnection { 
    public static Connection getConnection() 
        throws SQLException, ClassNotFoundException 
    { 
        Connection con= null;
        try {
			Context context= new InitialContext();
			DataSource ds= (DataSource)context.lookup("java:comp/env/jdbc/myDb");
			con=ds.getConnection();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
//        Class.forName("oracle.jdbc.driver.OracleDriver");  
//        con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","password");  
        return con; 
    } 
} 
