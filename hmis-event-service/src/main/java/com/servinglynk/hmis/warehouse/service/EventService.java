package com.servinglynk.hmis.warehouse.service;

import com.servinglynk.hmis.warehouse.model.AMQEvent;

public interface EventService {
	void processEvent(AMQEvent event) throws Exception;
}
