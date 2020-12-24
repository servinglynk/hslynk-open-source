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

import com.servinglynk.hmis.entity.ShelterEntity;
import com.servinglynk.hmis.service.SecurityContextUtil;

@Component
public class ShelterDaoImpl implements ShelterDao{
	
	@Autowired EntityManager entityManager;
	
	
	public Page<ShelterEntity> getAllShelters(String q,Pageable pageable){
		Session session = entityManager.unwrap(Session.class);
		DetachedCriteria criteria = DetachedCriteria.forClass(ShelterEntity.class);
	    Disjunction disjunction = Restrictions.disjunction();
	    disjunction.add(Restrictions.ilike("name", q,MatchMode.ANYWHERE));
	    disjunction.add(Restrictions.ilike("address", q,MatchMode.ANYWHERE));
	    disjunction.add(Restrictions.ilike("address1", q,MatchMode.ANYWHERE));
	    disjunction.add(Restrictions.ilike("address2", q,MatchMode.ANYWHERE));
	    disjunction.add(Restrictions.ilike("city", q,MatchMode.ANYWHERE));
	    disjunction.add(Restrictions.ilike("state", q,MatchMode.ANYWHERE));
	    disjunction.add(Restrictions.ilike("zipcode", q,MatchMode.ANYWHERE));
		
	    criteria.add(disjunction);
	    criteria.add(Restrictions.eq("projectGroupCode", SecurityContextUtil.getUserProjectGroup()));
	    criteria.add(Restrictions.eq("deleted", false));
	    
//	    SecurityContextUtil.getUserProjectGroup(),false
	    DetachedCriteria countCriteria = criteria;
	    List<ShelterEntity> entities = criteria.getExecutableCriteria(session).
			   setMaxResults(pageable.getPageSize()).setFirstResult(pageable.getPageSize()*pageable.getPageNumber()).list();
	  
	    countCriteria.setProjection(Projections.rowCount());
	   
		Long count = (Long)countCriteria.getExecutableCriteria(session).uniqueResult();
		return new PageImpl<ShelterEntity>(entities,pageable,count);
	}

}
