package com.servinglynk.hmis.warehouse.base.dao;

import java.util.List;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.model.base.BulkUpload;

@Transactional
public class BulkUploaderWorkerDaoImpl extends BaseDaoImpl<BulkUpload> implements BulkUploaderWorkerDao {

	public List<BulkUpload> findUnProcessedUploads(String status) throws Exception{
		DetachedCriteria query = DetachedCriteria.forClass(BulkUpload.class);
		query.add(Restrictions.eq("status","INITIAL"));
		query.add(Restrictions.eq("deleted",false));
		query.addOrder( Order.desc("dateCreated") );
		List<BulkUpload> list = (List<BulkUpload>) findByCriteria(query);
		return list;
	}
	public List<BulkUpload> findBulkUploadByStatus(String status) throws Exception{
		DetachedCriteria query = DetachedCriteria.forClass(BulkUpload.class);
		query.add(Restrictions.eq("status",status));
		query.add(Restrictions.eq("deleted",false));
		query.addOrder( Order.desc("dateCreated") );
		List<BulkUpload> list = (List<BulkUpload>) findByCriteriaWithOutDelete(query);
		return list;
	}
	public List<BulkUpload> findBulkUploadByStatusAndYear(String status,Long year) throws Exception{
		DetachedCriteria query = DetachedCriteria.forClass(BulkUpload.class);
		query.add(Restrictions.eq("status",status));
		query.add(Restrictions.eq("year",year));
		query.add(Restrictions.eq("deleted",false));
		query.addOrder( Order.desc("dateCreated") );
		List<BulkUpload> list = (List<BulkUpload>) findByCriteriaWithOutDelete(query);
		return list;
	}
	public List<BulkUpload> findBulkUploadForDevelopers(String status,UUID userId,String projectGroup) throws Exception{
		DetachedCriteria query = DetachedCriteria.forClass(BulkUpload.class);
		query.add(Restrictions.eq("status",status));
		query.createAlias("user", "user");
		//query.add(Restrictions.eq("user.id", userId));
		if(StringUtils.equals("DELETED", status)) {
			query.add(Restrictions.eq("deleted",true));
		}
		List<BulkUpload> list = (List<BulkUpload>) findByCriteriaWithOutDelete(query);
		return list;
	}
	public List<BulkUpload> findBulkUploadForCustAdmin(String status,UUID userId,String projectGroup) throws Exception{
		DetachedCriteria query = DetachedCriteria.forClass(BulkUpload.class);
		query.add(Restrictions.eq("status",status));
		query.createAlias("user", "user");
	//	query.add(Restrictions.eq("user.id", userId));
		query.add(Restrictions.eq("deleted",false));
		query.addOrder( Order.desc("dateCreated") );
		query.addOrder( Order.desc("id") );
		List<BulkUpload> list = (List<BulkUpload>) findByCriteria(query);
		return list;
	}
	public List<BulkUpload> findBulkUploadFoSuperAdmin(String status) throws Exception{
		DetachedCriteria query = DetachedCriteria.forClass(BulkUpload.class);
		query.add(Restrictions.eq("status",status));
		query.add(Restrictions.eq("deleted",false));
		query.addOrder( Order.desc("dateCreated") );
		query.addOrder( Order.desc("id") );
		List<BulkUpload> list = (List<BulkUpload>) findByCriteria(query);
		return list;
	}
	public List<BulkUpload> findBulkUploadByProjectGroupCode(String projectGroupCode) throws Exception{
		DetachedCriteria query = DetachedCriteria.forClass(BulkUpload.class);
		query.add(Restrictions.eq("projectGroupCode",projectGroupCode));
		query.add(Restrictions.eq("status","LIVE"));
		query.add(Restrictions.eq("deleted",false));
		query.addOrder( Order.desc("dateCreated") );
		query.addOrder( Order.desc("id") );
		List<BulkUpload> list = (List<BulkUpload>) findByCriteria(query);
		return list;
	}
	public List<BulkUpload> getRecentUploads(String projectGroupCode,UUID userId,Integer startIndex, Integer maxItems) throws Exception{
		DetachedCriteria query = DetachedCriteria.forClass(BulkUpload.class);
		query.add(Restrictions.eq("projectGroupCode",projectGroupCode));
		query.add(Restrictions.eq("deleted",false));
		query.createAlias("user", "user");
		//query.add(Restrictions.eq("user.id", userId));
		query.addOrder( Order.desc("id") );
		List<BulkUpload> list = (List<BulkUpload>) findByCriteria(query,startIndex,maxItems);
		return list;
	}
	
	public List<BulkUpload> findBulkUploadByProjectGroupCodeAndYear(String projectGroupCode,Long year) throws Exception{
		DetachedCriteria query = DetachedCriteria.forClass(BulkUpload.class);
		query.add(Restrictions.eq("projectGroupCode",projectGroupCode));
		query.add(Restrictions.eq("status","LIVE"));
		query.add(Restrictions.eq("year",year));
		List<BulkUpload> list = (List<BulkUpload>) findByCriteria(query);
		return list;
	}
}
