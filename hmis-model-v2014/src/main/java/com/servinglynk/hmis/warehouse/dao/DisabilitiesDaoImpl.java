/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.servinglynk.hmis.warehouse.dao.helper.ChronicHomelessCalcHelper;
import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Disabilities;
import com.servinglynk.hmis.warehouse.enums.DisabilitiesDisabilitytypeEnum;
import com.servinglynk.hmis.warehouse.enums.DisabilitiesDocumentationonfileEnum;
import com.servinglynk.hmis.warehouse.enums.DisabilitiesIndefiniteandimpairsEnum;
import com.servinglynk.hmis.warehouse.enums.DisabilitiesPathhowconfirmedEnum;
import com.servinglynk.hmis.warehouse.enums.DisabilitiesPathsmiinformationEnum;
import com.servinglynk.hmis.warehouse.enums.DisabilitiesReceivingservicesEnum;
import com.servinglynk.hmis.warehouse.model.v2014.Enrollment;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class DisabilitiesDaoImpl extends ParentDaoImpl implements
		DisabilitiesDao {
	
	@Autowired
	ChronicHomelessCalcHelper chronicHomelessCalcHelper;
	
	public void hydrateStaging(ExportDomain domain) 
	{
		
		Export export = domain.getExport();
		List<Disabilities> disabilitiesList = export.getDisabilities();
		hydrateBulkUploadActivityStaging(disabilitiesList, com.servinglynk.hmis.warehouse.model.v2014.Disabilities.class.getSimpleName(), domain);
		int i=0;
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) get(com.servinglynk.hmis.warehouse.model.v2014.Export.class, domain.getExportId());
		if(disabilitiesList!=null && disabilitiesList.size() > 0 )
		{
			for(Disabilities disabilities : disabilitiesList)
			{
				com.servinglynk.hmis.warehouse.model.v2014.Disabilities disabilitiesModel = new com.servinglynk.hmis.warehouse.model.v2014.Disabilities();
				disabilitiesModel.setId(UUID.randomUUID());
				disabilitiesModel.setDisabilityresponse(BasicDataGenerator.getIntegerValue(disabilities.getDisabilityResponse()));
				disabilitiesModel.setDisabilitytype(DisabilitiesDisabilitytypeEnum.lookupEnum(BasicDataGenerator.getStringValue(disabilities.getDisabilityType())));
				disabilitiesModel.setDocumentationonfile(DisabilitiesDocumentationonfileEnum.lookupEnum(BasicDataGenerator.getStringValue(disabilities.getDocumentationOnFile())));
				disabilitiesModel.setIndefiniteandimpairs(DisabilitiesIndefiniteandimpairsEnum.lookupEnum(BasicDataGenerator.getStringValue(disabilities.getIndefiniteAndImpairs())));
				disabilitiesModel.setPathhowconfirmed(DisabilitiesPathhowconfirmedEnum.lookupEnum(BasicDataGenerator.getStringValue(disabilities.getPATHHowConfirmed())));
				disabilitiesModel.setPathsmiinformation(DisabilitiesPathsmiinformationEnum.lookupEnum(BasicDataGenerator.getStringValue(disabilities.getPATHSMIInformation())));
				disabilitiesModel.setReceivingservices(DisabilitiesReceivingservicesEnum.lookupEnum(BasicDataGenerator.getStringValue(disabilities.getReceivingServices())));
				disabilitiesModel.setDateCreated(LocalDateTime.now());
				disabilitiesModel.setDateUpdated(LocalDateTime.now());
				disabilitiesModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(disabilities.getDateCreated()));
				disabilitiesModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(disabilities.getDateUpdated()));
				if(disabilities.getProjectEntryID() !=null && !"".equals(disabilities.getProjectEntryID())) {
					UUID uuid = domain.getEnrollmentProjectEntryIDMap().get((disabilities.getProjectEntryID()));
					if(uuid !=null) {
						Enrollment enrollmentModel = (Enrollment) get(Enrollment.class, uuid);
						disabilitiesModel.setEnrollmentid(enrollmentModel);
					}
						
				}
				
				disabilitiesModel.setExport(exportEntity);
				i++;
				exportEntity.addDisabilities(disabilitiesModel);
				hydrateCommonFields(disabilitiesModel, domain, disabilities.getDisabilitiesID(),i);
			}
			Collection<UUID> values = domain.getEnrollmentProjectEntryIDMap().values();
			for(UUID enrollmentId : values) {
				if(enrollmentId !=null) {
					Enrollment enrollmentModel = (Enrollment) get(Enrollment.class, enrollmentId);
					boolean enrollmentChronicHomeless = chronicHomelessCalcHelper.isEnrollmentChronicHomeless(enrollmentModel);
						enrollmentModel.setChronicHomeless(enrollmentChronicHomeless);
						insertOrUpdate(enrollmentModel);
				}
			}
		}
	}
		
	   public com.servinglynk.hmis.warehouse.model.v2014.Disabilities createDisabilities(com.servinglynk.hmis.warehouse.model.v2014.Disabilities disabilities){
	       disabilities.setId(UUID.randomUUID()); 
	       insert(disabilities);
	       return disabilities;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Disabilities updateDisabilities(com.servinglynk.hmis.warehouse.model.v2014.Disabilities disabilities){
	       update(disabilities);
	       return disabilities;
	   }
	   public void deleteDisabilities(com.servinglynk.hmis.warehouse.model.v2014.Disabilities disabilities){
	       delete(disabilities);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Disabilities getDisabilitiesById(UUID disabilitiesId){ 
	       return (com.servinglynk.hmis.warehouse.model.v2014.Disabilities) get(com.servinglynk.hmis.warehouse.model.v2014.Disabilities.class, disabilitiesId);
	   }
	   
	   @SuppressWarnings("unchecked")
	   public List<com.servinglynk.hmis.warehouse.model.v2014.Disabilities> getAllEnrollmentDisabilitiess(UUID enrollmentId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Disabilities.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2014.Disabilities>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getEnrollmentDisabilitiessCount(UUID enrollmentId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Disabilities.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return countRows(criteria);
	   }
}
