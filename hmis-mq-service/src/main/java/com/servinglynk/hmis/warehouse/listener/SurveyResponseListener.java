package com.servinglynk.hmis.warehouse.listener;

import java.util.UUID;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.servinglynk.hmis.warehouse.common.MQDateUtil;
import com.servinglynk.hmis.warehouse.model.AMQEvent;
import com.servinglynk.hmis.warehouse.model.ClientMetaDataModel;
import com.servinglynk.hmis.warehouse.model.HmisPostingModel;
import com.servinglynk.hmis.warehouse.model.HmisPostingsModel;
import com.servinglynk.hmis.warehouse.model.JSONObjectMapper;
import com.servinglynk.hmis.warehouse.model.SessionModel;

@Component
public class SurveyResponseListener extends BaseListener {

	@JmsListener(destination="survey.submissions")
	public void listeneQueue(String eventString) {
		System.out.println("inside survey.submissions listener");
		JSONObjectMapper mapper = new JSONObjectMapper();
		try {
			AMQEvent event = mapper.readValue(eventString, AMQEvent.class);
			
			ClientMetaDataModel model = new ClientMetaDataModel();
			model.setAdditionalInfo(mapper.writeValueAsString(event.getPayload()));
			if(event.getPayload().get("dedupClientId")!=null) model.setClientDedupId(UUID.fromString(event.getPayload().get("dedupClientId").toString()));
			if(event.getPayload().get("clientId")!=null) model.setClientId(UUID.fromString(event.getPayload().get("clientId").toString()));
			if(event.getPayload().get("submissionDate")!=null) model.setDate(MQDateUtil.stringToDateTime(event.getPayload().get("submissionDate").toString()));
			if(event.getPayload().get("submissionId")!=null) model.setMetaDataIdentifier(UUID.fromString(event.getPayload().get("submissionId").toString()));
			if(event.getPayload().get("projectGroupCode")!=null) model.setProjectGroupCode(event.getPayload().get("projectGroupCode").toString());
			model.setType("surveySubmissions");
			if(event.getPayload().get("userId")!=null) model.setUserId(UUID.fromString(event.getPayload().get("userId").toString()));
			
					if(Boolean.parseBoolean(event.getPayload().get("deleted").toString())) {
						serviceFactory.getClientMetaDataService().deleteClientMetaData(model);
					}else {
						serviceFactory.getClientMetaDataService().createClientMetaData(model);
					}
					
					Object hmisPostingObj = event.getPayload().get("hmisPosting");
					if(hmisPostingObj != null) {
						String hmisPosting = hmisPostingObj.toString();
							System.out.println("hmisPosting data "+hmisPosting);
							JSONObjectMapper objectMapper = new JSONObjectMapper();
							objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
							HmisPostingsModel hmisPostingsModel = objectMapper.readValue(hmisPosting, HmisPostingsModel.class);
							if(hmisPostingsModel != null) {
								HmisPostingModel hmisPostingModel = hmisPostingsModel.getHmisPosting();
								SessionModel sessionModel = new SessionModel();
								sessionModel.setClientId(event.getPayload().get("trustedAppId").toString());
								sessionModel.setProjectGroupCode(event.getPayload().get("projectGroupCode").toString());
								sessionModel.setSessionToken(event.getPayload().get("sessionToken").toString());
								
								serviceFactory.getHmisPostingService().postHmis(hmisPostingModel, sessionModel);
							}
						}
							}catch (Exception e) {
		e.printStackTrace();	
		}
	}
}