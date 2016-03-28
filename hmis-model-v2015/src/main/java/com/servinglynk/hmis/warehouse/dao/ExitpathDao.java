package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.model.v2015.Exitpath;

public interface ExitpathDao extends ParentDao {
	Exitpath createExitpath(Exitpath exitpath);
	Exitpath updateExitpath(Exitpath exitpath);
	void deleteExitpath(Exitpath exitpath);
	Exitpath getExitpathById(UUID exitpathId);
	public Exitpath getExitpathByDedupExitpathId(UUID id,String projectGroupCode);
	List<Exitpath> getAllExitpath(Integer startIndex, Integer maxItems);
	long getExitpathCount();
	void hydrateLive(com.servinglynk.hmis.warehouse.model.stagv2015.Exitpath exitpath);

}
