package com.servinglynk.hmis.warehouse.listener;

import org.springframework.beans.factory.annotation.Autowired;

import com.servinglynk.hmis.warehouse.service.ServiceFactory;

public class BaseListener {

	@Autowired protected ServiceFactory serviceFactory;
	
}
