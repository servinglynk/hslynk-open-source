package com.servinglynk.hmis.warehouse.service.impl;

import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.SortedPagination;
import com.servinglynk.hmis.warehouse.core.model.Enrollments;
import com.servinglynk.hmis.warehouse.model.base.HmisUser;
import com.servinglynk.hmis.warehouse.model.v2017.Client;
import com.servinglynk.hmis.warehouse.service.EnrollmentService;
import com.servinglynk.hmis.warehouse.service.converter.EnrollmentConveter;
import com.servinglynk.hmis.warehouse.service.exception.AccountNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.ClientNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.EnrollmentNotFound;
import com.servinglynk.hmis.warehouse.service.exception.ProjectNotFoundException;

public class EnrollmentServiceImpl extends ServiceBase implements EnrollmentService {

	@Override
	@Transactional
	public com.servinglynk.hmis.warehouse.core.model.Enrollment createEnrollment(
			com.servinglynk.hmis.warehouse.core.model.Enrollment enrollment,UUID clientId,String caller) {
		com.servinglynk.hmis.warehouse.model.v2017.Client pClient = daoFactory.getClientDao().getClientById(clientId);
		if(pClient==null) throw new ClientNotFoundException();

		com.servinglynk.hmis.warehouse.model.v2017.Project pProject  = daoFactory.getProjectDao().getProjectById(enrollment.getProjectid());
		if(pProject==null) throw new ProjectNotFoundException();


		com.servinglynk.hmis.warehouse.model.v2017.Enrollment pEnrollment = EnrollmentConveter.modelToEntity(enrollment, null);
		pEnrollment.setClient(pClient);
		pEnrollment.setProject(pProject);
		daoFactory.getProjectDao().populateUserProjectGroupCode(pEnrollment, caller);
		pEnrollment.setDateCreated((new Date()).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
		daoFactory.getEnrollmentDao().createEnrollment(pEnrollment);

		enrollment.setEnrollmentId(pEnrollment.getId());
		return enrollment;
	}

	@Override
	@Transactional
	public com.servinglynk.hmis.warehouse.core.model.Enrollment updateEnrollment(
			com.servinglynk.hmis.warehouse.core.model.Enrollment enrollment,UUID clientId,String caller) {
		com.servinglynk.hmis.warehouse.model.v2017.Client pClient = daoFactory.getClientDao().getClientById(clientId);
		if(pClient==null) throw new ClientNotFoundException();

		com.servinglynk.hmis.warehouse.model.v2017.Project pProject  = daoFactory.getProjectDao().getProjectById(enrollment.getProjectid());
		if(pProject==null) throw new ProjectNotFoundException();

		com.servinglynk.hmis.warehouse.model.v2017.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollment.getEnrollmentId());
		if(pEnrollment == null) throw new EnrollmentNotFound();

		EnrollmentConveter.modelToEntity(enrollment, pEnrollment);
		pEnrollment.setClient(pClient);
		pEnrollment.setProject(pProject);
	 	pEnrollment.setUserId(daoFactory.getHmisUserDao().findByUsername(caller).getId());
		pEnrollment.setDateUpdated((new Date()).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
		daoFactory.getEnrollmentDao().updateEnrollment(pEnrollment);

		return enrollment;
	}

	@Override
	@Transactional
	public com.servinglynk.hmis.warehouse.core.model.Enrollment deleteEnrollment(UUID enrollmentId,UUID clientId,String caller) {

		com.servinglynk.hmis.warehouse.model.v2017.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId);

		if(pEnrollment == null) throw new EnrollmentNotFound();

		daoFactory.getEnrollmentDao().deleteEnrollment(pEnrollment);
		Client client = pEnrollment.getClient();
		daoFactory.getClientDao().deleteClient(client);
		return new com.servinglynk.hmis.warehouse.core.model.Enrollment();
	}

	@Override
	@Transactional
	public com.servinglynk.hmis.warehouse.core.model.Enrollment getEnrollmentByClientIdAndEnrollmentId(
			UUID enrollmentId, UUID clientId) {
		com.servinglynk.hmis.warehouse.model.v2017.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId);
		if(pEnrollment == null) throw new EnrollmentNotFound();

		return EnrollmentConveter.entityToModel(pEnrollment);
	}

	@Override
	@Transactional
	public com.servinglynk.hmis.warehouse.core.model.Enrollment getEnrollmentByEnrollmentId(
			UUID enrollmentId) {
		com.servinglynk.hmis.warehouse.model.v2017.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollmentId);
		if(pEnrollment == null) throw new EnrollmentNotFound();

		return EnrollmentConveter.entityToModel(pEnrollment);
	}

	@Override
	@Transactional
	public Enrollments getEnrollmentsByClientId(UUID clientId,String loginUser,Integer startIndex, Integer maxItems) {

		HmisUser hmisUser = daoFactory.getAccountDao().findByUsername(loginUser);
		if(hmisUser==null) throw new AccountNotFoundException();

		List<com.servinglynk.hmis.warehouse.model.v2017.Enrollment> pEnrollments = daoFactory.getEnrollmentDao().getEnrollmentsByClientId(clientId,startIndex,maxItems);
//		List<com.servinglynk.hmis.warehouse.model.v2017.Enrollment> sharingEnrollments = daoFactory.getSharingRuleDao().getSharedEnrollments(hmisUser.getId(),hmisUser.getOrganization().getId());
//		if(sharingEnrollments.size()>0){
//			pEnrollments.addAll(sharingEnrollments);
//		}

		Enrollments enrollments = new Enrollments();

		for(com.servinglynk.hmis.warehouse.model.v2017.Enrollment pEnrollment : pEnrollments ){
			enrollments.addEnrollment(EnrollmentConveter.entityToModel(pEnrollment));
		}




        long count = daoFactory.getEnrollmentDao().getEnrollmentCount(clientId);
        SortedPagination pagination = new SortedPagination();

        pagination.setFrom(startIndex);
        pagination.setReturned(enrollments.getEnrollments().size());
        pagination.setTotal((int)count);
        enrollments.setPagination(pagination);


		return enrollments;
	}
}
