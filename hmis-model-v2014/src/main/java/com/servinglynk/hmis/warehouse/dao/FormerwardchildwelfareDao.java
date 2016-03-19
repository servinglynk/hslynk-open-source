package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

public interface FormerwardchildwelfareDao extends ParentDao {

	   com.servinglynk.hmis.warehouse.model.v2014.Formerwardchildwelfare createFormerWardChildWelfare(com.servinglynk.hmis.warehouse.model.v2014.Formerwardchildwelfare formerWardChildWelfare);
	   com.servinglynk.hmis.warehouse.model.v2014.Formerwardchildwelfare updateFormerWardChildWelfare(com.servinglynk.hmis.warehouse.model.v2014.Formerwardchildwelfare formerWardChildWelfare);
	   void deleteFormerWardChildWelfare(com.servinglynk.hmis.warehouse.model.v2014.Formerwardchildwelfare formerWardChildWelfare);
	   com.servinglynk.hmis.warehouse.model.v2014.Formerwardchildwelfare getFormerWardChildWelfareById(UUID formerWardChildWelfareId);
	   List<com.servinglynk.hmis.warehouse.model.v2014.Formerwardchildwelfare> getAllEnrollmentFormerWardChildWelfares(UUID enrollmentId,Integer startIndex, Integer maxItems);
	   long getEnrollmentFormerWardChildWelfaresCount(UUID enrollmentId);
}
