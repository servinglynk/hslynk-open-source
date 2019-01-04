package com.servinglynk.hmis.warehouse;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.lang3.StringUtils;

public class ZipFileExample {
    private static final String INPUT_FOLDER = "/Users/sdolia/github/hmis-lynk-open-source/hmis-hud-reports";
    private static final String ZIPPED_FOLDER = "/Users/sdolia/github/hmis-lynk-open-source/hmis-hud-reports/TestFiles.zip";
    public static void main(String[] args) {
        zipSimpleFolder(new File(INPUT_FOLDER),"", ZIPPED_FOLDER);
    }
    public static void zipSimpleFolder(File inputFolder, String parentName ,String zipFilePath ){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(zipFilePath);
            ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);
            String myname = parentName +inputFolder.getName()+"\\";
            ZipEntry folderZipEntry = new ZipEntry(myname);
            zipOutputStream.putNextEntry(folderZipEntry);
            File[] contents = inputFolder.listFiles();
            for (File f : contents){
                if (f.isFile() && StringUtils.contains(f.getName(), ".csv"))
                    zipFile(f,myname,zipOutputStream);
            }
            zipOutputStream.closeEntry();
            zipOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void zipFile(File inputFile,String parentName,ZipOutputStream zipOutputStream) {
        try {
            // A ZipEntry represents a file entry in the zip archive
            // We name the ZipEntry after the original file's name
            ZipEntry zipEntry = new ZipEntry(parentName+inputFile.getName());
            zipOutputStream.putNextEntry(zipEntry);
            FileInputStream fileInputStream = new FileInputStream(inputFile);
            byte[] buf = new byte[1024];
            int bytesRead;
            // Read the input file by chucks of 1024 bytes
            // and write the read bytes to the zip stream
            while ((bytesRead = fileInputStream.read(buf)) > 0) {
                zipOutputStream.write(buf, 0, bytesRead);
            }
            // close ZipEntry to store the stream to the file
            zipOutputStream.closeEntry();
            System.out.println("Regular file :" + inputFile.getCanonicalPath()+" is zipped to archive :"+ZIPPED_FOLDER);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
