package com.servinglynk.hmis.warehouse.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.SortedPagination;
import com.servinglynk.hmis.warehouse.core.model.Role;
import com.servinglynk.hmis.warehouse.core.model.Roles;
import com.servinglynk.hmis.warehouse.model.v2014.RoleEntity;
import com.servinglynk.hmis.warehouse.service.RoleService;
import com.servinglynk.hmis.warehouse.service.converter.RoleConverter;
import com.servinglynk.hmis.warehouse.service.exception.RoleNotFoundException;

public class RoleServiceImpl extends ServiceBase implements RoleService {

	@Transactional
	public Role createRole(Role role,String caller) {
		RoleEntity parentRoleEntiry=null;
		if(role.getParentRole()!=null){
		 parentRoleEntiry = daoFactory.getRoleDao().getRoleByid(role.getParentRole().getId());
		
		if(parentRoleEntiry==null) throw new RoleNotFoundException("Parent Role not found");
		}
		RoleEntity roleEntity = new RoleEntity();
		RoleConverter.modelToEntity(roleEntity, role);
		if(parentRoleEntiry!=null) roleEntity.setParentRoleEntity(parentRoleEntiry);
		
		roleEntity.setCreatedAt(new Date());
		roleEntity.setCreatedBy(caller);
		daoFactory.getRoleDao().createRole(roleEntity);
		role.setId(roleEntity.getId());
		return role;
	}

	@Transactional
	public Role updateRole(Role role,String caller) {
		RoleEntity parentRoleEntiry = null;
		if(role.getParentRole()!=null){
		 parentRoleEntiry = daoFactory.getRoleDao().getRoleByid(role.getParentRole().getId());
		if(parentRoleEntiry==null) throw new RoleNotFoundException("Parent Role not found");
		}
		RoleEntity roleEntity = daoFactory.getRoleDao().getRoleByid(role.getId());
		if(roleEntity==null){
			throw new RoleNotFoundException();
		}
		RoleConverter.modelToEntity(roleEntity, role);
		if(parentRoleEntiry!=null) roleEntity.setParentRoleEntity(parentRoleEntiry);
		roleEntity.setModifiedAt(new Date());
		roleEntity.setModifiedBy(caller);
		
		
		daoFactory.getRoleDao().updateRole(roleEntity);
		role.setId(roleEntity.getId());
		return role;
	}

	@Transactional
	public Role deleteRole(UUID roleId) {
		RoleEntity roleEntity = daoFactory.getRoleDao().getRoleByid(roleId);
		if(roleEntity==null){
			throw new RoleNotFoundException();
		}
		//daoFactory.getRoleDao().deleteRole(roleEntity);
		return new Role();
	}

	@Transactional
	public Roles getAllRoles(Integer startIndex, Integer maxItems) {
		Roles roles = new Roles();
		List<RoleEntity> roleEntities = daoFactory.getRoleDao().getRoles(startIndex,maxItems);
		
		for(RoleEntity roleEntity : roleEntities){
			roles.addRole(RoleConverter.entityToModelFull(roleEntity));
		}
		
		long count = daoFactory.getRoleDao().geRoleCount();
		
		SortedPagination pagination = new SortedPagination();

		pagination.setReturned(roles.getRoles().size());
		pagination.setFrom(startIndex);
		roles.setPagination(pagination);
		pagination.setTotal((int)count);
		return roles;
	}

}
