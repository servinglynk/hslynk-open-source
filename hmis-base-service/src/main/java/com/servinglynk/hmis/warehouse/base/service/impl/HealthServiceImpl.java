package com.servinglynk.hmis.warehouse.base.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.base.service.HealthService;

public class HealthServiceImpl extends ServiceBase implements HealthService {

	@Transactional
	public boolean checkConnectionHealth() {
		return daoFactory.getHealthDao().checkConnectionHealth();
	}

}
