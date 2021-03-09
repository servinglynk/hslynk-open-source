package com.servinglynk.hmis.warehouse;

import org.apache.log4j.Logger;

import com.servinglynk.hive.connection.SyncPostgresProcessor;

public class SPMReportGenerator  extends Logging {
	private static Logger logger = Logger.getLogger(LSAReportGenerator.class);
	public SPMReportGenerator(Logger logger) throws Exception {
	        this.logger = logger;
	}
	/***
	 * Generate SPM report
	 */
	 public static void generateReport() {
	        try {         
	        	Properties props = new Properties();
	    		props.generatePropValues();
	    		logger.info("Starting SPM reports process....");
	    		ReportConfig reportConfig = SyncPostgresProcessor.getReportConfigByStatusReportType("INITIAL","SPM");
	    		if(reportConfig != null) {
	    			SyncPostgresProcessor.updateReportConfig("INPROGRESS", reportConfig.getId());
	    			String reportId = String.valueOf(reportConfig.getId());
	        		SyncPostgresProcessor.updateReportConfig("BEFORE_ZIP_CREATION", reportConfig.getId());
	            	  // Get the bucket name from project group code.
	            	ZipFileProcessor.createZipFile(props.SPM_FILE_LOCATION, "", props.SPM_FILE_LOCATION+"/"+reportId+".zip");
	            	SyncPostgresProcessor.updateReportConfig("BEFORE_S3", reportConfig.getId());
	    		    String bucketName = SyncPostgresProcessor.getBucketName(reportConfig.getProjectGroupCode());
	    		    AwsS3Client client = new AwsS3Client();
	    			client.uploadFile(props.SPM_FILE_LOCATION+"/"+reportId+".zip", "SPM/"+reportId+".zip",bucketName);
	    			// update the report config to 
	    			SyncPostgresProcessor.updateReportConfig("COMPLETED", reportConfig.getId());
	    		}
	        } catch (Exception e) {
	        	e.printStackTrace();
	            logger.error(e, e);
	        }
	 }
	 
	public static void main(String args[]) {
		generateReport();
	}
	
}
