package com.servinglynk.hmis.service.converter;

import java.time.ZoneId;
import java.util.Date;

import com.servinglynk.hmis.entity.ClientEntity;
import com.servinglynk.hmis.model.Client;


public class ClientConverter {
	
	
	public static Client entityToModel(ClientEntity pClient) {
		Client client = new Client();
	    if(pClient.getDob()!=null)
		client.setDob(Date.from(pClient.getDob().atZone(ZoneId.systemDefault()).toInstant()));
	    if(pClient.getFirstName()!=null)
		client.setFirstName(pClient.getFirstName());
	    if(pClient.getLastName()!=null)
		client.setLastName(pClient.getLastName());
	    if(pClient.getMiddleName()!=null)
		client.setMiddleName(pClient.getMiddleName());
	    if(pClient.getNameSuffix()!=null)
		client.setNameSuffix(pClient.getNameSuffix());
	    if(pClient.getOtherGender()!=null)
		client.setOtherGender(pClient.getOtherGender());
	    if(pClient.getSsn()!=null)
		client.setSsn(pClient.getSsn());
	    if(pClient.getId()!=null)
	    	client.setClientId(pClient.getId());
	    if(pClient.getProjectGroupCode()!=null)
	    	client.setProjectGroupCode(pClient.getProjectGroupCode());
	    if(pClient.getSourceSystemId()!=null)
	    		client.setSourceSystemId(pClient.getSourceSystemId());
	    if(pClient.getSchemaYear()!=null)
	    		client.setLink("/hmis-clientapi/rest/v"+pClient.getSchemaYear()+"/clients/"+pClient.getId());
	    if(pClient.getDedupClientId()!=null)
	    		client.setDedupClientId(pClient.getDedupClientId());
	    if(pClient.getPhoneNumber()!=null)
	    		client.setPhoneNumber(pClient.getPhoneNumber());
	    if(pClient.getEmailAddress()!=null)
	    		client.setEmailAddress(pClient.getEmailAddress());
		return client;
	}

}
