package com.servinglynk.hmis.warehouse.dao;

import java.io.File;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;

import com.servinglynk.hmis.warehouse.domain.Sources;

public class BulkUploaderUnMarshallerTest {

	@Autowired
	HmisUserDao dao;

	public static void main(String[] args) {

		try {
			BulkUploaderUnMarshallerTest example = new BulkUploaderUnMarshallerTest();
			URL path = BulkUploaderUnMarshallerTest.class.getResource("hmismodel.xml");
			File file = new File(
					path.getFile());
			JAXBContext jaxbContext = JAXBContext.newInstance(Sources.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Sources customer = (Sources) jaxbUnmarshaller.unmarshal(file);
			System.out.println(customer);

		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}
}