package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.hbase.thrift2.generated.THBaseService.Iface;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.model.base.HmisBulkUpload;

@Transactional
public class BulkUploaderWorkerDaoImpl extends ParentDaoImpl implements BulkUploaderWorkerDao {

	public List<HmisBulkUpload> findUnProcessedUploads(String status) throws Exception{
		DetachedCriteria query = DetachedCriteria.forClass(HmisBulkUpload.class);
		query.add(Restrictions.eq("status","INITIAL"));
		List<HmisBulkUpload> list = (List<HmisBulkUpload>) findByCriteria(query);
		return list;
	}
	public List<HmisBulkUpload> findBulkUploadByStatus(String status) throws Exception{
		DetachedCriteria query = DetachedCriteria.forClass(HmisBulkUpload.class);
		query.add(Restrictions.eq("status",status));
		List<HmisBulkUpload> list = (List<HmisBulkUpload>) findByCriteriaWithOutDelete(query);
		return list;
	}
	
	public List<HmisBulkUpload> findBulkUploadForDevelopers(String status,UUID userId,String projectGroup) throws Exception{
		DetachedCriteria query = DetachedCriteria.forClass(HmisBulkUpload.class);
		query.add(Restrictions.eq("status",status));
		query.createAlias("user", "user");
		query.add(Restrictions.eq("user.id", userId));
		if(StringUtils.equals("DELETED", status)) {
			query.add(Restrictions.eq("deleted",true));
		}
		List<HmisBulkUpload> list = (List<HmisBulkUpload>) findByCriteriaWithOutDelete(query);
		return list;
	}
	public List<HmisBulkUpload> findBulkUploadForCustAdmin(String status,UUID userId,String projectGroup) throws Exception{
		DetachedCriteria query = DetachedCriteria.forClass(HmisBulkUpload.class);
		query.add(Restrictions.eq("status",status));
		query.createAlias("user", "user");
		query.add(Restrictions.eq("user.id", userId));
		List<HmisBulkUpload> list = (List<HmisBulkUpload>) findByCriteria(query);
		return list;
	}
	public List<HmisBulkUpload> findBulkUploadFoSuperAdmin(String status) throws Exception{
		DetachedCriteria query = DetachedCriteria.forClass(HmisBulkUpload.class);
		query.add(Restrictions.eq("status",status));
		List<HmisBulkUpload> list = (List<HmisBulkUpload>) findByCriteria(query);
		return list;
	}
	public List<HmisBulkUpload> findBulkUploadByProjectGroupCode(String projectGroupCode) throws Exception{
		DetachedCriteria query = DetachedCriteria.forClass(HmisBulkUpload.class);
		query.add(Restrictions.eq("projectGroupCode",projectGroupCode));
		query.add(Restrictions.eq("status","LIVE"));
		List<HmisBulkUpload> list = (List<HmisBulkUpload>) findByCriteria(query);
		return list;
	}
	
	@Override
	public void hydrateStaging(ExportDomain domain) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void hydrateLive(
			com.servinglynk.hmis.warehouse.model.stagv2014.Export export, Long id) {
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
