package com.servinglynk.hmis.warehouse.notification.scheduler.dao;

import java.util.List;

import com.servinglynk.hmis.warehouse.notification.persistence.dao.core.IQueryExecutor;
import com.servinglynk.hmis.warehouse.notification.persistence.entity.WorkerLineEntity;

public interface IWorkerLineDao extends IQueryExecutor{
	
	public List<WorkerLineEntity> findUnprocessedByExternalId(String exernalId);

}
