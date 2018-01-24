package com.servinglynk.hmis.warehouse.notification.persistence.dao.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.servinglynk.hmis.warehouse.notification.persistence.dao.HMISNotificationDao;
import com.servinglynk.hmis.warehouse.notification.persistence.dao.IHMISNotificationDao;
import com.servinglynk.hmis.warehouse.notification.persistence.dao.INotificationHeaderDao;
import com.servinglynk.hmis.warehouse.notification.persistence.dao.INotificationLineDao;
import com.servinglynk.hmis.warehouse.notification.persistence.dao.ITemplateLineDao;
import com.servinglynk.hmis.warehouse.notification.scheduler.dao.IWorkerHeaderDao;
import com.servinglynk.hmis.warehouse.notification.scheduler.dao.IWorkerLineDao;

@Component
public class ParentDaoFactory implements IParentDaoFactory {
	

	@Autowired
	private IWorkerLineDao workerLineDao;

	public IWorkerLineDao getWorkerLineDao() {
		return workerLineDao;
	}

	public void setWorkerLineDao(IWorkerLineDao workerLineDao) {
		this.workerLineDao = workerLineDao;
	}

	@Autowired
	private IWorkerHeaderDao workerHeaderDao;

	public IWorkerHeaderDao getWorkerHeaderDao() {
		return workerHeaderDao;
	}

	public void setWorkerHeaderDao(IWorkerHeaderDao workerHeaderDao) {
		this.workerHeaderDao = workerHeaderDao;
	}

	@Autowired
	private INotificationHeaderDao notificationHeaderDao;

	public INotificationHeaderDao getNotificationHeaderDao() {
		return notificationHeaderDao;
	}

	public void setNotificationHeaderDao(
			INotificationHeaderDao notificationHeaderDao) {
		this.notificationHeaderDao = notificationHeaderDao;
	}

	@Autowired
	private INotificationLineDao notificationLineDao;

	public INotificationLineDao getNotificationLineDao() {
		return notificationLineDao;
	}

	public void setNotificationLineDao(INotificationLineDao notificationLineDao) {
		this.notificationLineDao = notificationLineDao;
	}

	@Autowired
	private ITemplateLineDao templateLineDao;

	public ITemplateLineDao getTemplateLineDao() {
		return templateLineDao;
	}

	public void setTemplateLineDao(ITemplateLineDao templateLineDao) {
		this.templateLineDao = templateLineDao;
	}
	
	@Autowired
	private IHMISNotificationDao hmIhmisNotificationDao;

	public IHMISNotificationDao getHmIhmisNotificationDao() {
		return hmIhmisNotificationDao;
	}

	public void setHmIhmisNotificationDao(IHMISNotificationDao hmIhmisNotificationDao) {
		this.hmIhmisNotificationDao = hmIhmisNotificationDao;
	}
	
	
	
	
}
