package com.servinglynk.hmis.dao;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.servinglynk.hmis.entity.BedUnitReservationEntity;
import com.servinglynk.hmis.entity.RoomReservationEntity;
import com.servinglynk.hmis.service.SecurityContextUtil;

@Component
public class BedUnitReservationDaoImpl implements BedUnitReservationDao {
	
	@Autowired EntityManager entityManager;
	
	
	public PageImpl<BedUnitReservationEntity> getBedUnits(UUID bedUnitId, Date fromdate,Date todate,Pageable pageable) {
		Session session = entityManager.unwrap(Session.class);
		DetachedCriteria criteria = DetachedCriteria.forClass(BedUnitReservationEntity.class);
		criteria.createAlias("bedUnit", "bedUnit");
		criteria.add(Restrictions.eq("bedUnit.id", bedUnitId));
		 Disjunction disjunction = Restrictions.disjunction();
		if(fromdate!=null && todate != null) {
			disjunction.add(Restrictions.between("reservationStateDate", fromdate, todate));
			disjunction.add(Restrictions.between("reservationEndDateDate", fromdate, todate));
			criteria.add(disjunction);
		} else if(fromdate!=null) {
			criteria.add(Restrictions.lt("reservationStateDate", fromdate));
			criteria.add(Restrictions.gt("reservationEndDateDate",  fromdate));
		} else if(todate!=null) {
			criteria.add(Restrictions.lt("reservationStateDate", todate));
			criteria.add(Restrictions.gt("reservationEndDateDate", todate));
		}
		criteria.add(Restrictions.eq("deleted", false));
		criteria.add(Restrictions.eq("projectGroupCode", SecurityContextUtil.getUserProjectGroup()));
		
		  DetachedCriteria countCriteria = criteria;
		    List<BedUnitReservationEntity> entities = criteria.getExecutableCriteria(session).
				   setMaxResults(pageable.getPageSize()).setFirstResult(pageable.getPageSize()*pageable.getPageNumber()).list();
		  
		    countCriteria.setProjection(Projections.rowCount());
		   
			Long count = (Long)countCriteria.getExecutableCriteria(session).uniqueResult();
			
			return new PageImpl<BedUnitReservationEntity>(entities,pageable,count);
		
	}
	
	public PageImpl<BedUnitReservationEntity> getClientBedUnitReservations(UUID clientDedupId, Date fromdate,Date todate,Pageable pageable) {
		Session session = entityManager.unwrap(Session.class);
		DetachedCriteria criteria = DetachedCriteria.forClass(BedUnitReservationEntity.class);
		criteria.add(Restrictions.eq("reservedCleintDedupId", clientDedupId));
		 Disjunction disjunction = Restrictions.disjunction();
		if(fromdate!=null && todate != null) {
			disjunction.add(Restrictions.between("reservationStateDate", fromdate, todate));
			disjunction.add(Restrictions.between("reservationEndDateDate", fromdate, todate));
			criteria.add(disjunction);
		} else if(fromdate!=null) {
			criteria.add(Restrictions.lt("reservationStateDate", fromdate));
			criteria.add(Restrictions.gt("reservationEndDateDate",  fromdate));
		} else if(todate!=null) {
			criteria.add(Restrictions.lt("reservationStateDate", todate));
			criteria.add(Restrictions.gt("reservationEndDateDate", todate));
		}
		criteria.add(Restrictions.eq("deleted", false));
		criteria.add(Restrictions.eq("projectGroupCode", SecurityContextUtil.getUserProjectGroup()));
		
		  DetachedCriteria countCriteria = criteria;
		    List<BedUnitReservationEntity> entities = criteria.getExecutableCriteria(session).
				   setMaxResults(pageable.getPageSize()).setFirstResult(pageable.getPageSize()*pageable.getPageNumber()).list();
		  
		    countCriteria.setProjection(Projections.rowCount());
		   
			Long count = (Long)countCriteria.getExecutableCriteria(session).uniqueResult();
			
			return new PageImpl<BedUnitReservationEntity>(entities,pageable,count);
		
	}

	@Override
	public Boolean checkBedUnitOrRoomReservation(UUID bedUnitId, UUID roomId, Date startDate, Date endDate,
			UUID clientId) {
		Session session = entityManager.unwrap(Session.class);
		DetachedCriteria criteria = DetachedCriteria.forClass(BedUnitReservationEntity.class);
		criteria.createAlias("bedUnit", "bedUnit");
		criteria.add(Restrictions.eq("bedUnit.id", bedUnitId));
		criteria.add(Restrictions.eq("reservationStateDate", startDate));
		criteria.add(Restrictions.eq("reservationEndDateDate", endDate));
		criteria.add(Restrictions.eq("reservedCleintId", clientId));
		criteria.add(Restrictions.eq("deleted", false));
		criteria.add(Restrictions.eq("projectGroupCode", SecurityContextUtil.getUserProjectGroup()));
		criteria.setProjection(Projections.rowCount());
		Long count = (Long)criteria.getExecutableCriteria(session).uniqueResult();
		
		if(count == 0L) {
			DetachedCriteria roomCriteria = DetachedCriteria.forClass(RoomReservationEntity.class);
			roomCriteria.createAlias("room", "room");
			roomCriteria.add(Restrictions.eq("room.id", roomId));
			roomCriteria.add(Restrictions.eq("reservationStateDate", startDate));
			roomCriteria.add(Restrictions.eq("reservationEndDateDate", endDate));
			roomCriteria.add(Restrictions.eq("reservedCleintId", clientId));
			roomCriteria.add(Restrictions.eq("deleted", false));
			roomCriteria.add(Restrictions.eq("projectGroupCode", SecurityContextUtil.getUserProjectGroup()));
			roomCriteria.setProjection(Projections.rowCount());
			Long roomReservationCount = (Long)roomCriteria.getExecutableCriteria(session).uniqueResult();
			if(roomReservationCount == 0L) return false;
		}
		
		return true;
	}
}
