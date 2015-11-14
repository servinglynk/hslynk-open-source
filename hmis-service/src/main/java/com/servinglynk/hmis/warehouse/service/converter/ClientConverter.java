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

public class ClientConverter {

	public static com.servinglynk.hmis.warehouse.model.live.Client modelToEntity(Client client,com.servinglynk.hmis.warehouse.model.live.Client pClient){
		if(pClient==null) pClient = new com.servinglynk.hmis.warehouse.model.live.Client(); 


		pClient.setDob(client.getDob().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
		pClient.setDobDataQuality(ClientDobDataQualityEnum.valueOf(client.getDobDataQuality()));
		pClient.setEthnicity(ClientEthnicityEnum.valueOf(client.getEthnicity()+""));
		pClient.setFirstName(client.getFirstName());
		pClient.setGender(ClientGenderEnum.valueOf(client.getGender()+""));
		pClient.setLastName(client.getLastName());
		pClient.setMiddleName(client.getMiddleName());
		pClient.setNameDataQuality(ClientNameDataQualityEnum.valueOf(client.getNameDataQuality()+""));
		pClient.setNameSuffix(client.getNameSuffix());
		pClient.setOtherGender(client.getOtherGender());
		pClient.setRace(ClientRaceEnum.valueOf(client.getRace()+""));
		pClient.setSsn(client.getSsn());
		pClient.setSsnDataQuality(ClientSsnDataQualityEnum.valueOf(client.getSsnDataQuality()+""));
		
		return pClient;
	}
	
	public static Client entityToModel(com.servinglynk.hmis.warehouse.model.live.Client pClient){
		Client client = new Client();

		client.setDob(Date.from(pClient.getDob().atZone(ZoneId.systemDefault()).toInstant()));
		client.setDobDataQuality(pClient.getDobDataQuality().getValue());
		client.setEthnicity(pClient.getEthnicity().getValue());
		client.setFirstName(pClient.getFirstName());
		client.setGender(pClient.getGender().getValue());
		client.setLastName(pClient.getLastName());
		client.setMiddleName(pClient.getMiddleName());
		client.setNameDataQuality(pClient.getNameDataQuality().getValue());
		client.setNameSuffix(pClient.getNameSuffix());
		client.setOtherGender(pClient.getOtherGender());
		client.setRace(pClient.getRace().getValue());
		client.setSsn(pClient.getSsn());
		client.setSsnDataQuality(pClient.getSsnDataQuality().getValue());

	
	return client;
	}
}