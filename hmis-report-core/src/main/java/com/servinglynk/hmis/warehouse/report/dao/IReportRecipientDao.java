package com.servinglynk.hmis.warehouse.report.dao;

import java.util.List;

import com.servinglynk.hmis.warehouse.report.persistence.dao.core.IQueryExecutor;
import com.servinglynk.hmis.warehouse.report.persistence.entity.ReportRecipientEntity;

public interface IReportRecipientDao extends IQueryExecutor{
	


	public List<ReportRecipientEntity> findRecipientsByExternalId(String exernalId);


	}
