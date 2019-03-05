package com.servinglynk.hmis.warehouse.report.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.report.persistence.dao.core.QueryExecutor;
import com.servinglynk.hmis.warehouse.report.persistence.entity.ReportHeaderEntity;
import com.servinglynk.hmis.warehouse.report.persistence.entity.ReportLineEntity;

@Transactional
public class ReportLineDao extends QueryExecutor implements IReportLineDao {


	public ReportHeaderEntity findReportHeader(String externalId) throws Exception{
		DetachedCriteria query = DetachedCriteria.forClass(ReportHeaderEntity.class);
		query.add(Restrictions.eq("externalId",externalId));
		List<ReportHeaderEntity> list = (List<ReportHeaderEntity>) findByCriteria(query);
		if(!list.isEmpty()) return (ReportHeaderEntity) list.get(0);
		return null;
	}

	public List<ReportLineEntity> findReportLine(String externalId, Integer version) {
		DetachedCriteria query = DetachedCriteria.forClass(ReportLineEntity.class);
		query.createAlias("reportHeader", "reportHeader");
		query.add(Restrictions.eq("reportHeader.externalId",externalId));

		//if version is passed get the report for the version or get the latest versioned report
		if(version==null) query.addOrder(Order.desc("version"));
			else
		query.add(Restrictions.eq("version", version));
		
		return (List<ReportLineEntity>) findByCriteria(query);

	}

}
