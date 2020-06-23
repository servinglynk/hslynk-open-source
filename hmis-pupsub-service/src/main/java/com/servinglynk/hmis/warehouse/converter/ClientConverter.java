package com.servinglynk.hmis.warehouse.converter;

import java.time.ZoneId;
import java.util.Date;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.core.model.BaseClient;
import com.servinglynk.hmis.warehouse.model.base.Client;

public class ClientConverter {

	
	public static BaseClient entityToModel(Client pClient) {
			BaseClient client = new BaseClient();
		    if(pClient.getDob()!=null)
			client.setDob(pClient.getDob());
		    if(pClient.getDobDataQuality()!=null)
			client.setDobDataQuality(Integer.parseInt(pClient.getDobDataQuality().getValue()));
		    if(pClient.getEthnicity()!=null)
			client.setEthnicity(Integer.parseInt(pClient.getEthnicity().getValue()));
		    if(pClient.getFirstname()!=null)
			client.setFirstName(pClient.getFirstname());
		    if(pClient.getGender()!=null)
			client.setGender(Integer.parseInt(pClient.getGender().getValue()));
		    if(pClient.getLastname()!=null)
			client.setLastName(pClient.getLastname());
		    if(pClient.getMiddlename()!=null)
			client.setMiddleName(pClient.getMiddlename());
		    if(pClient.getNamedataquality()!=null)
			client.setNameDataQuality(Integer.parseInt(pClient.getNamedataquality().getValue()));
		    if(pClient.getNamesuffix()!=null)
			client.setNameSuffix(pClient.getNamesuffix());
		    if(pClient.getOthergender()!=null)
			client.setOtherGender(pClient.getOthergender());
		    if(pClient.getRace()!=null)
			client.setRace(Integer.parseInt(pClient.getRace().getValue()));
		    if(pClient.getSsn()!=null)
			client.setSsn(pClient.getSsn());
		    if(pClient.getSsndataquality()!=null)
			client.setSsnDataQuality(Integer.parseInt(pClient.getSsndataquality().getValue()));
		    if(pClient.getId()!=null)
		    	client.setClientId(UUID.fromString(pClient.getId()));
		    if(pClient.getProjectgroupcode()!=null)
		    	client.setProjectGroupCode(pClient.getProjectgroupcode());
		    if(pClient.getSourcesystemid()!=null)
		    		client.setSourceSystemId(pClient.getSourcesystemid());
		    if(pClient.getSchemayear()!=null)
		    		client.setLink("/hmis-clientapi/rest/v"+pClient.getSchemayear()+"/clients/"+pClient.getId());
		    if(pClient.getDedupclientid()!=null)
		    		client.setDedupClientId(UUID.fromString(pClient.getDedupclientid()));
		    if(pClient.getPhonenumber()!=null)
		    		client.setPhoneNumber(pClient.getPhonenumber());
		    if(pClient.getEmailaddress()!=null)
		    		client.setEmailAddress(pClient.getEmailaddress());
		    if(pClient.getVeteranstatus()!=null)
		    	 client.setVeteranStatus(Integer.parseInt(pClient.getVeteranstatus().getValue()));
		    
			return client;
		}
	
}