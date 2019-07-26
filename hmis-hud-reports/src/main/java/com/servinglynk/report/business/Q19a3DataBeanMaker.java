package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.servinglynk.hive.connection.ReportQuery;
import com.servinglynk.report.bean.Q19DataBean;
import com.servinglynk.report.bean.Q19a3ClientCashIncomeChangeIncomeSourceByEntryDataBean;
import com.servinglynk.report.bean.Q19a3ClientCashIncomeChangeIncomeSourceByEntryDataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.DataCollectionStage;
import com.servinglynk.report.model.IncomeAndSourceModel;
import com.servinglynk.report.model.IncomeAndSourceModel;

public class Q19a3DataBeanMaker extends BaseBeanMaker {
	public static List<Q19a3ClientCashIncomeChangeIncomeSourceByEntryDataBean> getQ19a3ClientCashIncomeChangeIncomeSourceByEntryList(ReportData data){
		
		Q19a3ClientCashIncomeChangeIncomeSourceByEntryDataBean q19a3Bean = new Q19a3ClientCashIncomeChangeIncomeSourceByEntryDataBean();
		if(data.isLiveMode()) {
			try {
				List<IncomeAndSourceModel> incomeAndSourcesAtEntryUnFiltered = getQ19IncomeAndSource(data,ReportQuery.Q19_STAYERS_AT_ENTRY_QUERY,"STAYERS",DataCollectionStage.ENTRY);
				
				List<IncomeAndSourceModel> incomeAndSourcesAtEntry = getDedupedItems(incomeAndSourcesAtEntryUnFiltered);
				
			
				List<IncomeAndSourceModel> incomeAndSourcesAtExitUnFiltered = data.getIncomeAndSourcesAtExit();
				List<IncomeAndSourceModel> incomeAndSourcesAtExit = getDedupedItems(incomeAndSourcesAtExitUnFiltered);
				List<IncomeAndSourceModel> incomeAndSourcesAtAnnualAssesmentUnFiltered = getQ19IncomeAndSource(data,ReportQuery.Q19_STAYERS_AT_ENTRY_ASSESMENT_QUERY,"STAYERS",DataCollectionStage.ENTRY);
				
				List<IncomeAndSourceModel> incomeAndSourcesAtAnnualAssesment = getDedupedItems(incomeAndSourcesAtAnnualAssesmentUnFiltered);
								
				List<IncomeAndSourceModel> incomesatAA = new ArrayList<>();
				incomesatAA.addAll(incomeAndSourcesAtExit);
				incomesatAA.addAll(incomeAndSourcesAtAnnualAssesment);
					
				List<IncomeAndSourceModel> incomes = new ArrayList<>();
				incomes.addAll(incomeAndSourcesAtExit);
				incomes.addAll(incomeAndSourcesAtAnnualAssesment);
				incomes.addAll(incomeAndSourcesAtEntry);	
				
				
					if(CollectionUtils.isNotEmpty(incomesatAA)){
						Set<String> allClients = new HashSet<>();
						incomesatAA.forEach(incomeAndSource -> allClients.add(incomeAndSource.getDedupClientId()) );
						
						int total = getIncomeCnt(incomes);
						BigInteger allClientsBigInt = BigInteger.valueOf(total);
						Q19DataBean earnedIncome = populateEarnedIncome(incomeAndSourcesAtExit,incomesatAA,allClientsBigInt );
						hydrateEarnedIncome(earnedIncome,q19a3Bean);
						
						
						List<IncomeAndSourceModel> otherIncomeAtEntry = incomeAndSourcesAtEntry.parallelStream().filter(income -> StringUtils.equals("1",income.getDataCollectionStage())).collect(Collectors.toList());
						List<IncomeAndSourceModel> otherIncomeATEntryButNotAtAA = incomesatAA.parallelStream().filter(income -> StringUtils.equals("3",income.getDataCollectionStage()) || StringUtils.equals("5",income.getDataCollectionStage())).collect(Collectors.toList());
						
						Q19DataBean otherIncome = populateOtherIncome(otherIncomeAtEntry,otherIncomeATEntryButNotAtAA,allClientsBigInt);
						hydrateOtherIncome(otherIncome, q19a3Bean);
						
						List<IncomeAndSourceModel> totalIncomeAtEntry = incomeAndSourcesAtEntry.parallelStream().filter(income -> StringUtils.equals("1",income.getDataCollectionStage())).collect(Collectors.toList());
						List<IncomeAndSourceModel> totalIncomeATAA = incomesatAA.parallelStream().filter(income -> StringUtils.equals("3",income.getDataCollectionStage()) || StringUtils.equals("5",income.getDataCollectionStage())).collect(Collectors.toList());
						
						
						Q19DataBean overallIncome = populateOverallIncomeIncome(totalIncomeAtEntry,totalIncomeATAA,allClientsBigInt);
						hydrateOverallIncome(overallIncome, q19a3Bean);
						
					}
			}catch(Exception e) {
				e.printStackTrace();
		logger.error("Error in Q26cBeanMaker:" + e);
			}
		}
		return Arrays.asList(q19a3Bean);
		
	}

