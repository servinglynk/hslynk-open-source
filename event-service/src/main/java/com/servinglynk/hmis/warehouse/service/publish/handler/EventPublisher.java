package com.servinglynk.hmis.warehouse.service.publish.handler;

import com.servinglynk.hmis.entity.SubscriptionEntity;

public interface EventPublisher {

	public void publish(SubscriptionEntity entity);
	
}
