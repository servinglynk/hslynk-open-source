package com.servinglynk.hmis.warehouse.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.servinglynk.hmis.warehouse.model.live.ServiceLicenseEntity;

public class ServiceLicenseDaoImpl extends QueryExecutorImpl implements
		ServiceLicenseDao {
	
	
	@SuppressWarnings("unchecked")
	public int deleteByServiceId(Long serviceId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(ServiceLicenseEntity.class);
		criteria.createAlias("service", "service");
		criteria.add(Restrictions.eq("service.id",serviceId));
		List<ServiceLicenseEntity>  serviceLicenses =(List<ServiceLicenseEntity>) findByCriteria(criteria);
		for(ServiceLicenseEntity serviceLicense : serviceLicenses)
		{
			delete(serviceLicense);
		}
		return serviceLicenses.size();
	}

}
