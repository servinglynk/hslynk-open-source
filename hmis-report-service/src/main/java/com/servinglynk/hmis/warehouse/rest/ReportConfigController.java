package com.servinglynk.hmis.warehouse.rest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.servinglynk.hmis.warehouse.annotations.APIMapping;
import com.servinglynk.hmis.warehouse.core.model.ReportConfig;
import com.servinglynk.hmis.warehouse.core.model.Session;


@RestController
@RequestMapping("/reports")
public class ReportConfigController extends ControllerBase {
	
	
	 @RequestMapping(method = RequestMethod.POST)
		@APIMapping(value="CREATE_REPORT_CONFIG",checkSessionToken=true, checkTrustedApp=true)
		public ReportConfig createReport(@RequestBody ReportConfig reportConfig,HttpServletRequest request) throws Exception {			
		 Session session = sessionHelper.getSession(request);
		 String username = session.getAccount().getUsername();
		 ReportConfig createReportConfig = serviceFactory.getReportConfigService().createReportConfig(reportConfig,username);
		 return createReportConfig;
		 
		}


}
