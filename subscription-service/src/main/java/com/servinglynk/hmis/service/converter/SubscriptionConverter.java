package com.servinglynk.hmis.service.converter;

import java.time.ZoneId;
import java.util.Date;

import com.servinglynk.hmis.entity.SubscriptionContactEntity;
import com.servinglynk.hmis.entity.SubscriptionEntity;
import com.servinglynk.hmis.model.SubscriptionChannel;
import com.servinglynk.hmis.model.SubscriptionContact;
import com.servinglynk.hmis.model.SubscriptionModel;

public class SubscriptionConverter {

	
	public static SubscriptionEntity modelToEntity(SubscriptionModel model,SubscriptionEntity entity) {
	     if(entity  == null ) {
	    	 entity = new SubscriptionEntity();
	    	 entity.setStatus("active");
	     }
		if(model.getReason()!=null) entity.setReason(model.getReason());
		if(model.getCriteria()!=null) entity.setCriteria(model.getCriteria());
		if(model.getCriteria()!=null) entity.setCriteriaUrl(model.getCriteria().substring(0, model.getCriteria().indexOf("?")));
		if(model.getResourceType()!=null) entity.setResourceType(model.getResourceType());
		if(model.getEnd()!=null) entity.setEnd(model.getEnd().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());

		if(model.getChannel()!=null) {
			if(model.getChannel().getEndpoint()!=null) entity.setChannelEndpoint(model.getChannel().getEndpoint());
			if(model.getChannel().getHeader()!=null) entity.setChannelHeader(model.getChannel().getHeader());
			if(model.getChannel().getPayload()!=null) entity.setChannelPayload(model.getChannel().getPayload());
			if(model.getChannel().getType()!=null) entity.setChannelType(model.getChannel().getType());
		}
	
		for(SubscriptionContact contact : model.getContact()) {
			SubscriptionContactEntity conEntity = new SubscriptionContactEntity();
			conEntity.setSubscription(entity);
			conEntity.setSystem(contact.getSystem());
			conEntity.setValue(contact.getValue());
			entity.getContactEntities().add(conEntity);
		}
		return entity;
	}
	
	public static SubscriptionModel entityToModel(SubscriptionEntity entity) {
		SubscriptionModel model = new SubscriptionModel();
		
		if(entity.getReason()!=null) model.setReason(entity.getReason());
		if(entity.getCriteria()!=null) model.setCriteria(entity.getCriteria());
		if(entity.getResourceType()!=null) model.setResourceType(entity.getResourceType());
		if(entity.getId()!=null) model.setId(entity.getId());
		 if(entity.getEnd()!=null)
				model.setEnd(Date.from(entity.getEnd().atZone(ZoneId.systemDefault()).toInstant()));
		SubscriptionChannel channel = new SubscriptionChannel();
			if(entity.getChannelEndpoint()!=null) channel.setEndpoint(entity.getChannelEndpoint());
			if(entity.getChannelHeader()!=null) channel.setHeader(entity.getChannelHeader());
			if(entity.getChannelPayload()!=null) channel.setPayload(entity.getChannelPayload());
			if(entity.getChannelType()!=null) channel.setType(entity.getChannelType());

			model.setChannel(channel);
		for(SubscriptionContactEntity contactEntity : entity.getContactEntities())	{
			SubscriptionContact contact = new SubscriptionContact();
			contact.setSystem(contactEntity.getSystem());
			contact.setValue(contactEntity.getValue());
			model.getContact().add(contact);
		}
		return model;
	}
	
}
