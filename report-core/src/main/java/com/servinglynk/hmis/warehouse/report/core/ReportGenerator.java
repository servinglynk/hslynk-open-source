package com.servinglynk.hmis.warehouse.report.core;

import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.fill.JRSwapFileVirtualizer;
import net.sf.jasperreports.engine.fill.JRVirtualizationContext;
import net.sf.jasperreports.engine.util.JRConcurrentSwapFile;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import com.servinglynk.hmis.warehouse.core.model.ReportResult;

public class ReportGenerator {
	

	public JRSwapFileVirtualizer virtualizer = null;

	
	public JasperPrint prepareReportPrint(ReportResult reportResult) throws Exception {


			JRConcurrentSwapFile jrSwapFile = new JRConcurrentSwapFile(reportResult.getTempLocation(), 1024, 2048);
			virtualizer = new JRSwapFileVirtualizer(10, jrSwapFile, true);

			///Resource re = new FileSystemResource(reportResult.getReportTemplate());
			Resource re = new ClassPathResource(reportResult.getReportTemplate());
			JasperReport report = JasperCompileManager.compileReport(re.getFile().getPath());
			
			JRDataSource dsResource = new JRBeanCollectionDataSource(reportResult.getReportData());
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put(JRParameter.REPORT_VIRTUALIZER, virtualizer);
			parameters.put("SubDataSource", dsResource);
			parameters.put(JRParameter.IS_IGNORE_PAGINATION, Boolean.TRUE);
	
		
			JasperPrint print = JasperFillManager.fillReport(report,parameters, dsResource);

			JRVirtualizationContext.getRegistered(print).setReadOnly(true);
			return print;
	}

}
