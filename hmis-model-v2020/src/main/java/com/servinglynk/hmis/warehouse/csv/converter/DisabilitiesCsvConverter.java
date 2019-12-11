package com.servinglynk.hmis.warehouse.csv.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;

import com.servinglynk.hmis.warehouse.csv.BaseCSV;
import com.servinglynk.hmis.warehouse.csv.Disabilities;
import com.servinglynk.hmis.warehouse.model.v2020.Client;
import com.servinglynk.hmis.warehouse.model.v2020.Enrollment;

@Component
public class DisabilitiesCsvConverter extends BaseCsvConverter {

	public Disabilities entityToCsv(com.servinglynk.hmis.warehouse.model.v2020.Disabilities entity) {
		 Disabilities model = new Disabilities();
		 model.setDisabilitiesID(getId(entity.getId()));
	       if(entity.getInformationDate()!=null)
	       model.setInformationDate(getDate(entity.getInformationDate()));
	       if(entity.getDataCollectionStage() !=null)
	    	   model.setDataCollectionStage(entity.getDataCollectionStage().getValue());
	if(entity.getDisabilitytype()!=null)
	       model.setDisabilityType(entity.getDisabilitytype().getValue());
	if(entity.getDisabilityresponse() !=null)
		model.setDisabilityResponse(String.valueOf(entity.getDisabilityresponse()));
	       
	if(entity.getIndefiniteandimpairs()!=null)
	       model.setIndefiniteAndImpairs(entity.getIndefiniteandimpairs().getValue());
	if(entity.getTcellcountavailable()!=null)
	       model.setTCellCountAvailable(entity.getTcellcountavailable().getValue());
	if(entity.getTcellcount()!=null)
	       model.setTCellCount(String.valueOf(entity.getTcellcount()));
	if(entity.getTcellcountsource()!=null)
	       model.setTCellSource(entity.getTcellcountsource().getValue());
	if(entity.getViralLoadAvailable()!=null)
	       model.setViralLoadAvailable(entity.getViralLoadAvailable().getValue());
	if(entity.getViralLoad()!=null)
	       model.setViralLoad(String.valueOf(entity.getViralLoad()));
	if(entity.getViralLoadSource()!=null)
	       model.setViralLoadSource(entity.getViralLoadSource().getValue());

	       Enrollment enrollmentid = entity.getEnrollmentid();
	       if(enrollmentid != null) {
	    	   model.setEnrollmentID(getId(enrollmentid.getId()));
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
		
		//model.setPITCount(entity.);
		return model;
	}
	
	public void writeToCSV(Set<com.servinglynk.hmis.warehouse.model.v2020.Disabilities> Disabilitiess,boolean fillHeaders) {
		List<BaseCSV> baseCSVs = null;
		if(fillHeaders) {
			baseCSVs = getBaseCSVs(new Disabilities());
		}else {
			baseCSVs = new ArrayList<BaseCSV>();
		}
		try {
		
		if(CollectionUtils.isNotEmpty(Disabilitiess)) {
			for(com.servinglynk.hmis.warehouse.model.v2020.Disabilities Disabilities : Disabilitiess) {
				baseCSVs.add(entityToCsv(Disabilities));
			}
		}
			CsvFileWriter.writeToCsv("Disabilities.csv",baseCSVs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
		 //e.printStackTrace();
		}
	}
	
}
