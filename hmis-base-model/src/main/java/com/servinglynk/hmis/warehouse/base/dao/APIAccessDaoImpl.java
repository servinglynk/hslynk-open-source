package com.servinglynk.hmis.warehouse.base.dao;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.Type;

import com.servinglynk.hmis.warehouse.model.base.APIAccessEntity;

public class APIAccessDaoImpl extends QueryExecutorImpl implements APIAccessDao {

	public String[] monthName = { "January", "February", "March", "April", "May", "June", "July",
		        "August", "September", "October", "November", "December" };
	

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
	
	@Override
	public List<APIAccessEntity> getAPIAccessDetails(String projectGroupCode, Date date,UUID serviceId) {
			DetachedCriteria  criteria =DetachedCriteria.forClass(APIAccessEntity.class);
			if(projectGroupCode!=null)criteria.add(Restrictions.eq("projectGroupCode", projectGroupCode));
			if(serviceId!=null)criteria.add(Restrictions.eq("serviceId", serviceId));
			criteria.add(Restrictions.sqlRestriction("rtrim(to_char(access_date,'Month')) = '"+monthName[date.getMonth()] + "'"));
				ProjectionList projectionList = Projections.projectionList();
				projectionList.add(Projections.property("projectGroupCode"),"projectGroupCode");

				projectionList.add(Projections.sum("accessCount"),"accessCount");
				projectionList.add(Projections.sqlProjection("to_char(access_date,'Month') as serviceName",new String[] {"serviceName"}, new Type[] {StandardBasicTypes.STRING}));
				projectionList.add(Projections.sqlGroupProjection("to_char(access_date,'Month') as serviceName","serviceName" ,new String[] {"serviceName"}, new Type[] {StandardBasicTypes.STRING}));
				projectionList.add(Projections.groupProperty("projectGroupCode"));
				
			criteria.setProjection(projectionList);
			criteria.setResultTransformer(Transformers.aliasToBean(APIAccessEntity.class));
			
			return (List<APIAccessEntity>) findByCriteria(criteria);
	}
	
	
	public void createAPIAccess(APIAccessEntity accessEntity){
		insert(accessEntity);		
	}
	
	public void updateAPIAccess(APIAccessEntity accessEntity){
		update(accessEntity);		
	}
}
