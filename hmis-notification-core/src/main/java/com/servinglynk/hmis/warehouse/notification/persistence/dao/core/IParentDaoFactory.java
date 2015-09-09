package com.servinglynk.hmis.warehouse.notification.persistence.dao.core;

import com.servinglynk.hmis.warehouse.notification.persistence.dao.INotificationHeaderDao;
import com.servinglynk.hmis.warehouse.notification.persistence.dao.INotificationLineDao;
import com.servinglynk.hmis.warehouse.notification.persistence.dao.ITemplateLineDao;
import com.servinglynk.hmis.warehouse.notification.scheduler.dao.IWorkerHeaderDao;
import com.servinglynk.hmis.warehouse.notification.scheduler.dao.IWorkerLineDao;



public interface IParentDaoFactory {
	
	public IWorkerLineDao getWorkerLineDao();
	public IWorkerHeaderDao getWorkerHeaderDao();
	public INotificationHeaderDao getNotificationHeaderDao();
	public INotificationLineDao getNotificationLineDao();
	public ITemplateLineDao getTemplateLineDao();
	
}