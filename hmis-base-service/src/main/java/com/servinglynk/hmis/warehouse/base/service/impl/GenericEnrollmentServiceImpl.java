package com.servinglynk.hmis.warehouse.base.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.SortedPagination;
import com.servinglynk.hmis.warehouse.base.service.GenericEnrollmentService;
import com.servinglynk.hmis.warehouse.base.service.converter.GenericEnrollmentConveter;
import com.servinglynk.hmis.warehouse.core.model.Account;
import com.servinglynk.hmis.warehouse.core.model.GenericEnrollment;
import com.servinglynk.hmis.warehouse.core.model.GenericEnrollments;
import com.servinglynk.hmis.warehouse.model.base.GenericEnrollmentEntity;
import com.servinglynk.hmis.warehouse.service.exception.ResourceNotFound;

public class GenericEnrollmentServiceImpl extends ServiceBase implements GenericEnrollmentService {

	@Override
	@Transactional
	public GenericEnrollment create(GenericEnrollment model,Account account) {
		
		if(model.getGlobalEnrollmentId()!=null) {
			serviceFactory.getGlobalEnrollmentService().getById(model.getGlobalEnrollmentId());
		}
		
		if(model.getGlobalProjectId()!=null) {
			serviceFactory.getGlobalProjectService().getById(model.getGlobalProjectId());
		}
		
		GenericEnrollmentEntity entity = GenericEnrollmentConveter.modelToEntity(null, model);
		entity.setUser(account.getAccountId());
		entity.setDateCreated(LocalDateTime.now());
		entity.setDateUpdated(LocalDateTime.now());
		entity.setProjectGroupCode(account.getProjectGroup().getProjectGroupCode());
		daoFactory.getGenericEnrollmentDao().create(entity);
		model.setId(entity.getId());
		return model;
	}

	@Transactional
	public void update(GenericEnrollment model,Account account) {
		
		if(model.getGlobalEnrollmentId()!=null) {
			serviceFactory.getGlobalEnrollmentService().getById(model.getGlobalEnrollmentId());
		}
		
		if(model.getGlobalProjectId()!=null) {
			serviceFactory.getGlobalProjectService().getById(model.getGlobalProjectId());
		}
		
		GenericEnrollmentEntity entity = daoFactory.getGenericEnrollmentDao().getById(model.getId());
		if(entity==null) throw new ResourceNotFound("Generic enrollment not found");
		GenericEnrollmentConveter.modelToEntity( entity, model);
		entity.setUser(account.getAccountId());
		entity.setDateUpdated(LocalDateTime.now());
		daoFactory.getGenericEnrollmentDao().updateGenericEnrollment(entity);
	}

	@Transactional
	public GenericEnrollment getById(UUID id) {
		GenericEnrollmentEntity entity = daoFactory.getGenericEnrollmentDao().getById(id);
		if(entity==null) throw new ResourceNotFound("Generic enrollment not found");
		GenericEnrollment model = GenericEnrollmentConveter.entityToModel(entity);
		return model;
	}

	@Transactional
	public GenericEnrollments getAllGlobalEnrollments( Integer start, Integer maxItems) {
		GenericEnrollments enrollments = new GenericEnrollments();
		List<GenericEnrollmentEntity> enrollmentEntities = daoFactory.getGenericEnrollmentDao().getAllGlobalEnrollments(start, maxItems);
		for(GenericEnrollmentEntity entity : enrollmentEntities) {
			GenericEnrollment model = GenericEnrollmentConveter.entityToModel(entity);
			enrollments.add(model);
		}
		
		Long count = daoFactory.getGenericEnrollmentDao().getAllGlobalEnrollmentsCount();
		
		SortedPagination pagination = new SortedPagination();
		pagination.setFrom(start);
		pagination.setReturned(enrollmentEntities.size());
		pagination.setTotal(count.intValue());
		enrollments.setPagination(pagination);		
		return enrollments;
	}

	@Transactional
	public void delete(UUID id) {
		GenericEnrollmentEntity entity = daoFactory.getGenericEnrollmentDao().getById(id);
		if(entity==null) throw new ResourceNotFound("Generic enrollment not found");
		daoFactory.getGenericEnrollmentDao().deleteGenericEnrollment(entity);
		
		
	}
}
