package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.model.v2015.Entryssvf;

public interface EntryssvfDao extends ParentDao {
	
	Entryssvf createEntryssvf(Entryssvf entryssvf);
	Entryssvf updateEntryssvf(Entryssvf entryssvf);
	void deleteEntryssvf(Entryssvf entryssvf);
	Entryssvf getEntryssvfById(UUID entryssvfId);
	public Entryssvf getEntryssvfByDedupEntryssvfId(UUID id,String projectGroupCode);
	List<Entryssvf> getAllEntryssvf(Integer startIndex, Integer maxItems);
	long getEntryssvfCount();
	void hydrateLive(com.servinglynk.hmis.warehouse.model.stagv2015.Entryssvf entryssvf);
	
	  List getAllEnrollmentEntryssvfs(UUID enrollmentId,Integer startIndex, Integer maxItems);
	   long getEnrollmentEntryssvfsCount(UUID enrollmentId);

}
