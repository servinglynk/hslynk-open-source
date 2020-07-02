package com.servinglynk.hmis.warehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

import com.servinglynk.hmis.warehouse.repository.RepositoryFactory;

public class BaseService {

		@Autowired protected RepositoryFactory repositoryFactory;
		
	//	@Autowired protected ElasticsearchTemplate template;
		
}
