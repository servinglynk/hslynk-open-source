package com.servinglynk.hmis.warehouse.base.dao;

import java.util.List;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.servinglynk.hmis.warehouse.model.base.GlobalEnrollmentEntity;
import com.servinglynk.hmis.warehouse.model.base.GlobalEnrollmentsMapEntity;

public class GlobalEnrollmentDaoImpl extends QueryExecutorImpl implements GlobalEnrollmentDao {

	public GlobalEnrollmentEntity create(GlobalEnrollmentEntity entity) {
		entity.setId(UUID.randomUUID());
		insert(entity);
		return entity;
	}
	
	public void update(GlobalEnrollmentEntity entity) {
		update(entity);
	}
	
	public GlobalEnrollmentEntity getById(UUID id) {
		DetachedCriteria criteria = DetachedCriteria.forClass(GlobalEnrollmentEntity.class);
		criteria.add(Restrictions.eq("id", id));
		List<GlobalEnrollmentEntity> entities = (List<GlobalEnrollmentEntity>) findByCriteria(criteria);
		if(!entities.isEmpty()) return entities.get(0);
		return null;
	}
	
	public List<GlobalEnrollmentEntity> getAllGlobalEnrollments(UUID dedupClientId,Integer start,Integer maxItems){
		DetachedCriteria criteria = DetachedCriteria.forClass(GlobalEnrollmentEntity.class);
		if(dedupClientId!=null) criteria.add(Restrictions.eq("dedupClientId",dedupClientId));
		return (List<GlobalEnrollmentEntity>) findByCriteria(criteria,start,maxItems);
	}
	
	public Long getAllGlobalEnrollmentsCount(UUID dedupClientId){
		DetachedCriteria criteria = DetachedCriteria.forClass(GlobalEnrollmentEntity.class);
		if(dedupClientId!=null) criteria.add(Restrictions.eq("dedupClientId",dedupClientId));
		return countRows(criteria);
	}
	
	public void createEnrollmentMap(GlobalEnrollmentsMapEntity entity) {
		entity.setId(UUID.randomUUID());
		insert(entity);
	}
	
	public void deleteEnrollmentMap(GlobalEnrollmentsMapEntity entity) {
		delete(entity);
	}
	public GlobalEnrollmentsMapEntity getByEnrollmetnMapId(UUID globalEnrollmentId,UUID enrollmentId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(GlobalEnrollmentsMapEntity.class);
		criteria.createAlias("globalEnrollment", "globalEnrollment");
		criteria.add(Restrictions.eq("globalEnrollment.id",globalEnrollmentId));
		if(enrollmentId!=null) criteria.add(Restrictions.eq("enrollmentId",enrollmentId));
		List<GlobalEnrollmentsMapEntity> entities = (List<GlobalEnrollmentsMapEntity>) findByCriteria(criteria);
		if(!entities.isEmpty()) return entities.get(0);
		return null;
	}
	
	public List<GlobalEnrollmentsMapEntity> getGlobalEnrollmentMappings(UUID globalEnrollmentId){
		DetachedCriteria criteria = DetachedCriteria.forClass(GlobalEnrollmentsMapEntity.class);
		criteria.createAlias("globalEnrollment", "globalEnrollment");
		criteria.add(Restrictions.eq("globalEnrollment.id", globalEnrollmentId));
		return (List<GlobalEnrollmentsMapEntity>) findByCriteria(criteria);
	}

	@Override
	public void removeAllEnrollments(UUID globalEnrollmentId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(GlobalEnrollmentsMapEntity.class);
		criteria.createAlias("globalEnrollment", "globalEnrollment");
		criteria.add(Restrictions.eq("globalEnrollment.id", globalEnrollmentId));
		List<GlobalEnrollmentsMapEntity> entities = (List<GlobalEnrollmentsMapEntity>) findByCriteria(criteria);
		for(GlobalEnrollmentsMapEntity entity : entities) {
			delete(entity);
		}

		
	}
}