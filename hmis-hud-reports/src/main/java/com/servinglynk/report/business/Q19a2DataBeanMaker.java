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

import com.servinglynk.report.bean.Q19DataBean;
import com.servinglynk.report.bean.Q19a2ClientCashIncomeChangeIncomeSourceByEntryDataBean;
import com.servinglynk.report.bean.Q19a2ClientCashIncomeChangeIncomeSourceByEntryDataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.EnrollmentModel;
import com.servinglynk.report.model.IncomeAndSourceModel;

public class Q19a2DataBeanMaker extends BaseBeanMaker {

	public static List<Q19a2ClientCashIncomeChangeIncomeSourceByEntryDataBean> getQ19a2ClientCashIncomeChangeIncomeSourceByEntryList(ReportData data){
		
		Q19a2ClientCashIncomeChangeIncomeSourceByEntryDataBean q19a2Bean = new Q19a2ClientCashIncomeChangeIncomeSourceByEntryDataBean();
		if(data.isLiveMode()) {
			try {
				List<EnrollmentModel> adultLeavers = data.getAdultLeavers();
				if(CollectionUtils.isEmpty(adultLeavers)){
					 return Arrays.asList(q19a2Bean);
				}
			
				List<IncomeAndSourceModel> incomeAndSourcesAtEntry = data.getIncomeAndSourcesAtEntry();
				List<IncomeAndSourceModel> incomeAndSourcesAtExit = data.getIncomeAndSourcesAtExit();
				
				
				List<IncomeAndSourceModel> incomes = new ArrayList<>();
				incomes.addAll(incomeAndSourcesAtEntry);
				incomes.addAll(incomeAndSourcesAtExit);
				
				if(CollectionUtils.isNotEmpty(incomes)){
						Set<String> allClients = new HashSet<>();
						incomes.forEach(incomeAndSource -> allClients.add(incomeAndSource.getDedupClientId()) );
						int total = getIncomeCnt(incomes);
						BigInteger allClientsBigInt = BigInteger.valueOf(total);
						List<IncomeAndSourceModel> earnedIncomeAtEntry = incomes.parallelStream().filter(income -> StringUtils.equals("1",income.getDataCollectionStage())).collect(Collectors.toList());
						List<IncomeAndSourceModel> earnedIncomeATEntryButNotAtAA = incomes.parallelStream().filter(income -> StringUtils.equals("3",income.getDataCollectionStage())).collect(Collectors.toList());
						
						List<IncomeAndSourceModel> didNotHaveEarnedIncomeAtEntry = incomes.parallelStream().filter(income -> StringUtils.equals("1",income.getDataCollectionStage()) &&  getFloat(income.getTotalmonthlyincome()) ==0).collect(Collectors.toList());
						List<IncomeAndSourceModel> didNotHaveEarnedIncomeATEntryButNotAtAA = incomes.parallelStream().filter(income -> StringUtils.equals("3",income.getDataCollectionStage()) && getFloat(income.getTotalmonthlyincome()) ==0).collect(Collectors.toList());
						
						Q19DataBean earnedIncome = populateEarnedIncome(earnedIncomeAtEntry,earnedIncomeATEntryButNotAtAA,allClientsBigInt,didNotHaveEarnedIncomeAtEntry,didNotHaveEarnedIncomeATEntryButNotAtAA );
						hydrateEarnedIncome(earnedIncome,q19a2Bean);
						
						
						List<IncomeAndSourceModel> otherIncomeAtEntry = incomes.parallelStream().filter(income -> StringUtils.equals("1",income.getDataCollectionStage())).collect(Collectors.toList());
						List<IncomeAndSourceModel> otherIncomeATEntryButNotAtAA = incomes.parallelStream().filter(income -> StringUtils.equals("3",income.getDataCollectionStage())).collect(Collectors.toList());
						
						List<IncomeAndSourceModel> didNotHaveOtherIncomeAtEntry = incomes.parallelStream().filter(income -> StringUtils.equals("1",income.getDataCollectionStage()) && (getFloat(income.getTotalmonthlyincome()) - getFloat(income.getTotalmonthlyincome()))  ==0).collect(Collectors.toList());
						List<IncomeAndSourceModel> didNotHaveOtherIncomeATEntryButNotAtAA = incomes.parallelStream().filter(income -> StringUtils.equals("3",income.getDataCollectionStage()) && (getFloat(income.getTotalmonthlyincome()) - getFloat(income.getTotalmonthlyincome()))  ==0).collect(Collectors.toList());
					
						Q19DataBean otherIncome = populateOtherIncome(otherIncomeAtEntry,otherIncomeATEntryButNotAtAA,allClientsBigInt,didNotHaveOtherIncomeAtEntry,didNotHaveOtherIncomeATEntryButNotAtAA);
						hydrateOtherIncome(otherIncome, q19a2Bean);
						
						List<IncomeAndSourceModel> totalIncomeAtEntry = incomes.parallelStream().filter(income -> StringUtils.equals("1",income.getDataCollectionStage())).collect(Collectors.toList());
						List<IncomeAndSourceModel> totalIncomeATAA = incomes.parallelStream().filter(income -> StringUtils.equals("3",income.getDataCollectionStage())).collect(Collectors.toList());
						
						List<IncomeAndSourceModel> didNotHaveTotalIncomeAtEntry = incomes.parallelStream().filter(income -> StringUtils.equals("1",income.getDataCollectionStage()) && getFloat(income.getTotalmonthlyincome()) ==0).collect(Collectors.toList());
						List<IncomeAndSourceModel> didNotHaveTotalIncomeATEntryButNotAtAA = incomes.parallelStream().filter(income -> StringUtils.equals("3",income.getDataCollectionStage()) && getFloat(income.getTotalmonthlyincome()) ==0).collect(Collectors.toList());
						
						Q19DataBean overallIncome = populateOverallIncomeIncome(totalIncomeAtEntry,totalIncomeATAA,allClientsBigInt,didNotHaveTotalIncomeAtEntry,didNotHaveTotalIncomeATEntryButNotAtAA);
						hydrateOverallIncome(overallIncome, q19a2Bean);
						
					}
			}catch(Exception e) {
		logger.error("Error in 19a2BeanMaker:" + e);
			}
		}
		return Arrays.asList(q19a2Bean);
		
	}
	
