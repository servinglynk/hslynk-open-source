package com.servinglynk.hmis.warehouse.rest;

import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.servinglynk.hmis.warehouse.annotations.APIMapping;
import com.servinglynk.hmis.warehouse.core.model.Property;
import com.servinglynk.hmis.warehouse.service.core.PropertyReaderServiceImpl;

@RestController()
@RequestMapping("/properties")
public class PropertyController {
	
	@Autowired 
	PropertyReaderServiceImpl propertyReaderService;
	
	@RequestMapping(method=RequestMethod.PUT)
	@APIMapping(checkSessionToken=false,checkTrustedApp=false)
	public com.servinglynk.hmis.warehouse.core.model.Properties reloadProperties() throws Exception {
		
		com.servinglynk.hmis.warehouse.core.model.Properties list = new com.servinglynk.hmis.warehouse.core.model.Properties();
		
		Properties oldProperties =	propertyReaderService.getApplicationProperties();
		Properties newProperties = propertyReaderService.loadProperties("HMIS_USER_SERVICE");
		Set<String> props = new HashSet<String>();
		props.addAll(oldProperties.stringPropertyNames());
		props.addAll(newProperties.stringPropertyNames());
		for(String key: props){
			list.add(new Property(key, newProperties.getProperty(key), oldProperties.getProperty(key)));
		}
		return list;
	}
	
	
	@RequestMapping(method=RequestMethod.GET)
	@APIMapping(checkSessionToken=false,checkTrustedApp=false)
	public com.servinglynk.hmis.warehouse.core.model.Properties readProperties() throws Exception {
		
		com.servinglynk.hmis.warehouse.core.model.Properties list = new com.servinglynk.hmis.warehouse.core.model.Properties();
		
		Properties properties =	propertyReaderService.getApplicationProperties();
		
		for(String key: properties.stringPropertyNames()){
			list.add(new Property(key, properties.getProperty(key)));
		}
		return list;
	}	
}