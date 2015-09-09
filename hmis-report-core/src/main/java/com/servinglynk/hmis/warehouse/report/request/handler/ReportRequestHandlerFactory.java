package com.servinglynk.hmis.warehouse.report.request.handler;



import org.springframework.beans.factory.annotation.Autowired;

import com.servinglynk.hmis.warehouse.report.business.util.ReportType;


public class ReportRequestHandlerFactory {

	@Autowired
		IReportRequestHandler aharReportHandler;

		
		public IReportRequestHandler getReportRequestHandler(ReportType reportType){

			 if(reportType.equals(ReportType.AHAR_REPORT)) 
				 return aharReportHandler;
			 
			 	return aharReportHandler;

		}


		public IReportRequestHandler getDemandForecastReportHandler() {
			return aharReportHandler;
		}

	
}
