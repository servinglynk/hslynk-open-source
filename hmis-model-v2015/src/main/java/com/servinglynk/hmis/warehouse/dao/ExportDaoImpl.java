package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

import org.apache.hadoop.hbase.thrift2.generated.THBaseService.Iface;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.model.stagv2015.Export;

public class ExportDaoImpl extends ParentDaoImpl implements ExportDao {

	@Override
	public void hydrateStaging(ExportDomain domain) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hydrateLive(Export export, Long id) {
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

	
		public Export getExportById(UUID id) throws Exception{
			DetachedCriteria query = DetachedCriteria.forClass(Export.class);
			query.add(Restrictions.eq("id",id));
			List<Export> list = (List<Export>) findByCriteria(query);
			return list.get(0);
		}
}
