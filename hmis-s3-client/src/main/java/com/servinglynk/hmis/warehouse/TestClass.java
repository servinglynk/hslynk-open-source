package com.servinglynk.hmis.warehouse;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestClass {
    public static void main(String[] args) throws Exception {
        AwsS3Client client = new AwsS3Client(); 
        List<String> buckets = new ArrayList<String>();
        buckets.add("abc-testin-sdolis");
//        buckets.add("te0008-6546a3c1-5cc3-4d9c-afd6-691a2704d8b8");
//        buckets.add("te0003-6546a3c1-5cc3-4d9c-afd6-691a2704d8b8");
//        buckets.add("mo0006-6546a3c1-5cc3-4d9c-afd6-691a2704d8b8");
//        buckets.add("fi0009-6546a3c1-5cc3-4d9c-afd6-691a2704d8b8");
//        buckets.add("jp0005-6546a3c1-5cc3-4d9c-afd6-691a2704d8b8");
//        buckets.add("ho0002-6546a3c1-5cc3-4d9c-afd6-691a2704d8b8");
//        buckets.add("pg0001-6546a3c1-5cc3-4d9c-afd6-691a2704d8b8");
//        buckets.add("mo0010-6546a3c1-5cc3-4d9c-afd6-691a2704d8b8");
        for(String bucket : buckets) {
        	try {
        		client.createBucket(bucket.toLowerCase(), "");
        	}catch(Exception e) {
        		e.printStackTrace( );
        	}
        	
        }
//        List<String> keys = client.listBucket("sdolia-abc", "");
//        for (String key : keys) {
//            System.out.println(key);
//        }
//        String path = client.downloadFile("sdolia-2017", "HUD Sample.xml",null);
//        System.out.println(path);
//        File file = new File(path);
//        if (file.exists()) {
//            System.out.println("File found");
//          //  file.delete();
//        } else {
//            throw new IOException("path not found: " + path);
//        }
    }
}
