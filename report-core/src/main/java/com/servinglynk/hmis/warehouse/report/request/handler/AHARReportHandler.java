package com.servinglynk.hmis.warehouse.report.request.handler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.servinglynk.hmis.warehouse.core.model.ReportHeader;
import com.servinglynk.hmis.warehouse.core.model.ReportRequest;
import com.servinglynk.hmis.warehouse.core.model.ReportResult;
import com.servinglynk.hmis.warehouse.notification.business.util.TestData;
import com.servinglynk.hmis.warehouse.report.business.service.core.ParentService;
import com.servinglynk.hmis.warehouse.report.core.ReportGeneratorFactory;
import com.servinglynk.hmis.warehouse.report.model.ExhibitOne;
import com.servinglynk.hmis.warehouse.report.model.ExhibitTwo;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class AHARReportHandler extends ParentService implements IReportRequestHandler {

	@Autowired
	ReportGeneratorFactory reportGeneratorFactory;
	
	public ReportResult createReport(ReportRequest reportRequest, ReportHeader reportHeader) throws Exception {
		ReportResult reportResult = new ReportResult();
		reportResult.setReportData(null);
		reportResult.setReportLocation(reportHeader.getReportLocation());
		reportResult.setReportName(reportHeader.getReportNamePrefix());
		reportResult.setReportTemplate(reportHeader.getReportTemplate());
		reportResult.setTempLocation(reportHeader.getTempLocation());
		
		System.out.println("Inside AHAR report handler");
		
		
		List<ExhibitOne> estimatedTotalForPeriod =TestData.getEstimatedData();
		JRDataSource estimatedTotalForPeriodDs = new JRBeanCollectionDataSource(estimatedTotalForPeriod);
		
		List<ExhibitOne> pointinTimeCounts = TestData.getPointinTimeCounts();
		JRDataSource pointinTimeCountsDs = new JRBeanCollectionDataSource(pointinTimeCounts);
		
		List<ExhibitOne> onSingleNightIn = TestData.getOnSingleNightIn();
		JRDataSource onSingleNightInDs = new JRBeanCollectionDataSource(onSingleNightIn);
		
		List<ExhibitOne> numberOfFamilies = TestData.getNumberOfFamilies();
		JRDataSource numberOfFamiliesDs = new JRBeanCollectionDataSource(numberOfFamilies);
		
		List<ExhibitOne> numberOfFamiliesNF = TestData.getNumberOfFamiliesNF();
		JRDataSource numberOfFamiliesNFDs = new JRBeanCollectionDataSource(numberOfFamiliesNF);
		
		List<ExhibitOne> estimatedUtilizationAndTurnoverRates = TestData.getEstimatedUtilizationAndTurnoverRates();
		JRDataSource estimatedUtilizationAndTurnoverRatesDs = new JRBeanCollectionDataSource(estimatedUtilizationAndTurnoverRates);
		
		List<ExhibitOne> estimatedCountsByHouseholdType = TestData.getEstimatedCountsByHouseholdType();
		JRDataSource estimatedCountsByHouseholdTypeDs = new JRBeanCollectionDataSource(estimatedCountsByHouseholdType);
		
		List<ExhibitTwo> exhibitTwoData = TestData.getExhibitTwoData();
		JRDataSource exhibitTwoDs = new JRBeanCollectionDataSource(exhibitTwoData);
		
//		JasperReport report =  JasperCompileManager.compileReport("D:\\AHARReport.jrxml");
//		InputStream reportStream = new FileInputStream("D:\\AHARReport.jasper");
		Map<String, Object> parameters = new HashMap<String,Object>();
		parameters.put("estimatedTotalForPeriod", estimatedTotalForPeriodDs);
		parameters.put("pointinTimeCounts", pointinTimeCountsDs);
		parameters.put("onSingleNightIn", onSingleNightInDs);
		parameters.put("numberOfFamilies", numberOfFamiliesDs);
		parameters.put("numberOfFamiliesNF",numberOfFamiliesNFDs);
		parameters.put("estimatedUtilizationAndTurnoverRates",estimatedUtilizationAndTurnoverRatesDs);
		parameters.put("estimatedCountsByHouseholdType",estimatedCountsByHouseholdTypeDs);
		parameters.put("exhibitTwo",exhibitTwoDs);
		
		
		reportResult.setParameters(parameters);
		
		
		reportGeneratorFactory.getReportGeneratorHandler(reportHeader.getOutputType()).reportPrint(reportResult);
		
		return reportResult;
	}

}
