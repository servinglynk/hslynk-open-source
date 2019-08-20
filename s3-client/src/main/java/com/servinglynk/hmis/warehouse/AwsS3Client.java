package com.servinglynk.hmis.warehouse;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ListObjectsRequest;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.Region;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectSummary;

public class AwsS3Client {
	
    private AmazonS3Client s3Client;
    public AwsS3Client(String accessKey, String secretKey)
    {
        s3Client = new AmazonS3Client(new BasicAWSCredentials(accessKey, secretKey));
    }

    public AwsS3Client()
    {
        DefaultAWSCredentialsProviderChain credentialProviderChain = new DefaultAWSCredentialsProviderChain();
        s3Client = new AmazonS3Client(credentialProviderChain.getCredentials());
    }

    public void createBucket(String bucketName, String prefix) {
    	s3Client.createBucket(bucketName, Region.US_West);
    }
    public void createBucket(String bucketName, Region region) {
    	s3Client.createBucket(bucketName, region);
    }
    /**
     * retrieve the list of keys in a specific bucket with a specific prefix
     * @param bucketName
     * @param prefix
     * @return
     */
    public List<String> listBucket(String bucketName, String prefix)
    {
        ObjectListing objects = s3Client.listObjects(bucketName, prefix);

        List<S3ObjectSummary> objectSummaries = objects.getObjectSummaries();
        List<String> results = new ArrayList<String>();
        for(S3ObjectSummary object : objectSummaries)
        {
                results.add(object.getKey());
        }
        return results;
    }

    
    public List<S3ObjectSummary> list(String bucket) {
        ObjectListing objectListing = s3Client.listObjects(new ListObjectsRequest().withBucketName(bucket));
        List<S3ObjectSummary> s3ObjectSummaries = objectListing.getObjectSummaries();
        return s3ObjectSummaries;
    }
    
    /**
     * Download a file (keyName) from a bucket (bucketName)
     * @param bucketName
     * @param keyName
     * @return
     */
    public String downloadFile(String bucketName, String keyName, String tmpPath) throws IOException
    {
        S3Object object = s3Client.getObject(
                new GetObjectRequest(bucketName, keyName));
        InputStream objectData = object.getObjectContent();
        String name = keyName.contains("/") ? keyName.substring(keyName.lastIndexOf('/') + 1) : keyName;
        String path = saveFile(objectData, name);
        objectData.close();
        return path;
    }

    private String saveFile(InputStream input, String name)
            throws IOException {
        File file = new File(name);
        OutputStream outputStream = new FileOutputStream(file);
        IOUtils.copy(input, outputStream);
        outputStream.close();
        return file.getAbsolutePath();
    }
    
    public static void main(String args[]) {
    	AwsS3Client se = new AwsS3Client();
    	se.list("al0024-6c0444d9-febc-48a2-8564-d7e66b1d5075");
    }
}
