/**
 * @author Surya Yadavalli
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
package com.servinglynk.hmis.warehouse.notification.persistence.dao.core;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class QueryExecutor   implements IQueryExecutor{
	@Autowired
	SessionFactory sessionFactory;
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
		
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	public void load(Object entity,Serializable id){
		getCurrentSession().load(entity, id);
	}
	
	public Object get(Class<?> entity,Serializable id){
		return getCurrentSession().get(entity, id);
	}
	
	public Object insert(Object entity) {
		try{
		return getCurrentSession().save(entity);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	public Object update(Object entity) {
		getCurrentSession().update(entity);
		return null;
	}

	public Object merge(Object entity) {
		getCurrentSession().merge(entity);
		return null;
	}

	public void delete(Object entity) {
		getCurrentSession().delete(entity);
	}
	
	

	public Object insertOrUpdate(Object entity) {
		getCurrentSession().saveOrUpdate(entity);
		return null;
	}

	
	protected int executeUpdateNQ(String queryName, String[] paramNames, Object[] paramValues) {
		
		if (paramNames != null && paramValues != null
				&& paramNames.length != paramValues.length) {
			throw new IllegalArgumentException("Length of paramNames array must match length of paramValues array");
		}

		Session session = getCurrentSession();
		Query queryObject = session.getNamedQuery(queryName);
		if (paramValues != null) {
			for (int i = 0; i < paramValues.length; i++) {
				applyNamedParameterToQuery(queryObject, paramNames[i],
						paramValues[i]);
			}
		}
		return queryObject.executeUpdate();
		
	}
	
	
protected int executeUpdateHQL(String queryName, String[] paramNames, Object[] paramValues) {
		
		if (paramNames != null && paramValues != null
				&& paramNames.length != paramValues.length) {
			throw new IllegalArgumentException(
					"Length of paramNames array must match length of paramValues array");
		}

		Session session = getCurrentSession();
		Query queryObject = session.createQuery(queryName);
		if (paramValues != null) {
			for (int i = 0; i < paramValues.length; i++) {
				applyNamedParameterToQuery(queryObject, paramNames[i],
						paramValues[i]);
			}
		}
		return queryObject.executeUpdate();
		
	}
	
	public List<?> findByNamedQueryAndNamedParam(String queryName, String[] paramNames, Object[] paramValues) {
		return findByNamedQueryAndNamedParam(queryName, paramNames,paramValues, -1, -1);
	}

	public List<?> findByNamedQuery(String queryName) {
		return findByNamedQueryAndNamedParam(queryName, null, null, -1, -1);
	}
	

	protected Object findUniqueResultByNamedQueryAndNamedParam(String queryName, String[] paramNames, Object[] paramValues) {

		if (paramNames != null && paramValues != null
				&& paramNames.length != paramValues.length) {
			throw new IllegalArgumentException("Length of paramNames array must match length of paramValues array");
		}

		Session session = getCurrentSession();
		Query queryObject = session.getNamedQuery(queryName);
			for (int i = 0; i < paramValues.length; i++) {
				if (paramValues != null) {
				applyNamedParameterToQuery(queryObject, paramNames[i],
						paramValues[i]);
			}
		}
		return  queryObject.uniqueResult();
	}
	
	protected Object findUniqueObjectByNamedQueryAndNamedParam(String queryName, String[] paramNames, Object[] paramValues) {

		if (paramNames != null && paramValues != null && paramNames.length != paramValues.length) {
			throw new IllegalArgumentException("Length of paramNames array must match length of paramValues array");
		}

		Session session = getCurrentSession();
		Query queryObject = session.getNamedQuery(queryName);
		if (paramValues != null) {
			for (int i = 0; i < paramValues.length; i++) {
				applyNamedParameterToQuery(queryObject, paramNames[i], paramValues[i]);
			}
		}
		return queryObject.uniqueResult();
	}
	
	 @SuppressWarnings("rawtypes")
	public List<?> findByNativeSQL(String query, Class className) {
		Session session = getCurrentSession();
		
		Query queryObject = session.createSQLQuery(query).addEntity(className);
		return queryObject.list();
	}
	

	protected List<?> findByNamedQueryAndNamedParam(String queryName,
			String[] paramNames, Object[] paramValues, int maxResults, int firstResult) {

		if (paramNames != null && paramValues != null
				&& paramNames.length != paramValues.length) {
			throw new IllegalArgumentException(
					"Length of paramNames array must match length of paramValues array");
		}

		Session session = getCurrentSession();
		Query queryObject = session.getNamedQuery(queryName);
		if (paramValues != null) {
			for (int i = 0; i < paramValues.length; i++) {
				applyNamedParameterToQuery(queryObject, paramNames[i],
						paramValues[i]);
			}
		}

		if (maxResults != -1) {
			queryObject.setMaxResults(maxResults);
		}
		if (firstResult != -1) {
			queryObject.setFirstResult(firstResult);
		}

		return queryObject.list();
	}
	
	@SuppressWarnings("rawtypes")
	protected void applyNamedParameterToQuery(Query queryObject,
			String paramName, Object value) {

		if (value instanceof Collection) {

			queryObject.setParameterList(paramName, (Collection) value);

		} else if (value instanceof Object[]) {

			queryObject.setParameterList(paramName, (Object[]) value);

		} else {

			queryObject.setParameter(paramName, value);

		}

	}




	public List<?> findByCriteria(DetachedCriteria detachedCriteria){
		return detachedCriteria.getExecutableCriteria(getCurrentSession()).list();
	}
	
	
	@SuppressWarnings("rawtypes")
	public List findByCriteria(DetachedCriteria detachedCriteria,Integer firstResult,Integer maxResults){
		return detachedCriteria.getExecutableCriteria(getCurrentSession()).setFirstResult(firstResult).setMaxResults(maxResults).list();
	}
	
	protected long countRows(DetachedCriteria dCriteria, ProjectionList projectionList){
		 dCriteria.setProjection(projectionList);
		 return (Long) dCriteria.getExecutableCriteria(getCurrentSession()).uniqueResult();
	}
	

	protected long countRows(DetachedCriteria dCriteria){
		 dCriteria.setProjection(Projections.rowCount());
		 return (Long) dCriteria.getExecutableCriteria(getCurrentSession()).uniqueResult();
	}
	
	@SuppressWarnings("rawtypes")
	protected Object[] executeNativeSQL(Class className){
		return null;
		/*
		Query query = session.createSQLQuery(
				"select * from stock s where s.stock_code = :stockCode")
				.addEntity(Stock.class)
				.setParameter("stockCode", "7277");
				List result = query.list();h
				*/
	}

	
	protected final Session getCurrentSession() {

		return sessionFactory.getCurrentSession();

	}
	
	public List<?> findByExample(Object entity) {
		Example example = Example.create( entity );
		example.enableLike(MatchMode.ANYWHERE);
		Criteria criteria = getCurrentSession().createCriteria( entity.getClass() );
		criteria.add( example );
		return criteria.add(example).list();
	}
	
@SuppressWarnings("rawtypes")
public List findAll(Object entity) {
		
		String queryString = "from "+entity.getClass().getName();
		
		SQLQuery sqlQuery = getCurrentSession().createSQLQuery(queryString);
		return sqlQuery.list();
		
		/*Example example = Example.create( entity );
		example.enableLike(MatchMode.ANYWHERE);
		Criteria criteria = getCurrentSession().createCriteria( entity.getClass() );
		criteria.add( example );
		return criteria.add(example).list();*/
	}



}
