package com.servinglynk.hmis.warehouse.dao;

public interface ClientDao extends ParentDao {
	public void hydrateLive(com.servinglynk.hmis.warehouse.model.staging.Client client);
}
