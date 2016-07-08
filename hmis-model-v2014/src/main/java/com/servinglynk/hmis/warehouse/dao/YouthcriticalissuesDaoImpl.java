/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.YouthCriticalIssues;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesAbuseandneglectfamEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesAbuseandneglectyouthEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesActivemilitaryparentEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesAlcoholdrugabusefamEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesAlcoholdrugabuseyouthEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesHealthissuesfamEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesHealthissuesyouthEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesHouseholddynamicsEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesHousingissuesfamEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesHousingissuesyouthEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesIncarceratedparentEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesIncarceratedparentstatusEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesInsufficientincomeEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesMentaldisabilityfamEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesMentaldisabilityyouthEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesMentalhealthissuesfamEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesMentalhealthissuesyouthEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesPhysicaldisabilityfamEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesPhysicaldisabilityyouthEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesSchooleducationalissuesfamEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesSchooleducationalissuesyouthEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesSexualorientationgenderidfamEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesSexualorientationgenderidyouthEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesUnemploymentfamEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesUnemploymentyouthEnum;
import com.servinglynk.hmis.warehouse.model.v2014.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2014.Youthcriticalissues;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class YouthcriticalissuesDaoImpl extends ParentDaoImpl implements
		YouthcriticalissuesDao {
	private static final Logger logger = LoggerFactory
			.getLogger(YouthcriticalissuesDaoImpl.class);


	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain) throws Exception {
		List<YouthCriticalIssues> youthCriticalIssuesList = domain.getExport().getYouthCriticalIssues();
		Long i=new Long(0L);
		Data data =new Data();
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) getModel(com.servinglynk.hmis.warehouse.model.v2014.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false);
		if(youthCriticalIssuesList !=null && !youthCriticalIssuesList.isEmpty())
		{
			for(YouthCriticalIssues youthCriticalIssues : youthCriticalIssuesList)
			{
				try {
					Youthcriticalissues youthcriticalissuesModel = getModelObject(domain, youthCriticalIssues,data);
					youthcriticalissuesModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(youthCriticalIssues.getDateCreated()));
					youthcriticalissuesModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(youthCriticalIssues.getDateUpdated()));
					youthcriticalissuesModel.setAbuseandneglectfam(YouthcriticalissuesAbuseandneglectfamEnum.lookupEnum(BasicDataGenerator.getStringValue(youthCriticalIssues.getAbuseAndNeglectFam())));
					youthcriticalissuesModel.setAbuseandneglectyouth(YouthcriticalissuesAbuseandneglectyouthEnum.lookupEnum(BasicDataGenerator.getStringValue(youthCriticalIssues.getAbuseAndNeglectYouth())));
					youthcriticalissuesModel.setActivemilitaryparent(YouthcriticalissuesActivemilitaryparentEnum.lookupEnum(BasicDataGenerator.getStringValue(youthCriticalIssues.getActiveMilitaryParent())));
					youthcriticalissuesModel.setAlcoholdrugabusefam(YouthcriticalissuesAlcoholdrugabusefamEnum.lookupEnum(BasicDataGenerator.getStringValue(youthCriticalIssues.getAlcoholDrugAbuseFam())));
					youthcriticalissuesModel.setAlcoholdrugabuseyouth(YouthcriticalissuesAlcoholdrugabuseyouthEnum.lookupEnum(BasicDataGenerator.getStringValue(youthCriticalIssues.getAlcoholDrugAbuseYouth())));
					youthcriticalissuesModel.setHealthissuesfam(YouthcriticalissuesHealthissuesfamEnum.lookupEnum(BasicDataGenerator.getStringValue(youthCriticalIssues.getHealthIssuesFam())));
					youthcriticalissuesModel.setHealthissuesyouth(YouthcriticalissuesHealthissuesyouthEnum.lookupEnum(BasicDataGenerator.getStringValue(youthCriticalIssues.getHealthIssuesYouth())));
					youthcriticalissuesModel.setHouseholddynamics(YouthcriticalissuesHouseholddynamicsEnum.lookupEnum(BasicDataGenerator.getStringValue(youthCriticalIssues.getHouseholdDynamics())));
					youthcriticalissuesModel.setHousingissuesfam(YouthcriticalissuesHousingissuesfamEnum.lookupEnum(BasicDataGenerator.getStringValue(youthCriticalIssues.getHousingIssuesFam())));
					youthcriticalissuesModel.setHousingissuesyouth(YouthcriticalissuesHousingissuesyouthEnum.lookupEnum(BasicDataGenerator.getStringValue(youthCriticalIssues.getHousingIssuesYouth())));
					youthcriticalissuesModel.setIncarceratedparent(YouthcriticalissuesIncarceratedparentEnum.lookupEnum(BasicDataGenerator.getStringValue(youthCriticalIssues.getIncarceratedParent())));
					youthcriticalissuesModel.setIncarceratedparentstatus(YouthcriticalissuesIncarceratedparentstatusEnum.lookupEnum(BasicDataGenerator.getStringValue(youthCriticalIssues.getIncarceratedParentStatus())));
					youthcriticalissuesModel.setInsufficientincome(YouthcriticalissuesInsufficientincomeEnum.lookupEnum(BasicDataGenerator.getStringValue(youthCriticalIssues.getInsufficientIncome())));
					youthcriticalissuesModel.setMentaldisabilityfam(YouthcriticalissuesMentaldisabilityfamEnum.lookupEnum(BasicDataGenerator.getStringValue(youthCriticalIssues.getMentalDisabilityFam())));
					youthcriticalissuesModel.setMentaldisabilityyouth(YouthcriticalissuesMentaldisabilityyouthEnum.lookupEnum(BasicDataGenerator.getStringValue(youthCriticalIssues.getMentalDisabilityYouth())));
					youthcriticalissuesModel.setMentalhealthissuesfam(YouthcriticalissuesMentalhealthissuesfamEnum.lookupEnum(BasicDataGenerator.getStringValue(youthCriticalIssues.getMentalHealthIssuesFam())));
					youthcriticalissuesModel.setMentalhealthissuesyouth(YouthcriticalissuesMentalhealthissuesyouthEnum.lookupEnum(BasicDataGenerator.getStringValue(youthCriticalIssues.getMentalHealthIssuesYouth())));
					youthcriticalissuesModel.setPhysicaldisabilityfam(YouthcriticalissuesPhysicaldisabilityfamEnum.lookupEnum(BasicDataGenerator.getStringValue(youthCriticalIssues.getPhysicalDisabilityFam())));
					youthcriticalissuesModel.setPhysicaldisabilityyouth(YouthcriticalissuesPhysicaldisabilityyouthEnum.lookupEnum(BasicDataGenerator.getStringValue(youthCriticalIssues.getPhysicalDisabilityYouth())));
					youthcriticalissuesModel.setSchooleducationalissuesfam(YouthcriticalissuesSchooleducationalissuesfamEnum.lookupEnum(BasicDataGenerator.getStringValue(youthCriticalIssues.getSchoolEducationalIssuesFam())));
					youthcriticalissuesModel.setSchooleducationalissuesyouth(YouthcriticalissuesSchooleducationalissuesyouthEnum.lookupEnum(BasicDataGenerator.getStringValue(youthCriticalIssues.getSchoolEducationalIssuesYouth())));
					youthcriticalissuesModel.setSexualorientationgenderidfam(YouthcriticalissuesSexualorientationgenderidfamEnum.lookupEnum(BasicDataGenerator.getStringValue(youthCriticalIssues.getSexualOrientationGenderIDFam())));
					youthcriticalissuesModel.setSexualorientationgenderidyouth(YouthcriticalissuesSexualorientationgenderidyouthEnum.lookupEnum(BasicDataGenerator.getStringValue(youthCriticalIssues.getSexualOrientationGenderIDYouth())));
					youthcriticalissuesModel.setUnemploymentfam(YouthcriticalissuesUnemploymentfamEnum.lookupEnum(BasicDataGenerator.getStringValue(youthCriticalIssues.getUnemploymentFam())));
					youthcriticalissuesModel.setUnemploymentyouth(YouthcriticalissuesUnemploymentyouthEnum.lookupEnum(BasicDataGenerator.getStringValue(youthCriticalIssues.getUnemploymentYouth())));
					youthcriticalissuesModel.setExport(exportEntity);
					Enrollment enrollmentModel = (Enrollment) getModel(Enrollment.class,youthCriticalIssues.getProjectEntryID(),getProjectGroupCode(domain),true);
					youthcriticalissuesModel.setEnrollmentid(enrollmentModel);
					if(exportEntity != null)
						exportEntity.addYouthcriticalissues(youthcriticalissuesModel);
					performSaveOrUpdate(youthcriticalissuesModel);
				}catch(Exception e) {
					logger.error("Exception in youthCriticalIssues:"+youthCriticalIssues.getProjectEntryID()+  ":: Exception" +e.getLocalizedMessage());
					throw new Exception(e);
				}
			}
		}
		hydrateBulkUploadActivityStaging(data.i,data.j, com.servinglynk.hmis.warehouse.model.v2014.Youthcriticalissues.class.getSimpleName(), domain,exportEntity);
	}
	
	public com.servinglynk.hmis.warehouse.model.v2014.Youthcriticalissues getModelObject(ExportDomain domain, YouthCriticalIssues youthcriticalissues ,Data data) {
		com.servinglynk.hmis.warehouse.model.v2014.Youthcriticalissues youthcriticalissuesModel = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			youthcriticalissuesModel = (com.servinglynk.hmis.warehouse.model.v2014.Youthcriticalissues) getModel(com.servinglynk.hmis.warehouse.model.v2014.Youthcriticalissues.class, youthcriticalissues.getYouthCriticalIssuesID(), getProjectGroupCode(domain),false);
		
		if(youthcriticalissuesModel == null) {
			youthcriticalissuesModel = new com.servinglynk.hmis.warehouse.model.v2014.Youthcriticalissues();
			youthcriticalissuesModel.setId(UUID.randomUUID());
			youthcriticalissuesModel.setInserted(true);
			++data.i;
		}else{
			++data.j;
		}
		hydrateCommonFields(youthcriticalissuesModel, domain,youthcriticalissues.getYouthCriticalIssuesID(),data.i+data.j);
		return youthcriticalissuesModel;
	}
	   public com.servinglynk.hmis.warehouse.model.v2014.Youthcriticalissues createYouthCriticalIssues(com.servinglynk.hmis.warehouse.model.v2014.Youthcriticalissues youthCriticalIssues){
	       youthCriticalIssues.setId(UUID.randomUUID()); 
	       insert(youthCriticalIssues);
	       return youthCriticalIssues;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Youthcriticalissues updateYouthCriticalIssues(com.servinglynk.hmis.warehouse.model.v2014.Youthcriticalissues youthCriticalIssues){
	       update(youthCriticalIssues);
	       return youthCriticalIssues;
	   }
	   public void deleteYouthCriticalIssues(com.servinglynk.hmis.warehouse.model.v2014.Youthcriticalissues youthCriticalIssues){
	       delete(youthCriticalIssues);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Youthcriticalissues getYouthCriticalIssuesById(UUID youthCriticalIssuesId){ 
	       return (com.servinglynk.hmis.warehouse.model.v2014.Youthcriticalissues) get(com.servinglynk.hmis.warehouse.model.v2014.Youthcriticalissues.class, youthCriticalIssuesId);
	   }
	   public List<com.servinglynk.hmis.warehouse.model.v2014.Youthcriticalissues> getAllEnrollmentYouthCriticalIssuess(UUID enrollmentId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Youthcriticalissues.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2014.Youthcriticalissues>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getEnrollmentYouthCriticalIssuessCount(UUID enrollmentId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Youthcriticalissues.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return countRows(criteria);
	   }

}
