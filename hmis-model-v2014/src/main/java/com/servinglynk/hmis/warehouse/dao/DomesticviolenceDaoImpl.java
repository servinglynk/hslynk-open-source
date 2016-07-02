package com.servinglynk.hmis.warehouse.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.DomesticViolence;
import com.servinglynk.hmis.warehouse.enums.DomesticviolenceDomesticviolencevictimEnum;
import com.servinglynk.hmis.warehouse.enums.DomesticviolenceWhenoccurredEnum;
import com.servinglynk.hmis.warehouse.model.v2014.Domesticviolence;
import com.servinglynk.hmis.warehouse.model.v2014.Enrollment;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

public class DomesticviolenceDaoImpl extends ParentDaoImpl implements
		DomesticviolenceDao {
	private static final Logger logger = LoggerFactory
			.getLogger(EnrollmentDaoImpl.class);
	@Override
	public void hydrateStaging(ExportDomain domain) {
		
		java.util.List<DomesticViolence> domesticViolenceList = domain.getExport().getDomesticViolence();
		hydrateBulkUploadActivityStaging(domesticViolenceList, com.servinglynk.hmis.warehouse.model.v2014.Domesticviolence.class.getSimpleName(), domain);
		int i=0;
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) get(com.servinglynk.hmis.warehouse.model.v2014.Export.class, domain.getExportId());
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
				if(StringUtils.isNotBlank(domesticViolence.getProjectEntryID())) {
					UUID id = domain.getEnrollmentProjectEntryIDMap().get(domesticViolence.getProjectEntryID());
					if(id != null) {
						Enrollment enrollmentModel = (Enrollment) get(Enrollment.class,id);
						domesticviolenceModel.setEnrollmentid(enrollmentModel);
					}else {
						logger.warn("EnrollmentCoc : A match was not found for Project EntryID:{}",domesticViolence.getProjectEntryID());
					}
				}
				domesticviolenceModel.setExport(exportEntity);
				exportEntity.addDomesticviolence(domesticviolenceModel);
				i++;
				hydrateCommonFields(domesticviolenceModel, domain, domesticViolence.getDomesticViolenceID(),i);
			}
		}

	}

	   public com.servinglynk.hmis.warehouse.model.v2014.Domesticviolence createDomesticViolence(com.servinglynk.hmis.warehouse.model.v2014.Domesticviolence domesticViolence){
	       domesticViolence.setId(UUID.randomUUID()); 
	       insert(domesticViolence);
	       return domesticViolence;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Domesticviolence updateDomesticViolence(com.servinglynk.hmis.warehouse.model.v2014.Domesticviolence domesticViolence){
	       update(domesticViolence);
	       return domesticViolence;
	   }
	   public void deleteDomesticViolence(com.servinglynk.hmis.warehouse.model.v2014.Domesticviolence domesticViolence){
	       delete(domesticViolence);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Domesticviolence getDomesticViolenceById(UUID domesticViolenceId){ 
	       return (com.servinglynk.hmis.warehouse.model.v2014.Domesticviolence) get(com.servinglynk.hmis.warehouse.model.v2014.Domesticviolence.class, domesticViolenceId);
	   }
	   public List<com.servinglynk.hmis.warehouse.model.v2014.Domesticviolence> getAllEnrollmentDomesticViolences(UUID enrollmentId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Domesticviolence.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2014.Domesticviolence>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getEnrollmentDomesticViolencesCount(UUID enrollmentId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Domesticviolence.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return countRows(criteria);
	   }
	
}
