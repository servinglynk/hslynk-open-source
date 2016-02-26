package com.servinglynk.hmis.warehouse.dao.helper;



import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class XSDValidator {
    public static void validateFile(File xmlFile, File xsdFile) throws SAXException, IOException
    {
        // 1. Lookup a factory for the W3C XML Schema language
        SchemaFactory factory = SchemaFactory.newInstance("http://www.w3.org/XML/XMLSchema/v1.1");
        // SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

        // 2. Compile the schema.
        File schemaLocation = xsdFile;
        Schema schema = factory.newSchema(schemaLocation);

        // 3. Get a validator from the schema.
        Validator validator = schema.newValidator();

        // 4. Parse the document you want to check.
        Source source = new StreamSource(xmlFile);

        // 5. Check the document
        try
        {
            validator.validate(source);
            System.out.println(xmlFile.getName() + " is valid.");
        }
        catch (SAXException ex)
        {
            System.out.println(xmlFile.getName() + " is not valid because ");
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    public static void main(String args[]) throws SAXException, IOException {
    	URL path = BulkUploadHelper.class.getResource("HUD_4_0__6_XSD_Fix.xml");
    	validateFile(new File(path.getPath()), new File("C:\\HMIS\\hmis-lynk-open-source\\hmis-model\\src\\main\\test\\com\\servinglynk\\hmis\\warehouse\\dao\\HUD_HMIS.xsd"));
    }
    
}