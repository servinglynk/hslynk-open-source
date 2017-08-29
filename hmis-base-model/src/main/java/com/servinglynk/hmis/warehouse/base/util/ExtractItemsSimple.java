package com.servinglynk.hmis.warehouse.base.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry;
import org.apache.commons.compress.archivers.sevenz.SevenZFile;

public class ExtractItemsSimple {
    public static void main(String[] args) {
    	extractFiles("/Users/sdolia/Downloads/2016.xml.7z", "2");
    }
    
    public static void extractFiles(String sevenzPath,String bulkUploadId) {
    	SevenZFile sevenZFile;
		try {
			sevenZFile = new SevenZFile(new File(sevenzPath));
        SevenZArchiveEntry entry = sevenZFile.getNextEntry();
        while(entry != null){
            System.out.println(entry.getName());
            new File(bulkUploadId).mkdir();
            FileOutputStream out = new FileOutputStream(bulkUploadId+"/"+entry.getName());
            byte[] content = new byte[(int) entry.getSize()];
            sevenZFile.read(content, 0, content.length);
            out.write(content);
            out.close();
            entry = sevenZFile.getNextEntry();
         }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}