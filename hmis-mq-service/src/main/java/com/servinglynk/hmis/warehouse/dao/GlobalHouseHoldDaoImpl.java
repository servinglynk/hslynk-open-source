package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.servinglynk.hmis.warehouse.entity.GlobalHouseHoldEntity;
import com.servinglynk.hmis.warehouse.entity.GlobalHouseHoldMapEntity;

@Component
public class GlobalHouseHoldDaoImpl implements GlobalHouseHoldDao {
	
	@Autowired EntityManager entityManager;
	
	
	@SuppressWarnings("unchecked")
	public GlobalHouseHoldEntity getGlobalHouseHold(String sourceSystemId,String sourceSystemHouseHoldId,String projectGroupCode) {
		Session session = entityManager.unwrap(Session.class);
		
		DetachedCriteria criteria = DetachedCriteria.forClass(GlobalHouseHoldMapEntity.class);
//		criteria.add(Restrictions.eq("sourceSystemId", sourceSystemId));
		criteria.add(Restrictions.eq("sourceSystemHouseHoldId", sourceSystemHouseHoldId));
		criteria.add(Restrictions.eq("projectGroupCode", projectGroupCode));
//		criteria.add(Restrictions.eq("deleted", false));
		List<GlobalHouseHoldMapEntity> entities = criteria.getExecutableCriteria(session).list();
		if(entities.isEmpty()) return null;
		return entities.get(0).getGlobalHouseHold();
	}
	
	
	public void createGlobalHouseHold(GlobalHouseHoldEntity entity) {
		entity.setId(UUID.randomUUID());
		Session session = entityManager.unwrap(Session.class);
		session.save(entity);
	}
	
	public void addGlobalHouseHoldMap(GlobalHouseHoldMapEntity entity) {
		entity.setId(UUID.randomUUID());
		Session session = entityManager.unwrap(Session.class);
		session.save(entity);
	}
	
	public void removeGlobalHouseHoldMap(GlobalHouseHoldMapEntity entity) {
		Session session = entityManager.unwrap(Session.class);
		session.update(entity);
	}
	
	@SuppressWarnings("unchecked")
	public List<GlobalHouseHoldMapEntity> getGlobalHouseHoldMapById(UUID hmisHouseHoldId,String projectGroupCode,String schemaYear) {
		Session session = entityManager.unwrap(Session.class);
		DetachedCriteria criteria = DetachedCriteria.forClass(GlobalHouseHoldMapEntity.class);
		criteria.add(Restrictions.eq("hmisHouseHoldId", hmisHouseHoldId));
		criteria.add(Restrictions.eq("projectGroupCode", projectGroupCode));
		criteria.add(Restrictions.eq("schemaYear", schemaYear));
		return criteria.getExecutableCriteria(session).list();
	}
}