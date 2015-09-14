package com.servinglynk.hmis.warehouse.sync.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.sync.business.service.core.SyncParentService;
import com.servinglynk.hmis.warehouse.sync.business.service.core.SyncParentServiceFactory;


@Component
@Service
public class SyncWorker  extends SyncParentService implements ISyncWorker  {
	
	final static Logger logger = Logger.getLogger(SyncWorker.class);


	@Autowired
	private SyncParentServiceFactory factory;
	
	@Transactional
	@Scheduled(initialDelay=20,fixedDelay=10000)
	public void processWorkerLine() {
		
		try {
			
					factory.getSyncService().performSync();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
}
