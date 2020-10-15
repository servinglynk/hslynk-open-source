package com.servinglynk.hmis.service;

import java.util.ArrayList;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.servinglynk.hmis.entity.SubscriptionEntity;
import com.servinglynk.hmis.model.SortedPagination;
import com.servinglynk.hmis.model.SubscriptionModel;
import com.servinglynk.hmis.model.Subscriptions;
import com.servinglynk.hmis.service.converter.SubscriptionConverter;
import com.servinglynk.hmis.service.exception.ResourceNotFoundException;

@Service
public class SubscriptionServiceImpl extends BaseService implements SubscriptionService {

	@Transactional
	public SubscriptionModel registerSubscription(SubscriptionModel subscription) {
		SubscriptionEntity entity = SubscriptionConverter.modelToEntity(subscription, null);
		daoFactory.getSubscriptionRepository().save(entity);
		SubscriptionModel returnModel = new SubscriptionModel();
		returnModel.setId(entity.getId());
		return returnModel;
	}

	@Transactional
	public void updateSubscription(SubscriptionModel subscription) {
		SubscriptionEntity entity = daoFactory.getSubscriptionRepository().findOne(subscription.getId());
		if(entity ==null) throw new ResourceNotFoundException("subscription not found "+subscription.getId());
		daoFactory.getSubscriptionContactRepository().delete(entity.getContactEntities());
		entity.setContactEntities(null);
		SubscriptionEntity entity1 = SubscriptionConverter.modelToEntity(subscription, entity);

		daoFactory.getSubscriptionRepository().save(entity1);
	}

	@Transactional
	public void deleteSubscription(UUID subscriptionid) {
		SubscriptionEntity entity = daoFactory.getSubscriptionRepository().findOne(subscriptionid);
		if(entity ==null) throw new ResourceNotFoundException("subscription not found "+subscriptionid);
		daoFactory.getSubscriptionRepository().delete(entity);
	}

	@Transactional
	public SubscriptionModel getSubscriptionById(UUID subscriptionid) {
		SubscriptionEntity entity = daoFactory.getSubscriptionRepository().findOne(subscriptionid);
		if(entity ==null) throw new ResourceNotFoundException("subscription not found "+subscriptionid);
		return SubscriptionConverter.entityToModel(entity);
	}

	@Transactional
	public Subscriptions getAllSubscriptions(Pageable pageable) {
		Subscriptions subscriptions = new Subscriptions();
		Page<SubscriptionEntity> subscriptionEntities = daoFactory.getSubscriptionRepository().findAll(pageable);
		for(SubscriptionEntity entity : subscriptionEntities.getContent()) {
			subscriptions.addSubscription(SubscriptionConverter.entityToModel(entity));
		}
		   SortedPagination pagination = new SortedPagination();
		   
	        pagination.setFrom(pageable.getPageNumber() * pageable.getPageSize());
	        pagination.setReturned(subscriptionEntities.getContent().size());
	        pagination.setTotal((int)subscriptionEntities.getTotalElements());
	        subscriptions.setPagination(pagination);
		return subscriptions;
	}

	
	
}
