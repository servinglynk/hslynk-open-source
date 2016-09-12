/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.base.util.ErrorType;
import com.servinglynk.hmis.warehouse.model.v2014.Error2014;

import org.apache.commons.collections.CollectionUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.HealthInsurance;
import com.servinglynk.hmis.warehouse.enums.DataCollectionStageEnum;
import com.servinglynk.hmis.warehouse.enums.HealthinsuranceInsurancefromanysourceEnum;
import com.servinglynk.hmis.warehouse.enums.HealthinsuranceMedicaidEnum;
import com.servinglynk.hmis.warehouse.enums.HealthinsuranceMedicareEnum;
import com.servinglynk.hmis.warehouse.enums.HealthinsuranceNocobrareasonEnum;
import com.servinglynk.hmis.warehouse.enums.HealthinsuranceNoemployerprovidedreasonEnum;
import com.servinglynk.hmis.warehouse.enums.HealthinsuranceNomedicaidreasonEnum;
import com.servinglynk.hmis.warehouse.enums.HealthinsuranceNomedicarereasonEnum;
import com.servinglynk.hmis.warehouse.enums.HealthinsuranceNoprivatepayreasonEnum;
import com.servinglynk.hmis.warehouse.enums.HealthinsuranceNoschipreasonEnum;
import com.servinglynk.hmis.warehouse.enums.HealthinsuranceNostatehealthinsreasonEnum;
import com.servinglynk.hmis.warehouse.enums.HealthinsuranceNovamedreasonEnum;
import com.servinglynk.hmis.warehouse.enums.HealthinsurancePrivatepayEnum;
import com.servinglynk.hmis.warehouse.enums.HealthinsuranceSchipEnum;
import com.servinglynk.hmis.warehouse.enums.HealthinsuranceStatehealthinsEnum;
import com.servinglynk.hmis.warehouse.enums.HealthinsuranceVamedicalservicesEnum;
import com.servinglynk.hmis.warehouse.model.v2014.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2014.Healthinsurance;
import com.servinglynk.hmis.warehouse.model.v2014.HmisBaseModel;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class HealthinsuranceDaoImpl extends ParentDaoImpl implements
		HealthinsuranceDao {
	private static final Logger logger = LoggerFactory
			.getLogger(HealthinsuranceDaoImpl.class);

	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception {
		List<HealthInsurance> healthInsurances = domain.getExport().getHealthInsurance();
		if(healthInsurances!=null && healthInsurances.size() >0 )
		{
			Data data =new Data();
			Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2014.Healthinsurance.class, getProjectGroupCode(domain));
			com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) getModel(Healthinsurance.class.getSimpleName(),com.servinglynk.hmis.warehouse.model.v2014.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false,exportModelMap, domain.getUpload().getId());
			if(CollectionUtils.isNotEmpty(healthInsurances)) {
				for(HealthInsurance healthInsurance : healthInsurances)
				{
					Healthinsurance model = null;
					try{
						model = getModelObject(domain, healthInsurance,data,modelMap);
						model.setCobra(BasicDataGenerator.getIntegerValue(healthInsurance.getCOBRA()));
						model.setEmployerprovided(BasicDataGenerator.getIntegerValue(healthInsurance.getEmployerProvided()));
						model.setInsurancefromanysource(HealthinsuranceInsurancefromanysourceEnum.lookupEnum(BasicDataGenerator.getStringValue(healthInsurance.getInsuranceFromAnySource())));
						model.setMedicaid(HealthinsuranceMedicaidEnum.lookupEnum(BasicDataGenerator.getStringValue(healthInsurance.getMedicaid())));
						model.setMedicare(HealthinsuranceMedicareEnum.lookupEnum(BasicDataGenerator.getStringValue(healthInsurance.getMedicare())));
						model.setNocobrareason(HealthinsuranceNocobrareasonEnum.lookupEnum(BasicDataGenerator.getStringValue(healthInsurance.getNoCOBRAReason())));
						model.setNoemployerprovidedreason(HealthinsuranceNoemployerprovidedreasonEnum.lookupEnum(BasicDataGenerator.getStringValue(healthInsurance.getNoEmployerProvidedReason())));
						model.setNomedicaidreason(HealthinsuranceNomedicaidreasonEnum.lookupEnum(BasicDataGenerator.getStringValue(healthInsurance.getNoMedicaidReason())));
						model.setNomedicarereason(HealthinsuranceNomedicarereasonEnum.lookupEnum(BasicDataGenerator.getStringValue(healthInsurance.getNoMedicareReason())));
						model.setNoprivatepayreason(HealthinsuranceNoprivatepayreasonEnum.lookupEnum(BasicDataGenerator.getStringValue(healthInsurance.getNoPrivatePayReason())));
						model.setNoschipreason(HealthinsuranceNoschipreasonEnum.lookupEnum(BasicDataGenerator.getStringValue(healthInsurance.getNoSCHIPReason())));
						model.setNostatehealthinsreason(HealthinsuranceNostatehealthinsreasonEnum.lookupEnum(BasicDataGenerator.getStringValue(healthInsurance.getNoStateHealthInsReason())));
						model.setNovamedreason(HealthinsuranceNovamedreasonEnum.lookupEnum(BasicDataGenerator.getStringValue(healthInsurance.getNoVAMedReason())));
						model.setPrivatepay(HealthinsurancePrivatepayEnum.lookupEnum(BasicDataGenerator.getStringValue(healthInsurance.getPrivatePay())));
						model.setSchip(HealthinsuranceSchipEnum.lookupEnum(BasicDataGenerator.getStringValue(healthInsurance.getSCHIP())));
						model.setStatehealthins(HealthinsuranceStatehealthinsEnum.lookupEnum(BasicDataGenerator.getStringValue(healthInsurance.getStateHealthIns())));
						model.setVamedicalservices(HealthinsuranceVamedicalservicesEnum.lookupEnum(BasicDataGenerator.getStringValue(healthInsurance.getVAMedicalServices())));
						model.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(healthInsurance.getDateCreated()));
						model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(healthInsurance.getDateUpdated()));
						Enrollment enrollmentModel = (Enrollment) getModel(Healthinsurance.class.getSimpleName(),Enrollment.class,healthInsurance.getProjectEntryID(),getProjectGroupCode(domain),true,relatedModelMap, domain.getUpload().getId());
						model.setEnrollmentid(enrollmentModel);
						model.setInformationDate(BasicDataGenerator.getLocalDateTime(healthInsurance.getInformationDate()));
						model.setDataCollectionStage(DataCollectionStageEnum.lookupEnum(BasicDataGenerator.getStringValue(healthInsurance.getDataCollectionStage())));
						model.setExport(exportEntity);
						if(!isFullRefresh(domain)) {
							HmisBaseModel hmisBaseModel = modelMap.get(model.getSourceSystemId());
							if(hmisBaseModel !=null) {
								modelMatch(hmisBaseModel, model);
							}	
							if(!model.isRecordToBoInserted() && !model.isIgnored()) {
								++data.j;
							}
						}
						performSaveOrUpdate(model);
					}catch(Exception e) {
						String errorMessage = "Exception in:"+healthInsurance.getProjectEntryID()+  ":: Exception" +e.getLocalizedMessage();
						if (model != null) {
							Error2014 error = new Error2014();
							error.model_id = model.getId();
							error.bulk_upload_ui = domain.getUpload().getId();
							error.project_group_code = domain.getUpload().getProjectGroupCode();
							error.source_system_id = model.getSourceSystemId();
							error.type = ErrorType.ERROR;
							error.error_description = errorMessage;
							error.date_created = model.getDateCreated();
							performSave(error);
						}
						logger.error(errorMessage);
					}
			  }
			}
			hydrateBulkUploadActivityStaging(data.i,data.j, com.servinglynk.hmis.warehouse.model.v2014.Healthinsurance.class.getSimpleName(), domain, exportEntity);
		}
	}
	public com.servinglynk.hmis.warehouse.model.v2014.Healthinsurance getModelObject(ExportDomain domain,HealthInsurance healthInsurance ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2014.Healthinsurance healthinsuranceModel = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			healthinsuranceModel = (com.servinglynk.hmis.warehouse.model.v2014.Healthinsurance) getModel(Healthinsurance.class.getSimpleName(),com.servinglynk.hmis.warehouse.model.v2014.Healthinsurance.class, healthInsurance.getHealthInsuranceID(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
		
		if(healthinsuranceModel == null) {
			healthinsuranceModel = new com.servinglynk.hmis.warehouse.model.v2014.Healthinsurance();
			healthinsuranceModel.setId(UUID.randomUUID());
			healthinsuranceModel.setRecordToBeInserted(true);
			++data.i;
		}
		hydrateCommonFields(healthinsuranceModel, domain,healthInsurance.getHealthInsuranceID(),data.i+data.j);
		return healthinsuranceModel;
	}
	   public com.servinglynk.hmis.warehouse.model.v2014.Healthinsurance createHealthInsurance(com.servinglynk.hmis.warehouse.model.v2014.Healthinsurance healthInsurance){
	       healthInsurance.setId(UUID.randomUUID()); 
	       insert(healthInsurance);
	       return healthInsurance;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Healthinsurance updateHealthInsurance(com.servinglynk.hmis.warehouse.model.v2014.Healthinsurance healthInsurance){
	       update(healthInsurance);
	       return healthInsurance;
	   }
	   public void deleteHealthInsurance(com.servinglynk.hmis.warehouse.model.v2014.Healthinsurance healthInsurance){
	       delete(healthInsurance);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Healthinsurance getHealthInsuranceById(UUID healthInsuranceId){ 
	       return (com.servinglynk.hmis.warehouse.model.v2014.Healthinsurance) get(com.servinglynk.hmis.warehouse.model.v2014.Healthinsurance.class, healthInsuranceId);
	   }
	   
	   @SuppressWarnings("unchecked")
	   public List<com.servinglynk.hmis.warehouse.model.v2014.Healthinsurance> getAllEnrollmentHealthInsurances(UUID enrollmentId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Healthinsurance.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2014.Healthinsurance>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getEnrollmentHealthInsurancesCount(UUID enrollmentId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Healthinsurance.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return countRows(criteria);
	   }
	
}
