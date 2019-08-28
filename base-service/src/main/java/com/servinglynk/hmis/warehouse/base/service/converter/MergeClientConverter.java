package com.servinglynk.hmis.warehouse.base.service.converter;

import java.time.ZoneId;
import java.util.Date;

import com.servinglynk.hmis.warehouse.core.model.MergeClient;

public class MergeClientConverter {
	public static com.servinglynk.hmis.warehouse.model.base.Client modelToEntity(MergeClient client,com.servinglynk.hmis.warehouse.model.base.Client pClient){
		if(pClient==null) pClient = new com.servinglynk.hmis.warehouse.model.base.Client(); 
	    if(client.getDob()!=null)
		pClient.setDob(client.getDob().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
	    if(client.getFirstName()!=null)
		pClient.setFirstName(client.getFirstName());
	    if(client.getLastName()!=null)
		pClient.setLastName(client.getLastName());
	    if(client.getSsn()!=null)
		pClient.setSsn(client.getSsn());

	    return pClient;
	}
	
	public static MergeClient entityToModel(com.servinglynk.hmis.warehouse.model.base.Client pClient){
		MergeClient client = new MergeClient();
	    if(pClient.getDob()!=null)
		client.setDob(Date.from(pClient.getDob().atZone(ZoneId.systemDefault()).toInstant()));
	    if(pClient.getFirstName()!=null)
		client.setFirstName(pClient.getFirstName());
	    if(pClient.getLastName()!=null)
		client.setLastName(pClient.getLastName());
	    if(pClient.getSsn()!=null)
		client.setSsn(pClient.getSsn());
	    if(pClient.getId()!=null)
	    client.setClientId(pClient.getId());
	    if(pClient.getDedupClientId()!=null)
	    client.setDedupClientId(pClient.getDedupClientId());
	    
	    return client;
	}
}
