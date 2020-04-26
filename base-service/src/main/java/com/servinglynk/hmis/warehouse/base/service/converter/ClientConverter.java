package com.servinglynk.hmis.warehouse.base.service.converter;

import java.time.ZoneId;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.servinglynk.hmis.warehouse.core.model.BaseClient;

import com.servinglynk.hmis.warehouse.enums.ClientDobDataQualityEnum;
import com.servinglynk.hmis.warehouse.enums.ClientEthnicityEnum;
import com.servinglynk.hmis.warehouse.enums.ClientGenderEnum;
import com.servinglynk.hmis.warehouse.enums.ClientNameDataQualityEnum;
import com.servinglynk.hmis.warehouse.enums.ClientRaceEnum;
import com.servinglynk.hmis.warehouse.enums.ClientSsnDataQualityEnum;
import com.servinglynk.hmis.warehouse.enums.HashStatusEnum;
import com.servinglynk.hmis.warehouse.model.SearchClient;

public class ClientConverter {

	public static com.servinglynk.hmis.warehouse.model.base.Client modelToEntity(BaseClient client,com.servinglynk.hmis.warehouse.model.base.Client pClient){
		if(pClient==null) pClient = new com.servinglynk.hmis.warehouse.model.base.Client(); 
	    if(client.getDob()!=null)
		pClient.setDob(client.getDob().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
	    if(client.getDobDataQuality()!=null)
		pClient.setDobDataQuality(ClientDobDataQualityEnum.lookupEnum(client.getDobDataQuality().toString()));
	    if(client.getEthnicity()!=null)
		pClient.setEthnicity(ClientEthnicityEnum.lookupEnum(client.getEthnicity()+""));
	    if(client.getFirstName()!=null)
		pClient.setFirstName(client.getFirstName());
	    if(client.getGender()!=null)
		pClient.setGender(ClientGenderEnum.lookupEnum(client.getGender()+""));
	    if(client.getLastName()!=null)
		pClient.setLastName(client.getLastName());
	    if(client.getMiddleName()!=null)
		pClient.setMiddleName(client.getMiddleName());
	    if(client.getNameDataQuality()!=null)
		pClient.setNameDataQuality(ClientNameDataQualityEnum.lookupEnum(client.getNameDataQuality()+""));
	    if(client.getNameSuffix()!=null)
		pClient.setNameSuffix(client.getNameSuffix());
	    if(client.getOtherGender()!=null)
		pClient.setOtherGender(client.getOtherGender());
	    if(client.getRace()!=null)
		pClient.setRace(ClientRaceEnum.lookupEnum(client.getRace()+""));
	    if(client.getSsn()!=null)
		pClient.setSsn(client.getSsn());
	    if(client.getSsnDataQuality()!=null)
		pClient.setSsnDataQuality(ClientSsnDataQualityEnum.lookupEnum(client.getSsnDataQuality()+""));
	    if(StringUtils.isNotBlank(client.getFirstNameHashStatus()))
	    pClient.setFirstNameHashStatus(HashStatusEnum.lookupEnum(client.getFirstNameHashStatus()));
	    if(StringUtils.isNotBlank(client.getLastNameHashStatus()))
		pClient.setLastNameHashStatus(HashStatusEnum.lookupEnum(client.getLastNameHashStatus()));
	    if(StringUtils.isNotBlank(client.getMiddleNameHashStatus()))
		pClient.setMiddleNameHashStatus(HashStatusEnum.lookupEnum(client.getMiddleNameHashStatus()));
	    if(StringUtils.isNotBlank(client.getSsnHashStatus()))
		pClient.setSsnHashStatus(HashStatusEnum.lookupEnum(client.getSsnHashStatus()));
	    if(StringUtils.isNotBlank(client.getSsnHashed()))
		pClient.setSsn(client.getSsnHashed());
		
		return pClient;
	}
	
	public static BaseClient entityToModel(com.servinglynk.hmis.warehouse.model.base.Client pClient){
		BaseClient client = new BaseClient();
	    if(pClient.getDob()!=null)
		client.setDob(Date.from(pClient.getDob().atZone(ZoneId.systemDefault()).toInstant()));
	    if(pClient.getDobDataQuality()!=null)
		client.setDobDataQuality(Integer.parseInt(pClient.getDobDataQuality().getValue()));
	    if(pClient.getEthnicity()!=null)
		client.setEthnicity(Integer.parseInt(pClient.getEthnicity().getValue()));
	    if(pClient.getFirstName()!=null)
		client.setFirstName(pClient.getFirstName());
	    if(pClient.getGender()!=null)
		client.setGender(Integer.parseInt(pClient.getGender().getValue()));
	    if(pClient.getLastName()!=null)
		client.setLastName(pClient.getLastName());
	    if(pClient.getMiddleName()!=null)
		client.setMiddleName(pClient.getMiddleName());
	    if(pClient.getNameDataQuality()!=null)
		client.setNameDataQuality(Integer.parseInt(pClient.getNameDataQuality().getValue()));
	    if(pClient.getNameSuffix()!=null)
		client.setNameSuffix(pClient.getNameSuffix());
	    if(pClient.getOtherGender()!=null)
		client.setOtherGender(pClient.getOtherGender());
	    if(pClient.getRace()!=null)
		client.setRace(Integer.parseInt(pClient.getRace().getValue()));
	    if(pClient.getSsn()!=null)
		client.setSsn(pClient.getSsn());
	    if(pClient.getSsnDataQuality()!=null)
		client.setSsnDataQuality(Integer.parseInt(pClient.getSsnDataQuality().getValue()));
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
	    if(pClient.getVeteranStatus()!=null)
	    	 client.setVeteranStatus(Integer.parseInt(pClient.getVeteranStatus().getValue()));
	    if(pClient.getFirstNameHashStatus() !=null)
	    	client.setFirstNameHashStatus(pClient.getFirstNameHashStatus().getValue());
	    if(pClient.getLastNameHashStatus() !=null)
		    client.setLastNameHashStatus(pClient.getLastNameHashStatus().getValue());
	    if(pClient.getMiddleNameHashStatus() !=null)
		    client.setMiddleNameHashStatus(pClient.getMiddleNameHashStatus().getValue());
	    if(pClient.getSsnHashStatus() !=null)
		    client.setSsnHashStatus(pClient.getSsnHashStatus().getValue());
//		copyBeanProperties(pClient,client);
	return client;
	}

	public static BaseClient entityToModel(SearchClient pClient) {
		BaseClient client = new BaseClient();
	    if(pClient.getrDob()!=null)
		client.setDob(Date.from(pClient.getrDob().atZone(ZoneId.systemDefault()).toInstant()));
	    if(pClient.getrDobDataQuality()!=null)
		client.setDobDataQuality(Integer.parseInt(pClient.getrDobDataQuality().getValue()));
	    if(pClient.getrEthnicity()!=null)
		client.setEthnicity(Integer.parseInt(pClient.getrEthnicity().getValue()));
	    if(pClient.getrFirstName()!=null)
		client.setFirstName(pClient.getrFirstName());
	    if(pClient.getrGender()!=null)
		client.setGender(Integer.parseInt(pClient.getrGender().getValue()));
	    if(pClient.getrLastName()!=null)
		client.setLastName(pClient.getrLastName());
	    if(pClient.getrMiddleName()!=null)
		client.setMiddleName(pClient.getrMiddleName());
	    if(pClient.getrNameDataQuality()!=null)
		client.setNameDataQuality(Integer.parseInt(pClient.getrNameDataQuality().getValue()));
	    if(pClient.getrNameSuffix()!=null)
		client.setNameSuffix(pClient.getrNameSuffix());
	    if(pClient.getrOtherGender()!=null)
		client.setOtherGender(pClient.getrOtherGender());
	    if(pClient.getrRace()!=null)
		client.setRace(Integer.parseInt(pClient.getrRace().getValue()));
	    if(pClient.getrSsn()!=null)
		client.setSsn(pClient.getrSsn());
	    if(pClient.getrSsnDataQuality()!=null)
		client.setSsnDataQuality(Integer.parseInt(pClient.getrSsnDataQuality().getValue()));
	    if(pClient.getrId()!=null)
	    	client.setClientId(pClient.getrId());
	    if(pClient.getrProjectGroupCode()!=null)
	    	client.setProjectGroupCode(pClient.getrProjectGroupCode());
	    if(pClient.getrSourceSystemId()!=null)
	    		client.setSourceSystemId(pClient.getrSourceSystemId());
	    if(pClient.getrSchemaYear()!=null)
	    		client.setLink("/hmis-clientapi/rest/v"+pClient.getrSchemaYear()+"/clients/"+pClient.getrId());
	    if(pClient.getrDedupClientId()!=null)
	    		client.setDedupClientId(pClient.getrDedupClientId());
	    if(pClient.getrPhoneNumber()!=null)
	    		client.setPhoneNumber(pClient.getrPhoneNumber());
	    if(pClient.getrEmailAddress()!=null)
	    		client.setEmailAddress(pClient.getrEmailAddress());
	    if(pClient.getrVeteranStatus()!=null)
	    	 client.setVeteranStatus(Integer.parseInt(pClient.getrVeteranStatus().getValue()));
	    
		return client;
	}
}