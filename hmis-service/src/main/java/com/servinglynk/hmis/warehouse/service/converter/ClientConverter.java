package com.servinglynk.hmis.warehouse.service.converter;

import java.time.ZoneId;
import java.util.Date;

import com.servinglynk.hmis.warehouse.core.model.Client;
import com.servinglynk.hmis.warehouse.enums.ClientDobDataQualityEnum;
import com.servinglynk.hmis.warehouse.enums.ClientEthnicityEnum;
import com.servinglynk.hmis.warehouse.enums.ClientGenderEnum;
import com.servinglynk.hmis.warehouse.enums.ClientNameDataQualityEnum;
import com.servinglynk.hmis.warehouse.enums.ClientRaceEnum;
import com.servinglynk.hmis.warehouse.enums.ClientSsnDataQualityEnum;

public class ClientConverter extends BaseConveter {

	public static com.servinglynk.hmis.warehouse.model.v2014.Client modelToEntity(Client client,com.servinglynk.hmis.warehouse.model.v2014.Client pClient){
		if(pClient==null) pClient = new com.servinglynk.hmis.warehouse.model.v2014.Client(); 


		pClient.setDob(client.getDob().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
		pClient.setDobDataQuality(ClientDobDataQualityEnum.lookupEnum(client.getDobDataQuality().toString()));
		pClient.setEthnicity(ClientEthnicityEnum.lookupEnum(client.getEthnicity()+""));
		pClient.setFirstName(client.getFirstName());
		pClient.setGender(ClientGenderEnum.lookupEnum(client.getGender()+""));
		pClient.setLastName(client.getLastName());
		pClient.setMiddleName(client.getMiddleName());
		pClient.setNameDataQuality(ClientNameDataQualityEnum.lookupEnum(client.getNameDataQuality()+""));
		pClient.setNameSuffix(client.getNameSuffix());
		pClient.setOtherGender(client.getOtherGender());
		pClient.setRace(ClientRaceEnum.lookupEnum(client.getRace()+""));
		pClient.setSsn(client.getSsn());
		pClient.setSsnDataQuality(ClientSsnDataQualityEnum.lookupEnum(client.getSsnDataQuality()+""));
		
		return pClient;
	}
	
	public static Client entityToModel(com.servinglynk.hmis.warehouse.model.v2014.Client pClient){
		Client client = new Client();

		client.setDob(Date.from(pClient.getDob().atZone(ZoneId.systemDefault()).toInstant()));
		client.setDobDataQuality(Integer.parseInt(pClient.getDobDataQuality().getValue()));
		client.setEthnicity(Integer.parseInt(pClient.getEthnicity().getValue()));
		client.setFirstName(pClient.getFirstName());
		client.setGender(Integer.parseInt(pClient.getGender().getValue()));
		client.setLastName(pClient.getLastName());
		client.setMiddleName(pClient.getMiddleName());
		client.setNameDataQuality(Integer.parseInt(pClient.getNameDataQuality().getValue()));
		client.setNameSuffix(pClient.getNameSuffix());
		client.setOtherGender(pClient.getOtherGender());
		client.setRace(Integer.parseInt(pClient.getRace().getValue()));
		client.setSsn(pClient.getSsn());
		client.setSsnDataQuality(Integer.parseInt(pClient.getSsnDataQuality().getValue()));
		client.setClientId(pClient.getId());

		copyBeanProperties(pClient,client);
	return client;
	}
}