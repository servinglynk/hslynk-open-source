/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.UUID;

/**
 * @author Sandeep
 *
 */
public interface ProjectDao extends ParentDao {

	com.servinglynk.hmis.warehouse.model.live.Project getProjectById(UUID projectId);
}
