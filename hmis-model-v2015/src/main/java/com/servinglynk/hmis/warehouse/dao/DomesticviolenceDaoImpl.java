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
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.DomesticViolence;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.DomesticviolenceDomesticviolencevictimEnum;
import com.servinglynk.hmis.warehouse.enums.DomesticviolenceWhenoccurredEnum;
import com.servinglynk.hmis.warehouse.model.stagv2015.Domesticviolence;
import com.servinglynk.hmis.warehouse.model.stagv2015.Enrollment;
import com.servinglynk.hmis.warehouse.model.stagv2015.Export;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

public class DomesticviolenceDaoImpl extends ParentDaoImpl implements
		DomesticviolenceDao {

	@Override
	public void hydrateStaging(ExportDomain domain) {

		java.util.List<DomesticViolence> domesticViolenceList = domain.getExport().getDomesticViolence();
		hydrateBulkUploadActivityStaging(domesticViolenceList, com.servinglynk.hmis.warehouse.model.v2015.Domesticviolence.class.getSimpleName(), domain);
		if(domesticViolenceList!=null && !domesticViolenceList.isEmpty())
		{
			for(DomesticViolence domesticViolence : domesticViolenceList)
			{
				Domesticviolence domesticviolenceModel = new Domesticviolence();
				domesticviolenceModel.setId(UUID.randomUUID());
				domesticviolenceModel.setDomesticviolencevictim(DomesticviolenceDomesticviolencevictimEnum.lookupEnum(BasicDataGenerator.getStringValue(domesticViolence.getDomesticViolenceVictim())));
				domesticviolenceModel.setWhenoccurred(DomesticviolenceWhenoccurredEnum.lookupEnum(BasicDataGenerator.getStringValue(domesticViolence.getWhenOccurred())));
				domesticviolenceModel.setDateCreated(LocalDateTime.now());
				domesticviolenceModel.setDateUpdated(LocalDateTime.now());
				domesticviolenceModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(domesticViolence.getDateCreated()));
				domesticviolenceModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(domesticViolence.getDateUpdated()));
				Enrollment enrollmentModel = (Enrollment) get(Enrollment.class, domain.getEnrollmentProjectEntryIDMap().get(domesticViolence.getProjectEntryID()));
				com.servinglynk.hmis.warehouse.model.stagv2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.stagv2015.Export) get(com.servinglynk.hmis.warehouse.model.stagv2015.Export.class, domain.getExportId());
				domesticviolenceModel.setExport(exportEntity);
				domesticviolenceModel.setEnrollmentid(enrollmentModel);
				exportEntity.addDomesticviolence(domesticviolenceModel);
				hydrateCommonFields(domesticviolenceModel, domain);
				insertOrUpdate(domesticviolenceModel);
			}
		}

	}

	@Override
	public void hydrateLive(Export export,Long id) {
		Set<Domesticviolence> domesticviolences = export.getDomesticviolences();
		hydrateBulkUploadActivity(domesticviolences, com.servinglynk.hmis.warehouse.model.v2015.Domesticviolence.class.getSimpleName(), export, id);
		if(domesticviolences != null && !domesticviolences.isEmpty()) {
			for(Domesticviolence domesticviolence : domesticviolences) {
				com.servinglynk.hmis.warehouse.model.v2015.Domesticviolence target = new com.servinglynk.hmis.warehouse.model.v2015.Domesticviolence();
				 BeanUtils.copyProperties(domesticviolence, target,getNonCollectionFields(target));
				 com.servinglynk.hmis.warehouse.model.v2015.Enrollment enrollmentModel = (com.servinglynk.hmis.warehouse.model.v2015.Enrollment) get(com.servinglynk.hmis.warehouse.model.v2015.Enrollment.class, domesticviolence.getEnrollmentid().getId());
				 target.setEnrollmentid(enrollmentModel);
				 com.servinglynk.hmis.warehouse.model.v2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2015.Export) get(com.servinglynk.hmis.warehouse.model.v2015.Export.class, export.getId());
				 target.setExport(exportEntity);
				 exportEntity.addDomesticviolence(target);
				 target.setDateCreated(LocalDateTime.now());
				target.setDateUpdated(LocalDateTime.now());
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

	   public com.servinglynk.hmis.warehouse.model.v2015.Domesticviolence createDomesticViolence(com.servinglynk.hmis.warehouse.model.v2015.Domesticviolence domesticViolence){
	       domesticViolence.setId(UUID.randomUUID());
	       insert(domesticViolence);
	       return domesticViolence;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2015.Domesticviolence updateDomesticViolence(com.servinglynk.hmis.warehouse.model.v2015.Domesticviolence domesticViolence){
	       update(domesticViolence);
	       return domesticViolence;
	   }
	   public void deleteDomesticViolence(com.servinglynk.hmis.warehouse.model.v2015.Domesticviolence domesticViolence){
	       delete(domesticViolence);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2015.Domesticviolence getDomesticViolenceById(UUID domesticViolenceId){
	       return (com.servinglynk.hmis.warehouse.model.v2015.Domesticviolence) get(com.servinglynk.hmis.warehouse.model.v2015.Domesticviolence.class, domesticViolenceId);
	   }
	   public List<com.servinglynk.hmis.warehouse.model.v2015.Domesticviolence> getAllEnrollmentDomesticViolences(UUID enrollmentId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Domesticviolence.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2015.Domesticviolence>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getEnrollmentDomesticViolencesCount(UUID enrollmentId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Domesticviolence.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return countRows(criteria);
	   }

}
