package com.servinglynk.hmis.warehouse.csv.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;

import com.servinglynk.hmis.warehouse.csv.Organization;
import com.servinglynk.hmis.warehouse.csv.BaseCSV;

@Component
public class OrganizationCsvConverter extends BaseCsvConverter {

	public Organization entityToCsv(com.servinglynk.hmis.warehouse.model.v2020.Organization entity) {
		 Organization model = new Organization();
	     model.setOrganizationID(getId(entity.getId()));
	     
		 model.setOrganizationCommonName(entity.getOrganizationcommonname());
	     model.setOrganizationName(entity.getOrganizationname());
	     if(entity.getUserId() !=null)
			model.setUserID(entity.getUserId().toString());
		model.setDateCreated(entity.getDateCreated().toString());
		model.setDateUpdated(entity.getDateUpdated().toString());
		if(entity.getExport() != null)
			model.setExportID(entity.getExport().getSourceSystemId());
		
		//model.setPITCount(entity.);
		return model;
	}
	
	public void writeToCSV(com.servinglynk.hmis.warehouse.model.v2020.Organization organization,boolean fillHeaders) {
		List<BaseCSV> baseCSVs = null;
		if(fillHeaders) {
			baseCSVs = getBaseCSVs(new Organization());
		}else {
			baseCSVs = new ArrayList<BaseCSV>();
		}
		try {
		
				baseCSVs.add(entityToCsv(organization));
			CsvFileWriter.writeToCsv("Organization.csv",baseCSVs);
			fillHeaders = false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
		 //e.printStackTrace();
		}
	}
	
}
