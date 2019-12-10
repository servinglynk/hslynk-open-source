package com.servinglynk.hmis.warehouse.csv.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;

import com.servinglynk.hmis.warehouse.csv.BaseCSV;
import com.servinglynk.hmis.warehouse.csv.EnrollmentCoC;

@Component
public class EnrollmentCocCsvConverter extends BaseCsvConverter {

	public EnrollmentCoC entityToCsv(com.servinglynk.hmis.warehouse.model.v2020.EnrollmentCoc entity) {
		EnrollmentCoC model = new EnrollmentCoC();
		if(entity.getDataCollectionStage() !=null)
	 	  model.setDataCollectionStage(entity.getDataCollectionStage().getValue());
		
    	  model.setEnrollmentCOCID(getId(entity.getId()));
    	  if(entity.getEnrollmentid() !=null) 
    		  model.setEnrollmentID(getId(entity.getEnrollmentid().getId()));
    	  model.setHouseholdID(entity.getHouseholdId());
    	  model.setInformationDate(getDate(entity.getInformationDate()));
    	  model.setCoCCode(entity.getCocCode());
   
	     if(entity.getUserId() !=null)
			model.setUserID(entity.getUserId().toString());
		model.setDateCreated(entity.getDateCreated().toString());
		model.setDateUpdated(entity.getDateUpdated().toString());
		if(entity.getExport() != null)
			model.setExportID(entity.getExport().getSourceSystemId());
		
		return model;
	}
	
	public void writeToCSV(Set<com.servinglynk.hmis.warehouse.model.v2020.EnrollmentCoc> enrollmentCocs,boolean fillHeaders) {
		List<BaseCSV> baseCSVs = null;
		if(fillHeaders) {
			baseCSVs = getBaseCSVs(new EnrollmentCoC());
		}else {
			baseCSVs = new ArrayList<BaseCSV>();
		}
		try {
		
		if(CollectionUtils.isNotEmpty(enrollmentCocs)) {
			for(com.servinglynk.hmis.warehouse.model.v2020.EnrollmentCoc enrollmentCoc : enrollmentCocs) {
				baseCSVs.add(entityToCsv(enrollmentCoc));
			}
		}
			CsvFileWriter.writeToCsv("EnrollmentCoC.csv",baseCSVs);
			fillHeaders = false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
		 //e.printStackTrace();
		}
	}
	
}
