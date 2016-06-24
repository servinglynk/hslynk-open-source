package com.servinglynk.hmis.warehouse.upload.csv;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;


public class ExtractZipContents {

	public void test() {

		try {
			URL path = ExtractZipContents.class.getResource("CSV_files.rar");
			ZipFile zipFile = new ZipFile("C:/HMIS/servinglynk-hmis/hmis-load-processor/src/main/java/com/servinglynk/hmis/warehouse/upload/csv/CSV_files.zip");
			Enumeration<?> enu = zipFile.entries();
			while (enu.hasMoreElements()) {
				ZipEntry zipEntry = (ZipEntry) enu.nextElement();

				String name = zipEntry.getName();
				long size = zipEntry.getSize();
				long compressedSize = zipEntry.getCompressedSize();
				System.out.printf("name: %-20s | size: %6d | compressed size: %6d\n", 
						name, size, compressedSize);
				File file = new File(name);
/*
				// create a BeanIO StreamFactory
		        StreamFactory factory = StreamFactory.newInstance();
		        // load the mapping file from the working directory
		        
		        factory.load(file);
		        // create a BeanReader to read from "input.csv"
		        
		        BeanReader in = factory.createReader("client", file);
				
		        Object record = null;
		        
		        // read records from "input.csv"
		        while ((record = in.read()) != null) {
		            // process each record
		                Map<String,Object> header = (Map<String,Object>) record;
		                //System.out.println(header.get("fileDate"));
		                if(name.contains("Client")) {
		                	Client client = (Client) record;
		                	System.out.println("Client :"+client.toString());
		                	
		                }
		                
		                // process the contact...
		        }
		        
		        in.close(); */
				
				if (name.endsWith("/")) {
					file.mkdirs();
					continue;
				}

				File parent = file.getParentFile();
				if (parent != null) {
					parent.mkdirs();
				}

				InputStream is = zipFile.getInputStream(zipEntry);
				FileInputStream fis = null;

				try {
					fis = new FileInputStream(file);

					System.out.println("Total file size to read (in bytes) : "
							+ fis.available());

					int content;
					while ((content = fis.read()) != -1) {
						// convert to char and display it
						System.out.print((char) content);
					}

				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						if (fis != null)
							fis.close();
					} catch (IOException ex) {
						ex.printStackTrace();
					}
				}
				/*
				FileOutputStream fos = new FileOutputStream(file);
				byte[] bytes = new byte[1024];
				int length;
				while ((length = is.read(bytes)) >= 0) {
					fos.write(bytes, 0, length);
				}
				is.close();
				fos.close();
*/
			}
			zipFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
