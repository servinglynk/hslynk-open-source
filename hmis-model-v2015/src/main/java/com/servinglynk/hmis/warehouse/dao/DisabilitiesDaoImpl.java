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
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Disabilities;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Disabilities;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.DisabilitiesDisabilitytypeEnum;
import com.servinglynk.hmis.warehouse.enums.DisabilitiesDocumentationonfileEnum;
import com.servinglynk.hmis.warehouse.enums.DisabilitiesPathhowconfirmedEnum;
import com.servinglynk.hmis.warehouse.enums.DisabilitiesPathsmiinformationEnum;
import com.servinglynk.hmis.warehouse.enums.DisabilitiesReceivingservicesEnum;
import com.servinglynk.hmis.warehouse.model.v2015.Enrollment;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class DisabilitiesDaoImpl extends ParentDaoImpl implements
		DisabilitiesDao {
	private static final Logger logger = LoggerFactory
			.getLogger(DisabilitiesDaoImpl.class);
	public void hydrateStaging(ExportDomain domain) throws Exception
	{
		com.servinglynk.hmis.warehouse.model.v2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2015.Export) getModel(com.servinglynk.hmis.warehouse.model.v2015.Export.class,domain.getExport().getExportID(),getProjectGroupCode(domain),false);
		Data data =new Data();
		Export export = domain.getExport();
		List<Disabilities> disabilitiesList = export.getDisabilities();
		if(disabilitiesList!=null && disabilitiesList.size() > 0 )
		{
			for(Disabilities disabilities : disabilitiesList)
			{
				try {
					com.servinglynk.hmis.warehouse.model.v2015.Disabilities disabilitiesModel = getModelObject(domain, disabilities, data);
					disabilitiesModel.setDisabilityresponse(BasicDataGenerator.getIntegerValue(disabilities.getDisabilityResponse()));
					disabilitiesModel.setDisabilitytype(DisabilitiesDisabilitytypeEnum.lookupEnum(BasicDataGenerator.getStringValue(disabilities.getDisabilityType())));
					disabilitiesModel.setDocumentationonfile(DisabilitiesDocumentationonfileEnum.lookupEnum(BasicDataGenerator.getStringValue(disabilities.getDocumentationOnFile())));
					//disabilitiesModel.setIndefiniteandimpairs(DisabilitiesIndefiniteandimpairsEnum.lookupEnum(BasicDataGenerator.getStringValue(disabilities.getIndefiniteAndImpairs())));
					disabilitiesModel.setPathhowconfirmed(DisabilitiesPathhowconfirmedEnum.lookupEnum(BasicDataGenerator.getStringValue(disabilities.getPATHHowConfirmed())));
					disabilitiesModel.setPathsmiinformation(DisabilitiesPathsmiinformationEnum.lookupEnum(BasicDataGenerator.getStringValue(disabilities.getPATHSMIInformation())));
					disabilitiesModel.setReceivingservices(DisabilitiesReceivingservicesEnum.lookupEnum(BasicDataGenerator.getStringValue(disabilities.getReceivingServices())));
					disabilitiesModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(disabilities.getDateCreated()));
					disabilitiesModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(disabilities.getDateUpdated()));
					Enrollment enrollmentModel = (Enrollment) getModel(Enrollment.class,disabilities.getProjectEntryID(),getProjectGroupCode(domain),true);
					disabilitiesModel.setEnrollmentid(enrollmentModel);
					disabilitiesModel.setExport(exportEntity);
					if(exportEntity !=null)
						exportEntity.addDisabilities(disabilitiesModel);
					performSaveOrUpdate(disabilitiesModel);
				}catch(Exception e) {
					logger.error("Exception beause of the Disabilities::"+disabilities.getDisabilitiesID() +" Exception ::"+e.getMessage());
					 throw new Exception(e);
				}
			}
		}
		hydrateBulkUploadActivityStaging(data.i,data.j, com.servinglynk.hmis.warehouse.model.v2015.Disabilities.class.getSimpleName(), domain, exportEntity);
	}

	public com.servinglynk.hmis.warehouse.model.v2015.Disabilities getModelObject(ExportDomain domain, Disabilities Disabilities ,Data data) {
		com.servinglynk.hmis.warehouse.model.v2015.Disabilities disabilitiesModel = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			disabilitiesModel = (com.servinglynk.hmis.warehouse.model.v2015.Disabilities) getModel(com.servinglynk.hmis.warehouse.model.v2015.Disabilities.class, Disabilities.getDisabilitiesID(), getProjectGroupCode(domain),false);
		
		if(disabilitiesModel == null) {
			disabilitiesModel = new com.servinglynk.hmis.warehouse.model.v2015.Disabilities();
			disabilitiesModel.setId(UUID.randomUUID());
			disabilitiesModel.setInserted(true);
			++data.i;
		}else{
			++data.j;
		}
		hydrateCommonFields(disabilitiesModel, domain,Disabilities.getDisabilitiesID(),data.i+data.j);
		return disabilitiesModel;
	}
	
	@Override
	public void hydrateHBASE(SyncDomain syncDomain) {
		// TODO Auto-generated method stub

	}

	   public com.servinglynk.hmis.warehouse.model.v2015.Disabilities createDisabilities(com.servinglynk.hmis.warehouse.model.v2015.Disabilities disabilities){
	       disabilities.setId(UUID.randomUUID());
	       insert(disabilities);
	       return disabilities;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2015.Disabilities updateDisabilities(com.servinglynk.hmis.warehouse.model.v2015.Disabilities disabilities){
	       update(disabilities);
	       return disabilities;
	   }
	   public void deleteDisabilities(com.servinglynk.hmis.warehouse.model.v2015.Disabilities disabilities){
	       delete(disabilities);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2015.Disabilities getDisabilitiesById(UUID disabilitiesId){
	       return (com.servinglynk.hmis.warehouse.model.v2015.Disabilities) get(com.servinglynk.hmis.warehouse.model.v2015.Disabilities.class, disabilitiesId);
	   }

	   @SuppressWarnings("unchecked")
	   public List<com.servinglynk.hmis.warehouse.model.v2015.Disabilities> getAllEnrollmentDisabilitiess(UUID enrollmentId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Disabilities.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2015.Disabilities>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getEnrollmentDisabilitiessCount(UUID enrollmentId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Disabilities.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return countRows(criteria);
	   }
}
