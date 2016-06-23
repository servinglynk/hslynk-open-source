package com.servinglynk.hmis.warehouse.dao;

import java.util.List;

import org.apache.hadoop.hbase.thrift2.generated.THBaseService.Iface;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.model.v2014.Export;
import com.servinglynk.hmis.warehouse.model.v2014.Sync;
@Transactional
public class SyncListDaoImpl  extends ParentDaoImpl implements SyncListDao{

	@Override
	public void addSync(Sync sync) {
		insert(sync);		
	}

	@Override
	public Sync getSync(String id) {
		Sync sync = (Sync) get(Sync.class, id);
		return sync;
	}

	@Override
	public List<Sync> getSyncs() {
		return (List<Sync>) list("Sync");
	}

	@Override
	public void hydrateStaging(ExportDomain domain) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Sync findLastSync(String status) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Sync.class);
		criteria.setProjection(Projections.max("dateCreated"));
		criteria.add(Restrictions.eq("status",status));
		if(criteria.getExecutableCriteria(getCurrentSession()).list() != null) {
			return (Sync) criteria.getExecutableCriteria(getCurrentSession()).list().get(0);
		}
		return null;
	}

}
