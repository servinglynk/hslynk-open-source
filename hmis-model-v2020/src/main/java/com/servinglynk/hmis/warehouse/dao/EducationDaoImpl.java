/**
 *
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.collections.CollectionUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Education;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.DataCollectionStageEnum;
import com.servinglynk.hmis.warehouse.enums.LastgradecompletedLastgradecompletedEnum;
import com.servinglynk.hmis.warehouse.enums.SchoolStatusEnum;
import com.servinglynk.hmis.warehouse.model.v2020.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2020.HmisBaseModel;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class EducationDaoImpl extends ParentDaoImpl implements EducationDao {
	private static final Logger logger = LoggerFactory
			.getLogger(EducationDaoImpl.class);
	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) {
		List<Education> educationList  = domain.getExport().getEducation();
		com.servinglynk.hmis.warehouse.model.v2020.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2020.Export) getModel(com.servinglynk.hmis.warehouse.model.v2020.Export.class,domain.getExport().getExportID(),getProjectGroupCode(domain),false,exportModelMap, domain.getUpload().getId());
		Data data =new Data();
		Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2020.Education.class, getProjectGroupCode(domain));
		if(CollectionUtils.isNotEmpty(educationList))
		{
			for(Education education : educationList)
			{
				com.servinglynk.hmis.warehouse.model.v2020.Education educationModel = getModelObject(domain, education,data,modelMap);
				 if(educationModel.isIgnored()) {
						continue;
				 }
				educationModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(education.getDateCreated()));
				educationModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(education.getDateUpdated()));
				educationModel
				.setLastgradecompleted(LastgradecompletedLastgradecompletedEnum
						.lookupEnum(education
										.getLastGradeCompleted()));
				educationModel.setSchoolStatus(
						SchoolStatusEnum
						.lookupEnum(education.getSchoolStatus()));
				Enrollment enrollmentModel = (Enrollment) getModel(Enrollment.class, education.getEnrollmentID(),getProjectGroupCode(domain),true,relatedModelMap, domain.getUpload().getId());
				educationModel.setEnrollmentid(enrollmentModel);
				educationModel.setExport(exportEntity);
				educationModel.setInformationDate(BasicDataGenerator.getLocalDateTime(education.getInformationDate()));
				educationModel.setDataCollectionStage(DataCollectionStageEnum.lookupEnum((education.getDataCollectionStage())));
				performSaveOrUpdate(educationModel,domain);
			}
		}
		hydrateBulkUploadActivityStaging(data.i,data.j,data.ignore, com.servinglynk.hmis.warehouse.model.v2020.Education.class.getSimpleName(), domain,exportEntity);
	}
	public com.servinglynk.hmis.warehouse.model.v2020.Education getModelObject(ExportDomain domain, Education education ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2020.Education modelFromDB = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			modelFromDB = (com.servinglynk.hmis.warehouse.model.v2020.Education) getModel(com.servinglynk.hmis.warehouse.model.v2020.Education.class, education.getEducationID(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
		
		if(domain.isReUpload()) {
			if(modelFromDB != null) {
				return modelFromDB;
			}
			modelFromDB = new com.servinglynk.hmis.warehouse.model.v2020.Education();
			modelFromDB.setId(UUID.randomUUID());
			modelFromDB.setRecordToBeInserted(true); 
data.i++;
			return modelFromDB;
		}
		
		if(modelFromDB == null) {
			modelFromDB = new com.servinglynk.hmis.warehouse.model.v2020.Education();
			modelFromDB.setId(UUID.randomUUID());
			modelFromDB.setRecordToBeInserted(true); 
data.i++;
		}else {
			com.servinglynk.hmis.warehouse.model.v2020.Education model = new com.servinglynk.hmis.warehouse.model.v2020.Education();
			// org.springframework.beans.BeanUtils.copyProperties(modelFromDB, model);
			model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(education.getDateUpdated()));
			performMatch(domain, modelFromDB, model, data);
		}
		hydrateCommonFields(modelFromDB, domain,education.getEducationID(),data);
		return modelFromDB;
	}

	@Override
	public void hydrateHBASE(SyncDomain syncDomain) {
		// TODO Auto-generated method stub

	}

	   public com.servinglynk.hmis.warehouse.model.v2020.Education createEducation(com.servinglynk.hmis.warehouse.model.v2020.Education education){
	       education.setId(UUID.randomUUID()); 
	       insert(education);
	       return education;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2020.Education updateEducation(com.servinglynk.hmis.warehouse.model.v2020.Education education){
	       update(education);
	       return education;
	   }
	   public void deleteEducation(com.servinglynk.hmis.warehouse.model.v2020.Education education){
	       delete(education);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2020.Education getEducationById(UUID educationId){ 
		      DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2020.Education.class);
		      criteria.add(Restrictions.eq("id", educationId));
		      List<com.servinglynk.hmis.warehouse.model.v2020.Education> entities = (List<com.servinglynk.hmis.warehouse.model.v2020.Education>) findByCriteria(criteria);
		      if(!entities.isEmpty()) return entities.get(0);
		      return null;
	   }
	   public List<com.servinglynk.hmis.warehouse.model.v2020.Education> getAllEnrollmentEducations(UUID enrollmentId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2020.Education.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2020.Education>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getEnrollmentEducationsCount(UUID enrollmentId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2020.Education.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return countRows(criteria);
	   }
}
