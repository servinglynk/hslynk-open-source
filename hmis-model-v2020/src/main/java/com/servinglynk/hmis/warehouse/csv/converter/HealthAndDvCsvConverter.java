package com.servinglynk.hmis.warehouse.csv.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;

import com.servinglynk.hmis.warehouse.csv.BaseCSV;
import com.servinglynk.hmis.warehouse.csv.HealthAndDV;
import com.servinglynk.hmis.warehouse.model.v2020.Client;
import com.servinglynk.hmis.warehouse.model.v2020.Domesticviolence;
import com.servinglynk.hmis.warehouse.model.v2020.Enrollment;

@Component
public class HealthAndDvCsvConverter extends BaseCsvConverter {

	public HealthAndDV entityToCsv(com.servinglynk.hmis.warehouse.model.v2020.HealthStatus entity) {
		 HealthAndDV model = new HealthAndDV();
		 model.setHealthAndDVID(getId(entity.getId()));
	       if(entity.getInformationDate()!=null)
	       model.setInformationDate(getDate(entity.getInformationDate()));
	       if(entity.getDataCollectionStage() !=null)
	    	   model.setDataCollectionStage(entity.getDataCollectionStage().getValue());
//	       if(entity.getHealthCategory()!=null)
//	           model.setentity.getHealthCategory().getValue()));
	    if(entity.getHealthStatus()!=null)
	           model.setGeneralHealthStatus(entity.getHealthStatus().getValue());
	    if(entity.getDueDate()!=null)
	           model.setDueDate(getDate(entity.getDueDate()));
	       
	       Enrollment enrollmentid = entity.getEnrollmentid();
	       if(enrollmentid != null) {
	    	   model.setProjectEntryID(getId(enrollmentid.getId()));
	    	   
	    	   Client client = enrollmentid.getClient();
	    	   if(client != null)
	    		   model.setPersonalID(getId(client.getId()));
	       }
	     if(entity.getUserId() !=null)
			model.setUserID(entity.getUserId().toString());
		model.setDateCreated(entity.getDateCreated().toString());
		model.setDateUpdated(entity.getDateUpdated().toString());
		if(entity.getExport() != null)
			model.setExportID(entity.getExport().getSourceSystemId());
		
		return model;
	}
	
	public HealthAndDV domesticVoilencesToCsv(com.servinglynk.hmis.warehouse.model.v2020.Domesticviolence entity) {
		 HealthAndDV model = new HealthAndDV();
		 model.setHealthAndDVID(getId(entity.getId()));
	       if(entity.getInformationDate()!=null)
	       model.setInformationDate(getDate(entity.getInformationDate()));
	       if(entity.getDataCollectionStage() !=null)
	    	   model.setDataCollectionStage(entity.getDataCollectionStage().getValue());

	       if(entity.getDomesticviolencevictim()!=null)
	           model.setDomesticViolenceVictim(entity.getDomesticviolencevictim().getValue());
	      if(entity.getWhenoccurred()!=null)
	           model.setWhenOccurred(entity.getWhenoccurred().getValue());
	      if(entity.getDataCollectionStage() !=null)
	         model.setDataCollectionStage(entity.getDataCollectionStage().getValue());

	      model.setCurrentlyFleeing(String.valueOf(entity.getCurrentlyFleeing()));

	      Enrollment enrollmentid = entity.getEnrollmentid();
	       if(enrollmentid != null) {
	    	   model.setProjectEntryID(getId(enrollmentid.getId()));
	    	   Client client = enrollmentid.getClient();
	    	   if(client != null)
	    		   model.setPersonalID(getId(client.getId()));
	       }
	     if(entity.getUserId() !=null)
			model.setUserID(entity.getUserId().toString());
		model.setDateCreated(entity.getDateCreated().toString());
		model.setDateUpdated(entity.getDateUpdated().toString());
		if(entity.getExport() != null)
			model.setExportID(entity.getExport().getSourceSystemId());
		
		return model;
	}
	
	public void writeToCSV(com.servinglynk.hmis.warehouse.model.v2020.Enrollment enrollment,boolean fillHeaders) {
		Set<com.servinglynk.hmis.warehouse.model.v2020.HealthStatus> healthStatuses  = enrollment.getHealthStatuses();
		List<BaseCSV> baseCSVs = null;
		if(fillHeaders) {
			baseCSVs = getBaseCSVs(new HealthAndDV());
		}else {
			baseCSVs = new ArrayList<BaseCSV>();
		}
		try {
		
		if(CollectionUtils.isNotEmpty(healthStatuses)) {
			for(com.servinglynk.hmis.warehouse.model.v2020.HealthStatus healthStatus : healthStatuses) {
				baseCSVs.add(entityToCsv(healthStatus));
			}
		}
		Set<Domesticviolence> domesticVoilences = enrollment.getDomesticviolences();
		if(CollectionUtils.isNotEmpty(domesticVoilences)) {
			for(com.servinglynk.hmis.warehouse.model.v2020.Domesticviolence domesticviolence : domesticVoilences) {
				baseCSVs.add(domesticVoilencesToCsv(domesticviolence));
			}
		}
			CsvFileWriter.writeToCsv("HealthAndDV.csv",baseCSVs);
			fillHeaders = false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
		 //e.printStackTrace();
		}
	}
	
}
