package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.model.v2015.Entryrhy;

public interface EntryrhyDao extends ParentDao {
	
	Entryrhy createEntryrhy(Entryrhy entryrhsp);
	Entryrhy updateEntryrhy(Entryrhy entryrhsp);
	void deleteEntryrhy(Entryrhy entryrhsp);
	Entryrhy getEntryrhyById(UUID entryrhspId);
	public Entryrhy getEntryrhyByDedupEntryrhyId(UUID id,String projectGroupCode);
	List<Entryrhy> getAllEntryrhy(Integer startIndex, Integer maxItems);
	long getEntryrhyCount();
	void hydrateLive(com.servinglynk.hmis.warehouse.model.stagv2015.Entryrhy entryrhy);
	
	   List<Entryrhy> getAllEnrollmentEntryrhys(UUID enrollmentId,Integer startIndex, Integer maxItems);
	   long getEnrollmentEntryrhysCount(UUID enrollmentId);

}
