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
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Inventory;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.InventoryAvailabiltyEnum;
import com.servinglynk.hmis.warehouse.model.stagv2014.Bedinventory;
import com.servinglynk.hmis.warehouse.model.stagv2014.Export;
import com.servinglynk.hmis.warehouse.model.stagv2014.Projectcoc;
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
		if(inventories != null && !inventories.isEmpty())
		{
			for(Inventory inventory : inventories)
			{
				
				UUID id = UUID.randomUUID();
				parentDaoFactory.getBedinventoryDao().hydrateBedInventory(domain,inventory);
				com.servinglynk.hmis.warehouse.model.stagv2014.Inventory inventoryModel = new com.servinglynk.hmis.warehouse.model.stagv2014.Inventory();
				inventoryModel.setId(id);
				inventoryModel.setDateCreated(BasicDataGenerator.getLocalDateTime(inventory.getDateCreated()));
				inventoryModel.setDateUpdated(BasicDataGenerator.getLocalDateTime(inventory.getDateUpdated()));
				inventoryModel.setAvailabilty(InventoryAvailabiltyEnum.lookupEnum(BasicDataGenerator.getStringValue(inventory.getAvailabilty())));
				Bedinventory bedInventory = (Bedinventory) get(Bedinventory.class, domain.getBedInventoryMap().get(String.valueOf(inventory.getBedInventory().getBedInventory())));
				inventoryModel.setBedinventory(bedInventory);
				Projectcoc projectCocModel = (Projectcoc) get(Projectcoc.class, domain.getProjectCocMap().get(String.valueOf(inventory.getProjectCoCID())));
				inventoryModel.setProjectCoc(projectCocModel);
				com.servinglynk.hmis.warehouse.model.stagv2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.stagv2014.Export) get(com.servinglynk.hmis.warehouse.model.stagv2014.Export.class, domain.getExportId());
				inventoryModel.setExport(exportEntity);
				exportEntity.addInventory(inventoryModel);
				insertOrUpdate(inventoryModel);
			}
		}
	}
	@Override
	public void hydrateLive(Export export, Long id) {
		Set<com.servinglynk.hmis.warehouse.model.stagv2014.Inventory> inventories = export.getInventories();
		hydrateBulkUploadActivity(inventories, com.servinglynk.hmis.warehouse.model.v2014.Inventory.class.getSimpleName(), export,id);
		if(inventories != null && !inventories.isEmpty()) {
			for(com.servinglynk.hmis.warehouse.model.stagv2014.Inventory inventory : inventories) {
				if(inventory !=null) {
					com.servinglynk.hmis.warehouse.model.v2014.Inventory target = new com.servinglynk.hmis.warehouse.model.v2014.Inventory();
					BeanUtils.copyProperties(inventory, target,getNonCollectionFields(target));
					com.servinglynk.hmis.warehouse.model.v2014.Bedinventory bedInventory = (com.servinglynk.hmis.warehouse.model.v2014.Bedinventory) get(com.servinglynk.hmis.warehouse.model.v2014.Bedinventory.class, inventory.getId());
					target.setBedinventory(bedInventory);
					com.servinglynk.hmis.warehouse.model.v2014.Projectcoc projectCocModel = (com.servinglynk.hmis.warehouse.model.v2014.Projectcoc) get(com.servinglynk.hmis.warehouse.model.v2014.Projectcoc.class,inventory.getProjectCoc().getId() );
					target.setProjectCoc(projectCocModel);
					com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) get(com.servinglynk.hmis.warehouse.model.v2014.Export.class, inventory.getExport().getId());
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
