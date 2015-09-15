/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import org.apache.hadoop.hbase.thrift2.generated.THBaseService.Iface;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Services;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.ServicesRecordtypeEnum;
import com.servinglynk.hmis.warehouse.enums.ServicesReferraloutcomeEnum;
import com.servinglynk.hmis.warehouse.model.staging.Enrollment;
import com.servinglynk.hmis.warehouse.model.staging.Export;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class ServicesDaoImpl extends ParentDaoImpl implements ServicesDao {

	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain) {
		List<Services> servicesList = domain.getExport().getServices();
		if(servicesList != null && !servicesList.isEmpty())
		{
			for(Services services : servicesList)
			{
				UUID id = UUID.randomUUID();
				com.servinglynk.hmis.warehouse.model.staging.Services servicesModel = new com.servinglynk.hmis.warehouse.model.staging.Services();
				servicesModel.setId(id);
				servicesModel.setDateprovided(BasicDataGenerator.getLocalDate(services.getDateProvided()));
				servicesModel.setFaamount(new BigDecimal(String.valueOf(services.getFAAmount())));
				servicesModel.setOthertypeprovided(services.getOtherTypeProvided());
				servicesModel.setRecordtype(ServicesRecordtypeEnum.lookupEnum(BasicDataGenerator.getStringValue(services.getRecordType())));
				servicesModel.setReferraloutcome(ServicesReferraloutcomeEnum.lookupEnum(BasicDataGenerator.getStringValue(services.getReferralOutcome())));
				servicesModel.setSubtypeprovided(BasicDataGenerator.getIntegerValue(services.getSubTypeProvided()));
				servicesModel.setTypeprovided(BasicDataGenerator.getIntegerValue(services.getTypeProvided()));
				servicesModel.setDateCreated(BasicDataGenerator.getLocalDate(services.getDateCreated()));
				servicesModel.setDateUpdated(BasicDataGenerator.getLocalDate(services.getDateUpdated()));
				Enrollment enrollment = (Enrollment) get(Enrollment.class, domain.getEnrollmentProjectEntryIDMap().get(services.getProjectEntryID()));
				servicesModel.setEnrollmentid(enrollment);
				com.servinglynk.hmis.warehouse.model.staging.Export exportEntity = (com.servinglynk.hmis.warehouse.model.staging.Export) get(com.servinglynk.hmis.warehouse.model.staging.Export.class, domain.getExportId());
				servicesModel.setExport(exportEntity);
				insertOrUpdate(servicesModel);
			}
		}
	}

	@Override
	public void hydrateLive(Export export) {
		// TODO Auto-generated method stub
		
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
