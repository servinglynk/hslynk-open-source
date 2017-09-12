package com.servinglynk.hmis.warehouse.base.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.base.service.APIAccessService;
import com.servinglynk.hmis.warehouse.core.model.APIAccess;
import com.servinglynk.hmis.warehouse.model.base.APIAccessEntity;

public class APIAccessServiceImpl extends ServiceBase implements APIAccessService {
	
	@Transactional
	public List<APIAccess> getAPIAccessDetails(String filter, String q) {
		List<APIAccess> accesses = new ArrayList<APIAccess>();
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.DAY_OF_MONTH,1);
		if(filter.equalsIgnoreCase("AM")) {
			calendar.set(Calendar.DAY_OF_MONTH,1);
			if(q!=null)	calendar.set(Calendar.MONTH,Integer.parseInt(q));
		}else if(filter.equals("LM")){
			 calendar.set(Calendar.MONTH,calendar.get(Calendar.MONTH)-1);
		}else if(filter.equalsIgnoreCase("TM")) {
			
		}
		List<APIAccessEntity> details =  daoFactory.getApiAccessDao().getAPIAccessDetails(null, calendar.getTime(), null);
		
		for(APIAccessEntity accessEntity :details) {
			APIAccess access = new APIAccess();
			access.setAccessCount(accessEntity.getAccessCount());
			access.setMonth(accessEntity.getServiceName());
			access.setProjectGroup(accessEntity.getProjectGroupCode());
			accesses.add(access);
		}
		return accesses;
	}

}
