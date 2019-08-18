package com.servinglynk.report.engine;


import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.servinglynk.hive.connection.SendEmail;
import com.servinglynk.hive.connection.SyncPostgresProcessor;
import com.servinglynk.hmis.warehouse.AwsS3Client;
import com.servinglynk.hmis.warehouse.Properties;
import com.servinglynk.hmis.warehouse.ReportConfig;
import com.servinglynk.hmis.warehouse.ZipFileProcessor;
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
		
        @SuppressWarnings({ "unchecked", "unlikely-arg-type" })
        
    private void exportToPDF(boolean sageReport) {
        try {         
        	Properties props = new Properties();
    		props.generatePropValues();
			ReportConfig reportConfig = SyncPostgresProcessor.getProjects(35);
			String reportId = String.valueOf(reportConfig.getId());
        	if(!sageReport) {
        		List<HomePageDataBean> dataBeanList = HomePageDataBeanMaker.getHomePageDataList(reportConfig);
                JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataBeanList);
                Map parameters = new HashMap();
            	ClassLoader classLoader = Reporter.class.getClassLoader();
    			File file = new File(classLoader.getResource("pdfGenerator.jrxml").getFile());
    			InputStream inputStream = new FileInputStream(file);
    		    JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
    		    JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
    		 
    		    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, beanColDataSource);
    		    JasperExportManager.exportReportToPdfFile(jasperPrint,reportId+".pdf"); 
        	}
        	
        	  // Get the bucket name from project group code.
        	ZipFileProcessor.createZipFile(props.APR_FILE_LOCATION, "", props.APR_FILE_LOCATION+reportId+".zip");
		    String bucketName = SyncPostgresProcessor.getBucketName(reportConfig.getProjectGroupCode());
			AwsS3Client client = new AwsS3Client();
			client.uploadFile(props.APR_FILE_LOCATION+reportId+".pdf", "APR/"+reportId+".pdf",bucketName);
			client.uploadFile(props.APR_FILE_LOCATION+reportId+".zip", "APR/"+reportId+".zip",bucketName);
			// update the report config to 
			SyncPostgresProcessor.updateReportConfig("S3", reportConfig.getId());
			SendEmail.generateAndSendEmail("sandeep.dolia@gmail.com", "");
        } catch (Exception e) {
            logger.error(e, e);
        }
    }

        public static void main(String[] args) throws Exception {
    	 boolean sageReport=false;
        Reporter main = new Reporter();
        main.exportToPDF(sageReport);
    }
	
	
}