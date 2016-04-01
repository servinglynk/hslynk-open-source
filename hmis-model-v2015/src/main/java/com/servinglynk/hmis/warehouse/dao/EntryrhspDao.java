package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.model.v2015.Entryrhsp;

public interface EntryrhspDao extends ParentDao{
	
	Entryrhsp createEntryrhsp(Entryrhsp entryrhsp);
	Entryrhsp updateEntryrhsp(Entryrhsp entryrhsp);
	void deleteEntryrhsp(Entryrhsp entryrhsp);
	Entryrhsp getEntryrhspById(UUID entryrhspId);
	public Entryrhsp getEntryrhspByDedupEntryrhspId(UUID id,String projectGroupCode);
	List<Entryrhsp> getAllEntryrhsp(Integer startIndex, Integer maxItems);
	long getEntryrhspCount();
	void hydrateLive(com.servinglynk.hmis.warehouse.model.stagv2015.Entryrhsp entryRshp);
	
	List<Entryrhsp> getAllEnrollmentEntryrhsps(UUID enrollmentId, Integer startIndex, Integer maxItems);
	long getEnrollmentEntryrhspsCount(UUID enrollmentId);

}
