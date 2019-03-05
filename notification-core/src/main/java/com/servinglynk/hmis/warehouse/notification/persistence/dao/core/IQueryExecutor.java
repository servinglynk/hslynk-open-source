/**
 * 
 */
package com.servinglynk.hmis.warehouse.notification.persistence.dao.core;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;


public interface IQueryExecutor  {

	public void load(Object entity,Serializable id);
	
	public Object get(Class<?> entity,Serializable id);
	
	public Object insert(Object entity);

	public Object update(Object entity);

	public Object merge(Object entity) ;

	public void delete(Object entity);

	public Object insertOrUpdate(Object entity);

	
	public List<?> findByNamedQueryAndNamedParam(String query,String[] params, Object[] values);
	public List<?> findByNativeSQL(String query, Class<?> className);

	public List<?> findByNamedQuery(String query);

	//public List<?> findByFetchCount(String query, int fetchCount);
	
	public List<?> findByCriteria(DetachedCriteria detachedCriteria);
}
