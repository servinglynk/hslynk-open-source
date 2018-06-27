package com.servinglynk.hmis.warehouse.client.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
import com.servinglynk.hmis.warehouse.core.model.BaseClient;
import com.servinglynk.hmis.warehouse.core.model.BaseProject;

public class SearchServiceClient extends CoreClientBase implements ISearchServiceClient {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<?> search(SearchRequest request) throws Exception {

		List<?> searchElements = new ArrayList<>();

		HttpHeaders headers = getHttpHeaders();
		headers.add("X-HMIS-TrustedApp-Id", request.getTrustedAppId());
		headers.add("Authorization", "HMISUserAuth session_token=" + request.getSessionToken());

		restTemplate = new RestTemplate();

		HttpEntity entity = new HttpEntity(headers);
		StringBuffer URI = new StringBuffer();
/*		if (request.getSearchEntity().equalsIgnoreCase("projects")) {
		 URI = new StringBuffer(
				"http://hhmiselb.aws.hmislynk.com/hmis-clientapi-v2014/rest/searchall/" + request.getSearchEntity() + "?");
		for (Map.Entry<String, Object> entry : request.getSearchParams().entrySet()) {
			URI.append("&" + entry.getKey() + "=" + entry.getValue());
		}
		}else {
			 URI = new StringBuffer(
					"http://hmiselb.aws.hmislynk.com/hmis-clientapi-v2014/rest/searchall/" + request.getSearchEntity() + "?");
			for (Map.Entry<String, Object> entry : request.getSearchParams().entrySet()) {
				URI.append("&" + entry.getKey() + "=" + entry.getValue());
			}
		}*/
		
		String baseUrl = buildURL(getURL("client.search.url"), request.getSearchEntity());
		
		URI = new StringBuffer(
				baseUrl + "?");
		for (Map.Entry<String, Object> entry : request.getSearchParams().entrySet()) {
			URI.append("&" + entry.getKey() + "=" + entry.getValue());
		}
		
		ResponseEntity<String> response = restTemplate.exchange(URI.toString(), HttpMethod.GET, entity, String.class);

		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = mapper.readTree(response.getBody());

		if (request.getSearchEntity().equalsIgnoreCase("projects")) {
			searchElements = mapper.readValue(root.get("searchResults").get("items").traverse(),
					TypeFactory.defaultInstance().constructCollectionType(List.class, BaseProject.class));
		} else if (request.getSearchEntity().equalsIgnoreCase("clients")) {
			searchElements = mapper.readValue(root.get("searchResults").get("items").traverse(),
					TypeFactory.defaultInstance().constructCollectionType(List.class, BaseClient.class));
		}

		return searchElements;
	}

	/*
	 * public static void main(String args[]) throws Exception { try{
	 * SearchRequest request = new SearchRequest(); request.setSessionToken(
	 * "C67BB2C58F32440F8A9F610F01CC38555945DA2F97584620B3516E49C52CDF6C");
	 * request.setTrustedAppId("MASTER_TRUSTED_APP"); SearchServiceClient client
	 * = new SearchServiceClient(); request.addSearchParam("q",
	 * "67ee2c7a-ec03-421f-802d-d73e02c3924a"); List<BaseProject> projects =
	 * (List<BaseProject>) client.search(request);
	 * System.out.println(projects.size()); }catch (Exception e) {
	 * e.printStackTrace(); } }
	 */
}
