package com.servinglynk.hmis.warehouse.dao;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.model.staging.Export;


public interface ParentDao extends QueryExecutor{
	public void hydrateStaging(ExportDomain domain);
	public void hydrateLive(Export export);
}
