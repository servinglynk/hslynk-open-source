package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import com.servinglynk.report.bean.Q17CashIncomeSourcesDataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.IncomeAndSourceModel;

public class Q17DataBeanMaker extends BaseBeanMaker {
	
	public static List<Q17CashIncomeSourcesDataBean> getQ17CashIncomeSourcesList(ReportData data){
		/**********************
		 * ANY changs to this file needs changes in Q25g
		 */
		Q17CashIncomeSourcesDataBean q17CashIncomeSourcesDataBeanTable =new Q17CashIncomeSourcesDataBean();
		if(data.isLiveMode()) {
		try{
			
			List<IncomeAndSourceModel> incomeAndSourcesAtEntry = data.getIncomeAndSourcesAtEntry();
			List<IncomeAndSourceModel> incomeAndSourcesAtExit = data.getIncomeAndSourcesAtExit();
			List<IncomeAndSourceModel> incomeAndSourcesAtAnnualAssesment = data.getIncomeAndSourcesAtAnnualAssesment();
			
			List<IncomeAndSourceModel> anamolyAtEntry = incomeAndSourcesAtEntry.parallelStream().filter(incomeAndSource -> StringUtils.equals("1", incomeAndSource.getAlimony())).collect(Collectors.toList());
			List<IncomeAndSourceModel> anamolyAtExit = incomeAndSourcesAtExit.parallelStream().filter(incomeAndSource -> StringUtils.equals("1", incomeAndSource.getAlimony())).collect(Collectors.toList());
			List<IncomeAndSourceModel> anamolyAtAA = incomeAndSourcesAtAnnualAssesment.parallelStream().filter(incomeAndSource -> StringUtils.equals("1", incomeAndSource.getAlimony())).collect(Collectors.toList());
			
		
		int alimonyIncomeAtEntry = getIncomeCnt(anamolyAtEntry);
		int alimonyIncomeAtExit = getIncomeCnt(anamolyAtExit);
		int alimonyIncomeAtAnnualAssesment = getIncomeCnt(anamolyAtAA);
		
		q17CashIncomeSourcesDataBeanTable.setQ17AlimonyAtEntry(BigInteger.valueOf(alimonyIncomeAtEntry));
		q17CashIncomeSourcesDataBeanTable.setQ17AlimonyAtExitforLeavers(BigInteger.valueOf(alimonyIncomeAtExit));
		q17CashIncomeSourcesDataBeanTable.setQ17AlimonyAtLatestAnnualAssessmentforStayers(BigInteger.valueOf(alimonyIncomeAtAnnualAssesment));
		
		
		List<IncomeAndSourceModel> childSupportAtEntry = incomeAndSourcesAtEntry.parallelStream().filter(incomeAndSource -> StringUtils.equals("1", incomeAndSource.getChildsupport())).collect(Collectors.toList());
		List<IncomeAndSourceModel> childSupportAtExit = incomeAndSourcesAtExit.parallelStream().filter(incomeAndSource -> StringUtils.equals("1", incomeAndSource.getChildsupport())).collect(Collectors.toList());
		List<IncomeAndSourceModel> childSupportAtAA = incomeAndSourcesAtAnnualAssesment.parallelStream().filter(incomeAndSource -> StringUtils.equals("1", incomeAndSource.getChildsupport())).collect(Collectors.toList());
		
		int childsupportIncomeAtEntry = getIncomeCnt(childSupportAtEntry);
		int childsupportIncomeAtExit = getIncomeCnt(childSupportAtExit);
		int childsupportIncomeAtAnnualAssesment = getIncomeCnt(childSupportAtAA);
		
		q17CashIncomeSourcesDataBeanTable.setQ17ChildSupportAtEntry(BigInteger.valueOf(childsupportIncomeAtEntry));
		q17CashIncomeSourcesDataBeanTable.setQ17ChildSupportAtExitforLeavers(BigInteger.valueOf(childsupportIncomeAtExit));
		q17CashIncomeSourcesDataBeanTable.setQ17ChildSupportAtLatestAnnualAssessmentforStayers(BigInteger.valueOf(childsupportIncomeAtAnnualAssesment));
		
		List<IncomeAndSourceModel> earnedAtEntry = incomeAndSourcesAtEntry.parallelStream().filter(incomeAndSource -> StringUtils.equals("1", incomeAndSource.getEarned())).collect(Collectors.toList());
		List<IncomeAndSourceModel> earnedAtExit = incomeAndSourcesAtExit.parallelStream().filter(incomeAndSource -> StringUtils.equals("1", incomeAndSource.getEarned())).collect(Collectors.toList());
		List<IncomeAndSourceModel> earnedtAtAA = incomeAndSourcesAtAnnualAssesment.parallelStream().filter(incomeAndSource -> StringUtils.equals("1", incomeAndSource.getEarned())).collect(Collectors.toList());
		
		int earnedIncomeAtEntry = getIncomeCnt(earnedAtEntry);
		int earnedIncomeAtExit = getIncomeCnt(earnedAtExit);
		int earnedIncomeAtAnnualAssesment = getIncomeCnt(earnedtAtAA);
		
		q17CashIncomeSourcesDataBeanTable.setQ17EarnedIncomeAtEntry(BigInteger.valueOf(earnedIncomeAtEntry));
		q17CashIncomeSourcesDataBeanTable.setQ17EarnedIncomeAtExitforLeavers(BigInteger.valueOf(earnedIncomeAtExit));
		q17CashIncomeSourcesDataBeanTable.setQ17EarnedIncomeAtLatestAnnualAssessmentforStayers(BigInteger.valueOf(earnedIncomeAtAnnualAssesment));
		
		List<IncomeAndSourceModel> gaAtEntry = incomeAndSourcesAtEntry.parallelStream().filter(incomeAndSource -> StringUtils.equals("1", incomeAndSource.getGa())).collect(Collectors.toList());
		List<IncomeAndSourceModel> gaAtExit = incomeAndSourcesAtExit.parallelStream().filter(incomeAndSource -> StringUtils.equals("1", incomeAndSource.getGa())).collect(Collectors.toList());
		List<IncomeAndSourceModel> gaAtAA = incomeAndSourcesAtAnnualAssesment.parallelStream().filter(incomeAndSource -> StringUtils.equals("1", incomeAndSource.getGa())).collect(Collectors.toList());
		
		
		int gaIncomeAtEntry = getIncomeCnt(gaAtEntry);
		int gaIncomeAtExit = getIncomeCnt(gaAtExit);
		int gaIncomeAtAnnualAssesment = getIncomeCnt(gaAtAA);
		
		q17CashIncomeSourcesDataBeanTable.setQ17GeneralAssistanceAtEntry(BigInteger.valueOf(gaIncomeAtEntry));
		q17CashIncomeSourcesDataBeanTable.setQ17GeneralAssistanceAtExitforLeavers(BigInteger.valueOf(gaIncomeAtExit));
		q17CashIncomeSourcesDataBeanTable.setQ17GeneralAssistanceAtLatestAnnualAssessmentforStayers(BigInteger.valueOf(gaIncomeAtAnnualAssesment));
		
		List<IncomeAndSourceModel> otherSourceAtEntry = incomeAndSourcesAtEntry.parallelStream().filter(incomeAndSource -> StringUtils.equals("1", incomeAndSource.getOthersource())).collect(Collectors.toList());
		List<IncomeAndSourceModel> otherSourceAtExit = incomeAndSourcesAtExit.parallelStream().filter(incomeAndSource -> StringUtils.equals("1", incomeAndSource.getOthersource())).collect(Collectors.toList());
		List<IncomeAndSourceModel> otherSourceAtAA = incomeAndSourcesAtAnnualAssesment.parallelStream().filter(incomeAndSource -> StringUtils.equals("1", incomeAndSource.getOthersource())).collect(Collectors.toList());
		
		int othersourceIncomeAtEntry = getIncomeCnt(otherSourceAtEntry);
		int othersourceIncomeAtExit = getIncomeCnt(otherSourceAtExit);
		int othersourceIncomeAtAnnualAssesment = getIncomeCnt(otherSourceAtAA);
		
		q17CashIncomeSourcesDataBeanTable.setQ17OtherSourcesAtEntry(BigInteger.valueOf(othersourceIncomeAtEntry));
		q17CashIncomeSourcesDataBeanTable.setQ17OtherSourcesAtExitforLeavers(BigInteger.valueOf(othersourceIncomeAtExit));
		q17CashIncomeSourcesDataBeanTable.setQ17OtherSourcesAtLatestAnnualAssessmentforStayers(BigInteger.valueOf(othersourceIncomeAtAnnualAssesment));
		
		
		List<IncomeAndSourceModel> pensionAtEntry = incomeAndSourcesAtEntry.parallelStream().filter(incomeAndSource -> StringUtils.equals("1", incomeAndSource.getPension())).collect(Collectors.toList());
		List<IncomeAndSourceModel> pensionAtExit = incomeAndSourcesAtExit.parallelStream().filter(incomeAndSource -> StringUtils.equals("1", incomeAndSource.getPension())).collect(Collectors.toList());
		List<IncomeAndSourceModel> pensioneAtAA = incomeAndSourcesAtAnnualAssesment.parallelStream().filter(incomeAndSource -> StringUtils.equals("1", incomeAndSource.getPension())).collect(Collectors.toList());
		
		
		int pensionIncomeAtEntry = getIncomeCnt(pensionAtEntry);
		int pensionIncomeAtExit = getIncomeCnt(pensionAtExit);
		int pensionIncomeAtAnnualAssesment = getIncomeCnt(pensioneAtAA);
		
		q17CashIncomeSourcesDataBeanTable.setQ17PensionFormerJobAtEntry(BigInteger.valueOf(pensionIncomeAtEntry));
		q17CashIncomeSourcesDataBeanTable.setQ17PensionFormerJobAtExitforLeavers(BigInteger.valueOf(pensionIncomeAtExit));
		q17CashIncomeSourcesDataBeanTable.setQ17PensionFormerJobAtLatestAnnualAssessmentforStayers(BigInteger.valueOf(pensionIncomeAtAnnualAssesment));
		
		
		List<IncomeAndSourceModel> privatedisabilityAtEntry = incomeAndSourcesAtEntry.parallelStream().filter(incomeAndSource -> StringUtils.equals("1", incomeAndSource.getPrivatedisability())).collect(Collectors.toList());
		List<IncomeAndSourceModel> privatedisabilityAtExit = incomeAndSourcesAtExit.parallelStream().filter(incomeAndSource -> StringUtils.equals("1", incomeAndSource.getPrivatedisability())).collect(Collectors.toList());
		List<IncomeAndSourceModel> privatedisabilityAtAA = incomeAndSourcesAtAnnualAssesment.parallelStream().filter(incomeAndSource -> StringUtils.equals("1", incomeAndSource.getPrivatedisability())).collect(Collectors.toList());
		
		
		int privatedisabilityIncomeAtEntry = getIncomeCnt(privatedisabilityAtEntry);
		int privatedisabilityIncomeAtExit = getIncomeCnt(privatedisabilityAtExit);
		int privatedisabilityIncomeAtAnnualAssesment = getIncomeCnt(privatedisabilityAtAA);
		
		q17CashIncomeSourcesDataBeanTable.setQ17PrivateDisabilityAtEntry(BigInteger.valueOf(privatedisabilityIncomeAtEntry));
		q17CashIncomeSourcesDataBeanTable.setQ17PrivateDisabilityAtExitforLeavers(BigInteger.valueOf(privatedisabilityIncomeAtExit));
		q17CashIncomeSourcesDataBeanTable.setQ17PrivateDisabilityAtLatestAnnualAssessmentforStayers(BigInteger.valueOf(privatedisabilityIncomeAtAnnualAssesment));
		
		List<IncomeAndSourceModel> socsecretirementAtEntry = incomeAndSourcesAtEntry.parallelStream().filter(incomeAndSource -> StringUtils.equals("1", incomeAndSource.getSocsecretirement())).collect(Collectors.toList());
		List<IncomeAndSourceModel> socsecretirementAtExit = incomeAndSourcesAtExit.parallelStream().filter(incomeAndSource -> StringUtils.equals("1", incomeAndSource.getPrivatedisability())).collect(Collectors.toList());
		List<IncomeAndSourceModel> socsecretirementAtAA = incomeAndSourcesAtAnnualAssesment.parallelStream().filter(incomeAndSource -> StringUtils.equals("1", incomeAndSource.getPrivatedisability())).collect(Collectors.toList());
		
		
		int socsecretirementIncomeAtEntry = getIncomeCnt(socsecretirementAtEntry);
		int socsecretirementIncomeAtExit = getIncomeCnt(socsecretirementAtExit);
		int socsecretirementIncomeAtAnnualAssesment = getIncomeCnt(socsecretirementAtAA);
		
		q17CashIncomeSourcesDataBeanTable.setQ17RetirementAtEntry(BigInteger.valueOf(socsecretirementIncomeAtEntry));
		q17CashIncomeSourcesDataBeanTable.setQ17RetirementAtExitforLeavers(BigInteger.valueOf(socsecretirementIncomeAtExit));
		q17CashIncomeSourcesDataBeanTable.setQ17RetirementAtLatestAnnualAssessmentforStayers(BigInteger.valueOf(socsecretirementIncomeAtAnnualAssesment));
		
		List<IncomeAndSourceModel> ssdiAtEntry = incomeAndSourcesAtEntry.parallelStream().filter(incomeAndSource -> StringUtils.equals("1", incomeAndSource.getSsdi())).collect(Collectors.toList());
		List<IncomeAndSourceModel> ssdiAtExit = incomeAndSourcesAtExit.parallelStream().filter(incomeAndSource -> StringUtils.equals("1", incomeAndSource.getSsdi())).collect(Collectors.toList());
		List<IncomeAndSourceModel> ssdiAtAA = incomeAndSourcesAtAnnualAssesment.parallelStream().filter(incomeAndSource -> StringUtils.equals("1", incomeAndSource.getSsdi())).collect(Collectors.toList());
		
		int ssdiIncomeAtEntry = getIncomeCnt(ssdiAtEntry);
		int ssdiIncomeAtExit = getIncomeCnt(ssdiAtExit);
		int ssdiIncomeAtAnnualAssesment = getIncomeCnt(ssdiAtAA);
		
		q17CashIncomeSourcesDataBeanTable.setQ17SSDIAtEntry(BigInteger.valueOf(ssdiIncomeAtEntry));
		q17CashIncomeSourcesDataBeanTable.setQ17SSDIAtExitforLeavers(BigInteger.valueOf(ssdiIncomeAtExit));
		q17CashIncomeSourcesDataBeanTable.setQ17SSDIAtLatestAnnualAssessmentforStayers(BigInteger.valueOf(ssdiIncomeAtAnnualAssesment));
	
		List<IncomeAndSourceModel> ssiAtEntry = incomeAndSourcesAtEntry.parallelStream().filter(incomeAndSource -> StringUtils.equals("1", incomeAndSource.getSsi())).collect(Collectors.toList());
		List<IncomeAndSourceModel> ssiAtExit = incomeAndSourcesAtExit.parallelStream().filter(incomeAndSource -> StringUtils.equals("1", incomeAndSource.getSsi())).collect(Collectors.toList());
		List<IncomeAndSourceModel> ssiAtAA = incomeAndSourcesAtAnnualAssesment.parallelStream().filter(incomeAndSource -> StringUtils.equals("1", incomeAndSource.getSsi())).collect(Collectors.toList());
		
		
		int ssiIncomeAtEntry = getIncomeCnt(ssiAtEntry);
		int ssiIncomeAtExit = getIncomeCnt(ssiAtExit);
		int ssiIncomeAtAnnualAssesment = getIncomeCnt(ssiAtAA);
		
		q17CashIncomeSourcesDataBeanTable.setQ17SSIAtEntry(BigInteger.valueOf(ssiIncomeAtEntry));
		q17CashIncomeSourcesDataBeanTable.setQ17SSIAtExitforLeavers(BigInteger.valueOf(ssiIncomeAtExit));
		q17CashIncomeSourcesDataBeanTable.setQ17SSIAtLatestAnnualAssessmentforStayers(BigInteger.valueOf(ssiIncomeAtAnnualAssesment));
		
		List<IncomeAndSourceModel> tanfAtEntry = incomeAndSourcesAtEntry.parallelStream().filter(incomeAndSource -> StringUtils.equals("1", incomeAndSource.getTanf())).collect(Collectors.toList());
		List<IncomeAndSourceModel> tanfAtExit = incomeAndSourcesAtExit.parallelStream().filter(incomeAndSource -> StringUtils.equals("1", incomeAndSource.getTanf())).collect(Collectors.toList());
		List<IncomeAndSourceModel> tanfAtAA = incomeAndSourcesAtAnnualAssesment.parallelStream().filter(incomeAndSource -> StringUtils.equals("1", incomeAndSource.getTanf())).collect(Collectors.toList());
		
		int tanfIncomeAtEntry = getIncomeCnt(tanfAtEntry);
		int tanfIncomeAtExit = getIncomeCnt(tanfAtExit);
		int tanfIncomeAtAnnualAssesment = getIncomeCnt(tanfAtAA);
		
		q17CashIncomeSourcesDataBeanTable.setQ17TANFAtEntry(BigInteger.valueOf(tanfIncomeAtEntry));
		q17CashIncomeSourcesDataBeanTable.setQ17TANFAtExitforLeavers(BigInteger.valueOf(tanfIncomeAtExit));
		q17CashIncomeSourcesDataBeanTable.setQ17TANFAtLatestAnnualAssessmentforStayers(BigInteger.valueOf(tanfIncomeAtAnnualAssesment));
		
		List<IncomeAndSourceModel> unemploymentAtEntry = incomeAndSourcesAtEntry.parallelStream().filter(incomeAndSource -> StringUtils.equals("1", incomeAndSource.getUnemployment())).collect(Collectors.toList());
		List<IncomeAndSourceModel> unemploymentAtExit = incomeAndSourcesAtExit.parallelStream().filter(incomeAndSource -> StringUtils.equals("1", incomeAndSource.getTanf())).collect(Collectors.toList());
		List<IncomeAndSourceModel> unemploymentAtAA = incomeAndSourcesAtAnnualAssesment.parallelStream().filter(incomeAndSource -> StringUtils.equals("1", incomeAndSource.getTanf())).collect(Collectors.toList());
		
		int unemploymentIncomeAtEntry = getIncomeCnt(unemploymentAtEntry);
		int unemploymentIncomeAtExit = getIncomeCnt(unemploymentAtExit);
		int unemploymentIncomeAtAnnualAssesment = getIncomeCnt(unemploymentAtAA);
		
		q17CashIncomeSourcesDataBeanTable.setQ17UnemployementInsuranceAtEntry(BigInteger.valueOf(unemploymentIncomeAtEntry));
		q17CashIncomeSourcesDataBeanTable.setQ17UnemployementInsuranceAtExitforLeavers(BigInteger.valueOf(unemploymentIncomeAtExit));
		q17CashIncomeSourcesDataBeanTable.setQ17UnemployementInsuranceAtLatestAnnualAssessmentforStayers(BigInteger.valueOf(unemploymentIncomeAtAnnualAssesment));
		
		
		List<IncomeAndSourceModel> vadisabilitynonserviceAtEntry = incomeAndSourcesAtEntry.parallelStream().filter(incomeAndSource -> StringUtils.equals("1", incomeAndSource.getVadisabilitynonservice())).collect(Collectors.toList());
		List<IncomeAndSourceModel> vadisabilitynonserviceAtExit = incomeAndSourcesAtExit.parallelStream().filter(incomeAndSource -> StringUtils.equals("1", incomeAndSource.getVadisabilitynonservice())).collect(Collectors.toList());
		List<IncomeAndSourceModel> vadisabilitynonserviceAtAA = incomeAndSourcesAtAnnualAssesment.parallelStream().filter(incomeAndSource -> StringUtils.equals("1", incomeAndSource.getVadisabilitynonservice())).collect(Collectors.toList());
		
		
		int vadisabilitynonserviceIncomeAtEntry = getIncomeCnt(vadisabilitynonserviceAtEntry);
		int vadisabilitynonserviceIncomeAtExit = getIncomeCnt(vadisabilitynonserviceAtExit);
		int vadisabilitynonserviceIncomeAtAnnualAssesment = getIncomeCnt(vadisabilitynonserviceAtAA);
		
		q17CashIncomeSourcesDataBeanTable.setQ17VANonServiceAtEntry(BigInteger.valueOf(vadisabilitynonserviceIncomeAtEntry));
		q17CashIncomeSourcesDataBeanTable.setQ17VANonServiceAtExitforLeavers(BigInteger.valueOf(vadisabilitynonserviceIncomeAtExit));
		q17CashIncomeSourcesDataBeanTable.setQ17VANonServiceAtLatestAnnualAssessmentforStayers(BigInteger.valueOf(vadisabilitynonserviceIncomeAtAnnualAssesment));
		
		List<IncomeAndSourceModel> vadisabilityserviceAtEntry = incomeAndSourcesAtEntry.parallelStream().filter(incomeAndSource -> StringUtils.equals("1", incomeAndSource.getVadisabilityservice())).collect(Collectors.toList());
		List<IncomeAndSourceModel> vadisabilityserviceAtExit = incomeAndSourcesAtExit.parallelStream().filter(incomeAndSource -> StringUtils.equals("1", incomeAndSource.getVadisabilityservice())).collect(Collectors.toList());
		List<IncomeAndSourceModel> vadisabilityserviceAtAA = incomeAndSourcesAtAnnualAssesment.parallelStream().filter(incomeAndSource -> StringUtils.equals("1", incomeAndSource.getVadisabilityservice())).collect(Collectors.toList());
		
		
		int vadisabilityserviceIncomeAtEntry = getIncomeCnt(vadisabilityserviceAtEntry);
		int vadisabilityserviceIncomeAtExit = getIncomeCnt(vadisabilityserviceAtExit);
		int vadisabilityserviceIncomeAtAnnualAssesment = getIncomeCnt(vadisabilityserviceAtAA);
		
		q17CashIncomeSourcesDataBeanTable.setQ17VAServiceAtEntry(BigInteger.valueOf(vadisabilityserviceIncomeAtEntry));
		q17CashIncomeSourcesDataBeanTable.setQ17VAServiceAtExitforLeavers(BigInteger.valueOf(vadisabilityserviceIncomeAtExit));
		q17CashIncomeSourcesDataBeanTable.setQ17VAServiceAtLatestAnnualAssessmentforStayers(BigInteger.valueOf(vadisabilityserviceIncomeAtAnnualAssesment));
		
		List<IncomeAndSourceModel> workerscompAtEntry = incomeAndSourcesAtEntry.parallelStream().filter(incomeAndSource -> StringUtils.equals("1", incomeAndSource.getWorkerscomp())).collect(Collectors.toList());
		List<IncomeAndSourceModel> workerscompAtExit = incomeAndSourcesAtExit.parallelStream().filter(incomeAndSource -> StringUtils.equals("1", incomeAndSource.getWorkerscomp())).collect(Collectors.toList());
		List<IncomeAndSourceModel> workerscompAtAA = incomeAndSourcesAtAnnualAssesment.parallelStream().filter(incomeAndSource -> StringUtils.equals("1", incomeAndSource.getWorkerscomp())).collect(Collectors.toList());
		
		int workerscompIncomeAtEntry = getIncomeCnt(workerscompAtEntry);
		int workerscompIncomeAtExit = getIncomeCnt(workerscompAtExit);
		int workerscompIncomeAtAnnualAssesment = getIncomeCnt(workerscompAtAA);
		
		q17CashIncomeSourcesDataBeanTable.setQ17WorkersCompensationAtEntry(BigInteger.valueOf(workerscompIncomeAtEntry));
		q17CashIncomeSourcesDataBeanTable.setQ17WorkersCompensationAtExitforLeavers(BigInteger.valueOf(workerscompIncomeAtExit));
		q17CashIncomeSourcesDataBeanTable.setQ17WorkersCompensationAtLatestAnnualAssessmentforStayers(BigInteger.valueOf(workerscompIncomeAtAnnualAssesment));
		
		
		List<IncomeAndSourceModel> incomeAtExit = data.getIncomeAndSourcesAtExit();
		List<IncomeAndSourceModel> incomeAtAA = data.getIncomeAndSourcesAtAnnualAssesment();
		
		List<IncomeAndSourceModel> d17IncomeAtEntry = incomeAndSourcesAtEntry.parallelStream().filter(incomeAndSource -> StringUtils.equals("1", incomeAndSource.getIncomefromanysource()) ||  StringUtils.equals("2", incomeAndSource.getIncomefromanysource()) ).collect(Collectors.toList());
		List<IncomeAndSourceModel> d17IncomeAtExit = incomeAndSourcesAtExit.parallelStream().filter(incomeAndSource -> StringUtils.equals("1", incomeAndSource.getIncomefromanysource()) ||  StringUtils.equals("2", incomeAndSource.getIncomefromanysource()) ).collect(Collectors.toList());
		List<String> d17EntryList = new ArrayList<String>();
		d17IncomeAtEntry.forEach(income -> d17EntryList.add(income.getDedupClientId()));
		List<String> d17ExitList = new ArrayList<String>();
		d17IncomeAtExit.forEach(income -> d17ExitList.add(income.getDedupClientId()));
		d17EntryList.retainAll(d17ExitList);
		q17CashIncomeSourcesDataBeanTable.setQ17AdultsWithIncomeAtEntry(BigInteger.ZERO);
		q17CashIncomeSourcesDataBeanTable.setQ17AdultsWithIncomeAtExitforLeavers(BigInteger.valueOf(d17EntryList != null? d17EntryList.size() : 0));
		q17CashIncomeSourcesDataBeanTable.setQ17AdultsWithIncomeAtLatestAnnualAssessmentforStayers(BigInteger.valueOf(getIncomeCntWithIncome(incomeAtAA)));
		
	
	} catch (Exception e) {
		logger.error("Error in Q17BeanMaker:" + e);
	}
		}
		return Arrays.asList(q17CashIncomeSourcesDataBeanTable);
	}

}
