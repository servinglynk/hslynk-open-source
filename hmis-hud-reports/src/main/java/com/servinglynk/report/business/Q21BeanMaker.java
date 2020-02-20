package com.servinglynk.report.business;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.servinglynk.hive.connection.ImpalaConnection;
import com.servinglynk.report.bean.Q21HealthInsuranceDataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.DataCollectionStage;
import com.servinglynk.report.model.HealthInsuranceModel;

public class Q21BeanMaker extends BaseBeanMaker {

	public static List<Q21HealthInsuranceDataBean> getQ21HealthInsuranceList(ReportData data){
		
		Q21HealthInsuranceDataBean q21HealthInsuranceDataBeanTable = new Q21HealthInsuranceDataBean();
		String entryQuery = " select  i.insurancefromanysource as insurancefromanysource,i.medicaid as medicaid,i.medicare as medicare, i.statehealthinadults as statehealthinadults,"+
				  "i.vamedicalservices as vamedicalservices,i.employerprovided as employerprovided, i.privatepay as privatepay,i.schip as schip,i.indianhealthservices as indianhealthservices, "+
				   "i.other_insurance as otherinsurance, e.dedup_client_id  as dedup_client_id from %s.healthinsurance i, %s.enrollment e where e.id=i.enrollmentid  "+
				  "  and TO_DATE(i.information_date) = TO_DATE(e.entrydate) and i.information_date <= :endDate  %dedup"+
				  " and e.ageatentry >=18  and i.datacollectionstage = '1'  order by e.dedup_client_id,i.information_date asc ";
			       
			String  exitQuery = " select  i.insurancefromanysource as insurancefromanysource , i.medicaid as medicaid,i.medicare as medicare, i.statehealthinadults as statehealthinadults,"+
				  "i.vamedicalservices as vamedicalservices,i.employerprovided as employerprovided, i.privatepay as privatepay,i.schip as schip,i.indianhealthservices as indianhealthservices, "+
				   "i.other_insurance as otherinsurance, e.dedup_client_id  as dedup_client_id from %s.healthinsurance i, %s.enrollment e,%s.exit ext where e.id=i.enrollmentid  "+
				  " and e.id = ext.enrollmentid "+
					  "  and TO_DATE(i.information_date) = TO_DATE(ext.exitdate) and i.information_date <= :endDate  %dedup"+
					  " and e.ageatentry >=18  and i.datacollectionstage = '3'  order by e.dedup_client_id,i.information_date asc ";
				       
			String  stayersQuery = " select  i.insurancefromanysource as insurancefromanysource , i.medicaid as medicaid,i.medicare as medicare, i.statehealthinadults as statehealthinadults,"+
					  "i.vamedicalservices as vamedicalservices,i.employerprovided as employerprovided, i.privatepay as privatepay,i.schip as schip,i.indianhealthservices as indianhealthservices, "+
					   "i.other_insurance as otherinsurance, e.dedup_client_id  as dedup_client_id  from %s.healthinsurance i, %s.enrollment e where e.id=i.enrollmentid  "+
						" and  i.information_date <= :endDate and e.ageatentry >= 18  %dedup "+
						" and   e.id not in ( select enrollmentid from %s.enrollment_coc where datacollectionstage='5' and datediff(now(),information_date) > 365 )  order by e.dedup_client_id,i.information_date asc ";  
				
			try {
				if(data.isLiveMode()) {
					List<HealthInsuranceModel> entryHealthInsurances = getHealthInsuranceModel(data, entryQuery, DataCollectionStage.ENTRY.getCode());
					List<HealthInsuranceModel> stayersHealthInsurances = getHealthInsuranceModel(data, stayersQuery, DataCollectionStage.ANNUAL_ASSESMENT.getCode());
					List<HealthInsuranceModel> exitHealthInsurances = getHealthInsuranceModel(data, exitQuery, DataCollectionStage.EXIT.getCode());
					
					List<String> noHealthInsuranceList = Arrays.asList(new String[] { "0", "1"});
					List<String> cdkInsuranceList = Arrays.asList(new String[] { "8", "9"});
					List<String> dataNotCollectedInsuranceList = Arrays.asList(new String[] { "99"});
//					List<HealthInsuranceModel> exitHealthInsurances = new ArrayList<>();
//					if(CollectionUtils.isNotEmpty(data.getLeavers())) {
//						List<HealthInsuranceModel> exitHealthInsurancesUnfiltered = getHealthInsuranceModel(data, exitQuery, DataCollectionStage.EXIT.getCode());
//						exitHealthInsurances = getDedupedItemsForHealth(exitHealthInsurancesUnfiltered);
//					}
//				
//					List<HealthInsuranceModel> entryHealthInsurances = getDedupedItemsForHealth(entryHealthInsurancesUnfiltered);
//					List<HealthInsuranceModel> stayersHealthInsurances = getDedupedItemsForHealth(stayersHealthInsurancesUnfiltered);
//					
					if(CollectionUtils.isNotEmpty(entryHealthInsurances)) {
						List<HealthInsuranceModel> medicaidHealthInsurance = entryHealthInsurances.parallelStream().filter(healthInsurance -> isPositive(healthInsurance.getMedicaid()) ).collect(Collectors.toList());
						List<HealthInsuranceModel> medicareHealthInsurance = entryHealthInsurances.parallelStream().filter(healthInsurance -> isPositive(healthInsurance.getMedicare()) ).collect(Collectors.toList());
						List<HealthInsuranceModel> stateChildHealthInsurance = entryHealthInsurances.parallelStream().filter(healthInsurance -> isPositive(healthInsurance.getStatehealthinadults()) ).collect(Collectors.toList());
						List<HealthInsuranceModel> medicalServices = entryHealthInsurances.parallelStream().filter(healthInsurance -> isPositive(healthInsurance.getVamedicalservices()) ).collect(Collectors.toList());
						List<HealthInsuranceModel> employerProvidedHealthInsurance = entryHealthInsurances.parallelStream().filter(healthInsurance -> isPositive(healthInsurance.getEmployerprovided()) ).collect(Collectors.toList());
						List<HealthInsuranceModel> healthInsuranceThroughCobra = entryHealthInsurances.parallelStream().filter(healthInsurance -> isPositive(healthInsurance.getInsurancefromanysource()) ).collect(Collectors.toList());
						List<HealthInsuranceModel> privatePayHealthInsurance = entryHealthInsurances.parallelStream().filter(healthInsurance -> isPositive(healthInsurance.getPrivatepay()) ).collect(Collectors.toList());
						List<HealthInsuranceModel> stateHealthInsuranceForAdults = entryHealthInsurances.parallelStream().filter(healthInsurance -> isPositive(healthInsurance.getStatehealthinadults()) ).collect(Collectors.toList());
						List<HealthInsuranceModel> indianHealthServicesProgram = entryHealthInsurances.parallelStream().filter(healthInsurance -> isPositive(healthInsurance.getIndianhealthservices()) ).collect(Collectors.toList());
						List<HealthInsuranceModel> other = entryHealthInsurances.parallelStream().filter(healthInsurance -> isPositive(healthInsurance.getOtherinsurance()) ).collect(Collectors.toList());
						
						q21HealthInsuranceDataBeanTable.setQ21AMedicaidHealthInsuranceAtEntry(BigInteger.valueOf(medicaidHealthInsurance != null ? medicaidHealthInsurance.size() : 0));
						q21HealthInsuranceDataBeanTable.setQ21BMedicaidHealthInsuranceAtEntry(BigInteger.valueOf(medicareHealthInsurance != null ? medicareHealthInsurance.size() :0));
						q21HealthInsuranceDataBeanTable.setQ21CStateChildHealthInsuranceAtEntry(BigInteger.valueOf(stateChildHealthInsurance != null ? stateChildHealthInsurance.size() :0));
						q21HealthInsuranceDataBeanTable.setQ21DVAMedicalServicesAtEntry(BigInteger.valueOf(medicalServices != null ? medicalServices.size() :0));
						q21HealthInsuranceDataBeanTable.setQ21EEmployerProvidedHealthInsuranceAtEntry(BigInteger.valueOf(employerProvidedHealthInsurance != null ? employerProvidedHealthInsurance.size() :0));
						q21HealthInsuranceDataBeanTable.setQ21FHealthInsuranceThroughCobraAtEntry(BigInteger.valueOf(healthInsuranceThroughCobra != null ? healthInsuranceThroughCobra.size() :0));
						q21HealthInsuranceDataBeanTable.setQ21GPrivatePayHealthInsuranceAtEntry(BigInteger.valueOf(privatePayHealthInsurance != null ?privatePayHealthInsurance.size() :0));
						q21HealthInsuranceDataBeanTable.setQ21HStateHealthInsuranceForAdultsAtEntry(BigInteger.valueOf(stateHealthInsuranceForAdults != null ? stateHealthInsuranceForAdults.size() :0));
						q21HealthInsuranceDataBeanTable.setQ21IIndianHealthServicesProgramAtEntry(BigInteger.valueOf(indianHealthServicesProgram != null ? indianHealthServicesProgram.size() :0));
						q21HealthInsuranceDataBeanTable.setQ21JOtherAtEntry(BigInteger.valueOf(other != null ? other.size() :0));
						
						q21HealthInsuranceDataBeanTable.setQ21KNoHealthInsuranceAtEntry(BigInteger.valueOf(getHealthInsuranceBySourceType(entryHealthInsurances, noHealthInsuranceList)));
						q21HealthInsuranceDataBeanTable.setQ21LClientRefusedAtEntry(BigInteger.valueOf(getHealthInsuranceBySourceType(entryHealthInsurances, cdkInsuranceList)));
						q21HealthInsuranceDataBeanTable.setQ21MDataNotCollectedAtEntry(BigInteger.valueOf(getHealthInsuranceBySourceType(entryHealthInsurances, dataNotCollectedInsuranceList)));
						q21HealthInsuranceDataBeanTable.setQ21NNoOfAdultStayersNotRequiredAtEntry(BigInteger.valueOf(0));
						
						q21HealthInsuranceDataBeanTable.setQ21O1SourceOfHealthInsuranceAtEntry(BigInteger.valueOf(getDedupWithIncomeWith1Count(entryHealthInsurances)));
						q21HealthInsuranceDataBeanTable.setQ21PMoreThan1SourceOfHealthInsuranceAtEntry(BigInteger.valueOf(getDedupWithIncomeWithMoreThan1Count(entryHealthInsurances)));
					}
					if(CollectionUtils.isNotEmpty(stayersHealthInsurances)) {
						List<HealthInsuranceModel> medicaidHealthInsurance = stayersHealthInsurances.parallelStream().filter(healthInsurance -> isPositive(healthInsurance.getMedicaid()) ).collect(Collectors.toList());
						List<HealthInsuranceModel> medicareHealthInsurance = stayersHealthInsurances.parallelStream().filter(healthInsurance -> isPositive(healthInsurance.getMedicare()) ).collect(Collectors.toList());
						List<HealthInsuranceModel> stateChildHealthInsurance = stayersHealthInsurances.parallelStream().filter(healthInsurance -> isPositive(healthInsurance.getStatehealthinadults()) ).collect(Collectors.toList());
						List<HealthInsuranceModel> medicalServices = stayersHealthInsurances.parallelStream().filter(healthInsurance -> isPositive(healthInsurance.getVamedicalservices()) ).collect(Collectors.toList());
						List<HealthInsuranceModel> employerProvidedHealthInsurance = stayersHealthInsurances.parallelStream().filter(healthInsurance -> isPositive(healthInsurance.getEmployerprovided()) ).collect(Collectors.toList());
						List<HealthInsuranceModel> healthInsuranceThroughCobra = stayersHealthInsurances.parallelStream().filter(healthInsurance -> isPositive(healthInsurance.getInsurancefromanysource()) ).collect(Collectors.toList());
						List<HealthInsuranceModel> privatePayHealthInsurance = stayersHealthInsurances.parallelStream().filter(healthInsurance -> isPositive(healthInsurance.getPrivatepay()) ).collect(Collectors.toList());
						List<HealthInsuranceModel> stateHealthInsuranceForAdults = stayersHealthInsurances.parallelStream().filter(healthInsurance -> isPositive(healthInsurance.getStatehealthinadults()) ).collect(Collectors.toList());
						List<HealthInsuranceModel> indianHealthServicesProgram = stayersHealthInsurances.parallelStream().filter(healthInsurance -> isPositive(healthInsurance.getIndianhealthservices()) ).collect(Collectors.toList());
						List<HealthInsuranceModel> other = stayersHealthInsurances.parallelStream().filter(healthInsurance -> isPositive(healthInsurance.getOtherinsurance()) ).collect(Collectors.toList());
					
						
						q21HealthInsuranceDataBeanTable.setQ21AMedicaidHealthInsuranceAtLatestStayers(BigInteger.valueOf(medicaidHealthInsurance != null ? medicaidHealthInsurance.size() : 0));
						q21HealthInsuranceDataBeanTable.setQ21BMedicaidHealthInsuranceAtLatestStayers(BigInteger.valueOf(medicareHealthInsurance != null ? medicareHealthInsurance.size() :0));
						q21HealthInsuranceDataBeanTable.setQ21CStateChildHealthInsuranceAtLatestStayers(BigInteger.valueOf(stateChildHealthInsurance != null ? stateChildHealthInsurance.size() :0));
						q21HealthInsuranceDataBeanTable.setQ21DVAMedicalServicesAtLatestStayers(BigInteger.valueOf(medicalServices != null ? medicalServices.size() :0));
						q21HealthInsuranceDataBeanTable.setQ21EEmployerProvidedHealthInsuranceAtLatestStayers(BigInteger.valueOf(employerProvidedHealthInsurance != null ? employerProvidedHealthInsurance.size() :0));
						q21HealthInsuranceDataBeanTable.setQ21FHealthInsuranceThroughCobraAtLatestStayers(BigInteger.valueOf(healthInsuranceThroughCobra != null ? healthInsuranceThroughCobra.size() :0));
						q21HealthInsuranceDataBeanTable.setQ21GPrivatePayHealthInsuranceAtLatestStayers(BigInteger.valueOf(privatePayHealthInsurance != null ?privatePayHealthInsurance.size() :0));
						q21HealthInsuranceDataBeanTable.setQ21HStateHealthInsuranceForAdultsAtLatestStayers(BigInteger.valueOf(stateHealthInsuranceForAdults != null ? stateHealthInsuranceForAdults.size() :0));
						q21HealthInsuranceDataBeanTable.setQ21IIndianHealthServicesProgramAtLatestStayers(BigInteger.valueOf(indianHealthServicesProgram != null ? indianHealthServicesProgram.size() :0));
						q21HealthInsuranceDataBeanTable.setQ21JOtherAtLatestStayers(BigInteger.valueOf(other != null ? other.size() :0));
						
						q21HealthInsuranceDataBeanTable.setQ21KNoHealthInsuranceAtLatestStayers(BigInteger.valueOf(getHealthInsuranceBySourceType(stayersHealthInsurances, noHealthInsuranceList)));
						q21HealthInsuranceDataBeanTable.setQ21LClientRefusedAtLatestStayers(BigInteger.valueOf(getHealthInsuranceBySourceType(stayersHealthInsurances, cdkInsuranceList)));
						q21HealthInsuranceDataBeanTable.setQ21MDataNotCollectedAtLatestStayers(BigInteger.valueOf(getHealthInsuranceBySourceType(stayersHealthInsurances, dataNotCollectedInsuranceList)));
						q21HealthInsuranceDataBeanTable.setQ21NNoOfAdultStayersNotRequiredAtLatestStayers(data.getNumOfAdultStayersNotRequiredAnnualAssesment());
						
						q21HealthInsuranceDataBeanTable.setQ21O1SourceOfHealthInsuranceAtLatestStayers(BigInteger.valueOf(getDedupWithIncomeWith1Count(stayersHealthInsurances)));
						q21HealthInsuranceDataBeanTable.setQ21PMoreThan1SourceOfHealthInsuranceAtLatestStayers(BigInteger.valueOf(getDedupWithIncomeWithMoreThan1Count(stayersHealthInsurances)));
						
					}
					
					if(CollectionUtils.isNotEmpty(exitHealthInsurances)) {
						List<HealthInsuranceModel> medicaidHealthInsurance = exitHealthInsurances.parallelStream().filter(healthInsurance -> isPositive(healthInsurance.getMedicaid()) ).collect(Collectors.toList());
						List<HealthInsuranceModel> medicareHealthInsurance = exitHealthInsurances.parallelStream().filter(healthInsurance -> isPositive(healthInsurance.getMedicare()) ).collect(Collectors.toList());
						List<HealthInsuranceModel> stateChildHealthInsurance = exitHealthInsurances.parallelStream().filter(healthInsurance -> isPositive(healthInsurance.getStatehealthinadults()) ).collect(Collectors.toList());
						List<HealthInsuranceModel> medicalServices = exitHealthInsurances.parallelStream().filter(healthInsurance -> isPositive(healthInsurance.getVamedicalservices()) ).collect(Collectors.toList());
						List<HealthInsuranceModel> employerProvidedHealthInsurance = exitHealthInsurances.parallelStream().filter(healthInsurance -> isPositive(healthInsurance.getEmployerprovided()) ).collect(Collectors.toList());
						List<HealthInsuranceModel> healthInsuranceThroughCobra = exitHealthInsurances.parallelStream().filter(healthInsurance -> isPositive(healthInsurance.getInsurancefromanysource()) ).collect(Collectors.toList());
						List<HealthInsuranceModel> privatePayHealthInsurance = exitHealthInsurances.parallelStream().filter(healthInsurance -> isPositive(healthInsurance.getPrivatepay()) ).collect(Collectors.toList());
						List<HealthInsuranceModel> stateHealthInsuranceForAdults = exitHealthInsurances.parallelStream().filter(healthInsurance -> isPositive(healthInsurance.getStatehealthinadults()) ).collect(Collectors.toList());
						List<HealthInsuranceModel> indianHealthServicesProgram = exitHealthInsurances.parallelStream().filter(healthInsurance -> isPositive(healthInsurance.getIndianhealthservices()) ).collect(Collectors.toList());
						List<HealthInsuranceModel> other = exitHealthInsurances.parallelStream().filter(healthInsurance -> isPositive(healthInsurance.getOtherinsurance()) ).collect(Collectors.toList());
						
						
						q21HealthInsuranceDataBeanTable.setQ21AMedicaidHealthInsuranceAtExitLeavers(BigInteger.valueOf(medicaidHealthInsurance != null ? medicaidHealthInsurance.size() : 0));
						q21HealthInsuranceDataBeanTable.setQ21BMedicaidHealthInsuranceAtExitLeavers(BigInteger.valueOf(medicareHealthInsurance != null ? medicareHealthInsurance.size() :0));
						q21HealthInsuranceDataBeanTable.setQ21CStateChildHealthInsuranceAtExitLeavers(BigInteger.valueOf(stateChildHealthInsurance != null ? stateChildHealthInsurance.size() :0));
						q21HealthInsuranceDataBeanTable.setQ21DVAMedicalServicesAtExitLeavers(BigInteger.valueOf(medicalServices != null ? medicalServices.size() :0));
						q21HealthInsuranceDataBeanTable.setQ21EEmployerProvidedHealthInsuranceAtExitLeavers(BigInteger.valueOf(employerProvidedHealthInsurance != null ? employerProvidedHealthInsurance.size() :0));
						q21HealthInsuranceDataBeanTable.setQ21FHealthInsuranceThroughCobraAtExitLeavers(BigInteger.valueOf(healthInsuranceThroughCobra != null ? healthInsuranceThroughCobra.size() :0));
						q21HealthInsuranceDataBeanTable.setQ21GPrivatePayHealthInsuranceAtExitLeavers(BigInteger.valueOf(privatePayHealthInsurance != null ?privatePayHealthInsurance.size() :0));
						q21HealthInsuranceDataBeanTable.setQ21HStateHealthInsuranceForAdultsAtExitLeavers(BigInteger.valueOf(stateHealthInsuranceForAdults != null ? stateHealthInsuranceForAdults.size() :0));
						q21HealthInsuranceDataBeanTable.setQ21IIndianHealthServicesProgramAtExitLeavers(BigInteger.valueOf(indianHealthServicesProgram != null ? indianHealthServicesProgram.size() :0));
						q21HealthInsuranceDataBeanTable.setQ21JOtherAtExitLeavers(BigInteger.valueOf(other != null ? other.size() :0));
						
						q21HealthInsuranceDataBeanTable.setQ21KNoHealthInsuranceAtExitLeavers(BigInteger.valueOf(getHealthInsuranceBySourceType(exitHealthInsurances, noHealthInsuranceList)));
						q21HealthInsuranceDataBeanTable.setQ21LClientRefusedAtExitLeavers(BigInteger.valueOf(getHealthInsuranceBySourceType(exitHealthInsurances, cdkInsuranceList)));
						q21HealthInsuranceDataBeanTable.setQ21MDataNotCollectedAtExitLeavers(BigInteger.valueOf(getHealthInsuranceBySourceType(exitHealthInsurances, dataNotCollectedInsuranceList)));
						q21HealthInsuranceDataBeanTable.setQ21NNoOfAdultStayersNotRequiredAtExitLeavers(BigInteger.valueOf(0));
						
						q21HealthInsuranceDataBeanTable.setQ21O1SourceOfHealthInsuranceAtExitLeavers(BigInteger.valueOf(getDedupWithIncomeWith1Count(exitHealthInsurances)));
						q21HealthInsuranceDataBeanTable.setQ21PMoreThan1SourceOfHealthInsuranceAtExitLeavers(BigInteger.valueOf(getDedupWithIncomeWithMoreThan1Count(exitHealthInsurances)));
		
					}
				}
			}catch(Exception e) {
				logger.error("Error in Q21BeanMaker:" + e);
			}
			
		
		return Arrays.asList(q21HealthInsuranceDataBeanTable);
	}
	// Row 16
	public static int getDedupWithIncomeWith1Count(List<HealthInsuranceModel> incomes) {
		if(CollectionUtils.isNotEmpty(incomes)) {
			String[] method1 = new String[] { "0", "1"};
			List<String> method1List = Arrays.asList(method1);
			Map<String,Integer>  dedupMap = getDedupedItemsForHealth(incomes, method1List);
			 Map<String,Integer> result = dedupMap.entrySet()
				      .stream()
				      .filter(map -> (map.getValue() == 1))
				      .collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));
			 if(result != null) {
				 return getSize(result.keySet());
			 }
		}
		return 0;
	}
	// Row 17
	public static int getDedupWithIncomeWithMoreThan1Count(List<HealthInsuranceModel> incomes) {
		if(CollectionUtils.isNotEmpty(incomes)) {
			String[] method1 = new String[] { "0", "1"};
			List<String> method1List = Arrays.asList(method1);
			Map<String,Integer>  dedupMap = getDedupedItemsForHealth(incomes, method1List);
			 Map<String,Integer> result = dedupMap.entrySet()
				      .stream()
				      .filter(map ->  (map.getValue() > 1))
				      .collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));
			 if(result != null) {
				 return getSize(result.keySet());
			 }
		}
		return 0;
	}
	
	public static Map<String,Integer> getDedupedItemsForHealth(List<HealthInsuranceModel> incomes, List<String> containsList) {
		Map<String,Integer> incomeMap = new HashMap<>();
		for(HealthInsuranceModel income : incomes) {
			int count= 0;
				if(containsList.contains(income.getEmployerprovided())) {
					count++;
				}
				if(containsList.contains(income.getMedicare())) {
					count++;
				}
				if(containsList.contains(income.getMedicaid())) {
					count++;
				}
				if(containsList.contains(income.getIndianhealthservices())) {
					count++;
				}
				if(containsList.contains(income.getOtherinsurance()) ) {
					count++;
				}
				if(containsList.contains(income.getPrivatepay())) {
					count++;
				}
				if(containsList.contains(income.getSchip())) {
					count++;
				}
				if(containsList.contains(income.getStatehealthinadults())) {
					count++;
				}
				if(containsList.contains(income.getVamedicalservices())) {
					count++;
				}
			Integer totalCount = incomeMap.get(income.getDedupClientId());
			if(totalCount != null) {
				incomeMap.put(income.getDedupClientId(), totalCount + count);
			}else {
				incomeMap.put(income.getDedupClientId(), count);
			}
		}
		return incomeMap;	
	}
	// Row 12,13,14
	public static int getHealthInsuranceBySourceType(List<HealthInsuranceModel> incomes, List<String> containsList) {
		Map<String,Integer> incomeMap = new HashMap<>();
		for(HealthInsuranceModel income : incomes) {
			int count= 0;
			if(containsList.contains(income.getInsurancefromanysource()))  {
				if(StringUtils.isBlank(income.getEmployerprovided()) || StringUtils.equals("0", income.getEmployerprovided())) {
					count++;
				}
				if(StringUtils.isBlank(income.getMedicare()) || StringUtils.equals("0", income.getMedicare())) {
					count++;
				}
				if(containsList.contains(income.getMedicaid())) {
					count++;
				}
				if(StringUtils.isBlank(income.getIndianhealthservices()) || StringUtils.equals("0", income.getIndianhealthservices())) {
					count++;
				}
				if(StringUtils.isBlank(income.getOtherinsurance()) || StringUtils.equals("0", income.getOtherinsurance())) {
					count++;
				}
				if(StringUtils.isBlank(income.getPrivatepay()) || StringUtils.equals("0", income.getPrivatepay())) {
					count++;
				}
				if(StringUtils.isBlank(income.getSchip()) || StringUtils.equals("0", income.getSchip())) {
					count++;
				}
				if(StringUtils.isBlank(income.getStatehealthinadults()) || StringUtils.equals("0", income.getStatehealthinadults())) {
					count++;
				}
				if(StringUtils.isBlank(income.getVamedicalservices()) || StringUtils.equals("0", income.getVamedicalservices())) {
					count++;
				}
			}
			Integer totalCount = incomeMap.get(income.getDedupClientId());
			if(totalCount != null) {
				incomeMap.put(income.getDedupClientId(), totalCount + count);
			}else {
				incomeMap.put(income.getDedupClientId(), count);
			}
			
			Map<String,Integer> result = incomeMap.entrySet()
				      .stream()
				      .filter(map ->  (map.getValue() > 1))
				      .collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));
			 if(result != null) {
				 return getSize(result.keySet());
			 }
		}
		return incomeMap;	
	}
	
	
	
	/*
	public static List<HealthInsuranceModel> getDedupedItemsForHealth(List<HealthInsuranceModel> incomes) {
		Map<String,HealthInsuranceModel> dedupIncomeAndSourceAtEntry = new HashMap<>();
		incomes.forEach(income->   dedupIncomeAndSourceAtEntry.put(income.getDedupClientId(), income));
		Collection<HealthInsuranceModel> values = dedupIncomeAndSourceAtEntry.values();
		return new ArrayList(values);	
	}
	*/
	
	 public static List<HealthInsuranceModel> getHealthInsuranceModel(ReportData data,String query,String datacollectionStage) {
		 List<HealthInsuranceModel> healthInsuranceModels = new ArrayList<HealthInsuranceModel>();
			ResultSet resultSet = null;
			Statement statement = null;
			Connection connection = null;
			try {
				connection = ImpalaConnection.getConnection();
				statement = connection.createStatement();
				String newQuery = buildQueryFromDataCollectionStage(datacollectionStage, query, data);
				resultSet = statement.executeQuery(formatQuery(newQuery,data.getSchema(),data));
				
			 while(resultSet.next()) {
				 healthInsuranceModels.add(new HealthInsuranceModel(resultSet.getString("insurancefromanysource"), resultSet.getString("medicaid"), resultSet.getString("medicare"), 
						 resultSet.getString("statehealthinadults"), resultSet.getString("vamedicalservices"), resultSet.getString("employerprovided"), 
						 resultSet.getString("privatepay"), resultSet.getString("schip"), resultSet.getString("indianhealthservices"), resultSet.getString("otherinsurance"), resultSet.getString("dedup_client_id")));
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
			return healthInsuranceModels;
		}	
	 
	 
	 
	
}
