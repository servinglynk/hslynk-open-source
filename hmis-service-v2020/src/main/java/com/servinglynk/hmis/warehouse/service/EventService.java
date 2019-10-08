package com.servinglynk.hmis.warehouse.service;

import java.util.UUID;

import com.servinglynk.hmis.warehouse.core.model.Event;
import com.servinglynk.hmis.warehouse.core.model.Events;

public interface EventService {
	
	   Event createEvent(Event Event,UUID enrollmentId,String caller);
	   Event updateEvent(Event Event,UUID enrollmentId,String caller);
	   Event deleteEvent(UUID EventId,String caller);
	   Event getEventById(UUID EventId);
	   Events getAllEnrollmentEvents(UUID enrollmentId,Integer startIndex, Integer maxItems);
}
