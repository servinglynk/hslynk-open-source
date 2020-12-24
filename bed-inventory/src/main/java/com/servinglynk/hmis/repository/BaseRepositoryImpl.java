package com.servinglynk.hmis.repository;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;


import com.servinglynk.hmis.config.SecurityUtil;
import com.servinglynk.hmis.warehouse.core.model.Account;

public class BaseRepositoryImpl<T, ID extends Serializable>
			extends SimpleJpaRepository<T, ID>   implements BaseRepository<T, ID> {

	public BaseRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
        this.entityManager = entityManager;
	}

	private final EntityManager entityManager;
	
	 public BaseRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
	        super(domainClass, entityManager);
	        this.entityManager = entityManager;
	    }



	@Override
	@Transactional
	public void delete(T entity)  {
			try {
				BeanUtils.setProperty(entity, "deleted", true);
				BeanUtils.setProperty(entity, "dateUpdated", LocalDateTime.now());
				Account account = SecurityUtil.getUserAccount();
				if(account!=null)
						BeanUtils.setProperty(entity, "userId", account.getAccountId());

				entityManager.merge(entity);
			} catch (Exception e) {
				entityManager.detach(entity);
				entityManager.flush();
			} 
	}
	@Transactional
	public void delete(Iterable<? extends T> entities){
		for (T entity : entities) {
			delete(entity);
		}
	}
	
	@Transactional
	public T findOne(ID id) {
		DetachedCriteria criteria = DetachedCriteria.forClass(this.getDomainClass());
		criteria.add(Restrictions.eq("id",id));
		criteria.add(Restrictions.eq("projectGroupCode", SecurityUtil.getUserProjectGroup()));
		Session session = entityManager.unwrap(Session.class);
		List<T> entities =	criteria.getExecutableCriteria(session).list();
		if(entities.isEmpty()) return null;
		return entities.get(0);
	}
}