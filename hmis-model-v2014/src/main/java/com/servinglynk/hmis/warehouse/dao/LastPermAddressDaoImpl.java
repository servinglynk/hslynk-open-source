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

import com.servinglynk.hmis.warehouse.base.util.ErrorType;
import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.LastPermanentAddress;
import com.servinglynk.hmis.warehouse.enums.LastPermAddressAddressDataQualityEnum;
import com.servinglynk.hmis.warehouse.enums.StateEnum;
import com.servinglynk.hmis.warehouse.model.v2014.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2014.Error2014;
import com.servinglynk.hmis.warehouse.model.v2014.HmisBaseModel;
import com.servinglynk.hmis.warehouse.model.v2014.LastPermAddress;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class LastPermAddressDaoImpl extends ParentDaoImpl implements
		LastPermAddressDao {
	private static final Logger logger = LoggerFactory
			.getLogger(LastPermAddressDaoImpl.class);
	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception {
		List<LastPermanentAddress> lastPermanentAddresses = domain.getExport().getLastPermanentAddress();
		Data data =new Data();
		Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2014.LastPermAddress.class, getProjectGroupCode(domain));
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) getModel(LastPermAddress.class.getSimpleName(),com.servinglynk.hmis.warehouse.model.v2014.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false,exportModelMap, domain.getUpload().getId());
		if(lastPermanentAddresses !=null && !lastPermanentAddresses.isEmpty())
		{
			for(LastPermanentAddress lastPermanentAddress : lastPermanentAddresses)
			{
				LastPermAddress model = null;
				try {
					model = getModelObject(domain, lastPermanentAddress,data,modelMap);
					model.setAddressDataQuality(LastPermAddressAddressDataQualityEnum.lookupEnum(BasicDataGenerator.getStringValue(lastPermanentAddress.getAddressDataQuality())));
					model.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(lastPermanentAddress.getDateCreated()));
					model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(lastPermanentAddress.getDateUpdated()));
					model.setCity(lastPermanentAddress.getLastPermanentCity());
					model.setState(StateEnum.lookupEnum(lastPermanentAddress.getLastPermanentState()));
					model.setStreet(lastPermanentAddress.getLastPermanentStreet());
					model.setZip(String.valueOf(lastPermanentAddress.getLastPermanentZIP()));
					Enrollment enrollmentModel = (Enrollment) getModel(LastPermAddress.class.getSimpleName(),Enrollment.class, lastPermanentAddress.getProjectEntryID(),getProjectGroupCode(domain),true,relatedModelMap, domain.getUpload().getId());
					model.setEnrollmentid(enrollmentModel);
					model.setExport(exportEntity);
									
					performSaveOrUpdate(model);
				} catch(Exception e) {
					String errorMessage = "Failure in LastPermAddress:::"+lastPermanentAddress.toString()+ " with exception"+e.getLocalizedMessage();
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
		hydrateBulkUploadActivityStaging(data.i,data.j,data.ignore, com.servinglynk.hmis.warehouse.model.v2014.LastPermAddress.class.getSimpleName(), domain, exportEntity);
	}
	
	public com.servinglynk.hmis.warehouse.model.v2014.LastPermAddress getModelObject(ExportDomain domain,LastPermanentAddress lastPermAddress ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2014.LastPermAddress modelFromDB = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			modelFromDB = (com.servinglynk.hmis.warehouse.model.v2014.LastPermAddress) getModel(LastPermAddress.class.getSimpleName(),com.servinglynk.hmis.warehouse.model.v2014.LastPermAddress.class, lastPermAddress.getLastPermanentAddressID(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
		
		if(modelFromDB == null) {
			modelFromDB = new com.servinglynk.hmis.warehouse.model.v2014.LastPermAddress();
			modelFromDB.setId(UUID.randomUUID());
			modelFromDB.setRecordToBeInserted(true);
			
		}
		 com.servinglynk.hmis.warehouse.model.v2014.LastPermAddress model = new com.servinglynk.hmis.warehouse.model.v2014.LastPermAddress();
		  org.springframework.beans.BeanUtils.copyProperties(modelFromDB, model);
		  model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(lastPermAddress.getDateUpdated()));
		  performMatch(domain, modelFromDB, model, data);
		hydrateCommonFields(model, domain,lastPermAddress.getLastPermanentAddressID(),data);
		
		return model;
	}
	public com.servinglynk.hmis.warehouse.model.v2014.LastPermAddress createLastPermanentAddress(com.servinglynk.hmis.warehouse.model.v2014.LastPermAddress lastPermanentAddress){
			       lastPermanentAddress.setId(UUID.randomUUID()); 
			       insert(lastPermanentAddress);
			       return lastPermanentAddress;
			   }
			   public com.servinglynk.hmis.warehouse.model.v2014.LastPermAddress updateLastPermanentAddress(com.servinglynk.hmis.warehouse.model.v2014.LastPermAddress lastPermanentAddress){
			       update(lastPermanentAddress);
			       return lastPermanentAddress;
			   }
			   public void deleteLastPermanentAddress(com.servinglynk.hmis.warehouse.model.v2014.LastPermAddress lastPermanentAddress){
			       delete(lastPermanentAddress);
			   }
			   public com.servinglynk.hmis.warehouse.model.v2014.LastPermAddress getLastPermanentAddressById(UUID lastPermanentAddressId){ 
			       return (com.servinglynk.hmis.warehouse.model.v2014.LastPermAddress) get(com.servinglynk.hmis.warehouse.model.v2014.LastPermAddress.class, lastPermanentAddressId);
			   }
			   public List<com.servinglynk.hmis.warehouse.model.v2014.LastPermAddress> getAllEnrollmentLastPermanentAddresss(UUID enrollmentId,Integer startIndex, Integer maxItems){
			       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.LastPermAddress.class);
			       criteria.createAlias("enrollmentid", "enrollmentid");
			       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
			       return (List<com.servinglynk.hmis.warehouse.model.v2014.LastPermAddress>) findByCriteria(criteria,startIndex,maxItems);
			   }
			   public long getEnrollmentLastPermanentAddresssCount(UUID enrollmentId){
			       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.LastPermAddress.class);
			       criteria.createAlias("enrollmentid", "enrollmentid");
			       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
			       return countRows(criteria);
			   }
		
}

