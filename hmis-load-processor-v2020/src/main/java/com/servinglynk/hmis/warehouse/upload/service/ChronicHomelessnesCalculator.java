package com.servinglynk.hmis.warehouse.upload.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.dao.ParentDaoFactory;

@Component
public class ChronicHomelessnesCalculator implements IChronicHomelessnesCalculator  {
	
	final static Logger logger = Logger.getLogger(ChronicHomelessnesCalculator.class);

	@Autowired
	Environment env;

	@Autowired
	private ParentDaoFactory factory;
	
	@Transactional
	@Scheduled(cron = "0 1 1 ? * *")
	public void processWorkerLine() {
		try {
			List<String> allActiveProjectGroupCodes = factory.getProjectGroupDao().getAllActiveProjectGroupCodes();
			for(String projectGroupCode : allActiveProjectGroupCodes) {
				factory.getBulkUploaderDao().calculateChronicHomelessness(projectGroupCode);
			}
			logger.info("======== ChronicHomelessCalcHelperr processed ======");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
