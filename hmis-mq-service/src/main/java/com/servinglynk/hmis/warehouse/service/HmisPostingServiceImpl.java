package com.servinglynk.hmis.warehouse.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import com.servinglynk.hmis.warehouse.model.Client;
import com.servinglynk.hmis.warehouse.model.EnrollmentModel;
import com.servinglynk.hmis.warehouse.model.HmisPostingModel;
import com.servinglynk.hmis.warehouse.model.QuestionResponseModel;
import com.servinglynk.hmis.warehouse.model.SessionModel;

@Service
public class HmisPostingServiceImpl implements HmisPostingService {
	@Autowired RestTemplate restTemplate;
	
	@Override
	public void postHmis(HmisPostingModel hmisPostingModel, SessionModel session) {
			if(hmisPostingModel != null) {
				String hmisPostingStatus = hmisPostingModel.getHmisPostingStatus();
				if(StringUtils.isNotEmpty(hmisPostingStatus)) {
					HttpHeaders httpHeader = getHttpHeader(session.getClientId(), session.getSessionToken());
					if(StringUtils.equals("CREATE", hmisPostingStatus)) {
						createEnrollment(hmisPostingModel, httpHeader);
					}else {
						
					}
					
				}
			}
	}
	
	/***
	 * Get Global project by id
	 * @param globalProjectId
	 * @param headers
	 * @return
	 */
	private GlobalProjectModel getGlobalProjectById(UUID globalProjectId, HttpHeaders headers) {
		try {
			HttpEntity<Client> requestEntity = new HttpEntity<Client>(headers);
			ResponseEntity<GlobalProjectModel> responseEntity =	restTemplate.exchange("http://hmiselb.aws.hmislynk.com/hmis-globalapi/rest/globalprojects/"+globalProjectId, HttpMethod.GET,requestEntity, GlobalProjectModel.class);
			System.out.println("enrollment created "+responseEntity.getStatusCodeValue());
			return responseEntity.getBody();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}
	/***
	 * Get Version specific projectId to create the enrollment.
	 * If a version specific projectId does not exists, create one and return it.
	 * @param hmisPostingModel
	 * @param headers
	 * @return
	 */
	private UUID getVersionSpecificProjectId(HmisPostingModel hmisPostingModel, HttpHeaders headers) {
		GlobalProjectModel globalProjectById = getGlobalProjectById(hmisPostingModel.getGlobalProjectId(), headers);
		return null;
	}
	
	/***
	 * Create Enrollment for a version specific schema
	 * @param hmisPostingModel
	 * @param headers
	 * @param schemaYear
	 */
	private void createEnrollment(HmisPostingModel hmisPostingModel, HttpHeaders headers) {
		try {
			EnrollmentModel enrollmentModel = new EnrollmentModel();
			enrollmentModel.setClientId(hmisPostingModel.getClientId());
			LocalDateTime entryDate = hmisPostingModel.getEntryDate();
			if(entryDate != null) {
				Date entryUtilDate = Date.from(entryDate.atZone(ZoneId.systemDefault()).toInstant());
				enrollmentModel.setEntryDate(entryUtilDate);
			}
			enrollmentModel.setProjectId(getVersionSpecificProjectId(hmisPostingModel, headers));
			HttpEntity<EnrollmentModel> requestEntity = new HttpEntity<EnrollmentModel>(enrollmentModel,headers);
			ResponseEntity<EnrollmentModel> responseEntity = restTemplate.exchange("http://hmiselb.aws.hmislynk.com/hmis-clientapi-"+hmisPostingModel.getSchemaVersion()+"/rest/clients/"+hmisPostingModel.getClientId()+"/enrollments", HttpMethod.POST,requestEntity, EnrollmentModel.class);
			System.out.println("enrollment created "+responseEntity.getStatusCodeValue());
			
			List<QuestionResponseModel> questionResponses = hmisPostingModel.getQuestionResponses();
			if(!CollectionUtils.isEmpty(questionResponses)) {
			//	Collections.sort(questionResponses, new SortbyUriObject());
				Map<String,List<QuestionResponseModel>> questionResponseMap = new HashMap<>();
				for( QuestionResponseModel questionResponseModel : questionResponses) {
					System.out.println(questionResponseModel.getUriObjectField());
					List<QuestionResponseModel> list = questionResponseMap.get(questionResponseModel.getUriObjectField());
					if(!CollectionUtils.isEmpty(list)) {
						list.add(questionResponseModel);
						questionResponseMap.put(questionResponseModel.getUriObjectField(), list);
					} else {
						List<QuestionResponseModel>  questionResponseModels = new ArrayList<QuestionResponseModel>();
						questionResponseModels.add(questionResponseModel);
						questionResponseMap.put(questionResponseModel.getUriObjectField(), questionResponseModels);
					}
				}
			}
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
