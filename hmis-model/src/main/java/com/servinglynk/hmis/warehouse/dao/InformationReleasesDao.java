package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.model.live.ReleaseOfInfoEntity;

public interface InformationReleasesDao {

	public ReleaseOfInfoEntity createReleaseOfInfo(ReleaseOfInfoEntity releaseOfInfoEntity);
	public ReleaseOfInfoEntity updateReleaseOfInfo(ReleaseOfInfoEntity releaseOfInfoEntity);
	public void deleteReleaseOfInfo(ReleaseOfInfoEntity releaseOfInfoEntity);
	public List<ReleaseOfInfoEntity> getreleaseOfInfoEntityByEnrollment(UUID enrollmentId);
	
}
