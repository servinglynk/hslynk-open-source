/**
 * @Date 03/12/2015
 * @Description HMIS Query Executor - This is extended by all DAOs to perform several DB operations 
 *   -  perform CRUD operations
 *   -  execute  Native Queries
 *   -  execute HQL queries
 *   -  execute Named queries with parameters 
 *   -  execute Criteria queries
 *   -  count rows 
 *   -  execute callable statements
 */
package com.servinglynk.hmis.warehouse.base.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.ProjectionList;

public interface QueryExecutor  {

	public void load(Object entity,Serializable id);
	
	public Object get(Class<?> entity,Serializable id);
	
	public Object insert(Object entity);

	public Object update(Object entity);

	public Object merge(Object entity) ;

	public void delete(Object entity);
	
	public List<?> list(String entityName);

	public Object insertOrUpdate(Object entity);

	//Named Query and Named Parameters
	public List<?> findByNQandNP(String query,String[] params, Object[] values);
	
	public List<?> findByNativeSQL(String query, Class<?> className);

	public List<?> findByNamedQuery(String query);
	
	public List<?> findByCriteriaWithOutDelete(DetachedCriteria detachedCriteria);

	public List<?> findByCriteria(DetachedCriteria detachedCriteria);
	
	public int executeNQ(String queryName, String[] paramNames, Object[] paramValues);
	
	public int executeHQL(String queryName, String[] paramNames, Object[] paramValues);
	
	public List<?> findByExample(Object entity);
	
	public long countRows(DetachedCriteria dCriteria);
	
	public long countRows(DetachedCriteria dCriteria, ProjectionList projectionList);
	
	public List<?> findByCriteria(DetachedCriteria detachedCriteria,Integer firstResult,Integer maxResults);
	
	List<?> find(DetachedCriteria detachedCriteria);
	
}
