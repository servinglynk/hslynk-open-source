package com.servinglynk.hmis.warehouse;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.amazonaws.util.IOUtils;
import com.amazonaws.util.StringUtils;

public class AwsS3Client {
    private AmazonS3Client s3Client;
    public AwsS3Client(String accessKey, String secretKey)
    {
        System.setProperty("aws.accessKeyId", accessKey);
        System.setProperty("aws.secretKey", secretKey);
        AWSCredentialsProvider credentialsProvider = new ProfileCredentialsProvider();
        s3Client = new AmazonS3Client(credentialsProvider);
    }

    public AwsS3Client()
    {
    	  AWSCredentialsProvider credentialsProvider = new ProfileCredentialsProvider();
          s3Client = new AmazonS3Client(credentialsProvider);
          s3Client.setRegion(Region.getRegion(Regions.US_WEST_1));
    }

    public void createBucket(String bucketName, String prefix) {
    	s3Client.createBucket(bucketName);
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
        
        String localPath = (StringUtils.isNullOrEmpty(tmpPath) ? "" : tmpPath + "/")+ UUID.randomUUID() + "-" + name;
        String path = saveFile(objectData, localPath);
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
}
