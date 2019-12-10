package com.servinglynk.hmis.warehouse.csv.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;

import com.servinglynk.hmis.warehouse.csv.BaseCSV;
import com.servinglynk.hmis.warehouse.csv.ProjectCOC;

@Component
public class ProjectCocCsvConverter extends BaseCsvConverter {

	public ProjectCOC entityToCsv(com.servinglynk.hmis.warehouse.model.v2020.Coc entity) {
		 ProjectCOC model = new ProjectCOC();
	     
	       model.setProjectCocID(getId(entity.getId()));
	       if(entity.getCoccode()!=null)
	       model.setCoCCode(entity.getCoccode());
	       model.setAddress1(entity.getAddress1());
	       model.setAddress2(entity.getAddress2());
	       model.setCity(entity.getCity());
	       model.setGeocode(entity.getGeoCode());
	       if(entity.getGeographyType() !=null)
	    	   model.setGeographyType(entity.getGeographyType().getValue());
	       model.setState(entity.getState());
	       model.setZIP(entity.getZip());
	       
		   if(entity.getUserId() !=null)
			model.setUserID(entity.getUserId().toString());
		model.setDateCreated(entity.getDateCreated().toString());
		model.setDateUpdated(entity.getDateUpdated().toString());
		if(entity.getExport() != null)
			model.setExportID(entity.getExport().getSourceSystemId());
		
		return model;
	}
	
	public void writeToCSV(Set<com.servinglynk.hmis.warehouse.model.v2020.Coc> ProjectCOCs,boolean fillHeaders) {
		List<BaseCSV> baseCSVs = null;
		if(fillHeaders) {
			baseCSVs = getBaseCSVs(new ProjectCOC());
		}else {
			baseCSVs = new ArrayList<BaseCSV>();
		}
		try {
		
		if(CollectionUtils.isNotEmpty(ProjectCOCs)) {
			for(com.servinglynk.hmis.warehouse.model.v2020.Coc ProjectCOC : ProjectCOCs) {
				baseCSVs.add(entityToCsv(ProjectCOC));
			}
		}
			CsvFileWriter.writeToCsv("ProjectCOC.csv",baseCSVs);
			fillHeaders = false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
		 //e.printStackTrace();
		}
	}
	
}
