package com.servinglynk.hmis.warehouse.service.core;

import java.util.List;

import com.servinglynk.hmis.warehouse.model.live.HmisUser;
import com.servinglynk.hmis.warehouse.model.live.Sync;

public interface HmisUserService extends ParentService {

	public void addHmisUser(HmisUser hmisuser);
	public HmisUser getHmisUser(String id);
	public void deleteHmisUser(String id);
	public List<HmisUser> getHmisUsers(String id);
	public void updateStrategy(HmisUser hmisUser);
	public void addSync(Sync sync);
	public Sync getSync(String id);
	public List<Sync> getSyncs();
	}
