package com.servinglynk.hmis.warehouse.report.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.servinglynk.hmis.warehouse.core.model.AHARModel;
import com.servinglynk.hmis.warehouse.report.persistence.dao.core.ParentDao;


public class AHARDao extends ParentDao implements IAHARDao {
	

	public List<String> getAHARReportData(AHARModel aharModel){
		
		// Test dao, to get the reoprt data from Postrgres DB
		DetachedCriteria query = null;
	
		/*
		DetachedCriteria query = DetachedCriteria.forClass(String.class);
		if(dfm.getLoadDate() != null) 	query.add(Restrictions.eq("loadDate", dfm.getLoadDate()));
		
		*/
		return (List<String>) findByCriteria(query,0,200);
	}
	
}
