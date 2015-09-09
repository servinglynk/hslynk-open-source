package com.servinglynk.hmis.warehouse.report.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.servinglynk.hmis.warehouse.report.persistence.dao.core.QueryExecutor;
import com.servinglynk.hmis.warehouse.report.persistence.entity.ReportRecipientEntity;

public class ReportRecipientDao extends QueryExecutor  implements IReportRecipientDao{ 
	
	public List<ReportRecipientEntity> findRecipientsByExternalId(String externalId){
		DetachedCriteria query = DetachedCriteria.forClass(ReportRecipientEntity.class);
		query.createAlias("reportHeaderEntity", "reportHeaderEntity");
		query.add(Restrictions.eq("reportHeaderEntity.externalId",externalId));
		return (List<ReportRecipientEntity>) findByCriteria(query);
	}


	}
