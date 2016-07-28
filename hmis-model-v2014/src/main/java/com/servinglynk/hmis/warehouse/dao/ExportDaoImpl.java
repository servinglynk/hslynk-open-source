package com.servinglynk.hmis.warehouse.dao;

import java.util.Map;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.base.util.ErrorType;
import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export;
import com.servinglynk.hmis.warehouse.model.v2014.Error2014;
import com.servinglynk.hmis.warehouse.model.v2014.HmisBaseModel;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

public class ExportDaoImpl extends ParentDaoImpl implements ExportDao {
	private static final Logger logger = LoggerFactory
			.getLogger(ExportDaoImpl.class);
	@Override
	@Transactional
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) {
		Export export = domain.getExport();
		Data data = new Data();
		Map<String, HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2014.Export.class, getProjectGroupCode(domain));
		com.servinglynk.hmis.warehouse.model.v2014.Export exportModel = null;
		try {
			exportModel = getModelObject(domain, export, data, modelMap);
			exportModel.setExportDate(BasicDataGenerator.getLocalDateTime(export.getExportDate()));
			exportModel.setExportdirective(export.getExportDirective());
			exportModel.setExportperiodtype(export.getExportPeriodType());
//		com.servinglynk.hmis.warehouse.model.staging.HmisUser user = (com.servinglynk.hmis.warehouse.model.staging.HmisUser) get(com.servinglynk.hmis.warehouse.model.staging.HmisUser.class, upload.getUser().getId());
			//	exportModel.setUser(user);
			com.servinglynk.hmis.warehouse.model.v2014.Source sourceEntity = (com.servinglynk.hmis.warehouse.model.v2014.Source) getModel(com.servinglynk.hmis.warehouse.model.v2014.Source.class, domain.getSource().getSourceID(), getProjectGroupCode(domain), true, relatedModelMap, domain.getUpload().getId());
			exportModel.setSource(sourceEntity);
			performSaveOrUpdate(exportModel);
		} catch (Exception ex) {
			String errorMessage = "Exception because of the export::"+exportModel.getId() +" Exception ::"+ex.getMessage();
			if (exportModel != null) {
				Error2014 error = new Error2014();
				error.model_id = exportModel.getId();
				error.bulk_upload_ui = domain.getUpload().getId();
				error.project_group_code = domain.getUpload().getProjectGroupCode();
				error.source_system_id = exportModel.getSourceSystemId();
				error.type = ErrorType.ERROR;
				error.error_description = errorMessage;
				error.date_created = exportModel.getDateCreated();
				performSave(error);
			}
			logger.error(errorMessage);
		}
		hydrateBulkUploadActivityStaging(data.i, data.j, com.servinglynk.hmis.warehouse.model.v2014.Export.class.getSimpleName(), domain, exportModel);
	}
	
	public com.servinglynk.hmis.warehouse.model.v2014.Export getModelObject(ExportDomain domain, Export export ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2014.Export exportModel = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			exportModel = (com.servinglynk.hmis.warehouse.model.v2014.Export) getModel(com.servinglynk.hmis.warehouse.model.v2014.Export.class, export.getExportID(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
		
		if(exportModel == null) {
			exportModel = new com.servinglynk.hmis.warehouse.model.v2014.Export();
			exportModel.setId(UUID.randomUUID());
			exportModel.setInserted(true);
			++data.i;
		}else{
			++data.j;
		}
		hydrateCommonFields(exportModel, domain,export.getExportID(),data.i+data.j);
		return exportModel;
	}
}
