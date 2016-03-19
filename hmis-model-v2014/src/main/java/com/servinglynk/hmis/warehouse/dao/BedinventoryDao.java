package com.servinglynk.hmis.warehouse.dao;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Inventory;

public interface BedinventoryDao extends ParentDao {
	void hydrateBedInventory(ExportDomain domain,Inventory inventory);
}
