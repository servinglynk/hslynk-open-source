package com.servinglynk.hmis.warehouse.service;

import com.servinglynk.hmis.warehouse.model.HmisPostingModel;
import com.servinglynk.hmis.warehouse.model.SessionModel;

public interface HmisPostingService {

	void postHmis(HmisPostingModel HmisPostingModel, SessionModel session);
}
