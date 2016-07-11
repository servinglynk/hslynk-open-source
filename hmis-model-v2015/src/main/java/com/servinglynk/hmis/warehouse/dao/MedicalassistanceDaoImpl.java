/**
 *
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.MedicalAssistance;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.MedicalassistanceAdapEnum;
import com.servinglynk.hmis.warehouse.enums.MedicalassistanceHivaidsassistanceEnum;
import com.servinglynk.hmis.warehouse.enums.MedicalassistanceNoadapreasonEnum;
import com.servinglynk.hmis.warehouse.enums.MedicalassistanceNohivaidsassistancereasonEnum;
import com.servinglynk.hmis.warehouse.model.v2015.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2015.Medicalassistance;
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
	public void hydrateStaging(ExportDomain domain) throws Exception {
		List<MedicalAssistance> medicalAssistanceList = domain.getExport().getMedicalAssistance();
		com.servinglynk.hmis.warehouse.model.v2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2015.Export) getModel(com.servinglynk.hmis.warehouse.model.v2015.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false);
		Data data =new Data();
		if(medicalAssistanceList !=null && !medicalAssistanceList.isEmpty())
		{
			for(MedicalAssistance medicalAssistance : medicalAssistanceList)
			{
				try {
					Medicalassistance medicalassistanceModel = getModelObject(domain, medicalAssistance, data);
					medicalassistanceModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(medicalAssistance.getDateCreated()));
					medicalassistanceModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(medicalAssistance.getDateUpdated()));
					medicalassistanceModel.setAdap(MedicalassistanceAdapEnum.lookupEnum(BasicDataGenerator.getStringValue(medicalAssistance.getADAP())));
					medicalassistanceModel.setHivaidsassistance(MedicalassistanceHivaidsassistanceEnum.lookupEnum(BasicDataGenerator.getStringValue(medicalAssistance.getHIVAIDSAssistance())));
					medicalassistanceModel.setNoadapreason(MedicalassistanceNoadapreasonEnum.lookupEnum(BasicDataGenerator.getStringValue(medicalAssistance.getNoADAPReason())));
					medicalassistanceModel.setNohivaidsassistancereason(MedicalassistanceNohivaidsassistancereasonEnum.lookupEnum(BasicDataGenerator.getStringValue(medicalAssistance.getNoHIVAIDSAssistanceReason())));
					
					Enrollment enrollmentModel = (Enrollment) getModel(Enrollment.class, medicalAssistance.getProjectEntryID(),getProjectGroupCode(domain),true);
					medicalassistanceModel.setEnrollmentid(enrollmentModel);
					medicalassistanceModel.setExport(exportEntity);
					if(exportEntity != null)
						exportEntity.addMedicalassistance(medicalassistanceModel);
					performSaveOrUpdate(medicalassistanceModel);
				}catch(Exception e){
					logger.error("Exception beause of the medicalAssistance::"+medicalAssistance.getMedicalAssistanceID() +" Exception ::"+e.getMessage());
					throw new Exception(e);
				}
			}
		}
		hydrateBulkUploadActivityStaging(data.i,data.j, com.servinglynk.hmis.warehouse.model.v2015.Medicalassistance.class.getSimpleName(), domain,exportEntity);
	}
	
	public com.servinglynk.hmis.warehouse.model.v2015.Medicalassistance getModelObject(ExportDomain domain, MedicalAssistance medicalassistance ,Data data) {
		com.servinglynk.hmis.warehouse.model.v2015.Medicalassistance medicalassistanceModel = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			medicalassistanceModel = (com.servinglynk.hmis.warehouse.model.v2015.Medicalassistance) getModel(com.servinglynk.hmis.warehouse.model.v2015.Medicalassistance.class, medicalassistance.getMedicalAssistanceID(), getProjectGroupCode(domain),false);
		
		if(medicalassistanceModel == null) {
			medicalassistanceModel = new com.servinglynk.hmis.warehouse.model.v2015.Medicalassistance();
			medicalassistanceModel.setId(UUID.randomUUID());
			medicalassistanceModel.setInserted(true);
			++data.i;
		}else{
			++data.j;
		}
		hydrateCommonFields(medicalassistanceModel, domain,medicalassistance.getMedicalAssistanceID(),data.i+data.j);
		return medicalassistanceModel;
	}
	


	@Override
	public void hydrateHBASE(SyncDomain syncDomain) {
		// TODO Auto-generated method stub

	}



	   public com.servinglynk.hmis.warehouse.model.v2015.Medicalassistance createMedicalassistance(com.servinglynk.hmis.warehouse.model.v2015.Medicalassistance medicalassistance){
	       medicalassistance.setId(UUID.randomUUID());
	       insert(medicalassistance);
	       return medicalassistance;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2015.Medicalassistance updateMedicalassistance(com.servinglynk.hmis.warehouse.model.v2015.Medicalassistance medicalassistance){
	       update(medicalassistance);
	       return medicalassistance;
	   }
	   public void deleteMedicalassistance(com.servinglynk.hmis.warehouse.model.v2015.Medicalassistance medicalassistance){
	       delete(medicalassistance);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2015.Medicalassistance getMedicalassistanceById(UUID medicalassistanceId){
	       return (com.servinglynk.hmis.warehouse.model.v2015.Medicalassistance) get(com.servinglynk.hmis.warehouse.model.v2015.Medicalassistance.class, medicalassistanceId);
	   }
	   public List<com.servinglynk.hmis.warehouse.model.v2015.Medicalassistance> getAllEnrollmentMedicalassistances(UUID enrollmentId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Medicalassistance.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2015.Medicalassistance>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getEnrollmentMedicalassistancesCount(UUID enrollmentId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Medicalassistance.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return countRows(criteria);
	   }

}
