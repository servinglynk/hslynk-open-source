package com.servinglynk.hmis.warehouse.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.servinglynk.hmis.warehouse.model.Client;
import com.servinglynk.hmis.warehouse.model.EnrollmentModel;
import com.servinglynk.hmis.warehouse.model.JSONObjectMapper;
import com.servinglynk.hmis.warehouse.model.SessionModel;

@Service
public class EnrollmentServiceImpl extends BaseService implements EnrollmentService {

	
	@Autowired RestTemplate restTemplate;
	
	@Override
	public void updateEnrollment(EnrollmentModel enrollment,SessionModel sessionModel,String schemaYear) {
		
		UUID geniricHousehold = enrollment.getGenericHouseHoldId();
		List<Client> clients  = daoFactory.getEnrollmentDao().getGenericHousehold(geniricHousehold, sessionModel.getProjectGroupCode(),schemaYear);
		for(Client client : clients) {
			HttpHeaders headers =  getHttpHeader(sessionModel.getClientId(), sessionModel.getSessionToken());
			this.createEnrollment(schemaYear,client.getClientId(), enrollment, headers);
		}
	}

	
	public void createEnrollment(String schemaYear,UUID clientId,EnrollmentModel enrollmentModel,HttpHeaders headers) {
		JSONObjectMapper jsonObjectMapper = new JSONObjectMapper();
		try {
			HttpEntity<EnrollmentModel> requestEntity = new HttpEntity<EnrollmentModel>(enrollmentModel,headers);
			ResponseEntity<EnrollmentModel> responseEntity =	restTemplate.exchange("http://hmiselb.aws.hmislynk.com/hmis-clientapi-v"+schemaYear+"/rest/clients/"+clientId+"/enrollments?updateGenericHouseHold=false", HttpMethod.POST,requestEntity, EnrollmentModel.class);
			System.out.println("enrollment created "+responseEntity.getStatusCodeValue());
			System.out.println("enrollment created "+responseEntity.getBody().getEnrollmentId());
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
	public HttpHeaders getHttpHeader(String clientId, String sessionToken) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", "application/json");
		headers.add("Content-Type", "application/json; charset=UTF-8");
		headers.add("X-HMIS-TrustedApp-Id", clientId);
		headers.add("Authorization","HMISUserAuth session_token="+sessionToken);
		return headers;
	}
	
}
