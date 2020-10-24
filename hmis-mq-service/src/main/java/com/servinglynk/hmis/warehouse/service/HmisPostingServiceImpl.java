package com.servinglynk.hmis.warehouse.service;

import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.servinglynk.hmis.warehouse.model.Client;
import com.servinglynk.hmis.warehouse.model.ClientSurveySubmission;
import com.servinglynk.hmis.warehouse.model.ClientSurveySubmissions;
import com.servinglynk.hmis.warehouse.model.EnrollmentModel;
import com.servinglynk.hmis.warehouse.model.EnrollmentsModel;
import com.servinglynk.hmis.warehouse.model.GlobalEnrollments;
import com.servinglynk.hmis.warehouse.model.GlobalProjectMap;
import com.servinglynk.hmis.warehouse.model.GlobalProjectModel;
import com.servinglynk.hmis.warehouse.model.GlobalProjectsMap;
import com.servinglynk.hmis.warehouse.model.HmisPostingModel;
import com.servinglynk.hmis.warehouse.model.QuestionResponseModel;
import com.servinglynk.hmis.warehouse.model.SessionModel;

@Service
public class HmisPostingServiceImpl implements HmisPostingService {
	protected final Log logger = LogFactory.getLog(getClass());
	private static final String HMIS_HOST ="http://hmiselb.aws.hmislynk.com";
	//private static final String HMIS_HOST ="http://localhost:8081";
	//private static final String CES_HOST = "http://localhost:8081";

	private static final String CES_HOST = "http://ceselb.aws.hmislynk.com";
	@Autowired RestTemplate restTemplate;
	@Autowired protected ServiceFactory serviceFactory;
	
	@Override
	public void postHmis(HmisPostingModel hmisPostingModel, SessionModel session) {
			if(hmisPostingModel != null) {
				UUID enrollmentId = null;
				String hmisPostingStatus = hmisPostingModel.getHmisPostingStatus();
					HttpHeaders httpHeader = getHttpHeader(session.getTrustedAppId(), session.getSessionToken());
					if(StringUtils.equals("CREATE", hmisPostingStatus) && hmisPostingModel.getGlobalEnrollmentId() == null && StringUtils.equals("1", hmisPostingModel.getSurveyCategory())) {
						enrollmentId = createEnrollment(hmisPostingModel, httpHeader);
					} else {
						String enrollmentAtEntry = getEnrollmentFromSurveySubmissionByClientId(hmisPostingModel, httpHeader);
						if(enrollmentAtEntry != null) {
							enrollmentId = UUID.fromString(enrollmentAtEntry);
						}
							//enrollmentId = getVersionSpecificEnrollmentId(hmisPostingModel, httpHeader);
						if(enrollmentId == null ) {
								// Create a version specific enrollment if one does not exists from the global household
							enrollmentId = createEnrollment(hmisPostingModel, httpHeader);
						 }
					}
					String hmisLink  = "/hmis-clientapi/rest/"+hmisPostingModel.getSchemaVersion()+"/clients/"+hmisPostingModel.getClientId()+"/enrollments/"+enrollmentId;
					postQuestionsToHmis(hmisPostingModel, httpHeader, enrollmentId, null);
					postAssessmentQuestions(hmisPostingModel, httpHeader, enrollmentId);
					updateClientSurveySubmission(hmisPostingModel, httpHeader, hmisLink, HttpMethod.PUT,enrollmentId);
			}
	}
	
