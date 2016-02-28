package com.servinglynk.hmis.warehouse.dao.helper;

import java.io.File;
import java.net.URL;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.util.StringUtils;

public class ClientIdentifierExtractor {
	static URL xslpath = ClientIdentifierExtractor.class.getResource("HUD_4_0__6_Input.xsl");
	public static void xmlXSLTransorm(String inputFileUrl,String outputFileUrl) {
		try{
					String xslPath = "/proj/xsl/HUD_4_0__6_Input.xsl";
	                Source xmlInput = new StreamSource(inputFileUrl);
	                if(xslpath != null && !StringUtils.isEmpty(xslpath.getPath())) {
	                	xslPath = xslpath.getPath();
	                }
	                Source xsl = new StreamSource(new File(xslPath));
	                Result xmlOutput = new StreamResult(new File(outputFileUrl));
	                Transformer transformer = TransformerFactory.newInstance().newTransformer(xsl);
	                transformer.transform(xmlInput, xmlOutput);
		}catch (TransformerException e) {
	         e.printStackTrace();
		}
	}
	
	public static void main (String args[]){
		
		ClientIdentifierExtractor hudXSLT = new ClientIdentifierExtractor();
		 hudXSLT.xmlXSLTransorm("C:/HMIS/hmis-lynk-open-source/hmis-model/src/main/test/com/servinglynk/hmis/warehouse/dao/HUD_4_0__6.xml","C:/HMIS/hmis-lynk-open-source/hmis-model/src/main/test/com/servinglynk/hmis/warehouse/dao/HUD_4_0__6_Output.xml");
	   }
}
