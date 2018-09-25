package com.servinglynk.hmis.warehouse.service;

import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.core.model.EnrollmentEntryLinks;
import com.servinglynk.hmis.warehouse.core.model.EnrollmentLinks;
import com.servinglynk.hmis.warehouse.core.model.ExitActionLink;

public interface EnrollmentLinksService {

	EnrollmentEntryLinks getEntryLinks(UUID clientId,UUID enrollmentId);
	EnrollmentLinks getEnrollmentLinks(UUID clientId,UUID enrollmentId);
	List<ExitActionLink> getExitLinks(UUID clientId,UUID enrollmentId);
}
