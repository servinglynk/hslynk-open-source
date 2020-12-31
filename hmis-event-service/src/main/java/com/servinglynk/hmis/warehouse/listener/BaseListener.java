package com.servinglynk.hmis.warehouse.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.servinglynk.hmis.warehouse.service.ServiceFactory;

public class BaseListener {

	
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired protected ServiceFactory serviceFactory;
	
}
