package com.servinglynk.hmis.dao;

import java.util.UUID;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.servinglynk.hmis.entity.AreaEntity;
import com.servinglynk.hmis.entity.BedUnitEntity;
import com.servinglynk.hmis.entity.RoomEntity;
import com.servinglynk.hmis.entity.ShelterEntity;


@Component
public class SummaryDaoImpl implements SummaryDao {
	
	@Autowired EntityManager entityManager;
	
	public Long getBedCount(UUID roomId,UUID areaId,UUID ShelterId) {
		Session session = entityManager.unwrap(Session.class);
		ProjectionList projectionList = Projections.projectionList();
		DetachedCriteria criteria = DetachedCriteria.forClass(BedUnitEntity.class);
		criteria.createAlias("room", "room");
		criteria.createAlias("area", "area");
		criteria.createAlias("shelter", "shelter");
		if(roomId!=null) criteria.add(Restrictions.eq("room.id", roomId));
		if(areaId!=null) criteria.add(Restrictions.eq("area.id", areaId));
		if(ShelterId!=null) criteria.add(Restrictions.eq("shelter.id", ShelterId));
		projectionList.add(Projections.rowCount());
		criteria.setProjection(projectionList);
		return (Long) criteria.getExecutableCriteria(session).uniqueResult();
	}
	
	
	public Long getRoomCount(UUID areaId,UUID ShelterId) {
		Session session = entityManager.unwrap(Session.class);
		ProjectionList projectionList = Projections.projectionList();
		DetachedCriteria criteria = DetachedCriteria.forClass(RoomEntity.class);
		criteria.createAlias("areaEntity", "areaEntity");
		criteria.createAlias("shelterEntity", "shelterEntity");
		if(areaId!=null) criteria.add(Restrictions.eq("areaEntity.id", areaId));
		if(ShelterId!=null) criteria.add(Restrictions.eq("shelterEntity.id", ShelterId));
		projectionList.add(Projections.rowCount());
		criteria.setProjection(projectionList);
		return (Long) criteria.getExecutableCriteria(session).uniqueResult();
	}
	
	public Long getAreaCount(UUID shelterId) {
		Session session = entityManager.unwrap(Session.class);
		ProjectionList projectionList = Projections.projectionList();
		DetachedCriteria criteria = DetachedCriteria.forClass(AreaEntity.class);
		criteria.createAlias("shelterEntity", "shelterEntity");
		if(shelterId!=null) criteria.add(Restrictions.eq("shelterEntity.id", shelterId));
		projectionList.add(Projections.rowCount());
		criteria.setProjection(projectionList);
		return (Long) criteria.getExecutableCriteria(session).uniqueResult();
	}
	
	public Long getShelterCount(UUID shelterId) {
		Session session = entityManager.unwrap(Session.class);
		ProjectionList projectionList = Projections.projectionList();
		DetachedCriteria criteria = DetachedCriteria.forClass(ShelterEntity.class);
		if(shelterId!=null) criteria.add(Restrictions.eq("id", shelterId));
		projectionList.add(Projections.rowCount());
		criteria.setProjection(projectionList);
		return (Long) criteria.getExecutableCriteria(session).uniqueResult();
	}


	@Override
	public Long getReservedBeds(UUID bedId, UUID roomId, UUID areaId, UUID shelterId) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Long getOccupiedBeds(UUID bedId, UUID roomId, UUID areaId, UUID shelterId) {
		// TODO Auto-generated method stub
		return null;
	}					


	@Override
	public Long getReservedRooms(UUID roomId, UUID areaId, UUID shelterId) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Long getVacantBeds(UUID bedId, UUID roomId, UUID areaId, UUID shelterId) {
		// TODO Auto-generated method stub
		return null;
	}
}