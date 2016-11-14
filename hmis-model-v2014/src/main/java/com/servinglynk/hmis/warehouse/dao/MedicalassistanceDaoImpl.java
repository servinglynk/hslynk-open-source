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
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.MedicalAssistance;
import com.servinglynk.hmis.warehouse.enums.DataCollectionStageEnum;
import com.servinglynk.hmis.warehouse.enums.MedicalassistanceAdapEnum;
import com.servinglynk.hmis.warehouse.enums.MedicalassistanceHivaidsassistanceEnum;
import com.servinglynk.hmis.warehouse.enums.MedicalassistanceNoadapreasonEnum;
import com.servinglynk.hmis.warehouse.enums.MedicalassistanceNohivaidsassistancereasonEnum;
import com.servinglynk.hmis.warehouse.model.v2014.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2014.Error2014;
import com.servinglynk.hmis.warehouse.model.v2014.HmisBaseModel;
import com.servinglynk.hmis.warehouse.model.v2014.Medicalassistance;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class MedicalassistanceDaoImpl extends ParentDaoImpl implements
		MedicalassistanceDao {
	private static final Logger logger = LoggerFactory
			.getLogger(MedicalassistanceDaoImpl.class);
	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception {
		List<MedicalAssistance> medicalAssistanceList = domain.getExport().getMedicalAssistance();
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) getModel(Medicalassistance.class.getSimpleName(),com.servinglynk.hmis.warehouse.model.v2014.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false,exportModelMap, domain.getUpload().getId());
		if(medicalAssistanceList !=null && !medicalAssistanceList.isEmpty())
		{
			Data data =new Data();
			Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2014.Medicalassistance.class, getProjectGroupCode(domain));
			for(MedicalAssistance medicalAssistance : medicalAssistanceList)
			{
				Medicalassistance model = null;
				try {
					model = getModelObject(domain, medicalAssistance,data,modelMap);
					model.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(medicalAssistance.getDateCreated()));
					model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(medicalAssistance.getDateUpdated()));
					model.setAdap(MedicalassistanceAdapEnum.lookupEnum(BasicDataGenerator.getStringValue(medicalAssistance.getADAP())));
					model.setHivaidsassistance(MedicalassistanceHivaidsassistanceEnum.lookupEnum(BasicDataGenerator.getStringValue(medicalAssistance.getHIVAIDSAssistance())));
					model.setNoadapreason(MedicalassistanceNoadapreasonEnum.lookupEnum(BasicDataGenerator.getStringValue(medicalAssistance.getNoADAPReason())));
					model.setNohivaidsassistancereason(MedicalassistanceNohivaidsassistancereasonEnum.lookupEnum(BasicDataGenerator.getStringValue(medicalAssistance.getNoHIVAIDSAssistanceReason())));
					Enrollment enrollmentModel = (Enrollment) getModel(Medicalassistance.class.getSimpleName(),Enrollment.class, medicalAssistance.getMedicalAssistanceID(),getProjectGroupCode(domain),true,relatedModelMap, domain.getUpload().getId());
					model.setEnrollmentid(enrollmentModel);
					model.setExport(exportEntity);
					model.setInformationDate(BasicDataGenerator.getLocalDateTime(medicalAssistance.getInformationDate()));
					model.setDataCollectionStage(DataCollectionStageEnum.lookupEnum(BasicDataGenerator.getStringValue(medicalAssistance.getDataCollectionStage())));
									
					performSaveOrUpdate(model);
				}catch(Exception e) {
					String errorMessage = "Failure in MedicalAssistance:::"+medicalAssistance.toString()+ " with exception"+e.getLocalizedMessage();
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
	}
	
	public com.servinglynk.hmis.warehouse.model.v2014.Medicalassistance getModelObject(ExportDomain domain,MedicalAssistance medicalassistance ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2014.Medicalassistance modelFromDB = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			modelFromDB = (com.servinglynk.hmis.warehouse.model.v2014.Medicalassistance) getModel(Medicalassistance.class.getSimpleName(),com.servinglynk.hmis.warehouse.model.v2014.Medicalassistance.class, medicalassistance.getMedicalAssistanceID(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
		
		if(modelFromDB == null) {
			modelFromDB = new com.servinglynk.hmis.warehouse.model.v2014.Medicalassistance();
			modelFromDB.setId(UUID.randomUUID());
			modelFromDB.setRecordToBeInserted(true);
			
		}
		 com.servinglynk.hmis.warehouse.model.v2014.Medicalassistance model = new com.servinglynk.hmis.warehouse.model.v2014.Medicalassistance();
		  org.springframework.beans.BeanUtils.copyProperties(modelFromDB, model);
		  model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(medicalassistance.getDateUpdated()));
		  performMatch(domain, modelFromDB, model, data);
		hydrateCommonFields(model, domain,medicalassistance.getMedicalAssistanceID(),data);
		
		return model;
	}
	   public com.servinglynk.hmis.warehouse.model.v2014.Medicalassistance createMedicalassistance(com.servinglynk.hmis.warehouse.model.v2014.Medicalassistance medicalassistance){
	       medicalassistance.setId(UUID.randomUUID()); 
	       insert(medicalassistance);
	       return medicalassistance;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Medicalassistance updateMedicalassistance(com.servinglynk.hmis.warehouse.model.v2014.Medicalassistance medicalassistance){
	       update(medicalassistance);
	       return medicalassistance;
	   }
	   public void deleteMedicalassistance(com.servinglynk.hmis.warehouse.model.v2014.Medicalassistance medicalassistance){
	       delete(medicalassistance);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Medicalassistance getMedicalassistanceById(UUID medicalassistanceId){ 
		      DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Medicalassistance.class);
		      criteria.add(Restrictions.eq("id", medicalassistanceId));
		      List<com.servinglynk.hmis.warehouse.model.v2014.Medicalassistance> entities = (List<com.servinglynk.hmis.warehouse.model.v2014.Medicalassistance>) findByCriteria(criteria);
		      if(!entities.isEmpty()) return entities.get(0);
		      return null;
	   }
	   public List<com.servinglynk.hmis.warehouse.model.v2014.Medicalassistance> getAllEnrollmentMedicalassistances(UUID enrollmentId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Medicalassistance.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2014.Medicalassistance>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getEnrollmentMedicalassistancesCount(UUID enrollmentId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Medicalassistance.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return countRows(criteria);
	   }

}