	public static void 	hydrateEarnedIncome(Q19DataBean q19dataBean,Q19a2ClientCashIncomeChangeIncomeSourceByEntryDataBean q19a2Bean) {
		//#B
		    q19a2Bean.setQ19a2AverageChangeInEarnedIncomeHadIncomeCategoryAtEntryAndDidNotHaveAtExit(q19dataBean.getAverageChangeInEarnedIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup());
			q19a2Bean.setQ19a2NoOfAdltsWithEarnedIncomeHadIncomeCategoryAtEntryAndDidNotHaveAtExit(q19dataBean.getNoOfAdltsWithEarnedIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup());
		//
			q19a2Bean.setQ19a2NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryButHadLessDollarAtExitThanAtEntry(q19dataBean.getNoOfAdltsWithEarnedIncomeRetainedIncomeCategoryButHadLessDollar());
			q19a2Bean.setQ19a2AverageChangeInEarnedIncomeRetainedIncomeCategoryButHadLessDollarAtExitThanAtEntry(q19dataBean.getAverageChangeInEarnedIncomeRetainedIncomeCategoryButHadLessDollar());
		//#D
			q19a2Bean.setQ19a2NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryAndSameDollarAtExitAsAtEntry(q19dataBean.getNoOfAdltsWithEarnedIncomeRetainedIncomeCategoryAndSameDollar());
			q19a2Bean.setQ19a2AverageChangeInEarnedIncomeRetainedIncomeCategoryAndSameDollarAtExitAsAtEntry(BigInteger.ZERO);
	
		//#F
			q19a2Bean.setQ19a2NoOfAdltsWithEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedIncomeCategoryExit(q19dataBean.getNoOfAdltsWithEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome());
			q19a2Bean.setQ19a2AverageChangeInEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedIncomeCategoryExit(q19dataBean.getAverageChangeInEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome());
		//#G
			q19a2Bean.setQ19a2NoOfAdltsWithEarnedIncomeDidNotHaveIncomeCategoryAtEntryOrExit(q19dataBean.getNoOfAdltsWithEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup());
			q19a2Bean.setQ19a2AverageChangeInEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedIncomeCategoryExit(BigInteger.ZERO);
	
		//#H 
			q19a2Bean.setQ19a2NoOfAdltsWithEarnedIncomeTotalAdult(q19dataBean.getNoOfAdltsWithEarnedIncomeTotalAdult());
			q19a2Bean.setQ19a2AverageChangeInEarnedIncomeTotalAdult(BigInteger.ZERO);
		
		//#E
			q19a2Bean.setQ19a2NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryAndIncreasedDollarAtExit(q19dataBean.getNoOfAdltsWithEarnedIncomeRetainedIncomeCategoryAndIncreasedDollar());
			q19a2Bean.setQ19a2AverageChangeInEarnedIncomeRetainedIncomeCategoryAndIncreasedDollarAtExit(q19dataBean.getAverageChangeInEarnedIncomeRetainedIncomeCategoryAndIncreasedDollar());
		//I
			q19a2Bean.setQ19a2NoOfAdltsWithEarnedIncomePerformanceMeasures(q19dataBean.getNoOfAdltsWithEarnedIncomePerformanceMeasures());
			q19a2Bean.setQ19a2AverageChangeInEarnedIncomePerformanceMeasures(q19dataBean.getAverageChangeInEarnedIncomePerformanceMeasures());
		
		//#J = I/H
			q19a2Bean.setQ19a2NoOfAdltsWithEarnedIncomePercent(q19dataBean.getNoOfAdltsWithEarnedIncomePercent());
			q19a2Bean.setQ19a2AverageChangeInEarnedIncomePercent(BigInteger.ZERO);
	   }
	   
