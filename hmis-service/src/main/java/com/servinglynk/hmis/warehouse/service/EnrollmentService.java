package com.servinglynk.hmis.warehouse.service;

import java.util.UUID;

import com.servinglynk.hmis.warehouse.core.model.ReleaseOfInfo;

public interface EnrollmentService {

	public ReleaseOfInfo createReleaseOfInfo(ReleaseOfInfo releaseOfInfo,String caller);
	public ReleaseOfInfo updateReleaseOfInfo(ReleaseOfInfo releaseOfInfo,String caller);
	public ReleaseOfInfo deleteReleaseOfInfo(UUID enrollmentId);
}
