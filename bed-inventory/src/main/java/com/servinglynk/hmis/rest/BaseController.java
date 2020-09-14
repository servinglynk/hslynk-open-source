package com.servinglynk.hmis.rest;

import org.springframework.beans.factory.annotation.Autowired;

import com.servinglynk.hmis.service.ServiceFactory;

public class BaseController {

	@Autowired protected ServiceFactory serviceFactory;
	
}
