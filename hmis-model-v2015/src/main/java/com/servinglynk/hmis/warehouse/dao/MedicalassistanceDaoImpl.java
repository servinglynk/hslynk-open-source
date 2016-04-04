/**
 *
 */
package com.servinglynk.hmis.warehouse.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.apache.hadoop.hbase.thrift2.generated.THBaseService.Iface;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.BeanUtils;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.MedicalAssistance;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.MedicalassistanceAdapEnum;
import com.servinglynk.hmis.warehouse.enums.MedicalassistanceHivaidsassistanceEnum;
import com.servinglynk.hmis.warehouse.enums.MedicalassistanceNoadapreasonEnum;
import com.servinglynk.hmis.warehouse.enums.MedicalassistanceNohivaidsassistancereasonEnum;
import com.servinglynk.hmis.warehouse.model.stagv2015.Enrollment;
import com.servinglynk.hmis.warehouse.model.stagv2015.Export;
import com.servinglynk.hmis.warehouse.model.stagv2015.Medicalassistance;
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
		hydrateBulkUploadActivityStaging(medicalAssistanceList, com.servinglynk.hmis.warehouse.model.v2015.Medicalassistance.class.getSimpleName(), domain);
		if(medicalAssistanceList !=null && !medicalAssistanceList.isEmpty())
		{
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

				Enrollment enrollmentModel = (Enrollment) get(Enrollment.class, domain.getEnrollmentProjectEntryIDMap().get(medicalAssistance.getProjectEntryID()));
				medicalassistanceModel.setEnrollmentid(enrollmentModel);
				com.servinglynk.hmis.warehouse.model.stagv2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.stagv2015.Export) get(com.servinglynk.hmis.warehouse.model.stagv2015.Export.class, domain.getExportId());
				medicalassistanceModel.setExport(exportEntity);
				exportEntity.addMedicalassistance(medicalassistanceModel);
				hydrateCommonFields(medicalassistanceModel, domain);
				insertOrUpdate(medicalassistanceModel);
			}
		}
	}

	@Override
	public void hydrateLive(Export export) {
		Set<Medicalassistance> medicalassistances = export.getMedicalassistances();
		hydrateBulkUploadActivity(medicalassistances, com.servinglynk.hmis.warehouse.model.v2015.Medicalassistance.class.getSimpleName(), export);
		if(medicalassistances != null && !medicalassistances.isEmpty()) {
			for(Medicalassistance medicalassistance : medicalassistances) {
				if(medicalassistance != null) {
					com.servinglynk.hmis.warehouse.model.v2015.Medicalassistance target = new com.servinglynk.hmis.warehouse.model.v2015.Medicalassistance();
					BeanUtils.copyProperties(medicalassistance, target,getNonCollectionFields(target));
					com.servinglynk.hmis.warehouse.model.v2015.Enrollment enrollmentModel = (com.servinglynk.hmis.warehouse.model.v2015.Enrollment) get(com.servinglynk.hmis.warehouse.model.v2015.Enrollment.class, medicalassistance.getEnrollmentid().getId());
					target.setEnrollmentid(enrollmentModel);
					com.servinglynk.hmis.warehouse.model.v2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2015.Export) get(com.servinglynk.hmis.warehouse.model.v2015.Export.class, export.getId());
					target.setExport(exportEntity);
					exportEntity.addMedicalassistance(target);
					target.setDateCreated(LocalDateTime.now());
					target.setDateUpdated(LocalDateTime.now());
					insertOrUpdate(target);
				}
			}
		}
	}

	@Override
	public void hydrateHBASE(SyncDomain syncDomain) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void performSave(Iface client, Object entity) {
		// TODO Auto-generated method stub

	}

	@Override
	protected List performGet(Iface client, Object entity) {
		// TODO Auto-generated method stub
		return null;
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
