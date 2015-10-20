package com.servinglynk.hmis.warehouse.report.request.handler;



import org.springframework.beans.factory.annotation.Autowired;

import com.servinglynk.hmis.warehouse.report.business.exception.ReportHandlerNotFoundException;
import com.servinglynk.hmis.warehouse.report.business.util.ReportType;


public class ReportRequestHandlerFactory {

	@Autowired
		IReportRequestHandler aharReportHandler;

		
		public IReportRequestHandler getReportRequestHandler(ReportType reportType){

			 if(reportType.equals(ReportType.AHAR_REPORT)) 
				 return aharReportHandler;
			
			 	throw new ReportHandlerNotFoundException("Handler not found for the report type :" + reportType);

		}


		public IReportRequestHandler getDemandForecastReportHandler() {
			return aharReportHandler;
		}

	
}
