package com.servinglynk.hmis.warehouse.report.persistence.dao.core;

import com.servinglynk.hmis.warehouse.report.dao.IReportLineDao;
import com.servinglynk.hmis.warehouse.report.dao.IReportRecipientDao;
import com.servinglynk.hmis.warehouse.report.scheduler.dao.IWorkerHeaderDao;
import com.servinglynk.hmis.warehouse.report.scheduler.dao.IWorkerLineDao;



public interface IParentDaoFactory {
	
	public IReportLineDao getReportLineDao();

	public IWorkerLineDao getWorkerLineDao();
	public IWorkerHeaderDao getWorkerHeaderDao();
	public IReportRecipientDao getReportRecipientDao();
	
}