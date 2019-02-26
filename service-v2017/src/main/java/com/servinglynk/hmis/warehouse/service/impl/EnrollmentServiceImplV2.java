package com.servinglynk.hmis.warehouse.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.SortedPagination;
import com.servinglynk.hmis.warehouse.core.model.EnrollmentCocs;
import com.servinglynk.hmis.warehouse.core.model.Enrollments;
import com.servinglynk.hmis.warehouse.model.base.HmisUser;
import com.servinglynk.hmis.warehouse.service.EnrollmentServiceV2;
import com.servinglynk.hmis.warehouse.service.converter.EnrollmentConveter;
import com.servinglynk.hmis.warehouse.service.exception.AccountNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.EnrollmentNotFound;

public class EnrollmentServiceImplV2 extends ServiceBase implements EnrollmentServiceV2 {


	@Override
	@Transactional
	public com.servinglynk.hmis.warehouse.core.model.Enrollment getEnrollmentByClientIdAndEnrollmentId(
			UUID enrollmentId, UUID clientId) {
		com.servinglynk.hmis.warehouse.model.v2017.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId);
		if(pEnrollment == null) throw new EnrollmentNotFound();

		return EnrollmentConveter.entityToModelv2(pEnrollment);
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
			enrollments.addEnrollment(EnrollmentConveter.entityToModelv2(pEnrollment));
		}




        long count = daoFactory.getEnrollmentDao().getEnrollmentCount(clientId);
        SortedPagination pagination = new SortedPagination();

        pagination.setFrom(startIndex);
        pagination.setReturned(enrollments.getEnrollments().size());
        pagination.setTotal((int)count);
        enrollments.setPagination(pagination);


		return enrollments;
	}
	
	
	public void generateLinks(UUID enrollmentId) {
		EnrollmentCocs enrollmentCocs = serviceFactory.getEnrollmentCocService().getAllEnrollmentEnrollmentCocs(enrollmentId, null, null);
		
	}
}