	   public static void 	hydrateOtherIncome(Q19DataBean q19dataBean,Q19a2ClientCashIncomeChangeIncomeSourceByEntryDataBean q19a2Bean) {
		//#B
		    q19a2Bean.setQ19a2AverageChangeInOtherIncomeHadIncomeCategoryAtEntryAndDidNotHaveAtExit(q19dataBean.getAverageChangeInOtherIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup());
			q19a2Bean.setQ19a2NoOfAdultsWithOtherIncomeHadIncomeCategoryAtEntryAndDidNotHaveAtExit(q19dataBean.getNoOfAdultsWithOtherIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup());
		//C
			q19a2Bean.setQ19a2NoOfAdultsWithOtherIncomeRetainedIncomeCategoryButHadLessDollarAtExitThanAtEntry(q19dataBean.getNoOfAdultsWithOtherIncomeRetainedIncomeCategoryButHadLessDollar());
			q19a2Bean.setQ19a2AverageChangeInOtherIncomeRetainedIncomeCategoryButHadLessDollarAtExitThanAtEntry(q19dataBean.getAverageChangeInOtherIncomeRetainedIncomeCategoryButHadLessDollar());
		//#D
			q19a2Bean.setQ19a2NoOfAdultsWithOtherIncomeRetainedIncomeCategoryAndSameDollarAtExitAsAtEntry(q19dataBean.getNoOfAdultsWithOtherIncomeRetainedIncomeCategoryAndSameDollar());
			q19a2Bean.setQ19a2AverageChangeInOtherIncomeRetainedIncomeCategoryAndSameDollarAtExitAsAtEntry(BigInteger.ZERO);
	
		//#F
			q19a2Bean.setQ19a2NoOfAdultsWithOtherIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedIncomeCategoryExit(q19dataBean.getNoOfAdultsWithOtherIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome());
			q19a2Bean.setQ19a2AverageChangeInOtherIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedIncomeCategoryExit(q19dataBean.getAverageChangeInOtherIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome());
		//#G
			q19a2Bean.setQ19a2NoOfAdultsWithOtherIncomeDidNotHaveIncomeCategoryAtEntryOrExit(q19dataBean.getNoOfAdultsWithOtherIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup());
			q19a2Bean.setQ19a2AverageChangeInOtherIncomeDidNotHaveIncomeCategoryAtEntryOrExit(BigInteger.ZERO);
	
		//#H 
			q19a2Bean.setQ19a2NoOfAdultsWithOtherIncomeTotalAdult(q19dataBean.getNoOfAdultsWithOtherIncomeTotalAdult());
			q19a2Bean.setQ19a2AverageChangeInOtherIncomeTotalAdult(BigInteger.ZERO);
		
		//#E
			q19a2Bean.setQ19a2NoOfAdultsWithOtherIncomeRetainedIncomeCategoryAndIncreasedDollarAtExit(q19dataBean.getNoOfAdultsWithOtherIncomeRetainedIncomeCategoryAndIncreasedDollar());
			q19a2Bean.setQ19a2AverageChangeInOtherIncomeRetainedIncomeCategoryAndIncreasedDollarAtExit(q19dataBean.getAverageChangeInOtherIncomeRetainedIncomeCategoryAndIncreasedDollar());
		//I
			q19a2Bean.setQ19a2NoOfAdultsWithOtherIncomePerformanceMeasures(q19dataBean.getNoOfAdultsWithOtherIncomePerformanceMeasures());
			q19a2Bean.setQ19a2AverageChangeInOtherIncomePerformanceMeasures(q19dataBean.getAverageChangeInOtherIncomePerformanceMeasures());
		
		//#J = I/H
			q19a2Bean.setQ19a2NoOfAdultsWithOtherIncomePercent(q19dataBean.getNoOfAdultsWithOtherIncomePercent());
			q19a2Bean.setQ19a2AverageChangeInOtherIncomePercent(BigInteger.ZERO);
	   }
	
	
	public static void 	hydrateOverallIncome(Q19DataBean q19dataBean,Q19a2ClientCashIncomeChangeIncomeSourceByEntryDataBean q19a2Bean) {
		//#B
		    q19a2Bean.setQ19a2AverageChangeInOverallIncomeHadIncomeCategoryAtEntryAndDidNotHaveAtExit(q19dataBean.getAverageChangeInOverallIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup());
			q19a2Bean.setQ19a2NumberOfAdultsWithAnyIncomeHadIncomeCategoryAtEntryAndDidNotHaveAtExit(q19dataBean.getNumberOfAdultsWithAnyIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup());
		//C
			q19a2Bean.setQ19a2NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryButHadLessDollarAtExitThanAtEntry(q19dataBean.getNumberOfAdultsWithAnyIncomeRetainedIncomeCategoryButHadLessDollar());
			q19a2Bean.setQ19a2AverageChangeInOverallIncomeRetainedIncomeCategoryButHadLessDollarAtExitThanAtEntry(q19dataBean.getAverageChangeInOverallIncomeRetainedIncomeCategoryButHadLessDollar());
		//#D
			q19a2Bean.setQ19a2NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryAndSameDollarAtExitAsAtEntry(q19dataBean.getNumberOfAdultsWithAnyIncomeRetainedIncomeCategoryAndSameDollar());
			q19a2Bean.setQ19a2AverageChangeInOverallIncomeRetainedIncomeCategoryAndSameDollarAtExitAsAtEntry(BigInteger.ZERO);
	
		//#F
			q19a2Bean.setQ19a2NumberOfAdultsWithAnyIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedIncomeCategoryExit(q19dataBean.getNumberOfAdultsWithAnyIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome());
			q19a2Bean.setQ19a2AverageChangeInOverallIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedIncomeCategoryExit(q19dataBean.getAverageChangeInOverallIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome());
		//#G
			q19a2Bean.setQ19a2NumberOfAdultsWithAnyIncomeDidNotHaveIncomeCategoryAtEntryOrExit(q19dataBean.getNumberOfAdultsWithAnyIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup());
			q19a2Bean.setQ19a2AverageChangeInOverallIncomeDidNotHaveIncomeCategoryAtEntryOrExit(BigInteger.ZERO);
	
		//#H 
			q19a2Bean.setQ19a2NumberOfAdultsWithAnyIncomeTotalAdult(q19dataBean.getNumberOfAdultsWithAnyIncomeTotalAdult());
			q19a2Bean.setQ19a2AverageChangeInOverallIncomeTotalAdult(q19dataBean.getAverageChangeInOverallIncomeTotalAdult());
		
		//#E
			q19a2Bean.setQ19a2NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryAndIncreasedDollarAtExit(q19dataBean.getNumberOfAdultsWithAnyIncomeRetainedIncomeCategoryAndIncreasedDollar());
			q19a2Bean.setQ19a2AverageChangeInOverallIncomeRetainedIncomeCategoryAndIncreasedDollarAtExit(q19dataBean.getAverageChangeInOverallIncomeRetainedIncomeCategoryAndIncreasedDollar());
		//I
			q19a2Bean.setQ19a2NumberOfAdultsWithAnyIncomePerformanceMeasures(q19dataBean.getNumberOfAdultsWithAnyIncomePerformanceMeasures());
			q19a2Bean.setQ19a2AverageChangeInOverallIncomePerformanceMeasures(q19dataBean.getAverageChangeInOverallIncomePerformanceMeasures());
		
		//#J = I/H
			q19a2Bean.setQ19a2NumberOfAdultsWithAnyIncomePercent(q19dataBean.getNumberOfAdultsWithAnyIncomePercent());
			q19a2Bean.setQ19a2AverageChangeInOverallIncomePercent(BigInteger.ZERO);
	   }


	
}
