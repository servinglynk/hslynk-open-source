package com.servinglynk.hmis.warehouse.base.dao;

import java.util.List;

public class HealthDaoImpl extends QueryExecutorImpl implements HealthDao {

	@Override
	public boolean checkConnectionHealth() {

		boolean flag=false;
		
		List result = getCurrentSession().createSQLQuery("select 1").list();
		
		if(!result.isEmpty()) flag = true;
		
		return flag;
	}

}
