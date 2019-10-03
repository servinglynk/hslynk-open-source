package com.servinglynk.hmis.warehouse.service;

import java.util.UUID;

public interface HistoryService {

	String getEntityHistory(UUID entityId,String entityName, Integer startIndex, Integer maxItems) throws Exception ;
}