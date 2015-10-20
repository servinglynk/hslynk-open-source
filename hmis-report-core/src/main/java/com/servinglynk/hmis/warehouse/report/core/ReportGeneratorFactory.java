package com.servinglynk.hmis.warehouse.report.core;

import org.springframework.beans.factory.annotation.Autowired;

import com.servinglynk.hmis.warehouse.report.business.exception.ReportGeneratorNotFoundException;

public class ReportGeneratorFactory  {

	@Autowired
	ExcelReportGenerator excelReportGenerator;
	
	@Autowired
	PdfReportGenerator pdfReportGenerator;
	
	public IReportGeneratorHandler getReportGeneratorHandler(String outputType) throws ReportGeneratorNotFoundException {
		
		if(ReportGeneratorType.valueOf(outputType).equals(ReportGeneratorType.PDF)){
			return pdfReportGenerator;
		}else if(ReportGeneratorType.valueOf(outputType).equals(ReportGeneratorType.XL)){
			return excelReportGenerator;
		}
		
		throw new ReportGeneratorNotFoundException("Report Generator Not Found : "+outputType);
		
	}
	
}
