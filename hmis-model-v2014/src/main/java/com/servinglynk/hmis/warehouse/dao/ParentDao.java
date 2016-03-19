package com.servinglynk.hmis.warehouse.dao;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.model.stagv2014.Export;


public interface ParentDao extends QueryExecutor{
	public void hydrateStaging(ExportDomain domain);
	public void hydrateLive(Export export);
	public void hydrateHBASE(SyncDomain syncDomain);
}
