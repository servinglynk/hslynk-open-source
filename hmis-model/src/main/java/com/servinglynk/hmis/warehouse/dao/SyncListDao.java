package com.servinglynk.hmis.warehouse.dao;

import java.util.List;

import com.servinglynk.hmis.warehouse.model.live.Sync;

public interface SyncListDao extends ParentDao {
	    public void addSync(Sync sync);
	    public Sync getSync(String id);
	    public List<Sync> getSyncs();

}
