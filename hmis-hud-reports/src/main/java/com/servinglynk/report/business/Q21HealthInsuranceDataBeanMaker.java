package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import com.servinglynk.report.bean.Q21HealthInsuranceDataBean;

public class Q21HealthInsuranceDataBeanMaker {

	public static List<Q21HealthInsuranceDataBean> getQ21HealthInsuranceList(){
		
		Q21HealthInsuranceDataBean q21HealthInsuranceDataBeanTable = new Q21HealthInsuranceDataBean();
		
				q21HealthInsuranceDataBeanTable.setQ21AMedicaidHealthInsuranceAtEntry(BigInteger.valueOf(0));
				q21HealthInsuranceDataBeanTable.setQ21AMedicaidHealthInsuranceAtLatestStayers(BigInteger.valueOf(0));
				q21HealthInsuranceDataBeanTable.setQ21AMedicaidHealthInsuranceAtExitLeavers(BigInteger.valueOf(0));

				q21HealthInsuranceDataBeanTable.setQ21BMedicaidHealthInsuranceAtEntry(BigInteger.valueOf(0));
				q21HealthInsuranceDataBeanTable.setQ21BMedicaidHealthInsuranceAtLatestStayers(BigInteger.valueOf(0));
				q21HealthInsuranceDataBeanTable.setQ21BMedicaidHealthInsuranceAtExitLeavers(BigInteger.valueOf(0));

				q21HealthInsuranceDataBeanTable.setQ21CStateChildHealthInsuranceAtEntry(BigInteger.valueOf(0));
				q21HealthInsuranceDataBeanTable.setQ21CStateChildHealthInsuranceAtLatestStayers(BigInteger.valueOf(0));
				q21HealthInsuranceDataBeanTable.setQ21CStateChildHealthInsuranceAtExitLeavers(BigInteger.valueOf(0));

				q21HealthInsuranceDataBeanTable.setQ21DVAMedicalServicesAtEntry(BigInteger.valueOf(0));
				q21HealthInsuranceDataBeanTable.setQ21DVAMedicalServicesAtLatestStayers(BigInteger.valueOf(0));
				q21HealthInsuranceDataBeanTable.setQ21DVAMedicalServicesAtExitLeavers(BigInteger.valueOf(0));

				q21HealthInsuranceDataBeanTable.setQ21EEmployerProvidedHealthInsuranceAtEntry(BigInteger.valueOf(0));
				q21HealthInsuranceDataBeanTable.setQ21EEmployerProvidedHealthInsuranceAtLatestStayers(BigInteger.valueOf(0));
				q21HealthInsuranceDataBeanTable.setQ21EEmployerProvidedHealthInsuranceAtExitLeavers(BigInteger.valueOf(0));

				q21HealthInsuranceDataBeanTable.setQ21FHealthInsuranceThroughCobraAtEntry(BigInteger.valueOf(0));
				q21HealthInsuranceDataBeanTable.setQ21FHealthInsuranceThroughCobraAtLatestStayers(BigInteger.valueOf(0));
				q21HealthInsuranceDataBeanTable.setQ21FHealthInsuranceThroughCobraAtExitLeavers(BigInteger.valueOf(0));

				q21HealthInsuranceDataBeanTable.setQ21GPrivatePayHealthInsuranceAtEntry(BigInteger.valueOf(0));
				q21HealthInsuranceDataBeanTable.setQ21GPrivatePayHealthInsuranceAtLatestStayers(BigInteger.valueOf(0));
				q21HealthInsuranceDataBeanTable.setQ21GPrivatePayHealthInsuranceAtExitLeavers(BigInteger.valueOf(0));

				q21HealthInsuranceDataBeanTable.setQ21HStateHealthInsuranceForAdultsAtEntry(BigInteger.valueOf(0));
				q21HealthInsuranceDataBeanTable.setQ21HStateHealthInsuranceForAdultsAtLatestStayers(BigInteger.valueOf(0));
				q21HealthInsuranceDataBeanTable.setQ21HStateHealthInsuranceForAdultsAtExitLeavers(BigInteger.valueOf(0));

				q21HealthInsuranceDataBeanTable.setQ21IIndianHealthServicesProgramAtEntry(BigInteger.valueOf(0));
				q21HealthInsuranceDataBeanTable.setQ21IIndianHealthServicesProgramAtExitLeavers(BigInteger.valueOf(0));
				q21HealthInsuranceDataBeanTable.setQ21IIndianHealthServicesProgramAtLatestStayers(BigInteger.valueOf(0));
				
				q21HealthInsuranceDataBeanTable.setQ21JOtherAtEntry(BigInteger.valueOf(0));
				q21HealthInsuranceDataBeanTable.setQ21JOtherAtExitLeavers(BigInteger.valueOf(0));
				q21HealthInsuranceDataBeanTable.setQ21JOtherAtLatestStayers(BigInteger.valueOf(0));
				
				q21HealthInsuranceDataBeanTable.setQ21KNoHealthInsuranceAtEntry(BigInteger.valueOf(0));
				q21HealthInsuranceDataBeanTable.setQ21KNoHealthInsuranceAtLatestStayers(BigInteger.valueOf(0));
				q21HealthInsuranceDataBeanTable.setQ21KNoHealthInsuranceAtExitLeavers(BigInteger.valueOf(0));

				q21HealthInsuranceDataBeanTable.setQ21LClientRefusedAtEntry(BigInteger.valueOf(0));
				q21HealthInsuranceDataBeanTable.setQ21LClientRefusedAtLatestStayers(BigInteger.valueOf(0));
				q21HealthInsuranceDataBeanTable.setQ21LClientRefusedAtExitLeavers(BigInteger.valueOf(0));

				q21HealthInsuranceDataBeanTable.setQ21MDataNotCollectedAtEntry(BigInteger.valueOf(0));
				q21HealthInsuranceDataBeanTable.setQ21MDataNotCollectedAtLatestStayers(BigInteger.valueOf(0));
				q21HealthInsuranceDataBeanTable.setQ21MDataNotCollectedAtExitLeavers(BigInteger.valueOf(0));

				q21HealthInsuranceDataBeanTable.setQ21NNoOfAdultStayersNotRequiredAtEntry(BigInteger.valueOf(0));
				q21HealthInsuranceDataBeanTable.setQ21NNoOfAdultStayersNotRequiredAtLatestStayers(BigInteger.valueOf(0));
				q21HealthInsuranceDataBeanTable.setQ21NNoOfAdultStayersNotRequiredAtExitLeavers(BigInteger.valueOf(0));

				q21HealthInsuranceDataBeanTable.setQ21O1SourceOfHealthInsuranceAtEntry(BigInteger.valueOf(0));
				q21HealthInsuranceDataBeanTable.setQ21O1SourceOfHealthInsuranceAtLatestStayers(BigInteger.valueOf(0));
				q21HealthInsuranceDataBeanTable.setQ21O1SourceOfHealthInsuranceAtExitLeavers(BigInteger.valueOf(0));

				q21HealthInsuranceDataBeanTable.setQ21PMoreThan1SourceOfHealthInsuranceAtEntry(BigInteger.valueOf(0));
				q21HealthInsuranceDataBeanTable.setQ21PMoreThan1SourceOfHealthInsuranceAtLatestStayers(BigInteger.valueOf(0));
				q21HealthInsuranceDataBeanTable.setQ21PMoreThan1SourceOfHealthInsuranceAtExitLeavers(BigInteger.valueOf(0));
		
		return Arrays.asList(q21HealthInsuranceDataBeanTable);
	}
	
}
