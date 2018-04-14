package com.servinglynk.hmis.warehouse.fileupload.repository;

import java.util.List;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.servinglynk.hmis.warehouse.fileupload.entity.UploadHeaderEntity;
import com.servinglynk.hmis.warehouse.fileupload.entity.UploadLineEntity;

public class UploadLineDaoImpl  extends QueryExecutorImpl implements UploadLineDao {
	
	public void save(UploadLineEntity object) {
		object.setId(UUID.randomUUID());
		insert(object);
	}

	public UploadLineEntity findById(UUID id) {
		DetachedCriteria criteria = DetachedCriteria.forClass(UploadLineEntity.class);
		criteria.add(Restrictions.eq("id", id));
		List<UploadLineEntity> entities = (List<UploadLineEntity>) findByCriteria(criteria);
		if(entities.isEmpty()) return null;
		return entities.get(0);
	}

	public List<UploadLineEntity> findByUploadHeader(UploadHeaderEntity headerEntity) {
		DetachedCriteria criteria = DetachedCriteria.forClass(UploadLineEntity.class);
		criteria.createAlias("uploadHeader","uploadHeader");
		criteria.add(Restrictions.eq("uploadHeader.id", headerEntity.getId()));
		List<UploadLineEntity> entities = (List<UploadLineEntity>) findByCriteria(criteria);
		return entities;
	}

	public void deleteUploadLine(UploadLineEntity uploadLine) {
			delete(uploadLine);
	}

}
