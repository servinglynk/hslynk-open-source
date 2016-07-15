/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.collections.CollectionUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.HealthInsurance;
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
			com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) getModel(com.servinglynk.hmis.warehouse.model.v2014.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false,exportModelMap);
			if(CollectionUtils.isNotEmpty(healthInsurances)) {
				for(HealthInsurance healthInsurance : healthInsurances)
				{
					try{
						Healthinsurance healthinsuranceModel = getModelObject(domain, healthInsurance,data,modelMap);
						healthinsuranceModel.setCobra(BasicDataGenerator.getIntegerValue(healthInsurance.getCOBRA()));
						healthinsuranceModel.setEmployerprovided(BasicDataGenerator.getIntegerValue(healthInsurance.getEmployerProvided()));
						healthinsuranceModel.setInsurancefromanysource(HealthinsuranceInsurancefromanysourceEnum.lookupEnum(BasicDataGenerator.getStringValue(healthInsurance.getInsuranceFromAnySource())));
						healthinsuranceModel.setMedicaid(HealthinsuranceMedicaidEnum.lookupEnum(BasicDataGenerator.getStringValue(healthInsurance.getMedicaid())));
						healthinsuranceModel.setMedicare(HealthinsuranceMedicareEnum.lookupEnum(BasicDataGenerator.getStringValue(healthInsurance.getMedicare())));
						healthinsuranceModel.setNocobrareason(HealthinsuranceNocobrareasonEnum.lookupEnum(BasicDataGenerator.getStringValue(healthInsurance.getNoCOBRAReason())));
						healthinsuranceModel.setNoemployerprovidedreason(HealthinsuranceNoemployerprovidedreasonEnum.lookupEnum(BasicDataGenerator.getStringValue(healthInsurance.getNoEmployerProvidedReason())));
						healthinsuranceModel.setNomedicaidreason(HealthinsuranceNomedicaidreasonEnum.lookupEnum(BasicDataGenerator.getStringValue(healthInsurance.getNoMedicaidReason())));
						healthinsuranceModel.setNomedicarereason(HealthinsuranceNomedicarereasonEnum.lookupEnum(BasicDataGenerator.getStringValue(healthInsurance.getNoMedicareReason())));
						healthinsuranceModel.setNoprivatepayreason(HealthinsuranceNoprivatepayreasonEnum.lookupEnum(BasicDataGenerator.getStringValue(healthInsurance.getNoPrivatePayReason())));
						healthinsuranceModel.setNoschipreason(HealthinsuranceNoschipreasonEnum.lookupEnum(BasicDataGenerator.getStringValue(healthInsurance.getNoSCHIPReason())));
						healthinsuranceModel.setNostatehealthinsreason(HealthinsuranceNostatehealthinsreasonEnum.lookupEnum(BasicDataGenerator.getStringValue(healthInsurance.getNoStateHealthInsReason())));
						healthinsuranceModel.setNovamedreason(HealthinsuranceNovamedreasonEnum.lookupEnum(BasicDataGenerator.getStringValue(healthInsurance.getNoVAMedReason())));
						healthinsuranceModel.setPrivatepay(HealthinsurancePrivatepayEnum.lookupEnum(BasicDataGenerator.getStringValue(healthInsurance.getPrivatePay())));
						healthinsuranceModel.setSchip(HealthinsuranceSchipEnum.lookupEnum(BasicDataGenerator.getStringValue(healthInsurance.getSCHIP())));
						healthinsuranceModel.setStatehealthins(HealthinsuranceStatehealthinsEnum.lookupEnum(BasicDataGenerator.getStringValue(healthInsurance.getStateHealthIns())));
						healthinsuranceModel.setVamedicalservices(HealthinsuranceVamedicalservicesEnum.lookupEnum(BasicDataGenerator.getStringValue(healthInsurance.getVAMedicalServices())));
						healthinsuranceModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(healthInsurance.getDateCreated()));
						healthinsuranceModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(healthInsurance.getDateUpdated()));
						Enrollment enrollmentModel = (Enrollment) getModel(Enrollment.class,healthInsurance.getHealthInsuranceID(),getProjectGroupCode(domain),true,relatedModelMap);
						healthinsuranceModel.setEnrollmentid(enrollmentModel);
						healthinsuranceModel.setExport(exportEntity);
						if(exportEntity != null)
							exportEntity.addHealthinsurance(healthinsuranceModel);
						performSaveOrUpdate(healthinsuranceModel);
					}catch(Exception e) {
						logger.error("Exception in:"+healthInsurance.getProjectEntryID()+  ":: Exception" +e.getLocalizedMessage());
						throw new Exception(e);
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
			healthinsuranceModel = (com.servinglynk.hmis.warehouse.model.v2014.Healthinsurance) getModel(com.servinglynk.hmis.warehouse.model.v2014.Healthinsurance.class, healthInsurance.getHealthInsuranceID(), getProjectGroupCode(domain),false,modelMap);
		
		if(healthinsuranceModel == null) {
			healthinsuranceModel = new com.servinglynk.hmis.warehouse.model.v2014.Healthinsurance();
			healthinsuranceModel.setId(UUID.randomUUID());
			healthinsuranceModel.setInserted(true);
			++data.i;
		}else{
			++data.j;
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
