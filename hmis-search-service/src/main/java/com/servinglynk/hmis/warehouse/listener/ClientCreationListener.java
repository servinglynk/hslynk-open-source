package com.servinglynk.hmis.warehouse.listener;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.servinglynk.hmis.warehouse.common.JsonUtil;
import com.servinglynk.hmis.warehouse.model.base.Client;
import com.servinglynk.hmis.warehouse.repository.ClientElasticRepository;

@Component
public class ClientCreationListener {
	
	@Autowired ClientElasticRepository clientElasticRepository;
	
	@JmsListener(destination = "cache.base.cleint")
	public void cacheClient(String client) {
		try {
			System.out.println("cleint Data "+client);
		Client clientEntity = JsonUtil.getObjectMapper().readValue(client, Client.class);
		clientEntity.setFullname(StringUtils.join(clientEntity.getFirstname(),clientEntity.getMiddlename(),clientEntity.getLastname()));
		clientEntity.setName(StringUtils.join(clientEntity.getFirstname(),clientEntity.getLastname()));	
		if(clientEntity.getParentid()==null && !clientEntity.isDeleted() && clientEntity.getDedupclientid()!=null)
			clientElasticRepository.save(clientEntity);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
