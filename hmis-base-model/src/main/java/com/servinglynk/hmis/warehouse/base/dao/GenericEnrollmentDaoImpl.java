package com.servinglynk.hmis.warehouse.base.dao;

import java.util.List;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.servinglynk.hmis.warehouse.model.base.GenericEnrollmentEntity;
import com.servinglynk.hmis.warehouse.model.base.GlobalEnrollmentEntity;

public class GenericEnrollmentDaoImpl extends QueryExecutorImpl implements GenericEnrollmentDao {

	public GenericEnrollmentEntity create(GenericEnrollmentEntity entity) {
		entity.setId(UUID.randomUUID());
		insert(entity);
		return entity;
	}
	
	public void updateGenericEnrollment(GenericEnrollmentEntity entity) {
		update(entity);
	}
	
	public GenericEnrollmentEntity getById(UUID id) {
		DetachedCriteria criteria = DetachedCriteria.forClass(GenericEnrollmentEntity.class);
		criteria.add(Restrictions.eq("id", id));
		List<GenericEnrollmentEntity> entities = (List<GenericEnrollmentEntity>) findByCriteria(criteria);
		if(!entities.isEmpty()) return entities.get(0);
		return null;
	}
	
	public List<GenericEnrollmentEntity> getAllGlobalEnrollments(Integer start,Integer maxItems){
		DetachedCriteria criteria = DetachedCriteria.forClass(GenericEnrollmentEntity.class);
		return (List<GenericEnrollmentEntity>) findByCriteria(criteria,start,maxItems);
	}
	
	public Long getAllGlobalEnrollmentsCount(){
		DetachedCriteria criteria = DetachedCriteria.forClass(GenericEnrollmentEntity.class);
		return countRows(criteria);
	}

	@Override
	public void deleteGenericEnrollment(GenericEnrollmentEntity entity) {
		delete(entity);
	}
	

}