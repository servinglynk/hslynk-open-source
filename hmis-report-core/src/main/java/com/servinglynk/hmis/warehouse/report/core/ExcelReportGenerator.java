package com.servinglynk.hmis.warehouse.report.core;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Calendar;

import org.apache.log4j.Logger;

import com.servinglynk.hmis.warehouse.core.model.ReportResult;
import com.servinglynk.hmis.warehouse.report.business.exception.ReportCreationException;

import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsxExporterConfiguration;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;

public class ExcelReportGenerator extends ReportGenerator implements 	IReportGeneratorHandler {

	private static final  Logger logger = Logger.getLogger(ExcelReportGenerator.class);

	public ReportResult reportPrint(ReportResult reportResult) {
		OutputStream output   = null;
		try {

			JasperPrint jasperPrint = this.prepareReportPrint(reportResult);
			String filePrefix = new StringBuilder(
					reportResult.getReportLocation()).append("\\\\").toString();
			
			StringBuilder name = new StringBuilder(
					reportResult.getReportName()).append("_")
					.append(Calendar.getInstance().getTimeInMillis())
					.append(".xlsm");
			
			String fileName = filePrefix + name;
		
			output = new FileOutputStream(new File(fileName.toString()));
			reportResult.setReportName(fileName.toString());
		
			logger.info("Report Name- "+fileName.toString());
			JRXlsxExporter exporterXLS = new JRXlsxExporter();
			
			SimpleXlsxExporterConfiguration configuration = new SimpleXlsxExporterConfiguration();
		
			
			SimpleOutputStreamExporterOutput exporterOutput = new SimpleOutputStreamExporterOutput(output);
			SimpleExporterInput exporterInput = new SimpleExporterInput(jasperPrint);
			
			SimpleXlsxReportConfiguration reportConfiguration = new SimpleXlsxReportConfiguration();
			reportConfiguration.setRemoveEmptySpaceBetweenRows(true);
			reportConfiguration.setRemoveEmptySpaceBetweenColumns(true);
			reportConfiguration.setIgnoreGraphics(true);
			reportConfiguration.setWhitePageBackground(true);
			exporterXLS.setConfiguration(reportConfiguration);
			
			exporterXLS.setExporterOutput(exporterOutput);
			exporterXLS.setExporterInput(exporterInput);
			exporterXLS.setConfiguration(configuration);
			logger.info("Exporting Excel Report - ");
			exporterXLS.exportReport();
			
			
		} catch (Exception e) {
			logger.info("Error in Report Generator - " + e.getMessage());
			throw new ReportCreationException("Error in Report Generator - "	+ e.getMessage());

		} finally {
			if (this.virtualizer != null)
				this.virtualizer.cleanup();
			try{
				output.close();
			}catch(Exception o){}
		}

		return reportResult;

	}
	
}
