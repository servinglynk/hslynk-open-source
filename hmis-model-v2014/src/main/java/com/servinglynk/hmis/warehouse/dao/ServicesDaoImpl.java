/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Services;
import com.servinglynk.hmis.warehouse.enums.ServicesRecordtypeEnum;
import com.servinglynk.hmis.warehouse.enums.ServicesReferraloutcomeEnum;
import com.servinglynk.hmis.warehouse.model.v2014.Enrollment;
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
		hydrateBulkUploadActivityStaging(servicesList, com.servinglynk.hmis.warehouse.model.v2014.Services.class.getSimpleName(), domain);
		int i=0;
		if(servicesList != null && !servicesList.isEmpty())
		{
			for(Services services : servicesList)
			{
				UUID id = UUID.randomUUID();
				com.servinglynk.hmis.warehouse.model.v2014.Services servicesModel = new com.servinglynk.hmis.warehouse.model.v2014.Services();
				servicesModel.setId(id);
				servicesModel.setDateprovided(BasicDataGenerator.getLocalDateTime(services.getDateProvided()));
				servicesModel.setFaamount(new BigDecimal(String.valueOf(services.getFAAmount())));
				servicesModel.setOthertypeprovided(services.getOtherTypeProvided());
				servicesModel.setRecordtype(ServicesRecordtypeEnum.lookupEnum(services.getRecordType()));
				servicesModel.setReferraloutcome(ServicesReferraloutcomeEnum.lookupEnum(BasicDataGenerator.getStringValue(services.getReferralOutcome())));
				servicesModel.setSubtypeprovided(BasicDataGenerator.getIntegerValue(services.getSubTypeProvided()));
				servicesModel.setTypeprovided(BasicDataGenerator.getIntegerValue(services.getTypeProvided()));
				servicesModel.setDateCreated(LocalDateTime.now());
				servicesModel.setDateUpdated(LocalDateTime.now());
				servicesModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(services.getDateCreated()));
				servicesModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(services.getDateUpdated()));
				Enrollment enrollment = (Enrollment) get(Enrollment.class, domain.getEnrollmentProjectEntryIDMap().get(services.getProjectEntryID()));
				servicesModel.setEnrollmentid(enrollment);
				com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) get(com.servinglynk.hmis.warehouse.model.v2014.Export.class, domain.getExportId());
				servicesModel.setExport(exportEntity);
				i++;
				hydrateCommonFields(servicesModel, domain,services.getServicesID(),i);
			}
		}
	}

	   public com.servinglynk.hmis.warehouse.model.v2014.Services createServices(com.servinglynk.hmis.warehouse.model.v2014.Services services){
	       services.setId(UUID.randomUUID()); 
	       insert(services);
	       return services;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Services updateServices(com.servinglynk.hmis.warehouse.model.v2014.Services services){
	       update(services);
	       return services;
	   }
	   public void deleteServices(com.servinglynk.hmis.warehouse.model.v2014.Services services){
	       delete(services);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Services getServicesById(UUID servicesId){ 
	       return (com.servinglynk.hmis.warehouse.model.v2014.Services) get(com.servinglynk.hmis.warehouse.model.v2014.Services.class, servicesId);
	   }
	   public List<com.servinglynk.hmis.warehouse.model.v2014.Services> getAllEnrollmentServicess(UUID enrollmentId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Services.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2014.Services>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getEnrollmentServicessCount(UUID enrollmentId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Services.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return countRows(criteria);
	   }

}
