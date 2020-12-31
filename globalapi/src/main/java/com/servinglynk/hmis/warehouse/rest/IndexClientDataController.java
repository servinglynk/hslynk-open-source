package com.servinglynk.hmis.warehouse.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

import com.servinglynk.hmis.warehouse.base.dao.QueryExecutorImpl;

public class IndexClientDataController extends QueryExecutorImpl {
	

	

	public void indexClientData(@RequestParam("projectGroup") String projectGroup) {
		
	}
	
	public void indexEnrollmentsData(@RequestParam("projectGroup") String projectGroup, @RequestParam("schema") String schema) {
			
		String query = "select * from v2020.enrollment where deleted = false "
				+ "and client_id in (select id from v2020.client where deleted = false and parent_id is null)";
	
		List<Object> rs =	getCurrentSession().createSQLQuery(query).list();
		
		
		
		
	}
	
	
}
