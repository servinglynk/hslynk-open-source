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
import com.servinglynk.hmis.entity.BedOccupantEntity;
import com.servinglynk.hmis.entity.BedUnitEntity;
import com.servinglynk.hmis.entity.BedUnitReservationEntity;
import com.servinglynk.hmis.entity.RoomEntity;
import com.servinglynk.hmis.entity.RoomReservationEntity;
import com.servinglynk.hmis.entity.ShelterEntity;
import com.servinglynk.hmis.service.SecurityContextUtil;


@Component
public class SummaryDaoImpl implements SummaryDao {
	
	@Autowired EntityManager entityManager;
	
	public Long getBedCount(UUID roomId,UUID areaId,UUID shelterId) {
		Session session = entityManager.unwrap(Session.class);
		ProjectionList projectionList = Projections.projectionList();
		DetachedCriteria criteria = DetachedCriteria.forClass(BedUnitEntity.class);
		criteria.createAlias("room", "room");
		criteria.createAlias("area", "area");
		criteria.createAlias("shelter", "shelter");
		if(roomId!=null) {
			criteria.add(Restrictions.eq("room.id", roomId));
			criteria.add(Restrictions.eq("room.deleted", false));
		}
		if(areaId!=null) {
			criteria.add(Restrictions.eq("area.id", areaId));
			criteria.add(Restrictions.eq("area.deleted", false));
		}
		if(shelterId!=null) {
			criteria.add(Restrictions.eq("shelter.id", shelterId));
			criteria.add(Restrictions.eq("shelter.deleted", false));
		}
		
	    criteria.add(Restrictions.eq("projectGroupCode", SecurityContextUtil.getUserProjectGroup()));
	    criteria.add(Restrictions.eq("deleted", false));
		projectionList.add(Projections.rowCount());
		criteria.setProjection(projectionList);
		return (Long) criteria.getExecutableCriteria(session).uniqueResult();
	}
	
	
	public Long getRoomCount(UUID areaId,UUID shelterId) {
		Session session = entityManager.unwrap(Session.class);
		ProjectionList projectionList = Projections.projectionList();
		DetachedCriteria criteria = DetachedCriteria.forClass(RoomEntity.class);
		criteria.createAlias("area", "area");
		criteria.createAlias("shelter", "shelter");
		if(areaId!=null) {
			criteria.add(Restrictions.eq("area.id", areaId));
			criteria.add(Restrictions.eq("area.deleted", false));
		}
		if(shelterId!=null) {
			criteria.add(Restrictions.eq("shelter.id", shelterId));
			criteria.add(Restrictions.eq("shelter.deleted", false));
		}
		
	    criteria.add(Restrictions.eq("projectGroupCode", SecurityContextUtil.getUserProjectGroup()));
	    criteria.add(Restrictions.eq("deleted", false));
		projectionList.add(Projections.rowCount());
		criteria.setProjection(projectionList);
		return (Long) criteria.getExecutableCriteria(session).uniqueResult();
	}
	
	public Long getAreaCount(UUID shelterId) {
		Session session = entityManager.unwrap(Session.class);
		ProjectionList projectionList = Projections.projectionList();
		DetachedCriteria criteria = DetachedCriteria.forClass(AreaEntity.class);
		criteria.createAlias("shelter", "shelter");
		if(shelterId!=null) {
			criteria.add(Restrictions.eq("shelter.id", shelterId));
			criteria.add(Restrictions.eq("shelter.deleted", false));
		}
		
	    criteria.add(Restrictions.eq("projectGroupCode", SecurityContextUtil.getUserProjectGroup()));
	    criteria.add(Restrictions.eq("deleted", false));
		projectionList.add(Projections.rowCount());
		criteria.setProjection(projectionList);
		return (Long) criteria.getExecutableCriteria(session).uniqueResult();
	}
	
	public Long getShelterCount(UUID shelterId) {
		Session session = entityManager.unwrap(Session.class);
		ProjectionList projectionList = Projections.projectionList();
		DetachedCriteria criteria = DetachedCriteria.forClass(ShelterEntity.class);
		if(shelterId!=null) criteria.add(Restrictions.eq("id", shelterId));
		
	    criteria.add(Restrictions.eq("projectGroupCode", SecurityContextUtil.getUserProjectGroup()));
	    criteria.add(Restrictions.eq("deleted", false));
		projectionList.add(Projections.rowCount());
		criteria.setProjection(projectionList);
		return (Long) criteria.getExecutableCriteria(session).uniqueResult();
	}


