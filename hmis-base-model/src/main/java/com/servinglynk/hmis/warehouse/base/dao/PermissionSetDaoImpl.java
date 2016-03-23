package com.servinglynk.hmis.warehouse.base.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.servinglynk.hmis.warehouse.model.base.ApiMethodEntity;
import com.servinglynk.hmis.warehouse.model.base.PermissionSetAclEntity;
import com.servinglynk.hmis.warehouse.model.base.PermissionSetEntity;
import com.servinglynk.hmis.warehouse.model.base.ProfileEntity;
import com.servinglynk.hmis.warehouse.model.base.UserPermissionSetAclEntity;

public class PermissionSetDaoImpl extends QueryExecutorImpl implements PermissionSetDao {

	@Override
	public PermissionSetEntity createPermissionSet(PermissionSetEntity permissionSetEntity) {
		insert(permissionSetEntity);
		return permissionSetEntity;
	}

	@Override
	public PermissionSetEntity updatePermissionSet(PermissionSetEntity permissionSetEntity) {
			update(permissionSetEntity);
		return permissionSetEntity;
	}

	@Override
	public void deletePermissionSet(PermissionSetEntity permissionSetEntity) {
		delete(permissionSetEntity);
	}

	@Override
	public PermissionSetEntity getPermissionSetById(UUID permissionSetId) {
		return (PermissionSetEntity) get(PermissionSetEntity.class, permissionSetId);
	}

	@Override
	public PermissionSetAclEntity createACL(PermissionSetAclEntity entity) {
		insert(entity);
		return entity;
	}
	
	
	public List<PermissionSetAclEntity> getACLByPermissionSetId(UUID permissionSetId){
		DetachedCriteria criteria = DetachedCriteria.forClass(PermissionSetAclEntity.class);
		criteria.createAlias("permissionSet", "permissionSet");
		criteria.add(Restrictions.eq("permissionSet.id",permissionSetId));
		return (List<PermissionSetAclEntity>) findByCriteria(criteria);
	}
	
	public void deleteACL(PermissionSetAclEntity entity){
		delete(entity);
	}

	
	public UserPermissionSetAclEntity assignPermissionSetToUser(UserPermissionSetAclEntity userPermissionSetAclEntity){
		insert(userPermissionSetAclEntity);
		return userPermissionSetAclEntity;
	}
	
	
	public boolean checkAssignedPermissonSet(List<PermissionSetEntity> permissionSetEntities,ApiMethodEntity apiMethodEntity){
		DetachedCriteria criteria = DetachedCriteria.forClass(PermissionSetAclEntity.class);
		criteria.createAlias("permissionSet","permissionSet");
		criteria.createAlias("apiMethod","apiMethod");
		
		criteria.add(Restrictions.eq("apiMethod.id",apiMethodEntity.getId()));
		
		for(PermissionSetEntity permissionSetEntity : permissionSetEntities){
		     Criterion criterion = Restrictions.eq("permissionSet.id", permissionSetEntity.getId());
		     criteria.add(Restrictions.or(criterion));
		}
		
		List<PermissionSetEntity> permissionSets= (List<PermissionSetEntity>) findByCriteria(criteria);
		 if(permissionSets.size()>0) return true; 
		 return false ;
	}
	
	public List<PermissionSetEntity> getAssignedPermissionSets(UUID userId){
		
		List<PermissionSetEntity> permissionSets=new ArrayList<PermissionSetEntity>();
		
		DetachedCriteria criteria = DetachedCriteria.forClass(UserPermissionSetAclEntity.class);
		criteria.createAlias("account","account");
		
		criteria.add(Restrictions.eq("account.id",userId));
		List<UserPermissionSetAclEntity> userPermissions = (List<UserPermissionSetAclEntity>) findByCriteria(criteria);
		
		for(UserPermissionSetAclEntity userPermissionSetAclEntity : userPermissions ){
			permissionSets.add(userPermissionSetAclEntity.getPermissionSet());
		}
		return permissionSets;
	}
	
}
