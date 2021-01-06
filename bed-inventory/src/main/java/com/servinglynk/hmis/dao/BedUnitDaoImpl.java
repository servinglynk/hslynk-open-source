package com.servinglynk.hmis.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.servinglynk.hmis.entity.BedUnitEntity;
import com.servinglynk.hmis.entity.RoomEntity;
import com.servinglynk.hmis.service.SecurityContextUtil;

@Component
public class BedUnitDaoImpl implements BedUnitDao {
	
	@Autowired EntityManager entityManager;

	@Override
	public Page<BedUnitEntity> getAllBedunits(RoomEntity roomEntity, String q, Pageable pageable) {
		Session session = entityManager.unwrap(Session.class);
		DetachedCriteria criteria = DetachedCriteria.forClass(BedUnitEntity.class);
	    Disjunction disjunction = Restrictions.disjunction();
	    disjunction.add(Restrictions.ilike("name", q,MatchMode.ANYWHERE));

	    criteria.add(disjunction);
	    criteria.add(Restrictions.eq("projectGroupCode", SecurityContextUtil.getUserProjectGroup()));
	    criteria.add(Restrictions.eq("deleted", false));
	    
	    DetachedCriteria countCriteria = criteria;
	    List<BedUnitEntity> entities = criteria.getExecutableCriteria(session).
			   setMaxResults(pageable.getPageSize()).setFirstResult(pageable.getPageSize()*pageable.getPageNumber()).list();
	  
	    countCriteria.setProjection(Projections.rowCount());
	   
		Long count = (Long)countCriteria.getExecutableCriteria(session).uniqueResult();
		return new PageImpl<BedUnitEntity>(entities,pageable,count);
	}

}