	@Override
	public Long getReservedBeds(UUID bedId, UUID roomId, UUID areaId, UUID shelterId) {
		Session session = entityManager.unwrap(Session.class);
		ProjectionList projectionList = Projections.projectionList();
		DetachedCriteria criteria = DetachedCriteria.forClass(BedUnitReservationEntity.class);
		criteria.createAlias("room", "room");
		criteria.createAlias("area", "area");
		criteria.createAlias("shelter", "shelter");
		criteria.createAlias("bedUnit", "bedUnit");
		if(bedId!=null) {
			criteria.add(Restrictions.eq("bedUnit.id", bedId));
			criteria.add(Restrictions.eq("bedUnit.deleted", false));
		}
		if(roomId!=null) {
			criteria.add(Restrictions.eq("room.id", roomId));
			criteria.add(Restrictions.eq("room.deleted", false));
		}
		if(areaId!=null) {
			criteria.add(Restrictions.eq("area.id", areaId));
			criteria.add(Restrictions.eq("area.deleted", false));
		}
		if(shelterId!=null) {
			criteria.add(Restrictions.eq("shelter.id", shelterId));
			criteria.add(Restrictions.eq("shelter.deleted", false));
		}
		
	    criteria.add(Restrictions.eq("projectGroupCode", SecurityContextUtil.getUserProjectGroup()));
	    criteria.add(Restrictions.eq("deleted", false));
		projectionList.add(Projections.rowCount());
		criteria.setProjection(projectionList);
		return (Long) criteria.getExecutableCriteria(session).uniqueResult();
	}


	@Override
	public Long getOccupiedBeds(UUID bedId, UUID roomId, UUID areaId, UUID shelterId) {
		Session session = entityManager.unwrap(Session.class);
		ProjectionList projectionList = Projections.projectionList();
		DetachedCriteria criteria = DetachedCriteria.forClass(BedOccupantEntity.class);
		criteria.createAlias("room", "room");
		criteria.createAlias("area", "area");
		criteria.createAlias("shelter", "shelter");
		criteria.createAlias("bedUnit", "bedUnit");
		if(bedId!=null) {
			criteria.add(Restrictions.eq("bedUnit.id", bedId));
			criteria.add(Restrictions.eq("bedUnit.deleted", false));	
		}
		if(roomId!=null) {
			criteria.add(Restrictions.eq("room.id", roomId));
			criteria.add(Restrictions.eq("room.deleted", false));
		}
		if(areaId!=null) {
			criteria.add(Restrictions.eq("area.id", areaId));
			criteria.add(Restrictions.eq("area.deleted", false));
		}
		if(shelterId!=null) {
			criteria.add(Restrictions.eq("shelter.id", shelterId));
			criteria.add(Restrictions.eq("shelter.deleted", false));
		}
		
	    criteria.add(Restrictions.eq("projectGroupCode", SecurityContextUtil.getUserProjectGroup()));
	    criteria.add(Restrictions.eq("deleted", false));
		projectionList.add(Projections.rowCount());
		criteria.setProjection(projectionList);
		return (Long) criteria.getExecutableCriteria(session).uniqueResult();
	}					


	@Override
	public Long getReservedRooms(UUID roomId, UUID areaId, UUID shelterId) {
		Session session = entityManager.unwrap(Session.class);
		ProjectionList projectionList = Projections.projectionList();
		DetachedCriteria criteria = DetachedCriteria.forClass(RoomReservationEntity.class);
		criteria.createAlias("room", "room");
		criteria.createAlias("area", "area");
		criteria.createAlias("shelter", "shelter");

		if(roomId!=null) {
			criteria.add(Restrictions.eq("room.id", roomId));
			criteria.add(Restrictions.eq("room.deleted", false));
		}
		if(areaId!=null) {
			criteria.add(Restrictions.eq("area.id", areaId));
			criteria.add(Restrictions.eq("area.deleted", false));
		}
		if(shelterId!=null) {
			criteria.add(Restrictions.eq("shelter.id", shelterId));
			criteria.add(Restrictions.eq("shelter.deleted", false));
		}
		
	    criteria.add(Restrictions.eq("projectGroupCode", SecurityContextUtil.getUserProjectGroup()));
	    criteria.add(Restrictions.eq("deleted", false));
		projectionList.add(Projections.rowCount());
		criteria.setProjection(projectionList);
		return (Long) criteria.getExecutableCriteria(session).uniqueResult();
	}
}