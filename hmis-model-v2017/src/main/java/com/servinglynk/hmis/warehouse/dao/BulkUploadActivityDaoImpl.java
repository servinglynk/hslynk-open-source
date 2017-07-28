package com.servinglynk.hmis.warehouse.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.servinglynk.hmis.warehouse.base.dao.QueryExecutorImpl;
import com.servinglynk.hmis.warehouse.model.v2017.BulkUploadActivity;

public class BulkUploadActivityDaoImpl extends QueryExecutorImpl implements BulkUploadActivityDao {

	public List<BulkUploadActivity> getBulkUploadActivityByUploadId(Long bulkUploadId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(BulkUploadActivity.class);
		criteria.add(Restrictions.eq("bulkUploadId",bulkUploadId));
		return (List<BulkUploadActivity>) findByCriteria(criteria);
	}
}
