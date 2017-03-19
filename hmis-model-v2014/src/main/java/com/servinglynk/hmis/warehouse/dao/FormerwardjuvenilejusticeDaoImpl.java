/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.servinglynk.hmis.warehouse.base.util.ErrorType;
import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.FormerWardJuvenileJustice;
import com.servinglynk.hmis.warehouse.enums.DataCollectionStageEnum;
import com.servinglynk.hmis.warehouse.enums.FormerwardjuvenilejusticeFormerwardjuvenilejusticeEnum;
import com.servinglynk.hmis.warehouse.enums.FormerwardjuvenilejusticeJuvenilejusticeyearsEnum;
import com.servinglynk.hmis.warehouse.model.v2014.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2014.Error2014;
import com.servinglynk.hmis.warehouse.model.v2014.Formerwardjuvenilejustice;
import com.servinglynk.hmis.warehouse.model.v2014.HmisBaseModel;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class FormerwardjuvenilejusticeDaoImpl extends ParentDaoImpl implements
		FormerwardjuvenilejusticeDao {
	private static final Logger logger = LoggerFactory
			.getLogger(FormerwardjuvenilejusticeDaoImpl.class);
	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception {
		List<FormerWardJuvenileJustice> formerWardJuvenileJustices = domain.getExport().getFormerWardJuvenileJustice();
		Data data =new Data();
		Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2014.Formerwardjuvenilejustice.class, getProjectGroupCode(domain));
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) getModel(Formerwardjuvenilejustice.class.getSimpleName(),com.servinglynk.hmis.warehouse.model.v2014.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false,exportModelMap, domain.getUpload().getId());
		if(formerWardJuvenileJustices !=null && !formerWardJuvenileJustices.isEmpty()) 
		{
			for(FormerWardJuvenileJustice formerWardJuvenileJustice : formerWardJuvenileJustices )
			{
				Formerwardjuvenilejustice model = null;
				try {
					model = getModelObject(domain, formerWardJuvenileJustice,data,modelMap);
					model.setFormerwardjuvenilejustice(FormerwardjuvenilejusticeFormerwardjuvenilejusticeEnum.lookupEnum(BasicDataGenerator.getStringValue(formerWardJuvenileJustice.getFormerWardJuvenileJustice())));
					model.setJuvenilejusticemonths(BasicDataGenerator.getIntegerValue(formerWardJuvenileJustice.getJuvenileJusticeMonths()));
					model.setJuvenilejusticeyears(FormerwardjuvenilejusticeJuvenilejusticeyearsEnum.lookupEnum(BasicDataGenerator.getStringValue(formerWardJuvenileJustice.getJuvenileJusticeYears())));
					model.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(formerWardJuvenileJustice.getDateCreated()));
					model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(formerWardJuvenileJustice.getDateUpdated()));
					Enrollment enrollmentModel = (Enrollment) getModel(Formerwardjuvenilejustice.class.getSimpleName(),Enrollment.class, formerWardJuvenileJustice.getProjectEntryID(),getProjectGroupCode(domain),true,relatedModelMap, domain.getUpload().getId());
					model.setEnrollmentid(enrollmentModel);
					model.setExport(exportEntity);
					model.setInformationDate(BasicDataGenerator.getLocalDateTime(formerWardJuvenileJustice.getInformationDate()));
					model.setDataCollectionStage(DataCollectionStageEnum.lookupEnum(BasicDataGenerator.getStringValue(formerWardJuvenileJustice.getDataCollectionStage())));
					
					performSaveOrUpdate(model);
				}catch (Exception e) {
					String errorMessage = "Exception in:"+formerWardJuvenileJustice.getProjectEntryID()+  ":: Exception" +e.getLocalizedMessage();
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
			}
		}
		hydrateBulkUploadActivityStaging(data.i,data.j,data.ignore, com.servinglynk.hmis.warehouse.model.v2014.Formerwardjuvenilejustice.class.getSimpleName(), domain,exportEntity);
	}
	
	public com.servinglynk.hmis.warehouse.model.v2014.Formerwardjuvenilejustice getModelObject(ExportDomain domain, FormerWardJuvenileJustice formerWardJuvenileJustice ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2014.Formerwardjuvenilejustice modelFromDB = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			modelFromDB = (com.servinglynk.hmis.warehouse.model.v2014.Formerwardjuvenilejustice) getModel(Formerwardjuvenilejustice.class.getSimpleName(),com.servinglynk.hmis.warehouse.model.v2014.Formerwardjuvenilejustice.class, formerWardJuvenileJustice.getFormerWardJuvenileJusticeID(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
		
		if(modelFromDB == null) {
			modelFromDB = new com.servinglynk.hmis.warehouse.model.v2014.Formerwardjuvenilejustice();
			modelFromDB.setId(UUID.randomUUID());
			modelFromDB.setRecordToBeInserted(true);
			
		}
		 com.servinglynk.hmis.warehouse.model.v2014.Formerwardjuvenilejustice model = new com.servinglynk.hmis.warehouse.model.v2014.Formerwardjuvenilejustice();
		  // org.springframework.beans.BeanUtils.copyProperties(modelFromDB, model);
		  model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(formerWardJuvenileJustice.getDateUpdated()));
		  performMatch(domain, modelFromDB, model, data);
		hydrateCommonFields(model, domain,formerWardJuvenileJustice.getFormerWardJuvenileJusticeID(),data);
		
		return model;
	}
}
