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

import com.servinglynk.report.bean.Q19a1ClientCashIncomeChangeIncomeSourceEntryDataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.IncomeAndSourceModel;

public class Q19a1DataBeanMaker extends BaseBeanMaker {
	static BigInteger earnedIncomeTotal = BigInteger.ZERO;
	static BigInteger otherIncomeTotal = BigInteger.ZERO;
	static BigInteger overallIncomeTotal = BigInteger.ZERO;
	public static List<Q19a1ClientCashIncomeChangeIncomeSourceEntryDataBean> getQ19a1ClientCashIncomeChangeIncomeSourceEntryDataBeanList(ReportData data){
	
		Q19a1ClientCashIncomeChangeIncomeSourceEntryDataBean q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate = new Q19a1ClientCashIncomeChangeIncomeSourceEntryDataBean();
		if(data.isLiveMode()) {
			try {

					List<IncomeAndSourceModel> incomeAndSourcesAtEntry = data.getIncomeAndSourcesAtEntry();
					List<IncomeAndSourceModel> incomeAndSourcesAtAnnualAssesment = data.getIncomeAndSourcesAtAnnualAssesment();
					
					List<IncomeAndSourceModel> incomes = new ArrayList<>();
					incomes.addAll(incomeAndSourcesAtEntry);
					incomes.addAll(incomeAndSourcesAtAnnualAssesment);
					
					if(CollectionUtils.isNotEmpty(incomes)){
						int total = getIncomeCnt(incomes);
						BigInteger allClientsBigInt = BigInteger.valueOf(total);
						populateEarnedIncome(q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate, incomes, allClientsBigInt);
						populateOtherIncome(q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate, incomes, allClientsBigInt);
						populateOverallIncomeIncome(q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate, incomes, allClientsBigInt);
			
					}
			}catch(Exception e) {
		logger.error("Error in Q19a1DataBeanMaker:" + e);
			}
		}
		return Arrays.asList(q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate);
		
	}

