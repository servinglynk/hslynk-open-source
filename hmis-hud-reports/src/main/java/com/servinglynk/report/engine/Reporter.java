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
        	ClassLoader classLoader = Reporter.class.getClassLoader();
			File file = new File(classLoader.getResource("homePage.jrxml").getFile());
//			System.out.println("File Path --> " + file);
			InputStream inputStream = new FileInputStream(file);
		//	List<HomePageDataBean> dataBeanList = new ArrayList<HomePageDataBean>();
//        	HomePageDataBeanMaker homePageDataBeanMaker = new HomePageDataBeanMaker();
			
			List<String> projects = new ArrayList<>();
			projects.add("84dc0df1-b27b-4b6d-b033-73101882e3f9");
			projects.add("c5f456cc-fec4-4d02-ad06-ad6dd5a50c65");
			projects.add("c8419a7a-bab6-42e4-b533-f47cd8a61837");
        	List<HomePageDataBean> dataBeanList = HomePageDataBeanMaker.getHomePageDataList("cp0004",null,sageReport, new Date(), new Date(),projects);
        	if(sageReport) {
        		//System.out.println("----Inside condition-------");
                JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataBeanList);
                Map parameters = new HashMap();
    		    JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
    		    JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
    		    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, beanColDataSource);
    		    JasperExportManager.exportReportToPdfFile(jasperPrint, "HMISREPORT_06072018.pdf"); 
        	}
     
        } catch (Exception e) {
            logger.error(e, e);
        }
    }
     
       /* private void exportToPDF() {
            try {         
            	
            	InputStream inputStream = new FileInputStream ("C:/workspace/hmis-hud-reports/src/main/resources/HUD_Annual_Report_P1_28012017.jrxml");
            	InputStream inputStreamP2 =new FileInputStream ("C:/workspace/hmis-hud-reports/src/main/resources/HUD_Annual_Report_P2_28012017.jrxml");
               
                
            	List<HomePageDataBean> dataBeanList = HomePageDataBeanMaker.getHomePageDataList();
                JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataBeanList);
                
                Map parameters = new HashMap();
        
    		    JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
    		    JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
    		    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, beanColDataSource);
    		    JasperExportManager.exportReportToPdfFile(jasperPrint, "C:/workspace/hmis-hud-reports/src/main/resources/HMIS_REPORT_27012017.pdf"); 
     
            } catch (Exception e) {
                logger.error(e, e);
            }
        }   */ 
        
        
     public static void main(String[] args) {
    	 boolean sageReport=true;
        Reporter main = new Reporter();
        main.exportToPDF(sageReport);
    }
	
	
}