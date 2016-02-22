/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.apache.hadoop.hbase.thrift2.generated.THBaseService.Iface;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.BeanUtils;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.LastPermanentAddress;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.LastPermAddressAddressDataQualityEnum;
import com.servinglynk.hmis.warehouse.enums.StateEnum;
import com.servinglynk.hmis.warehouse.model.staging.Enrollment;
import com.servinglynk.hmis.warehouse.model.staging.Export;
import com.servinglynk.hmis.warehouse.model.staging.LastPermAddress;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class LastPermAddressDaoImpl extends ParentDaoImpl implements
		LastPermAddressDao {

	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain) {
		List<LastPermanentAddress> lastPermanentAddresses = domain.getExport().getLastPermanentAddress();
		if(lastPermanentAddresses !=null && !lastPermanentAddresses.isEmpty())
		{
			for(LastPermanentAddress lastPermanentAddress : lastPermanentAddresses)
			{
				LastPermAddress lastPermAddressModel = new LastPermAddress();
				UUID id = UUID.randomUUID();
				lastPermAddressModel.setId(id);
				lastPermAddressModel.setAddressDataQuality(LastPermAddressAddressDataQualityEnum.lookupEnum(BasicDataGenerator.getStringValue(lastPermanentAddress.getAddressDataQuality())));

				lastPermAddressModel.setDateCreated(LocalDateTime.now());
				lastPermAddressModel.setDateUpdated(LocalDateTime.now());
				lastPermAddressModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(lastPermanentAddress.getDateCreated()));
				lastPermAddressModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(lastPermanentAddress.getDateUpdated()));
				lastPermAddressModel.setCity(lastPermanentAddress.getLastPermanentCity());
				lastPermAddressModel.setState(StateEnum.lookupEnum(lastPermanentAddress.getLastPermanentState()));
				lastPermAddressModel.setStreet(lastPermanentAddress.getLastPermanentStreet());
				lastPermAddressModel.setZip(String.valueOf(lastPermanentAddress.getLastPermanentZIP()));
				
				Enrollment enrollmentModel = (Enrollment) get(Enrollment.class, domain.getEnrollmentProjectEntryIDMap().get(lastPermanentAddress.getProjectEntryID()));
				lastPermAddressModel.setEnrollmentid(enrollmentModel);
				com.servinglynk.hmis.warehouse.model.staging.Export exportEntity = (com.servinglynk.hmis.warehouse.model.staging.Export) get(com.servinglynk.hmis.warehouse.model.staging.Export.class, domain.getExportId());
				lastPermAddressModel.setExport(exportEntity);
				exportEntity.addLastPermAddress(lastPermAddressModel);
				hydrateCommonFields(lastPermAddressModel, domain);
				insertOrUpdate(lastPermAddressModel);
			}
		}

	}

	@Override
	public void hydrateLive(Export export) {
		Set<LastPermAddress> lastPermAddresses = export.getLastPermAddresses();
		if(lastPermAddresses != null) {
			for(LastPermAddress lastPermAddress : lastPermAddresses) {
				if(lastPermAddress != null) {
					com.servinglynk.hmis.warehouse.model.live.LastPermAddress target = new com.servinglynk.hmis.warehouse.model.live.LastPermAddress();
					BeanUtils.copyProperties(lastPermAddress,target, getNonCollectionFields(target));
					com.servinglynk.hmis.warehouse.model.live.Enrollment enrollmentModel = (com.servinglynk.hmis.warehouse.model.live.Enrollment) get(com.servinglynk.hmis.warehouse.model.live.Enrollment.class, lastPermAddress.getEnrollmentid().getId());
					target.setEnrollmentid(enrollmentModel);
					com.servinglynk.hmis.warehouse.model.live.Export exportEntity = (com.servinglynk.hmis.warehouse.model.live.Export) get(com.servinglynk.hmis.warehouse.model.live.Export.class, export.getId());
					target.setExport(exportEntity);
					target.setDateCreated(LocalDateTime.now());
					target.setDateUpdated(LocalDateTime.now());
					exportEntity.addLastPermAddress(target);
					insertOrUpdate(target);
				}
 			}
		}
	}

	@Override
	public void hydrateHBASE(SyncDomain syncDomain) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void performSave(Iface client, Object entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected List performGet(Iface client, Object entity) {
		// TODO Auto-generated method stub
		return null;
	}
	public com.servinglynk.hmis.warehouse.model.live.LastPermAddress createLastPermanentAddress(com.servinglynk.hmis.warehouse.model.live.LastPermAddress lastPermanentAddress){
			       lastPermanentAddress.setId(UUID.randomUUID()); 
			       insert(lastPermanentAddress);
			       return lastPermanentAddress;
			   }
			   public com.servinglynk.hmis.warehouse.model.live.LastPermAddress updateLastPermanentAddress(com.servinglynk.hmis.warehouse.model.live.LastPermAddress lastPermanentAddress){
			       update(lastPermanentAddress);
			       return lastPermanentAddress;
			   }
			   public void deleteLastPermanentAddress(com.servinglynk.hmis.warehouse.model.live.LastPermAddress lastPermanentAddress){
			       delete(lastPermanentAddress);
			   }
			   public com.servinglynk.hmis.warehouse.model.live.LastPermAddress getLastPermanentAddressById(UUID lastPermanentAddressId){ 
			       return (com.servinglynk.hmis.warehouse.model.live.LastPermAddress) get(com.servinglynk.hmis.warehouse.model.live.LastPermAddress.class, lastPermanentAddressId);
			   }
			   public List<com.servinglynk.hmis.warehouse.model.live.LastPermAddress> getAllEnrollmentLastPermanentAddresss(UUID enrollmentId,Integer startIndex, Integer maxItems){
			       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.live.LastPermAddress.class);
			       criteria.createAlias("enrollmentid", "enrollmentid");
			       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
			       return (List<com.servinglynk.hmis.warehouse.model.live.LastPermAddress>) findByCriteria(criteria,startIndex,maxItems);
			   }
			   public long getEnrollmentLastPermanentAddresssCount(UUID enrollmentId){
			       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.live.LastPermAddress.class);
			       criteria.createAlias("enrollmentid", "enrollmentid");
			       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
			       return countRows(criteria);
			   }
		
}

