package com.servinglynk.hmis.warehouse;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class TestClass {
    public static void main(String[] args) throws Exception {
        AwsS3Client client = new AwsS3Client();
        List<String> keys = client.listBucket("sdolia-2015", "");
        for (String key : keys) {
            System.out.println(key);
        }
        String path = client.downloadFile("sdolia-2015", "HUD Sample.xml",null);
        System.out.println(path);
        File file = new File(path);
        if (file.exists()) {
            System.out.println("File found");
          //  file.delete();
        } else {
            throw new IOException("path not found: " + path);
        }
    }
}
