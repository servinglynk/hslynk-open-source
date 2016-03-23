package com.servinglynk.hmis.warehouse.base.dao;


import java.util.List;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.servinglynk.hmis.warehouse.model.base.DeveloperServiceEntity;

public class DeveloperServiceDaoImpl extends QueryExecutorImpl implements DeveloperServiceDao {


	@SuppressWarnings("unchecked")
	public DeveloperServiceEntity findByFriendlyName(String friendlyName){
		
		DetachedCriteria criteria = DetachedCriteria.forClass(DeveloperServiceEntity.class);
		criteria.add(Restrictions.eq("friendlyName",friendlyName));
		List<DeveloperServiceEntity> services=(List<DeveloperServiceEntity>) findByCriteria(criteria);
		if(services.size()>0) return services.get(0);
		return null;
		
	}
	
	
	public DeveloperServiceEntity create(DeveloperServiceEntity service){
		insert(service);
		return service;
	}
	
	
	public DeveloperServiceEntity updateService(DeveloperServiceEntity service){
		update(service);
		return service;
	}
	
	
	public DeveloperServiceEntity findByExternalId(String externalServiceId){

		DetachedCriteria criteria = DetachedCriteria.forClass(DeveloperServiceEntity.class);
		criteria.add(Restrictions.eq("externalId",externalServiceId));
		
		List<DeveloperServiceEntity> developerServiceEntities = (List<DeveloperServiceEntity>)findByCriteria(criteria);
		if(developerServiceEntities.size()>0) return developerServiceEntities.get(0);
		return null;
	}
	
	
	public void deleteService(DeveloperServiceEntity service){
		delete(service);
	}


	@SuppressWarnings("unchecked")
	public List<DeveloperServiceEntity> findByDeveloperCompanyId(UUID id, int startIndex,
			int maxItems) {
		DetachedCriteria criteria = DetachedCriteria.forClass(DeveloperServiceEntity.class);
		criteria.createAlias("developerCompany", "developerCompany");
		criteria.add(Restrictions.eq("developerCompany.id",id));
		
		
		return (List<DeveloperServiceEntity>) findByCriteria(criteria,startIndex,maxItems);
	}


	public int findCountByDeveloperCompanyId(UUID id) {
		DetachedCriteria criteria = DetachedCriteria.forClass(DeveloperServiceEntity.class);
		criteria.createAlias("developerCompany", "developerCompany");
		criteria.add(Restrictions.eq("developerCompany.id",id));
		
		return (findByCriteria(criteria)).size();
	}
	
}
