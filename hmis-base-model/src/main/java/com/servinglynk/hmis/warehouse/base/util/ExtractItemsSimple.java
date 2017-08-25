package com.servinglynk.hmis.warehouse.base.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry;
import org.apache.commons.compress.archivers.sevenz.SevenZFile;

public class ExtractItemsSimple {
    public static void main(String[] args) throws IOException {
    	SevenZFile sevenZFile = new SevenZFile(new File("/Users/sdolia/Downloads/test.7z"));
        SevenZArchiveEntry entry = sevenZFile.getNextEntry();
        while(entry!=null){
            System.out.println(entry.getName());
            FileOutputStream out = new FileOutputStream(entry.getName());
            byte[] content = new byte[(int) entry.getSize()];
            sevenZFile.read(content, 0, content.length);
            out.write(content);
            out.close();
            entry = sevenZFile.getNextEntry();
        }
        sevenZFile.close();
    }
}