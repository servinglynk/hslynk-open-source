package com.servinglynk.hmis.warehouse.service; 

import java.util.UUID;

import com.servinglynk.hmis.warehouse.core.model.VeteranInfo;
import com.servinglynk.hmis.warehouse.core.model.VeteranInfos;
public interface VeteranInfoService {

   VeteranInfo createVeteranInfo(VeteranInfo veteranInfo,UUID clientId,String caller);
   VeteranInfo updateVeteranInfo(VeteranInfo veteranInfo,UUID clientId,String caller);
   VeteranInfo deleteVeteranInfo(UUID veteranInfoId,String caller);
   VeteranInfo getVeteranInfoById(UUID veteranInfoId);
   VeteranInfos getAllClientVeteranInfos(UUID clientId,Integer startIndex, Integer maxItems);
}
