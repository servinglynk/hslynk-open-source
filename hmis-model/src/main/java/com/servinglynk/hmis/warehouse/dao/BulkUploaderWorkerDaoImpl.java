package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.hadoop.hbase.thrift2.generated.THBaseService.Iface;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.model.live.BulkUpload;

@Transactional
public class BulkUploaderWorkerDaoImpl extends ParentDaoImpl implements BulkUploaderWorkerDao {

	public List<BulkUpload> findUnProcessedUploads(String status) throws Exception{
		DetachedCriteria query = DetachedCriteria.forClass(BulkUpload.class);
		query.add(Restrictions.eq("status","INITIAL"));
		List<BulkUpload> list = (List<BulkUpload>) findByCriteria(query);
		return list;
	}
	public List<BulkUpload> findBulkUploadByStatus(String status) throws Exception{
		DetachedCriteria query = DetachedCriteria.forClass(BulkUpload.class);
		query.add(Restrictions.eq("status",status));
		List<BulkUpload> list = (List<BulkUpload>) findByCriteria(query);
		return list;
	}
	
	public List<BulkUpload> findBulkUploadForDevelopers(String status,UUID userId,String projectGroup) throws Exception{
		DetachedCriteria query = DetachedCriteria.forClass(BulkUpload.class);
		query.add(Restrictions.eq("status",status));
		query.createAlias("user", "user");
		query.add(Restrictions.eq("user.id", userId));
		List<BulkUpload> list = (List<BulkUpload>) findByCriteria(query);
		return list;
	}
	public List<BulkUpload> findBulkUploadForCustAdmin(String status,UUID userId,String projectGroup) throws Exception{
		DetachedCriteria query = DetachedCriteria.forClass(BulkUpload.class);
		query.add(Restrictions.eq("status",status));
		query.createAlias("user", "user");
		query.add(Restrictions.eq("user.id", userId));
		List<BulkUpload> list = (List<BulkUpload>) findByCriteria(query);
		return list;
	}
	public List<BulkUpload> findBulkUploadFoSuperAdmin(String status) throws Exception{
		DetachedCriteria query = DetachedCriteria.forClass(BulkUpload.class);
		query.add(Restrictions.eq("status",status));
		List<BulkUpload> list = (List<BulkUpload>) findByCriteria(query);
		return list;
	}
	public List<BulkUpload> findBulkUploadByProjectGroupCode(String projectGroupCode) throws Exception{
		DetachedCriteria query = DetachedCriteria.forClass(BulkUpload.class);
		query.add(Restrictions.eq("projectGroupCode",projectGroupCode));
		query.add(Restrictions.eq("status","LIVE"));
		List<BulkUpload> list = (List<BulkUpload>) findByCriteria(query);
		return list;
	}
	
	@Override
	public void hydrateStaging(ExportDomain domain) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void hydrateLive(
			com.servinglynk.hmis.warehouse.model.staging.Export export) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void hydrateHBASE(SyncDomain syncDomain) {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void performSave(Iface client, Object entity) {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected List performGet(Iface client, Object entity) {
		// TODO Auto-generated method stub
		return null;
	}
}
