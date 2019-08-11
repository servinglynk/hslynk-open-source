package com.servinglynk.hmis.warehouse.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.servinglynk.hmis.warehouse.dao.DaoFactory;

public abstract class BaseService {

	@Autowired protected DaoFactory daoFactory;
}
