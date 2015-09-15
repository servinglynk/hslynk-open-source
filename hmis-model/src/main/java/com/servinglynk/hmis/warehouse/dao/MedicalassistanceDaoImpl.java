/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.apache.hadoop.hbase.thrift2.generated.THBaseService.Iface;
import org.springframework.beans.BeanUtils;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.MedicalAssistance;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.MedicalassistanceAdapEnum;
import com.servinglynk.hmis.warehouse.enums.MedicalassistanceHivaidsassistanceEnum;
import com.servinglynk.hmis.warehouse.enums.MedicalassistanceNoadapreasonEnum;
import com.servinglynk.hmis.warehouse.enums.MedicalassistanceNohivaidsassistancereasonEnum;
import com.servinglynk.hmis.warehouse.model.staging.Enrollment;
import com.servinglynk.hmis.warehouse.model.staging.Export;
import com.servinglynk.hmis.warehouse.model.staging.Medicalassistance;
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
		if(medicalAssistanceList !=null && !medicalAssistanceList.isEmpty())
		{
			for(MedicalAssistance medicalAssistance : medicalAssistanceList)
			{
				Medicalassistance medicalassistanceModel = new Medicalassistance();
				UUID id = UUID.randomUUID();
				medicalassistanceModel.setId(id);
				medicalassistanceModel.setDateCreated(BasicDataGenerator.getLocalDate(medicalAssistance.getDateCreated()));
				medicalassistanceModel.setDateUpdated(BasicDataGenerator.getLocalDate(medicalAssistance.getDateUpdated()));
				medicalassistanceModel.setAdap(MedicalassistanceAdapEnum.lookupEnum(BasicDataGenerator.getStringValue(medicalAssistance.getADAP())));
				medicalassistanceModel.setHivaidsassistance(MedicalassistanceHivaidsassistanceEnum.lookupEnum(BasicDataGenerator.getStringValue(medicalAssistance.getHIVAIDSAssistance())));
				medicalassistanceModel.setNoadapreason(MedicalassistanceNoadapreasonEnum.lookupEnum(BasicDataGenerator.getStringValue(medicalAssistance.getNoADAPReason())));
				medicalassistanceModel.setNohivaidsassistancereason(MedicalassistanceNohivaidsassistancereasonEnum.lookupEnum(BasicDataGenerator.getStringValue(medicalAssistance.getNoHIVAIDSAssistanceReason())));
				Enrollment enrollmentModel = (Enrollment) get(Enrollment.class, domain.getEnrollmentProjectEntryIDMap().get(medicalAssistance.getProjectEntryID()));
				medicalassistanceModel.setEnrollmentid(enrollmentModel);
				com.servinglynk.hmis.warehouse.model.staging.Export exportEntity = (com.servinglynk.hmis.warehouse.model.staging.Export) get(com.servinglynk.hmis.warehouse.model.staging.Export.class, domain.getExportId());
				medicalassistanceModel.setExport(exportEntity);
				exportEntity.addMedicalassistance(medicalassistanceModel);
				insertOrUpdate(medicalassistanceModel);
			}
		}
	}

	@Override
	public void hydrateLive(Export export) {
		Set<Medicalassistance> medicalassistances = export.getMedicalassistances();
		if(medicalassistances != null && !medicalassistances.isEmpty()) {
			for(Medicalassistance medicalassistance : medicalassistances) {
				if(medicalassistance != null) {
					com.servinglynk.hmis.warehouse.model.live.Medicalassistance target = new com.servinglynk.hmis.warehouse.model.live.Medicalassistance();
					BeanUtils.copyProperties(medicalassistance, target,getNonCollectionFields(target));
					insert(target);
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

}
