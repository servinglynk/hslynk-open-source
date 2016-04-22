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
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.LastPermanentAddress;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.LastPermAddressAddressDataQualityEnum;
import com.servinglynk.hmis.warehouse.enums.StateEnum;
import com.servinglynk.hmis.warehouse.model.stagv2014.Enrollment;
import com.servinglynk.hmis.warehouse.model.stagv2014.Export;
import com.servinglynk.hmis.warehouse.model.stagv2014.LastPermAddress;
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
		hydrateBulkUploadActivityStaging(lastPermanentAddresses, com.servinglynk.hmis.warehouse.model.v2014.LastPermAddress.class.getSimpleName(), domain);
		int i=0;
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
				com.servinglynk.hmis.warehouse.model.stagv2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.stagv2014.Export) get(com.servinglynk.hmis.warehouse.model.stagv2014.Export.class, domain.getExportId());
				lastPermAddressModel.setExport(exportEntity);
				exportEntity.addLastPermAddress(lastPermAddressModel);
				hydrateCommonFields(lastPermAddressModel, domain, lastPermanentAddress.getLastPermanentAddressID());
				insert(lastPermAddressModel);
				i++;
				  if(i % batchSize() == 0 && i > 0) {
	                    getCurrentSession().flush();
	                    getCurrentSession().clear();
	                }
			}
		}

	}

	@Override
	public void hydrateLive(Export export, Long id) {
		Set<LastPermAddress> lastPermAddresses = export.getLastPermAddresses();
		hydrateBulkUploadActivity(lastPermAddresses, com.servinglynk.hmis.warehouse.model.v2014.LastPermAddress.class.getSimpleName(), export,id);
		if(lastPermAddresses != null) {
			for(LastPermAddress lastPermAddress : lastPermAddresses) {
				if(lastPermAddress != null) {
					com.servinglynk.hmis.warehouse.model.v2014.LastPermAddress target = new com.servinglynk.hmis.warehouse.model.v2014.LastPermAddress();
					BeanUtils.copyProperties(lastPermAddress,target, getNonCollectionFields(target));
					com.servinglynk.hmis.warehouse.model.v2014.Enrollment enrollmentModel = (com.servinglynk.hmis.warehouse.model.v2014.Enrollment) get(com.servinglynk.hmis.warehouse.model.v2014.Enrollment.class, lastPermAddress.getEnrollmentid().getId());
					target.setEnrollmentid(enrollmentModel);
					com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) get(com.servinglynk.hmis.warehouse.model.v2014.Export.class, export.getId());
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

