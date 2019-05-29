package com.servinglynk.hmis.warehouse.base.dao;

import java.util.List;

import com.servinglynk.hmis.warehouse.model.base.HmisUser;


public interface HmisUserDao extends BaseDao {
	
	 public void addHmisUser(HmisUser hmisUser);
	    public HmisUser getHmisUser(String id);
	    public void updateHmisUser(HmisUser hmisUser);
	    public void deleteHmisUser(String id);
	    public List<HmisUser> getHmisUsers();
		public HmisUser findByUsername(String userName);
}
