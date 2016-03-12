package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.servinglynk.hmis.warehouse.model.v2014.ReleaseOfInfoEntity;

public class InformationReleasesDaoImpl extends QueryExecutorImpl implements InformationReleasesDao {

	

	@Override
	public ReleaseOfInfoEntity createReleaseOfInfo(ReleaseOfInfoEntity releaseOfInfoEntity) {
		insert(releaseOfInfoEntity);
		return releaseOfInfoEntity;
	}

	@Override
	public ReleaseOfInfoEntity updateReleaseOfInfo(ReleaseOfInfoEntity releaseOfInfoEntity) {
		update(releaseOfInfoEntity);
		return releaseOfInfoEntity;
	}

	@Override
	public void deleteReleaseOfInfo(ReleaseOfInfoEntity releaseOfInfoEntity) {
			delete(releaseOfInfoEntity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ReleaseOfInfoEntity> getreleaseOfInfoEntityByEnrollment(UUID enrollmentId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(ReleaseOfInfoEntity.class);
		criteria.createAlias("enrollment","enrollment");		
		criteria.add(Restrictions.eq("enrollment.id",enrollmentId));
		return (List<ReleaseOfInfoEntity>) findByCriteria(criteria);
	}
}
