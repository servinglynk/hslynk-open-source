package com.servinglynk.hmis.warehouse.dao;

import java.util.Map;

import com.servinglynk.hmis.warehouse.base.dao.BaseDao;
import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.model.v2014.HmisBaseModel;


public interface ParentDao extends BaseDao{
	public void hydrateStaging(ExportDomain domain,Map<String, HmisBaseModel> exportModelMap,Map<String,HmisBaseModel> relatedModelMap) throws Exception;
}
