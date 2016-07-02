/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.hbase.thrift2.generated.THBaseService.Iface;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.HealthInsurance;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
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
import com.servinglynk.hmis.warehouse.model.v2014.Export;
import com.servinglynk.hmis.warehouse.model.v2014.Healthinsurance;
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
	public void hydrateStaging(ExportDomain domain) {
		List<HealthInsurance> healthInsurances = domain.getExport().getHealthInsurance();
		hydrateBulkUploadActivityStaging(healthInsurances, com.servinglynk.hmis.warehouse.model.v2014.Healthinsurance.class.getSimpleName(), domain);
		if(healthInsurances!=null && healthInsurances.size() >0 )
		{
			int i=0;
			com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) get(com.servinglynk.hmis.warehouse.model.v2014.Export.class, domain.getExportId());
			for(HealthInsurance healthInsurance : healthInsurances)
			{
				Healthinsurance healthinsuranceModel = new Healthinsurance();
				healthinsuranceModel.setId(UUID.randomUUID());
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
				healthinsuranceModel.setDateCreated(LocalDateTime.now());
				healthinsuranceModel.setDateUpdated(LocalDateTime.now());
				healthinsuranceModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(healthInsurance.getDateCreated()));
				healthinsuranceModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(healthInsurance.getDateUpdated()));
				
				if(StringUtils.isNotBlank(healthInsurance.getProjectEntryID())) {
					UUID id = domain.getEnrollmentProjectEntryIDMap().get(healthInsurance.getProjectEntryID());
					if(id != null) {
						Enrollment enrollmentModel = (Enrollment) get(Enrollment.class,id);
						healthinsuranceModel.setEnrollmentid(enrollmentModel);
					}else {
						logger.warn("EnrollmentCoc : A match was not found for Project EntryID:{}",healthInsurance.getProjectEntryID());
					}
				}
				healthinsuranceModel.setExport(exportEntity);
				exportEntity.addHealthinsurance(healthinsuranceModel);
				i++;
				hydrateCommonFields(healthinsuranceModel, domain, healthInsurance.getHealthInsuranceID(),i);
			}
		}
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
