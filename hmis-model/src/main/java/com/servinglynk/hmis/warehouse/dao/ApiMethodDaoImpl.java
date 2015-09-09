package com.servinglynk.hmis.warehouse.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.servinglynk.hmis.warehouse.entity.ApiGroupEntity;
import com.servinglynk.hmis.warehouse.entity.ApiMethodEntity;
import com.servinglynk.hmis.warehouse.entity.ServiceApiMethodEntity;

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

}
