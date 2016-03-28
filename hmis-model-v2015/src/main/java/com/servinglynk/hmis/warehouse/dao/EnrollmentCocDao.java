package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.model.v2015.EnrollmentCoc;


public interface EnrollmentCocDao extends ParentDao {
	
	EnrollmentCoc createEnrollmentCoc(EnrollmentCoc enrollmentCoc);
	EnrollmentCoc updateEnrollmentCoc(EnrollmentCoc enrollmentCoc);
	void deleteEnrollmentCoc(EnrollmentCoc enrollmentCoc);
	EnrollmentCoc getEnrollmentCocById(UUID enrollmentCocId);
	List<EnrollmentCoc> getAllEnrollmentCoc(Integer startIndex, Integer maxItems);
	long getEnrollmentCocCount();
	public EnrollmentCoc getEnrollmentCocByDedupEnrollmentCocId(UUID id,String projectGroupCode);

}
