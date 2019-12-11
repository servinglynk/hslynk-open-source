package com.servinglynk.hmis.warehouse.csv.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;

import com.servinglynk.hmis.warehouse.csv.Export;
import com.servinglynk.hmis.warehouse.model.v2020.Source;
import com.servinglynk.hmis.warehouse.csv.BaseCSV;

@Component
public class ExportCsvConverter extends BaseCsvConverter {

	public Export entityToCsv(com.servinglynk.hmis.warehouse.model.v2020.Export entity) {
		 Export model = new Export();
	     
		 model.setExportID(getId(entity.getId()));
		 model.setExportDate(getDate(entity.getExportDate()));
		 model.setExportDirective(entity.getExportdirective());
		 model.setExportPeriodType(entity.getExportdirective());
		 model.setExportStartDate(getDate(entity.getStartDate()));
		 model.setExportEndDate(getDate(entity.getEndDate()));
		 Source source = entity.getSource();
		 if(source != null) {
			 model.setSoftwareName(source.getSoftwarename());
			 model.setSoftwareVersion(source.getSoftwareversion());
			 model.setSourceContactEmail(source.getSourcecontactemail());
//			 model.setSourceContactPhone(entity.getp);
			 
		 }
		return model;
	}
	
	public void writeToCSV(com.servinglynk.hmis.warehouse.model.v2020.Export export,boolean fillHeaders) {
		List<BaseCSV> baseCSVs = null;
		if(fillHeaders) {
			baseCSVs = getBaseCSVs(new Export());
		}else {
			baseCSVs = new ArrayList<BaseCSV>();
		}
		
		try {
		
				baseCSVs.add(entityToCsv(export));
			CsvFileWriter.writeToCsv("Export.csv",baseCSVs);
			fillHeaders = false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
		 //e.printStackTrace();
		}
	}
	
}
