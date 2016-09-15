package com.servinglynk.hmis.warehouse.dao;

import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.servinglynk.hmis.warehouse.base.util.ErrorType;
import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export;
import com.servinglynk.hmis.warehouse.model.v2014.Error2014;
import com.servinglynk.hmis.warehouse.model.v2014.HmisBaseModel;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

public class ExportDaoImpl extends ParentDaoImpl implements ExportDao {
	private static final Logger logger = LoggerFactory
			.getLogger(ExportDaoImpl.class);
	@Override
	
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) {
		Export export = domain.getExport();
		Data data = new Data();
		Map<String, HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2014.Export.class, getProjectGroupCode(domain));
		com.servinglynk.hmis.warehouse.model.v2014.Export model = null;
		try {
			model = getModelObject(domain, export, data, modelMap);
			model.setExportDate(BasicDataGenerator.getLocalDateTime(export.getExportDate()));
			model.setExportdirective(export.getExportDirective());
			model.setExportperiodtype(export.getExportPeriodType());
			model.setSourceSystemId(export.getExportID());
			com.servinglynk.hmis.warehouse.model.v2014.Source sourceEntity = (com.servinglynk.hmis.warehouse.model.v2014.Source) getModel(com.servinglynk.hmis.warehouse.model.v2014.Export.class.getSimpleName(),com.servinglynk.hmis.warehouse.model.v2014.Source.class, domain.getSource().getSourceID(), getProjectGroupCode(domain), true, relatedModelMap, domain.getUpload().getId());
			model.setSource(sourceEntity);
			domain.setExportId(model.getId());
			
			performSaveOrUpdate(model);
		} catch (Exception ex) {
			String errorMessage = "Exception because of the export::"+model.getId() +" Exception ::"+ex.getMessage();
			if (model != null) {
				Error2014 error = new Error2014();
				error.model_id = model.getId();
				error.bulk_upload_ui = domain.getUpload().getId();
				error.project_group_code = domain.getUpload().getProjectGroupCode();
				error.source_system_id = model.getSourceSystemId();
				error.type = ErrorType.ERROR;
				error.error_description = errorMessage;
				error.date_created = model.getDateCreated();
				performSave(error);
			}
			logger.error(errorMessage);
		}
		hydrateBulkUploadActivityStaging(data.i,data.j,data.ignore, com.servinglynk.hmis.warehouse.model.v2014.Export.class.getSimpleName(), domain, model);
	}
	
	public com.servinglynk.hmis.warehouse.model.v2014.Export getModelObject(ExportDomain domain, Export export ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2014.Export modelFromDB = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			modelFromDB = (com.servinglynk.hmis.warehouse.model.v2014.Export) getModel(com.servinglynk.hmis.warehouse.model.v2014.Export.class.getSimpleName(),com.servinglynk.hmis.warehouse.model.v2014.Export.class, export.getExportID(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
		
		if(modelFromDB == null) {
			modelFromDB = new com.servinglynk.hmis.warehouse.model.v2014.Export();
			modelFromDB.setId(UUID.randomUUID());
			modelFromDB.setRecordToBeInserted(true);
			
		}
		hydrateCommonFields(modelFromDB, domain,export.getExportID(),data);
		return modelFromDB;
	}
}
