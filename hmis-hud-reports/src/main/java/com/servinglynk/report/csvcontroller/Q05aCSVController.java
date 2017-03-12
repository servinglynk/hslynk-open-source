package com.servinglynk.report.csvcontroller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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

import org.apache.log4j.Logger;

import com.servinglynk.report.bean.Q05aHMISComparableDBDataQualityDataBean;
import com.servinglynk.report.business.Q05aHMISComparableDBDataQualityDataBeanMaker;

public class Q05aCSVController {

	private static Logger logger = Logger.getLogger(Q05aCSVController.class);
	
    @SuppressWarnings("unchecked")
	public static void buildReport( List<Q05aHMISComparableDBDataQualityDataBean> dataBeanList) {
		try {                                           
			ClassLoader classLoader = Q05aCSVController.class.getClassLoader();
			File file = new File(classLoader.getResource("q05a.jrxml").getFile());
	    	InputStream inputStream1 = new FileInputStream(file);
	        JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataBeanList);
	        Map parameters = new HashMap();
		    JasperDesign jasperDesign1 = JRXmlLoader.load(inputStream1);
		    JasperReport jasperReport1 = JasperCompileManager.compileReport(jasperDesign1);
		    JasperPrint jasperPrint1 = JasperFillManager.fillReport(jasperReport1, parameters, beanColDataSource);
		    OutputStream ouputStream  = new FileOutputStream(new File("Q05a.csv"));
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

}
