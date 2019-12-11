package com.servinglynk.hmis.warehouse.csv.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;

import com.servinglynk.hmis.warehouse.csv.Affiliation;
import com.servinglynk.hmis.warehouse.csv.BaseCSV;

@Component
public class AffiliationCsvConverter extends BaseCsvConverter {

	public Affiliation entityToCsv(com.servinglynk.hmis.warehouse.model.v2020.Affiliation entity) {
		 Affiliation model = new Affiliation();
	     
		 model.setAffiliationID(getId(entity.getId()));
		 if(entity.getProjectid() !=null)
			 model.setProjectID(entity.getProjectid().getSourceSystemId());  
	     model.setResProjectID(entity.getResprojectid());

	     if(entity.getUserId() !=null)
			model.setUserID(entity.getUserId().toString());
		model.setDateCreated(entity.getDateCreated().toString());
		model.setDateUpdated(entity.getDateUpdated().toString());
		if(entity.getExport() != null)
			model.setExportID(entity.getExport().getSourceSystemId());
		
		//model.setPITCount(entity.);
		return model;
	}
	
	public void writeToCSV(Set<com.servinglynk.hmis.warehouse.model.v2020.Affiliation> affiliations,boolean fillHeaders) {
		List<BaseCSV> baseCSVs = null;
		if(fillHeaders) {
			baseCSVs = getBaseCSVs(new Affiliation());
		}else {
			baseCSVs = new ArrayList<BaseCSV>();
		}
		try {
		
		if(CollectionUtils.isNotEmpty(affiliations)) {
			for(com.servinglynk.hmis.warehouse.model.v2020.Affiliation affiliation : affiliations) {
				baseCSVs.add(entityToCsv(affiliation));
			}
		}
			CsvFileWriter.writeToCsv("Affiliation.csv",baseCSVs);
			fillHeaders = false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
		 //e.printStackTrace();
		}
	}
	
}
