package com.servinglynk.hmis.warehouse.service;

import java.util.UUID;

import com.servinglynk.hmis.warehouse.core.model.InformationRelease;

public interface InformationReleasesService {

	public InformationRelease createReleaseOfInfo(InformationRelease informationRelease,String caller);
	public InformationRelease updateReleaseOfInfo(InformationRelease informationRelease,String caller);
	public InformationRelease deleteReleaseOfInfo(UUID enrollmentId);
}
