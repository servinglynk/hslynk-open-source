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
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.LastPermanentAddress;
import com.servinglynk.hmis.warehouse.enums.LastPermAddressAddressDataQualityEnum;
import com.servinglynk.hmis.warehouse.enums.StateEnum;
import com.servinglynk.hmis.warehouse.model.v2014.Enrollment;
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
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) getModel(com.servinglynk.hmis.warehouse.model.v2014.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false,exportModelMap);
		if(lastPermanentAddresses !=null && !lastPermanentAddresses.isEmpty())
		{
			for(LastPermanentAddress lastPermanentAddress : lastPermanentAddresses)
			{
				try {
					LastPermAddress lastPermAddressModel = getModelObject(domain, lastPermanentAddress,data,modelMap);
					lastPermAddressModel.setAddressDataQuality(LastPermAddressAddressDataQualityEnum.lookupEnum(BasicDataGenerator.getStringValue(lastPermanentAddress.getAddressDataQuality())));
					lastPermAddressModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(lastPermanentAddress.getDateCreated()));
					lastPermAddressModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(lastPermanentAddress.getDateUpdated()));
					lastPermAddressModel.setCity(lastPermanentAddress.getLastPermanentCity());
					lastPermAddressModel.setState(StateEnum.lookupEnum(lastPermanentAddress.getLastPermanentState()));
					lastPermAddressModel.setStreet(lastPermanentAddress.getLastPermanentStreet());
					lastPermAddressModel.setZip(String.valueOf(lastPermanentAddress.getLastPermanentZIP()));
					Enrollment enrollmentModel = (Enrollment) getModel(Enrollment.class, lastPermanentAddress.getLastPermanentAddressID(),getProjectGroupCode(domain),true,relatedModelMap);
					lastPermAddressModel.setEnrollmentid(enrollmentModel);
					lastPermAddressModel.setExport(exportEntity);
					performSaveOrUpdate(lastPermAddressModel);
				} catch(Exception e) {
					logger.error("Failure in LastPermAddress:::"+lastPermanentAddress.toString()+ " with exception"+e.getLocalizedMessage());
					throw new Exception(e);
				}
			}
		}
		hydrateBulkUploadActivityStaging(data.i,data.j, com.servinglynk.hmis.warehouse.model.v2014.LastPermAddress.class.getSimpleName(), domain, exportEntity);
	}
	
	public com.servinglynk.hmis.warehouse.model.v2014.LastPermAddress getModelObject(ExportDomain domain,LastPermanentAddress lastPermAddress ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2014.LastPermAddress lastPermAddressModel = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			lastPermAddressModel = (com.servinglynk.hmis.warehouse.model.v2014.LastPermAddress) getModel(com.servinglynk.hmis.warehouse.model.v2014.LastPermAddress.class, lastPermAddress.getLastPermanentAddressID(), getProjectGroupCode(domain),false,modelMap);
		
		if(lastPermAddressModel == null) {
			lastPermAddressModel = new com.servinglynk.hmis.warehouse.model.v2014.LastPermAddress();
			lastPermAddressModel.setId(UUID.randomUUID());
			lastPermAddressModel.setInserted(true);
			++data.i;
		}else{
			++data.j;
		}
		hydrateCommonFields(lastPermAddressModel, domain,lastPermAddress.getLastPermanentAddressID(),data.i+data.j);
		return lastPermAddressModel;
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

