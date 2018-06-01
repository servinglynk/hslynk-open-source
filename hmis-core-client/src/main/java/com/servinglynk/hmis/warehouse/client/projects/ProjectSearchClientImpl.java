package com.servinglynk.hmis.warehouse.client.projects;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.servinglynk.hmis.warehouse.client.base.CoreClientBase;
import com.servinglynk.hmis.warehouse.client.model.SearchRequest;
import com.servinglynk.hmis.warehouse.core.model.BaseProject;

public class ProjectSearchClientImpl extends CoreClientBase implements ProjectSearchClient {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<?> search(SearchRequest request) throws Exception {

		List<?> searchElements = new ArrayList<>();

		HttpHeaders headers = getHttpHeaders();
		headers.add("X-HMIS-TrustedApp-Id", request.getTrustedAppId());
		headers.add("Authorization", "HMISUserAuth session_token=" + request.getSessionToken());

		restTemplate = new RestTemplate();

		HttpEntity entity = new HttpEntity(headers);
		
		String schemaYear = (String) request.getSearchParams().get("schemayear");
		String projectId = (String) request.getSearchParams().get("projectId");
				
				

		StringBuffer URI = new StringBuffer(
				"http://hmiselb.aws.hmislynk.com/hmis-clientapi-v"+schemaYear+"/rest/projects/" + projectId);
		ResponseEntity<String> response = restTemplate.exchange(URI.toString(), HttpMethod.GET, entity, String.class);

		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = mapper.readTree(response.getBody());


			searchElements = mapper.readValue(root.get("searchResults").get("items").traverse(),
					TypeFactory.defaultInstance().constructCollectionType(List.class, BaseProject.class));

		return searchElements;
	}
}
