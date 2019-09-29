package com.servinglynk.hmis.warehouse.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.lang3.reflect.MethodUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;

import com.amazonaws.services.elastictranscoder.model.AccessDeniedException;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.servinglynk.hmis.warehouse.SortedPagination;
import com.servinglynk.hmis.warehouse.common.security.LoggedInUser;
import com.servinglynk.hmis.warehouse.core.model.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2015.HistoryEntityMapping;
import com.servinglynk.hmis.warehouse.service.HistoryService;
import com.servinglynk.hmis.warehouse.service.exception.ResourceNotFoundException;

public class HistoryServiceImpl extends ServiceBase implements HistoryService {

	@Transactional
	public String getEntityHistory(UUID entityId,String apiName,Integer startIndex, Integer maxItems) throws Exception {
		
		HistoryEntityMapping mapping = daoFactory.getHistoryDao().getMapping(apiName);
		if(mapping == null) throw new ResourceNotFoundException("History mapping not found");
		
		SecurityContext context =  SecurityContextHolder.getContext();
		Authentication authentication =  context.getAuthentication();
		LoggedInUser loggedInUser = null;
		if(authentication.getPrincipal()!=null){
			loggedInUser = (LoggedInUser) authentication.getPrincipal();
		}else {
			throw new AccessDeniedException("User authentication required");
		}

		
		List returnData = new ArrayList();
		List<?> data =	daoFactory.getHistoryDao().getEntityHistory(entityId, mapping.getEntityName(),loggedInUser.getProjectGroup(), startIndex, maxItems);
		long count =	daoFactory.getHistoryDao().getEntityHistoryCount(entityId, mapping.getEntityName(), "MO0010");

		for(Object entity : data) {
				returnData.add(MethodUtils.invokeExactStaticMethod(Class.forName(mapping.getConverterClass()), "entityToModel", ConvertUtils.convert(entity, Class.forName(mapping.getEntityName()))));
		}
		
		SortedPagination pagination = new SortedPagination();
		pagination.setFrom(0);
		pagination.setMaximum(30);
		pagination.setReturned(data.size());
		pagination.setTotal((int)count);
		
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		JsonNode rootNode = mapper.createObjectNode();
		ObjectNode paginationNode = mapper.valueToTree(pagination);
		ArrayNode array = mapper.valueToTree(returnData);
		((ObjectNode) rootNode).put("pagination",paginationNode);
		((ObjectNode) rootNode).put(mapping.getListName(), array);

		JsonNode result = mapper.createObjectNode().set(mapping.getListName(), rootNode);
		
		return mapper.writeValueAsString(result);
	}
	
	
	
	public static void main(String args[]) throws JsonProcessingException {
		
		List data = new ArrayList<>();
		Enrollment model = new Enrollment();
		model.setClientId(UUID.randomUUID());
		model.setContinuouslyhomelessoneyear(0);
		data.add(model);
		SortedPagination pagination = new SortedPagination();
		pagination.setFrom(0);
		pagination.setMaximum(30);
		pagination.setReturned(10);
		pagination.setTotal(20);
		
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		JsonNode rootNode = mapper.createObjectNode();
		ObjectNode paginationNode = mapper.valueToTree(pagination);
		ArrayNode array = mapper.valueToTree(data);
//		ArrayNode companyNode =  mapper.createArrayNode();
		((ObjectNode) rootNode).put("pagination",paginationNode);
		((ObjectNode) rootNode).put("entollments", array);


		JsonNode result = mapper.createObjectNode().set("enrollments", rootNode);
		

/*		JsonNode childNode1 = mapper.createObjectNode();
		((ObjectNode) childNode1).put("enrollments", data);
		((ObjectNode) childNode1).put("name2", "val2");

		((ObjectNode) rootNode).set("obj1", childNode1);

		JsonNode childNode2 = mapper.createObjectNode();
		((ObjectNode) childNode2).put("name3", "val3");
		((ObjectNode) childNode2).put("name4", "val4");

		((ObjectNode) rootNode).set("obj2", childNode2);

		JsonNode childNode3 = mapper.createObjectNode();
		((ObjectNode) childNode3).put("name5", "val5");
		((ObjectNode) childNode3).put("name6", "val6");

		((ObjectNode) rootNode).set("obj3", childNode3);*/


		String jsonString = mapper.writeValueAsString(result);
		System.out.println(jsonString);
	}
}