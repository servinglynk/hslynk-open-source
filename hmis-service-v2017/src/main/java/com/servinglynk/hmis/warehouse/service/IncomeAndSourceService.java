package com.servinglynk.hmis.warehouse.service; 

import java.util.UUID;

import com.servinglynk.hmis.warehouse.core.model.IncomeAndSource;
import com.servinglynk.hmis.warehouse.core.model.IncomeAndSources;
public interface IncomeAndSourceService {

   IncomeAndSource createIncomeAndSource(IncomeAndSource incomeAndSource,UUID enrollmentId,String caller);
   IncomeAndSource updateIncomeAndSource(IncomeAndSource incomeAndSource,UUID enrollmentId,String caller);
   IncomeAndSource deleteIncomeAndSource(UUID incomeAndSourceId,String caller);
   IncomeAndSource getIncomeAndSourceById(UUID incomeAndSourceId);
   IncomeAndSources getAllEnrollmentIncomeAndSources(UUID enrollmentId,Integer startIndex, Integer maxItems);
}
