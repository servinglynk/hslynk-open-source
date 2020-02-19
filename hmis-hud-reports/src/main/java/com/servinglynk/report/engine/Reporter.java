package com.servinglynk.report.engine;


import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;

import org.apache.log4j.Logger;

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
        
    private void exportToPDF() {
        try {         
        	Properties props = new Properties();
    		props.generatePropValues();
    		logger.info("Starting hud reports process....");
    		ReportConfig reportConfig = SyncPostgresProcessor.getReportConfigByStatus("INITIAL");
    		if(reportConfig != null) {
    			SyncPostgresProcessor.updateReportConfig("INPROGRESS", reportConfig.getId());
    			String reportId = String.valueOf(reportConfig.getId());
            	List<HomePageDataBean> dataBeanList = HomePageDataBeanMaker.getHomePageDataList(reportConfig,props);
                JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataBeanList);
                Map parameters = new HashMap();
                parameters.put("SUBREPORT_DIR",props.APR_CONFIG_LOCATION );
                File file = new File(props.APR_CONFIG_LOCATION+"pdfGenerator.jrxml");
        	    InputStream inputStream = new FileInputStream(file);
        		JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
        		JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
        		/*
        		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, beanColDataSource);
        		JasperExportManager.exportReportToPdfFile(jasperPrint,reportId+".pdf"); 
        		SyncPostgresProcessor.updateReportConfig("BEFORE_ZIP_CREATION", reportConfig.getId());
            	  // Get the bucket name from project group code.
            	ZipFileProcessor.createZipFile(props.APR_FILE_LOCATION, "", props.APR_FILE_LOCATION+reportId+".zip");
            	SyncPostgresProcessor.updateReportConfig("BEFORE_S3", reportConfig.getId());
    		    String bucketName = SyncPostgresProcessor.getBucketName(reportConfig.getProjectGroupCode());
    			AwsS3Client client = new AwsS3Client();
    			client.uploadFile(props.APR_FILE_LOCATION+reportId+".pdf", "APR/"+reportId+".pdf",bucketName);
    			client.uploadFile(props.APR_FILE_LOCATION+reportId+".zip", "APR/"+reportId+".zip",bucketName);
    			*/
    			
    			
    			// update the report config to 
    			//SyncPostgresProcessor.updateReportConfig("COMPLETED", reportConfig.getId());
    		}
			//SendEmail.generateAndSendEmail("sandeep.dolia@gmail.com", "");
        } catch (Exception e) {
        	e.printStackTrace();
            logger.error(e, e);
        }
        
    }

        public static void main(String[] args) throws Exception {
        	Reporter main = new Reporter();
        	main.exportToPDF();
        	return;
	}
	
}