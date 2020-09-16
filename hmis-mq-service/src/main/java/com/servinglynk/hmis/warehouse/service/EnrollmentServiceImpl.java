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
	
	public void updateEnrollment(EnrollmentModel enrollment,SessionModel sessionModel,String schemaYear) {
		
		UUID geniricHousehold = enrollment.getGenericHouseHoldId();
		List<Client> clients  = daoFactory.getEnrollmentDao().getGenericHousehold(geniricHousehold, sessionModel.getProjectGroupCode(),schemaYear);
		for(Client client : clients) {
			HttpHeaders headers =  getHttpHeader(sessionModel.getClientId(), sessionModel.getSessionToken());
			if(client.getSchemaYear().equalsIgnoreCase(schemaYear)) {
				this.createEnrollment(schemaYear,client.getClientId(), enrollment, headers);
			}else {
				Client otherClient = this.getClient(client.getClientId(),headers,client.getSchemaYear());
				Client newClient = this.createClient(otherClient,headers,schemaYear);
				this.createEnrollment(schemaYear,newClient.getClientId(), enrollment, headers);
			}
		}
	}

	public void calCulateChronicHomelessness(SessionModel sessionModel,String schemaYear) {
			HttpHeaders headers =  getHttpHeader(sessionModel.getClientId(), sessionModel.getSessionToken());
			calCulateChronicHomelessness(schemaYear, sessionModel.getClientId(), sessionModel.getEnrollmentId(), headers);
	}
	
	
	private void calCulateChronicHomelessness(String schemaYear,String clientId, String enrollmentId, HttpHeaders headers) {
		JSONObjectMapper jsonObjectMapper = new JSONObjectMapper();
		try {
			HttpEntity<EnrollmentModel> requestEntity = new HttpEntity<EnrollmentModel>(null,headers);
			ResponseEntity<EnrollmentModel> responseEntity =	restTemplate.exchange("http://hmiselb.aws.hmislynk.com/hmis-clientapi-v"+schemaYear+"/rest/clients/"+clientId+"/enrollments/"+enrollmentId+"/calculatechronichomeless", HttpMethod.GET,requestEntity,EnrollmentModel.class);
			System.out.println("enrollment created "+responseEntity.getStatusCodeValue());
			System.out.println("enrollment created "+responseEntity.getBody().getEnrollmentId());
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	private Client createClient(Client otherClient, HttpHeaders headers, String schemaYear) {
		JSONObjectMapper jsonObjectMapper = new JSONObjectMapper();
		try {
			HttpEntity<Client> requestEntity = new HttpEntity<Client>(otherClient,headers);
			ResponseEntity<Client> responseEntity =	restTemplate.exchange("http://hmiselb.aws.hmislynk.com/hmis-clientapi-v"+schemaYear+"/rest/clients", HttpMethod.POST,requestEntity, Client.class);
			System.out.println("enrollment created "+responseEntity.getStatusCodeValue());
			return responseEntity.getBody();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	private Client getClient(UUID clientId, HttpHeaders headers, String schemaYear) {
		JSONObjectMapper jsonObjectMapper = new JSONObjectMapper();
		try {
			HttpEntity<Client> requestEntity = new HttpEntity<Client>(headers);
			ResponseEntity<Client> responseEntity =	restTemplate.exchange("http://hmiselb.aws.hmislynk.com/hmis-clientapi-v"+schemaYear+"/rest/clients/"+clientId, HttpMethod.GET,requestEntity, Client.class);
			System.out.println("enrollment created "+responseEntity.getStatusCodeValue());
			return responseEntity.getBody();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		// 
		return null;
	}


	public UUID createEnrollment(String schemaYear,UUID clientId,EnrollmentModel enrollmentModel,HttpHeaders headers) {
		JSONObjectMapper jsonObjectMapper = new JSONObjectMapper();
		try {
			HttpEntity<EnrollmentModel> requestEntity = new HttpEntity<EnrollmentModel>(enrollmentModel,headers);
			ResponseEntity<EnrollmentModel> responseEntity =	restTemplate.exchange("http://hmiselb.aws.hmislynk.com/hmis-clientapi-v"+schemaYear+"/rest/clients/"+clientId+"/enrollments?updateGenericHouseHold=false", HttpMethod.POST,requestEntity, EnrollmentModel.class);
			System.out.println("enrollment created "+responseEntity.getStatusCodeValue());
			System.out.println("enrollment created "+responseEntity.getBody().getEnrollmentId());
			return responseEntity.getBody().getEnrollmentId();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
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
