package com.servinglynk.hmis.warehouse.csv.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;

import com.servinglynk.hmis.warehouse.csv.BaseCSV;
import com.servinglynk.hmis.warehouse.csv.CurrentLivingSituation;
import com.servinglynk.hmis.warehouse.enums.LivingSituationEnum;
import com.servinglynk.hmis.warehouse.enums.NoYesEnum;
import com.servinglynk.hmis.warehouse.model.v2020.Client;
import com.servinglynk.hmis.warehouse.model.v2020.Enrollment;

@Component
public class CurrentLivingSituationCsvConverter extends BaseCsvConverter {

	public CurrentLivingSituation entityToCsv(com.servinglynk.hmis.warehouse.model.v2020.CurrentLivingSituation entity) {
		 CurrentLivingSituation model = new CurrentLivingSituation();
	     
		 model.setCurrentLivingSitID(getId(entity.getId()));
		 
	       NoYesEnum leavesituation14days = entity.getLeavesituation14days();
	       if(leavesituation14days !=null)
	    	   model.setLeaveSituation14Days(leavesituation14days.getValue());
	       LivingSituationEnum livingSituation = entity.getLivingSituation();
	       if(livingSituation !=null)
	    	   model.setCurrentLivingSituation(livingSituation.getValue());
	       model.setLocationDetails(entity.getLocationdetails());
	       NoYesEnum movedtwoormore = entity.getMovedtwoormore();
	       if(movedtwoormore !=null)
	    	   model.setMovedTwoOrMore(movedtwoormore.getValue());
	       NoYesEnum resourcestoobtain = entity.getResourcestoobtain();
	       if(resourcestoobtain !=null)
	    	   model.setResourcesToObtain(resourcestoobtain.getValue());
	       NoYesEnum subsequentresidence = entity.getSubsequentresidence();
	       if(subsequentresidence !=null)
	    	   model.setSubsequentResidence(subsequentresidence.getValue());
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
		
		//model.setPITCount(entity.);
		return model;
	}
	
	public void writeToCSV(Set<com.servinglynk.hmis.warehouse.model.v2020.CurrentLivingSituation> CurrentLivingSituations,boolean fillHeaders) {
		List<BaseCSV> baseCSVs = null;
		if(fillHeaders) {
			baseCSVs = getBaseCSVs(new CurrentLivingSituation());
		}else {
			baseCSVs = new ArrayList<BaseCSV>();
		}
		try {
		
		if(CollectionUtils.isNotEmpty(CurrentLivingSituations)) {
			for(com.servinglynk.hmis.warehouse.model.v2020.CurrentLivingSituation CurrentLivingSituation : CurrentLivingSituations) {
				baseCSVs.add(entityToCsv(CurrentLivingSituation));
			}
		}
			CsvFileWriter.writeToCsv("CurrentLivingSituation.csv",baseCSVs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
		 //e.printStackTrace();
		}
	}
	
}
