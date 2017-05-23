package com.servinglynk.report.csvcontroller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRCsvExporterParameter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

public class CSVGenerator {

	protected static InputStream getInputStream(String fileName) {
		InputStream inputStream1 = null;
		ClassLoader classLoader = CSVGenerator.class.getClassLoader();
		return classLoader.getResourceAsStream(fileName);
	}
	
	 @SuppressWarnings("unchecked")
		public static void buildReport(List<?> dataBeanList,String jrxmlFileName,String csvFileName) {
			try {             
				
				InputStream inputStream1 = getInputStream(jrxmlFileName);
		        Map parameters = new HashMap();
		        JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataBeanList);
			    JasperDesign jasperDesign1 = JRXmlLoader.load(inputStream1);
			    JasperReport jasperReport1 = JasperCompileManager.compileReport(jasperDesign1);
			    JasperPrint jasperPrint1 = JasperFillManager.fillReport(jasperReport1, parameters, beanColDataSource);
			    
			    //		    JasperViewer.viewReport(jasperPrint1,false);
			    
			    OutputStream ouputStream  = new FileOutputStream(new File(csvFileName));
			    ByteArrayOutputStream byteArrayOutputStream   = new ByteArrayOutputStream();
			    
			    JRCsvExporter exporterCSV = new JRCsvExporter();
			    exporterCSV.setParameter(JRCsvExporterParameter.JASPER_PRINT,jasperPrint1);
			    exporterCSV.setParameter(JRCsvExporterParameter.OUTPUT_STREAM,byteArrayOutputStream);
			    exporterCSV.exportReport();
			    System.out.println("Writing File...."+csvFileName);
			    ouputStream.write(byteArrayOutputStream.toByteArray()); 
			    ouputStream.flush();
			    ouputStream.close();
			    
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
			
		}
}
