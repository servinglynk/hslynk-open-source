package com.servinglynk.hmis.warehouse.dao;

import java.util.List;

import org.apache.hadoop.hbase.thrift2.generated.THBaseService.Iface;
import org.springframework.beans.factory.annotation.Autowired;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.model.stagv2015.Export;

public class CocDaoImpl  extends ParentDaoImpl implements CocDao{
	
	@Autowired
	private ParentDaoFactory factory;
	
	@Override
	public void hydrateStaging(ExportDomain domain) {
		factory.getInventoryDao().hydrateStaging(domain);
		factory.getSiteDao().hydrateStaging(domain);		
	}

	@Override
	public void hydrateLive(Export export) {
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
