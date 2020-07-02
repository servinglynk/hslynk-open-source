package com.servinglynk.hmis.warehouse.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.servinglynk.hmis.warehouse.common.JsonUtil;
import com.servinglynk.hmis.warehouse.model.base.ClientMetaData;
import com.servinglynk.hmis.warehouse.repository.ClientMetaDataRepository;

@Component
public class ClientMetaDetaListener {
	
	//@Autowired ElasticsearchTemplate template;
	@Autowired ClientMetaDataRepository clientMetaDataRepository;
	
	@JmsListener(destination = "cache.cleint.metadtata")
	public void createMetaDeta(String eventData) {
		try {
			ClientMetaData entity = JsonUtil.getObjectMapper().readValue(eventData, ClientMetaData.class);
			clientMetaDataRepository.save(entity);
		
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

	}
	
}
