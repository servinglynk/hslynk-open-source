/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.BeanUtils;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.LastPermanentAddress;
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
				lastPermAddressModel.setDateCreated(BasicDataGenerator.getLocalDate(lastPermanentAddress.getDateCreated()));
				lastPermAddressModel.setDateUpdated(BasicDataGenerator.getLocalDate(lastPermanentAddress.getDateUpdated()));
				lastPermAddressModel.setCity(lastPermanentAddress.getLastPermanentCity());
				lastPermAddressModel.setState(StateEnum.lookupEnum(lastPermanentAddress.getLastPermanentState()));
				lastPermAddressModel.setStreet(lastPermanentAddress.getLastPermanentStreet());
				lastPermAddressModel.setZip(String.valueOf(lastPermanentAddress.getLastPermanentZIP()));
				
				Enrollment enrollmentModel = (Enrollment) get(Enrollment.class, domain.getEnrollmentProjectEntryIDMap().get(lastPermanentAddress.getProjectEntryID()));
				lastPermAddressModel.setEnrollmentid(enrollmentModel);
				com.servinglynk.hmis.warehouse.model.staging.Export exportEntity = (com.servinglynk.hmis.warehouse.model.staging.Export) get(com.servinglynk.hmis.warehouse.model.staging.Export.class, domain.getExportId());
				lastPermAddressModel.setExport(exportEntity);
				exportEntity.addLastPermAddress(lastPermAddressModel);
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
					BeanUtils.copyProperties(lastPermAddress, target);
					insert(target);
				}
 			}
		}
	}

}

