package com.servinglynk.report.engine;


import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.servinglynk.hmis.warehouse.Properties;
import com.servinglynk.report.bean.HomePageDataBean;
import com.servinglynk.report.business.HomePageDataBeanMaker;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

public class Reporter {
	
		private Logger logger = Logger.getLogger(Reporter.class);
		
        @SuppressWarnings("unchecked")
        
    private void exportToPDF(boolean sageReport) {
        try {         
        	Properties props = new Properties();
    		props.generatePropValues();
        
			List<String> projects = new ArrayList<>();
			projects.add("4055e079-fbef-42cd-9f58-43a90be60b47");
			projects.add("468b31e4-3492-4043-a917-53b66b3cf617");
			projects.add("538948f4-3c13-4907-9174-2078c4408ce7");
			
			projects.add("5cc34dce-e603-4cb6-8d95-4cd3fb164098");
			projects.add("5e63e036-50fc-4ce1-bc88-6b61bbedd539");
			projects.add("8ce3bcf7-cea0-4735-9330-bb7f04b71a40");
			
			projects.add("913f65e5-d9d0-4312-b0ee-d94920bed6c2");
			projects.add("c31f3f53-0b9f-480e-8da8-ffe8c7b931ed");
			projects.add("e6ccebeb-2b03-47aa-96dc-e63b9d2c4fc1");
			projects.add("6eec300a-20a8-4e0f-9e00-ae8fc47fd677");
			
			ClassLoader classLoader = Reporter.class.getClassLoader();
			File file = new File(classLoader.getResource("q17.jrxml").getFile());
			InputStream inputStream = new FileInputStream(file);
		    JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
		    String jasperReport = JasperCompileManager.compileReportToFile("/Users/sdolia/github/hmis-lynk-open-source/hmis-hud-reports/src/main/csvresources/q17.jrxml");
		    
        	List<HomePageDataBean> dataBeanList = HomePageDataBeanMaker.getHomePageDataList("sr0012",null,sageReport, new Date(), new Date(),projects);
        	if(!sageReport) {
                JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataBeanList);
                Map parameters = new HashMap();
//            	ClassLoader classLoader = Reporter.class.getClassLoader();
//    			File file = new File(classLoader.getResource("pdfGenerator.jrxml").getFile());
//    			InputStream inputStream = new FileInputStream(file);
//    		    JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
//    		    JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
//    		 
    		    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, beanColDataSource);
    		    JasperExportManager.exportReportToPdfFile(jasperPrint, "HMISREPORT_testing.pdf"); 
        	}
        } catch (Exception e) {
            logger.error(e, e);
        }
    }

        public static void main(String[] args) throws Exception {
//        	ClassLoader classLoader = Reporter.class.getClassLoader();
//        	   File file1 = new File(classLoader.getResource("q21_Health_Insurance.jrxml").getFile());
//   			InputStream inputStream1 = new FileInputStream(file1);
//   		    JasperDesign jasperDesign1 = JRXmlLoader.load(inputStream1);
//   		    JasperReport jasperReport1 = JasperCompileManager.compileReportToFile("q21_Health_Insurance.jrxml","q21_Health_Insurance.jasper");
//   		    
   		    
    	 boolean sageReport=true;
        Reporter main = new Reporter();
        main.exportToPDF(sageReport);
    }
	
	
}