/**
 *
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.servinglynk.hmis.warehouse.base.util.ErrorType;
import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.HealthInsurance;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
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
import com.servinglynk.hmis.warehouse.enums.NoYesEnum;
import com.servinglynk.hmis.warehouse.model.v2017.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2017.Error2017;
import com.servinglynk.hmis.warehouse.model.v2017.Healthinsurance;
import com.servinglynk.hmis.warehouse.model.v2017.HmisBaseModel;
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
		com.servinglynk.hmis.warehouse.model.v2017.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2017.Export) getModel(com.servinglynk.hmis.warehouse.model.v2017.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false,exportModelMap, domain.getUpload().getId());
		Data data =new Data();
		Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2017.Healthinsurance.class, getProjectGroupCode(domain));
		if(healthInsurances!=null && healthInsurances.size() >0 )
		{
			for(HealthInsurance healthInsurance : healthInsurances)
			{
				Healthinsurance healthinsuranceModel = null;
				try {
					healthinsuranceModel = getModelObject(domain, healthInsurance,data,modelMap);
					healthinsuranceModel.setCobra(BasicDataGenerator.getIntegerValue(healthInsurance.getCOBRA()));
					healthinsuranceModel.setEmployerprovided(BasicDataGenerator.getIntegerValue(healthInsurance.getEmployerProvided()));
					healthinsuranceModel.setInsurancefromanysource(HealthinsuranceInsurancefromanysourceEnum.lookupEnum((healthInsurance.getInsuranceFromAnySource())));
					healthinsuranceModel.setMedicaid(HealthinsuranceMedicaidEnum.lookupEnum((healthInsurance.getMedicaid())));
					healthinsuranceModel.setMedicare(HealthinsuranceMedicareEnum.lookupEnum((healthInsurance.getMedicare())));
					healthinsuranceModel.setNocobrareason(HealthinsuranceNocobrareasonEnum.lookupEnum((healthInsurance.getNoCOBRAReason())));
					healthinsuranceModel.setNoemployerprovidedreason(HealthinsuranceNoemployerprovidedreasonEnum.lookupEnum((healthInsurance.getNoEmployerProvidedReason())));
					healthinsuranceModel.setNomedicaidreason(HealthinsuranceNomedicaidreasonEnum.lookupEnum((healthInsurance.getNoMedicaidReason())));
					healthinsuranceModel.setNomedicarereason(HealthinsuranceNomedicarereasonEnum.lookupEnum((healthInsurance.getNoMedicareReason())));
					healthinsuranceModel.setNoprivatepayreason(HealthinsuranceNoprivatepayreasonEnum.lookupEnum((healthInsurance.getNoPrivatePayReason())));
					healthinsuranceModel.setNoschipreason(HealthinsuranceNoschipreasonEnum.lookupEnum((healthInsurance.getNoSCHIPReason())));
					healthinsuranceModel.setNostatehealthinsreason(HealthinsuranceNostatehealthinsreasonEnum.lookupEnum((healthInsurance.getNoStateHealthInsReason())));
					healthinsuranceModel.setNovamedreason(HealthinsuranceNovamedreasonEnum.lookupEnum((healthInsurance.getNoVAMedReason())));
					healthinsuranceModel.setPrivatepay(HealthinsurancePrivatepayEnum.lookupEnum((healthInsurance.getPrivatePay())));
					healthinsuranceModel.setSchip(HealthinsuranceSchipEnum.lookupEnum((healthInsurance.getSCHIP())));
					healthinsuranceModel.setStatehealthinadults(HealthinsuranceStatehealthinsEnum.lookupEnum((healthInsurance.getStateHealthIns())));
					healthinsuranceModel.setVamedicalservices(HealthinsuranceVamedicalservicesEnum.lookupEnum((healthInsurance.getVAMedicalServices())));
					healthinsuranceModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(healthInsurance.getDateCreated()));
					healthinsuranceModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(healthInsurance.getDateUpdated()));
					healthinsuranceModel.setOtherInsurance(NoYesEnum.lookupEnum((healthInsurance.getOtherInsurance())));
					healthinsuranceModel.setOtherInsuranceIdentify(healthInsurance.getOtherInsuranceIdentify());
					healthinsuranceModel.setIndianHealthServices(NoYesEnum.lookupEnum((healthInsurance.getIndianHealthServices())));
					healthinsuranceModel.setNoIndianHealthServicesReason(HealthinsuranceNomedicaidreasonEnum.lookupEnum(healthInsurance.getNoIndianHealthServicesReason()));
					Enrollment enrollmentModel = (Enrollment) getModel(Enrollment.class, healthInsurance.getEnrollmentID(),getProjectGroupCode(domain),true,relatedModelMap, domain.getUpload().getId());
					healthinsuranceModel.setEnrollmentid(enrollmentModel);
					healthinsuranceModel.setInformationDate(BasicDataGenerator.getLocalDateTime(healthInsurance.getInformationDate()));
					healthinsuranceModel.setDataCollectionStage(DataCollectionStageEnum.lookupEnum((healthInsurance.getDataCollectionStage())));
					healthinsuranceModel.setExport(exportEntity);
					performSaveOrUpdate(healthinsuranceModel,domain);
				} catch(Exception e){
					String errorMessage = "Exception beause of the healthInsurance::"+healthInsurance.getHealthInsuranceID() +" Exception ::"+e.getMessage();
					if(healthinsuranceModel != null){
						Error2017 error = new Error2017();
						error.model_id = healthinsuranceModel.getId();
						error.bulk_upload_ui = domain.getUpload().getId();
						error.project_group_code = domain.getUpload().getProjectGroupCode();
						error.source_system_id = healthinsuranceModel.getSourceSystemId();
						error.type = ErrorType.ERROR;
						error.error_description = errorMessage;
						error.date_created = healthinsuranceModel.getDateCreated();
						performSave(error);
					}
					logger.error(errorMessage);
				}
			}
		}
		hydrateBulkUploadActivityStaging(data.i,data.j,data.ignore, com.servinglynk.hmis.warehouse.model.v2017.Healthinsurance.class.getSimpleName(), domain, exportEntity);
	}

	public com.servinglynk.hmis.warehouse.model.v2017.Healthinsurance getModelObject(ExportDomain domain, HealthInsurance healthinsurance ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2017.Healthinsurance modelFromDB = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			modelFromDB = (com.servinglynk.hmis.warehouse.model.v2017.Healthinsurance) getModel(com.servinglynk.hmis.warehouse.model.v2017.Healthinsurance.class, healthinsurance.getHealthInsuranceID(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
		
		if(domain.isReUpload() && modelFromDB != null) {
			return modelFromDB;
		}
		
		if(modelFromDB == null) {
			modelFromDB = new com.servinglynk.hmis.warehouse.model.v2017.Healthinsurance();
			modelFromDB.setId(UUID.randomUUID());
			modelFromDB.setRecordToBeInserted(true);
		}
		com.servinglynk.hmis.warehouse.model.v2017.Healthinsurance model = new com.servinglynk.hmis.warehouse.model.v2017.Healthinsurance();
		// org.springframework.beans.BeanUtils.copyProperties(modelFromDB, model);
		model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(healthinsurance.getDateUpdated()));
		performMatch(domain, modelFromDB, model, data);
		hydrateCommonFields(model, domain,healthinsurance.getHealthInsuranceID(),data);
		return model;
	}

	@Override
	public void hydrateHBASE(SyncDomain syncDomain) {
		// TODO Auto-generated method stub

	}

	   public com.servinglynk.hmis.warehouse.model.v2017.Healthinsurance createHealthInsurance(com.servinglynk.hmis.warehouse.model.v2017.Healthinsurance healthInsurance){
	       healthInsurance.setId(UUID.randomUUID());
	       insert(healthInsurance);
	       return healthInsurance;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2017.Healthinsurance updateHealthInsurance(com.servinglynk.hmis.warehouse.model.v2017.Healthinsurance healthInsurance){
	       update(healthInsurance);
	       return healthInsurance;
	   }
	   public void deleteHealthInsurance(com.servinglynk.hmis.warehouse.model.v2017.Healthinsurance healthInsurance){
	       delete(healthInsurance);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2017.Healthinsurance getHealthInsuranceById(UUID healthInsuranceId){
		      DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2017.Healthinsurance.class);
		      criteria.add(Restrictions.eq("id", healthInsuranceId));
		      List<com.servinglynk.hmis.warehouse.model.v2017.Healthinsurance> entities = (List<com.servinglynk.hmis.warehouse.model.v2017.Healthinsurance>) findByCriteria(criteria);
		      if(!entities.isEmpty()) return entities.get(0);
		      return null;
	   }

	   @SuppressWarnings("unchecked")
	   public List<com.servinglynk.hmis.warehouse.model.v2017.Healthinsurance> getAllEnrollmentHealthInsurances(UUID enrollmentId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2017.Healthinsurance.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2017.Healthinsurance>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getEnrollmentHealthInsurancesCount(UUID enrollmentId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2017.Healthinsurance.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return countRows(criteria);
	   }

}
