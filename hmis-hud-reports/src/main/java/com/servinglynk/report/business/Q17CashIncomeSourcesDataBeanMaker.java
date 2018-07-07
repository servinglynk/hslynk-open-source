package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import com.servinglynk.report.bean.Q17DataBean;
import com.servinglynk.report.bean.ReportData;

public class Q17CashIncomeSourcesDataBeanMaker {
	
	public static List<Q17DataBean> getQ17CashIncomeSourcesList(ReportData data){
		
		Q17DataBean q17CashIncomeSourcesDataBeanTable =new Q17DataBean();
		
		q17CashIncomeSourcesDataBeanTable.setQ17AdultsWithIncomeAtEntry(BigInteger.valueOf(0));
		q17CashIncomeSourcesDataBeanTable.setQ17AdultsWithIncomeAtExitforLeavers(BigInteger.valueOf(0));
		q17CashIncomeSourcesDataBeanTable.setQ17AdultsWithIncomeAtLatestAnnualAssessmentforStayers(BigInteger.valueOf(0));
		
		q17CashIncomeSourcesDataBeanTable.setQ17AlimonyAtEntry(BigInteger.valueOf(0));
		q17CashIncomeSourcesDataBeanTable.setQ17AlimonyAtExitforLeavers(BigInteger.valueOf(0));
		q17CashIncomeSourcesDataBeanTable.setQ17AlimonyAtLatestAnnualAssessmentforStayers(BigInteger.valueOf(0));
		
		q17CashIncomeSourcesDataBeanTable.setQ17ChildSupportAtEntry(BigInteger.valueOf(0));
		q17CashIncomeSourcesDataBeanTable.setQ17ChildSupportAtExitforLeavers(BigInteger.valueOf(0));
		q17CashIncomeSourcesDataBeanTable.setQ17ChildSupportAtLatestAnnualAssessmentforStayers(BigInteger.valueOf(0));
		
		q17CashIncomeSourcesDataBeanTable.setQ17EarnedIncomeAtEntry(BigInteger.valueOf(0));
		q17CashIncomeSourcesDataBeanTable.setQ17EarnedIncomeAtExitforLeavers(BigInteger.valueOf(0));
		q17CashIncomeSourcesDataBeanTable.setQ17EarnedIncomeAtLatestAnnualAssessmentforStayers(BigInteger.valueOf(0));
		
		q17CashIncomeSourcesDataBeanTable.setQ17GeneralAssistanceAtEntry(BigInteger.valueOf(0));
		q17CashIncomeSourcesDataBeanTable.setQ17GeneralAssistanceAtExitforLeavers(BigInteger.valueOf(0));
		q17CashIncomeSourcesDataBeanTable.setQ17GeneralAssistanceAtLatestAnnualAssessmentforStayers(BigInteger.valueOf(0));
		
		q17CashIncomeSourcesDataBeanTable.setQ17OtherSourcesAtEntry(BigInteger.valueOf(0));
		q17CashIncomeSourcesDataBeanTable.setQ17OtherSourcesAtExitforLeavers(BigInteger.valueOf(0));
		q17CashIncomeSourcesDataBeanTable.setQ17OtherSourcesAtLatestAnnualAssessmentforStayers(BigInteger.valueOf(0));
		
		q17CashIncomeSourcesDataBeanTable.setQ17PensionFormerJobAtEntry(BigInteger.valueOf(0));
		q17CashIncomeSourcesDataBeanTable.setQ17PensionFormerJobAtExitforLeavers(BigInteger.valueOf(0));
		q17CashIncomeSourcesDataBeanTable.setQ17PensionFormerJobAtLatestAnnualAssessmentforStayers(BigInteger.valueOf(0));
		
		q17CashIncomeSourcesDataBeanTable.setQ17PrivateDisabilityAtEntry(BigInteger.valueOf(0));
		q17CashIncomeSourcesDataBeanTable.setQ17PrivateDisabilityAtExitforLeavers(BigInteger.valueOf(0));
		q17CashIncomeSourcesDataBeanTable.setQ17PrivateDisabilityAtLatestAnnualAssessmentforStayers(BigInteger.valueOf(0));
		
		q17CashIncomeSourcesDataBeanTable.setQ17RetirementAtEntry(BigInteger.valueOf(0));
		q17CashIncomeSourcesDataBeanTable.setQ17RetirementAtExitforLeavers(BigInteger.valueOf(0));
		q17CashIncomeSourcesDataBeanTable.setQ17RetirementAtLatestAnnualAssessmentforStayers(BigInteger.valueOf(0));
		
		q17CashIncomeSourcesDataBeanTable.setQ17SSDIAtEntry(BigInteger.valueOf(0));
		q17CashIncomeSourcesDataBeanTable.setQ17SSDIAtExitforLeavers(BigInteger.valueOf(0));
		q17CashIncomeSourcesDataBeanTable.setQ17SSDIAtLatestAnnualAssessmentforStayers(BigInteger.valueOf(0));
		
		q17CashIncomeSourcesDataBeanTable.setQ17SSIAtEntry(BigInteger.valueOf(0));
		q17CashIncomeSourcesDataBeanTable.setQ17SSIAtExitforLeavers(BigInteger.valueOf(0));
		q17CashIncomeSourcesDataBeanTable.setQ17SSIAtLatestAnnualAssessmentforStayers(BigInteger.valueOf(0));
		
		q17CashIncomeSourcesDataBeanTable.setQ17TANFAtEntry(BigInteger.valueOf(0));
		q17CashIncomeSourcesDataBeanTable.setQ17TANFAtExitforLeavers(BigInteger.valueOf(0));
		q17CashIncomeSourcesDataBeanTable.setQ17TANFAtLatestAnnualAssessmentforStayers(BigInteger.valueOf(0));
		
		q17CashIncomeSourcesDataBeanTable.setQ17UnemployementInsuranceAtEntry(BigInteger.valueOf(0));
		q17CashIncomeSourcesDataBeanTable.setQ17UnemployementInsuranceAtExitforLeavers(BigInteger.valueOf(0));
		q17CashIncomeSourcesDataBeanTable.setQ17UnemployementInsuranceAtLatestAnnualAssessmentforStayers(BigInteger.valueOf(0));
		
		q17CashIncomeSourcesDataBeanTable.setQ17VANonServiceAtEntry(BigInteger.valueOf(0));
		q17CashIncomeSourcesDataBeanTable.setQ17VANonServiceAtExitforLeavers(BigInteger.valueOf(0));
		q17CashIncomeSourcesDataBeanTable.setQ17VANonServiceAtLatestAnnualAssessmentforStayers(BigInteger.valueOf(0));
		
		q17CashIncomeSourcesDataBeanTable.setQ17VAServiceAtEntry(BigInteger.valueOf(0));
		q17CashIncomeSourcesDataBeanTable.setQ17VAServiceAtExitforLeavers(BigInteger.valueOf(0));
		q17CashIncomeSourcesDataBeanTable.setQ17VAServiceAtLatestAnnualAssessmentforStayers(BigInteger.valueOf(0));
		
		q17CashIncomeSourcesDataBeanTable.setQ17WorkersCompensationAtEntry(BigInteger.valueOf(0));
		q17CashIncomeSourcesDataBeanTable.setQ17WorkersCompensationAtExitforLeavers(BigInteger.valueOf(0));
		q17CashIncomeSourcesDataBeanTable.setQ17WorkersCompensationAtLatestAnnualAssessmentforStayers(BigInteger.valueOf(0));
		
		
		
		
		return Arrays.asList(q17CashIncomeSourcesDataBeanTable);
	}

}
