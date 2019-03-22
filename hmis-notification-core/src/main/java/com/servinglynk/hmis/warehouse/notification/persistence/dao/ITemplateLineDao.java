package com.servinglynk.hmis.warehouse.notification.persistence.dao;

import java.util.List;

import com.servinglynk.hmis.warehouse.notification.persistence.dao.core.IParentDao;
import com.servinglynk.hmis.warehouse.notification.persistence.entity.TemplateHeaderEntity;
import com.servinglynk.hmis.warehouse.notification.persistence.entity.TemplateLineEntity;

public interface ITemplateLineDao extends IParentDao{
	
	public List<TemplateLineEntity> findTemplate(String externalId,Integer version);
	public TemplateHeaderEntity findTemplateHeader(String externalId);

}
