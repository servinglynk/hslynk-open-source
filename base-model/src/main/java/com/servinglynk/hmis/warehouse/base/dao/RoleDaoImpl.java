package com.servinglynk.hmis.warehouse.base.dao;

import java.util.List;
import java.util.UUID;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.servinglynk.hmis.warehouse.domain.Criteria;
import com.servinglynk.hmis.warehouse.model.base.RoleEntity;
import com.servinglynk.hmis.warehouse.model.base.UserRoleMapEntity;

public class RoleDaoImpl extends QueryExecutorImpl implements RoleDao {

	@Override
	public RoleEntity createRole(RoleEntity roleEntity) {
		insert(roleEntity);
		return roleEntity;
	}

	@Override
	public RoleEntity updateRole(RoleEntity roleEntity) {
		update(roleEntity);
		return roleEntity;
	}

	@Override
	public void deleteRole(RoleEntity roleEntity) {
		delete(roleEntity);
	}

	@Override
	public RoleEntity getRoleByid(UUID roleId) {
		return (RoleEntity) get(RoleEntity.class, roleId);
	}

	@SuppressWarnings("unchecked")
	public List<RoleEntity> getRoles() {
		DetachedCriteria criteria=DetachedCriteria.forClass(RoleEntity.class);
		return (List<RoleEntity>) findByCriteria(criteria);
	}

	@SuppressWarnings("unchecked")
	public List<RoleEntity> getRoles(List<UUID> roles,Integer startIndex, Integer maxItems) {
	//	DetachedCriteria criteria=DetachedCriteria.forClass(RoleEntity.class);
		org.hibernate.Criteria criteria = sessionFactory.getCurrentSession().createCriteria(RoleEntity.class);
		if(!roles.isEmpty())
			criteria.add(Restrictions.in("id", roles));
		ProjectionList projectionList = Projections.projectionList();
		projectionList.add(Projections.max("roleLevel"));
		criteria.setProjection(projectionList);
		
		Integer max = (Integer) criteria.uniqueResult();
	
		DetachedCriteria criteria2 = DetachedCriteria.forClass(RoleEntity.class);
		criteria2.add(Restrictions.ge("roleLevel", max));
		
		return (List<RoleEntity>) findByCriteria(criteria2,startIndex,maxItems);
	}
	
	@Override
	public long geRoleCount(List<UUID> roles) {
		org.hibernate.Criteria criteria = sessionFactory.getCurrentSession().createCriteria(RoleEntity.class);
		if(!roles.isEmpty())
			criteria.add(Restrictions.in("id", roles));
		ProjectionList projectionList = Projections.projectionList();
		projectionList.add(Projections.max("roleLevel"));
		criteria.setProjection(projectionList);
		
		Integer max = (Integer) criteria.uniqueResult();
	
		DetachedCriteria criteria2 = DetachedCriteria.forClass(RoleEntity.class);
		criteria2.add(Restrictions.ge("roleLevel", max));

		return countRows(criteria2);
	}
}
