package com.servinglynk.hmis.warehouse;

import org.apache.log4j.Logger;

import com.servinglynk.hive.connection.SyncPostgresProcessor;

public class LSAReportGenerator  extends Logging {
	private Logger logger = Logger.getLogger(ReportGenerator.class);
	public LSAReportGenerator(Logger logger) throws Exception {
	        this.logger = logger;
	}
	
	public static void main(String args[]) throws Exception {
		Logger logger = Logger.getLogger(ReportGenerator.class.getName());
		Properties props = new Properties();
		props.generatePropValues();
		LSAReportGenerator main = new LSAReportGenerator(logger);
	    main.exportToPDF();
	}
	
	
	 private void exportToPDF() {
	        try {         
	        	Properties props = new Properties();
	    		props.generatePropValues();
	    		logger.info("Starting LSA reports process....");
	    		ReportConfig reportConfig = SyncPostgresProcessor.getReportConfigByStatusReportType("INITIAL","LSA");
	    		if(reportConfig != null) {
	    			SyncPostgresProcessor.updateReportConfig("INPROGRESS", reportConfig.getId());
	    			String reportId = String.valueOf(reportConfig.getId());
	    			
	    			
	    			
	        		SyncPostgresProcessor.updateReportConfig("BEFORE_ZIP_CREATION", reportConfig.getId());
	            	  // Get the bucket name from project group code.
	            	ZipFileProcessor.createZipFile(props.APR_FILE_LOCATION, "", props.APR_FILE_LOCATION+reportId+".zip");
	            	SyncPostgresProcessor.updateReportConfig("BEFORE_S3", reportConfig.getId());
	    		    String bucketName = SyncPostgresProcessor.getBucketName(reportConfig.getProjectGroupCode());
	    			AwsS3Client client = new AwsS3Client();
	    			client.uploadFile(props.APR_FILE_LOCATION+reportId+".pdf", "APR/"+reportId+".pdf",bucketName);
	    			client.uploadFile(props.APR_FILE_LOCATION+reportId+".zip", "APR/"+reportId+".zip",bucketName);
	    			
	    			
	    			// update the report config to 
	    			SyncPostgresProcessor.updateReportConfig("COMPLETED", reportConfig.getId());
	    		}
				//SendEmail.generateAndSendEmail("sandeep.dolia@gmail.com", "");
	        } catch (Exception e) {
	        	e.printStackTrace();
	            logger.error(e, e);
	        }
	 }
	        
}
