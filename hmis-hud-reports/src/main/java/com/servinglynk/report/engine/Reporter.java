package com.servinglynk.report.engine;


import org.apache.log4j.Logger;

import com.servinglynk.hmis.warehouse.AprReportGenerator;
import com.servinglynk.hmis.warehouse.LSAReportGenerator;
import com.servinglynk.hmis.warehouse.SPMReportGenerator;

public class Reporter {
	
		private Logger logger = Logger.getLogger(Reporter.class);
		
        public static void main(String[] args) throws Exception {
        	AprReportGenerator.generateReport();
        	LSAReportGenerator.generateReport();
        	SPMReportGenerator.generateReport();
        	return;
	}
}