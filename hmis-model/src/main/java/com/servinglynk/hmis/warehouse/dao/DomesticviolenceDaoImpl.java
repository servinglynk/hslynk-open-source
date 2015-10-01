package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.apache.hadoop.hbase.thrift2.generated.THBaseService.Iface;
import org.springframework.beans.BeanUtils;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.DomesticViolence;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.DomesticviolenceDomesticviolencevictimEnum;
import com.servinglynk.hmis.warehouse.enums.DomesticviolenceWhenoccurredEnum;
import com.servinglynk.hmis.warehouse.model.staging.Domesticviolence;
import com.servinglynk.hmis.warehouse.model.staging.Enrollment;
import com.servinglynk.hmis.warehouse.model.staging.Export;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

public class DomesticviolenceDaoImpl extends ParentDaoImpl implements
		DomesticviolenceDao {

	@Override
	public void hydrateStaging(ExportDomain domain) {
		
		java.util.List<DomesticViolence> domesticViolenceList = domain.getExport().getDomesticViolence();
		if(domesticViolenceList!=null && !domesticViolenceList.isEmpty())
		{
			for(DomesticViolence domesticViolence : domesticViolenceList)
			{
				Domesticviolence domesticviolenceModel = new Domesticviolence();
				domesticviolenceModel.setId(UUID.randomUUID());
				domesticviolenceModel.setDomesticviolencevictim(DomesticviolenceDomesticviolencevictimEnum.lookupEnum(BasicDataGenerator.getStringValue(domesticViolence.getDomesticViolenceVictim())));
				domesticviolenceModel.setWhenoccurred(DomesticviolenceWhenoccurredEnum.lookupEnum(BasicDataGenerator.getStringValue(domesticViolence.getWhenOccurred())));
				domesticviolenceModel.setDateCreated(BasicDataGenerator.getLocalDate(domesticViolence.getDateCreated()));
				domesticviolenceModel.setDateUpdated(BasicDataGenerator.getLocalDate(domesticViolence.getDateUpdated()));
				Enrollment enrollmentModel = (Enrollment) get(Enrollment.class, domain.getEnrollmentProjectEntryIDMap().get(domesticViolence.getProjectEntryID()));
				com.servinglynk.hmis.warehouse.model.staging.Export exportEntity = (com.servinglynk.hmis.warehouse.model.staging.Export) get(com.servinglynk.hmis.warehouse.model.staging.Export.class, domain.getExportId());
				domesticviolenceModel.setExport(exportEntity);
				domesticviolenceModel.setEnrollmentid(enrollmentModel);
				exportEntity.addDomesticviolence(domesticviolenceModel);
				insertOrUpdate(domesticviolenceModel);
			}
		}

	}

	@Override
	public void hydrateLive(Export export) {
		Set<Domesticviolence> domesticviolences = export.getDomesticviolences();
		if(domesticviolences != null && !domesticviolences.isEmpty()) {
			for(Domesticviolence domesticviolence : domesticviolences) {
				com.servinglynk.hmis.warehouse.model.live.Domesticviolence target = new com.servinglynk.hmis.warehouse.model.live.Domesticviolence();
				 BeanUtils.copyProperties(domesticviolence, target,getNonCollectionFields(target));
				 com.servinglynk.hmis.warehouse.model.live.Enrollment enrollmentModel = (com.servinglynk.hmis.warehouse.model.live.Enrollment) get(com.servinglynk.hmis.warehouse.model.live.Enrollment.class, domesticviolence.getEnrollmentid().getId());
				 target.setEnrollmentid(enrollmentModel);
				 com.servinglynk.hmis.warehouse.model.live.Export exportEntity = (com.servinglynk.hmis.warehouse.model.live.Export) get(com.servinglynk.hmis.warehouse.model.live.Export.class, export.getId());
				 target.setExport(exportEntity);
				 exportEntity.addDomesticviolence(target);
				 insertOrUpdate(target);
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
