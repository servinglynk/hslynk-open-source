package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.servinglynk.report.bean.Q19a2ClientCashIncomeChangeIncomeSourceByEntryDataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.EnrollmentModel;
import com.servinglynk.report.model.IncomeAndSourceModel;

public class Q19a2DataBeanMaker extends BaseBeanMaker {
	static BigInteger earnedIncomeTotal = BigInteger.ZERO;
	static BigInteger otherIncomeTotal = BigInteger.ZERO;
	static BigInteger overallIncomeTotal = BigInteger.ZERO;
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
						BigInteger allClientsBigInt = BigInteger.valueOf(getSize(allClients));
						
						populateEarnedIncome(q19a2Bean, incomes, allClientsBigInt);
						populateOtherIncome(q19a2Bean, incomes, allClientsBigInt);
						populateOverallIncomeIncome(q19a2Bean, incomes, allClientsBigInt);
					}
			}catch(Exception e) {
		logger.error("Error in 19a2BeanMaker:" + e);
			}
		}
		return Arrays.asList(q19a2Bean);
		
	}
	

	public static void populateEarnedIncome(Q19a2ClientCashIncomeChangeIncomeSourceByEntryDataBean q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate, List<IncomeAndSourceModel> incomes,BigInteger allClientsBigInt) {
		List<IncomeAndSourceModel> earnedIncomeAtEntry = incomes.parallelStream().filter(income -> StringUtils.equals("1",income.getDataCollectionStage()) && getFloat(income.getEarnedamount())  >0).collect(Collectors.toList());
		List<IncomeAndSourceModel> earnedIncomeATEntryButNotAtAA = incomes.parallelStream().filter(income -> StringUtils.equals("3",income.getDataCollectionStage()) && getFloat(income.getEarnedamount()) >0).collect(Collectors.toList());
		
		Map<String,BigInteger>  earnedIncomeMapAtEntry = new HashMap<>();
		earnedIncomeAtEntry.forEach(incomeAndSource ->  {earnedIncomeMapAtEntry.put(incomeAndSource.getDedupClientId(), BigInteger.valueOf(getFloat(incomeAndSource.getEarnedamount()))); earnedIncomeTotal = earnedIncomeTotal.add(BigInteger.valueOf( getFloat(incomeAndSource.getEarnedamount()))); } );
		
		Map<String,BigInteger>  earnedIncomeMapAtAA = new HashMap<>();
		earnedIncomeATEntryButNotAtAA.forEach(incomeAndSource -> { earnedIncomeMapAtAA.put(incomeAndSource.getDedupClientId(), BigInteger.valueOf( getFloat(incomeAndSource.getEarnedamount()))); });
		
		Set<String> earnedKeySetAtEntry = earnedIncomeMapAtEntry.keySet();
		int earnedIncomeAtStartWithOutAA = 0;
		
		for(String key : earnedKeySetAtEntry) {
			BigInteger earnedAmount = earnedIncomeMapAtAA.get(key);
			if(earnedAmount == null) {
				earnedIncomeAtStartWithOutAA++;
			}
		}
		
		int retainEarnedIncomeCatLessAtAAThanAtEntry = 0;
		int retainEarnedIncomeCatSameAtAAThanAtEntry = 0;
		int retainEarnedIncomeCatGreaterAtAAThanAtEntry = 0;
		
		BigInteger earnedIncomeCatLessAtAAThanAtEntry = BigInteger.ZERO;
		BigInteger earnedIncomeCatSameAtAAThanAtEntry= BigInteger.ZERO;
		BigInteger earnedIncomeCatGreaterAtAAThanAtEntry = BigInteger.ZERO;
		BigInteger earnedIncomePerformaceMeasure = BigInteger.ZERO;
		for(String key : earnedKeySetAtEntry) {
			BigInteger earnedAmountAtEntry = earnedIncomeMapAtEntry.get(key);
			BigInteger earnedAmountAtAA = earnedIncomeMapAtAA.get(key);
			if(earnedAmountAtEntry != null && earnedAmountAtAA != null) {
				if(earnedAmountAtEntry.compareTo(earnedAmountAtAA) ==1) {
					retainEarnedIncomeCatLessAtAAThanAtEntry++;
					earnedIncomeCatLessAtAAThanAtEntry.add(earnedAmountAtEntry);
				}
				if(earnedAmountAtEntry.compareTo(earnedAmountAtAA) ==0) {
					retainEarnedIncomeCatSameAtAAThanAtEntry++;
					earnedIncomeCatSameAtAAThanAtEntry.add(earnedAmountAtEntry);
				}
				if(earnedAmountAtEntry.compareTo(earnedAmountAtAA) == -1) {
					earnedIncomePerformaceMeasure.add(earnedAmountAtEntry);
					earnedIncomePerformaceMeasure.add(earnedAmountAtAA);
					retainEarnedIncomeCatGreaterAtAAThanAtEntry++;
					earnedIncomeCatGreaterAtAAThanAtEntry.add(earnedAmountAtEntry);
				}
			}
		}
		
		//#B
		q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a2NoOfAdltsWithEarnedIncomeHadIncomeCategoryAtEntryAndDidNotHaveAtExit(BigInteger.valueOf(earnedIncomeAtStartWithOutAA));
		if(CollectionUtils.isNotEmpty(earnedIncomeAtEntry)) {
			BigInteger average = earnedIncomeTotal.divide(BigInteger.valueOf(earnedIncomeAtEntry.size()));
			q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a2AverageChangeInEarnedIncomeHadIncomeCategoryAtEntryAndDidNotHaveAtExit(average);
		}
	
		//#C
		q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a2NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryButHadLessDollarAtExitThanAtEntry(BigInteger.valueOf(retainEarnedIncomeCatLessAtAAThanAtEntry));
		if(retainEarnedIncomeCatLessAtAAThanAtEntry !=0) {
			BigInteger retainIncomeAtAAThenAtEntryAmount = earnedIncomeCatLessAtAAThanAtEntry.divide(BigInteger.valueOf(retainEarnedIncomeCatLessAtAAThanAtEntry));
			q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a2AverageChangeInEarnedIncomeRetainedIncomeCategoryButHadLessDollarAtExitThanAtEntry(retainIncomeAtAAThenAtEntryAmount);
		}
		//#D
		q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a2NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryAndSameDollarAtExitAsAtEntry(BigInteger.valueOf(retainEarnedIncomeCatSameAtAAThanAtEntry));
		if(retainEarnedIncomeCatSameAtAAThanAtEntry !=0) {
			BigInteger retainIncomeCatSameAtAAThanAtEntryAmount = earnedIncomeCatSameAtAAThanAtEntry.divide(BigInteger.valueOf(retainEarnedIncomeCatSameAtAAThanAtEntry));
			q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a2AverageChangeInEarnedIncomeRetainedIncomeCategoryAndSameDollarAtExitAsAtEntry(retainIncomeCatSameAtAAThanAtEntryAmount);
		}
		
		//#H
		q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a2NoOfAdltsWithEarnedIncomeTotalAdult(allClientsBigInt);
		q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a2AverageChangeInEarnedIncomeTotalAdult(BigInteger.ZERO);
		
	
		if(retainEarnedIncomeCatGreaterAtAAThanAtEntry !=0) {
				//#E
				q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a2NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryAndIncreasedDollarAtExit(BigInteger.valueOf(retainEarnedIncomeCatGreaterAtAAThanAtEntry));
				BigInteger retainIncomeCatGreater = BigInteger.valueOf(retainEarnedIncomeCatGreaterAtAAThanAtEntry);
				BigInteger earnedIncomeCatGreaterAtAAThanAtEntryAmount = earnedIncomeCatGreaterAtAAThanAtEntry.divide(retainIncomeCatGreater);
				q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a2AverageChangeInEarnedIncomeRetainedIncomeCategoryAndIncreasedDollarAtExit(earnedIncomeCatGreaterAtAAThanAtEntryAmount);
			
				//#I
				BigInteger  earnedIncomePerformaceMeasureAverage =  earnedIncomePerformaceMeasure.divide(retainIncomeCatGreater);
				q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a2NoOfAdltsWithEarnedIncomePerformanceMeasures(earnedIncomePerformaceMeasure);
				q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a2AverageChangeInEarnedIncomePerformanceMeasures(earnedIncomePerformaceMeasureAverage);
			
				//#J
				q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a2NoOfAdltsWithEarnedIncomePercent(earnedIncomePerformaceMeasure.divide(allClientsBigInt));
				q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a2AverageChangeInEarnedIncomePercent(BigInteger.ZERO);
			}
		Set<String> keySetAtAA = earnedIncomeMapAtAA.keySet();
		int noOfAdultsDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome = 0;
		BigInteger sumadultsDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome = BigInteger.ZERO;
		for(String key : keySetAtAA) {
			BigInteger earnedAmountAtEntry = earnedIncomeMapAtEntry.get(key);
			BigInteger earnedAmountAtAA = earnedIncomeMapAtAA.get(key);
			if(earnedAmountAtEntry == null && earnedAmountAtAA !=null) {
				noOfAdultsDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome ++;
				sumadultsDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome.add(earnedAmountAtAA);
			}
		}
		List<IncomeAndSourceModel> didNotHaveEarnedIncomeAtEntry = incomes.parallelStream().filter(income -> StringUtils.equals("1",income.getDataCollectionStage()) && getFloat(income.getEarnedamount()) ==0).collect(Collectors.toList());
		List<IncomeAndSourceModel> didNotHaveEarnedIncomeATEntryButNotAtAA = incomes.parallelStream().filter(income -> StringUtils.equals("3",income.getDataCollectionStage()) && getFloat(income.getEarnedamount()) ==0).collect(Collectors.toList());
		Set<String> clientIds = new HashSet<>();
		if(CollectionUtils.isNotEmpty(didNotHaveEarnedIncomeAtEntry)) {
			didNotHaveEarnedIncomeAtEntry.forEach(incomeSource -> clientIds.add(incomeSource.getDedupClientId()));
		}
		if(CollectionUtils.isNotEmpty(didNotHaveEarnedIncomeATEntryButNotAtAA)) {
			didNotHaveEarnedIncomeATEntryButNotAtAA.forEach(incomeSource -> clientIds.add(incomeSource.getDedupClientId()));
		}
		//#F
		if(noOfAdultsDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome != 0 && sumadultsDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome != BigInteger.ZERO) {
			BigInteger average = sumadultsDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome.divide(BigInteger.valueOf(noOfAdultsDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome));
			q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a2NoOfAdltsWithEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedIncomeCategoryExit(BigInteger.valueOf(noOfAdultsDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome));
			q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a2AverageChangeInEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedIncomeCategoryExit(average);
		}
		//#G
		q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a2NoOfAdltsWithEarnedIncomeDidNotHaveIncomeCategoryAtEntryOrExit(BigInteger.valueOf(getSize(clientIds)));
		q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a2AverageChangeInEarnedIncomeDidNotHaveIncomeCategoryAtEntryOrExit(BigInteger.ZERO);

	}
	public static void populateOtherIncome(Q19a2ClientCashIncomeChangeIncomeSourceByEntryDataBean q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate, List<IncomeAndSourceModel> incomes,BigInteger allClientsBigInt) {
		
		List<IncomeAndSourceModel> otherIncomeAtEntry = incomes.parallelStream().filter(income -> StringUtils.equals("1",income.getDataCollectionStage()) && getFloat(income.getOthersourceamount()) >0).collect(Collectors.toList());
		List<IncomeAndSourceModel> otherIncomeATEntryButNotAtAA = incomes.parallelStream().filter(income -> StringUtils.equals("3",income.getDataCollectionStage()) && getFloat(income.getOthersourceamount()) >0).collect(Collectors.toList());
		
		Map<String,BigInteger>  otherIncomeMapAtEntry = new HashMap<>();
		otherIncomeAtEntry.forEach(incomeAndSource ->  {otherIncomeMapAtEntry.put(incomeAndSource.getDedupClientId(), BigInteger.valueOf(getFloat(incomeAndSource.getOthersourceamount()))); otherIncomeTotal = otherIncomeTotal.add(BigInteger.valueOf(getFloat(incomeAndSource.getOthersourceamount()))); } );
		
		Map<String,BigInteger>  otherIncomeMapAtAA = new HashMap<>();
		otherIncomeATEntryButNotAtAA.forEach(incomeAndSource -> { otherIncomeMapAtAA.put(incomeAndSource.getDedupClientId(), BigInteger.valueOf(getFloat(incomeAndSource.getOthersourceamount()))); });
		
		Set<String> otherKeySetAtEntry = otherIncomeMapAtEntry.keySet();
		int otherIncomeAtStartWithOutAA = 0;
		
		for(String key : otherKeySetAtEntry) {
			BigInteger otherAmount = otherIncomeMapAtAA.get(key);
			if(otherAmount == null) {
				otherIncomeAtStartWithOutAA++;
			}
		}
		
		int retainOtherIncomeCatLessAtAAThanAtEntry = 0;
		int retainOtherIncomeCatSameAtAAThanAtEntry = 0;
		int retainOtherIncomeCatGreaterAtAAThanAtEntry = 0;
		
		BigInteger otherIncomeCatLessAtAAThanAtEntry = BigInteger.ZERO;
		BigInteger otherIncomeCatSameAtAAThanAtEntry= BigInteger.ZERO;
		BigInteger otherIncomeCatGreaterAtAAThanAtEntry = BigInteger.ZERO;
		BigInteger otherIncomePerformaceMeasure = BigInteger.ZERO;
		for(String key : otherKeySetAtEntry) {
			BigInteger otherAmountAtEntry = otherIncomeMapAtEntry.get(key);
			BigInteger otherAmountAtAA = otherIncomeMapAtAA.get(key);
			if(otherAmountAtEntry != null && otherAmountAtAA != null) {
				if(otherAmountAtEntry.compareTo(otherAmountAtAA) ==1) {
					retainOtherIncomeCatLessAtAAThanAtEntry++;
					otherIncomeCatLessAtAAThanAtEntry.add(otherAmountAtEntry);
				}
				if(otherAmountAtEntry.compareTo(otherAmountAtAA) ==0) {
					retainOtherIncomeCatSameAtAAThanAtEntry++;
					otherIncomeCatSameAtAAThanAtEntry.add(otherAmountAtEntry);
				}
				if(otherAmountAtEntry.compareTo(otherAmountAtAA) == -1) {
					otherIncomePerformaceMeasure.add(otherAmountAtEntry);
					otherIncomePerformaceMeasure.add(otherAmountAtAA);
					retainOtherIncomeCatGreaterAtAAThanAtEntry++;
					otherIncomeCatGreaterAtAAThanAtEntry.add(otherAmountAtEntry);
				}
			}
		}
		
		//#B
		q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a2AverageChangeInOtherIncomeHadIncomeCategoryAtEntryAndDidNotHaveAtExit(BigInteger.valueOf(otherIncomeAtStartWithOutAA));
		if(CollectionUtils.isNotEmpty(otherIncomeAtEntry)) {
			BigInteger average = otherIncomeTotal.divide(BigInteger.valueOf(otherIncomeAtEntry.size()));
			q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a2AverageChangeInOtherIncomeHadIncomeCategoryAtEntryAndDidNotHaveAtExit(average);
		}
		//#C
		q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a2NoOfAdultsWithOtherIncomeRetainedIncomeCategoryButHadLessDollarAtExitThanAtEntry(BigInteger.valueOf(retainOtherIncomeCatLessAtAAThanAtEntry));
		if(retainOtherIncomeCatLessAtAAThanAtEntry !=0) {
			BigInteger retainIncomeAtAAThenAtEntryAmount = otherIncomeCatLessAtAAThanAtEntry.divide(BigInteger.valueOf(retainOtherIncomeCatLessAtAAThanAtEntry));
			q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a2AverageChangeInOtherIncomeRetainedIncomeCategoryButHadLessDollarAtExitThanAtEntry(retainIncomeAtAAThenAtEntryAmount);
		}
		//#D
		q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a2NoOfAdultsWithOtherIncomeRetainedIncomeCategoryAndSameDollarAtExitAsAtEntry(BigInteger.valueOf(retainOtherIncomeCatSameAtAAThanAtEntry));
		if(retainOtherIncomeCatSameAtAAThanAtEntry !=0) {
			BigInteger retainIncomeCatSameAtAAThanAtEntryAmount = otherIncomeCatSameAtAAThanAtEntry.divide(BigInteger.valueOf(retainOtherIncomeCatSameAtAAThanAtEntry));
			q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a2AverageChangeInOtherIncomeRetainedIncomeCategoryAndSameDollarAtExitAsAtEntry(retainIncomeCatSameAtAAThanAtEntryAmount);
		}
		
		//#H
		q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a2NoOfAdultsWithOtherIncomeTotalAdult(allClientsBigInt);
		q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a2AverageChangeInOtherIncomeTotalAdult(BigInteger.ZERO);
		
	
		if(retainOtherIncomeCatGreaterAtAAThanAtEntry !=0) {
				//#E
				q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a2NoOfAdultsWithOtherIncomeRetainedIncomeCategoryAndIncreasedDollarAtExit(BigInteger.valueOf(retainOtherIncomeCatGreaterAtAAThanAtEntry));
				BigInteger retainIncomeCatGreater = BigInteger.valueOf(retainOtherIncomeCatGreaterAtAAThanAtEntry);
				BigInteger otherIncomeCatGreaterAtAAThanAtEntryAmount = otherIncomeCatGreaterAtAAThanAtEntry.divide(retainIncomeCatGreater);
				q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a2AverageChangeInOtherIncomeRetainedIncomeCategoryAndIncreasedDollarAtExit(otherIncomeCatGreaterAtAAThanAtEntryAmount);
			
				//#I
				BigInteger  otherIncomePerformaceMeasureAverage =  otherIncomePerformaceMeasure.divide(retainIncomeCatGreater);
				q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a2NoOfAdultsWithOtherIncomePerformanceMeasures(otherIncomePerformaceMeasure);
				q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a2AverageChangeInOtherIncomePerformanceMeasures(otherIncomePerformaceMeasureAverage);
			
				//#J
				q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a2NoOfAdultsWithOtherIncomePercent(otherIncomePerformaceMeasure.divide(allClientsBigInt));
				q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a2AverageChangeInOtherIncomePercent(BigInteger.ZERO);
			}
		Set<String> otherKeySetAtAA = otherIncomeMapAtAA.keySet();
		int noOfAdultsDidNotHaveTheOtherIncomeCategoryAtEntryAndGainedTheIncome = 0;
		BigInteger sumadultsDidNotHaveOtherIncomeCategoryAtEntryAndGainedTheIncome = BigInteger.ZERO;
		for(String key : otherKeySetAtAA) {
			BigInteger otherAmountAtEntry = otherIncomeMapAtEntry.get(key);
			BigInteger otherAmountAtAA = otherIncomeMapAtAA.get(key);
			if(otherAmountAtEntry == null && otherAmountAtAA !=null) {
				noOfAdultsDidNotHaveTheOtherIncomeCategoryAtEntryAndGainedTheIncome ++;
				sumadultsDidNotHaveOtherIncomeCategoryAtEntryAndGainedTheIncome.add(otherAmountAtAA);
			}
		}
		List<IncomeAndSourceModel> didNotHaveOtherIncomeAtEntry = incomes.parallelStream().filter(income -> StringUtils.equals("1",income.getDataCollectionStage()) && getFloat(income.getOthersourceamount()) ==0).collect(Collectors.toList());
		List<IncomeAndSourceModel> didNotHaveOtherIncomeATEntryButNotAtAA = incomes.parallelStream().filter(income -> StringUtils.equals("3",income.getDataCollectionStage()) && getFloat(income.getOthersourceamount()) ==0).collect(Collectors.toList());
		Set<String> clientIds = new HashSet<>();
		if(CollectionUtils.isNotEmpty(didNotHaveOtherIncomeAtEntry)) {
			didNotHaveOtherIncomeAtEntry.forEach(incomeSource -> clientIds.add(incomeSource.getDedupClientId()));
		}
		if(CollectionUtils.isNotEmpty(didNotHaveOtherIncomeATEntryButNotAtAA)) {
			didNotHaveOtherIncomeATEntryButNotAtAA.forEach(incomeSource -> clientIds.add(incomeSource.getDedupClientId()));
		}
		//#F
		if(noOfAdultsDidNotHaveTheOtherIncomeCategoryAtEntryAndGainedTheIncome != 0 && sumadultsDidNotHaveOtherIncomeCategoryAtEntryAndGainedTheIncome != BigInteger.ZERO) {
			BigInteger average = sumadultsDidNotHaveOtherIncomeCategoryAtEntryAndGainedTheIncome.divide(BigInteger.valueOf(noOfAdultsDidNotHaveTheOtherIncomeCategoryAtEntryAndGainedTheIncome));
			q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a2NoOfAdultsWithOtherIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedIncomeCategoryExit(BigInteger.valueOf(noOfAdultsDidNotHaveTheOtherIncomeCategoryAtEntryAndGainedTheIncome));
			q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a2AverageChangeInOtherIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedIncomeCategoryExit(average);
		}
		//#G
		q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a2NoOfAdultsWithOtherIncomeDidNotHaveIncomeCategoryAtEntryOrExit(BigInteger.valueOf(getSize(clientIds)));
		q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a2AverageChangeInOtherIncomeDidNotHaveIncomeCategoryAtEntryOrExit(BigInteger.ZERO);

	}
	
