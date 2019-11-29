package com.servinglynk.hmis.warehouse.base.service.converter;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.servinglynk.hmis.warehouse.core.model.FileExport;
import com.servinglynk.hmis.warehouse.core.model.Project;
import com.servinglynk.hmis.warehouse.enums.ExportLevelEnum;
import com.servinglynk.hmis.warehouse.enums.ExportTypeEnum;
import com.servinglynk.hmis.warehouse.model.base.FileExportEntity;
import com.servinglynk.hmis.warehouse.model.base.FileExportParamEntity;

public class FileExportConverter {

	public static LocalDateTime convertToLocalDateTimeViaInstant(Date dateToConvert) {
		if(dateToConvert != null) {
			return dateToConvert.toInstant()
				      .atZone(ZoneId.systemDefault())
				      .toLocalDateTime();
		}
	    return null;
	}
	
	public static FileExport entityToModel(FileExportEntity fileExportEntity){
		FileExport fileExport = new FileExport();
//		if(fileExportEntity.getCocId()!= null)
//			fileExport.setCocId(String.valueOf(fileExportEntity.getCocId()));
		fileExport.setDateCreated(fileExportEntity.getDateCreated());
		fileExport.setDateUpdated(fileExportEntity.getDateUpdated());
		fileExport.setStartDate(convertToDate(fileExportEntity.getStartDate()));
		fileExport.setEmailSent(fileExportEntity.isEmailSent());
		fileExport.setEndDate(convertToDate(fileExportEntity.getEndDate()));
		fileExport.setId(fileExportEntity.getId());
		fileExport.setName(fileExportEntity.getName());
		fileExport.setProjectGroupCode(fileExportEntity.getProjectGroupCode());
		fileExport.setExportLevel(fileExportEntity.getExportLevel().getValue());
		fileExport.setExportType(fileExportEntity.getExportType().getValue());
		fileExport.setStatus(fileExportEntity.getStatus());
		fileExport.setCreatedBy(fileExportEntity.getCreatedBy());
		fileExport.setUpdatedBy(fileExportEntity.getUpdatedBy());
		List<FileExportParamEntity> fileExportParams = fileExportEntity.getFileExportParams();
		List<Project> projectIds = new ArrayList<>();
		if(CollectionUtils.isNotEmpty(fileExportParams)) {
			for(FileExportParamEntity  param : fileExportParams) {
				if(StringUtils.equals("PROJECT_ID",param.getKey())) {
					Project reportProject = new Project();
					reportProject.setProjectId(param.getValue());
					projectIds.add(reportProject);
				}
			}
		fileExport.setProjectIds(projectIds);
		}
		return fileExport;
	}

	public static Date convertToDate(LocalDateTime localDate) {
		if(localDate != null) {
			Instant instant = localDate.atZone(ZoneId.systemDefault()).toInstant();
		    Date date = Date.from(instant);
		    return date;
		}
		return null;
	}
	public static FileExportEntity modelToEntity(FileExportEntity fileExportEntity,FileExport fileExport){
		if(fileExportEntity==null){
			fileExportEntity = new FileExportEntity();
		}
	
		if(fileExport.getDateCreated() != null)
			fileExportEntity.setDateCreated(fileExport.getDateCreated());
		fileExportEntity.setEmailSent(fileExport.isEmailSent());
		fileExportEntity.setEndDate(convertToLocalDateTimeViaInstant(fileExport.getEndDate()));
		fileExportEntity.setId(fileExport.getId());
		fileExportEntity.setName(fileExport.getName());
		fileExportEntity.setProjectGroupCode(fileExport.getProjectGroupCode());
		if(StringUtils.isNotBlank(fileExport.getExportLevel()))
			fileExportEntity.setExportLevel(ExportLevelEnum.lookupEnum(fileExport.getExportLevel()));
		if(StringUtils.isNotBlank(fileExport.getExportType())) 
			fileExportEntity.setExportType(ExportTypeEnum.lookupEnum(fileExport.getExportType()));
		fileExportEntity.setStartDate(convertToLocalDateTimeViaInstant(fileExport.getStartDate()));
		fileExportEntity.setStatus(fileExport.getStatus());
		fileExportEntity.setCreatedBy(fileExport.getCreatedBy());
		fileExportEntity.setUpdatedBy(fileExport.getUpdatedBy());
		return fileExportEntity;
	}
}
