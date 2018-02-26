package com.servinglynk.hmis.warehouse.notification.business.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.servinglynk.hmis.warehouse.core.model.WorkerLine;
import com.servinglynk.hmis.warehouse.notification.business.exception.WorkerNotFoundException;
import com.servinglynk.hmis.warehouse.notification.business.service.core.ParentService;
import com.servinglynk.hmis.warehouse.notification.common.Constants;
import com.servinglynk.hmis.warehouse.notification.common.CoreUtil;
import com.servinglynk.hmis.warehouse.notification.persistence.entity.WorkerHeaderEntity;
import com.servinglynk.hmis.warehouse.notification.persistence.entity.WorkerLineEntity;

@Service
@Transactional
public class WorkerService extends ParentService implements IWorkerService{
	
	final static Logger logger = Logger.getLogger(WorkerService.class);
	
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
		workerLineEntity.setNotificationId(workerLine.getNotificationId());
		daoFactory.getWorkerLineDao().insert(workerLineEntity);
		workerLine.setWorkerLineId(workerLineEntity.getExternalId());
	}
	
	

	public void processWorkerLine() throws WorkerNotFoundException
	{		
		
	}
	
	private WorkerHeaderEntity loadWorkerHeader(WorkerLine workerLine) throws WorkerNotFoundException{
		List<WorkerHeaderEntity> workerHeaderEntityList = daoFactory.getWorkerHeaderDao().findByExternalId(workerLine.getWorkerHeaderId());
		if( workerHeaderEntityList.isEmpty())	{
			logger.error("Exception : Worker Header Not found :"+ workerLine.getWorkerHeaderId());
			throw new WorkerNotFoundException();
			
		}
		return workerHeaderEntityList.get(0);		
	}
	
}
