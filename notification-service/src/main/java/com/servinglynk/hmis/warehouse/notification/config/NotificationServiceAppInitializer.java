package com.servinglynk.hmis.warehouse.notification.config;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
public class NotificationServiceAppInitializer implements WebApplicationInitializer {
	public void onStartup(ServletContext servletContext) throws ServletException {  
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();  
        ctx.register(NotificationServiceConfig.class);  
        servletContext.addListener(org.springframework.web.util.Log4jConfigListener.class);
        servletContext.setInitParameter("log4jConfigLocation","classpath:com/servinglynk/hmis/warehouse/notification/log4j.xml");
        
        
        ctx.setServletContext(servletContext);    
        Dynamic dynamic = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));  
        dynamic.addMapping("/rest/*");  
        dynamic.setLoadOnStartup(1);  
   }  
} 