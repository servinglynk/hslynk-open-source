package com.servinglynk.hmis.warehouse.base.dao;

import com.servinglynk.hmis.warehouse.model.base.DeveloperCompanyStatus;

public class DeveloperCompanyStatusDaoImpl extends QueryExecutorImpl implements DeveloperCompanyStatusDao {

	@Override
	public DeveloperCompanyStatus create(DeveloperCompanyStatus developerCompanyStatus) {
			insert(developerCompanyStatus);
		return developerCompanyStatus;
	}

}
