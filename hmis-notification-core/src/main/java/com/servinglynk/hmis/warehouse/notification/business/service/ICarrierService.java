package com.servinglynk.hmis.warehouse.notification.business.service;

import com.servinglynk.hmis.warehouse.notification.business.service.core.IParentService;
import com.servinglynk.hmis.warehouse.notification.carrier.CarrierNotification;
import com.servinglynk.hmis.warehouse.notification.persistence.entity.NotificationLineEntity;

public interface ICarrierService extends IParentService{
	
	
	public void send(CarrierNotification carrierNotification, NotificationLineEntity notificationLineEntity);

}