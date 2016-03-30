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
import org.springframework.beans.factory.annotation.Autowired;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ExitRHY;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Inventory;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.InventoryAvailabiltyEnum;
import com.servinglynk.hmis.warehouse.enums.InventoryBedtypeEnum;
import com.servinglynk.hmis.warehouse.enums.InventoryHouseholdtypeEnum;
import com.servinglynk.hmis.warehouse.model.stagv2015.Bedinventory;
import com.servinglynk.hmis.warehouse.model.stagv2015.Export;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class InventoryDaoImpl extends ParentDaoImpl implements InventoryDao {

	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	/*@Autowired
	private ParentDaoFactory parentDaoFactory;*/

	@Override
	public void hydrateStaging(ExportDomain domain) {
		
	    com.servinglynk.hmis.warehouse.domain.Sources.Source.Export export = domain.getExport();
		List<Inventory> inventory = export.getInventory();
		if (inventory != null && inventory.size() > 0) {
			for (Inventory inventories : inventory) {
				com.servinglynk.hmis.warehouse.model.stagv2015.Inventory inventoryModel = new com.servinglynk.hmis.warehouse.model.stagv2015.Inventory();
				UUID inventoryUUID = UUID.randomUUID();
				inventoryModel.setId(inventoryUUID);
				inventoryModel.setAvailabilty(InventoryAvailabiltyEnum.lookupEnum(BasicDataGenerator.getStringValue(inventories.getAvailability())));
//				inventoryModel.setBedinventory(inventories.getBedInventory());
				inventoryModel.setBedtype(InventoryBedtypeEnum.lookupEnum(BasicDataGenerator.getStringValue(inventories.getBedType())));
				inventoryModel.setChBedInventory(inventories.getChBedInventory());
//				inventoryModel.setCoc(coc);
				inventoryModel.setHmisparticipatingbeds(inventories.getHMISParticipatingBeds() );
				inventoryModel.setHouseholdtype(InventoryHouseholdtypeEnum.lookupEnum(BasicDataGenerator.getStringValue(inventories.getHouseholdType())));
				inventoryModel.setInformationdate(BasicDataGenerator.getLocalDateTime(inventories.getInformationDate()));
				inventoryModel.setInventoryenddate(BasicDataGenerator.getLocalDateTime(inventories.getInventoryEndDate()));
				inventoryModel.setInventorystartdate(BasicDataGenerator.getLocalDateTime(inventories.getInventoryStartDate()));
				inventoryModel.setUnitinventory(inventories.getUnitInventory());
				inventoryModel.setVetBedInventory(inventories.getVetBedInventory());
				inventoryModel.setYouthAgeGroup(inventories.getYouthAgeGroup());
				inventoryModel.setYouthBedInventory(inventories.getYouthBedInventory());
				inventoryModel.setDeleted(false);
				inventoryModel.setDateCreated(LocalDateTime.now());
				inventoryModel.setDateUpdated(LocalDateTime.now());
				/*Enrollment enrollmentModel = (Enrollment) get(Enrollment.class, domain.getEnrollmentProjectEntryIDMap().get(entryRhsps.getEntryRHSPID()));
				entryRhspModel.setEnrollmentid(enrollmentModel);*/
				com.servinglynk.hmis.warehouse.model.stagv2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.stagv2015.Export) get(com.servinglynk.hmis.warehouse.model.stagv2015.Export.class, domain.getExportId());
				exportEntity.addInventory(inventoryModel);
				inventoryModel.setUserId(exportEntity.getUserId());
				inventoryModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(inventories.getDateCreated()));
				inventoryModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(inventories.getDateUpdated()));
				hydrateCommonFields(inventoryModel, domain);
				inventoryModel.setExport(exportEntity);
//				inventoryModel.setProjectGroupCode(inventories.getUserID());
				inventoryModel.setSync(false);
				insertOrUpdate(inventoryModel);
			}
		}
	
	}

	
	@Override
	public void hydrateLive(Export export) {
		Set<com.servinglynk.hmis.warehouse.model.stagv2015.Inventory> inventories = export.getInventories();
		if(inventories != null && !inventories.isEmpty()) {
			for(com.servinglynk.hmis.warehouse.model.stagv2015.Inventory inventory : inventories) {
				if(inventory !=null) {
					com.servinglynk.hmis.warehouse.model.v2015.Inventory target = new com.servinglynk.hmis.warehouse.model.v2015.Inventory();
					BeanUtils.copyProperties(inventory, target,getNonCollectionFields(target));
					com.servinglynk.hmis.warehouse.model.v2015.Bedinventory bedInventory = (com.servinglynk.hmis.warehouse.model.v2015.Bedinventory) get(com.servinglynk.hmis.warehouse.model.v2015.Bedinventory.class, inventory.getId());
					target.setBedinventory(bedInventory);
				//	com.servinglynk.hmis.warehouse.model.v2015.Projectcoc projectCocModel = (com.servinglynk.hmis.warehouse.model.v2015.Projectcoc) get(com.servinglynk.hmis.warehouse.model.v2015.Projectcoc.class,inventory.getProjectCoc().getId() );
				//	target.setProjectCoc(projectCocModel);
					com.servinglynk.hmis.warehouse.model.v2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2015.Export) get(com.servinglynk.hmis.warehouse.model.v2015.Export.class, inventory.getExport().getId());
					target.setExport(exportEntity);
					exportEntity.addInventory(target);
					target.setDateCreated(LocalDateTime.now());
					 target.setDateUpdated(LocalDateTime.now());
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
	@Override
	public com.servinglynk.hmis.warehouse.model.v2015.Inventory createInventory(com.servinglynk.hmis.warehouse.model.v2015.Inventory inventory) {
		inventory.setId(UUID.randomUUID());
			insert(inventory);
		return inventory;
	}


	@Override
	public com.servinglynk.hmis.warehouse.model.v2015.Inventory updateInventory(com.servinglynk.hmis.warehouse.model.v2015.Inventory inventory) {
			update(inventory);
		return inventory;
	}


	@Override
	public void deleteInventory(com.servinglynk.hmis.warehouse.model.v2015.Inventory inventory) {
			delete(inventory);
		
	}


	@SuppressWarnings("unchecked")
	@Override
	public com.servinglynk.hmis.warehouse.model.v2015.Inventory getInventoryById(UUID inventoryId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Inventory.class);
		criteria.add(Restrictions.eq("id", inventoryId));
		List<com.servinglynk.hmis.warehouse.model.v2015.Inventory> inventory = (List<com.servinglynk.hmis.warehouse.model.v2015.Inventory>) findByCriteria(criteria);
		if(inventory.size()>0) return inventory.get(0);
		return null;
	}
	@SuppressWarnings("unchecked")
	@Override
	public com.servinglynk.hmis.warehouse.model.v2015.Inventory getInventoryByDedupInventoryId(UUID id,String projectGroupCode) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Inventory.class);
		criteria.add(Restrictions.eq("dedupClientId", id));
		criteria.add(Restrictions.eq("projectGroupCode", projectGroupCode));
		List<com.servinglynk.hmis.warehouse.model.v2015.Inventory> inventory = (List<com.servinglynk.hmis.warehouse.model.v2015.Inventory>) findByCriteria(criteria);
		if(inventory !=null && inventory.size()>0) return inventory.get(0);
		return null;
	}
	/*public com.servinglynk.hmis.warehouse.model.stagv2015.Coc getCocByDedupCliendIdFromStaging(UUID id) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.stagv2015.Coc.class);
		criteria.add(Restrictions.eq("dedupClientId", id));
		List<com.servinglynk.hmis.warehouse.model.stagv2015.Coc> coc = (List<com.servinglynk.hmis.warehouse.model.stagv2015.Coc>) findByCriteria(criteria);
		if(coc !=null && coc.size()>0) return coc.get(0);
		return null;
	}*/

	@SuppressWarnings("unchecked")
	@Override
	public List<com.servinglynk.hmis.warehouse.model.v2015.Inventory> getAllInventories(Integer startIndex, Integer maxItems) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Inventory.class);	
		List<com.servinglynk.hmis.warehouse.model.v2015.Inventory> inventory = (List<com.servinglynk.hmis.warehouse.model.v2015.Inventory>) findByCriteria(criteria,startIndex,maxItems);
		return inventory;
	}
	
	@Override
	public long getIventoriesCount(){
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Exitrhy.class);	
		return countRows(criteria);
	}
	
	
	   
	  /* public List<com.servinglynk.hmis.warehouse.model.v2015.Inventory> getAllProjectCocInventories(UUID enrollmentId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Inventory.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2015.Inventory>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getProjectCocInventoriesCount(UUID enrollmentId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Inventory.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return countRows(criteria);
	   }*/

}
