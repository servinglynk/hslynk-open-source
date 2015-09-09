package com.servinglynk.hmis.warehouse.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.core.annotation.Order;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.servinglynk.hmis.warehouse.config.DatabaseConfig;

@Order(1)
public class Initializer extends
		AbstractAnnotationConfigDispatcherServletInitializer {

	 public void onStartup(ServletContext servletContext)
			   throws ServletException {
			  AnnotationConfigWebApplicationContext mvcContext = new AnnotationConfigWebApplicationContext();
			  mvcContext.register(WebAppConfig.class);
			 
			  ServletRegistration.Dynamic dispatcher = servletContext.addServlet(
			    "dispatcher1", new DispatcherServlet(mvcContext));
			  dispatcher.setLoadOnStartup(1);
			  dispatcher.addMapping("/app/*");
			 }
	 
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {DatabaseConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { WebAppConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}