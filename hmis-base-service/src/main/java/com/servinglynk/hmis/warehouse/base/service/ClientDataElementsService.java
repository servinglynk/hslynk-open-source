package com.servinglynk.hmis.warehouse.base.service;

import java.util.UUID;

import com.servinglynk.hmis.warehouse.core.model.Parameters;

public interface ClientDataElementsService {

	Parameters getClientDataElements(UUID clientId);
}