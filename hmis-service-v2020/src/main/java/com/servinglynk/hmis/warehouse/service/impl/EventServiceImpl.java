package com.servinglynk.hmis.warehouse.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.SortedPagination;
import com.servinglynk.hmis.warehouse.core.model.Event;
import com.servinglynk.hmis.warehouse.core.model.Events;
import com.servinglynk.hmis.warehouse.service.EventService;
import com.servinglynk.hmis.warehouse.service.converter.EventConverter;
import com.servinglynk.hmis.warehouse.service.exception.EnrollmentNotFound;
import com.servinglynk.hmis.warehouse.service.exception.EventsNotFoundException;


public class EventServiceImpl extends ServiceBase implements EventService  {

   @Transactional
   public Event createEvent(Event Event,UUID enrollmentId,String caller){
       com.servinglynk.hmis.warehouse.model.v2020.Event pEvent = EventConverter.modelToEntity(Event, null);
       com.servinglynk.hmis.warehouse.model.v2020.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollmentId);
       if(pEnrollment == null) throw new EnrollmentNotFound();
       pEvent.setEnrollmentid(pEnrollment);
       pEvent.setDateCreated(LocalDateTime.now());
       daoFactory.getProjectDao().populateUserProjectGroupCode(pEvent, caller);
       daoFactory.getEventDao().createEvent(pEvent);
       pEvent.setId(pEvent.getId());
       Event entityToModel = EventConverter.entityToModel(pEvent);
       return entityToModel;
   }


   @Transactional
   public Event updateEvent(Event Event,UUID enrollmentId,String caller){
       com.servinglynk.hmis.warehouse.model.v2020.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollmentId);
       if(pEnrollment == null) throw new EnrollmentNotFound();
       com.servinglynk.hmis.warehouse.model.v2020.Event pEvent = daoFactory.getEventDao().getEventById(Event.getEventId());
       if(pEvent==null) throw new EventsNotFoundException();

       EventConverter.modelToEntity(Event, pEvent);
       pEvent.setEnrollmentid(pEnrollment);
       pEvent.setDateUpdated(LocalDateTime.now());
       pEvent.setUserId(daoFactory.getHmisUserDao().findByUsername(caller).getId());
       daoFactory.getEventDao().updateEvent(pEvent);
       Event.setEventId(pEvent.getId());
       return Event;
   }


   @Transactional
   public Event deleteEvent(UUID EventId,String caller){
       com.servinglynk.hmis.warehouse.model.v2020.Event pEvent = daoFactory.getEventDao().getEventById(EventId);
       if(pEvent==null) throw new EventsNotFoundException();

       daoFactory.getEventDao().deleteEvent(pEvent);
       return new Event();
   }


   @Transactional
   public Event getEventById(UUID EventId){
       com.servinglynk.hmis.warehouse.model.v2020.Event pEvent = daoFactory.getEventDao().getEventById(EventId);
       if(pEvent==null) throw new EventsNotFoundException();
       return EventConverter.entityToModel( pEvent );
   }


   @Transactional
   @Override
   public Events getAllEnrollmentEvents(UUID enrollmentId,Integer startIndex, Integer maxItems){
       Events events = new Events();
        List<com.servinglynk.hmis.warehouse.model.v2020.Event> entities = daoFactory.getEventDao().getAllEnrollmentEvents(enrollmentId,startIndex,maxItems);
        for(com.servinglynk.hmis.warehouse.model.v2020.Event entity : entities){
        	events.addEvent(EventConverter.entityToModel(entity));
        }
        long count = daoFactory.getEventDao().getEnrollmentEventsCount(enrollmentId);
        SortedPagination pagination = new SortedPagination();

        pagination.setFrom(startIndex);
        pagination.setReturned(events.getEvents().size());
        pagination.setTotal((int)count);
        events.setPagination(pagination);
        return events;
   }
}
