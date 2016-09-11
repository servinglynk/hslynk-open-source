package com.servinglynk.hmis.warehouse.client.reportservice;

import com.servinglynk.hmis.warehouse.client.exception.RestClientHttpException;





public interface IReportServiceClient {

	public ReportRequest createReport(ReportRequest reportRequest) throws RestClientHttpException;
	
	
}
