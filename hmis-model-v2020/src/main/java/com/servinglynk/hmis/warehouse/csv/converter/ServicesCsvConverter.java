package com.servinglynk.hmis.warehouse.csv.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;

import com.servinglynk.hmis.warehouse.csv.BaseCSV;
import com.servinglynk.hmis.warehouse.csv.Services;
import com.servinglynk.hmis.warehouse.model.v2020.Contact;
import com.servinglynk.hmis.warehouse.model.v2020.ServiceFaReferral;

@Component
public class ServicesCsvConverter extends BaseCsvConverter {

	public Services entityToCsv(com.servinglynk.hmis.warehouse.model.v2020.Contact entity) {
		 Services model = new Services();
		 model.setServicesID(getId(entity.getId()));
		  if(entity.getContactLocation()!=null)
			  if(entity.getContactLocation() != null)
		       model.setTypeProvided(entity.getContactLocation().getValue());
		  	  
		       model.setDateProvided(getDate(entity.getContactDate()));
		       model.setRecordType("13");

	     if(entity.getUserId() !=null)
			model.setUserID(entity.getUserId().toString());
		model.setDateCreated(entity.getDateCreated().toString());
		model.setDateUpdated(entity.getDateUpdated().toString());
		if(entity.getExport() != null)
			model.setExportID(entity.getExport().getSourceSystemId());
		
		//model.setPITCount(entity.);
		return model;
	}
	
	public Services servicesToCsv(com.servinglynk.hmis.warehouse.model.v2020.ServiceFaReferral entity) {
		 Services model = new Services();
		 model.setServicesID(getId(entity.getId()));
		  model.setDateProvided(getDate(entity.getDateprovided()));
	       if(entity.getRecordType() !=null)
	    	   model.setRecordType(entity.getRecordType().getValue());
	       if(entity.getTypeProvided() != null)
	    	   model.setTypeProvided(String.valueOf(entity.getTypeProvided()));
	       model.setOtherTypeProvided(entity.getOtherTypeProvided());
	       if(entity.getSubTypeProvided() !=null)
	       model.setSubTypeProvided(String.valueOf(entity.getSubTypeProvided()));
	       if(entity.getFaAmount() !=null)
	       model.setFAAmount(String.valueOf(entity.getFaAmount().floatValue()));
	       if(entity.getReferralOutcome() !=null)
	       model.setReferralOutcome(String.valueOf(entity.getReferralOutcome()));
	       
	     if(entity.getUserId() !=null)
			model.setUserID(entity.getUserId().toString());
		model.setDateCreated(entity.getDateCreated().toString());
		model.setDateUpdated(entity.getDateUpdated().toString());
		if(entity.getExport() != null)
			model.setExportID(entity.getExport().getSourceSystemId());
		
		//model.setPITCount(entity.);
		return model;
	}
	
	public void writeToCSV(com.servinglynk.hmis.warehouse.model.v2020.Enrollment enrollment,boolean fillHeaders) {
		List<BaseCSV> baseCSVs = null;
		if(fillHeaders) {
			baseCSVs = getBaseCSVs(new Services());
		}else {
			baseCSVs = new ArrayList<BaseCSV>();
		}
		try {
		Set<Contact> contacts = enrollment.getContacts();
		if(CollectionUtils.isNotEmpty(contacts)) {
			for(com.servinglynk.hmis.warehouse.model.v2020.Contact contact : contacts) {
				baseCSVs.add(entityToCsv(contact));
			}
		}
		Set<ServiceFaReferral> services = enrollment.getServiceFaReferrals();
		if(CollectionUtils.isNotEmpty(services)) {
			for(com.servinglynk.hmis.warehouse.model.v2020.ServiceFaReferral service : services) {
				baseCSVs.add(servicesToCsv(service));
			}
		}
			CsvFileWriter.writeToCsv("Services.csv",baseCSVs);
			fillHeaders = false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
		 //e.printStackTrace();
		}
	}
	
}
