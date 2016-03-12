package com.servinglynk.hmis.warehouse.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.core.model.ApiMethod;
import com.servinglynk.hmis.warehouse.core.model.PermissionSet;
import com.servinglynk.hmis.warehouse.model.v2014.ApiMethodEntity;
import com.servinglynk.hmis.warehouse.model.v2014.HmisUser;
import com.servinglynk.hmis.warehouse.model.v2014.PermissionSetAclEntity;
import com.servinglynk.hmis.warehouse.model.v2014.PermissionSetEntity;
import com.servinglynk.hmis.warehouse.model.v2014.UserPermissionSetAclEntity;
import com.servinglynk.hmis.warehouse.service.PermissionSetService;
import com.servinglynk.hmis.warehouse.service.converter.ApiMethodConverter;
import com.servinglynk.hmis.warehouse.service.converter.PermissionSetConverter;
import com.servinglynk.hmis.warehouse.service.exception.ApiMethodNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.PermissionSetNotFoundException;

public class PermissionSetServiceImpl extends ServiceBase implements PermissionSetService {

	@Transactional
	public PermissionSet createPermissionSet(PermissionSet permissionSet,String caller) {
		if(permissionSet.getApiMethods().size()==0){
			throw new ApiMethodNotFoundException("PermisstionSet should contain atleast on APIMethod");
		}
		PermissionSetEntity entity = PermissionSetConverter.modelToEntity(new PermissionSetEntity(), permissionSet);
		entity.setCreatedAt(new Date());
		entity.setCreatedBy(caller);
		daoFactory.getPermissionSetDao().createPermissionSet(entity);
		for(ApiMethod apiMethod : permissionSet.getApiMethods()){
			ApiMethodEntity apiMethodEntity =	daoFactory.getApiMethodDao().findByExternalId(apiMethod.getExternalId());
			PermissionSetAclEntity permissionSetAclEntity = new PermissionSetAclEntity();
			permissionSetAclEntity.setApiMethod(apiMethodEntity);
			permissionSetAclEntity.setPermissionSet(entity);
			permissionSetAclEntity.setCreatedAt(new Date());
			permissionSetAclEntity.setCreatedBy(caller);
			daoFactory.getPermissionSetDao().createACL(permissionSetAclEntity);
		}
		permissionSet.setId(entity.getId());
		return permissionSet;
	}

	@Transactional
	public PermissionSet updatePermissionSet(PermissionSet permissionSet,String caller) {
		if(permissionSet.getApiMethods().size()==0){
			throw new ApiMethodNotFoundException("PermisstionSet should contain atleast on APIMethod");
		}
		PermissionSetEntity entity = daoFactory.getPermissionSetDao().getPermissionSetById(permissionSet.getId());
		
		if(entity==null) throw new PermissionSetNotFoundException();
		
		entity = PermissionSetConverter.modelToEntity(entity, permissionSet);
		entity.setModifiedAt(new Date());
		entity.setModifiedBy(caller);
		daoFactory.getPermissionSetDao().updatePermissionSet(entity);
		
		List<PermissionSetAclEntity> acls = daoFactory.getPermissionSetDao().getACLByPermissionSetId(entity.getId());
		
		for(PermissionSetAclEntity permissionSetAclEntity : acls){
			daoFactory.getPermissionSetDao().deleteACL(permissionSetAclEntity);
		}
		
		for(ApiMethod apiMethod : permissionSet.getApiMethods()){
			ApiMethodEntity apiMethodEntity =	daoFactory.getApiMethodDao().findByExternalId(apiMethod.getExternalId());
			PermissionSetAclEntity permissionSetAclEntity = new PermissionSetAclEntity();
			permissionSetAclEntity.setApiMethod(apiMethodEntity);
			permissionSetAclEntity.setPermissionSet(entity);
			permissionSetAclEntity.setCreatedAt(new Date());
			permissionSetAclEntity.setCreatedBy(caller);
			daoFactory.getPermissionSetDao().createACL(permissionSetAclEntity);
		}
		permissionSet.setId(entity.getId());
		return permissionSet;
	}

	@Transactional
	public PermissionSet deletePermissionSet(UUID permissionSetId,String caller) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public PermissionSet getPermissionSetById(UUID permissionSetId) {
		List<PermissionSetAclEntity> permissionSetAclEntities= daoFactory.getPermissionSetDao().getACLByPermissionSetId(permissionSetId);
		PermissionSet permissionSet = PermissionSetConverter.entityToModel(permissionSetAclEntities.get(0).getPermissionSet());
		
		for(PermissionSetAclEntity permissionSetAclEntity : permissionSetAclEntities){
			ApiMethod apiMethod = ApiMethodConverter.entityToModel(permissionSetAclEntity.getApiMethod());
			permissionSet.addApiMethod(apiMethod);
		}
		
		return permissionSet;
	}
	
	@Transactional
	public void assignPermissionSetTOUser(String userName,PermissionSet permissionSet,String caller){
		HmisUser accountEntity =  daoFactory.getAccountDao().findByUsername(userName);

		if(accountEntity==null) throw new UsernameNotFoundException(" User not found with user name "+userName);
		
		PermissionSetEntity permissionSetEntity = daoFactory.getPermissionSetDao().getPermissionSetById(permissionSet.getId());
		
		if(permissionSetEntity==null) throw new PermissionSetNotFoundException();
		
		UserPermissionSetAclEntity uPSAEntity = new UserPermissionSetAclEntity();
		uPSAEntity.setAccount(accountEntity);
		uPSAEntity.setPermissionSet(permissionSetEntity);
		
		daoFactory.getPermissionSetDao().assignPermissionSetToUser(uPSAEntity);
		
		
	}
	


}
