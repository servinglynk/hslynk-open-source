package com.servinglynk.hmis.warehouse.base.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.SortedPagination;
import com.servinglynk.hmis.warehouse.base.service.GlobalEnrollmentService;
import com.servinglynk.hmis.warehouse.base.service.converter.GlobalEnrollmentConveter;
import com.servinglynk.hmis.warehouse.core.model.Account;
import com.servinglynk.hmis.warehouse.core.model.GlobalEnrollment;
import com.servinglynk.hmis.warehouse.core.model.GlobalEnrollmentMap;
import com.servinglynk.hmis.warehouse.core.model.GlobalEnrollments;
import com.servinglynk.hmis.warehouse.core.model.GlobalEnrollmentsMap;
import com.servinglynk.hmis.warehouse.model.base.GlobalEnrollmentEntity;
import com.servinglynk.hmis.warehouse.model.base.GlobalEnrollmentsMapEntity;
import com.servinglynk.hmis.warehouse.service.exception.ResourceNotFound;

public class GlobalEnrollmentServiceImpl extends ServiceBase implements GlobalEnrollmentService {

	@Override
	@Transactional
	public GlobalEnrollment create(GlobalEnrollment model,Account account) {
		GlobalEnrollmentEntity entity = GlobalEnrollmentConveter.modelToEntity(null, model);
		entity.setUser(account.getAccountId());
		entity.setDateCreated(LocalDateTime.now());
		entity.setDateUpdated(LocalDateTime.now());
		entity.setProjectGroupCode(account.getProjectGroup().getProjectGroupCode());
		daoFactory.getGlobalEnrollmentDao().create(entity);
		model.setId(entity.getId());
		return model;
	}

	@Transactional
	public void update(GlobalEnrollment model,Account account) {
		GlobalEnrollmentEntity entity = daoFactory.getGlobalEnrollmentDao().getById(model.getId());
		if(entity==null) throw new ResourceNotFound("Global enrollment not found");
		GlobalEnrollmentConveter.modelToEntity( entity, model);
		entity.setUser(account.getAccountId());
		entity.setDateUpdated(LocalDateTime.now());
		daoFactory.getGlobalEnrollmentDao().create(entity);
	}

	@Transactional
	public GlobalEnrollment getById(UUID id) {
		GlobalEnrollmentEntity entity = daoFactory.getGlobalEnrollmentDao().getById(id);
		if(entity==null) throw new ResourceNotFound("Global enrollment not found");
		GlobalEnrollment model = GlobalEnrollmentConveter.entityToModel(entity);
		for(GlobalEnrollmentsMapEntity enrollment :  entity.getEnrollments()) {
			model.addEnrollment(GlobalEnrollmentConveter.entityToModel(enrollment));
		}
		return model;
	}

	@Transactional
	public GlobalEnrollments getAllGlobalEnrollments(UUID dedupClientId, Integer start, Integer maxItems) {
		GlobalEnrollments enrollments = new GlobalEnrollments();
		List<GlobalEnrollmentEntity> enrollmentEntities = daoFactory.getGlobalEnrollmentDao().getAllGlobalEnrollments(dedupClientId,start, maxItems);
		for(GlobalEnrollmentEntity entity : enrollmentEntities) {
			GlobalEnrollment model = GlobalEnrollmentConveter.entityToModel(entity);
			for(GlobalEnrollmentsMapEntity enrollment :  entity.getEnrollments()) {
				model.addEnrollment(GlobalEnrollmentConveter.entityToModel(enrollment));
			}
			enrollments.add(model);
		}
		
		Long count = daoFactory.getGlobalEnrollmentDao().getAllGlobalEnrollmentsCount(dedupClientId);
		
		SortedPagination pagination = new SortedPagination();
		pagination.setFrom(start);
		pagination.setReturned(enrollmentEntities.size());
		pagination.setTotal(count.intValue());
		enrollments.setPagination(pagination);		
		return enrollments;
	}

	@Transactional
	public void mapEnrollmentsToGlobalEnrollment(UUID globalEnrollmentId, GlobalEnrollmentsMap enrollments,Account account) {
		GlobalEnrollmentEntity entity = daoFactory.getGlobalEnrollmentDao().getById(globalEnrollmentId);
		if(entity==null) throw new ResourceNotFound("Global enrollment not found");
		daoFactory.getGlobalEnrollmentDao().removeAllEnrollments(globalEnrollmentId);
		List<UUID> enrollmentIds = new ArrayList<UUID>();
		for(GlobalEnrollmentMap enrollment : enrollments.getGlobalEnrollmentMaps()) {
			if(!enrollmentIds.contains(enrollment.getEnrollmentId())) {
				enrollmentIds.add(enrollment.getEnrollmentId());
				GlobalEnrollmentsMapEntity enrollmentsMapEntity = GlobalEnrollmentConveter.modelToEntity(null, enrollment);
				enrollmentsMapEntity.setUser(account.getAccountId());
				enrollmentsMapEntity.setDateCreated(LocalDateTime.now());
				enrollmentsMapEntity.setDateUpdated(LocalDateTime.now());
				enrollmentsMapEntity.setProjectGroupCode(account.getProjectGroup().getProjectGroupCode());
				enrollmentsMapEntity.setGlobalEnrollment(entity);
				daoFactory.getGlobalEnrollmentDao().createEnrollmentMap(enrollmentsMapEntity);
			}
		}
		
	}

	@Transactional
	public void removeEnrollmentsFromGlobalEnrollment(UUID globalEnrollmentId, UUID enrollmentMapId) {
		GlobalEnrollmentEntity entity = daoFactory.getGlobalEnrollmentDao().getById(globalEnrollmentId);
		if(entity==null) throw new ResourceNotFound("Global enrollment not found");
		GlobalEnrollmentsMapEntity mapEntity = daoFactory.getGlobalEnrollmentDao().getByEnrollmetnMapId(globalEnrollmentId,enrollmentMapId);
		if(mapEntity==null) throw new ResourceNotFound("Enrollment mapping not found");
		daoFactory.getGlobalEnrollmentDao().deleteEnrollmentMap(mapEntity);
	}

}
