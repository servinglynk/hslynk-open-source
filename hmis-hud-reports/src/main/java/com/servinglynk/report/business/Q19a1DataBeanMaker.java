package com.servinglynk.report.business;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

import com.servinglynk.hive.connection.ImpalaConnection;
import com.servinglynk.report.bean.Q19a1ClientCashIncomeChangeIncomeSourceEntryDataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.EnrollmentModel;
import com.servinglynk.report.model.IncomeSourceModel;

public class Q19a1DataBeanMaker extends BaseBeanMaker {
	static BigInteger earnedIncomeTotal = BigInteger.ZERO;
	static BigInteger otherIncomeTotal = BigInteger.ZERO;
	static BigInteger overallIncomeTotal = BigInteger.ZERO;
	public static List<Q19a1ClientCashIncomeChangeIncomeSourceEntryDataBean> getQ19a1ClientCashIncomeChangeIncomeSourceEntryDataBeanList(ReportData data){
	
		Q19a1ClientCashIncomeChangeIncomeSourceEntryDataBean q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate = new Q19a1ClientCashIncomeChangeIncomeSourceEntryDataBean();
		if(data.isLiveMode()) {
			try {
				List<EnrollmentModel> adultStayers = data.getAdultStayers();
				String query = "select  alimonyamount,childsupportamount,earnedamount,gaamount,othersourceamount,pensionamount,privatedisabilityamount, "+
						" socsecretirementamount,ssiamount,tanfamount,totalmonthlyincome,unemploymentamount,vadisabilitynonserviceamount, "+
						" vadisabilityserviceamount,workerscompamount,incomefromanysource,e.dedup_client_id as incomefromanysource,datacollectionstage from %s.incomeandsources i, %s.enrollment e,%s.project p  where    e.id=i.enrollmentid ";
				
				if(CollectionUtils.isNotEmpty(adultStayers)) {
					StringBuilder builder = new StringBuilder(" and e.id in (");
					for(EnrollmentModel model : adultStayers){
						if(StringUtils.isNotBlank(model.getProjectEntryID())) {
							builder.append("'");
							builder.append(model.getProjectEntryID());
							builder.append("'");
							builder.append(",");
						}
					}
					builder.deleteCharAt(builder.length()-1);
					builder.append(" ) " );
					
					List<IncomeSourceModel> incomes = getIncome(data.getSchema(), query+builder.toString(), data);
					if(CollectionUtils.isNotEmpty(incomes)){
						Set<String> allClients = new HashSet<>();
						incomes.forEach(incomeAndSource -> allClients.add(incomeAndSource.getDedupClientId()) );
						BigInteger allClientsBigInt = BigInteger.valueOf(getSize(allClients));
						
						populateEarnedIncome(q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate, incomes, allClientsBigInt);
						populateOtherIncome(q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate, incomes, allClientsBigInt);
						populateOverallIncomeIncome(q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate, incomes, allClientsBigInt);
			
					}
				}
			}catch(Exception e) {
		logger.error("Error in Q19a1DataBeanMaker:" + e);
			}
		}
		return Arrays.asList(q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate);
		
	}
	
