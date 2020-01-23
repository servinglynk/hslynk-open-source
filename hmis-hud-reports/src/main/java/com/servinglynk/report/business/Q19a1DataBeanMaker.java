package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.servinglynk.hive.connection.ReportQuery;
import com.servinglynk.report.bean.Q19DataBean;
import com.servinglynk.report.bean.Q19a1ClientCashIncomeChangeIncomeSourceEntryDataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.DataCollectionStage;
import com.servinglynk.report.model.IncomeAndSourceModel;

public class Q19a1DataBeanMaker extends BaseBeanMaker {
	public static List<Q19a1ClientCashIncomeChangeIncomeSourceEntryDataBean> getQ19a1ClientCashIncomeChangeIncomeSourceEntryDataBeanList(ReportData data){
	
		Q19a1ClientCashIncomeChangeIncomeSourceEntryDataBean q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate = new Q19a1ClientCashIncomeChangeIncomeSourceEntryDataBean();
		if(data.isLiveMode()) {
			try {
				
				
					List<IncomeAndSourceModel> incomeAndSourcesAtEntryUnFiltered = getQ19IncomeAndSource(data,ReportQuery.Q19_STAYERS_AT_ENTRY_QUERY,"STAYERS",DataCollectionStage.ENTRY);
					List<IncomeAndSourceModel> incomeAndSourcesAtAnnualAssesmentUnFiltered = getQ19IncomeAndSource(data,ReportQuery.Q19_STAYERS_AT_ENTRY_ASSESMENT_QUERY,"STAYERS",DataCollectionStage.ENTRY);
					
					List<IncomeAndSourceModel> incomeAndSourcesAtEntry = getDedupedItems(incomeAndSourcesAtEntryUnFiltered);
					List<IncomeAndSourceModel> incomeAndSourcesAtAnnualAssesment = getDedupedItems(incomeAndSourcesAtAnnualAssesmentUnFiltered);
					
					List<IncomeAndSourceModel> incomes = new ArrayList<>();
					incomes.addAll(incomeAndSourcesAtEntry);
					incomes.addAll(incomeAndSourcesAtAnnualAssesment);
					
					if(CollectionUtils.isNotEmpty(incomes)){
						int total = getIncomeCnt(incomes);
						BigInteger allClientsBigInt = BigInteger.valueOf(total);
						
						Q19DataBean earnedIncome = populateEarnedIncome(incomeAndSourcesAtEntry,incomeAndSourcesAtAnnualAssesment,allClientsBigInt );
						hydrateEarnedIncome(earnedIncome,q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate);
						
						Q19DataBean otherIncome = populateOtherIncome(incomeAndSourcesAtEntry,incomeAndSourcesAtAnnualAssesment,allClientsBigInt);
						hydrateOtherIncome(otherIncome, q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate);
						
						Q19DataBean overallIncome = populateOverallIncomeIncome(incomeAndSourcesAtEntry,incomeAndSourcesAtAnnualAssesment,allClientsBigInt);
						hydrateOverallIncome(overallIncome, q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate);
					}
			}catch(Exception e) {
				e.printStackTrace();
		logger.error("Error in Q19a1DataBeanMaker:" + e);
			}
		}
		return Arrays.asList(q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate);
	}
	

	
	public static void 	hydrateEarnedIncome(Q19DataBean q19dataBean,Q19a1ClientCashIncomeChangeIncomeSourceEntryDataBean q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate) {
		//#B
		    q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1AverageChangeInEarnedIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup(q19dataBean.getAverageChangeInEarnedIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup());
			q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1NoOfAdltsWithEarnedIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup(q19dataBean.getNoOfAdltsWithEarnedIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup());
		//C
			q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryButHadLessDollar(q19dataBean.getNoOfAdltsWithEarnedIncomeRetainedIncomeCategoryButHadLessDollar());
			q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1AverageChangeInEarnedIncomeRetainedIncomeCategoryButHadLessDollar(q19dataBean.getAverageChangeInEarnedIncomeRetainedIncomeCategoryButHadLessDollar());
		//#D
			q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryAndSameDollar(q19dataBean.getNoOfAdltsWithEarnedIncomeRetainedIncomeCategoryAndSameDollar());
			q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1AverageChangeInEarnedIncomeRetainedIncomeCategoryAndSameDollar(BigInteger.ZERO);
	
		//#F
			q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1NoOfAdltsWithEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome(q19dataBean.getNoOfAdltsWithEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome());
			q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1AverageChangeInEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome(q19dataBean.getAverageChangeInEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome());
		//#G
			q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1NoOfAdltsWithEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup(q19dataBean.getNoOfAdltsWithEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup());
			q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1AverageChangeInEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup(BigInteger.ZERO);
	
		//#H 
			q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1NoOfAdltsWithEarnedIncomeTotalAdult(q19dataBean.getNoOfAdltsWithEarnedIncomeTotalAdult());
			q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1AverageChangeInEarnedIncomeTotalAdult(BigInteger.ZERO);
		
		//#E
			q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryAndIncreasedDollar(q19dataBean.getNoOfAdltsWithEarnedIncomeRetainedIncomeCategoryAndIncreasedDollar());
			q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1AverageChangeInEarnedIncomeRetainedIncomeCategoryAndIncreasedDollar(q19dataBean.getAverageChangeInEarnedIncomeRetainedIncomeCategoryAndIncreasedDollar());
		//I
			q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1NoOfAdltsWithEarnedIncomePerformanceMeasures(q19dataBean.getNoOfAdltsWithEarnedIncomePerformanceMeasures());
			q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1AverageChangeInEarnedIncomePerformanceMeasures(q19dataBean.getAverageChangeInEarnedIncomePerformanceMeasures());
		
		//#J = I/H
			q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1NoOfAdltsWithEarnedIncomePercent(q19dataBean.getNoOfAdltsWithEarnedIncomePercent());
			q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1AverageChangeInEarnedIncomePercent(BigInteger.ZERO);
	   }
	   
