package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.servinglynk.hmis.warehouse.base.dao.QueryExecutorImpl;
import com.servinglynk.hmis.warehouse.model.v2014.HistoryEntityMapping;

public class HistoryDaoImpl extends QueryExecutorImpl implements HistoryDao {
	
	
	public List<?> getEntityHistory(UUID entityId,String entityName,String projectGroupCode,Integer startIndex, Integer maxItems) {
		DetachedCriteria criteria =DetachedCriteria.forEntityName(entityName);
		criteria.add(Restrictions.eq("parentId", entityId));
		criteria.add(Restrictions.eq("deleted",false));
		criteria.add(Restrictions.eq("projectGroupCode", projectGroupCode));
		return getByCriteria(criteria, startIndex, maxItems);
	}
	
	public long getEntityHistoryCount(UUID entityId,String entityName,String projectGroupCode) {
		DetachedCriteria criteria =DetachedCriteria.forEntityName(entityName);
		criteria.add(Restrictions.eq("parentId", entityId));
		criteria.add(Restrictions.eq("deleted",false));
		criteria.add(Restrictions.eq("projectGroupCode", projectGroupCode));
		return getRowsCount(criteria);
	}
	
	public HistoryEntityMapping getMapping(String apiName) {
		DetachedCriteria criteria = DetachedCriteria.forClass(HistoryEntityMapping.class);
		criteria.add(Restrictions.eq("apiName", apiName));
		List<HistoryEntityMapping> data	=	(List<HistoryEntityMapping>) getByCriteria(criteria);
		if(data.isEmpty()) return null;
		return data.get(0);
	}

}
