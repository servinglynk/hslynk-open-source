package com.servinglynk.hmis.warehouse.base.service.impl;

import com.servinglynk.hmis.warehouse.NotificationSearchRequest;
import com.servinglynk.hmis.warehouse.core.model.Account;
import com.servinglynk.hmis.warehouse.core.model.HmisNotification;
import com.servinglynk.hmis.warehouse.core.model.HmisNotifications;

public interface HMISNotificationsService {

	HmisNotification sendHmisNotification(HmisNotification hmisNotification, Account account) throws Exception;

	HmisNotifications getEmailNotifications(NotificationSearchRequest searchRequest) throws Exception;
}