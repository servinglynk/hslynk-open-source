package com.servinglynk.hmis.warehouse;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.servinglynk.hive.connection.CsvExporter;
import com.servinglynk.hive.connection.StoredProcCall;
import com.servinglynk.hive.connection.SyncPostgresProcessor;

public class LSAReportGenerator  extends Logging {
	private static Logger logger = Logger.getLogger(LSAReportGenerator.class);
	public LSAReportGenerator(Logger logger) throws Exception {
	        this.logger = logger;
	}
	/***
	 * Generate LSA report
	 */
	 public static void generateReport() {
	        try {         
	        	Properties props = new Properties();
	    		props.generatePropValues();
	    		logger.info("Starting LSA reports process....");
	    		CsvExporter csvExporter = new CsvExporter();
	    		Map<String,String> csvs = new HashMap<>();
	    		csvs.put("lsa_calculated","ReportID");
	    		csvs.put("lsa_exit","ReportID");
	    		csvs.put("lsa_funder","ExportID");
	    		csvs.put("lsa_inventory","ExportID");
	    		csvs.put("lsa_organization","ExportID");
	    		csvs.put("lsa_project","ExportID");
	    		csvs.put("lsa_projectcoc","ExportID");
	    		csvs.put("lsa_person","ReportID");
	    		csvs.put("lsa_report","ReportID");
	    		csvs.put("lsa_household","ReportID");
	    		
	    		ReportConfig reportConfig = SyncPostgresProcessor.getReportConfigByStatusReportType("INITIAL","LSA");
	    		if(reportConfig != null) {
	    			SyncPostgresProcessor.updateReportConfig("INPROGRESS", reportConfig.getId());
	    			String reportId = String.valueOf(reportConfig.getId());
	    			Integer id = Integer.parseInt(reportId);
	    			
	    			StoredProcCall.callStoredProc("create_temp_tables");
	    			SyncPostgresProcessor.insertLsaReport(reportConfig);
	    			StoredProcCall.callStoredProc("run_hmis_households_and_enrollments");
	    			
	    			for (Map.Entry<String,String> entry : csvs.entrySet())   {
	    				csvExporter.export("LSA",entry.getKey(),entry.getValue(),id);
	    			}
	        		SyncPostgresProcessor.updateReportConfig("BEFORE_ZIP_CREATION", reportConfig.getId());
	            	  // Get the bucket name from project group code.
	            	ZipFileProcessor.createZipFile(props.LSA_FILE_LOCATION, "", props.LSA_FILE_LOCATION+"/"+reportId+".zip");
	            	SyncPostgresProcessor.updateReportConfig("BEFORE_S3", reportConfig.getId());
	    		    String bucketName = SyncPostgresProcessor.getBucketName(reportConfig.getProjectGroupCode());
	    		    AwsS3Client client = new AwsS3Client();
	    			client.uploadFile(props.LSA_FILE_LOCATION+"/"+reportId+".zip", "LSA/"+reportId+".zip",bucketName);
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
