package com.servinglynk.hmis.warehouse.report.core;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.fill.JRSwapFileVirtualizer;
import net.sf.jasperreports.engine.fill.JRVirtualizationContext;
import net.sf.jasperreports.engine.util.JRConcurrentSwapFile;
import net.sf.jasperreports.export.SimpleXlsxExporterConfiguration;
import net.sf.jasperreports.export.XlsxExporterConfiguration;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.servinglynk.hmis.warehouse.core.model.ReportResult;
import com.servinglynk.hmis.warehouse.report.business.exception.ReportCreationException;
import com.servinglynk.hmis.warehouse.report.config.ReportConfig;

public class ReportGenerator {
	
	final static Logger logger = Logger.getLogger(ReportGenerator.class);
	
	@Autowired
	ReportConfig reportConfig;

	public ReportResult reportPrint(ReportResult reportResult) throws ReportCreationException {
		

	

		JRSwapFileVirtualizer virtualizer = null;

		try {

			long start = System.currentTimeMillis();

			JRConcurrentSwapFile jrSwapFile = new JRConcurrentSwapFile(reportResult.getTempLocation(), 1024, 2048);
			virtualizer = new JRSwapFileVirtualizer(10, jrSwapFile, true);

			Resource re = new ClassPathResource(reportResult.getReportTemplate());
			JasperReport report = JasperCompileManager.compileReport(re.getFile().getPath());
			
			JRDataSource dsResource = new JRBeanCollectionDataSource(reportResult.getReportData());
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put(JRParameter.REPORT_VIRTUALIZER, virtualizer);
			parameters.put("SubDataSource", dsResource);
			parameters.put(JRParameter.IS_IGNORE_PAGINATION, Boolean.TRUE);

			JasperPrint print = JasperFillManager.fillReport(report,parameters, dsResource);

			JRVirtualizationContext.getRegistered(print).setReadOnly(true);

			StringBuilder fileName = new StringBuilder(reportResult.getReportLocation())
														.append("\\")
														.append(reportResult.getReportName()).append("_")
														.append(Calendar.getInstance().getTimeInMillis())
														.append(".xlsm");

			OutputStream output = new FileOutputStream(new File(fileName.toString()));
			reportResult.setReportName(fileName.toString());

			JRXlsxExporter exporterXLS = new  JRXlsxExporter();
			exporterXLS.setParameter(JRXlsExporterParameter.JASPER_PRINT, print);
			exporterXLS.setParameter(JRXlsExporterParameter.OUTPUT_STREAM,output);
			exporterXLS.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND,Boolean.TRUE);
			exporterXLS.setParameter(JRXlsExporterParameter.IS_IGNORE_GRAPHICS,Boolean.TRUE);
			exporterXLS.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,Boolean.TRUE);
			exporterXLS.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS,Boolean.TRUE);
			
			exporterXLS.exportReport();
			output.close();

			long end = System.currentTimeMillis();
			logger.info("Report generation completed in "+(end-start) +"ms");
			
		} catch (Exception e) {
			logger.error("Error in Report Generator - "+ e.getMessage());
			throw new ReportCreationException("Error in Report Generator - "+ e.getMessage());
		} finally {
			if (virtualizer != null)
				virtualizer.cleanup();
		}
		return reportResult;
	}

}
