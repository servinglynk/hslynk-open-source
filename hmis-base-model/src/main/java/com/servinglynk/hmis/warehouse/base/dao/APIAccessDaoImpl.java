package com.servinglynk.hmis.warehouse.base.dao;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.servinglynk.hmis.warehouse.model.base.APIAccessEntity;

public class APIAccessDaoImpl extends QueryExecutorImpl implements APIAccessDao {

	@SuppressWarnings("unchecked")
	@Override
	public APIAccessEntity getAPIAccess(String projectGroupCode, Date date,UUID serviceId) {
			DetachedCriteria  criteria =DetachedCriteria.forClass(APIAccessEntity.class);
			criteria.add(Restrictions.eq("projectGroupCode", projectGroupCode));
			criteria.add(Restrictions.eq("accessDate", date));
			criteria.add(Restrictions.eq("serviceId", serviceId));
			List<APIAccessEntity> entities = (List<APIAccessEntity>) findByCriteria(criteria);
			if(!entities.isEmpty()) return entities.get(0);
		return null;
	}
	
	
	public void createAPIAccess(APIAccessEntity accessEntity){
		insert(accessEntity);		
	}
	
	public void updateAPIAccess(APIAccessEntity accessEntity){
		update(accessEntity);		
	}

}
