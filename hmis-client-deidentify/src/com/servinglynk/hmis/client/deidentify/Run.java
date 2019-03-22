package com.servinglynk.hmis.client.deidentify;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Run {
	
	public static void main(String args[]) {
		Run run = new Run();
		try {
			String fileName = args[0];
			if(fileName !=null && !"".equals(fileName))
				run.deIdentifyClient(fileName);	
		} catch(ArrayIndexOutOfBoundsException ex) {
			System.out.println("Error:Please specify the file name.");
		} catch (Exception e){
			System.out.println("Error:Please contact hmislynk administrator or sandeep.dolia@gmail.com on why this process does not work.");
		}
		
	}
	
	public void deIdentifyClient(String filePath) {
	
    File tempFile = new File("HUD_"+System.currentTimeMillis()+"_deidentified_out.xml");
			try {
				
				FileInputStream fis = new FileInputStream(filePath);
				BufferedReader in = new BufferedReader(new InputStreamReader(fis));
				FileWriter fstream = new FileWriter(tempFile, false);
				BufferedWriter out = new BufferedWriter(fstream);
				String aLine = null;
				while ((aLine = in.readLine()) != null) {
				      //Process each line and add output to Dest.txt file
				      if(aLine.indexOf("<hmis:FirstName>") != -1)  {
				    	  aLine = aLine.replaceAll("(?s)<hmis:FirstName[^>]*>.*?</hmis:FirstName>",
                                  "");
				      }
				      if(aLine.indexOf("<hmis:LastName>") != -1)  {
				    	  aLine = aLine.replaceAll("(?s)<hmis:LastName[^>]*>.*?</hmis:LastName>",
				                                    "");
				      }
				      if(aLine.indexOf("<hmis:SSN>") != -1)  {
				    	  aLine = aLine.replaceAll("(?s)<hmis:SSN[^>]*>.*?</hmis:SSN>",
				                                    "");
				      }
				      if(aLine.indexOf("<hmis:DOB>") != -1)  {
				    	  String dob = aLine;
				    	  try {
				    	  aLine = aLine.substring(aLine.indexOf(":DOB>")+5,aLine.indexOf("</hmis:DOB>"));
				    	  aLine = "<hmis:DOB>"+aLine.substring(0, 8)+"01</hmis:DOB>";
				    	  }catch(IllegalArgumentException e) {
				    		  aLine = dob;
				    	  }
				      }
				      out.write(aLine);
			    	  out.newLine();
				    }
					System.out.println("Success: Deidentified the clients in the output file :"+tempFile.getAbsolutePath());
				     // do not forget to close the buffer reader
				     in.close();
				     // close buffer writer
				     out.close();
			}catch (IOException e) {
				        //Simple exception handling, replace with what's necessary for your use case!
				        throw new RuntimeException("Generating file failed", e);
				     }
     }
			
}
