package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.model.v2014.HistoryEntityMapping;

public interface HistoryDao {

	List<?> getEntityHistory(UUID entityId,String entityName,String projectGroupCode,Integer startIndex, Integer maxItems);
	
	long getEntityHistoryCount(UUID entityId,String entityName,String projectGroupCode);
	
	HistoryEntityMapping getMapping(String apiName);
}