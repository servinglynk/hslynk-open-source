package com.servinglynk.hmis.warehouse.util;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Iterator;
import java.util.UUID;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.context.SecurityContext;

import com.servinglynk.hmis.warehouse.model.base.APIAccessEntity;


public class ClientOperationLogger {

	private static final Logger log = LoggerFactory.getLogger(ClientOperationLogger.class);
	
	@Autowired
	ApplicationContext applicationContext;
		
	@Async
	public void logClientOperation(Iterator entities) {
		while (entities.hasNext()) {
			Object object = (Object) entities.next();
			try {
				if((object.getClass().getName().equalsIgnoreCase("com.servinglynk.hmis.warehouse.model.v2014.Client")  
						|| object.getClass().getName().equalsIgnoreCase("com.servinglynk.hmis.warehouse.model.v2015.Client")
						|| object.getClass().getName().equalsIgnoreCase("com.servinglynk.hmis.warehouse.model.v2016.Client")
						)
						&&  BeanUtils.getNestedProperty(object, "deleted").equalsIgnoreCase("true")) {		
					
/*					String projectGroup="";
					String user="";
					Authentication authentication =  context.getAuthentication();
					if(authentication!=null && authentication.getPrincipal()!=null) {
						SessionEntity entity = (SessionEntity) authentication.getPrincipal();
						 projectGroup =  entity.getAccount().getProjectGroupEntity().getProjectGroupCode();
						 user = entity.getAccount().getUsername();
					}
*/					log.debug(object.getClass().getName() + ","+BeanUtils.getProperty(object,"id") +","+applicationContext.getApplicationName() +"," + BeanUtils.getNestedProperty(object, "userId") +","+BeanUtils.getNestedProperty(object, "projectGroupCode"));
				}
			} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}