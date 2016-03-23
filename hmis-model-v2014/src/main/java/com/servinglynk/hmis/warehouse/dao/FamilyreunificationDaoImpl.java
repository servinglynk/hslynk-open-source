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
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.FamilyReunification;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.FamilyreunificationFamilyreunificationachievedEnum;
import com.servinglynk.hmis.warehouse.model.stagv2014.Exit;
import com.servinglynk.hmis.warehouse.model.stagv2014.Export;
import com.servinglynk.hmis.warehouse.model.stagv2014.Familyreunification;
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
				com.servinglynk.hmis.warehouse.model.stagv2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.stagv2014.Export) get(com.servinglynk.hmis.warehouse.model.stagv2014.Export.class, domain.getExportId());
				familyreunificationModel.setExport(exportEntity);
				exportEntity.addFamilyreunification(familyreunificationModel);
				hydrateCommonFields(familyreunificationModel, domain);
				insertOrUpdate(familyreunificationModel);
			}
		}
	}

	@Override
	public void hydrateLive(Export export) {
		Set<Familyreunification> familyreunifications = export.getFamilyreunifications();
		if(familyreunifications !=null && !familyreunifications.isEmpty()) {
			for(Familyreunification familyreunification : familyreunifications) {
				if(familyreunification != null) {
					com.servinglynk.hmis.warehouse.model.v2014.Familyreunification target = new com.servinglynk.hmis.warehouse.model.v2014.Familyreunification();
					BeanUtils.copyProperties(familyreunification, target,getNonCollectionFields(target));
					com.servinglynk.hmis.warehouse.model.v2014.Exit exitModel = (com.servinglynk.hmis.warehouse.model.v2014.Exit) get(com.servinglynk.hmis.warehouse.model.v2014.Exit.class, familyreunification.getExitid().getId());
					target.setExitid(exitModel);
					com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) get(com.servinglynk.hmis.warehouse.model.v2014.Export.class, export.getId());
					target.setExport(exportEntity);
					exportEntity.addFamilyreunification(target);
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
