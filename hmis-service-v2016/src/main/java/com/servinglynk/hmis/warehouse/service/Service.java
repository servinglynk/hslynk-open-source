package com.servinglynk.hmis.warehouse.service;

import com.servinglynk.hmis.warehouse.service.core.ParentServiceFactory;

public interface Service {

	public ParentServiceFactory getParentServiceFactory() ;

	public void setParentServiceFactory(ParentServiceFactory serviceFactory) ;
}
