/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
	private static final Logger logger = LoggerFactory
			.getLogger(ServicesDaoImpl.class);
	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain) throws Exception {
		List<Services> servicesList = domain.getExport().getServices();
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) getModel(com.servinglynk.hmis.warehouse.model.v2014.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false);
		Data data =new Data();
		if(servicesList != null && !servicesList.isEmpty())
		{
			for(Services services : servicesList)
			{
				try {
					com.servinglynk.hmis.warehouse.model.v2014.Services servicesModel = getModelObject(domain, services,data);
					servicesModel.setDateprovided(BasicDataGenerator.getLocalDateTime(services.getDateProvided()));
					servicesModel.setFaamount(new BigDecimal(String.valueOf(services.getFAAmount())));
					servicesModel.setOthertypeprovided(services.getOtherTypeProvided());
					servicesModel.setRecordtype(ServicesRecordtypeEnum.lookupEnum(services.getRecordType()));
					servicesModel.setReferraloutcome(ServicesReferraloutcomeEnum.lookupEnum(BasicDataGenerator.getStringValue(services.getReferralOutcome())));
					servicesModel.setSubtypeprovided(BasicDataGenerator.getIntegerValue(services.getSubTypeProvided()));
					servicesModel.setTypeprovided(BasicDataGenerator.getIntegerValue(services.getTypeProvided()));
					servicesModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(services.getDateCreated()));
					servicesModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(services.getDateUpdated()));
					Enrollment enrollment = (Enrollment) getModel(Enrollment.class, services.getProjectEntryID(),getProjectGroupCode(domain),true);
					servicesModel.setEnrollmentid(enrollment);
					servicesModel.setExport(exportEntity);
					if(exportEntity !=null)
						exportEntity.addServices(servicesModel);
					performSaveOrUpdate(servicesModel);
				} catch(Exception e) {
					logger.error("Failure in services:::"+services.toString()+ " with exception"+e.getLocalizedMessage());
					throw new Exception(e);
				}
			}
		}
		hydrateBulkUploadActivityStaging(data.i,data.j, com.servinglynk.hmis.warehouse.model.v2014.Services.class.getSimpleName(), domain, exportEntity);
	}
	public com.servinglynk.hmis.warehouse.model.v2014.Services getModelObject(ExportDomain domain,Services Services ,Data data) {
		com.servinglynk.hmis.warehouse.model.v2014.Services servicesModel = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			servicesModel = (com.servinglynk.hmis.warehouse.model.v2014.Services) getModel(com.servinglynk.hmis.warehouse.model.v2014.Services.class, Services.getServicesID(), getProjectGroupCode(domain),false);
		
		if(servicesModel == null) {
			servicesModel = new com.servinglynk.hmis.warehouse.model.v2014.Services();
			servicesModel.setId(UUID.randomUUID());
			servicesModel.setInserted(true);
			++data.i;
		}else{
			++data.j;
		}
		hydrateCommonFields(servicesModel, domain,Services.getServicesID(),data.i+data.j);
		return servicesModel;
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
