package com.servinglynk.hmis.warehouse.dao.helper;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.Source;
import javax.xml.transform.stax.StAXSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.xml.sax.SAXException;

public class Validate {

	public static void main(String[] args) throws  XMLStreamException, IOException, SAXException {		
		XMLInputFactory factory = XMLInputFactory.newInstance();
		XMLStreamReader reader = factory.createXMLStreamReader(new FileInputStream(new File("/home/user/Desktop/HUD_instance.xml")));

		Source instanceDocument = new StAXSource(reader);
		StreamSource schemaDocument = new StreamSource("file:///home/user/git/hmis-xml/src/HUD_HMIS.xsd");
//		StreamSource schemaDocument = new StreamSource("https://raw.githubusercontent.com/hmis-interop/xml/v6.1.1/src/HUD_HMIS.xsd");
		SchemaFactory sf = SchemaFactory.newInstance("http://www.w3.org/XML/XMLSchema/v1.1");
		Schema s = sf.newSchema(schemaDocument);
		Validator v = s.newValidator();
		try {
			v.validate(instanceDocument);
			System.out.println("Document is valid.");
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Document is not valid:");
			//System.out.println(e.getMessage()); 
			System.out.println(e.toString());
			//System.out.println(e.getCause());
			//System.out.println(e.getException());
		}

	}	
}
