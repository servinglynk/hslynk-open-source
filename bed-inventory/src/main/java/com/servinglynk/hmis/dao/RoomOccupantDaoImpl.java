package com.servinglynk.hmis.dao;

import java.util.ArrayList;
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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.servinglynk.hmis.entity.RoomOccupantEntity;
import com.servinglynk.hmis.service.SecurityContextUtil;

@Component
public class RoomOccupantDaoImpl implements RoomOccupantDao {
	
	@Autowired EntityManager entityManager;

	@Override
	public RoomOccupantEntity getClinetRoomOccupants(UUID clientId, UUID roomId) {
		Session session = entityManager.unwrap(Session.class);
		DetachedCriteria criteria = DetachedCriteria.forClass(RoomOccupantEntity.class);
		criteria.createAlias("room", "room");
		criteria.add(Restrictions.eq("room.id", roomId));
		criteria.add(Restrictions.eq("clientId", clientId));
		criteria.add(Restrictions.isNull("checkOutDate"));
		criteria.add(Restrictions.eq("deleted", false));
		criteria.add(Restrictions.eq("projectGroupCode", SecurityContextUtil.getUserProjectGroup()));
		List<RoomOccupantEntity> occupantEntities = criteria.getExecutableCriteria(session).list();
		if(occupantEntities.isEmpty()) return null;
		return occupantEntities.get(0);
	}

	@Override
	public Page<RoomOccupantEntity> getRoomOccupants(UUID roomid, Date fromdate, Date todate, Pageable pageable) {
		Session session = entityManager.unwrap(Session.class);
		DetachedCriteria criteria = DetachedCriteria.forClass(RoomOccupantEntity.class);
		criteria.createAlias("room", "room");
		criteria.add(Restrictions.eq("room.id", roomid));
		 Disjunction disjunction = Restrictions.disjunction();
		if(fromdate!=null && todate != null) {
			disjunction.add(Restrictions.between("occupancyStartDate", fromdate, todate));
			disjunction.add(Restrictions.between("occupancyEndDate", fromdate, todate));
			criteria.add(disjunction);
		} else if(fromdate!=null) {
			criteria.add(Restrictions.lt("occupancyStartDate", fromdate));
			criteria.add(Restrictions.gt("occupancyEndDate",  fromdate));
		} else if(todate!=null) {
			criteria.add(Restrictions.lt("occupancyStartDate", todate));
			criteria.add(Restrictions.gt("occupancyEndDate", todate));
		}
		criteria.add(Restrictions.eq("deleted", false));
		criteria.add(Restrictions.eq("projectGroupCode", SecurityContextUtil.getUserProjectGroup()));
		
		  DetachedCriteria countCriteria = criteria;
		    List<RoomOccupantEntity> entities = new ArrayList<RoomOccupantEntity>();
		    
		    if (pageable!=null) {
			  entities = criteria.getExecutableCriteria(session).
				   setMaxResults(pageable.getPageSize()).setFirstResult(pageable.getPageSize()*pageable.getPageNumber()).list();
		    }
		  
		    countCriteria.setProjection(Projections.rowCount());
		   
			Long count = (Long)countCriteria.getExecutableCriteria(session).uniqueResult();
			
			return new PageImpl<RoomOccupantEntity>(entities,pageable,count);
	}

}
