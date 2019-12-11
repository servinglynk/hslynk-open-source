package com.servinglynk.hmis.warehouse.csv.converter;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;

import com.servinglynk.hmis.warehouse.csv.BaseCSV;
import com.servinglynk.hmis.warehouse.csv.Enrollment;
import com.servinglynk.hmis.warehouse.csv.Project;

@Component
public class ProjectCsvConverter extends BaseCsvConverter{

	public Project entityToCsv(com.servinglynk.hmis.warehouse.model.v2020.Project entity) {
		Project  model = new Project();
		if(entity.getContinuumproject() !=null)
			model.setContinuumProject(entity.getContinuumproject().getValue());
		model.setDateCreated(entity.getDateCreated().toString());
		model.setDateUpdated(entity.getDateUpdated().toString());
		if(entity.getExport() != null)
			model.setExportID(entity.getExport().getSourceSystemId());
		if(entity.getHmisParticipatingProject() != null)
		model.setHMISParticipatingProject(entity.getHmisParticipatingProject().getValue());
		if(entity.getHousingType() !=null)
			model.setHousingType(entity.getHousingType().getValue());
		if(entity.getOperatingEndDate() !=null)
			model.setOperatingEndDate(entity.getOperatingEndDate().toString());
		if(entity.getOperatingStartDate() !=null)
			model.setOperatingStartDate(entity.getOperatingStartDate().toString());
		if(entity.getOrganizationid() != null)
			model.setOrganizationID(entity.getOrganizationid().getSourceSystemId());
		
		model.setProjectCommonName(entity.getProjectcommonname());
		model.setProjectID(getId(entity.getId()));
		model.setProjectName(entity.getProjectname());
		if(entity.getProjecttype() != null)
			model.setProjectType(entity.getProjecttype().getValue());
		if(entity.getResidentialaffiliation() !=null)
			model.setResidentialAffiliation(entity.getResidentialaffiliation().getValue());
		if(entity.getTargetpopulation() !=null)
			model.setTargetPopulation(entity.getTargetpopulation().getValue());
		if(entity.getTrackingmethod() != null)
			model.setTrackingMethod(entity.getTrackingmethod().getValue());
		if(entity.getUserId() !=null)
		model.setUserID(entity.getUserId().toString());
		//model.setPITCount(entity.);
		return model;
	}
	
	public void writeToCSV(List<com.servinglynk.hmis.warehouse.model.v2020.Project> projects,boolean fillHeaders) {
		List<BaseCSV> baseCSVs = null;
		if(fillHeaders) {
			baseCSVs = getBaseCSVs(new Enrollment());
		}else {
			baseCSVs = new ArrayList<BaseCSV>();
		}
		try {
		if(CollectionUtils.isNotEmpty(projects)) {
			for(com.servinglynk.hmis.warehouse.model.v2020.Project project : projects) {
				baseCSVs.add(entityToCsv(project));
			}
		}
		
			CsvFileWriter.writeToCsv("Project.csv",baseCSVs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
		 //e.printStackTrace();
		}
	}
	
}
