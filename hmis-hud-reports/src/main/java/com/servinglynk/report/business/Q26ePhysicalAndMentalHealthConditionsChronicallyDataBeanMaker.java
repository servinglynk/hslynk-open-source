package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import com.servinglynk.report.bean.Q26ePhysicalAndMentalHealthConditionsChronicallyDataBean;
import com.servinglynk.report.bean.ReportData;

public class Q26ePhysicalAndMentalHealthConditionsChronicallyDataBeanMaker extends BaseBeanMaker {
	
	public static List<Q26ePhysicalAndMentalHealthConditionsChronicallyDataBean> getQ26ePhysicalAndMentalHealthConditionsChronicallyList(ReportData data){
		
		Q26ePhysicalAndMentalHealthConditionsChronicallyDataBean q26ePhysicalAndMentalHealthConditionsChronicallyTable = new Q26ePhysicalAndMentalHealthConditionsChronicallyDataBean();
		try {
			if(data.isLiveMode()) {
				String query = " select distinct(e.dedup_client_id) from %s.disabilities d,%s.enrollment e, %s.client c  where e.id = d.enrollmentid and e.client_id = c.id  and e.chronichomeless=true and d.datacollectionstage = '1' and d.information_date >= :startDate and d.information_date <= :endDate ";
				String queryExit = " select distinct(e.dedup_client_id) from %s.disabilities d, %s.enrollment e, %s.exit ext,%s.client c   where e.id = d.enrollmentid and e.client_id = c.id  and e.chronichomeless=true and e.id=ext.enrollmentid and d.datacollectionstage = '3' and d.information_date >= :startDate and d.information_date <= :endDate ";
				String queryStayers = " select distinct(e.dedup_client_id) from %s.disabilities d, %s.enrollment e,%s.client c  where e.id = d.enrollmentid and e.client_id = c.id  and e.chronichomeless=true and d.datacollectionstage = '4' and d.information_date >= :startDate and d.information_date <= :endDate ";
				
				Set<String> enrollmentFromDisabilities = getEnrollmentFromDisabilities(data.getSchema(), data, query+" and d.disabilitytype='9' ");
				Set<String> enrollmentFromDisabilitiesExit = getEnrollmentFromDisabilities(data.getSchema(), data, queryExit+"  and d.disabilitytype='9' ");
				Set<String> enrollmentFromDisabilitiesStayers = getEnrollmentFromDisabilities(data.getSchema(), data, queryStayers+"  and d.disabilitytype='9' ");
				
				q26ePhysicalAndMentalHealthConditionsChronicallyTable.setq26eMentalIllnessAtEntry(BigInteger.valueOf(getSize(enrollmentFromDisabilities)));
				q26ePhysicalAndMentalHealthConditionsChronicallyTable.setq26eMentalIllnessStayers(BigInteger.valueOf(getSize(enrollmentFromDisabilitiesStayers)));
				q26ePhysicalAndMentalHealthConditionsChronicallyTable.setq26eMentalIllnessLeavers(BigInteger.valueOf(getSize(enrollmentFromDisabilitiesExit)));
				
				String acholoAbuseQuery = " and disabilitytype='10' and disabilityresponse='1' ";
				Set<String> alchoholAbuse = getEnrollmentFromDisabilities(data.getSchema(), data, query+acholoAbuseQuery);
				Set<String> alchoholAbuseExit = getEnrollmentFromDisabilities(data.getSchema(), data, queryExit+acholoAbuseQuery);
				Set<String> alchoholAbuseStayers = getEnrollmentFromDisabilities(data.getSchema(), data, queryStayers+acholoAbuseQuery);
				
				q26ePhysicalAndMentalHealthConditionsChronicallyTable.setq26eAlcoholAbuseAtEntry(BigInteger.valueOf(getSize(alchoholAbuse)));
				q26ePhysicalAndMentalHealthConditionsChronicallyTable.setq26eAlcoholAbuseStayers(BigInteger.valueOf(getSize(alchoholAbuseStayers)));
				q26ePhysicalAndMentalHealthConditionsChronicallyTable.setq26eAlcoholAbuseLeavers(BigInteger.valueOf(getSize(alchoholAbuseExit)));

				String drugAbuseQuery = " and disabilitytype='10' and disabilityresponse='2' ";
				Set<String> drugAbuse = getEnrollmentFromDisabilities(data.getSchema(), data, query+drugAbuseQuery);
				Set<String> drugAbuseExit = getEnrollmentFromDisabilities(data.getSchema(), data, queryExit+drugAbuseQuery);
				Set<String> drugAbuseStayers = getEnrollmentFromDisabilities(data.getSchema(), data, queryStayers+drugAbuseQuery);
				
				q26ePhysicalAndMentalHealthConditionsChronicallyTable.setq26eDrugAbuseAtEntry(BigInteger.valueOf(getSize(drugAbuse)));
				q26ePhysicalAndMentalHealthConditionsChronicallyTable.setq26eDrugAbuseStayers(BigInteger.valueOf(getSize(drugAbuseStayers)));
				q26ePhysicalAndMentalHealthConditionsChronicallyTable.setq26eDrugAbuseLeavers(BigInteger.valueOf(getSize(drugAbuseExit)));
				
				String alcoholAndDrugQuery = "  and disabilitytype='10' and disabilityresponse='3' ";
				Set<String> alcoholAndDrug = getEnrollmentFromDisabilities(data.getSchema(), data, query+alcoholAndDrugQuery);
				Set<String> alcoholAndDrugExit = getEnrollmentFromDisabilities(data.getSchema(), data, queryExit+alcoholAndDrugQuery);
				Set<String> alcoholAndDrugStayers = getEnrollmentFromDisabilities(data.getSchema(), data, queryStayers+alcoholAndDrugQuery);
				
				q26ePhysicalAndMentalHealthConditionsChronicallyTable.setq26eBothAlcoholAndDrugAbuseAtEntry(BigInteger.valueOf(getSize(alcoholAndDrug)));
				q26ePhysicalAndMentalHealthConditionsChronicallyTable.setq26eBothAlcoholAndDrugAbuseStayers(BigInteger.valueOf(getSize(alcoholAndDrugStayers)));
				q26ePhysicalAndMentalHealthConditionsChronicallyTable.setq26eBothAlcoholAndDrugAbuseLeavers(BigInteger.valueOf(getSize(alcoholAndDrugExit)));

				String chronicHealthConditionQuery = "   and disabilitytype='7' ";
				Set<String> chronicHealthCondition = getEnrollmentFromDisabilities(data.getSchema(), data, query+chronicHealthConditionQuery);
				Set<String> chronicHealthConditionExit = getEnrollmentFromDisabilities(data.getSchema(), data, queryExit+chronicHealthConditionQuery);
				Set<String> chronicHealthConditionStayers = getEnrollmentFromDisabilities(data.getSchema(), data, queryStayers+chronicHealthConditionQuery);
				
				q26ePhysicalAndMentalHealthConditionsChronicallyTable.setq26eChronicHealthConditionAtEntry(BigInteger.valueOf(getSize(chronicHealthCondition)));
				q26ePhysicalAndMentalHealthConditionsChronicallyTable.setq26eChronicHealthConditionStayers(BigInteger.valueOf(getSize(chronicHealthConditionStayers)));
				q26ePhysicalAndMentalHealthConditionsChronicallyTable.setq26eChronicHealthConditionLeavers(BigInteger.valueOf(getSize(chronicHealthConditionExit)));

				String hivRelatedDiseaseQuery = "   and disabilitytype='8' ";
				Set<String> hivRelatedDisease = getEnrollmentFromDisabilities(data.getSchema(), data, query+hivRelatedDiseaseQuery);
				Set<String> hivRelatedDiseaseExit = getEnrollmentFromDisabilities(data.getSchema(), data, queryExit+hivRelatedDiseaseQuery);
				Set<String> hivRelatedDiseaseStayers = getEnrollmentFromDisabilities(data.getSchema(), data, queryStayers+hivRelatedDiseaseQuery);
				
				
				q26ePhysicalAndMentalHealthConditionsChronicallyTable.setq26eHIVAIDSAndRelatedDiseasesAtEntry(BigInteger.valueOf(getSize(hivRelatedDisease)));
				q26ePhysicalAndMentalHealthConditionsChronicallyTable.setq26eHIVAIDSAndRelatedDiseasesStayers(BigInteger.valueOf(getSize(hivRelatedDiseaseStayers)));
				q26ePhysicalAndMentalHealthConditionsChronicallyTable.setq26eHIVAIDSAndRelatedDiseasesLeavers(BigInteger.valueOf(getSize(hivRelatedDiseaseExit)));

				String developmentalDisabilityQuery = "  and disabilitytype='5' ";
				Set<String> developmentalDisability = getEnrollmentFromDisabilities(data.getSchema(), data, query+developmentalDisabilityQuery);
				Set<String> developmentalDisabilityExit = getEnrollmentFromDisabilities(data.getSchema(), data, queryExit+developmentalDisabilityQuery);
				Set<String> developmentalDisabilityStayers = getEnrollmentFromDisabilities(data.getSchema(), data, queryStayers+developmentalDisabilityQuery);
				
				q26ePhysicalAndMentalHealthConditionsChronicallyTable.setq26eDevelopmentalDisabilityAtEntry(BigInteger.valueOf(getSize(developmentalDisability)));
				q26ePhysicalAndMentalHealthConditionsChronicallyTable.setq26eDevelopmentalDisabilityStayers(BigInteger.valueOf(getSize(developmentalDisabilityStayers)));
				q26ePhysicalAndMentalHealthConditionsChronicallyTable.setq26eDevelopmentalDisabilityLeavers(BigInteger.valueOf(getSize(developmentalDisabilityExit)));

				String physicalDisabilityQuery = "  and disabilitytype='6' ";
				Set<String> physicalDisability = getEnrollmentFromDisabilities(data.getSchema(), data, query+physicalDisabilityQuery);
				Set<String> physicalDisabilityExit = getEnrollmentFromDisabilities(data.getSchema(), data, queryExit+physicalDisabilityQuery);
				Set<String> physicalDisabilityStayers = getEnrollmentFromDisabilities(data.getSchema(), data, queryStayers+physicalDisabilityQuery);
				
				
				q26ePhysicalAndMentalHealthConditionsChronicallyTable.setq26ePhysicalDisabilityAtEntry(BigInteger.valueOf(getSize(physicalDisability)));
				q26ePhysicalAndMentalHealthConditionsChronicallyTable.setq26ePhysicalDisabilityStayers(BigInteger.valueOf(getSize(physicalDisabilityStayers)));
				q26ePhysicalAndMentalHealthConditionsChronicallyTable.setq26ePhysicalDisabilityLeavers(BigInteger.valueOf(getSize(physicalDisabilityExit)));
			
			}
		}catch(Exception e) {
			logger.error("Error in Q26cBeanMaker:" + e);
		}
		return Arrays.asList(q26ePhysicalAndMentalHealthConditionsChronicallyTable);
	}

}
