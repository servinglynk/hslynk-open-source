package com.servinglynk.hmis.warehouse.csv.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;

import com.servinglynk.hmis.warehouse.csv.BaseCSV;
import com.servinglynk.hmis.warehouse.csv.Funder;

@Component
public class FunderCsvConverter extends BaseCsvConverter {

	public Funder entityToCsv(com.servinglynk.hmis.warehouse.model.v2020.Funder entity) {
		 Funder model = new Funder();
	     
		 model.setFunderID(getId(entity.getId()));
		 if(entity.getProjectid() !=null)
			 model.setProjectID(entity.getProjectid().getSourceSystemId());  
		 if(entity.getFunder() !=null)
			 model.setFunder(entity.getFunder().getValue());
		 if(entity.getEnddate() !=null) 
			model.setEndDate(entity.getEnddate().toString());
		 if(entity.getGrantid() != null)
			 model.setGrantID(entity.getGrantid().toString());
		 if(model.getStartDate() != null)
			 model.setStartDate(entity.getStartdate().toString());
	     if(entity.getUserId() !=null)
			model.setUserID(entity.getUserId().toString());
		model.setDateCreated(entity.getDateCreated().toString());
		model.setDateUpdated(entity.getDateUpdated().toString());
		if(entity.getExport() != null)
			model.setExportID(entity.getExport().getSourceSystemId());
		
		//model.setPITCount(entity.);
		return model;
	}
	
	public void writeToCSV(Set<com.servinglynk.hmis.warehouse.model.v2020.Funder> Funders,boolean fillHeaders) {
		
		List<BaseCSV> baseCSVs = null;
		if(fillHeaders) {
			baseCSVs = getBaseCSVs(new Funder());
		}else {
			baseCSVs = new ArrayList<BaseCSV>();
		}
		
		try {
		if(CollectionUtils.isNotEmpty(Funders)) {
			for(com.servinglynk.hmis.warehouse.model.v2020.Funder Funder : Funders) {
				baseCSVs.add(entityToCsv(Funder));
			}
		}
			CsvFileWriter.writeToCsv("Funder.csv",baseCSVs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
		 //e.printStackTrace();
		}
	}
}