public static void populateOverallIncomeIncome(Q19a2ClientCashIncomeChangeIncomeSourceByEntryDataBean q19a1Bean, List<IncomeAndSourceModel> incomes,BigInteger allClientsBigInt) {
		
		List<IncomeAndSourceModel> otherIncomeAtEntry = incomes.parallelStream().filter(income -> StringUtils.equals("1",income.getDataCollectionStage()) && getFloat(income.getTotalmonthlyincome()) >0).collect(Collectors.toList());
		List<IncomeAndSourceModel> otherIncomeATEntryButNotAtAA = incomes.parallelStream().filter(income -> StringUtils.equals("3",income.getDataCollectionStage()) && getFloat(income.getTotalmonthlyincome()) >0).collect(Collectors.toList());
		
		Map<String,BigInteger>  otherIncomeMapAtEntry = new HashMap<>();
		otherIncomeAtEntry.forEach(incomeAndSource ->  {otherIncomeMapAtEntry.put(incomeAndSource.getDedupClientId(), BigInteger.valueOf(getFloat(incomeAndSource.getTotalmonthlyincome()))); overallIncomeTotal = overallIncomeTotal.add(BigInteger.valueOf(getFloat(incomeAndSource.getTotalmonthlyincome()))); } );
		
		Map<String,BigInteger>  otherIncomeMapAtAA = new HashMap<>();
		otherIncomeATEntryButNotAtAA.forEach(incomeAndSource -> { otherIncomeMapAtAA.put(incomeAndSource.getDedupClientId(), BigInteger.valueOf(getFloat(incomeAndSource.getTotalmonthlyincome()))); });
		
		Set<String> otherKeySetAtEntry = otherIncomeMapAtEntry.keySet();
		int otherIncomeAtStartWithOutAA = 0;
		
		for(String key : otherKeySetAtEntry) {
			BigInteger otherAmount = otherIncomeMapAtAA.get(key);
			if(otherAmount == null) {
				otherIncomeAtStartWithOutAA++;
			}
		}
		
		int retainOtherIncomeCatLessAtAAThanAtEntry = 0;
		int retainOtherIncomeCatSameAtAAThanAtEntry = 0;
		int retainOtherIncomeCatGreaterAtAAThanAtEntry = 0;
		
		BigInteger otherIncomeCatLessAtAAThanAtEntry = BigInteger.ZERO;
		BigInteger otherIncomeCatSameAtAAThanAtEntry= BigInteger.ZERO;
		BigInteger otherIncomeCatGreaterAtAAThanAtEntry = BigInteger.ZERO;
		BigInteger otherIncomePerformaceMeasure = BigInteger.ZERO;
		for(String key : otherKeySetAtEntry) {
			BigInteger otherAmountAtEntry = otherIncomeMapAtEntry.get(key);
			BigInteger otherAmountAtAA = otherIncomeMapAtAA.get(key);
			if(otherAmountAtEntry != null && otherAmountAtAA != null) {
				if(otherAmountAtEntry.compareTo(otherAmountAtAA) ==1) {
					retainOtherIncomeCatLessAtAAThanAtEntry++;
					otherIncomeCatLessAtAAThanAtEntry.add(otherAmountAtEntry);
				}
				if(otherAmountAtEntry.compareTo(otherAmountAtAA) ==0) {
					retainOtherIncomeCatSameAtAAThanAtEntry++;
					otherIncomeCatSameAtAAThanAtEntry.add(otherAmountAtEntry);
				}
				if(otherAmountAtEntry.compareTo(otherAmountAtAA) == -1) {
					otherIncomePerformaceMeasure.add(otherAmountAtEntry);
					otherIncomePerformaceMeasure.add(otherAmountAtAA);
					retainOtherIncomeCatGreaterAtAAThanAtEntry++;
					otherIncomeCatGreaterAtAAThanAtEntry.add(otherAmountAtEntry);
				}
			}
		}
		
		//#B
		q19a1Bean.setQ19a2NumberOfAdultsWithAnyIncomeHadIncomeCategoryAtEntryAndDidNotHaveAtExit(BigInteger.valueOf(otherIncomeAtStartWithOutAA));
		if(CollectionUtils.isNotEmpty(otherIncomeAtEntry)) {
			BigInteger average = overallIncomeTotal.divide(BigInteger.valueOf(otherIncomeAtEntry.size()));
			q19a1Bean.setQ19a2AverageChangeInOverallIncomeHadIncomeCategoryAtEntryAndDidNotHaveAtExit(average);
		}
		//#C
		q19a1Bean.setQ19a2NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryButHadLessDollarAtExitThanAtEntry(BigInteger.valueOf(retainOtherIncomeCatLessAtAAThanAtEntry));
		if(retainOtherIncomeCatLessAtAAThanAtEntry !=0) {
			BigInteger retainIncomeAtAAThenAtEntryAmount = otherIncomeCatLessAtAAThanAtEntry.divide(BigInteger.valueOf(retainOtherIncomeCatLessAtAAThanAtEntry));
			q19a1Bean.setQ19a2AverageChangeInOverallIncomeRetainedIncomeCategoryButHadLessDollarAtExitThanAtEntry(retainIncomeAtAAThenAtEntryAmount);
		}
		//#D
		q19a1Bean.setQ19a2NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryAndSameDollarAtExitAsAtEntry(BigInteger.valueOf(retainOtherIncomeCatSameAtAAThanAtEntry));
		if(retainOtherIncomeCatSameAtAAThanAtEntry !=0) {
			BigInteger retainIncomeCatSameAtAAThanAtEntryAmount = otherIncomeCatSameAtAAThanAtEntry.divide(BigInteger.valueOf(retainOtherIncomeCatSameAtAAThanAtEntry));
			q19a1Bean.setQ19a2AverageChangeInOverallIncomeRetainedIncomeCategoryAndSameDollarAtExitAsAtEntry(retainIncomeCatSameAtAAThanAtEntryAmount);
		}
		
		//#H
		q19a1Bean.setQ19a2NumberOfAdultsWithAnyIncomeTotalAdult(allClientsBigInt);
	    q19a1Bean.setQ19a2AverageChangeInOverallIncomeTotalAdult(BigInteger.ZERO);
	
		if(retainOtherIncomeCatGreaterAtAAThanAtEntry !=0) {
				//#E
				q19a1Bean.setQ19a2NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryAndIncreasedDollarAtExit(BigInteger.valueOf(retainOtherIncomeCatGreaterAtAAThanAtEntry));
				BigInteger retainIncomeCatGreater = BigInteger.valueOf(retainOtherIncomeCatGreaterAtAAThanAtEntry);
				BigInteger otherIncomeCatGreaterAtAAThanAtEntryAmount = otherIncomeCatGreaterAtAAThanAtEntry.divide(retainIncomeCatGreater);
				q19a1Bean.setQ19a2AverageChangeInOverallIncomeRetainedIncomeCategoryAndIncreasedDollarAtExit(otherIncomeCatGreaterAtAAThanAtEntryAmount);
			
				//#I
				BigInteger  otherIncomePerformaceMeasureAverage =  otherIncomePerformaceMeasure.divide(retainIncomeCatGreater);
				q19a1Bean.setQ19a2NumberOfAdultsWithAnyIncomePerformanceMeasures(otherIncomePerformaceMeasure);
				q19a1Bean.setQ19a2AverageChangeInOverallIncomePerformanceMeasures(otherIncomePerformaceMeasureAverage);
			
				//#J
				q19a1Bean.setQ19a2NumberOfAdultsWithAnyIncomePercent(otherIncomePerformaceMeasure.divide(allClientsBigInt));
				q19a1Bean.setQ19a2AverageChangeInOverallIncomePercent(BigInteger.ZERO);
			}
		Set<String> otherKeySetAtAA = otherIncomeMapAtAA.keySet();
		int noOfAdultsDidNotHaveTheOtherIncomeCategoryAtEntryAndGainedTheIncome = 0;
		BigInteger sumadultsDidNotHaveOtherIncomeCategoryAtEntryAndGainedTheIncome = BigInteger.ZERO;
		for(String key : otherKeySetAtAA) {
			BigInteger otherAmountAtEntry = otherIncomeMapAtEntry.get(key);
			BigInteger otherAmountAtAA = otherIncomeMapAtAA.get(key);
			if(otherAmountAtEntry == null && otherAmountAtAA !=null) {
				noOfAdultsDidNotHaveTheOtherIncomeCategoryAtEntryAndGainedTheIncome ++;
				sumadultsDidNotHaveOtherIncomeCategoryAtEntryAndGainedTheIncome.add(otherAmountAtAA);
			}
		}
		List<IncomeAndSourceModel> didNotHaveOtherIncomeAtEntry = incomes.parallelStream().filter(income -> StringUtils.equals("1",income.getDataCollectionStage()) && getFloat(income.getTotalmonthlyincome()) ==0).collect(Collectors.toList());
		List<IncomeAndSourceModel> didNotHaveOtherIncomeATEntryButNotAtAA = incomes.parallelStream().filter(income -> StringUtils.equals("3",income.getDataCollectionStage()) &&  getFloat(income.getTotalmonthlyincome()) ==0).collect(Collectors.toList());
		Set<String> clientIds = new HashSet<>();
		if(CollectionUtils.isNotEmpty(didNotHaveOtherIncomeAtEntry)) {
			didNotHaveOtherIncomeAtEntry.forEach(incomeSource -> clientIds.add(incomeSource.getDedupClientId()));
		}
		if(CollectionUtils.isNotEmpty(didNotHaveOtherIncomeATEntryButNotAtAA)) {
			didNotHaveOtherIncomeATEntryButNotAtAA.forEach(incomeSource -> clientIds.add(incomeSource.getDedupClientId()));
		}
		//#F
		if(noOfAdultsDidNotHaveTheOtherIncomeCategoryAtEntryAndGainedTheIncome != 0 && sumadultsDidNotHaveOtherIncomeCategoryAtEntryAndGainedTheIncome != BigInteger.ZERO) {
			BigInteger average = sumadultsDidNotHaveOtherIncomeCategoryAtEntryAndGainedTheIncome.divide(BigInteger.valueOf(noOfAdultsDidNotHaveTheOtherIncomeCategoryAtEntryAndGainedTheIncome));
			q19a1Bean.setQ19a2NumberOfAdultsWithAnyIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedIncomeCategoryExit(BigInteger.valueOf(noOfAdultsDidNotHaveTheOtherIncomeCategoryAtEntryAndGainedTheIncome));
			q19a1Bean.setQ19a2AverageChangeInOverallIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedIncomeCategoryExit(average);
		}
		//#G
		q19a1Bean.setQ19a2NumberOfAdultsWithAnyIncomeDidNotHaveIncomeCategoryAtEntryOrExit(BigInteger.valueOf(getSize(clientIds)));
		q19a1Bean.setQ19a2AverageChangeInOverallIncomeDidNotHaveIncomeCategoryAtEntryOrExit(BigInteger.ZERO);

	}
	
}
