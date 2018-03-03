package com.servinglynk.hmis.warehouse.base.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.servinglynk.hmis.warehouse.model.base.PropertyEntity;

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
	
	public PropertyEntity readConsentProperty(){
		DetachedCriteria criteria = DetachedCriteria.forClass(PropertyEntity.class);
		criteria.add(Restrictions.eq("keyName","consentCheck"));
		List<PropertyEntity> entities = (List<PropertyEntity>) findByCriteria(criteria);
		if(!entities.isEmpty()) return entities.get(0);
		return null;
	}

}
