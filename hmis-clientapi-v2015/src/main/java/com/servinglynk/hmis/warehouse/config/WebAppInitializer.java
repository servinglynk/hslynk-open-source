package com.servinglynk.hmis.warehouse.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.util.Log4jConfigListener;

public class WebAppInitializer implements WebApplicationInitializer  {

	
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		 AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();  
	        ctx.register(ClientAPIConfig.class);  
	        ctx.setServletContext(servletContext); 
	        ctx.setConfigLocation("classpath:log4j.properties");

	        servletContext.addListener(new Log4jConfigListener());
	        servletContext.addListener(new ContextLoaderListener(ctx));
	        
	        Dynamic dynamic = servletContext.addServlet("hmis-clientapi", new DispatcherServlet(ctx));  
	        dynamic.addMapping("/rest/*");  
	        dynamic.setLoadOnStartup(1);  
	}
}
