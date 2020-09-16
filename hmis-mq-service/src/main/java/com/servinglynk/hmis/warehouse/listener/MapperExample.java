package com.servinglynk.hmis.warehouse.listener;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.servinglynk.hmis.warehouse.model.HmisPostingsModel;
import com.servinglynk.hmis.warehouse.model.SessionModel;
import com.servinglynk.hmis.warehouse.service.HmisPostingServiceImpl;

public class MapperExample {
	
	public static void mapExample() throws JsonMappingException, JsonProcessingException {
		String hmisPosting = "{\"hmisPosting\":{\"globalProjectId\":\"25bd64a6-8f05-4a41-9d1a-3a64b7810956\",\"clientId\":\"480b8184-a429-4b68-8a1a-97c90e48f459\",\"dedupClientId\":\"ed2498a0-f8ad-11e9-a57b-02fe61f7863e\",\"surveyId\":\"8860fc8b-b127-4811-b458-0ee8840962a9\",\"surveyCategory\":\"1\",\"projectGroupCode\":\"TT0013\",\"userId\":\"19c0b1e8-de88-4a9a-a418-7da9aff2e593\",\"questionResponses\":[{\"questionText\":\"housingType\",\"responseText\":\"Site-based - clustered/multiple sites\",\"responseId\":\"0e2cbbf0-b432-465d-81a8-a75c615ee1ee\",\"updateUrlTemplate\":\"/v2020/projects/{projectid}/inventories/{inventoryid}\",\"uriObjectField\":\"inventory.housingType\"},{\"questionText\":\"State Health Insurance for Adults\",\"responseText\":\"No\",\"responseId\":\"6d437de6-6baf-4799-8cc9-abd1115c6edd\",\"updateUrlTemplate\":\"/v2020/clients/{clientid}/enrollments/{enrollmentid}/healthinsurances/{healthinsuranceid}\",\"uriObjectField\":\"healthInsurance.stateHealthInAdults\"},{\"questionText\":\"Physical Disability\",\"responseText\":\"No\",\"responseId\":\"a371a51c-f30b-43fc-a1c4-ee043e0e393e\",\"updateUrlTemplate\":\"/v2020/clients/{clientid}/enrollments/{enrollmentid}/disabilities/{disabilityid}\",\"uriObjectField\":\"disabilities.indefiniteandImpairs\"},{\"questionText\":\"Special Supplemental Nutrition Program for Women, Infants, and Children\",\"responseText\":\"No\",\"responseId\":\"3a037d7e-4a1a-4d2c-b91d-84b6600b2176\",\"updateUrlTemplate\":\"/v2020/clients/{clientid}/enrollments/{enrollmentid}/noncashbenefits/{noncashbenefitid}\",\"uriObjectField\":\"noncashbenefits.wic\"}]}}";
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        HmisPostingsModel hmisPostingsModel = mapper.readValue(hmisPosting, HmisPostingsModel.class);
        HmisPostingServiceImpl impl = new HmisPostingServiceImpl();
        SessionModel sessionModel = new SessionModel();
		sessionModel.setClientId("BF3CC2EA-7924-4CF6-AE93-7D9F0ED6B63E");
		sessionModel.setProjectGroupCode("TT0013");
		sessionModel.setSessionToken("HMISUserAuth session_token=C0655915EB0945769E407E430671641E5C9271CA5E054CDFA2804C004DE81044");
		
        impl.postHmis(hmisPostingsModel.getHmisPosting(), sessionModel);
        System.out.println("Working");
	}
	
	public static void main (String args[]) {
		String objectJson = good();
		String url = "http://localhost:8081/hmis-clientapi-v2020/rest/projects";
		makeAPICall(objectJson, getHttpHeader("BF3CC2EA-7924-4CF6-AE93-7D9F0ED6B63E", "HMISUserAuth session_token=51F8EFAA7F204C4294603F1C83DB24F1D80CE2E8151E4168BFAF0F997D21D134"), url, HttpMethod.POST);
	}
	
	public static Object makeAPICall(String objectJson,HttpHeaders headers, String url, HttpMethod httpMethod) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			HttpEntity<Object> requestEntity = new HttpEntity<Object>(objectJson,headers);
			ResponseEntity<Object> responseEntity =	restTemplate.exchange(url, httpMethod, requestEntity, Object.class);
			System.out.println("enrollment created "+responseEntity.getStatusCodeValue());
			return responseEntity.getBody();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}
	
	public static HttpHeaders getHttpHeader(String clientId, String sessionToken) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", "application/json");
		headers.add("Content-Type", "application/json; charset=UTF-8");
		headers.add("X-HMIS-TrustedApp-Id", clientId);
		headers.add("authorization","HMISUserAuth session_token="+sessionToken);
		MediaType mediaType = new MediaType("application", "json", Charset.forName("UTF-8"));
		headers.setContentType(mediaType);
		return headers;
	}

	
	
	public static String good() {
		Map<String, Object> map = new HashMap<>();
		map.put("projectName", "good");
		map.put("sourceSystemId", "sis");
		map.put("description","desc");
		map.put("projectCommonName", "commong");
		ObjectMapper objectMapper = new ObjectMapper();
				try {
			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		String writeValueAsString = objectMapper.writer().withRootName("project").writeValueAsString(map);
		System.out.println(writeValueAsString);
		return writeValueAsString;
		
	}catch(Exception e) {
		e.printStackTrace();
	}
				return null;
	}
}
