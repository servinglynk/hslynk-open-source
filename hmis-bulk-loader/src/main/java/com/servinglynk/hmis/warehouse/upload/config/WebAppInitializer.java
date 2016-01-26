package com.servinglynk.hmis.warehouse.upload.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {
		 AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();  
	        ctx.register(AppConfig.class);  
	        ctx.setServletContext(servletContext);    
	        Dynamic dynamic = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));  
	        dynamic.addMapping("/");  
	        dynamic.setLoadOnStartup(1);  

	}
}
