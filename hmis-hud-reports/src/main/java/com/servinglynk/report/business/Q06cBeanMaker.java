package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import com.servinglynk.hive.connection.ReportQuery;
import com.servinglynk.report.bean.Q06cPointInTimeCountPersonsLastWednesdayDataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.DataCollectionStage;
import com.servinglynk.report.model.ExitModel;
import com.servinglynk.report.model.IncomeAndSourceModel;

public class Q06cBeanMaker extends BaseBeanMaker {

	public static Long destinationErroCount = 0L;
	
	

	public static List<Q06cPointInTimeCountPersonsLastWednesdayDataBean> getQ06cPointInTimeCountPersonsLastWednesdayList(ReportData data) {
		
		Q06cPointInTimeCountPersonsLastWednesdayDataBean q06cDataBean = new Q06cPointInTimeCountPersonsLastWednesdayDataBean();
		
		if(data.isLiveMode()) {
		try {
			List<IncomeAndSourceModel> entryIncomeAndSource = getIncomeAndSource(data,ReportQuery.ENTRY_INCOME_AND_SOURCE_QUERY,DataCollectionStage.ENTRY);
			data.setIncomeAndSourcesAtEntry(entryIncomeAndSource);
			List<IncomeAndSourceModel> filterIncomeAndSourceAtEntryFor6c = filterIncomeAndSourceFor6c(entryIncomeAndSource);
			
			List<IncomeAndSourceModel> exitIncomeAndSource = getIncomeAndSource(data,ReportQuery.EXIT_INCOME_AND_SOURCE_QUERY,DataCollectionStage.EXIT);
			data.setIncomeAndSourcesAtExit(exitIncomeAndSource);
			List<IncomeAndSourceModel> filterIncomeAndSourceAtExitFor6c = filterIncomeAndSourceFor6c(exitIncomeAndSource);
			
			List<IncomeAndSourceModel> annualAssesmentIcomeAndSource = getIncomeAndSource(data,ReportQuery.REQUIRED_ANNUAL_ASSESMENT_QUERY,DataCollectionStage.ANNUAL_ASSESMENT);
			List<IncomeAndSourceModel> annualAssesmentIncomeAndSource  = annualAssesmentIcomeAndSource.parallelStream().filter(incomeAndSource -> isWithIn30DaysOfAnniversary(incomeAndSource.getEntryExitDate(),incomeAndSource.getInformationDate())).collect(Collectors.toList());
			data.setIncomeAndSourcesAtAnnualAssesment(annualAssesmentIncomeAndSource);
			List<IncomeAndSourceModel> filterIncomeAndSourceAtAAFor6c = filterIncomeAndSourceFor6c(annualAssesmentIncomeAndSource);
			
			
			List<ExitModel> exits = data.getExits();
			exits.forEach(exit -> {
				if (StringUtils.equals("8", exit.getDestination()) || StringUtils.equals("9", exit.getDestination())
						|| StringUtils.equals("99", exit.getDestination()) || StringUtils.equals("30", exit.getDestination()) || exit.getDestination() == null) {
					destinationErroCount++;
				}
			});
			
			
			q06cDataBean.setDestinationStatusErrorCount(BigInteger.valueOf(destinationErroCount));
			int exitCount = exits.size();
			if(exitCount !=0)
				q06cDataBean.setDestinationStatusErrorRate(BigInteger.valueOf(destinationErroCount / exitCount));
			
			int filterIncomeAndSourceAtEntryFor6cSize = getSize(filterIncomeAndSourceAtEntryFor6c);
			q06cDataBean.setIseErrorCount(BigInteger.valueOf(filterIncomeAndSourceAtEntryFor6cSize));
			
			if (data.getNoOfAdultHeadsOfHousehold() != null && data.getNoOfChildHeadsOfHousehold() != null && filterIncomeAndSourceAtEntryFor6cSize !=0) {
				q06cDataBean.setIseErrorRate(
						BigInteger.valueOf(filterIncomeAndSourceAtEntryFor6cSize / (data.getNoOfAdultHeadsOfHousehold().intValue()
								+ data.getNoOfChildHeadsOfHousehold().intValue())));
		    }
			int filterIncomeAndSourceAtAAFor6cSize = getSize(filterIncomeAndSourceAtAAFor6c);
			q06cDataBean.setIsaaErrorCount(BigInteger.valueOf(filterIncomeAndSourceAtAAFor6cSize));
			if (data.getNumOfHeadsOfHHandAdults365Days() != null
					&& data.getNumOfHeadsOfHHandAdults365Days().intValue() != 0)
				if(data.getNumOfHeadsOfHHandAdults365Days() != null && filterIncomeAndSourceAtAAFor6cSize !=0) {
					q06cDataBean.setIsaaErrorRate(
							BigInteger.valueOf(filterIncomeAndSourceAtAAFor6cSize / data.getNumOfHeadsOfHHandAdults365Days().intValue()));
				}
			
			int filterIncomeAndSourceAtExitFor6cSize = getSize(filterIncomeAndSourceAtExitFor6c);
			q06cDataBean.setIsaeErrorCount(BigInteger.valueOf(filterIncomeAndSourceAtExitFor6cSize));
			if (data.getTotNoOfAdultLeavers() != null && data.getTotNoOfAdultLeavers().intValue() != 0 && filterIncomeAndSourceAtExitFor6cSize !=0)
				q06cDataBean.setIsaeErrorRate(BigInteger.valueOf((filterIncomeAndSourceAtExitFor6cSize/data.getTotNoOfAdultLeavers().intValue())));
		} catch (Exception e) {
			logger.error("Error in Q06bBeanMaker:" + e);
		}
		}
		return Arrays.asList(q06cDataBean);
	}
	
 public static List<IncomeAndSourceModel> filterIncomeAndSourceFor6c(List<IncomeAndSourceModel> incomeAndSources) {
	  List<IncomeAndSourceModel> filterMissingIncomeAndSource = filterMissingIncomeAndSource(incomeAndSources);
	  List<IncomeAndSourceModel> filterIdentifiedSource = filterIdentifiedSource(filterMissingIncomeAndSource);
	  return filterUnIdentifiedSource(filterIdentifiedSource);
 }
 
 public static void main(String args[]) {
	 System.out.println("Betwen date "+isWithIn30DaysOfAnniversary(new java.sql.Date(2018, 02, 15), new java.sql.Date(2020, 03, 10)));
 }
	
}