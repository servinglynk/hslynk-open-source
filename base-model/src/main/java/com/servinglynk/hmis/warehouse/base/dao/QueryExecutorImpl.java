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
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.internal.CriteriaImpl;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.common.Constants;
import com.servinglynk.hmis.warehouse.common.security.LoggedInUser;
import com.servinglynk.hmis.warehouse.model.EnrollmentSharingModel;
import com.servinglynk.hmis.warehouse.model.base.HmisBaseModel;
import com.servinglynk.hmis.warehouse.model.base.SessionEntity;

@Component
public class QueryExecutorImpl  implements QueryExecutor{
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
	@Transactional(propagation = Propagation.REQUIRED)
	public Object insert(Object entity) {
		try{
		return getCurrentSession().save(entity);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unused")
	public Object update(Object entity) {
		 try {
			 // Looking for parentId field.
			 // If field is available, existed record will be clone and then update action perform on existed record.
			 // If field is not available, only update action perform on existed record.
			 Field parentIdField = entity.getClass().getSuperclass().getDeclaredField("parentId");
			 getCurrentSession().evict(entity);
			 Method method = entity.getClass().getDeclaredMethod("getId");
			 cloneRecord(entity.getClass().getName(), UUID.fromString(method.invoke(entity).toString()));
		  	 getCurrentSession().update(entity); 
		}catch(NoSuchFieldException ex){
			getCurrentSession().update(entity);
		}
		 catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}
	

	public void cloneRecord(String className,UUID id) throws Exception {
		Class<?> clz = Class.forName(className);
		 Object obj = getCurrentSession().get(clz, id);	
			Object cloneObj = Class.forName(className).newInstance();
			BeanUtils.copyProperties(cloneObj, obj);
			BeanUtils.setProperty(cloneObj, "parentId", id );
			BeanUtils.setProperty(cloneObj, "id", UUID.randomUUID());
			//BeanUtils.setProperty(cloneObj, "version", getVersion(className,id)+1);
			getCurrentSession().save(cloneObj);
 		    getCurrentSession().evict(obj);
	}
	
	public long getVersion(String className,UUID parentId) throws Exception {
		DetachedCriteria criteria = DetachedCriteria.forClass(Class.forName(className));
		criteria.add(Restrictions.eq("parentId", parentId));
		return criteria.getExecutableCriteria(getCurrentSession()).list().size();
	}

	public Object merge(Object entity) {
		getCurrentSession().merge(entity);
		return null;
	}

	@SuppressWarnings("unused")
	public void delete(Object entity) {
          try
          {
        	  // looking for deleted field in entity class. 
        	  // If field is available deleted field will be updated to true.
        	  // If field is not available catch block will be executed then regular delete operation will be performed.  
 			 Field deletedField = entity.getClass().getSuperclass().getDeclaredField("deleted");
        	  if(deletedField!=null) {
                  BeanUtils.setProperty(entity, "deleted",true);
                  BeanUtils.setProperty(entity, "sync",false);
                  BeanUtils.setProperty(entity, "dateUpdated",LocalDateTime.now());
                  getCurrentSession().update(entity);
        	  }else{
        		  getCurrentSession().delete(entity);
        	  }
        	 
          } catch(Exception  e){
        	  getCurrentSession().delete(entity);  
        	  e.printStackTrace();
          }
	}
	@SuppressWarnings("unused")
	public void softDeleteByProjectGroupCode(String className,String projectGroupCode,UUID exportId) {
		DetachedCriteria criteria = null;
		try {
			criteria = DetachedCriteria.forClass(Class.forName(className));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		criteria.add(Restrictions.eq("projectGroupCode", projectGroupCode));
		criteria.add(Restrictions.eq("deleted", false));
	//	criteria.createAlias("export", "exp").add(Restrictions.eq("exp.id", exportId));
		List<Object> objects = criteria.getExecutableCriteria(getCurrentSession()).list();
		if(objects !=null) {
			for(Object entity : objects) {
				 if(entity instanceof HmisBaseModel) {
					 delete(entity);
				 }
			}
		}
	}
	@SuppressWarnings("unused")
	public void deleteFromDB(Object entity) {
          try
          {
        	  delete(entity);
          } catch(Exception  e){
        	  e.printStackTrace();
          }
		
	
	}
	
	@SuppressWarnings("unused")
	public void hardDelete(Object entity) {
          try
          {
        	 getCurrentSession().delete(entity);
          } catch(Exception  e){
        	  getCurrentSession().delete(entity);  
        	  e.printStackTrace();
          }
	}
	
	@SuppressWarnings("unused")
	public void undoSoftDeleteByExportId(String className,UUID exportId) {
		DetachedCriteria criteria = null;
		try {
			criteria = DetachedCriteria.forClass(Class.forName(className));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		criteria.createAlias("export", "export");
		criteria.add(Restrictions.eq("export.id", exportId));
		criteria.add(Restrictions.eq("deleted", true));
		List<Object> objects = criteria.getExecutableCriteria(getCurrentSession()).list();
		if(objects !=null) {
			for(Object entity : objects) {
				 if(entity instanceof HmisBaseModel) {
					 ((HmisBaseModel) entity).setDeleted(false);
					 ((HmisBaseModel) entity).setSync(false);
					 undoDelete(entity);
				 }
			}
		}
	}
	
	@SuppressWarnings("unused")
	public void undoDelete(Object entity) {
          try
          {
        	  // looking for deleted field in entity class. 
        	  // If field is available deleted field will be updated to true.
        	  // If field is not available catch block will be executed then regular delete operation will be performed.  
        	  if(entity instanceof HmisBaseModel) {
                  BeanUtils.setProperty(entity, "deleted",false);
                  BeanUtils.setProperty(entity, "sync",true);
                  BeanUtils.setProperty(entity, "dateUpdated",LocalDateTime.now());
                  getCurrentSession().update(entity);
        	  }else{
        		  getCurrentSession().delete(entity);
        	  }
        	 
          } catch(Exception  e){
        	  getCurrentSession().delete(entity);  
        	  e.printStackTrace();
          }
	}
	

	public Object insertOrUpdate(Object entity) {
		getCurrentSession().saveOrUpdate(entity);
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.IQueryExecutor#executeNQ(java.lang.String, java.lang.String[], java.lang.Object[])
	 * 
	 * This method is used to execute Named queries . All DAO can call this method for executing Named Queries. If the number of parameters do not match with 
	 * number of values, throws "Illegal Argument Exception". 
	 */
	public int executeNQ(String queryName, String[] paramNames, Object[] paramValues) {
		if (paramNames != null && paramValues != null 	&& paramNames.length != paramValues.length) {
			throw new IllegalArgumentException("Length of paramNames array must match length of paramValues array");
		}

		Session session = getCurrentSession();
		Query queryObject = session.getNamedQuery(queryName);
		if (paramValues != null) {
			for (int param = 0; param< paramValues.length; param++) {
				applyNamedParameterToQuery(queryObject, paramNames[param], 	paramValues[param]);
			}
		}
		return queryObject.executeUpdate();
		
	}
	
/* 
 * (non-Javadoc)
 * @see com.servinglynk.hmis.warehouse.dao.IQueryExecutor#executeUpdateHQL(java.lang.String, java.lang.String[], java.lang.Object[])
 * 
 * This method is used to execute Hibernate queries . All DAO can call this method for executing Hibernate Queries. If the number of parameters do not match with 
 * number of values, throws "Illegal Argument Exception". 
 */
public int executeHQL(String queryName, String[] paramNames, Object[] paramValues) {
		
	if (paramNames != null && paramValues != null
			&& paramNames.length != paramValues.length) {
		throw new IllegalArgumentException("Length of paramNames array must match length of paramValues array");
	}

	Session session = getCurrentSession();
	Query queryObject = session.createQuery(queryName);
	if (paramValues != null) {
		for (int param = 0;  param< paramValues.length; param++) {
			applyNamedParameterToQuery(queryObject, paramNames[param],	paramValues[param]);
		}
	}
	return queryObject.executeUpdate();
		
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

	public List<?> findByNamedQuery(String queryName) {
		return null;
		//TBD
	}
	
	public List<?> list(String entityName){
		Session session = getCurrentSession();
		return session.createQuery("from "+entityName).list();
	}
	
	
	public List<?> findByNativeSQL(String query, Class<?> className) {
		Session session = getCurrentSession();
		
		Query queryObject = session.createSQLQuery(query).addEntity(className);
		return queryObject.list();
	}
	
	public List<?> find(DetachedCriteria detachedCriteria){
				return detachedCriteria.getExecutableCriteria(getCurrentSession()).list();
	}
	
	public List<?> findByCriteria(DetachedCriteria detachedCriteria){
		addingConditionsToCriteria(detachedCriteria);
				return detachedCriteria.getExecutableCriteria(getCurrentSession()).list();
	}
	
	public List<?> getByCriteria(DetachedCriteria detachedCriteria){
		return detachedCriteria.getExecutableCriteria(getCurrentSession()).list();
	}
	
	public List<?> getByCriteria(DetachedCriteria detachedCriteria,Integer firstResult,Integer maxResults){
		Criteria criteria = detachedCriteria.getExecutableCriteria(getCurrentSession());
		if(firstResult!=null && maxResults!=null) {
			criteria.setFirstResult(firstResult);
			criteria.setMaxResults(maxResults);		
		}
		return criteria.list();
	}
	
	public List<?> findByCriteriaWithOutDelete(DetachedCriteria detachedCriteria){
		Criteria criteria = detachedCriteria.getExecutableCriteria(getCurrentSession());
		return criteria.list();
	}
	
	public List<?> findByCriteria(DetachedCriteria detachedCriteria,Integer firstResult,Integer maxResults){
		addingConditionsToCriteria(detachedCriteria);
		Criteria criteria = detachedCriteria.getExecutableCriteria(getCurrentSession());
		if(firstResult!=null && maxResults!=null) {
			criteria.setFirstResult(firstResult);
			criteria.setMaxResults(maxResults);		
		}
		return criteria.list();
	}
	
	@SuppressWarnings("unused")
	public DetachedCriteria addingConditionsToCriteria(DetachedCriteria detachedCriteria) {
		try{
			SecurityContext context =  SecurityContextHolder.getContext();
			Authentication authentication =  context.getAuthentication();
			CriteriaImpl criteriaImpl =(CriteriaImpl)detachedCriteria.getExecutableCriteria(getCurrentSession());
			Class<?> clz = Class.forName(criteriaImpl.getEntityOrClassName());
			if(EnrollmentSharingModel.class.isAssignableFrom(clz)) {
				if(authentication.getPrincipal()!=null){
					LoggedInUser entity = (LoggedInUser) authentication.getPrincipal();
					Criterion projectGroupCriterion = Restrictions.eq("projectGroupCode", entity.getProjectGroup());
						if(entity.getCheckProjectGroup())detachedCriteria.add(projectGroupCriterion);
					detachedCriteria.add(Restrictions.eq("deleted", false));
					detachedCriteria.add(Restrictions.isNull("parentId"));
				}
			}else if(clz.getSimpleName().equals("Enrollment")) {
				if(authentication.getPrincipal()!=null){
					detachedCriteria.add(Restrictions.isNull("parentId"));
					LoggedInUser entity = (LoggedInUser) authentication.getPrincipal();
					Criterion projectGroupCriterion = Restrictions.eq("projectGroupCode", entity.getProjectGroup());
					if(entity.getCheckProjectGroup())	detachedCriteria.add(projectGroupCriterion);
					detachedCriteria.add(Restrictions.eq("deleted", false));
				}
			}else 
			if(clz.getSuperclass().getSimpleName().equals("HmisBaseModel")){
				if(authentication.getPrincipal()!=null){

					LoggedInUser entity = (LoggedInUser) authentication.getPrincipal();
					if(entity.getCheckProjectGroup())detachedCriteria.add(Restrictions.eq("projectGroupCode",entity.getProjectGroup()));
					detachedCriteria.add(Restrictions.eq("deleted", false));
					detachedCriteria.add(Restrictions.isNull("parentId"));
				}
			}else if (clz.getSuperclass().getSimpleName().equals("HMISModel")) {
				if(authentication.getPrincipal()!=null){
					LoggedInUser entity = (LoggedInUser) authentication.getPrincipal();
					if(entity.getCheckProjectGroup())detachedCriteria.add(Restrictions.eq("projectGroupCode", entity.getProjectGroup()));
					detachedCriteria.add(Restrictions.eq("deleted", false));
				}
			}else if(clz.getSimpleName().equals("HmisUser")) {
				LoggedInUser entity = (LoggedInUser) authentication.getPrincipal();
				if(entity.getCheckProjectGroup())detachedCriteria.add(Restrictions.eq("projectGroupCode", entity.getProjectGroup()));

			}
		return detachedCriteria;
		}catch(Exception e){
			return detachedCriteria;
		}
		
	}
	
	public long countRows(DetachedCriteria dCriteria, ProjectionList projectionList){
		 return (long)0;
		 //TBD
	}
	public long countRows(DetachedCriteria dCriteria){
		addingConditionsToCriteria(dCriteria);
		dCriteria.setProjection(Projections.rowCount());
		Criteria criteria = dCriteria.getExecutableCriteria(getCurrentSession());
		return (long) criteria.uniqueResult();
	}
	
	public long getRowsCount(DetachedCriteria dCriteria){
		addingConditionsToCriteria(dCriteria);
		dCriteria.setProjection(Projections.rowCount());
		Criteria criteria = dCriteria.getExecutableCriteria(getCurrentSession());
		return (long) criteria.uniqueResult();
	}
	
	protected Object[] executeNativeSQL(Class<?> className){
		return null;
	}
	
	public List<?> findByNQandNP(String query,String[] params, Object[] values){
		return null;
		//TBD
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
	
	// 03/18/2015 - Applying parameters query - parameteres can be sent normally as a collection, array of objects or as a value.
	protected void applyNamedParameterToQuery(Query queryObject, String paramName, Object value) {
		if (value instanceof Collection) {
				queryObject.setParameterList(paramName, (Collection<?>) value);
		} else if (value instanceof Object[]) {
				queryObject.setParameterList(paramName, (Object[]) value);
		} else {
				queryObject.setParameter(paramName, value);
		}
	}


	protected Object findUniqueResultByNamedQueryAndNamedParam(String queryName,
			String[] paramNames, Object[] paramValues) {

		if (paramNames != null && paramValues != null
				&& paramNames.length != paramValues.length) {
			throw new IllegalArgumentException(
					"Length of paramNames array must match length of paramValues array");
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
	
	
	protected List<UUID> findIdsByNativeQuery(String query){
		return getCurrentSession().createSQLQuery(query).addScalar("id", org.hibernate.type.PostgresUUIDType.INSTANCE)
				.list();
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
	

}
