package com.servinglynk.hmis.warehouse.service.impl;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.SortedPagination;
import com.servinglynk.hmis.warehouse.client.MessageSender;
import com.servinglynk.hmis.warehouse.core.model.Enrollments;
import com.servinglynk.hmis.warehouse.core.model.HmisHousehold;
import com.servinglynk.hmis.warehouse.core.model.Session;
import com.servinglynk.hmis.warehouse.model.AMQEvent;
import com.servinglynk.hmis.warehouse.model.base.HmisUser;
import com.servinglynk.hmis.warehouse.service.EnrollmentLinksService;
import com.servinglynk.hmis.warehouse.service.EnrollmentService;
import com.servinglynk.hmis.warehouse.service.converter.EnrollmentConveter;
import com.servinglynk.hmis.warehouse.service.exception.AccountNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.ClientNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.EnrollmentNotFound;
import com.servinglynk.hmis.warehouse.service.exception.ProjectNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.ResourceNotFoundException;

public class EnrollmentServiceImpl extends ServiceBase implements EnrollmentService {
	
	@Autowired
	EnrollmentLinksService enrollmentLinksService;
	
	@Autowired MessageSender messageSender;

	@Override
	@Transactional
	public com.servinglynk.hmis.warehouse.core.model.Enrollment createEnrollment(
			com.servinglynk.hmis.warehouse.core.model.Enrollment enrollment,UUID clientId,Boolean updateGenericHouseHold,Session session) {
		com.servinglynk.hmis.warehouse.model.v2020.Client pClient = daoFactory.getClientDao().getClientById(clientId);
		if(pClient==null) throw new ClientNotFoundException();

		com.servinglynk.hmis.warehouse.model.v2020.Project pProject  = daoFactory.getProjectDao().getProjectById(enrollment.getProjectid());
		if(pProject==null) throw new ProjectNotFoundException();
		com.servinglynk.hmis.warehouse.model.v2020.Enrollment pEnrollment = EnrollmentConveter.modelToEntity(enrollment, null);
		pEnrollment.setClient(pClient);
		pEnrollment.setProject(pProject);	
		daoFactory.getProjectDao().populateUserProjectGroupCode(pEnrollment, session.getAccount().getUsername());
		pEnrollment.setDateCreated(LocalDateTime.now());
		pEnrollment.setDateUpdated(LocalDateTime.now());
		
		com.servinglynk.hmis.warehouse.model.v2020.HmisHousehold pHmisHousehold = null;
		
		if(enrollment.getHmisHouseholdId()!=null) {
			pHmisHousehold = daoFactory.getHmisHouseholdDao().getHouseHoldById(enrollment.getHmisHouseholdId());
			if(pHmisHousehold==null) throw new ResourceNotFoundException("HmisHouseHold Not found "+enrollment.getHouseholdid());
		}else {
			HmisHousehold hmisHousehold = new HmisHousehold();
			hmisHousehold.setSourceSystemHouseHoldId(enrollment.getHouseholdid());
			pHmisHousehold = daoFactory.getHmisHouseholdDao().fetchBulkUploadHouseHold(pEnrollment);
		}


		pEnrollment.setHmisHousehold(pHmisHousehold);
		pEnrollment.setGenericHouseHoldId(enrollment.getGenericHouseHoldId());
		
		daoFactory.getEnrollmentDao().createEnrollment(pEnrollment);
		if(enrollment.getGenericHouseHoldId()!=null && updateGenericHouseHold) {
			this.publishGenericHouseHold(enrollment, session);
		}

		enrollment.setEnrollmentId(pEnrollment.getId());
		
		return enrollment;
	}

	@Override
	@Transactional
	public com.servinglynk.hmis.warehouse.core.model.Enrollment updateEnrollment(
			com.servinglynk.hmis.warehouse.core.model.Enrollment enrollment,UUID clientId,String caller) {
		com.servinglynk.hmis.warehouse.model.v2020.Client pClient = daoFactory.getClientDao().getClientById(clientId);
		com.servinglynk.hmis.warehouse.model.v2020.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollment.getEnrollmentId());
		if(pEnrollment == null) throw new EnrollmentNotFound();
		
		if(pClient==null) throw new ClientNotFoundException();
		EnrollmentConveter.modelToEntity(enrollment, pEnrollment);
		
		if(enrollment.getProjectid()!=null) {
			com.servinglynk.hmis.warehouse.model.v2020.Project pProject  = daoFactory.getProjectDao().getProjectById(enrollment.getProjectid());
			if(pProject==null) throw new ProjectNotFoundException();
			pEnrollment.setProject(pProject);
		}
		
		if(enrollment.getHmisHouseholdId()!=null) {
			com.servinglynk.hmis.warehouse.model.v2020.HmisHousehold pHmisHousehold = daoFactory.getHmisHouseholdDao().getHouseHoldById(enrollment.getHmisHouseholdId());
			if(pHmisHousehold==null) throw new ResourceNotFoundException("HmisHouseHold Not found "+enrollment.getHouseholdid());
			pEnrollment.setHmisHousehold(pHmisHousehold);		
		}
		pEnrollment.setClient(pClient);

