/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.apache.hadoop.hbase.thrift2.generated.THBaseService.Iface;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.BeanUtils;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Services;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.ServicesRecordtypeEnum;
import com.servinglynk.hmis.warehouse.enums.ServicesReferraloutcomeEnum;
import com.servinglynk.hmis.warehouse.model.staging.Enrollment;
import com.servinglynk.hmis.warehouse.model.staging.Export;
import com.servinglynk.hmis.warehouse.model.staging.Projectcompletionstatus;
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
				servicesModel.setDateprovided(BasicDataGenerator.getLocalDateTime(services.getDateProvided()));
				servicesModel.setFaamount(new BigDecimal(String.valueOf(services.getFAAmount())));
				servicesModel.setOthertypeprovided(services.getOtherTypeProvided());
				servicesModel.setRecordtype(ServicesRecordtypeEnum.lookupEnum(BasicDataGenerator.getStringValue(services.getRecordType())));
				servicesModel.setReferraloutcome(ServicesReferraloutcomeEnum.lookupEnum(BasicDataGenerator.getStringValue(services.getReferralOutcome())));
				servicesModel.setSubtypeprovided(BasicDataGenerator.getIntegerValue(services.getSubTypeProvided()));
				servicesModel.setTypeprovided(BasicDataGenerator.getIntegerValue(services.getTypeProvided()));
				servicesModel.setDateCreated(BasicDataGenerator.getLocalDateTime(services.getDateCreated()));
				servicesModel.setDateUpdated(BasicDataGenerator.getLocalDateTime(services.getDateUpdated()));
				Enrollment enrollment = (Enrollment) get(Enrollment.class, domain.getEnrollmentProjectEntryIDMap().get(services.getProjectEntryID()));
				servicesModel.setEnrollmentid(enrollment);
				com.servinglynk.hmis.warehouse.model.staging.Export exportEntity = (com.servinglynk.hmis.warehouse.model.staging.Export) get(com.servinglynk.hmis.warehouse.model.staging.Export.class, domain.getExportId());
				servicesModel.setExport(exportEntity);
				hydrateCommonFields(servicesModel, exportEntity.getUser());
				insertOrUpdate(servicesModel);
			}
		}
	}

	@Override
	public void hydrateLive(Export export) {
		Set<com.servinglynk.hmis.warehouse.model.staging.Services> servicesStaging = export.getServiceses();
		if(servicesStaging != null && !servicesStaging.isEmpty()) {
			for(com.servinglynk.hmis.warehouse.model.staging.Services services : servicesStaging) {
				if(services != null) {
					com.servinglynk.hmis.warehouse.model.live.Services target = new com.servinglynk.hmis.warehouse.model.live.Services();
					BeanUtils.copyProperties(services, target,getNonCollectionFields(target));
					com.servinglynk.hmis.warehouse.model.live.Enrollment enrollmentModel = (com.servinglynk.hmis.warehouse.model.live.Enrollment) get(com.servinglynk.hmis.warehouse.model.live.Enrollment.class, services.getEnrollmentid().getId());
					target.setEnrollmentid(enrollmentModel);
					com.servinglynk.hmis.warehouse.model.live.Export exportEntity = (com.servinglynk.hmis.warehouse.model.live.Export) get(com.servinglynk.hmis.warehouse.model.live.Export.class, export.getId());
					target.setExport(exportEntity);
					exportEntity.addServices(target);
					target.setDateCreated(LocalDateTime.now());
					target.setDateUpdated(LocalDateTime.now());
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
	
	   public com.servinglynk.hmis.warehouse.model.live.Services createServices(com.servinglynk.hmis.warehouse.model.live.Services services){
	       services.setId(UUID.randomUUID()); 
	       insert(services);
	       return services;
	   }
	   public com.servinglynk.hmis.warehouse.model.live.Services updateServices(com.servinglynk.hmis.warehouse.model.live.Services services){
	       update(services);
	       return services;
	   }
	   public void deleteServices(com.servinglynk.hmis.warehouse.model.live.Services services){
	       delete(services);
	   }
	   public com.servinglynk.hmis.warehouse.model.live.Services getServicesById(UUID servicesId){ 
	       return (com.servinglynk.hmis.warehouse.model.live.Services) get(com.servinglynk.hmis.warehouse.model.live.Services.class, servicesId);
	   }
	   public List<com.servinglynk.hmis.warehouse.model.live.Services> getAllEnrollmentServicess(UUID enrollmentId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.live.Services.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return (List<com.servinglynk.hmis.warehouse.model.live.Services>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getEnrollmentServicessCount(UUID enrollmentId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.live.Services.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return countRows(criteria);
	   }

}
