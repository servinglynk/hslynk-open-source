package com.servinglynk.hmis.warehouse.hbase.service;

import java.util.List;

import com.servinglynk.hmis.warehouse.model.live.HmisUser;

public interface SyncUserService {
	public boolean syncHmisUser(List<com.servinglynk.hmis.warehouse.sync.hbase.model.HmisUser> hmisUsers);
	public List<com.servinglynk.hmis.warehouse.sync.hbase.model.HmisUser> getHmisUser(String rowKey);
}
