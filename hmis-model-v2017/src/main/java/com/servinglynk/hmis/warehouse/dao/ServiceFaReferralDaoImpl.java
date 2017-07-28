package com.servinglynk.hmis.warehouse.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import com.servinglynk.hmis.warehouse.base.util.ErrorType;
import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Services;
import com.servinglynk.hmis.warehouse.model.v2017.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2017.Error2016;
import com.servinglynk.hmis.warehouse.model.v2017.HmisBaseModel;
import com.servinglynk.hmis.warehouse.model.v2017.ServiceFaReferral;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

public class ServiceFaReferralDaoImpl extends ParentDaoImpl implements ServiceFaReferralDao{
	private static final Logger logger = LoggerFactory
			.getLogger(ServiceFaReferralDaoImpl.class);
	@Override
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception {
		
	    com.servinglynk.hmis.warehouse.domain.Sources.Source.Export export = domain.getExport();
	    com.servinglynk.hmis.warehouse.model.v2017.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2017.Export) getModel(com.servinglynk.hmis.warehouse.model.v2017.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false,exportModelMap, domain.getUpload().getId());
		Data data =new Data();
		Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2017.ServiceFaReferral.class, getProjectGroupCode(domain));
		List<Services> services = export.getServices();
		if (services != null && services.size() > 0) {
			for (Services serviceFaReferrals : services) {
				com.servinglynk.hmis.warehouse.model.v2017.ServiceFaReferral serviceFaReferralModel = null;
				try{
					serviceFaReferralModel = getModelObject(domain, serviceFaReferrals,data,modelMap);
					serviceFaReferralModel.setDateprovided(BasicDataGenerator.getLocalDateTime(serviceFaReferrals.getDateCreated()));
					serviceFaReferralModel.setFaAmount(new BigDecimal(serviceFaReferrals.getFAAmount()));
					//serviceFaReferralModel.setFunderList(serviceFaReferrals.getFunderList());
					serviceFaReferralModel.setOtherTypeProvided(serviceFaReferrals.getOtherTypeProvided());
					serviceFaReferralModel.setReferralOutcome(new Integer(serviceFaReferrals.getReferralOutcome()).intValue());
					//	serviceFaReferralModel.setServiceCategory(new Integer(serviceFaReferrals.getFAAmount()).intValue());
					serviceFaReferralModel.setSubTypeProvided(new Integer(serviceFaReferrals.getSubTypeProvided()).intValue());
					serviceFaReferralModel.setTypeProvided(new Integer(serviceFaReferrals.getTypeProvided()).intValue());
					Enrollment enrollment = (Enrollment) getModel(Enrollment.class, serviceFaReferrals.getProjectEntryID(),getProjectGroupCode(domain),true,relatedModelMap, domain.getUpload().getId());
					serviceFaReferralModel.setEnrollmentid(enrollment);
					serviceFaReferralModel.setDeleted(false);
					serviceFaReferralModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(serviceFaReferrals.getDateCreated()));
					serviceFaReferralModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(serviceFaReferrals.getDateUpdated()));
					serviceFaReferralModel.setExport(exportEntity);
					serviceFaReferralModel.setSync(false);
					performSaveOrUpdate(serviceFaReferralModel);
				} catch (Exception e){
					String errorMessage = "Exception beause of the serviceFaReferrals::"+serviceFaReferrals.getServicesID() +" Exception ::"+e.getMessage();
					if(serviceFaReferralModel != null){
						Error2016 error = new Error2016();
						error.model_id = serviceFaReferralModel.getId();
						error.bulk_upload_ui = domain.getUpload().getId();
						error.project_group_code = domain.getUpload().getProjectGroupCode();
						error.source_system_id = serviceFaReferralModel.getSourceSystemId();
						error.type = ErrorType.ERROR;
						error.error_description = errorMessage;
						error.date_created = serviceFaReferralModel.getDateCreated();
						performSave(error);
					}
					logger.error(errorMessage);
				}
			}
		}

	}

	public com.servinglynk.hmis.warehouse.model.v2017.ServiceFaReferral getModelObject(ExportDomain domain, Services services ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2017.ServiceFaReferral modelFromDB = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			modelFromDB = (com.servinglynk.hmis.warehouse.model.v2017.ServiceFaReferral) getModel(com.servinglynk.hmis.warehouse.model.v2017.ServiceFaReferral.class, services.getServicesID(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
		
		if(modelFromDB == null) {
			modelFromDB = new com.servinglynk.hmis.warehouse.model.v2017.ServiceFaReferral();
			modelFromDB.setId(UUID.randomUUID());
			modelFromDB.setRecordToBeInserted(true);
		}
		com.servinglynk.hmis.warehouse.model.v2017.ServiceFaReferral model = new com.servinglynk.hmis.warehouse.model.v2017.ServiceFaReferral();
		// org.springframework.beans.BeanUtils.copyProperties(modelFromDB, model);
		model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(services.getDateUpdated()));
		performMatch(domain, modelFromDB, model, data);
		hydrateCommonFields(model, domain,services.getServicesID(),data);
		return model;
	}
	
	
	@Override
	public void hydrateLive(com.servinglynk.hmis.warehouse.model.v2017.ServiceFaReferral serviceFaReferral) {
			if(serviceFaReferral !=null) {
				com.servinglynk.hmis.warehouse.model.v2017.ServiceFaReferral target = new com.servinglynk.hmis.warehouse.model.v2017.ServiceFaReferral();
				BeanUtils.copyProperties(serviceFaReferral, target, new String[] {"enrollments","veteranInfoes"});
				com.servinglynk.hmis.warehouse.model.v2017.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2017.Export) get(com.servinglynk.hmis.warehouse.model.v2017.Export.class, serviceFaReferral.getExport().getId());
				exportEntity.addServiceFaReferral(target);
				target.setExport(exportEntity);
				com.servinglynk.hmis.warehouse.model.v2017.ServiceFaReferral serviceFaReferralByDedupCliendId = getServiceFaReferralByDedupServiceFaReferralId(serviceFaReferral.getId(),serviceFaReferral.getProjectGroupCode());
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
	public ServiceFaReferral createServiceFaReferral(ServiceFaReferral serviceFaReferral) {
		serviceFaReferral.setId(UUID.randomUUID());
			insert(serviceFaReferral);
		return serviceFaReferral;
	}


	@Override
	public ServiceFaReferral updateServiceFaReferral(com.servinglynk.hmis.warehouse.model.v2017.ServiceFaReferral serviceFaReferral) {
			update(serviceFaReferral);
		return serviceFaReferral;
	}


	@Override
	public void deleteServiceFaReferral(com.servinglynk.hmis.warehouse.model.v2017.ServiceFaReferral serviceFaReferral) {
			delete(serviceFaReferral);
		
	}


	@SuppressWarnings("unchecked")
	@Override
	public com.servinglynk.hmis.warehouse.model.v2017.ServiceFaReferral getServiceFaReferralById(UUID serviceFaReferralId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2017.ServiceFaReferral.class);
		criteria.add(Restrictions.eq("id", serviceFaReferralId));
		List<com.servinglynk.hmis.warehouse.model.v2017.ServiceFaReferral> serviceFaReferral = (List<com.servinglynk.hmis.warehouse.model.v2017.ServiceFaReferral>) findByCriteria(criteria);
		if(serviceFaReferral.size()>0) return serviceFaReferral.get(0);
		return null;
	}
	@SuppressWarnings("unchecked")
	@Override
	public com.servinglynk.hmis.warehouse.model.v2017.ServiceFaReferral getServiceFaReferralByDedupServiceFaReferralId(UUID id,String projectGroupCode) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2017.ServiceFaReferral.class);
		criteria.add(Restrictions.eq("dedupClientId", id));
		criteria.add(Restrictions.eq("projectGroupCode", projectGroupCode));
		List<com.servinglynk.hmis.warehouse.model.v2017.ServiceFaReferral> serviceFaReferral = (List<com.servinglynk.hmis.warehouse.model.v2017.ServiceFaReferral>) findByCriteria(criteria);
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
	public List<com.servinglynk.hmis.warehouse.model.v2017.ServiceFaReferral> getAllServiceFaReferral(Integer startIndex, Integer maxItems) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2017.ServiceFaReferral.class);	
		List<com.servinglynk.hmis.warehouse.model.v2017.ServiceFaReferral> serviceFaReferral = (List<com.servinglynk.hmis.warehouse.model.v2017.ServiceFaReferral>) findByCriteria(criteria,startIndex,maxItems);
		return serviceFaReferral;
	}
	
	
	public long getServiceFaReferralCount(){
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2017.ServiceFaReferral.class);	
		return countRows(criteria);
	}


	@Override
	public long getEnrollmentServiceFaReferralsCount(UUID enrollmentId) {
		 DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2017.ServiceFaReferral.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return countRows(criteria);
	}


	@Override
	public List<ServiceFaReferral> getAllEnrollmentServiceFaReferrals(UUID enrollmentId, Integer startIndex,
			Integer maxItems) {
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2017.ServiceFaReferral.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2017.ServiceFaReferral>) findByCriteria(criteria,startIndex,maxItems);
	}


}
