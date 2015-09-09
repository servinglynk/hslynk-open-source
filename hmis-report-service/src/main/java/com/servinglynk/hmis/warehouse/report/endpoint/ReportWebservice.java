package com.servinglynk.hmis.warehouse.report.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.servinglynk.hmis.warehouse.core.model.ReportRequest;
import com.servinglynk.hmis.warehouse.report.business.service.core.ParentServiceFactory;


@RestController
@RequestMapping("/reports")
public class ReportWebservice {
	
	
	 @Autowired
		protected ParentServiceFactory parentServiceFactory;
	 
	 
	 
	 
	 @RequestMapping(method = RequestMethod.POST)
		public ReportRequest createReport(@RequestBody ReportRequest reportRequest) throws Exception {			
			parentServiceFactory.getReportService().createReportRequest(reportRequest);
			
			
			return reportRequest;
		}


}
