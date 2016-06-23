/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Inventory;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Inventory.BedInventory;
import com.servinglynk.hmis.warehouse.enums.BedinventoryYouthAgeGroupEnum;
import com.servinglynk.hmis.warehouse.enums.InventoryAvailabiltyEnum;
import com.servinglynk.hmis.warehouse.model.v2014.Projectcoc;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class InventoryDaoImpl extends ParentDaoImpl implements InventoryDao {

	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Autowired
	private ParentDaoFactory parentDaoFactory;
	@Override
	public void hydrateStaging(ExportDomain domain) {
		List<Inventory> inventories = domain.getExport().getInventory();
		hydrateBulkUploadActivityStaging(inventories, com.servinglynk.hmis.warehouse.model.v2014.Inventory.class.getSimpleName(), domain);
		int i=0;
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) get(com.servinglynk.hmis.warehouse.model.v2014.Export.class, domain.getExportId());
		if(inventories != null && !inventories.isEmpty())
		{
			for(Inventory inventory : inventories)
			{
				
				UUID id = UUID.randomUUID();
				com.servinglynk.hmis.warehouse.model.v2014.Inventory inventoryModel = new com.servinglynk.hmis.warehouse.model.v2014.Inventory();
				inventoryModel.setId(id);
				inventoryModel.setDateCreated(BasicDataGenerator.getLocalDateTime(inventory.getDateCreated()));
				inventoryModel.setDateUpdated(BasicDataGenerator.getLocalDateTime(inventory.getDateUpdated()));
				inventoryModel.setAvailabilty(InventoryAvailabiltyEnum.lookupEnum(BasicDataGenerator.getStringValue(inventory.getAvailabilty())));
				BedInventory bedInventory = inventory.getBedInventory();
				if(bedInventory !=null) {
					inventoryModel.setBedInventory(new Integer(bedInventory.getBedInventory()));
					inventoryModel.setChBedInventory(new Integer(bedInventory.getCHBedInventory()));
					inventoryModel.setVetBedInventory(new Integer(bedInventory.getVetBedInventory()));
					inventoryModel.setYouthAgeGroup(BedinventoryYouthAgeGroupEnum.lookupEnum(BasicDataGenerator.getStringValue(bedInventory.getYouthAgeGroup())));
					inventoryModel.setYouthBedInventory(new Long(bedInventory.getYouthBedInventory()));
				}
				Projectcoc projectCocModel = (Projectcoc) get(Projectcoc.class, domain.getProjectCocMap().get(String.valueOf(inventory.getProjectCoCID())));
				inventoryModel.setProjectCoc(projectCocModel);
				inventoryModel.setExport(exportEntity);
				exportEntity.addInventory(inventoryModel);
				i++;
				hydrateCommonFields(inventoryModel, domain, inventory.getInventoryID(), i);
			}
		}
	}
	   public com.servinglynk.hmis.warehouse.model.v2014.Inventory createInventory(com.servinglynk.hmis.warehouse.model.v2014.Inventory inventory){
	       inventory.setId(UUID.randomUUID()); 
	       insert(inventory);
	       return inventory;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Inventory updateInventory(com.servinglynk.hmis.warehouse.model.v2014.Inventory inventory){
	       update(inventory);
	       return inventory;
	   }
	   public void deleteInventory(com.servinglynk.hmis.warehouse.model.v2014.Inventory inventory){
	       delete(inventory);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Inventory getInventoryById(UUID inventoryId){ 
	       return (com.servinglynk.hmis.warehouse.model.v2014.Inventory) get(com.servinglynk.hmis.warehouse.model.v2014.Inventory.class, inventoryId);
	   }																
	   public List<com.servinglynk.hmis.warehouse.model.v2014.Inventory> getAllProjectCocInventories(UUID projectCocId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Inventory.class);
	       criteria.createAlias("projectCoc", "projectCoc");
	       criteria.add(Restrictions.eq("projectCoc.id", projectCocId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2014.Inventory>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getProjectCocInventoriesCount(UUID projectCocId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Inventory.class);
	       criteria.createAlias("projectCoc", "projectCoc");
	       criteria.add(Restrictions.eq("projectCoc.id", projectCocId));
	       return countRows(criteria);
	   }

}