	public static void 	hydrateEarnedIncome(Q19DataBean q19dataBean,Q19a3ClientCashIncomeChangeIncomeSourceByEntryDataBean q19a3Bean) {
		//#B
		    q19a3Bean.setQ19a3AverageChangeInEarnedIncomeHadIncomeCategoryAtEntryAndDidNotHavefollowupOrExit(q19dataBean.getAverageChangeInEarnedIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup());
			q19a3Bean.setQ19a3NoOfAdltsWithEarnedIncomeHadIncomeCategoryAtEntryAndDidNotHavefollowupOrExit(q19dataBean.getNoOfAdltsWithEarnedIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup());
		//C
			q19a3Bean.setQ19a3NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryButHadLessDollarAtFollowupOrExitAtEntry(q19dataBean.getNoOfAdltsWithEarnedIncomeRetainedIncomeCategoryButHadLessDollar());
			q19a3Bean.setQ19a3AverageChangeInEarnedIncomeRetainedIncomeCategoryButHadLessDollarAtFollowupOrExitAtEntry(q19dataBean.getAverageChangeInEarnedIncomeRetainedIncomeCategoryButHadLessDollar());
		//#D
			q19a3Bean.setQ19a3NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryAndSameDollartFollowupOrExitAtEntry(q19dataBean.getNoOfAdltsWithEarnedIncomeRetainedIncomeCategoryAndSameDollar());
			q19a3Bean.setQ19a3AverageChangeInEarnedIncomeRetainedIncomeCategoryAndSameDollartFollowupOrExitAtEntry(BigInteger.ZERO);
	
		//#F
			q19a3Bean.setQ19a3NoOfAdltsWithEarnedIncomeDidNotHaveIncomeCategoryEntryAndGainedIncomeCategoryAtFollowupOrExit(q19dataBean.getNoOfAdltsWithEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome());
			q19a3Bean.setQ19a3AverageChangeInEarnedIncomeDidNotHaveIncomeCategoryEntryAndGainedIncomeCategoryAtFollowupOrExit(q19dataBean.getAverageChangeInEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome());
		//#G
			q19a3Bean.setQ19a3NoOfAdltsWithEarnedIncomeDidNotHaveIncomeCategoryAtEntryOrFollowupOrExit(q19dataBean.getNoOfAdltsWithEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup());
			q19a3Bean.setQ19a3AverageChangeInEarnedIncomeDidNotHaveIncomeCategoryAtEntryOrFollowupOrExit(BigInteger.ZERO);
	
		//#H 
			q19a3Bean.setQ19a3NoOfAdltsWithEarnedIncomeTotalAdult(q19dataBean.getNoOfAdltsWithEarnedIncomeTotalAdult());
			q19a3Bean.setQ19a3AverageChangeInEarnedIncomeTotalAdult(BigInteger.ZERO);
		
		//#E
			q19a3Bean.setQ19a3NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryAndIncreasedDollarAtFollowupOrExit(q19dataBean.getNoOfAdltsWithEarnedIncomeRetainedIncomeCategoryAndIncreasedDollar());
			q19a3Bean.setQ19a3AverageChangeInEarnedIncomeRetainedIncomeCategoryAndIncreasedDollarAtFollowupOrExit(q19dataBean.getAverageChangeInEarnedIncomeRetainedIncomeCategoryAndIncreasedDollar());
		//I
			q19a3Bean.setQ19a3NoOfAdltsWithEarnedIncomePerformanceMeasures(q19dataBean.getNoOfAdltsWithEarnedIncomePerformanceMeasures());
			q19a3Bean.setQ19a3AverageChangeInEarnedIncomePerformanceMeasures(q19dataBean.getAverageChangeInEarnedIncomePerformanceMeasures());
		
		//#J = I/H
			q19a3Bean.setQ19a3NoOfAdltsWithEarnedIncomePercent(q19dataBean.getNoOfAdltsWithEarnedIncomePercent());
			q19a3Bean.setQ19a3AverageChangeInEarnedIncomePercent(BigInteger.ZERO);
	   }
	   
