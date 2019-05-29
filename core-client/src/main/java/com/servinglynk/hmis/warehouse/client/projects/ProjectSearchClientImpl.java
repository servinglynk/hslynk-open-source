package com.servinglynk.hmis.warehouse.client.projects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
import com.servinglynk.hmis.warehouse.core.model.JSONObjectMapper;

public class ProjectSearchClientImpl extends CoreClientBase implements ProjectSearchClient {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public BaseProject search(SearchRequest request) throws Exception {

		List<?> searchElements = new ArrayList<>();

		HttpHeaders headers = getHttpHeaders();
		headers.add("X-HMIS-TrustedApp-Id", request.getTrustedAppId());
		headers.add("Authorization", "HMISUserAuth session_token=" + request.getSessionToken());

		restTemplate = new RestTemplate();

		HttpEntity entity = new HttpEntity(headers);
		
		String schemaYear = (String) request.getSearchParams().get("schemayear");
		UUID projectId = (UUID) request.getSearchParams().get("projectId");
				
				

/*		StringBuffer URI = new StringBuffer(
				"http://hmiselb.aws.hmislynk.com/hmis-clientapi-v"+schemaYear+"/rest/projects/" + projectId);*/
		StringBuffer URI = new StringBuffer(
				"http://hmiselb.aws.hmislynk.com/hmis-clientapi-v"+schemaYear+"/rest/projects/" + projectId);
		
		ResponseEntity<String> response = restTemplate.exchange(URI.toString(), HttpMethod.GET, entity, String.class);
		
		
		System.out.println("response "+response.getBody());
	//	ResponseEntity<BaseProject> response = restTemplate.exchange(URI.toString(), HttpMethod.GET, entity, BaseProject.class);
		
		JSONObjectMapper objectMapper = new JSONObjectMapper();
		BaseProject proj = 	objectMapper.readValue(response.getBody(), BaseProject.class);

	//	System.out.println(proj.getProjectType());
/*		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = mapper.readTree(response.getBody());


			searchElements = mapper.readValue(response.getBody(),
					TypeFactory.defaultInstance().constructCollectionType(List.class, BaseProject.class));
*/
	//	return response.getBody();
		return proj;
	}
	
/*	public static void main(String args[]) throws Exception {
		Map<String,Object> searchParams = new HashMap<>();
		searchParams.put("schemayear", "2014");
		searchParams.put("projectId", UUID.fromString("9d278142-978d-461e-8aea-07d629e462e8"));
		SearchRequest searchRequest = new SearchRequest();
		searchRequest.setSearchParams(searchParams);
		searchRequest.setSessionToken("E80C77C9ECDA495EA60752D537528C408BF4C5F6E01443619CA5B42DB28657B9");
		searchRequest.setTrustedAppId("MASTER_TRUSTED_APP");
		ProjectSearchClientImpl impl = new ProjectSearchClientImpl();
		impl.search(searchRequest);
	}*/
}
