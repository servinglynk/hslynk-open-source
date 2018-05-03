package com.servinglynk.hmis.warehouse.fileupload.repository;

import java.util.List;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.servinglynk.hmis.warehouse.fileupload.entity.UploadHeaderEntity;

public class UploadHeaderDaoImpl extends QueryExecutorImpl implements UploadHeaderDao{
	
	public void save(UploadHeaderEntity entity) {
		entity.setId(UUID.randomUUID());
		insert(entity);
	}
	public void updateUploadHeader(UploadHeaderEntity entity) {
		update(entity);
	}

	public UploadHeaderEntity findById(UUID id) {
		DetachedCriteria criteria = DetachedCriteria.forClass(UploadHeaderEntity.class);
		criteria.add(Restrictions.eq("id", id));
		List<UploadHeaderEntity> entities = (List<UploadHeaderEntity>) findByCriteria(criteria);
		if(entities.isEmpty()) return null;
		return entities.get(0);
	}

	public void deleteHeaderEntity(UploadHeaderEntity headerEntity) {
			delete(headerEntity);		
	}
}
