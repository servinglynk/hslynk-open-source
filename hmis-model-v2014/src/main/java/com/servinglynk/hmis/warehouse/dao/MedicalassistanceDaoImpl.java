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

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.MedicalAssistance;
import com.servinglynk.hmis.warehouse.enums.MedicalassistanceAdapEnum;
import com.servinglynk.hmis.warehouse.enums.MedicalassistanceHivaidsassistanceEnum;
import com.servinglynk.hmis.warehouse.enums.MedicalassistanceNoadapreasonEnum;
import com.servinglynk.hmis.warehouse.enums.MedicalassistanceNohivaidsassistancereasonEnum;
import com.servinglynk.hmis.warehouse.model.v2014.Enrollment;
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
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) getModel(com.servinglynk.hmis.warehouse.model.v2014.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false,exportModelMap);
		if(medicalAssistanceList !=null && !medicalAssistanceList.isEmpty())
		{
			Data data =new Data();
			Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2014.Medicalassistance.class, getProjectGroupCode(domain));
			for(MedicalAssistance medicalAssistance : medicalAssistanceList)
			{
				try {
					Medicalassistance medicalassistanceModel = getModelObject(domain, medicalAssistance,data,modelMap);
					medicalassistanceModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(medicalAssistance.getDateCreated()));
					medicalassistanceModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(medicalAssistance.getDateUpdated()));
					medicalassistanceModel.setAdap(MedicalassistanceAdapEnum.lookupEnum(BasicDataGenerator.getStringValue(medicalAssistance.getADAP())));
					medicalassistanceModel.setHivaidsassistance(MedicalassistanceHivaidsassistanceEnum.lookupEnum(BasicDataGenerator.getStringValue(medicalAssistance.getHIVAIDSAssistance())));
					medicalassistanceModel.setNoadapreason(MedicalassistanceNoadapreasonEnum.lookupEnum(BasicDataGenerator.getStringValue(medicalAssistance.getNoADAPReason())));
					medicalassistanceModel.setNohivaidsassistancereason(MedicalassistanceNohivaidsassistancereasonEnum.lookupEnum(BasicDataGenerator.getStringValue(medicalAssistance.getNoHIVAIDSAssistanceReason())));
					Enrollment enrollmentModel = (Enrollment) getModel(Enrollment.class, medicalAssistance.getMedicalAssistanceID(),getProjectGroupCode(domain),true,relatedModelMap);
					medicalassistanceModel.setEnrollmentid(enrollmentModel);
					medicalassistanceModel.setExport(exportEntity);
					performSaveOrUpdate(medicalassistanceModel);
				}catch(Exception e) {
					logger.error("Failure in MedicalAssistance:::"+medicalAssistance.toString()+ " with exception"+e.getLocalizedMessage());
					throw new Exception(e);
				}
			}
		}
	}
	
	public com.servinglynk.hmis.warehouse.model.v2014.Medicalassistance getModelObject(ExportDomain domain,MedicalAssistance medicalassistance ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2014.Medicalassistance MedicalassistanceModel = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			MedicalassistanceModel = (com.servinglynk.hmis.warehouse.model.v2014.Medicalassistance) getModel(com.servinglynk.hmis.warehouse.model.v2014.Medicalassistance.class, medicalassistance.getMedicalAssistanceID(), getProjectGroupCode(domain),false,modelMap);
		
		if(MedicalassistanceModel == null) {
			MedicalassistanceModel = new com.servinglynk.hmis.warehouse.model.v2014.Medicalassistance();
			MedicalassistanceModel.setId(UUID.randomUUID());
			MedicalassistanceModel.setInserted(true);
			++data.i;
		}else{
			++data.j;
		}
		hydrateCommonFields(MedicalassistanceModel, domain,medicalassistance.getMedicalAssistanceID(),data.i+data.j);
		return MedicalassistanceModel;
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
	       return (com.servinglynk.hmis.warehouse.model.v2014.Medicalassistance) get(com.servinglynk.hmis.warehouse.model.v2014.Medicalassistance.class, medicalassistanceId);
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
