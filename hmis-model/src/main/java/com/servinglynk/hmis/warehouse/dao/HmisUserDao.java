package com.servinglynk.hmis.warehouse.dao;

import java.util.List;

import com.servinglynk.hmis.warehouse.model.v2014.Client;
import com.servinglynk.hmis.warehouse.model.v2014.HmisUser;


public interface HmisUserDao extends ParentDao {
	
	 public void addHmisUser(HmisUser hmisUser);
	    public HmisUser getHmisUser(String id);
	    public void updateHmisUser(HmisUser hmisUser);
	    public void deleteHmisUser(String id);
	    public List<HmisUser> getHmisUsers();
	    public void addClient(Client client);
		public HmisUser findByUsername(String userName);
}
