package com.servinglynk.hmis.warehouse.base.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.servinglynk.hmis.warehouse.model.base.ReportConfigParamEntity;

public class ReportConfigParamDaoImpl extends QueryExecutorImpl implements ReportConfigParamDao {

	@Override
	public ReportConfigParamEntity createReportConfigParam(ReportConfigParamEntity ReportConfigParamEntity) {
		insert(ReportConfigParamEntity);
		return ReportConfigParamEntity;
	}

	@Override
	public ReportConfigParamEntity updateReportConfigParam(ReportConfigParamEntity ReportConfigParamEntity) {
		update(ReportConfigParamEntity);
		return ReportConfigParamEntity;
	}

	@Override
	public void deleteReportConfigParam(ReportConfigParamEntity reportConfigParamEntity) {
		delete(reportConfigParamEntity);
	}

	@Override
	public ReportConfigParamEntity getReportConfigParamByid(Long id) {
		return (ReportConfigParamEntity) get(ReportConfigParamEntity.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ReportConfigParamEntity> getReportConfigParams(Long id) {
		DetachedCriteria criteria=DetachedCriteria.forClass(ReportConfigParamEntity.class);
		criteria.add(Restrictions.eq("reportConfigId", id));
		return (List<ReportConfigParamEntity>) findByCriteria(criteria);
	}
}
