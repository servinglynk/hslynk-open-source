/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.apache.hadoop.hbase.thrift2.generated.THBaseService.Iface;
import org.springframework.beans.BeanUtils;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Disabilities;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.DisabilitiesDisabilitytypeEnum;
import com.servinglynk.hmis.warehouse.enums.DisabilitiesDocumentationonfileEnum;
import com.servinglynk.hmis.warehouse.enums.DisabilitiesIndefiniteandimpairsEnum;
import com.servinglynk.hmis.warehouse.enums.DisabilitiesPathhowconfirmedEnum;
import com.servinglynk.hmis.warehouse.enums.DisabilitiesPathsmiinformationEnum;
import com.servinglynk.hmis.warehouse.enums.DisabilitiesReceivingservicesEnum;
import com.servinglynk.hmis.warehouse.model.staging.Enrollment;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class DisabilitiesDaoImpl extends ParentDaoImpl implements
		DisabilitiesDao {
	
	public void hydrateStaging(ExportDomain domain) 
	{
		
		Export export = domain.getExport();
		List<Disabilities> disabilitiesList = export.getDisabilities();
		if(disabilitiesList!=null && disabilitiesList.size() > 0 )
		{
			for(Disabilities disabilities : disabilitiesList)
			{
				com.servinglynk.hmis.warehouse.model.staging.Disabilities disabilitiesModel = new com.servinglynk.hmis.warehouse.model.staging.Disabilities();
				disabilitiesModel.setId(UUID.randomUUID());
				disabilitiesModel.setDisabilityresponse(BasicDataGenerator.getIntegerValue(disabilities.getDisabilityResponse()));
				disabilitiesModel.setDisabilitytype(DisabilitiesDisabilitytypeEnum.lookupEnum(BasicDataGenerator.getStringValue(disabilities.getDisabilityType())));
				disabilitiesModel.setDocumentationonfile(DisabilitiesDocumentationonfileEnum.lookupEnum(BasicDataGenerator.getStringValue(disabilities.getDocumentationOnFile())));
				disabilitiesModel.setIndefiniteandimpairs(DisabilitiesIndefiniteandimpairsEnum.lookupEnum(BasicDataGenerator.getStringValue(disabilities.getIndefiniteAndImpairs())));
				disabilitiesModel.setPathhowconfirmed(DisabilitiesPathhowconfirmedEnum.lookupEnum(BasicDataGenerator.getStringValue(disabilities.getPATHHowConfirmed())));
				disabilitiesModel.setPathsmiinformation(DisabilitiesPathsmiinformationEnum.lookupEnum(BasicDataGenerator.getStringValue(disabilities.getPATHSMIInformation())));
				disabilitiesModel.setReceivingservices(DisabilitiesReceivingservicesEnum.lookupEnum(BasicDataGenerator.getStringValue(disabilities.getReceivingServices())));
				disabilitiesModel.setDateCreated(BasicDataGenerator.getLocalDate(disabilities.getDateCreated()));
				disabilitiesModel.setDateUpdated(BasicDataGenerator.getLocalDate(disabilities.getDateUpdated()));
				if(disabilities.getProjectEntryID() !=null && !"".equals(disabilities.getProjectEntryID())) {
					UUID uuid = domain.getEnrollmentProjectEntryIDMap().get((disabilities.getProjectEntryID()));
					if(uuid !=null) {
						Enrollment enrollmentModel = (Enrollment) get(Enrollment.class, uuid);
						disabilitiesModel.setEnrollmentid(enrollmentModel);
					}
						
				}
				
				com.servinglynk.hmis.warehouse.model.staging.Export exportEntity = (com.servinglynk.hmis.warehouse.model.staging.Export) get(com.servinglynk.hmis.warehouse.model.staging.Export.class, domain.getExportId());
				disabilitiesModel.setExport(exportEntity);
				
				exportEntity.addDisabilities(disabilitiesModel);
				insertOrUpdate(disabilitiesModel);
			}
		}
	}

	@Override
	public void hydrateLive(
			com.servinglynk.hmis.warehouse.model.staging.Export export) {
		Set<com.servinglynk.hmis.warehouse.model.staging.Disabilities> disabilitieses = export.getDisabilitieses();
		if(disabilitieses !=null && !disabilitieses.isEmpty()) {
			for(com.servinglynk.hmis.warehouse.model.staging.Disabilities disabilities : disabilitieses) {
				com.servinglynk.hmis.warehouse.model.live.Disabilities target = new com.servinglynk.hmis.warehouse.model.live.Disabilities();
				BeanUtils.copyProperties(disabilities, target,getNonCollectionFields(target));
				insert(target);
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
}
