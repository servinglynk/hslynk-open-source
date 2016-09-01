/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.base.util.ErrorType;
import com.servinglynk.hmis.warehouse.model.v2014.Error2014;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.SexualOrientation;
import com.servinglynk.hmis.warehouse.enums.DataCollectionStageEnum;
import com.servinglynk.hmis.warehouse.enums.SexualorientationSexualorientationEnum;
import com.servinglynk.hmis.warehouse.model.v2014.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2014.HmisBaseModel;
import com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class SexualorientationDaoImpl extends ParentDaoImpl implements
		SexualorientationDao {
	private static final Logger logger = LoggerFactory
			.getLogger(SexualorientationDaoImpl.class);

	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception {
		List<SexualOrientation> sexualOrientations = domain.getExport().getSexualOrientation();
		Data data =new Data();
		Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation.class, getProjectGroupCode(domain));
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) getModel(Sexualorientation.class.getSimpleName(),com.servinglynk.hmis.warehouse.model.v2014.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false,exportModelMap, domain.getUpload().getId());
		if(sexualOrientations !=null && !sexualOrientations.isEmpty())
		{
			for(SexualOrientation sexualOrientation : sexualOrientations)
			{
				Sexualorientation sexualorientationModel = null;
				try {
					sexualorientationModel = getModelObject(domain, sexualOrientation,data,modelMap);
					sexualorientationModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(sexualOrientation.getDateCreated()));
					sexualorientationModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(sexualOrientation.getDateUpdated()));
					sexualorientationModel.setSexualorientation(SexualorientationSexualorientationEnum.lookupEnum(BasicDataGenerator.getStringValue(sexualOrientation.getSexualOrientation())));
					Enrollment enrollmentModel = (Enrollment) getModel(Sexualorientation.class.getSimpleName(),Enrollment.class,sexualOrientation.getProjectEntryID(),getProjectGroupCode(domain),true,relatedModelMap, domain.getUpload().getId());
					sexualorientationModel.setEnrollmentid(enrollmentModel);
					sexualorientationModel.setExport(exportEntity);
					sexualorientationModel.setInformationDate(BasicDataGenerator.getLocalDateTime(sexualOrientation.getInformationDate()));
					sexualorientationModel.setDataCollectionStage(DataCollectionStageEnum.lookupEnum(BasicDataGenerator.getStringValue(sexualOrientation.getDataCollectionStage())));
					performSaveOrUpdate(sexualorientationModel);
				} catch(Exception e) {
					String errorMessage = "Failure in Sexualorientation:::"+sexualOrientation.toString()+ " with exception"+e.getLocalizedMessage();
					if (sexualorientationModel != null) {
						Error2014 error = new Error2014();
						error.model_id = sexualorientationModel.getId();
						error.bulk_upload_ui = domain.getUpload().getId();
						error.project_group_code = domain.getUpload().getProjectGroupCode();
						error.source_system_id = sexualorientationModel.getSourceSystemId();
						error.type = ErrorType.ERROR;
						error.error_description = errorMessage;
						error.date_created = sexualorientationModel.getDateCreated();
						performSave(error);
					}
					logger.error(errorMessage);
				}
			}
		}
		hydrateBulkUploadActivityStaging(data.i,data.j, com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation.class.getSimpleName(), domain,exportEntity);
	}
	public com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation getModelObject(ExportDomain domain,SexualOrientation sexualorientation ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation SexualorientationModel = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			SexualorientationModel = (com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation) getModel(Sexualorientation.class.getSimpleName(),com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation.class, sexualorientation.getSexualOrientationID(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
		
		if(SexualorientationModel == null) {
			SexualorientationModel = new com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation();
			SexualorientationModel.setId(UUID.randomUUID());
			SexualorientationModel.setInserted(true);
			++data.i;
		}else{
			++data.j;
		}
		hydrateCommonFields(SexualorientationModel, domain,sexualorientation.getSexualOrientationID(),data.i+data.j);
		return SexualorientationModel;
	}
	   public com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation createSexualorientation(com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation sexualorientation){
	       sexualorientation.setId(UUID.randomUUID()); 
	       insert(sexualorientation);
	       return sexualorientation;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation updateSexualorientation(com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation sexualorientation){
	       update(sexualorientation);
	       return sexualorientation;
	   }
	   public void deleteSexualorientation(com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation sexualorientation){
	       delete(sexualorientation);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation getSexualorientationById(UUID sexualorientationId){ 
	       return (com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation) get(com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation.class, sexualorientationId);
	   }
	   public List<com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation> getAllEnrollmentSexualorientations(UUID enrollmentId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getEnrollmentSexualorientationsCount(UUID enrollmentId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return countRows(criteria);
	   }

}
