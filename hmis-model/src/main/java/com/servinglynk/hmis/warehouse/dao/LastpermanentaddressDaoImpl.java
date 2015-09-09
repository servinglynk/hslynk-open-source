/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.Map;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.LastPermanentAddress;
import com.servinglynk.hmis.warehouse.enums.LastPermAddressAddressDataQualityEnum;
import com.servinglynk.hmis.warehouse.enums.StateEnum;
import com.servinglynk.hmis.warehouse.model.staging.Enrollment;
import com.servinglynk.hmis.warehouse.model.staging.LastPermAddress;
import com.servinglynk.hmis.warehouse.model.staging.Lastpermanentaddress;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class LastpermanentaddressDaoImpl extends ParentDaoImpl implements
		LastpermanentaddressDao {

	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain) {
//		LastPermanentAddress lastPermanentAddress = export.getLastPermanentAddress();
//		if(lastPermanentAddress !=null)
//		{
//			Lastpermanentaddress lastpermanentaddressModel = new Lastpermanentaddress();
//			UUID id = UUID.randomUUID();
//			lastpermanentaddressModel.setId(id);
//			lastpermanentaddressModel.set(LastPermAddressAddressDataQualityEnum.lookupEnum(BasicDataGenerator.getStringValue(lastPermanentAddress.getAddressDataQuality())));
//			lastpermanentaddressModel.setDateCreated(BasicDataGenerator.getLocalDate(lastPermanentAddress.getDateCreated()));
//			lastpermanentaddressModel.setDateUpdated(BasicDataGenerator.getLocalDate(lastPermanentAddress.getDateUpdated()));
//			lastpermanentaddressModel.setCity(lastPermanentAddress.getLastPermanentCity());
//			lastpermanentaddressModel.setState(StateEnum.lookupEnum(lastPermanentAddress.getLastPermanentState()));
//			lastpermanentaddressModel.setStreet(lastPermanentAddress.getLastPermanentStreet());
//			lastpermanentaddressModel.setZip(String.valueOf(lastPermanentAddress.getLastPermanentZIP()));
//			
//			Enrollment enrollmentModel = (Enrollment) get(Enrollment.class, enrollmentProjectEntryIDMap.get(lastPermanentAddress.getProjectEntryID()));
//			lastpermanentaddressModel.setEnrollmentid(enrollmentModel);
//			insertOrUpdate(lastpermanentaddressModel);
//		}
	}

	@Override
	public void hydrateLive(
			com.servinglynk.hmis.warehouse.model.staging.Export export) {
		// TODO Auto-generated method stub
		
	}

}
