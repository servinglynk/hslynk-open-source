package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import com.servinglynk.report.bean.Q18ClientCashIncomeCategoryEarnedOtherIncomeDataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.IncomeAndSourceModel;
import com.servinglynk.report.model.NoYesEnum;

public class Q18DataBeanMaker extends BaseBeanMaker {

	public static List<Q18ClientCashIncomeCategoryEarnedOtherIncomeDataBean> getQ18ClientCashIncomeCategoryEarnedOtherIncomeList(ReportData data){
		
		Q18ClientCashIncomeCategoryEarnedOtherIncomeDataBean q18eData = new Q18ClientCashIncomeCategoryEarnedOtherIncomeDataBean();
//		
//		String query = " select count(dedup_client_id)  from %s.incomeandsources i, %s.enrollment e where i.datacollectionstage='1' and  e.project_entry_id=i.enrollmentid "+ 
//				" and i.information_date >= e.entrydate and i.information_date >= ? and i.information_date <= ? and e.ageatentry >= 18 ";
//
//		
		if(data.isLiveMode()) {
		try {
	
		
		List<IncomeAndSourceModel> incomeAtEntry = data.getIncomeAndSourcesAtEntry();
		List<IncomeAndSourceModel> incomeAtExit = data.getIncomeAndSourcesAtExit();
		List<IncomeAndSourceModel> incomeAndSourcesAtAnnualAssesment = data.getIncomeAndSourcesAtAnnualAssesment();
		
		q18eData.setQ18AdultsWithIncomeInfoAtEntryNumberOfAdultsAtEntry(BigInteger.ZERO);
		q18eData.setQ18AdultsWithIncomeInfoAtEntryNumberOfAdultsAtExit(BigInteger.valueOf(getIncomeCntWithIncome(incomeAtExit) ));
		q18eData.setQ18AdultsWithIncomeInfoAtEntryNumberOfAdultsAtFollowup(BigInteger.valueOf(getIncomeCntWithIncome(incomeAndSourcesAtAnnualAssesment)));
		
		List<IncomeAndSourceModel> earnedIncomeAtEntry = incomeAtEntry.parallelStream().filter(income -> getFloat(income.getEarnedamount()) > 0 &&  (getFloat(income.getTotalmonthlyincome()) - getFloat(income.getOthersourceamount())) == 0).collect(Collectors.toList());
		List<IncomeAndSourceModel> earnedIncomeAtsAtExit = incomeAtExit.parallelStream().filter(income -> getFloat(income.getEarnedamount()) > 0  && (getFloat(income.getTotalmonthlyincome()) - getFloat(income.getOthersourceamount()))  == 0).collect(Collectors.toList());
		List<IncomeAndSourceModel> earnedIncomeAtAnnualAssesment = incomeAndSourcesAtAnnualAssesment.parallelStream().filter(income -> getFloat(income.getEarnedamount()) > 0 &&  (getFloat(income.getTotalmonthlyincome()) - getFloat(income.getOthersourceamount())) == 0).collect(Collectors.toList());
		
		q18eData.setQ18AdultsWithOnlyEarnedIncomeNumberOfAdultsAtEntry(BigInteger.valueOf(getIncomeCnt(earnedIncomeAtEntry)));
		q18eData.setQ18AdultsWithOnlyEarnedIncomeNumberOfAdultsAtExit(BigInteger.valueOf(getIncomeCnt(earnedIncomeAtsAtExit)));
		q18eData.setQ18AdultsWithOnlyEarnedIncomeNumberOfAdultsAtFollowup(BigInteger.valueOf(getIncomeCnt(earnedIncomeAtAnnualAssesment)));
		
		List<IncomeAndSourceModel> bothEarnedAndOtherIncomeAtEntry = incomeAtEntry.parallelStream().filter(income -> getFloat(income.getEarnedamount()) > 0 &&  (getFloat(income.getTotalmonthlyincome()) - getFloat(income.getOthersourceamount())) > 0).collect(Collectors.toList());
		List<IncomeAndSourceModel> bothEarnedAndOtherIncomeAtsAtExit = incomeAtExit.parallelStream().filter(income -> getFloat(income.getEarnedamount()) > 0 &&  (getFloat(income.getTotalmonthlyincome()) - getFloat(income.getOthersourceamount())) > 0).collect(Collectors.toList());
		List<IncomeAndSourceModel> bothEarnedAndOtherIncomeAtAnnualAssesment = incomeAndSourcesAtAnnualAssesment.parallelStream().filter(income -> getFloat(income.getEarnedamount()) > 0 &&  (getFloat(income.getTotalmonthlyincome()) - getFloat(income.getOthersourceamount())) > 0).collect(Collectors.toList());
		
		q18eData.setQ18AdultsWithBothEarnedAndOtherIncomeNumberOfAdultsAtEntry(BigInteger.valueOf(getIncomeCnt(bothEarnedAndOtherIncomeAtEntry)));
		q18eData.setQ18AdultsWithBothEarnedAndOtherIncomeNumberOfAdultsAtExit(BigInteger.valueOf(getIncomeCnt(bothEarnedAndOtherIncomeAtsAtExit)));
		q18eData.setQ18AdultsWithBothEarnedAndOtherNumberOfAdultsAtFollowup(BigInteger.valueOf(getIncomeCnt(bothEarnedAndOtherIncomeAtAnnualAssesment)));
		
		List<IncomeAndSourceModel> noearnedIncomeAtEntry = incomeAtEntry.parallelStream().filter(income -> getFloat(income.getEarnedamount()) == 0 ).collect(Collectors.toList());
		List<IncomeAndSourceModel> noearnedIncomeAtExit = incomeAtExit.parallelStream().filter(income -> getFloat(income.getEarnedamount()) == 0 ).collect(Collectors.toList());
		List<IncomeAndSourceModel> noearnedIncomeAtAnnualAssesment = incomeAndSourcesAtAnnualAssesment.parallelStream().filter(income -> getFloat(income.getEarnedamount()) == 0 ).collect(Collectors.toList());
		
		
		List<IncomeAndSourceModel> otherIncomeAtEntry = noearnedIncomeAtEntry.parallelStream().filter(income ->  ((getFloat(income.getTotalmonthlyincome()) - getFloat(income.getOthersourceamount())) > 0)).collect(Collectors.toList());
		List<IncomeAndSourceModel> otherIncomeAtsAtExit = noearnedIncomeAtExit.parallelStream().filter(income ->  ((getFloat(income.getTotalmonthlyincome()) - getFloat(income.getOthersourceamount())) > 0)).collect(Collectors.toList());
		List<IncomeAndSourceModel> otherIncomeAtAnnualAssesment = noearnedIncomeAtAnnualAssesment.parallelStream().filter(income ->  ((getFloat(income.getTotalmonthlyincome()) - getFloat(income.getOthersourceamount())) > 0)).collect(Collectors.toList());
		

		q18eData.setQ18AdultsWithOnlyOtherIncomeNumberOfAdultsAtEntry(BigInteger.valueOf(getIncomeCnt(otherIncomeAtEntry)));
		q18eData.setQ18AdultsWithOnlyOtherIncomeNumberOfAdultsAtExit(BigInteger.valueOf(getIncomeCnt(otherIncomeAtsAtExit)));
		q18eData.setQ18AdultsWithOnlyOtherIncomeNumberOfAdultsAtFollowup(BigInteger.valueOf(getIncomeCnt(otherIncomeAtAnnualAssesment)));
		
		List<IncomeAndSourceModel> dkIncomeAtEntry = incomeAtEntry.parallelStream().filter(income -> income != null && ( StringUtils.equals(NoYesEnum.EIGHT.getValue(), income.getIncomefromanysource()) || StringUtils.equals(NoYesEnum.NINE.getValue(), income.getIncomefromanysource())) ).collect(Collectors.toList());
		List<IncomeAndSourceModel> dkIncomeAtsAtExit = incomeAtExit.parallelStream().filter(income -> income != null && ( StringUtils.equals(NoYesEnum.EIGHT.getValue(), income.getIncomefromanysource()) || StringUtils.equals(NoYesEnum.NINE.getValue(), income.getIncomefromanysource())) ).collect(Collectors.toList());
		List<IncomeAndSourceModel> dkIncomeAtAnnualAssesment = incomeAndSourcesAtAnnualAssesment.parallelStream().filter(income -> income != null && ( StringUtils.equals(NoYesEnum.EIGHT.getValue(), income.getIncomefromanysource()) || StringUtils.equals(NoYesEnum.NINE.getValue(), income.getIncomefromanysource())) ).collect(Collectors.toList());

		q18eData.setQ18AdultsWithDKRNumberOfAdultsAtEntry(BigInteger.valueOf(getIncomeCnt(dkIncomeAtEntry)));
		q18eData.setQ18AdultsWithDKRNumberOfAdultsAtExit(BigInteger.valueOf(getIncomeCnt(dkIncomeAtsAtExit)));
		q18eData.setQ18AdultsWithDKRNumberOfAdultsAtFollowup(BigInteger.valueOf(getIncomeCnt(dkIncomeAtAnnualAssesment)));
		
		List<IncomeAndSourceModel> missingIncomeAtEntry = incomeAtEntry.parallelStream().filter(income -> income != null && ( StringUtils.equals(NoYesEnum.NINTY_NINE.getValue(), income.getIncomefromanysource()) )).collect(Collectors.toList());
		List<IncomeAndSourceModel> missingIncomeAtsAtExit = incomeAtExit.parallelStream().filter(income -> income != null && ( StringUtils.equals(NoYesEnum.NINTY_NINE.getValue(), income.getIncomefromanysource()) )).collect(Collectors.toList());
		List<IncomeAndSourceModel> missingIncomeAtAnnualAssesment = noearnedIncomeAtAnnualAssesment.parallelStream().filter(income -> income != null && ( StringUtils.equals(NoYesEnum.NINTY_NINE.getValue(), income.getIncomefromanysource()) )).collect(Collectors.toList());
		
	
		q18eData.setQ18AdultsWithMissingInfoNumberOfAdultsAtEntry(BigInteger.valueOf(getIncomeCnt(missingIncomeAtEntry)));
		q18eData.setQ18AdultsWithMissingInfoNumberOfAdultsAtExit(BigInteger.valueOf(getIncomeCnt(missingIncomeAtsAtExit)));
		q18eData.setQ18AdultsWithMissingInfoNumberOfAdultsAtFollowup(BigInteger.valueOf(getIncomeCnt(missingIncomeAtAnnualAssesment)));
		
		List<IncomeAndSourceModel> noIncomeAtEntry = incomeAtEntry.parallelStream().filter(income -> getFloat(income.getTotalmonthlyincome()) == 0 ).collect(Collectors.toList());
		List<IncomeAndSourceModel> noIncomeAtsAtExit = incomeAtExit.parallelStream().filter(income -> getFloat(income.getTotalmonthlyincome()) == 0 ).collect(Collectors.toList());
		List<IncomeAndSourceModel> noIncomeAtAnnualAssesment = noearnedIncomeAtAnnualAssesment.parallelStream().filter(income -> getFloat(income.getTotalmonthlyincome()) == 0 ).collect(Collectors.toList());
		
		
		q18eData.setQ18AdultsWithNoIncomeNumberOfAdultsAtEntry(BigInteger.valueOf(getIncomeCnt(noIncomeAtEntry)));
		q18eData.setQ18AdultsWithNoIncomeNumberOfAdultsAtExit(BigInteger.valueOf(getIncomeCnt(noIncomeAtsAtExit)));
		q18eData.setQ18AdultsWithNoOtherNumberOfAdultsAtFollowup(BigInteger.valueOf(getIncomeCnt(noIncomeAtAnnualAssesment)));
		
		
	
		q18eData.setQ18NumberOfAdultStayersNotRequiredNumberOfAdultsAtEntry(BigInteger.valueOf(0));
		q18eData.setQ18NumberOfAdultStayersNotRequiredNumberOfAdultsAtExit(BigInteger.valueOf(0));
		q18eData.setQ18NumberOfAdultStayersNotRequiredNumberOfAdultsAtFollowup(data.getNumOfAdultStayersNotRequiredAnnualAssesment());
		
		q18eData.setQ18NumberOfAdultStayersWithoutRequiredNumberOfAdultsAtEntry(BigInteger.valueOf(0));
		q18eData.setQ18NumberOfAdultStayersWithoutRequiredNumberOfAdultsAtExit(BigInteger.valueOf(0));
		q18eData.setQ18NumberOfAdultStayersWithoutRequiredNumberOfAdultsAtFollowup(data.getNumOfAdultStayersWithoutRequiredAnnualAssesment());
		
		
		q18eData.setQ18TotalAdultsNumberOfAdultsAtEntry(data.getNumOfAdults());
		q18eData.setQ18TotalAdultsNumberOfAdultsAtExit(data.getTotNoOfAdultLeavers());
		q18eData.setQ18TotalAdultsNumberOfAdultsAtFollowup(data.getTotNoOfAdultStayers());
		
		List<IncomeAndSourceModel> oneOrMoreIncomeAtEntry = incomeAtEntry.parallelStream().filter(income ->  getFloat(income.getTotalmonthlyincome())  >0 ).collect(Collectors.toList());
		List<IncomeAndSourceModel> oneOrMoreIncomeAtsAtExit = incomeAtExit.parallelStream().filter(income -> getFloat(income.getTotalmonthlyincome())  >0).collect(Collectors.toList());
		List<IncomeAndSourceModel> oneOrMoreIncomeAtAnnualAssesment = incomeAndSourcesAtAnnualAssesment.parallelStream().filter(income -> getFloat(income.getTotalmonthlyincome()) >0).collect(Collectors.toList());
		
		q18eData.setQ18OneOrMoreSourceofIncomeNumberOfAdultsAtEntry(BigInteger.valueOf(getIncomeCnt(oneOrMoreIncomeAtEntry)));
		q18eData.setQ18OneOrMoreSourceofIncomeNumberOfAdultsAtExit(BigInteger.valueOf(getIncomeCnt(oneOrMoreIncomeAtsAtExit)));
		q18eData.setQ18OneOrMoreSourceofIncomeNumberOfAdultsAtFollowup(BigInteger.valueOf(getIncomeCnt(oneOrMoreIncomeAtAnnualAssesment)));
		} catch (Exception e) {
			logger.error("Error in Q18BeanMaker:" + e);
		}
		}
		return Arrays.asList(q18eData);
	}
}
