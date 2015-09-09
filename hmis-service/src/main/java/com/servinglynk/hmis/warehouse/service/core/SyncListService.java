package com.servinglynk.hmis.warehouse.service.core;

import java.util.List;

import com.servinglynk.hmis.warehouse.model.live.Sync;

public interface SyncListService {
	public void addSync(Sync sync);
	public Sync getSync(String id);
	public List<Sync> getSyncs();
}
