package com.servinglynk.hmis.warehouse.base.dao;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.model.base.APIAccessEntity;

public interface APIAccessDao {
	
	APIAccessEntity getAPIAccess(String projectGroupCode, Date date,UUID serviceId) ;
	List<APIAccessEntity> getAPIAccessDetails(String projectGroupCode, Date date,UUID serviceId);
	void createAPIAccess(APIAccessEntity accessEntity);
	void updateAPIAccess(APIAccessEntity accessEntity);
}
