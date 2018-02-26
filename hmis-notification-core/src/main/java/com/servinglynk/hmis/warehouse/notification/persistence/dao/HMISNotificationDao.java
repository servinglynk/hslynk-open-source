package com.servinglynk.hmis.warehouse.notification.persistence.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.servinglynk.hmis.warehouse.notification.persistence.dao.core.ParentDao;
import com.servinglynk.hmis.warehouse.notification.persistence.entity.HMISNotificationEntity;

public class HMISNotificationDao extends ParentDao implements IHMISNotificationDao {

	public void updateNotificationStatus(HMISNotificationEntity entity,String status,String statusMessage) {
		entity.setStatus(status);
		entity.setStatusMessage(statusMessage);
		entity.setModifiedAt(new Date());
		update(entity);
	}	
	
	public HMISNotificationEntity getHmisNotification(Long id) {
		DetachedCriteria criteria = DetachedCriteria.forClass(HMISNotificationEntity.class);
		criteria.add(Restrictions.eq("id", id));
		List<HMISNotificationEntity>	entities = (List<HMISNotificationEntity>) findByCriteria(criteria);
		if(entities.isEmpty()) return null;
		return entities.get(0);
	}
}