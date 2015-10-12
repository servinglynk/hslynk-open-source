/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.apache.hadoop.hbase.thrift2.generated.THBaseService.Iface;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Inventory;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.InventoryAvailabiltyEnum;
import com.servinglynk.hmis.warehouse.model.staging.Bedinventory;
import com.servinglynk.hmis.warehouse.model.staging.Export;
import com.servinglynk.hmis.warehouse.model.staging.Projectcoc;
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
		if(inventories != null && !inventories.isEmpty())
		{
			for(Inventory inventory : inventories)
			{
				
				UUID id = UUID.randomUUID();
				parentDaoFactory.getBedinventoryDao().hydrateBedInventory(domain,inventory);
				com.servinglynk.hmis.warehouse.model.staging.Inventory inventoryModel = new com.servinglynk.hmis.warehouse.model.staging.Inventory();
				inventoryModel.setId(id);
				inventoryModel.setDateCreated(BasicDataGenerator.getLocalDateTime(inventory.getDateCreated()));
				inventoryModel.setDateUpdated(BasicDataGenerator.getLocalDateTime(inventory.getDateUpdated()));
				inventoryModel.setAvailabilty(InventoryAvailabiltyEnum.lookupEnum(BasicDataGenerator.getStringValue(inventory.getAvailabilty())));
				Bedinventory bedInventory = (Bedinventory) get(Bedinventory.class, domain.getBedInventoryMap().get(String.valueOf(inventory.getBedInventory().getBedInventory())));
				inventoryModel.setBedinventory(bedInventory);
				Projectcoc projectCocModel = (Projectcoc) get(Projectcoc.class, domain.getProjectCocMap().get(String.valueOf(inventory.getProjectCoCID())));
				inventoryModel.setProjectCoc(projectCocModel);
				com.servinglynk.hmis.warehouse.model.staging.Export exportEntity = (com.servinglynk.hmis.warehouse.model.staging.Export) get(com.servinglynk.hmis.warehouse.model.staging.Export.class, domain.getExportId());
				inventoryModel.setExport(exportEntity);
				exportEntity.addInventory(inventoryModel);
				insertOrUpdate(inventoryModel);
			}
		}
	}
	@Override
	public void hydrateLive(Export export) {
		Set<com.servinglynk.hmis.warehouse.model.staging.Inventory> inventories = export.getInventories();
		if(inventories != null && !inventories.isEmpty()) {
			for(com.servinglynk.hmis.warehouse.model.staging.Inventory inventory : inventories) {
				if(inventory !=null) {
					com.servinglynk.hmis.warehouse.model.live.Inventory target = new com.servinglynk.hmis.warehouse.model.live.Inventory();
					BeanUtils.copyProperties(inventory, target,getNonCollectionFields(target));
					com.servinglynk.hmis.warehouse.model.live.Bedinventory bedInventory = (com.servinglynk.hmis.warehouse.model.live.Bedinventory) get(com.servinglynk.hmis.warehouse.model.live.Bedinventory.class, inventory.getId());
					target.setBedinventory(bedInventory);
					com.servinglynk.hmis.warehouse.model.live.Projectcoc projectCocModel = (com.servinglynk.hmis.warehouse.model.live.Projectcoc) get(com.servinglynk.hmis.warehouse.model.live.Projectcoc.class,inventory.getProjectCoc().getId() );
					target.setProjectCoc(projectCocModel);
					com.servinglynk.hmis.warehouse.model.live.Export exportEntity = (com.servinglynk.hmis.warehouse.model.live.Export) get(com.servinglynk.hmis.warehouse.model.live.Export.class, inventory.getExport().getId());
					target.setExport(exportEntity);
					exportEntity.addInventory(target);
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