	/***
	 * Get Global project by id
	 * @param globalProjectId
	 * @param headers
	 * @return
	 */
	private String getEnrollmentFromSurveySubmissionByClientId(HmisPostingModel hmisPostingModel, HttpHeaders headers) {
		String enrollmentId = null;
		try {
			HttpEntity<Client> requestEntity = new HttpEntity<Client>(headers);
			ResponseEntity<ClientSurveySubmissions> responseEntity =	restTemplate.exchange(CES_HOST+"/survey-api/rest/clientsurveysubmissions?q="+hmisPostingModel.getClientId(), HttpMethod.GET,requestEntity, ClientSurveySubmissions.class);
			logger.info("Get Survey Submission "+responseEntity.getStatusCodeValue());
			ClientSurveySubmissions clientSurveySubmissions = responseEntity.getBody();
			if(clientSurveySubmissions != null) {
				List<ClientSurveySubmission> clientSurveySubmissionsList = clientSurveySubmissions.getClientSurveySubmissions();
				if(!CollectionUtils.isEmpty(clientSurveySubmissionsList)) {
					for(ClientSurveySubmission clientSurveySubmission : clientSurveySubmissionsList) {
						if(StringUtils.equals("1", clientSurveySubmission.getSurveyCategory()) && StringUtils.equals("DONE", clientSurveySubmission.getHmisPostingStatus())
						  &&  hmisPostingModel.getSurveyId() == clientSurveySubmission.getSurveyId()) {
							if(clientSurveySubmission.getGlobalEnrollmentId() != null) {
								enrollmentId = String.valueOf(clientSurveySubmission.getGlobalEnrollmentId());
								break;
							}
							String hmisLink = clientSurveySubmission.getHmisLink();
							if(StringUtils.isNotBlank(hmisLink)) {
								String[] split = StringUtils.split("/");
								enrollmentId = split[split.length-1];
								break;
							}
						}
					}
				}
			}
		} catch (Exception e) {
			logger.error(" Error when getGlobalProjectById is called", e.getCause());
		} 
		return enrollmentId;
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
			ResponseEntity<GlobalProjectModel> responseEntity =	restTemplate.exchange(HMIS_HOST+"/hmis-globalapi/rest/globalprojects/"+globalProjectId, HttpMethod.GET,requestEntity, GlobalProjectModel.class);
			logger.info("Project created "+responseEntity.getStatusCodeValue());
			return responseEntity.getBody();
		} catch (Exception e) {
			logger.error(" Error when getGlobalProjectById is called", e.getCause());
		} 
		return null;
	}
	/***
	 * Get Global project by id
	 * @param globalProjectId
	 * @param headers
	 * @return
	 */
	private GlobalEnrollments getGlobalEnrollmentByDedupClientId(UUID dedupClientId, HttpHeaders headers) {
		try {
			HttpEntity<Client> requestEntity = new HttpEntity<Client>(headers);
			ResponseEntity<GlobalEnrollments> responseEntity =	restTemplate.exchange(HMIS_HOST+"/hmis-globalapi/rest/clients/"+dedupClientId+"/globalenrollments", HttpMethod.GET,requestEntity, GlobalEnrollments.class);
			logger.info("Project created "+responseEntity.getStatusCodeValue());
			return responseEntity.getBody();
		} catch (Exception e) {
			logger.error(" Error when getGlobalEnrollmentById is called", e.getCause());
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
		if(globalProjectById != null) {
			String schemaVersion = hmisPostingModel.getSchemaVersion();
			schemaVersion = StringUtils.substring(schemaVersion,1);
			GlobalProjectsMap projectsMap = globalProjectById.getProjects();
			if(projectsMap != null) {
				List<GlobalProjectMap> globalProjectMaps = projectsMap.getGlobalProjectMaps();
				if(!CollectionUtils.isEmpty(globalProjectMaps)) {
					for(GlobalProjectMap globalProjectMap : globalProjectMaps) {
							if(StringUtils.equals(schemaVersion, globalProjectMap.getSource())) {
								return globalProjectMap.getProjectId();
							}
					}
				}
			}
			return createVersionSpecificProject(globalProjectById, headers, hmisPostingModel);
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
	private UUID getEnrollmentAtEntry(HmisPostingModel hmisPostingModel, HttpHeaders headers) {
		GlobalProjectModel globalProjectById = getGlobalProjectById(hmisPostingModel.getGlobalProjectId(), headers);
		String schemaVersion = hmisPostingModel.getSchemaVersion();
		schemaVersion = StringUtils.substring(schemaVersion,1);
		GlobalProjectsMap projectsMap = globalProjectById.getProjects();
		if(projectsMap != null) {
			List<GlobalProjectMap> globalProjectMaps = projectsMap.getGlobalProjectMaps();
			if(!CollectionUtils.isEmpty(globalProjectMaps)) {
				for(GlobalProjectMap globalProjectMap : globalProjectMaps) {
						if(StringUtils.equals(schemaVersion, globalProjectMap.getSource())) {
							return globalProjectMap.getProjectId();
						}
				}
			}
		}
		return createVersionSpecificProject(globalProjectById, headers, hmisPostingModel);
	}
	/***
	 * Get Version specific projectId to create the enrollment.
	 * If a version specific projectId does not exists, create one and return it.
	 * @param hmisPostingModel
	 * @param headers
	 * @return
	 */
	private UUID getVersionSpecificEnrollmentId(HmisPostingModel hmisPostingModel, HttpHeaders headers) {
		try {
			UUID projectId = getVersionSpecificProjectId(hmisPostingModel, headers);
			HttpEntity<Client> requestEntity = new HttpEntity<Client>(headers);
			String url = HMIS_HOST+"/hmis-clientapi-"+hmisPostingModel.getSchemaVersion()+"/rest/clients/"+hmisPostingModel.getClientId()+"/enrollments";
			ResponseEntity<EnrollmentsModel> responseEntity = restTemplate.exchange(url, HttpMethod.GET,requestEntity, EnrollmentsModel.class);
			EnrollmentsModel enrollmentsModel = responseEntity.getBody();
			if(enrollmentsModel != null) {
				List<EnrollmentModel> enrollments = enrollmentsModel.getEnrollments();
				if(!CollectionUtils.isEmpty(enrollments)) {
					for(EnrollmentModel model : enrollments) {
						if(projectId == model.getProjectId()) {
							return model.getEnrollmentId();
						}
					}
				}
			}
		} catch (Exception e) {
			logger.error(" Error when getVersionSpecificEnrollmentId is called", e.getCause());
		}
		return null;
	}

	/****
	 * Create a version specific project from the gloabl project id
	 * @param globalProjectById
	 * @param headers
	 * @param hmisPostingModel
	 * @return
	 */
	private UUID createVersionSpecificProject(GlobalProjectModel globalProjectById, HttpHeaders headers,
			HmisPostingModel hmisPostingModel) {
		Map<String, Object> map = new HashMap<>();
		map.put("projectName", globalProjectById.getProjectName());
		map.put("sourceSystemId", globalProjectById.getSourceSystemId());
		map.put("description", globalProjectById.getDescription());
		map.put("projectCommonName", globalProjectById.getProjectCommonName());
		ObjectMapper objectMapper = new ObjectMapper();
				try {
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		String jsonObj = objectMapper.writer().withRootName("project").writeValueAsString(map);
		String url = HMIS_HOST+"/hmis-clientapi-"+hmisPostingModel.getSchemaVersion()+"/rest/projects";
		//
		 Object responseObject = makeAPICall(jsonObj, headers, url, HttpMethod.POST);
        LinkedHashMap<Object, Map> persons = (LinkedHashMap<Object, Map>) responseObject;
        Set<Entry<Object, Map>> entrySet = persons.entrySet();
        Entry<Object, Map> next = entrySet.iterator().next();
        logger.info("key:"+next.getKey() + " value:"+next.getValue());
        
        Map value = next.getValue();
		return UUID.fromString((String)value.get("projectId"));
		} catch (JsonMappingException e) {
			logger.error(" Error when createVersionSpecificProject is called", e.getCause());
		} catch (JsonProcessingException e) {
			logger.error(" Error when createVersionSpecificProject is called", e.getCause());
		}
		return null;
	}

	
	/****
	 * Create a version specific project from the gloabl project id
	 * @param globalProjectById
	 * @param headers
	 * @param hmisPostingModel
	 * @return
	 */
	private UUID createAssessment(HttpHeaders headers, HmisPostingModel hmisPostingModel, UUID enrollmentId) {
		Map<String, Object> map = new HashMap<>();
		map.put("assessmentType", "1");
		map.put("assessmentLevel", "1");
		ObjectMapper objectMapper = new ObjectMapper();
				try {
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		String jsonObj = objectMapper.writer().withRootName("assessment").writeValueAsString(map);
		String requestPath = hmisPostingModel.getSchemaVersion()+"/rest/clients/{clientid}/enrollments/{enrollmentid}/assessments";
		//
		String url = getAssessmentUrl(requestPath, hmisPostingModel.getClientId(), enrollmentId, null, null);
		 Object responseObject = makeAPICall(jsonObj, headers, url, HttpMethod.POST);
        LinkedHashMap<Object, Map> persons = (LinkedHashMap<Object, Map>) responseObject;
        Set<Entry<Object, Map>> entrySet = persons.entrySet();
        Entry<Object, Map> next = entrySet.iterator().next();
        logger.info("key:"+next.getKey() + " value:"+next.getValue());
        Map value = next.getValue();
		return UUID.fromString((String)value.get("assessmentId"));
		} catch (JsonMappingException e) {
			logger.error(" Error when createAssessment is called", e.getCause());
		} catch (JsonProcessingException e) {
			logger.error(" Error when createAssessment is called", e.getCause());
		}
		return null;
	}

	/***
	 * The first step for Hmis posting is to make sure an enrollment is created.
	 * @param hmisPostingModel
	 * @param headers
	 * @param schemaYear
	 */
	private UUID createEnrollment(HmisPostingModel hmisPostingModel, HttpHeaders headers) {
		Map<String, Object> map = new HashMap<>();
		try {
			map.put("entryDate", converDate(hmisPostingModel.getEntryDate()));
			UUID projectId = getVersionSpecificProjectId(hmisPostingModel, headers);
			map.put("projectId",projectId);
			map.put("clientId", hmisPostingModel.getClientId());
			ObjectMapper objectMapper = new ObjectMapper();
				
			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			String jsonObj = objectMapper.writer().withRootName("enrollment").writeValueAsString(map);
			String url = HMIS_HOST+"/hmis-clientapi-"+hmisPostingModel.getSchemaVersion()+"/rest/clients/"+hmisPostingModel.getClientId()+"/enrollments";
			//
			 Object responseObject = makeAPICall(jsonObj, headers, url, HttpMethod.POST);
	        LinkedHashMap<Object, Map> persons = (LinkedHashMap<Object, Map>) responseObject;
	        Set<Entry<Object, Map>> entrySet = persons.entrySet();
	        Entry<Object, Map> next = entrySet.iterator().next();
	        logger.info("key:"+next.getKey() + " value:"+next.getValue());
	        Map value = next.getValue();
			return UUID.fromString((String)value.get("enrollmentId"));
		} catch (JsonMappingException e) {
			logger.error(" Error when createExit is called", e.getCause());
		} catch (JsonProcessingException e) {
			logger.error(" Error when createExit is called", e.getCause());
		}
		return null;
	}
	/***
	 * Create Exit if the survey category is Exit
	 * @param hmisPostingModel
	 * @param headers
	 * @param enrollmentId
	 */
	private UUID createExit(HmisPostingModel hmisPostingModel, HttpHeaders headers, UUID enrollmentId) {
		Map<String, Object> map = new HashMap<>();
		String exitDate = hmisPostingModel.getExitDate();
		map.put("exitDate",converDate(hmisPostingModel.getExitDate()));
		
		ObjectMapper objectMapper = new ObjectMapper();
				try {
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		String jsonObj = objectMapper.writer().withRootName("exit").writeValueAsString(map);
		String url = HMIS_HOST+"/hmis-clientapi-"+hmisPostingModel.getSchemaVersion()+"/rest/clients/"+hmisPostingModel.getClientId()+"/enrollments/"+enrollmentId+"/exits";
		//
		 Object responseObject = makeAPICall(jsonObj, headers, url, HttpMethod.POST);
        LinkedHashMap<Object, Map> persons = (LinkedHashMap<Object, Map>) responseObject;
        Set<Entry<Object, Map>> entrySet = persons.entrySet();
        Entry<Object, Map> next = entrySet.iterator().next();
        logger.info("key:"+next.getKey() + " value:"+next.getValue());
        Map value = next.getValue();
		return UUID.fromString((String)value.get("exitId"));
		} catch (JsonMappingException e) {
			logger.error(" Error when createExit is called", e.getCause());
		} catch (JsonProcessingException e) {
			logger.error(" Error when createExit is called", e.getCause());
		}
		return null;
	}
	/***
	 * Post questions to HMIS
	 * @param hmisPostingModel
	 * @param headers
	 * @param enrollmentId
	 * @param exitId
	 * @param projectId
	 * @throws JsonProcessingException
	 * @throws JsonMappingException
	 */
	private void postQuestionsToHmis(HmisPostingModel hmisPostingModel, HttpHeaders headers, UUID enrollmentId, UUID projectId) {
		UUID exitId = null;
		if(StringUtils.equals("3", hmisPostingModel.getSurveyCategory())) {
			exitId = createExit(hmisPostingModel,  headers, enrollmentId);
		}
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		List<QuestionResponseModel> questionResponses = hmisPostingModel.getQuestionResponses();
		if(!CollectionUtils.isEmpty(questionResponses)) {
			Map<String,List<QuestionResponseModel>> questionResponseMap = new HashMap<>();
			for( QuestionResponseModel questionResponseModel : questionResponses) {
				logger.info(questionResponseModel.getUriObjectField());
				List<QuestionResponseModel> list = questionResponseMap.get(questionResponseModel.getUpdateUrlTemplate());
				if(!CollectionUtils.isEmpty(list)) {
					list.add(questionResponseModel);
					questionResponseMap.put(questionResponseModel.getUpdateUrlTemplate(), list);
				} else {
					List<QuestionResponseModel>  questionResponseModels = new ArrayList<QuestionResponseModel>();
					questionResponseModels.add(questionResponseModel);
					questionResponseMap.put(questionResponseModel.getUpdateUrlTemplate(), questionResponseModels);
				}
			}
			Set<String> keySet = questionResponseMap.keySet();
			for(String questionResponseKey : keySet) {
				try {
					List<QuestionResponseModel> list = questionResponseMap.get(questionResponseKey);
					String rootName = "";
					List<UUID> responseIds = new ArrayList<>();
					if(!CollectionUtils.isEmpty(list)) {
						Map<String, Object> map = new HashMap<>();
						for(QuestionResponseModel questionResponseModel : list) {
							String uriObjectField = questionResponseModel.getUriObjectField();
							String[] split = StringUtils.split(uriObjectField, ".");
							rootName = split[0];
							responseIds.add(questionResponseModel.getResponseId());
							map.put(split[1], StringUtils.isNotBlank(questionResponseModel.getPickListValueCode()) ? questionResponseModel.getPickListValueCode() : questionResponseModel.getResponseText());
						}
						map.put("dataCollectionStage", hmisPostingModel.getSurveyCategory());
						map.put("informationDate", converDate(hmisPostingModel.getInformationDate()));
						objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
						String jsonObj = objectMapper.writer().withRootName(rootName).writeValueAsString(map);
						String url = getUrl(questionResponseKey,hmisPostingModel.getClientId(), enrollmentId, exitId, projectId, null);
						// Create the url from the uriObjectFied.
						Object responseObject = makeAPICall(jsonObj, headers, url, HttpMethod.POST);
				        LinkedHashMap<Object, Map> persons = (LinkedHashMap<Object, Map>) responseObject;
				        Set<Entry<Object, Map>> entrySet = persons.entrySet();
				        Entry<Object, Map> next = entrySet.iterator().next();
				        logger.info("key:"+next.getKey() + " value:"+next.getValue());
				        Map value = next.getValue();
						String rootId = (String)value.get(rootName+"Id");
						updateResponse(hmisPostingModel, responseIds, headers, url+"/"+rootId, HttpMethod.PUT);
					}
				}catch(Exception e) {
					logger.error(" Error when postQuestionsToHmis is called", e.getCause());
				}
			}
		}
	}
	/***
	 * Update HmisLink in the response table.
	 * @param hmisPostingModel
	 * @param responseIds
	 * @param headers
	 * @param hmisLink
	 * @param httpMethod
	 */
	private void updateResponse(HmisPostingModel hmisPostingModel,List<UUID> responseIds, HttpHeaders headers, String hmisLink, HttpMethod httpMethod) {
		Map<String, Object> map = new HashMap<>();
		
		map.put("hmisLink", StringUtils.replace(hmisLink, HMIS_HOST+"", ""));
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		for(UUID responseId : responseIds) {
			try {
				String url = CES_HOST+"/survey-api/rest/v3/clients/"+hmisPostingModel.getDedupClientId()+"/surveys/"+hmisPostingModel.getSurveyId()+"/responses/"+responseId;
				String jsonObj = objectMapper.writer().withRootName("response").writeValueAsString(map);
				makeAPICall(jsonObj, headers, url, httpMethod);
			} catch (JsonMappingException e) {
				logger.error(" Error when updateResponse is called", e.getCause());
			} catch (JsonProcessingException e) {
				logger.error(" Error when updateResponse is called", e.getCause());
			}
		}
	}
	/***
	 * Update HmisLink in the client_survey_submission table.
	 * @param hmisPostingModel
	 * @param responseIds
	 * @param headers
	 * @param hmisLink
	 * @param httpMethod
	 */
	private void updateClientSurveySubmission(HmisPostingModel hmisPostingModel, HttpHeaders headers, String hmisLink, HttpMethod httpMethod, UUID enrollmentId) {
		Map<String, Object> map = new HashMap<>();
		map.put("hmisLink", StringUtils.replace(hmisLink, HMIS_HOST+"", ""));
		map.put("globalEnrollmentId", enrollmentId);
		map.put("hmisPostingStatus", "DONE");
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			try {
				String url = CES_HOST+"/survey-api/rest/clientsurveysubmissions/"+hmisPostingModel.getClientSurveySubmissionId();
				String jsonObj = objectMapper.writer().withRootName("clientsurveysubmission").writeValueAsString(map);
				makeAPICall(jsonObj, headers, url, httpMethod);
			} catch (JsonMappingException e) {
				logger.error(" Error when updateResponse is called", e.getCause());
			} catch (JsonProcessingException e) {
				logger.error(" Error when updateResponse is called", e.getCause());
			}
		}
	/***
	 * Post questions to HMIS
	 * @param hmisPostingModel
	 * @param headers
	 * @param enrollmentId
	 * @param exitId
	 * @param projectId
	 * @throws JsonProcessingException
	 * @throws JsonMappingException
	 */
	private void postAssessmentQuestions(HmisPostingModel hmisPostingModel, HttpHeaders headers, UUID enrollmentId) {
		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		List<QuestionResponseModel> questionResponses = hmisPostingModel.getQuestionResponses();
		boolean isAssessmentCreated = false;
		UUID assessmentId = null;
		if(!CollectionUtils.isEmpty(questionResponses)) {
			Map<String,List<QuestionResponseModel>> questionResponseMap = new HashMap<>();
			for( QuestionResponseModel questionResponseModel : questionResponses) {
				logger.info(questionResponseModel.getUriObjectField());
				if(StringUtils.equals(questionResponseModel.getQuestionClassification(), "CES")) {
					try {
						if(!isAssessmentCreated) {
							assessmentId = createAssessment(headers, hmisPostingModel, enrollmentId);
							isAssessmentCreated = true;
						}
						Map<String, Object> map = new HashMap<>();
						map.put("assessmentQuestion", questionResponseModel.getQuestionText());
						map.put("assessmentAnswer", questionResponseModel.getResponseText());
						if(hmisPostingModel.getDedupClientId() != null)
							map.put("dedupClientId", String.valueOf(hmisPostingModel.getDedupClientId()));
						objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
						String jsonObj = objectMapper.writer().withRootName("assessmentQuestion").writeValueAsString(map);
						String requestPath = hmisPostingModel.getSchemaVersion()+"/rest/clients/{clientid}/enrollments/{enrollmentid}/assessments/{assessmentid}/assessmentquestions";
						String url = getAssessmentUrl(requestPath,hmisPostingModel.getClientId(), enrollmentId, assessmentId, null);
						// Create the url from the uriObjectFied.
						Object responseObject = makeAPICall(jsonObj, headers, url, HttpMethod.POST);
						LinkedHashMap<Object, Map> persons = (LinkedHashMap<Object, Map>) responseObject;
				        Set<Entry<Object, Map>> entrySet = persons.entrySet();
				        Entry<Object, Map> next = entrySet.iterator().next();
				        logger.info("key:"+next.getKey() + " value:"+next.getValue());
				        Map value = next.getValue();
						String rootId = (String)value.get("assessmentQuestionId");
						List<UUID> responses = new ArrayList<>();
						responses.add(questionResponseModel.getResponseId());
						updateResponse(hmisPostingModel,responses , headers, url+"/"+rootId, HttpMethod.PUT);
					} catch (Exception e) {
						logger.error(" Error when creating assessment questions", e.getCause());
					}
				}
			}
		}
	}
	/***
	 * Get the URL from the uriTemplate
	 * @param requestPath
	 * @param clientId
	 * @param enrollmentId
	 * @param exitId
	 * @param projectId
	 * @param id
	 * @return
	 */
	private String getUrl(String requestPath,UUID clientId,UUID enrollmentId, UUID exitId, UUID projectId,UUID id) {
		if(StringUtils.startsWith(requestPath, "/")) {
			requestPath = StringUtils.substring(requestPath, 1);
			requestPath = StringUtils.substring(requestPath, 0, StringUtils.lastIndexOf(requestPath, "/"));
			if(id !=null) {
				requestPath = requestPath +"/"+id;
			}
			if(StringUtils.indexOf(requestPath, "/2020/rest") == -1) {
				requestPath = StringUtils.replace(requestPath, "2020", "2020/rest");
			}
			if(requestPath != null) {
				if(enrollmentId !=null)
					requestPath = StringUtils.replace(requestPath, "{enrollmentid}", enrollmentId.toString());
				if(exitId !=null)
					requestPath = StringUtils.replace(requestPath, "{exitid}", exitId.toString());
				if(projectId !=null)
					requestPath = StringUtils.replace(requestPath, "{projectid}", projectId.toString());
				if(clientId !=null)
					requestPath = StringUtils.replace(requestPath, "{clientid}", clientId.toString());
			}
		}
		String url = HMIS_HOST+"/hmis-clientapi-"+requestPath;
		return url;
	}
	/***
	 * Get the URL from the uriTemplate
	 * @param requestPath
	 * @param clientId
	 * @param enrollmentId
	 * @param exitId
	 * @param projectId
	 * @param id
	 * @return
	 */
	private String getAssessmentUrl(String requestPath,UUID clientId,UUID enrollmentId, UUID assessmentId,UUID id) {
		if(StringUtils.startsWith(requestPath, "/")) {
			requestPath = StringUtils.substring(requestPath, 1);
			requestPath = StringUtils.substring(requestPath, 0, StringUtils.lastIndexOf(requestPath, "/"));
			if(id !=null) {
				requestPath = requestPath +"/"+id;
			}
			if(StringUtils.indexOf(requestPath, "/2020/rest") == -1) {
				requestPath = StringUtils.replace(requestPath, "2020", "2020/rest");
			}
		}
		if(requestPath != null) {
			if(enrollmentId !=null)
				requestPath = StringUtils.replace(requestPath, "{enrollmentid}", enrollmentId.toString());
			if(assessmentId !=null)
				requestPath = StringUtils.replace(requestPath, "{assessmentid}", assessmentId.toString());
			if(clientId !=null)
				requestPath = StringUtils.replace(requestPath, "{clientid}", clientId.toString());
		}
		String url = HMIS_HOST+"/hmis-clientapi-"+requestPath;
		return url;
	}
	/***
	 * Make an API call to the version specific API.
	 * @param objectJson
	 * @param headers
	 * @param url
	 * @param httpMethod
	 * @return
	 */
	private Object makeAPICall(String objectJson,HttpHeaders headers, String url, HttpMethod httpMethod) {
		try {
			RestTemplate rest = new RestTemplate();
			HttpEntity<Object> requestEntity = new HttpEntity<Object>(objectJson,headers);
			logger.info("Make API URL "+url);
			logger.info("Make API objectJSON "+objectJson);
			ResponseEntity<Object> responseEntity =	rest.exchange(url, httpMethod, requestEntity, Object.class);
			logger.info("Make API call "+responseEntity.getStatusCodeValue());
			return responseEntity.getBody();
		} catch (Exception e) {
			logger.error(" Error when makeAPICall is called", e.getCause());
		} 
		return null;
	}
	/***
	 * Convert String date to long timestamp.
	 * @param inputDate
	 * @return
	 */
	private String converDate(String inputDate) {
		Date date = new Date();
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(inputDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return String.valueOf(date.getTime());
	}
	/***
	 * Get Http headers
	 * @param clientId
	 * @param sessionToken
	 * @return
	 */
	public HttpHeaders getHttpHeader(String clientId, String sessionToken) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", "application/json");
		headers.add("Content-Type", "application/json; charset=UTF-8");
		headers.add("X-HMIS-TrustedApp-Id", clientId);
		headers.add("Authorization","HMISUserAuth session_token="+sessionToken);
		MediaType mediaType = new MediaType("application", "json", Charset.forName("UTF-8"));
		headers.setContentType(mediaType);
		return headers;
	}
}
