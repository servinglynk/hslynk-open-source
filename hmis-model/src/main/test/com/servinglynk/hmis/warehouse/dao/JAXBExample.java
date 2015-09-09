package com.servinglynk.hmis.warehouse.dao;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;

import com.servinglynk.hmis.warehouse.domain.Sources;

public class JAXBExample {

	@Autowired
	HmisUserDao dao;

	public static void main(String[] args) {

		try {
			JAXBExample example = new JAXBExample();
			File file = new File(
					"hmismodel.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Sources.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Sources customer = (Sources) jaxbUnmarshaller.unmarshal(file);
			System.out.println(customer);

		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}
}