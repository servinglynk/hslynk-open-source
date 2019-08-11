package com.servinglynk.hmis.warehouse.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class WebAppInitializer  {

	
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		 AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();  
	        ctx.register(RestConfig.class);  
	      //  ctx.setServletContext(servletContext);    
	      /*  Dynamic dynamic = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));  
	        dynamic.addMapping("/rest/*");  
	        dynamic.setLoadOnStartup(1);  */
	}
}
