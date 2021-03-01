package com.servinglynk.hmis.warehouse.service;

import java.util.Map;

public interface SubscriptionService {
	
	void processSubscriptionEvent(Map<String, Object> requestData);
}
