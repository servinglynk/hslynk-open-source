package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import com.servinglynk.report.bean.Q25ePhysicalAndMentalHealthConditionsVeteransDataBean;

public class Q25ePhysicalAndMentalHealthConditionsVeteransDataBeanMaker {
	
	public static List<Q25ePhysicalAndMentalHealthConditionsVeteransDataBean> getQ25ePhysicalAndMentalHealthConditionsVeteransList(){
		
		Q25ePhysicalAndMentalHealthConditionsVeteransDataBean q25ePhysicalAndMentalHealthConditionsVeteransTable = new Q25ePhysicalAndMentalHealthConditionsVeteransDataBean();
		
				q25ePhysicalAndMentalHealthConditionsVeteransTable.setQ25eMentalIllnessAtEntry(BigInteger.valueOf(0));
				q25ePhysicalAndMentalHealthConditionsVeteransTable.setQ25eMentalIllnessStayers(BigInteger.valueOf(0));
				q25ePhysicalAndMentalHealthConditionsVeteransTable.setQ25eMentalIllnessLeavers(BigInteger.valueOf(0));

				q25ePhysicalAndMentalHealthConditionsVeteransTable.setQ25eAlcoholAbuseAtEntry(BigInteger.valueOf(0));
				q25ePhysicalAndMentalHealthConditionsVeteransTable.setQ25eAlcoholAbuseStayers(BigInteger.valueOf(0));
				q25ePhysicalAndMentalHealthConditionsVeteransTable.setQ25eAlcoholAbuseLeavers(BigInteger.valueOf(0));

				q25ePhysicalAndMentalHealthConditionsVeteransTable.setQ25eDrugAbuseAtEntry(BigInteger.valueOf(0));
				q25ePhysicalAndMentalHealthConditionsVeteransTable.setQ25eDrugAbuseStayers(BigInteger.valueOf(0));
				q25ePhysicalAndMentalHealthConditionsVeteransTable.setQ25eDrugAbuseLeavers(BigInteger.valueOf(0));

				q25ePhysicalAndMentalHealthConditionsVeteransTable.setQ25eBothAlcoholAndDrugAbuseAtEntry(BigInteger.valueOf(0));
				q25ePhysicalAndMentalHealthConditionsVeteransTable.setQ25eBothAlcoholAndDrugAbuseStayers(BigInteger.valueOf(0));
				q25ePhysicalAndMentalHealthConditionsVeteransTable.setQ25eBothAlcoholAndDrugAbuseLeavers(BigInteger.valueOf(0));

				q25ePhysicalAndMentalHealthConditionsVeteransTable.setQ25eChronicHealthConditionAtEntry(BigInteger.valueOf(0));
				q25ePhysicalAndMentalHealthConditionsVeteransTable.setQ25eChronicHealthConditionStayers(BigInteger.valueOf(0));
				q25ePhysicalAndMentalHealthConditionsVeteransTable.setQ25eChronicHealthConditionLeavers(BigInteger.valueOf(0));

				q25ePhysicalAndMentalHealthConditionsVeteransTable.setQ25eHIVandRelatedDiseaseAtEntry(BigInteger.valueOf(0));
				q25ePhysicalAndMentalHealthConditionsVeteransTable.setQ25eHIVandRelatedDiseaseStayers(BigInteger.valueOf(0));
				q25ePhysicalAndMentalHealthConditionsVeteransTable.setQ25eHIVandRelatedDiseaseLeavers(BigInteger.valueOf(0));

				q25ePhysicalAndMentalHealthConditionsVeteransTable.setQ25eDevelopmentalDisabilityAtEntry(BigInteger.valueOf(0));
				q25ePhysicalAndMentalHealthConditionsVeteransTable.setQ25eDevelopmentalDisabilityStayers(BigInteger.valueOf(0));
				q25ePhysicalAndMentalHealthConditionsVeteransTable.setQ25eDevelopmentalDisabilityLeavers(BigInteger.valueOf(0));

				q25ePhysicalAndMentalHealthConditionsVeteransTable.setQ25ePhysicalDisabilityAtEntry(BigInteger.valueOf(0));
				q25ePhysicalAndMentalHealthConditionsVeteransTable.setQ25ePhysicalDisabilityStayers(BigInteger.valueOf(0));
				q25ePhysicalAndMentalHealthConditionsVeteransTable.setQ25ePhysicalDisabilityLeavers(BigInteger.valueOf(0));
						
				return Arrays.asList(q25ePhysicalAndMentalHealthConditionsVeteransTable);
	}

}
