/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import com.servinglynk.hmis.warehouse.model.staging.Client;

/**
 * @author Sandeep
 *
 */
public interface VeteranInfoDao extends ParentDao {
	public void hydrateLive(Client client);
}
