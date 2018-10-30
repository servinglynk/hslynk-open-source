package com.servinglynk.hmis.warehouse.service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.core.model.EnrollmentEntryLinks;
import com.servinglynk.hmis.warehouse.core.model.EnrollmentLinks;
import com.servinglynk.hmis.warehouse.core.model.ExitActionLink;

public interface EnrollmentLinksService {
//	public void getLinks(UUID clientId,UUID enrollmentId);
	EnrollmentEntryLinks getEntryLinks(UUID clientId,UUID enrollmentId);
	EnrollmentLinks getEnrollmentLinks(UUID clientId,UUID enrollmentId);
	Map<String,List<ExitActionLink>> getExitLinks(UUID clientId,UUID enrollmentId);
}
