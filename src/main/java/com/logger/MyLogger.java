package com.logger;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class MyLogger implements ServletContextListener {
	private static Logger log= Logger.getLogger(MyLogger.class);

	public void contextInitialized(ServletContextEvent event) {
		ServletContext context = event.getServletContext();
		String log4jConfigFile = context.getInitParameter("log4j-config-location");
		String fullPath = context.getRealPath("") + File.separator + log4jConfigFile;
		PropertyConfigurator.configure(fullPath);
		log.info("Log4j Configured");
//		InputStream in = getClass().getResourceAsStream("log4j.properties");
//		if(in!=null) {
//			PropertyConfigurator.configure(in);
//			log.info("Log4j Configured");
//		} else {
//			BasicConfigurator.configure();
//			log.info("Log4j Basic Configured");
//		}
		// TODO Auto-generated method stub
		
	}

	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

}
