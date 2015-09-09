package com.servinglynk.hmis.warehouse.upload.service;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.upload.business.service.core.ParentService;
@Component
@Service
public class RollupWorker  extends ParentService implements IRollupWorker {
	final static Logger logger = Logger.getLogger(RollupWorker.class);
	
	@Override
	@Transactional
	@Scheduled(initialDelay=20,fixedDelay=10000)
	public void processWorkerLine() throws Exception {
		performRollUpForQuestion7();
		logger.info("RollupWorker Testing");
	}

	private void performRollUpForQuestion7() {
		
	}

}
