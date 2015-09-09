package com.servinglynk.hmis.warehouse.report.persistence.dao.core;

import org.springframework.beans.factory.annotation.Autowired;

import com.servinglynk.hmis.warehouse.report.dao.IAHARDao;
import com.servinglynk.hmis.warehouse.report.dao.IReportLineDao;
import com.servinglynk.hmis.warehouse.report.dao.IReportRecipientDao;
import com.servinglynk.hmis.warehouse.report.scheduler.dao.IWorkerHeaderDao;
import com.servinglynk.hmis.warehouse.report.scheduler.dao.IWorkerLineDao;


public class ParentDaoFactory implements IParentDaoFactory {
	


	@Autowired
	private IWorkerLineDao workerLineDao;

	public IWorkerLineDao getWorkerLineDao() {
		return workerLineDao;
	}

	public void setWorkerLineDao(IWorkerLineDao workerLineDao) {
		this.workerLineDao = workerLineDao;
	}

	@Autowired
	private IWorkerHeaderDao workerHeaderDao;

	public IWorkerHeaderDao getWorkerHeaderDao() {
		return workerHeaderDao;
	}

	public void setWorkerHeaderDao(IWorkerHeaderDao workerHeaderDao) {
		this.workerHeaderDao = workerHeaderDao;
	}
	

	@Autowired
	private IReportLineDao reportLineDao;

	public IReportLineDao getReportLineDao() {
		return reportLineDao;
	}

	public void setReportLineDao(IReportLineDao reportLineDao) {
		this.reportLineDao = reportLineDao;
	}
	

	@Autowired
	private IAHARDao demandForecastDao;

	public IAHARDao getDemandForecastDao() {
		return demandForecastDao;
	}

	public void setDemandForecastDao(IAHARDao demandForecastDao) {
		this.demandForecastDao = demandForecastDao;
	}
	
	

	@Autowired
	private IReportRecipientDao reportRecipientDao;

	public IReportRecipientDao getReportRecipientDao() {
		return reportRecipientDao;
	}

	public void setReportRecipientDao(IReportRecipientDao reportRecipientDao) {
		this.reportRecipientDao = reportRecipientDao;
	}


	



	
	
}
