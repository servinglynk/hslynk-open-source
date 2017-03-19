package com.servinglynk.hmis.warehouse.base.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.servinglynk.hmis.warehouse.model.base.ApiGroupEntity;
import com.servinglynk.hmis.warehouse.model.base.ApiMethodEntity;
import com.servinglynk.hmis.warehouse.model.base.ServiceApiMethodEntity;

public class ApiMethodDaoImpl extends QueryExecutorImpl implements
		ApiMethodDao {

	
	
	@SuppressWarnings("unchecked")
	public ApiMethodEntity findByExternalId(String apiId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(ApiMethodEntity.class);
		criteria.add(Restrictions.eq("externalId",apiId));
		 List<ApiMethodEntity> apiMethodEntities =  (List<ApiMethodEntity>) findByCriteria(criteria);
		 if(apiMethodEntities.size()>0) return apiMethodEntities.get(0);
		 return null;
	}
	
	
	public ApiGroupEntity getApiGroup(){
			return (ApiGroupEntity)get(ApiGroupEntity.class,new Long(1));
	}

	
	public ApiMethodEntity createApiMethod(ApiMethodEntity apiMethodEntity){
		insert(apiMethodEntity);
		return apiMethodEntity;
	}
	
	
	
	public ServiceApiMethodEntity createMapServiceWithApi(ServiceApiMethodEntity serviceApiMethodEntity){
		insert(serviceApiMethodEntity);
		return serviceApiMethodEntity;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<ApiGroupEntity> getApiMethods(){
		DetachedCriteria criteria =DetachedCriteria.forClass(ApiGroupEntity.class);
		
		return (List<ApiGroupEntity>) findByCriteria(criteria);
	}

}
