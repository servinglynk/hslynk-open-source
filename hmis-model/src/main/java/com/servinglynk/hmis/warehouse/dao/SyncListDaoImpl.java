package com.servinglynk.hmis.warehouse.dao;

import java.util.List;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.model.live.Sync;
import com.servinglynk.hmis.warehouse.model.staging.Export;

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
	public void hydrateLive(Export export) {
		// TODO Auto-generated method stub
		
	}
	

}
