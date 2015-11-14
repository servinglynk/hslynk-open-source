package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

public interface FormerwardchildwelfareDao extends ParentDao {

	   com.servinglynk.hmis.warehouse.model.live.Formerwardchildwelfare createFormerWardChildWelfare(com.servinglynk.hmis.warehouse.model.live.Formerwardchildwelfare formerWardChildWelfare);
	   com.servinglynk.hmis.warehouse.model.live.Formerwardchildwelfare updateFormerWardChildWelfare(com.servinglynk.hmis.warehouse.model.live.Formerwardchildwelfare formerWardChildWelfare);
	   void deleteFormerWardChildWelfare(com.servinglynk.hmis.warehouse.model.live.Formerwardchildwelfare formerWardChildWelfare);
	   com.servinglynk.hmis.warehouse.model.live.Formerwardchildwelfare getFormerWardChildWelfareById(UUID formerWardChildWelfareId);
	   List<com.servinglynk.hmis.warehouse.model.live.Formerwardchildwelfare> getAllEnrollmentFormerWardChildWelfares(UUID enrollmentId,Integer startIndex, Integer maxItems);
	   long getEnrollmentFormerWardChildWelfaresCount(UUID enrollmentId);
}
