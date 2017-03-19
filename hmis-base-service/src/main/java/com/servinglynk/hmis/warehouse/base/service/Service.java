package com.servinglynk.hmis.warehouse.base.service;

import com.servinglynk.hmis.warehouse.base.service.core.BaseServiceFactory;

public interface Service {

	public BaseServiceFactory getParentServiceFactory() ;

	public void setParentServiceFactory(BaseServiceFactory serviceFactory) ;
}
