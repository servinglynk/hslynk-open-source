package com.servinglynk.hmis.warehouse.report.core;

import java.util.Calendar;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

import com.servinglynk.hmis.warehouse.core.model.ReportResult;
import com.servinglynk.hmis.warehouse.report.business.exception.ReportCreationException;

public class PdfReportGenerator extends ReportGenerator implements IReportGeneratorHandler {


	public ReportResult reportPrint(ReportResult reportResult) {
		
		System.out.println(" Inside pdf report generator");
		
		 try {
			 
			 
		//		JasperPrint jasperPrint = this.prepareReportPrint(reportResult);
			
			/*	JRConcurrentSwapFile jrSwapFile = new JRConcurrentSwapFile(reportResult.getTempLocation(), 1024, 2048);
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

			 


				//OutputStream output = new FileOutputStream(new File(
				//		fileName.toString())); */
			 
			 
			 JasperReport report =  JasperCompileManager.compileReport(reportResult.getReportTemplate());
			 JasperPrint jasperPrint = JasperFillManager.fillReport(report, reportResult.getParameters(), new JREmptyDataSource());
			 
				StringBuilder fileName = new StringBuilder(
						reportResult.getReportLocation()).append("\\")
						.append(reportResult.getReportName()).append("_")
						.append(Calendar.getInstance().getTimeInMillis())
						.append(".pdf");
				
			 reportResult.setReportName(fileName.toString());
				
			 
			JasperExportManager.exportReportToPdfFile(jasperPrint,fileName.toString());
		} catch (Exception e) {
			e.printStackTrace();
			throw new ReportCreationException("Error in Report Generator - "+ e.getMessage());
		} finally {
			if (virtualizer != null)
				virtualizer.cleanup();
		}
		return reportResult;
	}

}
