package com.servinglynk.hmis.warehouse.fileupload.repository;

import java.util.List;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.servinglynk.hmis.warehouse.fileupload.entity.UploadTypeEntity;

public class UploadTypeDaoImpl extends QueryExecutorImpl implements UploadTypeDao {

	public UploadTypeEntity findById(UUID uploadTypeId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(UploadTypeEntity.class);
		criteria.add(Restrictions.eq("id", uploadTypeId));
		List<UploadTypeEntity> entities = (List<UploadTypeEntity>) findByCriteria(criteria);
		if(entities.isEmpty()) return null;
		return entities.get(0);
	}

	@Override
	public UploadTypeEntity findByCode(String uploadType) {
		DetachedCriteria criteria = DetachedCriteria.forClass(UploadTypeEntity.class);
		criteria.add(Restrictions.eq("uploadTypeCode", uploadType));
		List<UploadTypeEntity> entities = (List<UploadTypeEntity>) findByCriteria(criteria);
		if(entities.isEmpty()) return null;
		return entities.get(0);
	}

}
