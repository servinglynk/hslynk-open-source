package com.servinglynk.hmis.warehouse.report.scheduler.dao;

import java.util.List;

import com.servinglynk.hmis.warehouse.report.persistence.dao.core.IQueryExecutor;
import com.servinglynk.hmis.warehouse.report.persistence.entity.WorkerLineEntity;

public interface IWorkerLineDao extends IQueryExecutor{
	
	public List<WorkerLineEntity> findUnprocessedByExternalId(String exernalId);

}
