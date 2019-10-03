package com.servinglynk.hmis.warehouse.service; 

import java.util.UUID;

import com.servinglynk.hmis.warehouse.core.model.Affiliation;
import com.servinglynk.hmis.warehouse.core.model.Affiliations;
public interface AffiliationService {

   Affiliation createAffiliation(Affiliation affiliation,UUID projectId,String caller);
   Affiliation updateAffiliation(Affiliation affiliation,UUID projectId,String caller);
   Affiliation deleteAffiliation(UUID affiliationId,String caller);
   Affiliation getAffiliationById(UUID affiliationId);
   Affiliations getAllProjectAffiliations(UUID projectId,Integer startIndex, Integer maxItems);
}
