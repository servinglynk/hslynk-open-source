package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.model.v2017.ServiceFaReferral;

public interface ServiceFaReferralDao extends ParentDao {

	
	ServiceFaReferral createServiceFaReferral(ServiceFaReferral serviceFaReferral);
	ServiceFaReferral updateServiceFaReferral(ServiceFaReferral serviceFaReferral);
	void deleteServiceFaReferral(ServiceFaReferral serviceFaReferral);
	ServiceFaReferral getServiceFaReferralById(UUID serviceFaReferralId);
	public ServiceFaReferral getServiceFaReferralByDedupServiceFaReferralId(UUID id,String projectGroupCode);
	List<ServiceFaReferral> getAllServiceFaReferral(Integer startIndex, Integer maxItems);
	long getServiceFaReferralCount();
	void hydrateLive(com.servinglynk.hmis.warehouse.model.v2017.ServiceFaReferral serviceFaReferral);
	long getEnrollmentServiceFaReferralsCount(UUID enrollmentId);
	List<ServiceFaReferral> getAllEnrollmentServiceFaReferrals(UUID enrollmentId, Integer startIndex, Integer maxItems);
}
