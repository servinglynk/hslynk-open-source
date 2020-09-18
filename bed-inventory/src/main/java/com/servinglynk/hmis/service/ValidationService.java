package com.servinglynk.hmis.service;

import java.util.UUID;

public interface ValidationService {
	 UUID validateCleintId(UUID clientId);
	 String validateEnrillment(UUID enrollmentId);
}
