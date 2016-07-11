package com.servinglynk.hmis.warehouse.dao;

import com.servinglynk.hmis.warehouse.base.dao.BaseDao;
import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;


public interface ParentDao extends BaseDao{
	public void hydrateStaging(ExportDomain domain) throws Exception ;
	public void hydrateHBASE(SyncDomain syncDomain);
}
