package com.servinglynk.hmis.warehouse.fileupload.repository;

import java.util.List;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.servinglynk.hmis.warehouse.fileupload.entity.UploadMimeTypeEntity;
import com.servinglynk.hmis.warehouse.fileupload.entity.UploadTypeEntity;

public class UploadMimeTypeDaoImpl extends QueryExecutorImpl implements UploadMimeTypeDao  {

	public void save(UploadMimeTypeEntity object) {
		object.setId(UUID.randomUUID());
		insert(object);
	}

	public List<UploadMimeTypeEntity> findByUploadType(UploadTypeEntity uploadType) {
		DetachedCriteria criteria = DetachedCriteria.forClass(UploadMimeTypeEntity.class);
		criteria.createAlias("uploadType","uploadType");
		criteria.add(Restrictions.eq("uploadType.id", uploadType.getId()));
		List<UploadMimeTypeEntity> entities = (List<UploadMimeTypeEntity>) findByCriteria(criteria);
		return entities;
	}
}
