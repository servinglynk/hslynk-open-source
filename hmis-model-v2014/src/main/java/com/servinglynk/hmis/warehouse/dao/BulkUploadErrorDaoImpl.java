package com.servinglynk.hmis.warehouse.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.servinglynk.hmis.warehouse.base.dao.QueryExecutorImpl;
import com.servinglynk.hmis.warehouse.model.v2014.Error2014;

public class BulkUploadErrorDaoImpl extends QueryExecutorImpl implements BulkUploadErrorDao {

	public List<Error2014> getBulkUploadErrorByUploadId(Long bulkUploadId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Error2014.class);
		criteria.add(Restrictions.eq("bulk_upload_ui",bulkUploadId));
		criteria.addOrder( Order.desc("type") );
		return (List<Error2014>) findByCriteria(criteria);
	}
}
