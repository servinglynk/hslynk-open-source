package com.servinglynk.hmis.warehouse;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.servinglynk.hive.connection.CsvExporter;
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
	    		CsvExporter csvExporter = new CsvExporter();
	    		Map<String,String> csvs = new HashMap<>();
	    		csvs.put("\"lsa_Calculated\"","\"ReportID\"");
	    		csvs.put("\"lsa_Exit\"","\"ReportID\"");
	    		csvs.put("\"lsa_Funder\"","\"ExportID\"");
	    		csvs.put("\"lsa_Inventory\"","\"ExportID\"");
	    		csvs.put("\"lsa_Organization\"","\"ExportID\"");
	    		csvs.put("\"lsa_Project\"","\"ExportID\"");
	    		csvs.put("\"lsa_ProjectCoC\"","\"ExportID\"");
	    		csvs.put("\"lsa_Person\"","\"ReportID\"");
	    		csvs.put("\"lsa_Report\"","\"ReportID\"");
	    		csvs.put("\"lsa_HouseHold\"","\"ReportID\"");
	    		
	    		
	    		ReportConfig reportConfig = SyncPostgresProcessor.getReportConfigByStatusReportType("INITIAL","LSA");
	    		if(reportConfig != null) {
	    			SyncPostgresProcessor.updateReportConfig("INPROGRESS", reportConfig.getId());
	    			String reportId = String.valueOf(reportConfig.getId());
	    			Integer id = Integer.parseInt(reportId);
	    			SyncPostgresProcessor.insertLsaReport(reportConfig);
	    			
	    			//StoredProcCall.callStoredProcWithParams(id,reportConfig.getProjectGroupCode(), "fun_lsareport_parameters_and_vendor_info");
	    			for (Map.Entry<String,String> entry : csvs.entrySet())   {
	    				csvExporter.export("LSA",entry.getKey(),entry.getValue(),12345);
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
				//SendEmail.generateAndSendEmail("sandeep.dolia@gmail.com", "");
	        } catch (Exception e) {
	        	e.printStackTrace();
	            logger.error(e, e);
	        }
	 }
	 
	
	
}