	 	pEnrollment.setUserId(daoFactory.getHmisUserDao().findByUsername(caller).getId());
		pEnrollment.setDateUpdated((new Date()).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
		daoFactory.getEnrollmentDao().updateEnrollment(pEnrollment);

		return enrollment;
	}

	@Override
	@Transactional
	public com.servinglynk.hmis.warehouse.core.model.Enrollment deleteEnrollment(UUID enrollmentId,UUID clientId,String caller) {

		com.servinglynk.hmis.warehouse.model.v2020.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId);

		if(pEnrollment == null) throw new EnrollmentNotFound();

		daoFactory.getEnrollmentDao().deleteEnrollment(pEnrollment);
		return new com.servinglynk.hmis.warehouse.core.model.Enrollment();
	}

	
	@Transactional
	public com.servinglynk.hmis.warehouse.core.model.Enrollment getEnrollmentByClientIdAndEnrollmentId(
			UUID enrollmentId, UUID clientId) {
		return this.getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false);
	}

	@Transactional
	public com.servinglynk.hmis.warehouse.core.model.Enrollment getEnrollmentByClientIdAndEnrollmentId(
			UUID enrollmentId, UUID clientId,boolean includeChildLinks) {
		com.servinglynk.hmis.warehouse.model.v2020.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId);
		if(pEnrollment == null) throw new EnrollmentNotFound();
		com.servinglynk.hmis.warehouse.core.model.Enrollment model = EnrollmentConveter.entityToModel(pEnrollment);
		if(includeChildLinks) {
			model.setEntryLinks(enrollmentLinksService.getEntryLinks(pEnrollment.getClient().getId(), pEnrollment.getId()));
			model.setEnrollmentLinks(enrollmentLinksService.getEnrollmentLinks(clientId, enrollmentId));
			model.setExitLinks(enrollmentLinksService.getExitLinks(clientId, enrollmentId));
		}
		return model;
	}

	@Override
	@Transactional
	public com.servinglynk.hmis.warehouse.core.model.Enrollment getEnrollmentByEnrollmentId(
			UUID enrollmentId,boolean includeChildLinks) {
		com.servinglynk.hmis.warehouse.model.v2020.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollmentId);
		if(pEnrollment == null) throw new EnrollmentNotFound();
		com.servinglynk.hmis.warehouse.core.model.Enrollment model = EnrollmentConveter.entityToModel(pEnrollment);
		if(includeChildLinks) {
			model.setEntryLinks(enrollmentLinksService.getEntryLinks(pEnrollment.getClient().getId(), pEnrollment.getId()));
			model.setEnrollmentLinks(enrollmentLinksService.getEnrollmentLinks(pEnrollment.getClient().getId(), enrollmentId));
			model.setExitLinks(enrollmentLinksService.getExitLinks(pEnrollment.getClient().getId(), enrollmentId));
		}
		return model;
	}

	@Override
	@Transactional
	public Enrollments getEnrollmentsByClientId(UUID clientId,String loginUser,Integer startIndex, Integer maxItems) {

		HmisUser hmisUser = daoFactory.getAccountDao().findByUsername(loginUser);
		if(hmisUser==null) throw new AccountNotFoundException();

		List<com.servinglynk.hmis.warehouse.model.v2020.Enrollment> pEnrollments = daoFactory.getEnrollmentDao().getEnrollmentsByClientId(clientId,startIndex,maxItems);
//		List<com.servinglynk.hmis.warehouse.model.v2020.Enrollment> sharingEnrollments = daoFactory.getSharingRuleDao().getSharedEnrollments(hmisUser.getId(),hmisUser.getOrganization().getId());
//		if(sharingEnrollments.size()>0){
//			pEnrollments.addAll(sharingEnrollments);
//		}

		Enrollments enrollments = new Enrollments();

		for(com.servinglynk.hmis.warehouse.model.v2020.Enrollment pEnrollment : pEnrollments ){
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
	
	public void publishGenericHouseHold(com.servinglynk.hmis.warehouse.core.model.Enrollment enrollment, Session session) {
		 try {
			  AMQEvent event = new AMQEvent();
			  event.setEventType("enrollment.generichousehold");
			  Map<String, Object> data  = new HashMap<String, Object>();
			  data.put("sessionToken", session.getToken());
			  data.put("clientId",session.getClientTypeId());
			  data.put("userId", session.getAccount().getAccountId());
			  data.put("projectGroupCode", session.getAccount().getProjectGroup().getProjectGroupCode());
			  data.put("enrollemnt", enrollment.toJSONString());
			  data.put("schemaYear", "2020");
			  event.setPayload(data);
			  event.setSubsystem("enrollments");
			  event.setCreatedAt(new Date());
			  messageSender.sendAmqMessage(event);
		 }catch (Exception e) {	
			 e.printStackTrace();
		 }
	}
}