package com.servinglynk.hmis.warehouse.service.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class BaseConverter implements IBaseConverter {

	 public static void copyBeanProperties(
		      final Object source,
		      final Object target){

		      final BeanWrapper src = new BeanWrapperImpl(source);
		      final BeanWrapper trg = new BeanWrapperImpl(target);
		      
		      List<String> properties = new ArrayList<String>();
		      properties.add("dateCreated");
		      properties.add("dateUpdated");
		      
		      for(final String propertyName : properties){
		          trg.setPropertyValue(
		              propertyName,
		              src.getPropertyValue(propertyName)
		          );
		      }

		  }
}