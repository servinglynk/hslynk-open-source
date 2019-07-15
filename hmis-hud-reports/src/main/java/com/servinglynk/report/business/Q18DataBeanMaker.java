package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import com.servinglynk.report.bean.Q18ClientCashIncomeCategoryEarnedOtherIncomeDataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.IncomeAndSourceModel;
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
		
		q18eData.setQ18AdultsWithIncomeInfoAtEntryNumberOfAdultsAtEntry(BigInteger.valueOf(getSize(incomeAtEntry)));
		q18eData.setQ18AdultsWithIncomeInfoAtEntryNumberOfAdultsAtExit(BigInteger.valueOf(getSize(incomeAtExit) ));
		q18eData.setQ18AdultsWithIncomeInfoAtEntryNumberOfAdultsAtFollowup(BigInteger.valueOf(getSize(incomeAndSourcesAtAnnualAssesment)));
		
		List<IncomeAndSourceModel> earnedIncomeAtEntry = incomeAtEntry.parallelStream().filter(income -> getFloat(income.getEarnedamount()) > 0 &&  getFloat(income.getOthersourceamount()) == 0).collect(Collectors.toList());
		List<IncomeAndSourceModel> earnedIncomeAtsAtExit = incomeAtExit.parallelStream().filter(income -> getFloat(income.getEarnedamount()) > 0 &&  getFloat(income.getOthersourceamount()) == 0).collect(Collectors.toList());
		List<IncomeAndSourceModel> earnedIncomeAtAnnualAssesment = incomeAndSourcesAtAnnualAssesment.parallelStream().filter(income -> getFloat(income.getEarnedamount()) > 0 &&  getFloat(income.getOthersourceamount()) == 0).collect(Collectors.toList());
		
		q18eData.setQ18AdultsWithOnlyEarnedIncomeNumberOfAdultsAtEntry(BigInteger.valueOf(earnedIncomeAtEntry !=null ? earnedIncomeAtEntry.size() :0 ));
		q18eData.setQ18AdultsWithOnlyEarnedIncomeNumberOfAdultsAtExit(BigInteger.valueOf(earnedIncomeAtsAtExit != null ? earnedIncomeAtsAtExit.size() : 0));
		q18eData.setQ18AdultsWithOnlyEarnedIncomeNumberOfAdultsAtFollowup(BigInteger.valueOf(earnedIncomeAtAnnualAssesment != null ? earnedIncomeAtAnnualAssesment.size() : 0));
		
		List<IncomeAndSourceModel> bothEarnedAndOtherIncomeAtEntry = incomeAtEntry.parallelStream().filter(income -> getFloat(income.getEarnedamount()) > 0 &&  getFloat(income.getOthersourceamount()) > 0).collect(Collectors.toList());
		List<IncomeAndSourceModel> bothEarnedAndOtherIncomeAtsAtExit = incomeAtExit.parallelStream().filter(income -> getFloat(income.getEarnedamount()) > 0 &&  getFloat(income.getOthersourceamount()) > 0).collect(Collectors.toList());
		List<IncomeAndSourceModel> bothEarnedAndOtherIncomeAtAnnualAssesment = incomeAndSourcesAtAnnualAssesment.parallelStream().filter(income -> getFloat(income.getEarnedamount()) > 0 &&  getFloat(income.getOthersourceamount()) > 0).collect(Collectors.toList());
		
		q18eData.setQ18AdultsWithBothEarnedAndOtherIncomeNumberOfAdultsAtEntry(BigInteger.valueOf(bothEarnedAndOtherIncomeAtEntry != null ? bothEarnedAndOtherIncomeAtEntry.size() : 0));
		q18eData.setQ18AdultsWithBothEarnedAndOtherIncomeNumberOfAdultsAtExit(BigInteger.valueOf(bothEarnedAndOtherIncomeAtsAtExit != null ? bothEarnedAndOtherIncomeAtsAtExit.size() :0));
		q18eData.setQ18AdultsWithBothEarnedAndOtherNumberOfAdultsAtFollowup(BigInteger.valueOf(bothEarnedAndOtherIncomeAtAnnualAssesment != null ?bothEarnedAndOtherIncomeAtAnnualAssesment.size() :0));
		
		List<IncomeAndSourceModel> noearnedIncomeAtEntry = incomeAtEntry.parallelStream().filter(income -> getFloat(income.getEarnedamount()) == 0 ).collect(Collectors.toList());
		List<IncomeAndSourceModel> noearnedIncomeAtExit = incomeAtExit.parallelStream().filter(income -> getFloat(income.getEarnedamount()) == 0 ).collect(Collectors.toList());
		List<IncomeAndSourceModel> noearnedIncomeAtAnnualAssesment = incomeAndSourcesAtAnnualAssesment.parallelStream().filter(income -> getFloat(income.getEarnedamount()) == 0 ).collect(Collectors.toList());
		
		
		List<IncomeAndSourceModel> otherIncomeAtEntry = noearnedIncomeAtEntry.parallelStream().filter(income ->  (getFloat(income.getOthersourceamount()) > 0)).collect(Collectors.toList());
		List<IncomeAndSourceModel> otherIncomeAtsAtExit = noearnedIncomeAtExit.parallelStream().filter(income ->  (getFloat(income.getOthersourceamount()) > 0)).collect(Collectors.toList());
		List<IncomeAndSourceModel> otherIncomeAtAnnualAssesment = noearnedIncomeAtAnnualAssesment.parallelStream().filter(income ->  (getFloat(income.getOthersourceamount()) > 0)).collect(Collectors.toList());
		

		q18eData.setQ18AdultsWithOnlyOtherIncomeNumberOfAdultsAtEntry(BigInteger.valueOf(otherIncomeAtEntry != null ? otherIncomeAtEntry.size() :0));
		q18eData.setQ18AdultsWithOnlyOtherIncomeNumberOfAdultsAtExit(BigInteger.valueOf(otherIncomeAtsAtExit != null ?otherIncomeAtsAtExit.size():0));
		q18eData.setQ18AdultsWithOnlyOtherIncomeNumberOfAdultsAtFollowup(BigInteger.valueOf(otherIncomeAtAnnualAssesment != null ?  otherIncomeAtAnnualAssesment.size() :0));
		
		List<IncomeAndSourceModel> dkIncomeAtEntry = incomeAtEntry.parallelStream().filter(income -> income != null && ( StringUtils.equals(NoYesEnum.EIGHT.getValue(), income.getIncomefromanysource()) || StringUtils.equals(NoYesEnum.NINE.getValue(), income.getIncomefromanysource())) ).collect(Collectors.toList());
		List<IncomeAndSourceModel> dkIncomeAtsAtExit = incomeAtExit.parallelStream().filter(income -> income != null && ( StringUtils.equals(NoYesEnum.EIGHT.getValue(), income.getIncomefromanysource()) || StringUtils.equals(NoYesEnum.NINE.getValue(), income.getIncomefromanysource())) ).collect(Collectors.toList());
		List<IncomeAndSourceModel> dkIncomeAtAnnualAssesment = incomeAndSourcesAtAnnualAssesment.parallelStream().filter(income -> income != null && ( StringUtils.equals(NoYesEnum.EIGHT.getValue(), income.getIncomefromanysource()) || StringUtils.equals(NoYesEnum.NINE.getValue(), income.getIncomefromanysource())) ).collect(Collectors.toList());

		q18eData.setQ18AdultsWithDKRNumberOfAdultsAtEntry(BigInteger.valueOf(dkIncomeAtEntry != null ? dkIncomeAtEntry.size(): 0));
		q18eData.setQ18AdultsWithDKRNumberOfAdultsAtExit(BigInteger.valueOf(dkIncomeAtsAtExit != null ? dkIncomeAtsAtExit.size() : 0));
		q18eData.setQ18AdultsWithDKRNumberOfAdultsAtFollowup(BigInteger.valueOf(dkIncomeAtAnnualAssesment  != null ? dkIncomeAtAnnualAssesment.size() : 0));
		
		List<IncomeAndSourceModel> missingIncomeAtEntry = incomeAtEntry.parallelStream().filter(income -> income != null && ( StringUtils.equals(NoYesEnum.NINTY_NINE.getValue(), income.getIncomefromanysource()) )).collect(Collectors.toList());
		List<IncomeAndSourceModel> missingIncomeAtsAtExit = incomeAtExit.parallelStream().filter(income -> income != null && ( StringUtils.equals(NoYesEnum.NINTY_NINE.getValue(), income.getIncomefromanysource()) )).collect(Collectors.toList());
		List<IncomeAndSourceModel> missingIncomeAtAnnualAssesment = noearnedIncomeAtAnnualAssesment.parallelStream().filter(income -> income != null && ( StringUtils.equals(NoYesEnum.NINTY_NINE.getValue(), income.getIncomefromanysource()) )).collect(Collectors.toList());
		
	
		q18eData.setQ18AdultsWithMissingInfoNumberOfAdultsAtEntry(BigInteger.valueOf(missingIncomeAtEntry != null ? missingIncomeAtEntry .size() :0));
		q18eData.setQ18AdultsWithMissingInfoNumberOfAdultsAtExit(BigInteger.valueOf(missingIncomeAtsAtExit != null ? missingIncomeAtsAtExit.size() :0 ));
		q18eData.setQ18AdultsWithMissingInfoNumberOfAdultsAtFollowup(BigInteger.valueOf(missingIncomeAtAnnualAssesment != null ? missingIncomeAtAnnualAssesment.size() :0));
		
		List<IncomeAndSourceModel> noIncomeAtEntry = incomeAtEntry.parallelStream().filter(income -> getFloat(income.getTotalmonthlyincome()) == 0 ).collect(Collectors.toList());
		List<IncomeAndSourceModel> noIncomeAtsAtExit = incomeAtExit.parallelStream().filter(income -> getFloat(income.getTotalmonthlyincome()) == 0 ).collect(Collectors.toList());
		List<IncomeAndSourceModel> noIncomeAtAnnualAssesment = noearnedIncomeAtAnnualAssesment.parallelStream().filter(income -> getFloat(income.getTotalmonthlyincome()) == 0 ).collect(Collectors.toList());
		
		
		q18eData.setQ18AdultsWithNoIncomeNumberOfAdultsAtEntry(BigInteger.valueOf(noIncomeAtEntry !=null ? noIncomeAtEntry.size() :0));
		q18eData.setQ18AdultsWithNoIncomeNumberOfAdultsAtExit(BigInteger.valueOf(noIncomeAtsAtExit != null ? noIncomeAtsAtExit.size() :0 ));
		q18eData.setQ18AdultsWithNoOtherNumberOfAdultsAtFollowup(BigInteger.valueOf(noIncomeAtAnnualAssesment != null ? noIncomeAtAnnualAssesment.size() :0));
		
		
	
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
		
		q18eData.setQ18OneOrMoreSourceofIncomeNumberOfAdultsAtEntry(BigInteger.valueOf(oneOrMoreIncomeAtEntry != null ? oneOrMoreIncomeAtEntry.size() :0));
		q18eData.setQ18OneOrMoreSourceofIncomeNumberOfAdultsAtExit(BigInteger.valueOf(oneOrMoreIncomeAtsAtExit != null ? oneOrMoreIncomeAtsAtExit.size() :0));
		q18eData.setQ18OneOrMoreSourceofIncomeNumberOfAdultsAtFollowup(BigInteger.valueOf(oneOrMoreIncomeAtAnnualAssesment != null ? oneOrMoreIncomeAtAnnualAssesment.size() :0));
		} catch (Exception e) {
			logger.error("Error in Q18BeanMaker:" + e);
		}
		}
		return Arrays.asList(q18eData);
	}
}
