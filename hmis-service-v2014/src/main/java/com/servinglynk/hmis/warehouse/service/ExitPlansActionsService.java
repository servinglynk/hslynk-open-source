package com.servinglynk.hmis.warehouse.service; 

import java.util.UUID;

import com.servinglynk.hmis.warehouse.core.model.ExitPlansActions;
import com.servinglynk.hmis.warehouse.core.model.ExitPlansActionsList;
public interface ExitPlansActionsService {

   ExitPlansActions createExitPlansActions(ExitPlansActions exitPlansActions,UUID exitId,String caller);
   ExitPlansActions updateExitPlansActions(ExitPlansActions exitPlansActions,UUID exitId,String caller);
   ExitPlansActions deleteExitPlansActions(UUID exitPlansActionsId,String caller);
   ExitPlansActions getExitPlansActionsById(UUID exitPlansActionsId);
   ExitPlansActionsList getAllExitExitPlansActionss(UUID exitId,Integer startIndex, Integer maxItems);
}