	   public static void 	hydrateOtherIncome(Q19DataBean q19dataBean,Q19a3ClientCashIncomeChangeIncomeSourceByEntryDataBean q19a3Bean) {
		//#B
		    q19a3Bean.setQ19a3AverageChangeInOtherIncomeHadIncomeCategoryAtEntryAndDidNotHavefollowupOrExit(q19dataBean.getAverageChangeInOtherIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup());
			q19a3Bean.setQ19a3NoOfAdultsWithOtherIncomeHadIncomeCategoryAtEntryAndDidNotHavefollowupOrExit(q19dataBean.getNoOfAdultsWithOtherIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup());
		//C
			q19a3Bean.setQ19a3NoOfAdultsWithOtherIncomeRetainedIncomeCategoryButHadLessDollarAtFollowupOrExitAtEntry(q19dataBean.getNoOfAdultsWithOtherIncomeRetainedIncomeCategoryButHadLessDollar());
			q19a3Bean.setQ19a3AverageChangeInOtherIncomeRetainedIncomeCategoryButHadLessDollarAtFollowupOrExitAtEntry(q19dataBean.getAverageChangeInOtherIncomeRetainedIncomeCategoryButHadLessDollar());
		//#D
			q19a3Bean.setQ19a3NoOfAdultsWithOtherIncomeRetainedIncomeCategoryAndSameDollartFollowupOrExitAtEntry(q19dataBean.getNoOfAdultsWithOtherIncomeRetainedIncomeCategoryAndSameDollar());
			q19a3Bean.setQ19a3AverageChangeInOtherIncomeRetainedIncomeCategoryAndSameDollartFollowupOrExitAtEntry(BigInteger.ZERO);
	
		//#F
			q19a3Bean.setQ19a3NoOfAdultsWithOtherIncomeDidNotHaveIncomeCategoryEntryAndGainedIncomeCategoryAtFollowupOrExit(q19dataBean.getNoOfAdultsWithOtherIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome());
			q19a3Bean.setQ19a3AverageChangeInOtherIncomeDidNotHaveIncomeCategoryEntryAndGainedIncomeCategoryAtFollowupOrExit(q19dataBean.getAverageChangeInOtherIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome());
		//#G
			q19a3Bean.setQ19a3NoOfAdultsWithOtherIncomeDidNotHaveIncomeCategoryAtEntryOrFollowupOrExit(q19dataBean.getNoOfAdultsWithOtherIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup());
			q19a3Bean.setQ19a3AverageChangeInOtherIncomeDidNotHaveIncomeCategoryAtEntryOrFollowupOrExit(BigInteger.ZERO);
	
		//#H 
			q19a3Bean.setQ19a3NoOfAdultsWithOtherIncomeTotalAdult(q19dataBean.getNoOfAdultsWithOtherIncomeTotalAdult());
			q19a3Bean.setQ19a3AverageChangeInOtherIncomeTotalAdult(BigInteger.ZERO);
		
		//#E
			q19a3Bean.setQ19a3NoOfAdultsWithOtherIncomeRetainedIncomeCategoryAndIncreasedDollarAtFollowupOrExit(q19dataBean.getNoOfAdultsWithOtherIncomeRetainedIncomeCategoryAndIncreasedDollar());
			q19a3Bean.setQ19a3AverageChangeInOtherIncomeRetainedIncomeCategoryAndIncreasedDollarAtFollowupOrExit(q19dataBean.getAverageChangeInOtherIncomeRetainedIncomeCategoryAndIncreasedDollar());
		//I
			q19a3Bean.setQ19a3NoOfAdultsWithOtherIncomePerformanceMeasures(q19dataBean.getNoOfAdultsWithOtherIncomePerformanceMeasures());
			q19a3Bean.setQ19a3AverageChangeInOtherIncomePerformanceMeasures(q19dataBean.getAverageChangeInOtherIncomePerformanceMeasures());
		
		//#J = I/H
			q19a3Bean.setQ19a3NoOfAdultsWithOtherIncomePercent(q19dataBean.getNoOfAdultsWithOtherIncomePercent());
			q19a3Bean.setQ19a3AverageChangeInOtherIncomePercent(BigInteger.ZERO);
	   }
	
	
	public static void 	hydrateOverallIncome(Q19DataBean q19dataBean,Q19a3ClientCashIncomeChangeIncomeSourceByEntryDataBean q19a3DataBean) {
		//#B
		    q19a3DataBean.setQ19a3AverageChangeInOverallIncomeHadIncomeCategoryAtEntryAndDidNotHavefollowupOrExit(q19dataBean.getAverageChangeInOverallIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup());
			q19a3DataBean.setQ19a3NumberOfAdultsWithAnyIncomeHadIncomeCategoryAtEntryAndDidNotHavefollowupOrExit(q19dataBean.getNumberOfAdultsWithAnyIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup());
		//C
			q19a3DataBean.setQ19a3NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryButHadLessDollarAtFollowupOrExitAtEntry(q19dataBean.getNumberOfAdultsWithAnyIncomeRetainedIncomeCategoryButHadLessDollar());
			q19a3DataBean.setQ19a3AverageChangeInOverallIncomeRetainedIncomeCategoryButHadLessDollarAtFollowupOrExitAtEntry(q19dataBean.getAverageChangeInOverallIncomeRetainedIncomeCategoryButHadLessDollar());
		//#D
			q19a3DataBean.setQ19a3NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryAndSameDollartFollowupOrExitAtEntry(q19dataBean.getNumberOfAdultsWithAnyIncomeRetainedIncomeCategoryAndSameDollar());
			q19a3DataBean.setQ19a3AverageChangeInOverallIncomeRetainedIncomeCategoryAndSameDollartFollowupOrExitAtEntry(BigInteger.ZERO);
	
		//#F
			q19a3DataBean.setQ19a3NumberOfAdultsWithAnyIncomeDidNotHaveIncomeCategoryEntryAndGainedIncomeCategoryAtFollowupOrExit(q19dataBean.getNumberOfAdultsWithAnyIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome());
			q19a3DataBean.setQ19a3AverageChangeInOverallIncomeDidNotHaveIncomeCategoryEntryAndGainedIncomeCategoryAtFollowupOrExit(q19dataBean.getAverageChangeInOverallIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome());
		//#G
			q19a3DataBean.setQ19a3NumberOfAdultsWithAnyIncomeDidNotHaveIncomeCategoryAtEntryOrFollowupOrExit(q19dataBean.getNumberOfAdultsWithAnyIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup());
			q19a3DataBean.setQ19a3AverageChangeInOverallIncomeDidNotHaveIncomeCategoryAtEntryOrFollowupOrExit(BigInteger.ZERO);
	
		//#H 
			q19a3DataBean.setQ19a3NumberOfAdultsWithAnyIncomeTotalAdult(q19dataBean.getNumberOfAdultsWithAnyIncomeTotalAdult());
			q19a3DataBean.setQ19a3AverageChangeInOverallIncomeTotalAdult(q19dataBean.getAverageChangeInOverallIncomeTotalAdult());
		
		//#E
			q19a3DataBean.setQ19a3NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryAndIncreasedDollarAtFollowupOrExit(q19dataBean.getNumberOfAdultsWithAnyIncomeRetainedIncomeCategoryAndIncreasedDollar());
			q19a3DataBean.setQ19a3AverageChangeInOverallIncomeRetainedIncomeCategoryAndIncreasedDollarAtFollowupOrExit(q19dataBean.getAverageChangeInOverallIncomeRetainedIncomeCategoryAndIncreasedDollar());
		//I
			q19a3DataBean.setQ19a3NumberOfAdultsWithAnyIncomePerformanceMeasures(q19dataBean.getNumberOfAdultsWithAnyIncomePerformanceMeasures());
			q19a3DataBean.setQ19a3AverageChangeInOverallIncomePerformanceMeasures(q19dataBean.getAverageChangeInOverallIncomePerformanceMeasures());
		
		//#J = I/H
			q19a3DataBean.setQ19a3NumberOfAdultsWithAnyIncomePercent(q19dataBean.getNumberOfAdultsWithAnyIncomePercent());
			q19a3DataBean.setQ19a3AverageChangeInOverallIncomePercent(BigInteger.ZERO);
	   }
}
