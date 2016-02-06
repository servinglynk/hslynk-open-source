package com.servinglynk.hmis.warehouse.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.servinglynk.hmis.warehouse.model.live.PropertyEntity;

public class PropertyDaoImpl extends QueryExecutorImpl implements PropertyDao {


	@SuppressWarnings("unchecked")
	public List<PropertyEntity> readProperties(String serviceName) {
		DetachedCriteria criteria = DetachedCriteria.forClass(PropertyEntity.class);
		criteria.add(Restrictions.eq("service", serviceName));
		return (List<PropertyEntity>) findByCriteria(criteria);
	}
	
	@SuppressWarnings("unchecked")
	public List<PropertyEntity> readCommonProperties() {
		DetachedCriteria criteria = DetachedCriteria.forClass(PropertyEntity.class);
		criteria.add(Restrictions.eq("service", "COMMON"));
		return (List<PropertyEntity>) findByCriteria(criteria);
	}

}
