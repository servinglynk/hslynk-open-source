package com.servinglynk.report.engine;


import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.servinglynk.hmis.warehouse.Properties;
import com.servinglynk.report.bean.HomePageDataBean;
import com.servinglynk.report.business.HomePageDataBeanMaker;

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
            
//        	HomePageDataBeanMaker homePageDataBeanMaker = new HomePageDataBeanMaker();
        	List<HomePageDataBean> dataBeanList = HomePageDataBeanMaker.getHomePageDataList("mo0010","01630ab0-2eeb-4e75-87b7-11d8f260ebb5",sageReport, new Date(), new Date());
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