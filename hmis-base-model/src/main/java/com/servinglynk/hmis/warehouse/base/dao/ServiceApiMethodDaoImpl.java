package com.servinglynk.hmis.warehouse.base.dao;

import java.util.List;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.servinglynk.hmis.warehouse.model.base.ServiceApiMethodEntity;


public class ServiceApiMethodDaoImpl extends QueryExecutorImpl
		implements ServiceApiMethodDao {

	
	
	public int deleteApiMethodsByServiceId(UUID serviceId) {
		
		DetachedCriteria criteria = DetachedCriteria.forClass(ServiceApiMethodEntity.class);
		criteria.createAlias("service","service");
		criteria.add(Restrictions.eq("service.id",serviceId));
		List<ServiceApiMethodEntity> serviceApiMethods =(List<ServiceApiMethodEntity>) findByCriteria(criteria);
		for(ServiceApiMethodEntity serviceApiMethod : serviceApiMethods){
			delete(serviceApiMethod);
		}
		return serviceApiMethods.size();
	}


	public ServiceApiMethodEntity create(ServiceApiMethodEntity serviceApiMethod) {
		insert(serviceApiMethod);
		return serviceApiMethod;
	}


	@SuppressWarnings("unchecked")
	public ServiceApiMethodEntity findByServiceIdAndApiMethodId(UUID serviceId,
			UUID apiMethodId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(ServiceApiMethodEntity.class);
		criteria.createAlias("apiMethod", "apiMethod");
		criteria.createAlias("service", "service");
		
		criteria.add(Restrictions.eq("service.id", serviceId));
		criteria.add(Restrictions.eq("apiMethod.id", apiMethodId));
		
		List<ServiceApiMethodEntity> serviceApiMethods = (List<ServiceApiMethodEntity>)findByCriteria(criteria);
		if(serviceApiMethods.size()>0) return serviceApiMethods.get(0);
		return null;
	}

}
