package com.servinglynk.hmis.warehouse.dao;

import com.servinglynk.hmis.warehouse.base.dao.BaseDao;
import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.model.v2015.Export;


public interface ParentDao extends BaseDao{
	public void hydrateStaging(ExportDomain domain);
	public void hydrateLive(Export export,Long id);
	public void hydrateHBASE(SyncDomain syncDomain);
}
