package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.model.v2015.Coc;

public interface CocDao  extends ParentDao {

public void hydrateLive(com.servinglynk.hmis.warehouse.model.stagv2015.Coc coc);
	
	Coc createCoc(Coc coc);
	Coc updateCoc(Coc coc);
	void deleteCoc(Coc coc);
	Coc getCocById(UUID cocId);
	List<Coc> getAllCoc(Integer startIndex, Integer maxItems);
	long getCocCount();
	public Coc getCocByDedupCliendId(UUID id,String projectGroupCode);
	
}
