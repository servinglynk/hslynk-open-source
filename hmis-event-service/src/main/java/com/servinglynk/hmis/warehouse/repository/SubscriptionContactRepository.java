package com.servinglynk.hmis.warehouse.repository;

import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.entity.SubscriptionContactEntity;
import com.servinglynk.hmis.entity.SubscriptionEntity;

public interface SubscriptionContactRepository extends BaseRepository<SubscriptionContactEntity,UUID> {

	List<SubscriptionContactEntity> findBySubscription(SubscriptionEntity subscriptionEntity);
	
}