	   public static void 	hydrateOtherIncome(Q19DataBean q19dataBean,Q19a1ClientCashIncomeChangeIncomeSourceEntryDataBean q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate) {
		//#B
		    q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1AverageChangeInOtherIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup(q19dataBean.getAverageChangeInOtherIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup());
			q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1NoOfAdultsWithOtherIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup(q19dataBean.getNoOfAdultsWithOtherIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup());
		//C
			q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1NoOfAdultsWithOtherIncomeRetainedIncomeCategoryButHadLessDollar(q19dataBean.getNoOfAdultsWithOtherIncomeRetainedIncomeCategoryButHadLessDollar());
			q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1AverageChangeInOtherIncomeRetainedIncomeCategoryButHadLessDollar(q19dataBean.getAverageChangeInOtherIncomeRetainedIncomeCategoryButHadLessDollar());
		//#D
			q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1NoOfAdultsWithOtherIncomeRetainedIncomeCategoryAndSameDollar(q19dataBean.getNoOfAdultsWithOtherIncomeRetainedIncomeCategoryAndSameDollar());
			q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1AverageChangeInOtherIncomeRetainedIncomeCategoryAndSameDollar(BigInteger.ZERO);
	
		//#F
			q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1NoOfAdultsWithOtherIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome(q19dataBean.getNoOfAdultsWithOtherIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome());
			q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1AverageChangeInOtherIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome(q19dataBean.getAverageChangeInOtherIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome());
		//#G
			q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1NoOfAdultsWithOtherIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup(q19dataBean.getNoOfAdultsWithOtherIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup());
			q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1AverageChangeInOtherIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup(BigInteger.ZERO);
	
		//#H 
			q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1NoOfAdultsWithOtherIncomeTotalAdult(q19dataBean.getNoOfAdultsWithOtherIncomeTotalAdult());
			q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1AverageChangeInOtherIncomeTotalAdult(BigInteger.ZERO);
		
		//#E
			q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1NoOfAdultsWithOtherIncomeRetainedIncomeCategoryAndIncreasedDollar(q19dataBean.getNoOfAdultsWithOtherIncomeRetainedIncomeCategoryAndIncreasedDollar());
			q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1AverageChangeInOtherIncomeRetainedIncomeCategoryAndIncreasedDollar(q19dataBean.getAverageChangeInOtherIncomeRetainedIncomeCategoryAndIncreasedDollar());
		//I
			q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1NoOfAdultsWithOtherIncomePerformanceMeasures(q19dataBean.getNoOfAdultsWithOtherIncomePerformanceMeasures());
			q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1AverageChangeInOtherIncomePerformanceMeasures(q19dataBean.getAverageChangeInOtherIncomePerformanceMeasures());
		
		//#J = I/H
			q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1NoOfAdultsWithOtherIncomePercent(q19dataBean.getNoOfAdultsWithOtherIncomePercent());
			q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1AverageChangeInOtherIncomePercent(BigInteger.ZERO);
	   }
	
	
	public static void 	hydrateOverallIncome(Q19DataBean q19dataBean,Q19a1ClientCashIncomeChangeIncomeSourceEntryDataBean q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate) {
		//#B
		    q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1AverageChangeInOverallIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup(q19dataBean.getAverageChangeInOverallIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup());
			q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1NumberOfAdultsWithAnyIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup(q19dataBean.getNumberOfAdultsWithAnyIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup());
		//C
			q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryButHadLessDollar(q19dataBean.getNumberOfAdultsWithAnyIncomeRetainedIncomeCategoryButHadLessDollar());
			q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1AverageChangeInOverallIncomeRetainedIncomeCategoryButHadLessDollar(q19dataBean.getAverageChangeInOverallIncomeRetainedIncomeCategoryButHadLessDollar());
		//#D
			q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryAndSameDollar(q19dataBean.getNumberOfAdultsWithAnyIncomeRetainedIncomeCategoryAndSameDollar());
			q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1AverageChangeInOverallIncomeRetainedIncomeCategoryAndSameDollar(BigInteger.ZERO);
	
		//#F
			q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1NumberOfAdultsWithAnyIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome(q19dataBean.getNumberOfAdultsWithAnyIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome());
			q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1AverageChangeInOverallIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome(q19dataBean.getAverageChangeInOverallIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome());
		//#G
			q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1NumberOfAdultsWithAnyIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup(q19dataBean.getNumberOfAdultsWithAnyIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup());
			q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1AverageChangeInOverallIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup(BigInteger.ZERO);
	
		//#H 
			q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1NumberOfAdultsWithAnyIncomeTotalAdult(q19dataBean.getNumberOfAdultsWithAnyIncomeTotalAdult());
			q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1AverageChangeInOverallIncomeTotalAdult(q19dataBean.getAverageChangeInOverallIncomeTotalAdult());
		
		//#E
			q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryAndIncreasedDollar(q19dataBean.getNumberOfAdultsWithAnyIncomeRetainedIncomeCategoryAndIncreasedDollar());
			q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1AverageChangeInOverallIncomeRetainedIncomeCategoryAndIncreasedDollar(q19dataBean.getAverageChangeInOverallIncomeRetainedIncomeCategoryAndIncreasedDollar());
		//I
			q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1NumberOfAdultsWithAnyIncomePerformanceMeasures(q19dataBean.getNumberOfAdultsWithAnyIncomePerformanceMeasures());
			q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1AverageChangeInOverallIncomePerformanceMeasures(q19dataBean.getAverageChangeInOverallIncomePerformanceMeasures());
		
		//#J = I/H
			q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1NumberOfAdultsWithAnyIncomePercent(q19dataBean.getNumberOfAdultsWithAnyIncomePercent());
			q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1AverageChangeInOverallIncomePercent(BigInteger.ZERO);
	   }
	
	
	public static List<IncomeAndSourceModel> getDedupedItems(List<IncomeAndSourceModel> incomes) {
		Map<String,IncomeAndSourceModel> dedupIncomeAndSourceAtEntry = new HashMap<>();
		incomes.forEach(income->  dedupIncomeAndSourceAtEntry.put(income.getDedupClientId(), income));
		Collection<IncomeAndSourceModel> values = dedupIncomeAndSourceAtEntry.values();
		return new ArrayList(values);	
	}
	
}
