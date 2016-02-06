package com.servinglynk.hmis.warehouse.service.core;

import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.dao.PropertyDao;
import com.servinglynk.hmis.warehouse.model.live.PropertyEntity;

public class PropertyReaderServiceImpl {

	@Autowired
	PropertyDao propertyDao;
	
	@Autowired
	Environment env;
	
	
	
	@Transactional
	public Properties readProperties(String serviceName){
		Properties properties = new Properties();
		List<PropertyEntity> entities =   propertyDao.readCommonProperties();
		for(PropertyEntity propertyEntity : entities){
			if (propertyEntity.getValue()!=null){
				properties.put(propertyEntity.getKeyName(), propertyEntity.getValue());
			}else{
				properties.put(propertyEntity.getKeyName(),"");
			}
		}
		
		entities =   propertyDao.readProperties(serviceName);
		for(PropertyEntity propertyEntity : entities){
			if (propertyEntity.getValue()!=null){
				// replacing existing property value with service specific value (if exists otherwise creates new property)
				properties.setProperty(propertyEntity.getKeyName(), propertyEntity.getValue());  
			}else{
				properties.setProperty(propertyEntity.getKeyName(),"");
			}
		}
		
		return properties;
		
	}
	
	@SuppressWarnings("unchecked")
	public Properties getApplicationProperties(){
			MutablePropertySources propertySources = ((ConfigurableEnvironment) env).getPropertySources();
		  PropertySource<Properties>  prop = (PropertySource<Properties>) propertySources.get("dbPropertySource");
		  Properties props = prop.getSource();
		return props;
	}
	
	// Method to read Properties from Application server (from env Object)
	
	@Transactional
	public Properties loadProperties(String serviceName){
		 // 1. Display currently loaded properties from Application Server (env object)
		 // 2. Load properties from Database 
		 MutablePropertySources propertySources = ((ConfigurableEnvironment) env).getPropertySources();
		  Properties properties = this.readProperties(serviceName);
		  System.out.println("Data base properties "+properties.toString());
		  PropertiesPropertySource dbPropertySource = new PropertiesPropertySource("dbPropertySource", properties);
		  propertySources.addFirst(dbPropertySource);
		 // 3. Display currently loaded properties from Application Server (env object)
		  return properties;
	}
	
}
