package com.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class Appinit implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext arg) throws ServletException {
		AnnotationConfigWebApplicationContext apc = new AnnotationConfigWebApplicationContext();
		//configuration class => Beans => viewResolver , dataSource , sessionFactor etc
		apc.register(AppConfig.class);
		arg.addServlet("dispatcherServlet", new DispatcherServlet()).addMapping("/");
		
	}

}
