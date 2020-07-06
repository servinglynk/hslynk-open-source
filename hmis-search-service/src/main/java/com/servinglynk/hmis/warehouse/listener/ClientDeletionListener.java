package com.servinglynk.hmis.warehouse.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.servinglynk.hmis.warehouse.common.JsonUtil;
import com.servinglynk.hmis.warehouse.model.base.Client;
import com.servinglynk.hmis.warehouse.repository.ClientElasticRepository;

@Component
public class ClientDeletionListener {
	
	@Autowired ClientElasticRepository clientElasticRepository;
	
	@JmsListener(destination = "delete.cached.base.cleint")
	public void cacheClient(String client) {
		try {
			System.out.println("cleint Data "+client);
	//	Client clientEntity = JsonUtil.getObjectMapper().readValue(client, Client.class);
	//	clientElasticRepository.findById(client);
			clientElasticRepository.deleteById(client);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
