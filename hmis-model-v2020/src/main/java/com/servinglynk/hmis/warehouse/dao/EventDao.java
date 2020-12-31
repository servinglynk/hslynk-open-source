/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.model.v2020.Event;

/**
 * @author Sandeep
 *
 */
public interface EventDao extends ParentDao {

	
	   com.servinglynk.hmis.warehouse.model.v2020.Event createEvent(com.servinglynk.hmis.warehouse.model.v2020.Event Event);
	   com.servinglynk.hmis.warehouse.model.v2020.Event updateEvent(com.servinglynk.hmis.warehouse.model.v2020.Event Event);
	   void deleteEvent(com.servinglynk.hmis.warehouse.model.v2020.Event Event);
	   com.servinglynk.hmis.warehouse.model.v2020.Event getEventById(UUID EventId);
	   List<Event> getAllEnrollmentEvents(UUID enrollmentId, Integer startIndex, Integer maxItems);
	   long getEnrollmentEventsCount(UUID enrollmentId);
}
