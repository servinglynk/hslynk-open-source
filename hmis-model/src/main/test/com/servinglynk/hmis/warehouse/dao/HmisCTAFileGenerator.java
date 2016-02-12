package com.servinglynk.hmis.warehouse.dao;

import java.io.File;
import java.net.URL;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;


/*import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;*/


public class HmisCTAFileGenerator {
	URL path = HmisCTAFileGenerator.class.getResource("HUD_4_0__6.xml");
	URL xslpath = HmisCTAFileGenerator.class.getResource("HUD_4_0__6_Input.xsl");
	URL output = HmisCTAFileGenerator.class.getResource("HUD_4_0__6_Output.xml");
	public void xmlXSLTransorm() {
		try{
				/*Source xmlInput = new StreamSource(path.getPath());
				Source xsl = new StreamSource(new File(xslpath.getPath()));
			    Result xmlOutput = new StreamResult(new File(output.getPath()));
			    */
	                Source xmlInput = new StreamSource("C:/HMIS/hmis-lynk-open-source/hmis-model/src/main/test/com/servinglynk/hmis/warehouse/dao/HUD_4_0__6.xml");
	                Source xsl = new StreamSource(new File("C:/HMIS/hmis-lynk-open-source/hmis-model/src/main/test/com/servinglynk/hmis/warehouse/dao/HUD_4_0__6_Input.xsl"));
	                Result xmlOutput = new StreamResult(new File("C:/HMIS/hmis-lynk-open-source/hmis-model/src/main/test/com/servinglynk/hmis/warehouse/dao/HUD_4_0__6_Output.xml"));
	                Transformer transformer = TransformerFactory.newInstance().newTransformer(xsl);
	                transformer.transform(xmlInput, xmlOutput);
	                System.out.println("Successfully Updated in Output.XML " );
		}catch (TransformerException e) {
	         e.printStackTrace();
		}
	}
	
	public static void main (String args[]){
		
		HmisCTAFileGenerator hudXSLT = new HmisCTAFileGenerator();
		hudXSLT.xmlXSLTransorm();
		
	   }
}
