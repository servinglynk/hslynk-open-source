/**
 *
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Education;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.LastgradecompletedLastgradecompletedEnum;
import com.servinglynk.hmis.warehouse.enums.SchoolStatusEnum;
import com.servinglynk.hmis.warehouse.model.v2015.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2015.HmisBaseModel;
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
		com.servinglynk.hmis.warehouse.model.v2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2015.Export) getModel(com.servinglynk.hmis.warehouse.model.v2015.Export.class,domain.getExport().getExportID(),getProjectGroupCode(domain),false,exportModelMap);
		Data data =new Data();
		Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2015.Education.class, getProjectGroupCode(domain));
		if(educationList!=null && !educationList.isEmpty())
		{
			for(Education education : educationList)
			{
				com.servinglynk.hmis.warehouse.model.v2015.Education educationModel = getModelObject(domain, education,data,modelMap);
				educationModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(education.getDateCreated()));
				educationModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(education.getDateUpdated()));
				educationModel
				.setLastgradecompleted(LastgradecompletedLastgradecompletedEnum
						.lookupEnum(BasicDataGenerator
								.getStringValue(education
										.getLastGradeCompleted())));
				educationModel.setSchoolStatus(
						SchoolStatusEnum
						.lookupEnum(BasicDataGenerator
								.getStringValue(education.getSchoolStatus())));
				Enrollment enrollmentModel = (Enrollment) getModel(Enrollment.class, education.getProjectEntryID(),getProjectGroupCode(domain),true,relatedModelMap);
				educationModel.setEnrollmentid(enrollmentModel);
				educationModel.setExport(exportEntity);
				performSaveOrUpdate(educationModel);
			}
		}
		hydrateBulkUploadActivityStaging(data.i,data.j, com.servinglynk.hmis.warehouse.model.v2015.Education.class.getSimpleName(), domain,exportEntity);
	}
	public com.servinglynk.hmis.warehouse.model.v2015.Education getModelObject(ExportDomain domain, Education education ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2015.Education educationModel = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			educationModel = (com.servinglynk.hmis.warehouse.model.v2015.Education) getModel(com.servinglynk.hmis.warehouse.model.v2015.Education.class, education.getEducationID(), getProjectGroupCode(domain),false,modelMap);
		
		if(educationModel == null) {
			educationModel = new com.servinglynk.hmis.warehouse.model.v2015.Education();
			educationModel.setId(UUID.randomUUID());
			educationModel.setInserted(true);
			++data.i;
		}else{
			++data.j;
		}
		hydrateCommonFields(educationModel, domain,education.getEducationID(),data.i+data.j);
		return educationModel;
	}

	@Override
	public void hydrateHBASE(SyncDomain syncDomain) {
		// TODO Auto-generated method stub

	}

	   public com.servinglynk.hmis.warehouse.model.v2015.Education createEducation(com.servinglynk.hmis.warehouse.model.v2015.Education education){
	       education.setId(UUID.randomUUID()); 
	       insert(education);
	       return education;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2015.Education updateEducation(com.servinglynk.hmis.warehouse.model.v2015.Education education){
	       update(education);
	       return education;
	   }
	   public void deleteEducation(com.servinglynk.hmis.warehouse.model.v2015.Education education){
	       delete(education);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2015.Education getEducationById(UUID educationId){ 
	       return (com.servinglynk.hmis.warehouse.model.v2015.Education) get(com.servinglynk.hmis.warehouse.model.v2015.Education.class, educationId);
	   }
	   public List<com.servinglynk.hmis.warehouse.model.v2015.Education> getAllEnrollmentEducations(UUID enrollmentId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Education.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2015.Education>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getEnrollmentEducationsCount(UUID enrollmentId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Education.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return countRows(criteria);
	   }
}
