package com.servinglynk.hmis.warehouse.dao;

import com.servinglynk.hmis.warehouse.base.dao.BaseDao;
import com.servinglynk.hmis.warehouse.domain.ExportDomain;


public interface ParentDao extends BaseDao{
	public void hydrateStaging(ExportDomain domain) throws Exception;
}
