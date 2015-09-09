package com.servinglynk.hmis.warehouse.report.dao;

import java.util.List;

import com.servinglynk.hmis.warehouse.core.model.AHARModel;
import com.servinglynk.hmis.warehouse.report.persistence.dao.core.IParentDao;


public interface IAHARDao extends IParentDao {

	public List<String> getAHARReportData(AHARModel dfm);
}