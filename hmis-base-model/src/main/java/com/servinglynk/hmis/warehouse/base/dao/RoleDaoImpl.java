package com.servinglynk.hmis.warehouse.base.dao;

import java.util.List;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;

import com.servinglynk.hmis.warehouse.model.base.RoleEntity;

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
	public List<RoleEntity> getRoles(Integer startIndex, Integer maxItems) {
		DetachedCriteria criteria=DetachedCriteria.forClass(RoleEntity.class);
		return (List<RoleEntity>) findByCriteria(criteria,startIndex,maxItems);
	}

	@Override
	public long geRoleCount() {
		DetachedCriteria criteria=DetachedCriteria.forClass(RoleEntity.class);
		return countRows(criteria);
	}
}
