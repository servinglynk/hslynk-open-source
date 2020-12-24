package com.servinglynk.hmis.warehouse;

import com.servinglynk.hive.connection.SyncPostgresProcessor;

public class TestS3Upload {

	public static void mains(String args[]) throws Exception {
		Properties props = new Properties();
		props.generatePropValues();
	    String bucketName = SyncPostgresProcessor.getBucketName("TT0013");
		AwsS3Client client = new AwsS3Client(Properties.AWS_PUBLIC_KEY,Properties.AWS_SECRET_KEY);
		String reportId ="55";
		client.uploadFile(props.LSA_FILE_LOCATION+"/"+reportId+".zip", reportId+".zip",bucketName);
	}
}
