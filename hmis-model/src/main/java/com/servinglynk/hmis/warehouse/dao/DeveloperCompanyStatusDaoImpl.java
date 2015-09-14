package com.servinglynk.hmis.warehouse.dao;

import com.servinglynk.hmis.warehouse.model.live.DeveloperCompanyStatus;

public class DeveloperCompanyStatusDaoImpl extends QueryExecutorImpl implements DeveloperCompanyStatusDao {

	@Override
	public DeveloperCompanyStatus create(DeveloperCompanyStatus developerCompanyStatus) {
			insert(developerCompanyStatus);
		return developerCompanyStatus;
	}

}
