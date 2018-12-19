

package com.servinglynk.report.engine;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRPrintPage;
import net.sf.jasperreports.engine.JRScriptletException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRCsvExporterParameter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import org.apache.log4j.Logger;

import com.servinglynk.report.bean.DataBean;
import com.servinglynk.report.bean.Q27DToQ27FDataBean;
import com.servinglynk.report.business.DataBeanMaker;
import com.servinglynk.report.business.Q27DToQ27FDataBeanMaker;

public class ReportMerger {
	
	private Logger logger = Logger.getLogger(Reporter.class);
	
    @SuppressWarnings("unchecked")
    
    	private void exportToPDF() {
		try {                                           
        	InputStream inputStream1 = new FileInputStream("C:/workspace/hmis-hud-reports/src/main/resources/HUD_Annual_Report.jrxml");
        	
        	InputStream inputStream2 = new FileInputStream ("C:/workspace/hmis-hud-reports/src/main/resources/q27D_To_q27F_Tables.jrxml");
        	
            DataBeanMaker dataBeanMaker = new DataBeanMaker();
            ArrayList<DataBean> dataBeanList = dataBeanMaker.getDataBeanList();
            JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataBeanList);
        
            Q27DToQ27FDataBeanMaker q27DToQ27FDataBeanMaker = new Q27DToQ27FDataBeanMaker();
            ArrayList<Q27DToQ27FDataBean> q27DToQ29DDataBeanLst = q27DToQ27FDataBeanMaker.getQ27dToQ27fDataBeanList();
            JRBeanCollectionDataSource q27DtoQ29DBeanColDataSource = new JRBeanCollectionDataSource(q27DToQ29DDataBeanLst);
            
            Map parameters = new HashMap();
    
		    JasperDesign jasperDesign1 = JRXmlLoader.load(inputStream1);
		    JasperReport jasperReport1 = JasperCompileManager.compileReport(jasperDesign1);
		    JasperPrint jasperPrint1 = JasperFillManager.fillReport(jasperReport1, parameters, beanColDataSource);
		    
		    JasperDesign jasperDesign2 = JRXmlLoader.load(inputStream2);
		    JasperReport jasperReport2 = JasperCompileManager.compileReport(jasperDesign2);
		    JasperPrint jasperPrint2= JasperFillManager.fillReport(jasperReport2, parameters, q27DtoQ29DBeanColDataSource);
		    
		    List pages = jasperPrint2.getPages();
		    for (int j = 0; j < pages.size(); j++) {
		        JRPrintPage object = (JRPrintPage)pages.get(j);
		        jasperPrint1.addPage(object);

		    }
//		    JasperViewer.viewReport(jasperPrint1,false);
		    JasperExportManager.exportReportToPdfFile(jasperPrint1, "C:/workspace/hmis-hud-reports/src/main/resources/HUD_Annual_Report.pdf");    
        } catch (Exception e) {
            logger.error(e, e);
        }
		
    }
	private void exportToXLS() {
	try {                                           
    	InputStream inputStream1 = new FileInputStream("C:/workspace/hmis-hud-reports/src/main/resources/HUD_Annual_Report.jrxml");
    	
    	InputStream inputStream2 = new FileInputStream ("C:/workspace/hmis-hud-reports/src/main/resources/q27D_To_q27F_Tables.jrxml");
    	
        DataBeanMaker dataBeanMaker = new DataBeanMaker();
        ArrayList<DataBean> dataBeanList = dataBeanMaker.getDataBeanList();
        JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataBeanList);
    
        Q27DToQ27FDataBeanMaker q27DToQ27FDataBeanMaker = new Q27DToQ27FDataBeanMaker();
        ArrayList<Q27DToQ27FDataBean> q27DToQ27FDataBeanLst = q27DToQ27FDataBeanMaker.getQ27dToQ27fDataBeanList();
        JRBeanCollectionDataSource q27DtoQ27FBeanColDataSource = new JRBeanCollectionDataSource(q27DToQ27FDataBeanLst);
        
        Map parameters = new HashMap();

	    JasperDesign jasperDesign1 = JRXmlLoader.load(inputStream1);
	    JasperReport jasperReport1 = JasperCompileManager.compileReport(jasperDesign1);
	    JasperPrint jasperPrint1 = JasperFillManager.fillReport(jasperReport1, parameters, beanColDataSource);
	    
	    JasperDesign jasperDesign2 = JRXmlLoader.load(inputStream2);
	    JasperReport jasperReport2 = JasperCompileManager.compileReport(jasperDesign2);
	    JasperPrint jasperPrint2= JasperFillManager.fillReport(jasperReport2, parameters, q27DtoQ27FBeanColDataSource);
	    
	    List pages = jasperPrint2.getPages();
	    for (int j = 0; j < pages.size(); j++) {
	        JRPrintPage object = (JRPrintPage)pages.get(j);
	        jasperPrint1.addPage(object);

	    }
//	    JasperViewer.viewReport(jasperPrint1,false);
	    
	    OutputStream ouputStream  = new FileOutputStream(new File("C:/workspace/hmis-hud-reports/src/main/resources/HUD_Annual_Report.xls"));
	    ByteArrayOutputStream byteArrayOutputStream   = new ByteArrayOutputStream();
	    
	    JRXlsExporter exporterXLS = new JRXlsExporter();
	    exporterXLS.setParameter(JRXlsExporterParameter.JASPER_PRINT,jasperPrint1);
	    exporterXLS.setParameter(JRXlsExporterParameter.OUTPUT_STREAM,byteArrayOutputStream);
	    exporterXLS.exportReport();
	    
	    ouputStream.write(byteArrayOutputStream.toByteArray()); 
	    ouputStream.flush();
	    ouputStream.close();
	    
    } catch (Exception e) {
        logger.error(e, e);
    }
	
}
    
	private void exportToCSV() {
		try {                                           
	    	InputStream inputStream1 = new FileInputStream("C:/workspace/hmis-hud-reports/src/main/resources/HUD_Annual_Report.jrxml");
	    	
	    	InputStream inputStream2 = new FileInputStream ("C:/workspace/hmis-hud-reports/src/main/resources/q27D_To_q27F_Tables.jrxml");
	    	
	        DataBeanMaker dataBeanMaker = new DataBeanMaker();
	        ArrayList<DataBean> dataBeanList = dataBeanMaker.getDataBeanList();
	        JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataBeanList);
	    
	        Q27DToQ27FDataBeanMaker q27DToQ27FDataBeanMaker = new Q27DToQ27FDataBeanMaker();
	        ArrayList<Q27DToQ27FDataBean> q27DToQ27FDataBeanLst = q27DToQ27FDataBeanMaker.getQ27dToQ27fDataBeanList();
	        JRBeanCollectionDataSource q27DtoQ27FBeanColDataSource = new JRBeanCollectionDataSource(q27DToQ27FDataBeanLst);
	        
	        Map parameters = new HashMap();

		    JasperDesign jasperDesign1 = JRXmlLoader.load(inputStream1);
		    JasperReport jasperReport1 = JasperCompileManager.compileReport(jasperDesign1);
		    JasperPrint jasperPrint1 = JasperFillManager.fillReport(jasperReport1, parameters, beanColDataSource);
		    
		    JasperDesign jasperDesign2 = JRXmlLoader.load(inputStream2);
		    JasperReport jasperReport2 = JasperCompileManager.compileReport(jasperDesign2);
		    JasperPrint jasperPrint2= JasperFillManager.fillReport(jasperReport2, parameters, q27DtoQ27FBeanColDataSource);
		    
		    List pages = jasperPrint2.getPages();
		    for (int j = 0; j < pages.size(); j++) {
		        JRPrintPage object = (JRPrintPage)pages.get(j);
		        jasperPrint1.addPage(object);

		    }
//		    JasperViewer.viewReport(jasperPrint1,false);
		    
		    OutputStream ouputStream  = new FileOutputStream(new File("C:/workspace/hmis-hud-reports/src/main/resources/HUD_Annual_Report.csv"));
		    ByteArrayOutputStream byteArrayOutputStream   = new ByteArrayOutputStream();
		    
		    JRCsvExporter exporterCSV = new JRCsvExporter();
		    exporterCSV.setParameter(JRCsvExporterParameter.JASPER_PRINT,jasperPrint1);
		    exporterCSV.setParameter(JRCsvExporterParameter.OUTPUT_STREAM,byteArrayOutputStream);
		    exporterCSV.exportReport();
		    
		    ouputStream.write(byteArrayOutputStream.toByteArray()); 
		    ouputStream.flush();
		    ouputStream.close();
		    
	    } catch (Exception e) {
	        logger.error(e, e);
	    }
		
	}

   	public static void main(String[] args) throws JRScriptletException {
        ReportMerger main = new ReportMerger();
        main.exportToPDF();
        main.exportToXLS();
        main.exportToCSV();
        
    }

}


