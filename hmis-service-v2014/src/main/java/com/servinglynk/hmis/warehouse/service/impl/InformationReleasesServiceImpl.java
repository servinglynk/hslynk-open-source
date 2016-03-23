package com.servinglynk.hmis.warehouse.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.common.ValidationUtil;
import com.servinglynk.hmis.warehouse.core.model.Project;
import com.servinglynk.hmis.warehouse.core.model.InformationRelease;
import com.servinglynk.hmis.warehouse.core.model.exception.MissingParameterException;
import com.servinglynk.hmis.warehouse.model.v2014.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2014.ReleaseOfInfoEntity;
import com.servinglynk.hmis.warehouse.service.InformationReleasesService;
import com.servinglynk.hmis.warehouse.service.exception.EnrollmentNotFound;
import com.servinglynk.hmis.warehouse.service.exception.ProfileNotFoundException;

public class InformationReleasesServiceImpl extends ServiceBase implements InformationReleasesService {

	
	@Transactional
	public InformationRelease createReleaseOfInfo(InformationRelease releaseOfInfo, String caller) {

		if (ValidationUtil.isNull(releaseOfInfo.getEnrollmentId()))
			throw new MissingParameterException("Enrollment Id required");

		if (ValidationUtil.isNull(releaseOfInfo.isConsented()))
			throw new MissingParameterException("Consented required");

		Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(releaseOfInfo.getEnrollmentId());

		if (pEnrollment == null)
			throw new EnrollmentNotFound();

		for (Project project : releaseOfInfo.getProjects()) {

			com.servinglynk.hmis.warehouse.model.v2014.Project pProject = daoFactory.getProjectDao()
					.getProjectById(project.getProjectId());

			if (pProject == null)
				throw new ProfileNotFoundException();

			ReleaseOfInfoEntity releaseOfInfoEntity = new ReleaseOfInfoEntity();
			releaseOfInfoEntity.setConsented(releaseOfInfo.isConsented());
			releaseOfInfoEntity.setEnrollment(pEnrollment);
			releaseOfInfoEntity.setCreatedAt(new Date());
			releaseOfInfoEntity.setCreatedBy(caller);

			daoFactory.getInformationReleasesDao().createReleaseOfInfo(releaseOfInfoEntity);
		}
		// releaseOfInfo.setRoleaseOfInfoId(releaseOfInfoEntity.getId());

		return releaseOfInfo;
	}

	@Transactional
	public InformationRelease updateReleaseOfInfo(InformationRelease releaseOfInfo, String caller) {

		if (ValidationUtil.isNull(releaseOfInfo.getEnrollmentId()))
			throw new MissingParameterException("Enrollment Id required");

		if (ValidationUtil.isNull(releaseOfInfo.isConsented()))
			throw new MissingParameterException("Consented required");

		deleteReleaseOfInfo(releaseOfInfo.getEnrollmentId());
		createReleaseOfInfo(releaseOfInfo, caller);
		
		return releaseOfInfo;
	}

	@Transactional
	public InformationRelease deleteReleaseOfInfo(UUID enrollmentId) {

		if (ValidationUtil.isNull(enrollmentId))
			throw new MissingParameterException("Enrollment Id required");
		
		Enrollment enrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollmentId);
		
		if(enrollment == null) throw new EnrollmentNotFound();

		List<ReleaseOfInfoEntity> entities = daoFactory.getInformationReleasesDao().getreleaseOfInfoEntityByEnrollment(enrollmentId);

		for(ReleaseOfInfoEntity entity : entities)
		{
		daoFactory.getInformationReleasesDao().deleteReleaseOfInfo(entity);
		}
		return new InformationRelease();
	}

}
