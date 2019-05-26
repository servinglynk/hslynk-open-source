package com.servinglynk.hmis.warehouse.upload.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.servinglynk.hmis.warehouse.dao.ParentDaoFactory;

@Component
public class ChronicHomelessnesCalculator implements IChronicHomelessnesCalculator  {
	
	final static Logger logger = Logger.getLogger(ChronicHomelessnesCalculator.class);

	@Autowired
	Environment env;

	@Autowired
	private ParentDaoFactory factory;
	
	public void processWorkerLine() {
		try {
			
			factory.getBulkUploaderDao().calculateChronicHomelessness("SR0012");
			logger.info("======== ChronicHomelessCalcHelperr processed ======");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
