package com.servinglynk.hmis.warehouse.service;

public interface ServiceFactory {

	EventService getEventService();
	SubscriptionService getSubscriptionService();
}
