package com.servinglynk.hmis.warehouse.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.apache.hadoop.hbase.thrift2.generated.THBaseService.Iface;
import org.springframework.beans.BeanUtils;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Inventory;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Inventory.BedInventory;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.BedinventoryYouthAgeGroupEnum;
import com.servinglynk.hmis.warehouse.model.stagv2015.Bedinventory;
import com.servinglynk.hmis.warehouse.model.stagv2015.Export;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

	public class BedinventoryDaoImpl  extends ParentDaoImpl  implements BedinventoryDao {
		
		@Override
		public void hydrateStaging(ExportDomain domain) {
			throw new UnsupportedOperationException();
		}
		@Override
		public void hydrateBedInventory(ExportDomain domain, Inventory inventory) {
			BedInventory bedInventory = inventory.getBedInventory();
			Bedinventory bedInventoryModel = new Bedinventory();
			bedInventoryModel.setBedInventory(new Integer(bedInventory.getBedInventory()));
			bedInventoryModel.setChBedInventory(new Integer(bedInventory.getCHBedInventory()));
			bedInventoryModel.setVetBedInventory(new Integer(bedInventory.getVetBedInventory()));
			bedInventoryModel.setYouthAgeGroup(BedinventoryYouthAgeGroupEnum.lookupEnum(BasicDataGenerator.getStringValue(bedInventory.getYouthAgeGroup())));
			bedInventoryModel.setYouthBedInventory(new Long(bedInventory.getYouthBedInventory()));
			com.servinglynk.hmis.warehouse.model.stagv2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.stagv2015.Export) get(com.servinglynk.hmis.warehouse.model.stagv2015.Export.class, domain.getExportId());
			bedInventoryModel.setExport(exportEntity);
			UUID bedInventoryId = UUID.randomUUID();
			bedInventoryModel.setId(bedInventoryId);
			domain.getBedInventoryMap().put(String.valueOf(bedInventory.getBedInventory()), bedInventoryId);
			exportEntity.addBedinventory(bedInventoryModel);
			insertOrUpdate(bedInventoryModel);
		}
		@Override
		public void hydrateLive(Export export,Long id) {
			Set<Bedinventory> bedinventories = export.getBedinventories();
			if(bedinventories !=null && !bedinventories.isEmpty()) {
				for(Bedinventory bedInventory : bedinventories) {
					com.servinglynk.hmis.warehouse.model.v2015.Bedinventory target = new com.servinglynk.hmis.warehouse.model.v2015.Bedinventory();
					BeanUtils.copyProperties(bedInventory, target,getNonCollectionFields(target));
					 target.setDateCreated(LocalDateTime.now());
					 target.setDateUpdated(LocalDateTime.now());
					insert(target);
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