	public static void populateEarnedIncome(Q19a1ClientCashIncomeChangeIncomeSourceEntryDataBean q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate, List<IncomeAndSourceModel> incomes,BigInteger allClientsBigInt) {
		List<IncomeAndSourceModel> earnedIncomeAtEntry = incomes.parallelStream().filter(income -> StringUtils.equals("1",income.getDataCollectionStage()) && getFloat(income.getEarnedamount()) > 0 ).collect(Collectors.toList());
		List<IncomeAndSourceModel> earnedIncomeATEntryButNotAtAA = incomes.parallelStream().filter(income -> StringUtils.equals("5",income.getDataCollectionStage()) && getFloat(income.getEarnedamount()) > 0 ).collect(Collectors.toList());
		
		Map<String,BigInteger>  earnedIncomeMapAtEntry = new HashMap<>();
		earnedIncomeAtEntry.forEach(incomeAndSource ->  {earnedIncomeMapAtEntry.put(incomeAndSource.getDedupClientId(), BigInteger.valueOf(getFloat(incomeAndSource.getEarnedamount()))); earnedIncomeTotal = earnedIncomeTotal.add( BigInteger.valueOf(getFloat(incomeAndSource.getEarnedamount()))); } );
		
		Map<String,BigInteger>  earnedIncomeMapAtAA = new HashMap<>();
		earnedIncomeATEntryButNotAtAA.forEach(incomeAndSource -> { earnedIncomeMapAtAA.put(incomeAndSource.getDedupClientId(), BigInteger.valueOf(getFloat(incomeAndSource.getEarnedamount()))); });
		
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
					earnedIncomeCatLessAtAAThanAtEntry= earnedIncomeCatLessAtAAThanAtEntry.add(earnedAmountAtEntry);
				}
				if(earnedAmountAtEntry.compareTo(earnedAmountAtAA) ==0) {
					retainEarnedIncomeCatSameAtAAThanAtEntry++;
					earnedIncomeCatSameAtAAThanAtEntry = earnedIncomeCatSameAtAAThanAtEntry.add(earnedAmountAtEntry);
				}
				if(earnedAmountAtEntry.compareTo(earnedAmountAtAA) == -1) {
					earnedIncomePerformaceMeasure= earnedIncomePerformaceMeasure.add(earnedAmountAtEntry);
					earnedIncomePerformaceMeasure= earnedIncomePerformaceMeasure.add(earnedAmountAtAA);
					retainEarnedIncomeCatGreaterAtAAThanAtEntry++;
					earnedIncomeCatGreaterAtAAThanAtEntry=earnedIncomeCatGreaterAtAAThanAtEntry.add(earnedAmountAtEntry);
				}
			}
		}
		
		//#B
		q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1NoOfAdltsWithEarnedIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup(BigInteger.valueOf(earnedIncomeAtStartWithOutAA));
		if(CollectionUtils.isNotEmpty(earnedIncomeAtEntry)) {
			BigInteger average = earnedIncomeTotal.divide(BigInteger.valueOf(getIncomeCnt(earnedIncomeAtEntry)));
			average = average.multiply(BigInteger.valueOf(-1));
			q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1AverageChangeInEarnedIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup(average);
		}
	
		//#C
		q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryButHadLessDollar(BigInteger.valueOf(retainEarnedIncomeCatLessAtAAThanAtEntry));
		if(retainEarnedIncomeCatLessAtAAThanAtEntry !=0) {
			BigInteger retainIncomeAtAAThenAtEntryAmount = earnedIncomeCatLessAtAAThanAtEntry.divide(BigInteger.valueOf(retainEarnedIncomeCatLessAtAAThanAtEntry));
			q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1AverageChangeInEarnedIncomeRetainedIncomeCategoryButHadLessDollar(retainIncomeAtAAThenAtEntryAmount);
		}
		//#D
		q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryAndSameDollar(BigInteger.valueOf(retainEarnedIncomeCatSameAtAAThanAtEntry));
		if(retainEarnedIncomeCatSameAtAAThanAtEntry !=0) {
			BigInteger retainIncomeCatSameAtAAThanAtEntryAmount = earnedIncomeCatSameAtAAThanAtEntry.divide(BigInteger.valueOf(retainEarnedIncomeCatSameAtAAThanAtEntry));
			q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1AverageChangeInEarnedIncomeRetainedIncomeCategoryAndSameDollar(retainIncomeCatSameAtAAThanAtEntryAmount);
		}
		
		//#H
		q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1NoOfAdltsWithEarnedIncomeTotalAdult(allClientsBigInt);
		q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1AverageChangeInEarnedIncomeTotalAdult(BigInteger.ZERO);
		
	
		if(retainEarnedIncomeCatGreaterAtAAThanAtEntry !=0) {
				//#E
				q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryAndIncreasedDollar(BigInteger.valueOf(retainEarnedIncomeCatGreaterAtAAThanAtEntry));
				BigInteger retainIncomeCatGreater = BigInteger.valueOf(retainEarnedIncomeCatGreaterAtAAThanAtEntry);
				BigInteger earnedIncomeCatGreaterAtAAThanAtEntryAmount = earnedIncomeCatGreaterAtAAThanAtEntry.divide(retainIncomeCatGreater);
				q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1AverageChangeInEarnedIncomeRetainedIncomeCategoryAndIncreasedDollar(earnedIncomeCatGreaterAtAAThanAtEntryAmount);
			
				//#I
				BigInteger  earnedIncomePerformaceMeasureAverage =  earnedIncomePerformaceMeasure.divide(retainIncomeCatGreater);
				q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1NoOfAdltsWithEarnedIncomePerformanceMeasures(earnedIncomePerformaceMeasure);
				q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1AverageChangeInEarnedIncomePerformanceMeasures(earnedIncomePerformaceMeasureAverage);
			
				//#J
				q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1NoOfAdltsWithEarnedIncomePercent(earnedIncomePerformaceMeasure.divide(allClientsBigInt));
				q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1AverageChangeInEarnedIncomePercent(BigInteger.ZERO);
			}
		Set<String> keySetAtAA = earnedIncomeMapAtAA.keySet();
		int noOfAdultsDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome = 0;
		BigInteger sumadultsDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome = BigInteger.ZERO;
		for(String key : keySetAtAA) {
			BigInteger earnedAmountAtEntry = earnedIncomeMapAtEntry.get(key);
			BigInteger earnedAmountAtAA = earnedIncomeMapAtAA.get(key);
			if((earnedAmountAtEntry== null || ( earnedAmountAtEntry != null && earnedAmountAtEntry.compareTo(BigInteger.ZERO) ==0 )) && earnedAmountAtAA !=null) {
				noOfAdultsDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome ++;
				sumadultsDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome= sumadultsDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome.add(earnedAmountAtAA);
			}
		}
		List<IncomeAndSourceModel> didNotHaveEarnedIncomeAtEntry = incomes.parallelStream().filter(income -> StringUtils.equals("1",income.getDataCollectionStage()) &&  getFloat(income.getEarnedamount()) ==0).collect(Collectors.toList());
		
		List<IncomeAndSourceModel> didNotHaveEarnedIncomeATEntryButNotAtAA = incomes.parallelStream().filter(income -> StringUtils.equals("5",income.getDataCollectionStage()) && getFloat(income.getEarnedamount()) ==0).collect(Collectors.toList());
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
			q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1NoOfAdltsWithEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome(BigInteger.valueOf(noOfAdultsDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome));
			q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1AverageChangeInEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome(average);
		}
		//#G
		q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1NoOfAdltsWithEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup(BigInteger.valueOf(getSize(clientIds)));
		q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1AverageChangeInEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup(BigInteger.ZERO);

	}
	public static void populateOtherIncome(Q19a1ClientCashIncomeChangeIncomeSourceEntryDataBean q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate, List<IncomeAndSourceModel> incomes,BigInteger allClientsBigInt) {
		
		List<IncomeAndSourceModel> otherIncomeAtEntry = incomes.parallelStream().filter(income -> StringUtils.equals("1",income.getDataCollectionStage()) && (getFloat(income.getTotalmonthlyincome()) - getFloat(income.getEarnedamount()))  >0).collect(Collectors.toList());
		List<IncomeAndSourceModel> otherIncomeATEntryButNotAtAA = incomes.parallelStream().filter(income -> StringUtils.equals("5",income.getDataCollectionStage()) && (getFloat(income.getTotalmonthlyincome()) - getFloat(income.getEarnedamount()))  >0).collect(Collectors.toList());
		
		Map<String,BigInteger>  otherIncomeMapAtEntry = new HashMap<>();
		otherIncomeAtEntry.forEach(incomeAndSource ->  {otherIncomeMapAtEntry.put(incomeAndSource.getDedupClientId(), BigInteger.valueOf((getFloat(incomeAndSource.getTotalmonthlyincome()) - getFloat(incomeAndSource.getEarnedamount())))); otherIncomeTotal = otherIncomeTotal.add( BigInteger.valueOf((getFloat(incomeAndSource.getTotalmonthlyincome()) - getFloat(incomeAndSource.getEarnedamount()))));  } );
		
		Map<String,BigInteger>  otherIncomeMapAtAA = new HashMap<>();
		otherIncomeATEntryButNotAtAA.forEach(incomeAndSource -> { otherIncomeMapAtAA.put(incomeAndSource.getDedupClientId(), BigInteger.valueOf((getFloat(incomeAndSource.getTotalmonthlyincome()) - getFloat(incomeAndSource.getEarnedamount())))); });
		
		Set<String> otherKeySetAtEntry = otherIncomeMapAtEntry.keySet();
		int otherIncomeAtStartWithOutAA = 0;
		
		BigInteger incomeAtStartAndNotAtAA = BigInteger.ZERO;
		for(String key : otherKeySetAtEntry) {
			BigInteger otherAmount = otherIncomeMapAtAA.get(key);
			if(otherAmount == null) {
				incomeAtStartAndNotAtAA = incomeAtStartAndNotAtAA.add(otherIncomeMapAtEntry.get(key));
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
					otherIncomeCatLessAtAAThanAtEntry= otherIncomeCatLessAtAAThanAtEntry.add(otherAmountAtEntry);
				}
				if(otherAmountAtEntry.compareTo(otherAmountAtAA) ==0) {
					retainOtherIncomeCatSameAtAAThanAtEntry++;
					otherIncomeCatSameAtAAThanAtEntry = otherIncomeCatSameAtAAThanAtEntry.add(otherAmountAtEntry);
				}
				if(otherAmountAtEntry.compareTo(otherAmountAtAA) == -1) {
					otherIncomeCatGreaterAtAAThanAtEntry = otherIncomePerformaceMeasure.add(otherAmountAtEntry);
					otherIncomeCatGreaterAtAAThanAtEntry= otherIncomePerformaceMeasure.add(otherAmountAtAA);
					retainOtherIncomeCatGreaterAtAAThanAtEntry++;
					otherIncomeCatGreaterAtAAThanAtEntry = otherIncomeCatGreaterAtAAThanAtEntry.add(otherAmountAtEntry);
				}
			}
		}
		
		//#B
		q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1AverageChangeInOtherIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup(BigInteger.valueOf(otherIncomeAtStartWithOutAA));
		if(CollectionUtils.isNotEmpty(otherIncomeAtEntry) && otherIncomeAtStartWithOutAA !=0) {
			BigInteger average = incomeAtStartAndNotAtAA.divide(BigInteger.valueOf(otherIncomeAtStartWithOutAA));
			average = average.multiply(BigInteger.valueOf(-1));
			q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1AverageChangeInOtherIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup(average);
		}
		//#C
		q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1NoOfAdultsWithOtherIncomeRetainedIncomeCategoryButHadLessDollar(BigInteger.valueOf(retainOtherIncomeCatLessAtAAThanAtEntry));
		if(retainOtherIncomeCatLessAtAAThanAtEntry !=0) {
			BigInteger retainIncomeAtAAThenAtEntryAmount = otherIncomeCatLessAtAAThanAtEntry.divide(BigInteger.valueOf(retainOtherIncomeCatLessAtAAThanAtEntry));
			q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1AverageChangeInOtherIncomeRetainedIncomeCategoryButHadLessDollar(retainIncomeAtAAThenAtEntryAmount);
		}
		//#D
		q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1NoOfAdultsWithOtherIncomeRetainedIncomeCategoryAndSameDollar(BigInteger.valueOf(retainOtherIncomeCatSameAtAAThanAtEntry));
		if(retainOtherIncomeCatSameAtAAThanAtEntry !=0) {
			BigInteger retainIncomeCatSameAtAAThanAtEntryAmount = otherIncomeCatSameAtAAThanAtEntry.divide(BigInteger.valueOf(retainOtherIncomeCatSameAtAAThanAtEntry));
			q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1AverageChangeInOtherIncomeRetainedIncomeCategoryAndSameDollar(retainIncomeCatSameAtAAThanAtEntryAmount);
		}
		
		//#H
		q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1NoOfAdultsWithOtherIncomeTotalAdult(allClientsBigInt);
		q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1AverageChangeInOtherIncomeTotalAdult(BigInteger.ZERO);
		
	
		if(retainOtherIncomeCatGreaterAtAAThanAtEntry !=0) {
				//#E
				q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1NoOfAdultsWithOtherIncomeRetainedIncomeCategoryAndIncreasedDollar(BigInteger.valueOf(retainOtherIncomeCatGreaterAtAAThanAtEntry));
				BigInteger retainIncomeCatGreater = BigInteger.valueOf(retainOtherIncomeCatGreaterAtAAThanAtEntry);
				BigInteger otherIncomeCatGreaterAtAAThanAtEntryAmount = otherIncomeCatGreaterAtAAThanAtEntry.divide(retainIncomeCatGreater);
				q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1AverageChangeInOtherIncomeRetainedIncomeCategoryAndIncreasedDollar(otherIncomeCatGreaterAtAAThanAtEntryAmount);
			
				//#I
				BigInteger  otherIncomePerformaceMeasureAverage =  otherIncomePerformaceMeasure.divide(retainIncomeCatGreater);
				q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1NoOfAdultsWithOtherIncomePerformanceMeasures(otherIncomePerformaceMeasure);
				q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1AverageChangeInOtherIncomePerformanceMeasures(otherIncomePerformaceMeasureAverage);
			
				//#J
				q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1NoOfAdultsWithOtherIncomePercent(otherIncomePerformaceMeasure.divide(allClientsBigInt));
				q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1AverageChangeInOtherIncomePercent(BigInteger.ZERO);
			}
		Set<String> otherKeySetAtAA = otherIncomeMapAtAA.keySet();
		int noOfAdultsDidNotHaveTheOtherIncomeCategoryAtEntryAndGainedTheIncome = 0;
		BigInteger sumadultsDidNotHaveOtherIncomeCategoryAtEntryAndGainedTheIncome = BigInteger.ZERO;
		for(String key : otherKeySetAtAA) {
			BigInteger otherAmountAtEntry = otherIncomeMapAtEntry.get(key);
			BigInteger otherAmountAtAA = otherIncomeMapAtAA.get(key);
			if((otherAmountAtEntry== null || ( otherAmountAtEntry != null && otherAmountAtEntry.compareTo(BigInteger.ZERO) ==0 )) && otherAmountAtAA !=null) {
				noOfAdultsDidNotHaveTheOtherIncomeCategoryAtEntryAndGainedTheIncome ++;
				sumadultsDidNotHaveOtherIncomeCategoryAtEntryAndGainedTheIncome = sumadultsDidNotHaveOtherIncomeCategoryAtEntryAndGainedTheIncome.add(otherAmountAtAA);
			}
		}
		List<IncomeAndSourceModel> didNotHaveOtherIncomeAtEntry = incomes.parallelStream().filter(income -> StringUtils.equals("1",income.getDataCollectionStage()) && (getFloat(income.getTotalmonthlyincome()) - getFloat(income.getEarnedamount()))  ==0).collect(Collectors.toList());
		List<IncomeAndSourceModel> didNotHaveOtherIncomeATEntryButNotAtAA = incomes.parallelStream().filter(income -> StringUtils.equals("5",income.getDataCollectionStage()) && (getFloat(income.getTotalmonthlyincome()) - getFloat(income.getEarnedamount()))  ==0).collect(Collectors.toList());
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
			q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1NoOfAdultsWithOtherIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome(BigInteger.valueOf(noOfAdultsDidNotHaveTheOtherIncomeCategoryAtEntryAndGainedTheIncome));
			q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1AverageChangeInOtherIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome(average);
		}
		//#G
		q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1NoOfAdultsWithOtherIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup(BigInteger.valueOf(getSize(clientIds)));
		q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1AverageChangeInOtherIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup(BigInteger.ZERO);

	}
	
