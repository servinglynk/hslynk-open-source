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
import com.servinglynk.hmis.warehouse.model.v2015.ServiceFaReferral;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

public class ServiceFaReferralDaoImpl extends ParentDaoImpl implements ServiceFaReferralDao{

	@Override
	public void hydrateStaging(ExportDomain domain) {
		
	    com.servinglynk.hmis.warehouse.domain.Sources.Source.Export export = domain.getExport();
		List<Services> services = export.getServices();
		hydrateBulkUploadActivityStaging(services, com.servinglynk.hmis.warehouse.model.v2015.ServiceFaReferral.class.getSimpleName(), domain);
		if (services != null && services.size() > 0) {
			for (Services serviceFaReferrals : services) {
				com.servinglynk.hmis.warehouse.model.stagv2015.ServiceFaReferral serviceFaReferralModel = new com.servinglynk.hmis.warehouse.model.stagv2015.ServiceFaReferral();
				UUID serviceFaReferralUUID = UUID.randomUUID();
				serviceFaReferralModel.setId(serviceFaReferralUUID);
				serviceFaReferralModel.setDateprovided(BasicDataGenerator.getLocalDateTime(serviceFaReferrals.getDateCreated()));
				serviceFaReferralModel.setFaAmount(new BigDecimal(serviceFaReferrals.getFAAmount()));
				//serviceFaReferralModel.setFunderList(serviceFaReferrals.getFunderList());
				serviceFaReferralModel.setOtherTypeProvided(serviceFaReferrals.getOtherTypeProvided());
				serviceFaReferralModel.setReferralOutcome(new Integer(serviceFaReferrals.getReferralOutcome()).intValue());
			//	serviceFaReferralModel.setServiceCategory(new Integer(serviceFaReferrals.getFAAmount()).intValue());
				serviceFaReferralModel.setSubTypeProvided(new Integer(serviceFaReferrals.getSubTypeProvided()).intValue());
				serviceFaReferralModel.setTypeProvided(new Integer(serviceFaReferrals.getTypeProvided()).intValue());
								
				serviceFaReferralModel.setDeleted(false);
				serviceFaReferralModel.setDateCreated(LocalDateTime.now());
				serviceFaReferralModel.setDateUpdated(LocalDateTime.now());
				com.servinglynk.hmis.warehouse.model.stagv2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.stagv2015.Export) get(com.servinglynk.hmis.warehouse.model.stagv2015.Export.class, domain.getExportId());
				exportEntity.addServiceFaReferral(serviceFaReferralModel);
				serviceFaReferralModel.setUserId(exportEntity.getUserId());
				serviceFaReferralModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(serviceFaReferrals.getDateCreated()));
				serviceFaReferralModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(serviceFaReferrals.getDateUpdated()));
				hydrateCommonFields(serviceFaReferralModel, domain);
				serviceFaReferralModel.setExport(exportEntity);
				serviceFaReferralModel.setProjectGroupCode(serviceFaReferrals.getProjectEntryID());
				serviceFaReferralModel.setSync(false);
				insertOrUpdate(serviceFaReferralModel);
			}
		}
	
	}


	@Override
	public void hydrateLive(com.servinglynk.hmis.warehouse.model.stagv2015.Export export, Long id) {
		Set<com.servinglynk.hmis.warehouse.model.stagv2015.ServiceFaReferral> serviceFaReferral = export.getServiceFaReferrals();
		hydrateBulkUploadActivity(serviceFaReferral, com.servinglynk.hmis.warehouse.model.v2015.ServiceFaReferral.class.getSimpleName(), export, id);
		if(serviceFaReferral !=null && !serviceFaReferral.isEmpty()) {
			for(com.servinglynk.hmis.warehouse.model.stagv2015.ServiceFaReferral serviceFaReferrals : serviceFaReferral) {
			//	com.servinglynk.hmis.warehouse.model.v2015.ServiceFaReferral serviceFaReferralByDedupCliendId = getServiceFaReferralByDedupServiceFaReferralId(serviceFaReferrals.getId(),serviceFaReferrals.getProjectGroupCode());
			//	if(serviceFaReferralByDedupCliendId ==null) {
					com.servinglynk.hmis.warehouse.model.v2015.ServiceFaReferral target = new com.servinglynk.hmis.warehouse.model.v2015.ServiceFaReferral();
					BeanUtils.copyProperties(serviceFaReferrals, target, new String[] {"enrollments","veteranInfoes"});
					com.servinglynk.hmis.warehouse.model.v2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2015.Export) get(com.servinglynk.hmis.warehouse.model.v2015.Export.class, export.getId());
					exportEntity.addServiceFaReferral(target);
					target.setExport(exportEntity);
					insertOrUpdate(target);
				}
		//	}
		}
	}
	
	@Override
	public void hydrateLive(com.servinglynk.hmis.warehouse.model.stagv2015.ServiceFaReferral serviceFaReferral) {
			if(serviceFaReferral !=null) {
				com.servinglynk.hmis.warehouse.model.v2015.ServiceFaReferral target = new com.servinglynk.hmis.warehouse.model.v2015.ServiceFaReferral();
				BeanUtils.copyProperties(serviceFaReferral, target, new String[] {"enrollments","veteranInfoes"});
				com.servinglynk.hmis.warehouse.model.v2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2015.Export) get(com.servinglynk.hmis.warehouse.model.v2015.Export.class, serviceFaReferral.getExport().getId());
				exportEntity.addServiceFaReferral(target);
				target.setExport(exportEntity);
				com.servinglynk.hmis.warehouse.model.v2015.ServiceFaReferral serviceFaReferralByDedupCliendId = getServiceFaReferralByDedupServiceFaReferralId(serviceFaReferral.getId(),serviceFaReferral.getProjectGroupCode());
				if(serviceFaReferralByDedupCliendId ==null) {
					insert(target);	
				}
			}
	}
	
	
	@Override
	public void hydrateHBASE(SyncDomain syncDomain) {
		// TODO Auto-generated method stub
		
	}


	@Override
	protected void performSave(Iface coc, Object entity) {
		// TODO Auto-generated method stub
		
	}


	@Override
	protected List performGet(Iface coc, Object entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServiceFaReferral createServiceFaReferral(ServiceFaReferral serviceFaReferral) {
		serviceFaReferral.setId(UUID.randomUUID());
			insert(serviceFaReferral);
		return serviceFaReferral;
	}


	@Override
	public ServiceFaReferral updateServiceFaReferral(com.servinglynk.hmis.warehouse.model.v2015.ServiceFaReferral serviceFaReferral) {
			update(serviceFaReferral);
		return serviceFaReferral;
	}


	@Override
	public void deleteServiceFaReferral(com.servinglynk.hmis.warehouse.model.v2015.ServiceFaReferral serviceFaReferral) {
			delete(serviceFaReferral);
		
	}


	@SuppressWarnings("unchecked")
	@Override
	public com.servinglynk.hmis.warehouse.model.v2015.ServiceFaReferral getServiceFaReferralById(UUID serviceFaReferralId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.ServiceFaReferral.class);
		criteria.add(Restrictions.eq("id", serviceFaReferralId));
		List<com.servinglynk.hmis.warehouse.model.v2015.ServiceFaReferral> serviceFaReferral = (List<com.servinglynk.hmis.warehouse.model.v2015.ServiceFaReferral>) findByCriteria(criteria);
		if(serviceFaReferral.size()>0) return serviceFaReferral.get(0);
		return null;
	}
	@SuppressWarnings("unchecked")
	@Override
	public com.servinglynk.hmis.warehouse.model.v2015.ServiceFaReferral getServiceFaReferralByDedupServiceFaReferralId(UUID id,String projectGroupCode) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.ServiceFaReferral.class);
		criteria.add(Restrictions.eq("dedupClientId", id));
		criteria.add(Restrictions.eq("projectGroupCode", projectGroupCode));
		List<com.servinglynk.hmis.warehouse.model.v2015.ServiceFaReferral> serviceFaReferral = (List<com.servinglynk.hmis.warehouse.model.v2015.ServiceFaReferral>) findByCriteria(criteria);
		if(serviceFaReferral !=null && serviceFaReferral.size()>0) return serviceFaReferral.get(0);
		return null;
	}
	/*public com.servinglynk.hmis.warehouse.model.stagv2015.Coc getCocByDedupCliendIdFromStaging(UUID id) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.stagv2015.Coc.class);
		criteria.add(Restrictions.eq("dedupClientId", id));
		List<com.servinglynk.hmis.warehouse.model.stagv2015.Coc> coc = (List<com.servinglynk.hmis.warehouse.model.stagv2015.Coc>) findByCriteria(criteria);
		if(coc !=null && coc.size()>0) return coc.get(0);
		return null;
	}*/

	@SuppressWarnings("unchecked")
	@Override
	public List<com.servinglynk.hmis.warehouse.model.v2015.ServiceFaReferral> getAllServiceFaReferral(Integer startIndex, Integer maxItems) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.ServiceFaReferral.class);	
		List<com.servinglynk.hmis.warehouse.model.v2015.ServiceFaReferral> serviceFaReferral = (List<com.servinglynk.hmis.warehouse.model.v2015.ServiceFaReferral>) findByCriteria(criteria,startIndex,maxItems);
		return serviceFaReferral;
	}
	
	
	public long getServiceFaReferralCount(){
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.ServiceFaReferral.class);	
		return countRows(criteria);
	}


	@Override
	public long getEnrollmentServiceFaReferralsCount(UUID enrollmentId) {
		 DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.RhybcpStatus.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return countRows(criteria);
	}


	@Override
	public List<ServiceFaReferral> getAllEnrollmentServiceFaReferrals(UUID enrollmentId, Integer startIndex,
			Integer maxItems) {
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.ServiceFaReferral.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2015.ServiceFaReferral>) findByCriteria(criteria,startIndex,maxItems);
	}


}
