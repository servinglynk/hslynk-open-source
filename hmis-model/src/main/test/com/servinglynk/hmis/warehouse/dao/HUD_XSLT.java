package com.servinglynk.hmis.warehouse.dao;

import java.io.File;
import java.net.URL;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;


/*import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;*/


public class HUD_XSLT {
	URL path = BulkUploaderTest.class.getResource("HUD_4_0__6.xml");
	URL xslpath = BulkUploaderTest.class.getResource("HUD_4_0__6_Input.xsl");
	URL output = BulkUploaderTest.class.getResource("HUD_4_0__6_Output.xml");
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
		
		HUD_XSLT hudXSLT = new HUD_XSLT();
		hudXSLT.xmlXSLTransorm();
		
	   }
}
