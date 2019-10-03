package com.servinglynk.hmis.warehouse.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.servinglynk.hmis.warehouse.base.dao.QueryExecutorImpl;
import com.servinglynk.hmis.warehouse.model.v2020.Error2020;

public class BulkUploadErrorDaoImpl extends QueryExecutorImpl implements BulkUploadErrorDao {

	public List<Error2020> getBulkUploadErrorByUploadId(Long bulkUploadId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Error2020.class);
		criteria.add(Restrictions.eq("bulk_upload_ui",bulkUploadId));
		criteria.addOrder( Order.desc("type") );
		return (List<Error2020>) findByCriteria(criteria);
	}
}
