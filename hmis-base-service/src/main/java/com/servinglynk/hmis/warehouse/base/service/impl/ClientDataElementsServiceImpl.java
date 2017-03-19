package com.servinglynk.hmis.warehouse.base.service.impl;

import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.base.service.ClientDataElementsService;
import com.servinglynk.hmis.warehouse.core.model.Parameter;
import com.servinglynk.hmis.warehouse.core.model.Parameters;
import com.servinglynk.hmis.warehouse.model.base.ClientDataElementsEntity;

public class ClientDataElementsServiceImpl extends ServiceBase implements ClientDataElementsService {

	public Parameters getClientDataElements(UUID clientId){
		List<ClientDataElementsEntity> elementsEntities = daoFactory.getClientDataElementDao().getClientDataElements(clientId);
		
		Parameters parameters = new Parameters();
		for(ClientDataElementsEntity elementsEntity : elementsEntities){
			Parameter parameter = new Parameter();
			parameter.setKey(elementsEntity.getDataElementName());
			parameter.setValue(elementsEntity.getDataElementValue());
			parameters.addParameter(parameter);
		}
		return parameters;
	}	
}