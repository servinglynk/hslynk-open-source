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

				q21HealthInsuranceDataBeanTable.setQ21INoHealthInsuranceAtEntry(BigInteger.valueOf(0));
				q21HealthInsuranceDataBeanTable.setQ21INoHealthInsuranceAtLatestStayers(BigInteger.valueOf(0));
				q21HealthInsuranceDataBeanTable.setQ21INoHealthInsuranceAtExitLeavers(BigInteger.valueOf(0));

				q21HealthInsuranceDataBeanTable.setQ21JClientRefusedAtEntry(BigInteger.valueOf(0));
				q21HealthInsuranceDataBeanTable.setQ21JClientRefusedAtLatestStayers(BigInteger.valueOf(0));
				q21HealthInsuranceDataBeanTable.setQ21JClientRefusedAtExitLeavers(BigInteger.valueOf(0));

				q21HealthInsuranceDataBeanTable.setQ21KDataNotCollectedAtEntry(BigInteger.valueOf(0));
				q21HealthInsuranceDataBeanTable.setQ21KDataNotCollectedAtLatestStayers(BigInteger.valueOf(0));
				q21HealthInsuranceDataBeanTable.setQ21KDataNotCollectedAtExitLeavers(BigInteger.valueOf(0));

				q21HealthInsuranceDataBeanTable.setQ21LNoOfAdultStayersNotRequiredAtEntry(BigInteger.valueOf(0));
				q21HealthInsuranceDataBeanTable.setQ21LNoOfAdultStayersNotRequiredAtLatestStayers(BigInteger.valueOf(0));
				q21HealthInsuranceDataBeanTable.setQ21LNoOfAdultStayersNotRequiredAtExitLeavers(BigInteger.valueOf(0));

				q21HealthInsuranceDataBeanTable.setQ21M1SourceOfHealthInsuranceAtEntry(BigInteger.valueOf(0));
				q21HealthInsuranceDataBeanTable.setQ21M1SourceOfHealthInsuranceAtLatestStayers(BigInteger.valueOf(0));
				q21HealthInsuranceDataBeanTable.setQ21M1SourceOfHealthInsuranceAtExitLeavers(BigInteger.valueOf(0));

				q21HealthInsuranceDataBeanTable.setQ21NMoreThan1SourceOfHealthInsuranceAtEntry(BigInteger.valueOf(0));
				q21HealthInsuranceDataBeanTable.setQ21NMoreThan1SourceOfHealthInsuranceAtLatestStayers(BigInteger.valueOf(0));
				q21HealthInsuranceDataBeanTable.setQ21NMoreThan1SourceOfHealthInsuranceAtExitLeavers(BigInteger.valueOf(0));
		
		return Arrays.asList(q21HealthInsuranceDataBeanTable);
	}
	
}
