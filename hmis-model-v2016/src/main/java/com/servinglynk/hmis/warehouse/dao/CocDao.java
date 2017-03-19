package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

public interface CocDao  extends ParentDao {
	
	   com.servinglynk.hmis.warehouse.model.v2016.Coc createCoc(com.servinglynk.hmis.warehouse.model.v2016.Coc coc);
	   com.servinglynk.hmis.warehouse.model.v2016.Coc updateCoc(com.servinglynk.hmis.warehouse.model.v2016.Coc coc);
	   void deleteCoc(com.servinglynk.hmis.warehouse.model.v2016.Coc coc);
	   com.servinglynk.hmis.warehouse.model.v2016.Coc getCocById(UUID cocId);
	   List<com.servinglynk.hmis.warehouse.model.v2016.Coc> getAllCocs(UUID projectId,Integer startIndex, Integer maxItems);
	   long getCocsCount(UUID projectId);

	   public void hydrateLive(com.servinglynk.hmis.warehouse.model.v2016.Coc coc);
	
		
}
