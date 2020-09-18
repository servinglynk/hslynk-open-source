package com.servinglynk.hmis.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.servinglynk.hmis.dao.DaoFactory;

public class BaseService {
	
	@Autowired 
	protected DaoFactory daoFactory;
	
	@Autowired
	protected ValidationService validationService;

}