public static void populateOverallIncomeIncome(Q19a1ClientCashIncomeChangeIncomeSourceEntryDataBean q19a1Bean, List<IncomeAndSourceModel> incomes,BigInteger allClientsBigInt) {
		
		List<IncomeAndSourceModel> otherIncomeAtEntry = incomes.parallelStream().filter(income -> StringUtils.equals("1",income.getDataCollectionStage()) && getFloat(income.getTotalmonthlyincome()) >0).collect(Collectors.toList());
		List<IncomeAndSourceModel> otherIncomeATEntryButNotAtAA = incomes.parallelStream().filter(income -> StringUtils.equals("5",income.getDataCollectionStage()) && getFloat(income.getTotalmonthlyincome()) >0).collect(Collectors.toList());
		
		Map<String,BigInteger>  otherIncomeMapAtEntry = new HashMap<>();
		otherIncomeAtEntry.forEach(incomeAndSource ->  {otherIncomeMapAtEntry.put(incomeAndSource.getDedupClientId(), BigInteger.valueOf(getFloat(incomeAndSource.getTotalmonthlyincome()))); overallIncomeTotal = overallIncomeTotal.add(BigInteger.valueOf(getFloat(incomeAndSource.getTotalmonthlyincome()))); } );
		
		Map<String,BigInteger>  otherIncomeMapAtAA = new HashMap<>();
		otherIncomeATEntryButNotAtAA.forEach(incomeAndSource -> { otherIncomeMapAtAA.put(incomeAndSource.getDedupClientId(), BigInteger.valueOf(getFloat(incomeAndSource.getTotalmonthlyincome()))); });
		
		Set<String> otherKeySetAtEntry = otherIncomeMapAtEntry.keySet();
		int otherIncomeAtStartWithOutAA = 0;
		
		BigInteger incomeAtStartAndNotAtAA = BigInteger.ZERO;
		for(String key : otherKeySetAtEntry) {
			BigInteger otherAmount = otherIncomeMapAtAA.get(key);
			if(otherAmount == null) {
				incomeAtStartAndNotAtAA = incomeAtStartAndNotAtAA.add(otherIncomeMapAtEntry.get(key));
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
					otherIncomeCatLessAtAAThanAtEntry = otherIncomeCatLessAtAAThanAtEntry.add(otherAmountAtEntry);
				}
				if(otherAmountAtEntry.compareTo(otherAmountAtAA) ==0) {
					retainOtherIncomeCatSameAtAAThanAtEntry++;
					otherIncomeCatSameAtAAThanAtEntry = otherIncomeCatSameAtAAThanAtEntry.add(otherAmountAtEntry);
				}
				if(otherAmountAtEntry.compareTo(otherAmountAtAA) == -1) {
					otherIncomePerformaceMeasure = otherIncomePerformaceMeasure.add(otherAmountAtEntry);
					otherIncomePerformaceMeasure = otherIncomePerformaceMeasure.add(otherAmountAtAA);
					retainOtherIncomeCatGreaterAtAAThanAtEntry++;
					otherIncomeCatGreaterAtAAThanAtEntry = otherIncomeCatGreaterAtAAThanAtEntry.add(otherAmountAtEntry);
				}
			}
		}
		
		//#B
		q19a1Bean.setQ19a1NumberOfAdultsWithAnyIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup(BigInteger.valueOf(otherIncomeAtStartWithOutAA));
		if(CollectionUtils.isNotEmpty(otherIncomeAtEntry)) {
			BigInteger average = incomeAtStartAndNotAtAA.divide(BigInteger.valueOf(getIncomeCnt(otherIncomeAtEntry)));
			average = average.multiply(BigInteger.valueOf(-1));
			q19a1Bean.setQ19a1AverageChangeInOverallIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup(average);
		}
		//#C
		q19a1Bean.setQ19a1NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryButHadLessDollar(BigInteger.valueOf(retainOtherIncomeCatLessAtAAThanAtEntry));
		if(retainOtherIncomeCatLessAtAAThanAtEntry !=0) {
			BigInteger retainIncomeAtAAThenAtEntryAmount = otherIncomeCatLessAtAAThanAtEntry.divide(BigInteger.valueOf(retainOtherIncomeCatLessAtAAThanAtEntry));
			q19a1Bean.setQ19a1AverageChangeInOverallIncomeRetainedIncomeCategoryButHadLessDollar(retainIncomeAtAAThenAtEntryAmount);
		}
		//#D
		q19a1Bean.setQ19a1NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryAndSameDollar(BigInteger.valueOf(retainOtherIncomeCatSameAtAAThanAtEntry));
		if(retainOtherIncomeCatSameAtAAThanAtEntry !=0) {
			BigInteger retainIncomeCatSameAtAAThanAtEntryAmount = otherIncomeCatSameAtAAThanAtEntry.divide(BigInteger.valueOf(retainOtherIncomeCatSameAtAAThanAtEntry));
			q19a1Bean.setQ19a1AverageChangeInOverallIncomeRetainedIncomeCategoryAndSameDollar(retainIncomeCatSameAtAAThanAtEntryAmount);
		}
		
		//#H
		q19a1Bean.setQ19a1NumberOfAdultsWithAnyIncomeTotalAdult(allClientsBigInt);
	    q19a1Bean.setQ19a1AverageChangeInOverallIncomeTotalAdult(BigInteger.ZERO);
	
		if(retainOtherIncomeCatGreaterAtAAThanAtEntry !=0) {
				//#E
				q19a1Bean.setQ19a1NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryAndIncreasedDollar(BigInteger.valueOf(retainOtherIncomeCatGreaterAtAAThanAtEntry));
				BigInteger retainIncomeCatGreater = BigInteger.valueOf(retainOtherIncomeCatGreaterAtAAThanAtEntry);
				BigInteger otherIncomeCatGreaterAtAAThanAtEntryAmount = otherIncomeCatGreaterAtAAThanAtEntry.divide(retainIncomeCatGreater);
				q19a1Bean.setQ19a1AverageChangeInOverallIncomeRetainedIncomeCategoryAndIncreasedDollar(otherIncomeCatGreaterAtAAThanAtEntryAmount);
			
				//#I
				BigInteger  otherIncomePerformaceMeasureAverage =  otherIncomePerformaceMeasure.divide(retainIncomeCatGreater);
				q19a1Bean.setQ19a1NumberOfAdultsWithAnyIncomePerformanceMeasures(otherIncomePerformaceMeasure);
				q19a1Bean.setQ19a1AverageChangeInOverallIncomePerformanceMeasures(otherIncomePerformaceMeasureAverage);
			
				//#J
				q19a1Bean.setQ19a1NumberOfAdultsWithAnyIncomePercent(otherIncomePerformaceMeasure.divide(allClientsBigInt));
				q19a1Bean.setQ19a1AverageChangeInOverallIncomePercent(BigInteger.ZERO);
			}
		Set<String> otherKeySetAtAA = otherIncomeMapAtAA.keySet();
		int noOfAdultsDidNotHaveTheOtherIncomeCategoryAtEntryAndGainedTheIncome = 0;
		BigInteger sumadultsDidNotHaveOtherIncomeCategoryAtEntryAndGainedTheIncome = BigInteger.ZERO;
		for(String key : otherKeySetAtAA) {
			BigInteger otherAmountAtEntry = otherIncomeMapAtEntry.get(key);
			BigInteger otherAmountAtAA = otherIncomeMapAtAA.get(key);
			if((otherAmountAtEntry== null || ( otherAmountAtEntry != null && otherAmountAtEntry.compareTo(BigInteger.ZERO) ==0 ))  && otherAmountAtAA !=null) {
				noOfAdultsDidNotHaveTheOtherIncomeCategoryAtEntryAndGainedTheIncome ++;
				sumadultsDidNotHaveOtherIncomeCategoryAtEntryAndGainedTheIncome.add(otherAmountAtAA);
			}
		}
		List<IncomeAndSourceModel> didNotHaveOtherIncomeAtEntry = incomes.parallelStream().filter(income -> StringUtils.equals("1",income.getDataCollectionStage()) && getFloat(income.getTotalmonthlyincome()) ==0).collect(Collectors.toList());
		List<IncomeAndSourceModel> didNotHaveOtherIncomeATEntryButNotAtAA = incomes.parallelStream().filter(income -> StringUtils.equals("5",income.getDataCollectionStage()) && getFloat(income.getTotalmonthlyincome()) ==0).collect(Collectors.toList());
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
			q19a1Bean.setQ19a1NumberOfAdultsWithAnyIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome(BigInteger.valueOf(noOfAdultsDidNotHaveTheOtherIncomeCategoryAtEntryAndGainedTheIncome));
			q19a1Bean.setQ19a1AverageChangeInOverallIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome(average);
		}
		//#G
		q19a1Bean.setQ19a1NumberOfAdultsWithAnyIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup(BigInteger.valueOf(getSize(clientIds)));
		q19a1Bean.setQ19a1AverageChangeInOverallIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup(BigInteger.ZERO);

	}
	
}
