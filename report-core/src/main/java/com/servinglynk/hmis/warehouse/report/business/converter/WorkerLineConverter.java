package com.servinglynk.hmis.warehouse.report.business.converter;

import com.servinglynk.hmis.warehouse.core.model.WorkerLine;
import com.servinglynk.hmis.warehouse.report.persistence.entity.WorkerLineEntity;


public class WorkerLineConverter {

	/* MODEL TO ENTITY CONVERSIONS */
	public static WorkerLineEntity convertModelToEntity(WorkerLine workerLineModel,WorkerLineEntity workerLineEntity) {
		return workerLineEntity;
	}



	public static WorkerLine convertEntityToModel(WorkerLineEntity workerLineEntity) {
		WorkerLine workerLine = new WorkerLine();
		workerLine.setInput(workerLineEntity.getLineInput());
		workerLine.setWorkerLineId(workerLineEntity.getExternalId());
		return workerLine;
	}

}
