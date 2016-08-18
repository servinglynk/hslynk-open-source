package com.servinglynk.hmis.warehouse.util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ListObjectsV2Request;
import com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectSummary;
public class AmazonS3Example {
	
	private static final String SUFFIX = "/";
	
	public static void main(String[] args) {
		// credentials object identifying user for authentication
		// user must have AWSConnector and AmazonS3FullAccess for 
		// this example to work
		AWSCredentials credentials = new BasicAWSCredentials(
				"AKIAJH6EMBEDW342TOAQ", 
				"7SbPwlS+tnEES/qdWF2Fdt9AuamobzND09Q7W5/V");
		
		// create a client connection based on credentials
		AmazonS3 s3client = new AmazonS3Client(credentials);
		
		// create bucket - name must be unique for all S3 users
		String bucketName = "sdolia-2015";
	//	s3client.createBucket(bucketName);
		
		// list buckets
		for (Bucket bucket : s3client.listBuckets()) {
			System.out.println(" - " + bucket.getName());
			listKeys(bucket.getName());
		}
////		createFolder(bucketName, folderName, s3client);
//		
//		// upload file to folder and set it to public
//		String fileName = folderName + SUFFIX + "HUD_4.0.xml";
//		s3client.putObject(new PutObjectRequest(bucketName, fileName, 
//				new File("C:\\Users\\sdolia\\Desktop\\HUDFile\\HUD_4.0.xml"))
//				.withCannedAcl(CannedAccessControlList.PublicRead));
		
	//	deleteFolder(bucketName, folderName, s3client);
		
		// deletes bucket
	//	s3client.deleteBucket(bucketName);
	}
	
	public static void listKeys(String bucketName) {
		AWSCredentials credentials = new BasicAWSCredentials(
				"AKIAJH6EMBEDW342TOAQ", 
				"7SbPwlS+tnEES/qdWF2Fdt9AuamobzND09Q7W5/V");
		 AmazonS3 s3client = new AmazonS3Client(credentials);
	        try {
	            System.out.println("Listing objects");
	            final ListObjectsV2Request req = new ListObjectsV2Request().withBucketName(bucketName).withMaxKeys(2);
	            ListObjectsV2Result result;
	            do {               
	               result = s3client.listObjectsV2(req);
	               
	               for (S3ObjectSummary objectSummary : 
	                   result.getObjectSummaries()) {
	                   System.out.println(" - " + objectSummary.getKey() + "  " +
	                           "(size = " + objectSummary.getSize() + 
	                           ")");
	                   try {
						readFile(bucketName, objectSummary.getKey());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	               }
	               System.out.println("Next Continuation Token : " + result.getNextContinuationToken());
	               req.setContinuationToken(result.getNextContinuationToken());
	            } while(result.isTruncated() == true ); 
	            
	         } catch (AmazonServiceException ase) {
	            System.out.println("Caught an AmazonServiceException, " +
	            		"which means your request made it " +
	                    "to Amazon S3, but was rejected with an error response " +
	                    "for some reason.");
	            System.out.println("Error Message:    " + ase.getMessage());
	            System.out.println("HTTP Status Code: " + ase.getStatusCode());
	            System.out.println("AWS Error Code:   " + ase.getErrorCode());
	            System.out.println("Error Type:       " + ase.getErrorType());
	            System.out.println("Request ID:       " + ase.getRequestId());
	        } catch (AmazonClientException ace) {
	            System.out.println("Caught an AmazonClientException, " +
	            		"which means the client encountered " +
	                    "an internal error while trying to communicate" +
	                    " with S3, " +
	                    "such as not being able to access the network.");
	            System.out.println("Error Message: " + ace.getMessage());
	        }
	    }
	
	public static void readFile(String bucketName,String key) throws IOException {
		AWSCredentials credentials = new BasicAWSCredentials(
				"AKIAJH6EMBEDW342TOAQ", 
				"7SbPwlS+tnEES/qdWF2Fdt9AuamobzND09Q7W5/V");	
		AmazonS3 s3Client = new AmazonS3Client(credentials);        
		S3Object object = s3Client.getObject(
		                  new GetObjectRequest(bucketName, key));
		InputStream objectData = object.getObjectContent();
		displayTextInputStream(objectData);
		// Process the objectData stream.
		objectData.close();
	}
	 public static void displayTextInputStream(InputStream input)
			    throws IOException {
			    	// Read one text line at a time and display.
			        BufferedReader reader = new BufferedReader(new 
			        		InputStreamReader(input));
			        while (true) {
			            String line = reader.readLine();
			            if (line == null) break;

			            System.out.println("    " + line);
			        }
			        System.out.println();
			    }
	public static void createFolder(String bucketName, String folderName, AmazonS3 client) {
		// create meta-data for your folder and set content-length to 0
		ObjectMetadata metadata = new ObjectMetadata();
		metadata.setContentLength(0);
		// create empty content
		InputStream emptyContent = new ByteArrayInputStream(new byte[0]);
		// create a PutObjectRequest passing the folder name suffixed by /
		PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName,
				folderName + SUFFIX, emptyContent, metadata);
		// send request to S3 to create folder
		client.putObject(putObjectRequest);
	}
	/**
	 * This method first deletes all the files in given folder and than the
	 * folder itself
	 */
	public static void deleteFolder(String bucketName, String folderName, AmazonS3 client) {
		List fileList = 
				client.listObjects(bucketName, folderName).getObjectSummaries();
//		for (S3ObjectSummary file : fileList) {
//			client.deleteObject(bucketName, file.getKey());
//		}
		client.deleteObject(bucketName, folderName);
	}
}
