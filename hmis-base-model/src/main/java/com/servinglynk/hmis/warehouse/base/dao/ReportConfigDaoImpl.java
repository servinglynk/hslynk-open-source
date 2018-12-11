package com.servinglynk.hmis.warehouse.base.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.servinglynk.hmis.warehouse.model.base.ReportConfigEntity;

public class ReportConfigDaoImpl extends QueryExecutorImpl implements ReportConfigDao {

	@Override
	public ReportConfigEntity createReportConfig(ReportConfigEntity reportConfigEntity) {
		insert(reportConfigEntity);
		return reportConfigEntity;
	}

	@Override
	public ReportConfigEntity updateReportConfig(ReportConfigEntity reportConfigEntity) {
		update(reportConfigEntity);
		return reportConfigEntity;
	}

	@Override
	public void deleteReportConfig(ReportConfigEntity reportConfigEntity) {
		delete(reportConfigEntity);
	}

	@Override
	public ReportConfigEntity getReportConfigByid(Long id) {
		return (ReportConfigEntity) get(ReportConfigEntity.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ReportConfigEntity> getReportConfigs(String projectGroupCode) {
		DetachedCriteria criteria=DetachedCriteria.forClass(ReportConfigEntity.class);
		criteria.add(Restrictions.eq("projectGroupCode", projectGroupCode));
		return (List<ReportConfigEntity>) findByCriteria(criteria);
	}
}
