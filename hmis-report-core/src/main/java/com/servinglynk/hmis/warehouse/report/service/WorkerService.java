package com.servinglynk.hmis.warehouse.report.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.core.model.WorkerLine;
import com.servinglynk.hmis.warehouse.report.business.exception.WorkerNotFoundException;
import com.servinglynk.hmis.warehouse.report.business.service.core.ParentService;
import com.servinglynk.hmis.warehouse.report.common.Constants;
import com.servinglynk.hmis.warehouse.report.common.CoreUtil;
import com.servinglynk.hmis.warehouse.report.persistence.entity.WorkerHeaderEntity;
import com.servinglynk.hmis.warehouse.report.persistence.entity.WorkerLineEntity;

@Service
@Transactional
public class WorkerService extends ParentService implements IWorkerService{
	

	public void createWorkerLine(WorkerLine workerLine) throws WorkerNotFoundException {

		WorkerHeaderEntity workerHeader = loadWorkerHeader(workerLine);
		WorkerLineEntity workerLineEntity = new WorkerLineEntity();
		workerLineEntity.setCurrRetry(0);
		workerLineEntity.setExternalId(CoreUtil.createUniqueID(false));
		workerLineEntity.setWorkerHeader(workerHeader);
		workerLineEntity.setMaxRetry(workerHeader.getMaxRetry());
		workerLineEntity.setRetryInterval(workerHeader.getRetryInterval());
		workerLineEntity.setStatus(Constants.JOB_CREATED);
		workerLineEntity.setLineInput(workerLine.getInput());
		workerLineEntity.setInsertAt(new Date());
		workerLineEntity.setInsertBy(Constants.REPORT_SERVICE);
		daoFactory.getWorkerLineDao().insert(workerLineEntity);
		workerLine.setWorkerLineId(workerLineEntity.getExternalId());
	}
	

	private WorkerHeaderEntity loadWorkerHeader(WorkerLine workerLine) throws WorkerNotFoundException{
		List<WorkerHeaderEntity> workerHeaderEntityList = daoFactory.getWorkerHeaderDao().findByExternalId(workerLine.getWorkerHeaderId());
		if( workerHeaderEntityList.isEmpty())	throw new WorkerNotFoundException();
		return workerHeaderEntityList.get(0);		
	}
	
}
