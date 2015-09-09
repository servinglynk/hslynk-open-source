package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.servinglynk.hmis.warehouse.entity.ServiceApiMethodEntity;
import com.servinglynk.hmis.warehouse.entity.ServiceLicenseEntity;


public class ServiceApiMethodDaoImpl extends QueryExecutorImpl
		implements ServiceApiMethodDao {

	
	

	@SuppressWarnings("unchecked")
	public int deleteByServiceId(UUID serviceId) {
		
		DetachedCriteria criteria = DetachedCriteria.forClass(ServiceLicenseEntity.class);
		criteria.createAlias("service","service");
		criteria.add(Restrictions.eq("service.id",serviceId));
		List<ServiceLicenseEntity> serviceLicenses =(List<ServiceLicenseEntity>) findByCriteria(criteria);
		for(ServiceLicenseEntity serviceLicense : serviceLicenses){
			delete(serviceLicense);
		}
		return serviceLicenses.size();
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
