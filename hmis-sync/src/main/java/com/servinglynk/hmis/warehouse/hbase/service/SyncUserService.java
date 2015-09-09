package com.servinglynk.hmis.warehouse.hbase.service;

import java.util.List;

import com.servinglynk.hmis.warehouse.hbase.model.HmisUser;

public interface SyncUserService {
	public boolean syncHmisUser(List<HmisUser> hmisUsers);
	public List<HmisUser> getHmisUser(String rowKey);
}
