package com.servinglynk.hmis.warehouse.dao;

import java.util.UUID;

import com.servinglynk.hmis.warehouse.model.v2015.Export;

/**
 * @author Sandeep
 *
 */
public interface ExportDao extends ParentDao{
	public Export getExportById(UUID id) throws Exception;
}
