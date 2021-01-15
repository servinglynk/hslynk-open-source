package com.servinglynk.hmis.warehouse.service.converter;

import java.time.ZoneId;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.servinglynk.hmis.warehouse.core.model.ActionLink;
import com.servinglynk.hmis.warehouse.core.model.Client;
import com.servinglynk.hmis.warehouse.enums.ClientDobDataQualityEnum;
import com.servinglynk.hmis.warehouse.enums.ClientEthnicityEnum;
import com.servinglynk.hmis.warehouse.enums.ClientGenderEnum;
import com.servinglynk.hmis.warehouse.enums.ClientNameDataQualityEnum;
import com.servinglynk.hmis.warehouse.enums.ClientRaceEnum;
import com.servinglynk.hmis.warehouse.enums.ClientSsnDataQualityEnum;
import com.servinglynk.hmis.warehouse.enums.HashStatusEnum;

public class ClientConverter {

	public static com.servinglynk.hmis.warehouse.model.v2014.Client modelToEntity(Client client,com.servinglynk.hmis.warehouse.model.v2014.Client pClient){
		if(pClient==null) pClient = new com.servinglynk.hmis.warehouse.model.v2014.Client(); 
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
	    if(client.getRace1()!=null)
				pClient.setRace1(ClientRaceEnum.lookupEnum(client.getRace()+""));
	    if(client.getSsn()!=null)
		pClient.setSsn(client.getSsn());
	    if(client.getSsn()!=null && StringUtils.isEmpty(client.getSsn().replaceAll(" ", ""))) pClient.setSsn(null);
	    if(client.getSsnDataQuality()!=null)
		pClient.setSsnDataQuality(ClientSsnDataQualityEnum.lookupEnum(client.getSsnDataQuality()+""));
	    if(client.getSourceSystemId()!=null)
	    	pClient.setSourceSystemId(client.getSourceSystemId());
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
	
	public static Client entityToModel(com.servinglynk.hmis.warehouse.model.v2014.Client pClient){
		Client client = new Client();
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
	    if(pClient.getRace1()!=null)
			client.setRace1(Integer.parseInt(pClient.getRace1().getValue()));
	    if(pClient.getSsn()!=null)
		client.setSsn(pClient.getSsn());
	    if(pClient.getSsnDataQuality()!=null)
		client.setSsnDataQuality(Integer.parseInt(pClient.getSsnDataQuality().getValue()));
	    if(pClient.getId()!=null)
		client.setClientId(pClient.getId());
	    if(pClient.getSourceSystemId()!=null)
	    	client.setSourceSystemId(pClient.getSourceSystemId());
	    if(pClient.getDedupClientId() !=null)
	    	client.setDedupClientId(pClient.getDedupClientId());
	    if(pClient.getFirstNameHashStatus() !=null)
	    	client.setFirstNameHashStatus(pClient.getFirstNameHashStatus().getValue());
	    if(pClient.getLastNameHashStatus() !=null)
		    client.setLastNameHashStatus(pClient.getLastNameHashStatus().getValue());
	    if(pClient.getMiddleNameHashStatus() !=null)
		    client.setMiddleNameHashStatus(pClient.getMiddleNameHashStatus().getValue());
	    if(pClient.getSsnHashStatus() !=null)
		    client.setSsnHashStatus(pClient.getSsnHashStatus().getValue());
	    if(pClient.getParentId()==null)
	    	client.addLink(new ActionLink("history","/client/"+pClient.getId()+"/history"));
//		copyBeanProperties(pClient,client);
	return client;
	}
}