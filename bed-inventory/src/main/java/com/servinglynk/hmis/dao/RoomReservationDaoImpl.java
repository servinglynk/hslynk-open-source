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

import com.servinglynk.hmis.entity.RoomReservationEntity;
import com.servinglynk.hmis.service.SecurityContextUtil;

@Component
public class RoomReservationDaoImpl implements RoomReservationDao {
	
	@Autowired EntityManager entityManager;

	public PageImpl<RoomReservationEntity> getRoomReservations(UUID roomId, Date fromdate, Date todate,
			Pageable pageable) {
		
		Session session = entityManager.unwrap(Session.class);
		DetachedCriteria criteria = DetachedCriteria.forClass(RoomReservationEntity.class);
		criteria.createAlias("room", "room");
		criteria.add(Restrictions.eq("room.id", roomId));
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
		    List<RoomReservationEntity> entities = criteria.getExecutableCriteria(session).
				   setMaxResults(pageable.getPageSize()).setFirstResult(pageable.getPageSize()*pageable.getPageNumber()).list();
		  
		    countCriteria.setProjection(Projections.rowCount());
		   
			Long count = (Long)countCriteria.getExecutableCriteria(session).uniqueResult();
			
			return new PageImpl<RoomReservationEntity>(entities,pageable,count);

	}

}
