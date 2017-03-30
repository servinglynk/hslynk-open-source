package com.servinglynk.report.engine;


import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import org.apache.log4j.Logger;

import com.servinglynk.report.bean.HomePageDataBean;
import com.servinglynk.report.business.HomePageDataBeanMaker;

public class Reporter {
	
		private Logger logger = Logger.getLogger(Reporter.class);
		
        @SuppressWarnings("unchecked")
        
    private void exportToPDF(boolean sageReport) {
        try {         
        	ClassLoader classLoader = Reporter.class.getClassLoader();
			File file = new File(classLoader.getResource("homePage.jrxml").getFile());
//			System.out.println("File Path --> " + file);
			InputStream inputStream = new FileInputStream(file);
            
//        	HomePageDataBeanMaker homePageDataBeanMaker = new HomePageDataBeanMaker();
        	List<HomePageDataBean> dataBeanList = HomePageDataBeanMaker.getHomePageDataList("mo0010","01630ab0-2eeb-4e75-87b7-11d8f260ebb5",sageReport);
        	/*if(sageReport) {
//        		System.out.println("----Inside condition-------");
                JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataBeanList);
                Map parameters = new HashMap();
    		    JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
    		    JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
    		    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, beanColDataSource);
    		    JasperExportManager.exportReportToPdfFile(jasperPrint, "HMIS_REPORT_19032017.pdf"); 
        	}*/
     
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