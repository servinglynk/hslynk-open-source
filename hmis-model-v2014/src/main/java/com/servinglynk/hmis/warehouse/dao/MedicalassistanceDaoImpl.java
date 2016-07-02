/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.MedicalAssistance;
import com.servinglynk.hmis.warehouse.enums.MedicalassistanceAdapEnum;
import com.servinglynk.hmis.warehouse.enums.MedicalassistanceHivaidsassistanceEnum;
import com.servinglynk.hmis.warehouse.enums.MedicalassistanceNoadapreasonEnum;
import com.servinglynk.hmis.warehouse.enums.MedicalassistanceNohivaidsassistancereasonEnum;
import com.servinglynk.hmis.warehouse.model.v2014.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2014.Medicalassistance;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class MedicalassistanceDaoImpl extends ParentDaoImpl implements
		MedicalassistanceDao {

	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain) {
		List<MedicalAssistance> medicalAssistanceList = domain.getExport().getMedicalAssistance();
		hydrateBulkUploadActivityStaging(medicalAssistanceList, com.servinglynk.hmis.warehouse.model.v2014.Medicalassistance.class.getSimpleName(), domain);
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) get(com.servinglynk.hmis.warehouse.model.v2014.Export.class, domain.getExportId());
		if(medicalAssistanceList !=null && !medicalAssistanceList.isEmpty())
		{
			int i=0;
			for(MedicalAssistance medicalAssistance : medicalAssistanceList)
			{
				Medicalassistance medicalassistanceModel = new Medicalassistance();
				UUID id = UUID.randomUUID();
				medicalassistanceModel.setId(id);
				medicalassistanceModel.setDateCreated(LocalDateTime.now());
				medicalassistanceModel.setDateUpdated(LocalDateTime.now());
				medicalassistanceModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(medicalAssistance.getDateCreated()));
				medicalassistanceModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(medicalAssistance.getDateUpdated()));
				medicalassistanceModel.setAdap(MedicalassistanceAdapEnum.lookupEnum(BasicDataGenerator.getStringValue(medicalAssistance.getADAP())));
				medicalassistanceModel.setHivaidsassistance(MedicalassistanceHivaidsassistanceEnum.lookupEnum(BasicDataGenerator.getStringValue(medicalAssistance.getHIVAIDSAssistance())));
				medicalassistanceModel.setNoadapreason(MedicalassistanceNoadapreasonEnum.lookupEnum(BasicDataGenerator.getStringValue(medicalAssistance.getNoADAPReason())));
				medicalassistanceModel.setNohivaidsassistancereason(MedicalassistanceNohivaidsassistancereasonEnum.lookupEnum(BasicDataGenerator.getStringValue(medicalAssistance.getNoHIVAIDSAssistanceReason())));
				if(StringUtils.isNotBlank(medicalAssistance.getProjectEntryID())) {
					UUID uuid = domain.getEnrollmentProjectEntryIDMap().get((medicalAssistance.getProjectEntryID()));
					if(uuid !=null) {
						Enrollment enrollmentModel = (Enrollment) get(Enrollment.class, uuid);
						medicalassistanceModel.setEnrollmentid(enrollmentModel);
					}
						
				}
				medicalassistanceModel.setExport(exportEntity);
				exportEntity.addMedicalassistance(medicalassistanceModel);
				i++;
				hydrateCommonFields(medicalassistanceModel, domain, medicalAssistance.getMedicalAssistanceID(),i);
			}
		}
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
