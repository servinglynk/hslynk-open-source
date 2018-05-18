package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.servinglynk.report.bean.Q06cDataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.ExitModel;
import com.servinglynk.report.model.IncomeAndSourceModel;

public class Q06cBeanMaker {

	public static Long destinationErroCount=0L;
	public static Long iseErrorCount=0L;
	public static Long isaaErrorCount=0L;
	public static Long isaeErrorCount=0L;
	
	public static List<Q06cDataBean> getQ06cPointInTimeCountPersonsLastWednesdayList(ReportData data){
		
		Q06cDataBean q06cDataBean =new Q06cDataBean();
		List<ExitModel> exits = data.getExits();
		exits.parallelStream().forEach(exit -> {
			
			if(StringUtils.equals("8", exit.getDestination()) || StringUtils.equals("9", exit.getDestination()) || StringUtils.equals("30", exit.getDestination())
					|| StringUtils.equals("99", exit.getDestination())
					) {
				destinationErroCount++;
			}
		}
		);
		List<IncomeAndSourceModel> incomeAndSources = data.getIncomeAndSources();
		incomeAndSources.parallelStream().forEach(incomeAndSource -> { 
			
			if(StringUtils.equals("1", incomeAndSource.getDataCollectionStage()) ) {
				iseErrorCount++;
			}
		}
		);
		incomeAndSources.parallelStream().forEach(incomeAndSource -> { 
			
			if(StringUtils.equals("3", incomeAndSource.getDataCollectionStage()) ) {
				isaeErrorCount++;
			}
		}
		);
		incomeAndSources.parallelStream().forEach(incomeAndSource -> { 
			
			if(StringUtils.equals("5", incomeAndSource.getDataCollectionStage()) ) {
				isaaErrorCount++;
			}
		}
		);
		q06cDataBean.setDestinationStatusErrorCount(BigInteger.valueOf(destinationErroCount));
		q06cDataBean.setDestinationStatusErrorRate(BigInteger.valueOf(destinationErroCount/exits.size() ));
		q06cDataBean.setIseErrorCount(BigInteger.valueOf(iseErrorCount));
		if(data.getNoOfAdultHeadsOfHousehold() !=null && data.getNoOfChildHeadsOfHousehold()!=null)
			q06cDataBean.setIseErrorRate(BigInteger.valueOf(iseErrorCount/(data.getNoOfAdultHeadsOfHousehold().intValue()+data.getNoOfChildHeadsOfHousehold().intValue())));
		q06cDataBean.setIsaaErrorCount(BigInteger.valueOf(isaaErrorCount));
		if(data.getNumOfHeadsOfHHandAdults365Days() !=null && data.getNumOfHeadsOfHHandAdults365Days().intValue() != 0)
			q06cDataBean.setIsaaErrorRate(BigInteger.valueOf(isaaErrorCount/data.getNumOfHeadsOfHHandAdults365Days().intValue()));
		q06cDataBean.setIsaeErrorCount(BigInteger.valueOf(isaeErrorCount));
		if(data.getTotNoOfAdultLeavers() !=null && data.getTotNoOfAdultLeavers().intValue() !=0)
			q06cDataBean.setIsaeErrorRate(BigInteger.valueOf(data.getTotNoOfAdultLeavers().intValue()));
		
		return Arrays.asList(q06cDataBean);
	}
	
}