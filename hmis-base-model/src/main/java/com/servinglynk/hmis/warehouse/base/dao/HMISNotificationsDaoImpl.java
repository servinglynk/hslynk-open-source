package com.servinglynk.hmis.warehouse.base.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.servinglynk.hmis.warehouse.NotificationSearchRequest;
import com.servinglynk.hmis.warehouse.model.HMISNotificationEntity;

public class HMISNotificationsDaoImpl extends QueryExecutorImpl implements HMISNotificationsDao {
	
	
	public HMISNotificationEntity saveNotification(HMISNotificationEntity entity) {
		insert(entity);
		return entity;
	}

	@Override
	public List<HMISNotificationEntity> getEmailNotifications(NotificationSearchRequest searchRequest) {
		DetachedCriteria criteria = DetachedCriteria.forClass(HMISNotificationEntity.class);
		if(searchRequest.getFromDate()!=null)
			 criteria.add(Restrictions.ge("createdAt", searchRequest.getFromDate()));
		if(searchRequest.getToDate()!=null)
			 criteria.add(Restrictions.le("createdAt", searchRequest.getFromDate()));
		if(!searchRequest.getStatus().isEmpty())
			criteria.add(Restrictions.in("status", searchRequest.getStatus()));
		if(searchRequest.getRecipientId()!=null)
			criteria.add(Restrictions.eq("recipientId",searchRequest.getRecipientId()).ignoreCase());
		if(searchRequest.getRecipientType()!=null)
			criteria.add(Restrictions.eq("recipientType",searchRequest.getRecipientType()).ignoreCase());
		
		criteria.add(Restrictions.eq("projectGroupCode",searchRequest.getProjectGroup()));
			return	(List<HMISNotificationEntity>) findByCriteria(criteria,searchRequest.getStartIndex(),searchRequest.getMaxItems());
	}
	
	
	public Long getEmailNotificationsCount(NotificationSearchRequest searchRequest) {
		DetachedCriteria criteria = DetachedCriteria.forClass(HMISNotificationEntity.class);
		if(searchRequest.getFromDate()!=null)
			 criteria.add(Restrictions.ge("createdAt", searchRequest.getFromDate()));
		if(searchRequest.getToDate()!=null)
			 criteria.add(Restrictions.le("createdAt", searchRequest.getFromDate()));
		if(!searchRequest.getStatus().isEmpty())
			criteria.add(Restrictions.in("status", searchRequest.getStatus()));
		if(searchRequest.getRecipientId()!=null)
			criteria.add(Restrictions.eq("recipientId",searchRequest.getRecipientId()).ignoreCase());
		if(searchRequest.getRecipientType()!=null)
			criteria.add(Restrictions.eq("recipientType",searchRequest.getRecipientType()).ignoreCase());
		criteria.add(Restrictions.eq("projectGroupCode",searchRequest.getProjectGroup()));
			return countRows(criteria);
	}


}
