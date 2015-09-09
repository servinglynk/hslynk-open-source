package com.servinglynk.hmis.warehouse.report.dao;

import java.util.List;

import com.servinglynk.hmis.warehouse.report.persistence.dao.core.IQueryExecutor;
import com.servinglynk.hmis.warehouse.report.persistence.entity.ReportHeaderEntity;
import com.servinglynk.hmis.warehouse.report.persistence.entity.ReportLineEntity;

public interface IReportLineDao extends IQueryExecutor{
	


	public List<ReportLineEntity> findReportLine(String externalId,Integer version);
	public ReportHeaderEntity findReportHeader(String externalId) throws Exception;


	}