	public static List<IncomeSourceModel> getIncome(String schema,String query,ReportData data) {
		List<IncomeSourceModel> incomes = new ArrayList<>();
		ResultSet resultSet = null;
		Statement statement = null;
		Connection connection = null;
		try {
			connection = ImpalaConnection.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(formatQuery(getQueryForProjectDB(data, query),schema,data));
			
		 while(resultSet.next()) {
			 int totalIncome = getFloatValue(resultSet,1)+getFloatValue(resultSet,2)+getFloatValue(resultSet,3)+getFloatValue(resultSet,4)+getFloatValue(resultSet,5)+getFloatValue(resultSet,6)+getFloatValue(resultSet,7)+
			 getFloatValue(resultSet,8)+getFloatValue(resultSet,9)+getFloatValue(resultSet,10)+getFloatValue(resultSet,11)+getFloatValue(resultSet,12)+getFloatValue(resultSet,13)+getFloatValue(resultSet,14)+getFloatValue(resultSet,15);
			 BigInteger totIncome = new BigInteger(String.valueOf(totalIncome));
			 int earned = getFloatValue(resultSet,3);
			 String earnedIncome = String.valueOf(earned);
			 BigInteger earnedIncomeBigInt = new BigInteger(earnedIncome);
			 String dedupClientId = (String) resultSet.getObject(17);
			 BigInteger otherIncome = BigInteger.ZERO;
			 if( totIncome != null &&  totIncome.longValue() > 0 ) {
				 otherIncome = totIncome.subtract(earnedIncomeBigInt != null  && earnedIncomeBigInt.longValue() > 0 ? earnedIncomeBigInt : BigInteger.ZERO);
			 }
			 String incomefromanysource = (String) resultSet.getString("incomefromanysource");
			 String dataCollectionStage = (String) resultSet.getString("datacollectionstage");
			 IncomeSourceModel model = new IncomeSourceModel(totIncome, earnedIncomeBigInt, otherIncome, dedupClientId,incomefromanysource);
			 model.setDataCollectionStage(dataCollectionStage);
			 incomes.add(model);
		 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
					//connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return incomes;
	}

	public static void populateEarnedIncome(Q19a1ClientCashIncomeChangeIncomeSourceEntryDataBean q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate, List<IncomeSourceModel> incomes,BigInteger allClientsBigInt) {
		List<IncomeSourceModel> earnedIncomeAtEntry = incomes.parallelStream().filter(income -> StringUtils.equals("1",income.getDataCollectionStage()) && income.getEarnedIncome() != null && income.getEarnedIncome().floatValue() >0).collect(Collectors.toList());
		List<IncomeSourceModel> earnedIncomeATEntryButNotAtAA = incomes.parallelStream().filter(income -> StringUtils.equals("5",income.getDataCollectionStage()) && income.getEarnedIncome() != null && income.getEarnedIncome().floatValue() >0).collect(Collectors.toList());
		
		Map<String,BigInteger>  earnedIncomeMapAtEntry = new HashMap<>();
		earnedIncomeAtEntry.forEach(incomeAndSource ->  {earnedIncomeMapAtEntry.put(incomeAndSource.getDedupClientId(), incomeAndSource.getEarnedIncome()); earnedIncomeTotal.add(incomeAndSource.getEarnedIncome()); } );
		
		Map<String,BigInteger>  earnedIncomeMapAtAA = new HashMap<>();
		earnedIncomeATEntryButNotAtAA.forEach(incomeAndSource -> { earnedIncomeMapAtAA.put(incomeAndSource.getDedupClientId(), incomeAndSource.getEarnedIncome()); });
		
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
		q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1NoOfAdltsWithEarnedIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup(BigInteger.valueOf(earnedIncomeAtStartWithOutAA));
		if(CollectionUtils.isNotEmpty(earnedIncomeAtEntry)) {
			BigInteger average = earnedIncomeTotal.divide(BigInteger.valueOf(earnedIncomeAtEntry.size()));
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
			if(earnedAmountAtEntry == null && earnedAmountAtAA !=null) {
				noOfAdultsDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome ++;
				sumadultsDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome.add(earnedAmountAtAA);
			}
		}
		List<IncomeSourceModel> didNotHaveEarnedIncomeAtEntry = incomes.parallelStream().filter(income -> StringUtils.equals("1",income.getDataCollectionStage()) && income.getEarnedIncome() == null || income.getEarnedIncome().floatValue() ==0).collect(Collectors.toList());
		List<IncomeSourceModel> didNotHaveEarnedIncomeATEntryButNotAtAA = incomes.parallelStream().filter(income -> StringUtils.equals("5",income.getDataCollectionStage()) && income.getEarnedIncome() == null || income.getEarnedIncome().floatValue() ==0).collect(Collectors.toList());
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
	public static void populateOtherIncome(Q19a1ClientCashIncomeChangeIncomeSourceEntryDataBean q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate, List<IncomeSourceModel> incomes,BigInteger allClientsBigInt) {
		
		List<IncomeSourceModel> otherIncomeAtEntry = incomes.parallelStream().filter(income -> StringUtils.equals("1",income.getDataCollectionStage()) && income.getOtherIncome() != null && income.getOtherIncome().floatValue() >0).collect(Collectors.toList());
		List<IncomeSourceModel> otherIncomeATEntryButNotAtAA = incomes.parallelStream().filter(income -> StringUtils.equals("5",income.getDataCollectionStage()) && income.getOtherIncome() != null && income.getOtherIncome().floatValue() >0).collect(Collectors.toList());
		
		Map<String,BigInteger>  otherIncomeMapAtEntry = new HashMap<>();
		otherIncomeAtEntry.forEach(incomeAndSource ->  {otherIncomeMapAtEntry.put(incomeAndSource.getDedupClientId(), incomeAndSource.getOtherIncome()); otherIncomeTotal.add(incomeAndSource.getOtherIncome()); } );
		
		Map<String,BigInteger>  otherIncomeMapAtAA = new HashMap<>();
		otherIncomeATEntryButNotAtAA.forEach(incomeAndSource -> { otherIncomeMapAtAA.put(incomeAndSource.getDedupClientId(), incomeAndSource.getOtherIncome()); });
		
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
		q19a1ClientCashIncomeChangeIncomeSourceEntryTableDate.setQ19a1AverageChangeInOtherIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup(BigInteger.valueOf(otherIncomeAtStartWithOutAA));
		if(CollectionUtils.isNotEmpty(otherIncomeAtEntry)) {
			BigInteger average = otherIncomeTotal.divide(BigInteger.valueOf(otherIncomeAtEntry.size()));
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
			if(otherAmountAtEntry == null && otherAmountAtAA !=null) {
				noOfAdultsDidNotHaveTheOtherIncomeCategoryAtEntryAndGainedTheIncome ++;
				sumadultsDidNotHaveOtherIncomeCategoryAtEntryAndGainedTheIncome.add(otherAmountAtAA);
			}
		}
		List<IncomeSourceModel> didNotHaveOtherIncomeAtEntry = incomes.parallelStream().filter(income -> StringUtils.equals("1",income.getDataCollectionStage()) && income.getOtherIncome() == null || income.getOtherIncome().floatValue() ==0).collect(Collectors.toList());
		List<IncomeSourceModel> didNotHaveOtherIncomeATEntryButNotAtAA = incomes.parallelStream().filter(income -> StringUtils.equals("5",income.getDataCollectionStage()) && income.getOtherIncome() == null || income.getOtherIncome().floatValue() ==0).collect(Collectors.toList());
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
	
public static void populateOverallIncomeIncome(Q19a1ClientCashIncomeChangeIncomeSourceEntryDataBean q19a1Bean, List<IncomeSourceModel> incomes,BigInteger allClientsBigInt) {
		
		List<IncomeSourceModel> otherIncomeAtEntry = incomes.parallelStream().filter(income -> StringUtils.equals("1",income.getDataCollectionStage()) && income.getIncomeAmount() != null && income.getIncomeAmount().floatValue() >0).collect(Collectors.toList());
		List<IncomeSourceModel> otherIncomeATEntryButNotAtAA = incomes.parallelStream().filter(income -> StringUtils.equals("5",income.getDataCollectionStage()) && income.getIncomeAmount() != null && income.getIncomeAmount().floatValue() >0).collect(Collectors.toList());
		
		Map<String,BigInteger>  otherIncomeMapAtEntry = new HashMap<>();
		otherIncomeAtEntry.forEach(incomeAndSource ->  {otherIncomeMapAtEntry.put(incomeAndSource.getDedupClientId(), incomeAndSource.getOtherIncome()); overallIncomeTotal.add(incomeAndSource.getIncomeAmount()); } );
		
		Map<String,BigInteger>  otherIncomeMapAtAA = new HashMap<>();
		otherIncomeATEntryButNotAtAA.forEach(incomeAndSource -> { otherIncomeMapAtAA.put(incomeAndSource.getDedupClientId(), incomeAndSource.getOtherIncome()); });
		
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
		q19a1Bean.setQ19a1NumberOfAdultsWithAnyIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup(BigInteger.valueOf(otherIncomeAtStartWithOutAA));
		if(CollectionUtils.isNotEmpty(otherIncomeAtEntry)) {
			BigInteger average = overallIncomeTotal.divide(BigInteger.valueOf(otherIncomeAtEntry.size()));
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
			if(otherAmountAtEntry == null && otherAmountAtAA !=null) {
				noOfAdultsDidNotHaveTheOtherIncomeCategoryAtEntryAndGainedTheIncome ++;
				sumadultsDidNotHaveOtherIncomeCategoryAtEntryAndGainedTheIncome.add(otherAmountAtAA);
			}
		}
		List<IncomeSourceModel> didNotHaveOtherIncomeAtEntry = incomes.parallelStream().filter(income -> StringUtils.equals("1",income.getDataCollectionStage()) && income.getOtherIncome() == null || income.getOtherIncome().floatValue() ==0).collect(Collectors.toList());
		List<IncomeSourceModel> didNotHaveOtherIncomeATEntryButNotAtAA = incomes.parallelStream().filter(income -> StringUtils.equals("5",income.getDataCollectionStage()) && income.getOtherIncome() == null || income.getOtherIncome().floatValue() ==0).collect(Collectors.toList());
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
