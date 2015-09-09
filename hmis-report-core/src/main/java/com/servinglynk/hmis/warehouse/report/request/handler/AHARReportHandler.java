package com.servinglynk.hmis.warehouse.report.request.handler;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.servinglynk.hmis.warehouse.core.model.AHARModel;
import com.servinglynk.hmis.warehouse.core.model.Parameters;
import com.servinglynk.hmis.warehouse.core.model.ReportHeader;
import com.servinglynk.hmis.warehouse.core.model.ReportRequest;
import com.servinglynk.hmis.warehouse.core.model.ReportResult;
import com.servinglynk.hmis.warehouse.report.business.service.core.ParentService;
import com.servinglynk.hmis.warehouse.report.common.ParameterVO;
import com.servinglynk.hmis.warehouse.report.core.ReportGenerator;
import com.servinglynk.hmis.warehouse.report.dao.AHARDao;


public class AHARReportHandler extends ParentService implements IReportRequestHandler{
	final static Logger logger = Logger.getLogger(AHARReportHandler.class);
	
	@Autowired
    AHARDao demandForecastDao;
	


	@Autowired
	ReportGenerator reportGenerator;
	
	public ReportGenerator getReportGenerator() {
		return reportGenerator;
	}
	
		//@Transactional
		public ReportResult createReport(ReportRequest reportRequest, ReportHeader reportHeader) throws Exception {
			
			Parameters params = reportRequest.getParameters();
			ParameterVO paramVO = new ParameterVO(params);
			
			AHARModel aharModel = new AHARModel(); 
			
			/* sample to show how to add filters from Report Reqeust */
			String date = paramVO.getStringValue("date");
			if (date!=null){
				try{
					SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
					Date date1 = sdf.parse(date);
					aharModel.setDate(date1);
				}catch(Exception e){
					    // do not take any action. 
						///e.printStackTrace();
				}
				
			}
			
	
			// This is the place where you get the report data , either by calling HBASE or Postgres
			 List<AHARModel> reportData = new ArrayList<AHARModel>();		 
			
			
			ReportResult reportResult = new ReportResult();
			reportResult.setReportData(reportData);
			reportResult.setReportLocation(reportHeader.getReportLocation());
			reportResult.setReportName(reportHeader.getReportNamePrefix());
			reportResult.setReportTemplate(reportHeader.getReportTemplate());
			reportResult.setTempLocation(reportRequest.getTempLocation());
			
			reportGenerator.reportPrint(reportResult);
			logger.debug("Report Location ::"+ reportResult.getReportLocation());
			
			return reportResult;
				 
		
	 }
		

}
