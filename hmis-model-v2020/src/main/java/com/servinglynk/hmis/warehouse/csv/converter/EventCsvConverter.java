package com.servinglynk.hmis.warehouse.csv.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;

import com.servinglynk.hmis.warehouse.csv.BaseCSV;
import com.servinglynk.hmis.warehouse.csv.Event;
import com.servinglynk.hmis.warehouse.model.v2020.Client;
import com.servinglynk.hmis.warehouse.model.v2020.Enrollment;

@Component
public class EventCsvConverter extends BaseCsvConverter {

	public Event entityToCsv(com.servinglynk.hmis.warehouse.model.v2020.Event entity) {
		 Event model = new Event();
		 model.setEventID(getId(entity.getId()));
	       model.setEvent(entity.getEvent().getValue());
	       model.setEventDate(model.getEventDate());
	       model.setLocationCrisisOrPHHousing(entity.getLocationcrisisorphhousing());
	       model.setReferralCaseManageAfter(entity.getLocationcrisisorphhousing());
	       model.setReferralResult(entity.getReferralResult());
	       model.setResultDate(getDate(entity.getResultDate()));
	       
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
	
	public void writeToCSV(Set<com.servinglynk.hmis.warehouse.model.v2020.Event> Events,boolean fillHeaders) {
		List<BaseCSV> baseCSVs = null;
		if(fillHeaders) {
			baseCSVs = getBaseCSVs(new Event());
		}else {
			baseCSVs = new ArrayList<BaseCSV>();
		}
		try {
		
		if(CollectionUtils.isNotEmpty(Events)) {
			for(com.servinglynk.hmis.warehouse.model.v2020.Event Event : Events) {
				baseCSVs.add(entityToCsv(Event));
			}
		}
			CsvFileWriter.writeToCsv("Event.csv",baseCSVs);
			fillHeaders = false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
		 //e.printStackTrace();
		}
	}
	
}
