package com.servinglynk.hmis.warehouse.notification.scheduler.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import com.servinglynk.hmis.warehouse.notification.common.Constants;
import com.servinglynk.hmis.warehouse.notification.persistence.dao.core.QueryExecutor;
import com.servinglynk.hmis.warehouse.notification.persistence.entity.WorkerLineEntity;


public class WorkerLineDao extends QueryExecutor implements IWorkerLineDao{
	
	public WorkerLineDao() {
		super();
	}
	
	
	public List<WorkerLineEntity> findUnprocessedByExternalId(String externalId) {
		DetachedCriteria query = DetachedCriteria.forClass(WorkerLineEntity.class);
		query.add(Property.forName("status").eq(Constants.JOB_CREATED));
		query.createAlias("workerHeader", "workerHeader");
		query.add(Restrictions.eq("workerHeader.externalId",externalId));
		query.add(Restrictions.geProperty("maxRetry", "currRetry"));
		return (List<WorkerLineEntity>) findByCriteria(query);

	}

}
