package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

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
			.getLogger(DomesticviolenceDaoImpl.class);
	@Override
	public void hydrateStaging(ExportDomain domain) throws Exception {
		
		java.util.List<DomesticViolence> domesticViolenceList = domain.getExport().getDomesticViolence();
		Long i=new Long(0L);
		Data data=new Data();
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) getModel(com.servinglynk.hmis.warehouse.model.v2014.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain));
		if(domesticViolenceList!=null && !domesticViolenceList.isEmpty())
		{
			for(DomesticViolence domesticViolence : domesticViolenceList)
			{
				try {
					Domesticviolence domesticviolenceModel = getModelObject(domain, domesticViolence,data);
					domesticviolenceModel.setDomesticviolencevictim(DomesticviolenceDomesticviolencevictimEnum.lookupEnum(BasicDataGenerator.getStringValue(domesticViolence.getDomesticViolenceVictim())));
					domesticviolenceModel.setWhenoccurred(DomesticviolenceWhenoccurredEnum.lookupEnum(BasicDataGenerator.getStringValue(domesticViolence.getWhenOccurred())));
					domesticviolenceModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(domesticViolence.getDateCreated()));
					domesticviolenceModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(domesticViolence.getDateUpdated()));
					Enrollment enrollmentModel = (Enrollment) getModel(Enrollment.class,domesticViolence.getProjectEntryID(),getProjectGroupCode(domain));;
					domesticviolenceModel.setEnrollmentid(enrollmentModel);
					domesticviolenceModel.setExport(exportEntity);
					if(exportEntity !=null)
						exportEntity.addDomesticviolence(domesticviolenceModel);
					performSaveOrUpdate(domesticviolenceModel);
				}catch (Exception e) {
					logger.error("Exception in:"+domesticViolence.getProjectEntryID()+  ":: Exception" +e.getLocalizedMessage());
					throw new Exception(e);
				}
				
			}
		}

	}
	
	public com.servinglynk.hmis.warehouse.model.v2014.Domesticviolence getModelObject(ExportDomain domain, DomesticViolence domesticViolence ,Data data) {
		com.servinglynk.hmis.warehouse.model.v2014.Domesticviolence domesticViolenceModel = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			domesticViolenceModel = (com.servinglynk.hmis.warehouse.model.v2014.Domesticviolence) getModel(com.servinglynk.hmis.warehouse.model.v2014.Domesticviolence.class, domesticViolence.getDomesticViolenceID(), getProjectGroupCode(domain));
		
		if(domesticViolenceModel == null) {
			domesticViolenceModel = new com.servinglynk.hmis.warehouse.model.v2014.Domesticviolence();
			domesticViolenceModel.setId(UUID.randomUUID());
			domesticViolenceModel.setInserted(true);
			++data.i;
		}else{
			++data.j;
		}
		hydrateCommonFields(domesticViolenceModel, domain,domesticViolence.getDomesticViolenceID(),data.i+data.j);
		return domesticViolenceModel;
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
