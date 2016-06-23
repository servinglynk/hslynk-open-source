/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.FamilyReunification;
import com.servinglynk.hmis.warehouse.enums.FamilyreunificationFamilyreunificationachievedEnum;
import com.servinglynk.hmis.warehouse.model.v2014.Exit;
import com.servinglynk.hmis.warehouse.model.v2014.Familyreunification;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class FamilyreunificationDaoImpl extends ParentDaoImpl implements
		FamilyreunificationDao {

	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain) {
		List<FamilyReunification> familyReunifications = domain.getExport().getFamilyReunification();
		hydrateBulkUploadActivityStaging(familyReunifications, com.servinglynk.hmis.warehouse.model.v2014.Familyreunification.class.getSimpleName(), domain);
		int i=0;
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) get(com.servinglynk.hmis.warehouse.model.v2014.Export.class, domain.getExportId());
		if(familyReunifications!=null && familyReunifications.size() >0 ) 
		{
			for(FamilyReunification familyReunification : familyReunifications)
			{
				Familyreunification familyreunificationModel = new Familyreunification();
				familyreunificationModel.setId(UUID.randomUUID());

				familyreunificationModel.setDateCreated(LocalDateTime.now());
				familyreunificationModel.setDateUpdated(LocalDateTime.now());
				familyreunificationModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(familyReunification.getDateCreated()));
				familyreunificationModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(familyReunification.getDateUpdated()));
				familyreunificationModel.setFamilyreunificationachieved(FamilyreunificationFamilyreunificationachievedEnum.lookupEnum(BasicDataGenerator.getStringValue(familyReunification.getFamilyReunificationAchieved())));
				Exit exit = (Exit) get(Exit.class, domain.getExitMap().get(familyReunification.getExitID()));
				familyreunificationModel.setExitid(exit);
				familyreunificationModel.setExport(exportEntity);
				exportEntity.addFamilyreunification(familyreunificationModel);
				i++;
				hydrateCommonFields(familyreunificationModel, domain, familyReunification.getFamilyReunificationID(),i);
			}
		}
	}

	   public com.servinglynk.hmis.warehouse.model.v2014.Familyreunification createFamilyReunification(com.servinglynk.hmis.warehouse.model.v2014.Familyreunification familyReunification){
	       familyReunification.setId(UUID.randomUUID()); 
	       insert(familyReunification);
	       return familyReunification;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Familyreunification updateFamilyReunification(com.servinglynk.hmis.warehouse.model.v2014.Familyreunification familyReunification){
	       update(familyReunification);
	       return familyReunification;
	   }
	   public void deleteFamilyReunification(com.servinglynk.hmis.warehouse.model.v2014.Familyreunification familyReunification){
	       delete(familyReunification);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Familyreunification getFamilyReunificationById(UUID familyReunificationId){ 
	       return (com.servinglynk.hmis.warehouse.model.v2014.Familyreunification) get(com.servinglynk.hmis.warehouse.model.v2014.Familyreunification.class, familyReunificationId);
	   }
	   
	   @SuppressWarnings("unchecked")
	   public List<com.servinglynk.hmis.warehouse.model.v2014.Familyreunification> getAllExitFamilyReunifications(UUID exitId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Familyreunification.class);
	       criteria.createAlias("exitid", "exitid");
	       criteria.add(Restrictions.eq("exitid.id", exitId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2014.Familyreunification>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getExitFamilyReunificationsCount(UUID exitId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Familyreunification.class);
	       criteria.createAlias("exitid", "exitid");
	       criteria.add(Restrictions.eq("exitid.id", exitId));
	       return countRows(criteria);
	   }
}
