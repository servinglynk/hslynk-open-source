package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.servinglynk.report.bean.Q22bAverageAndMedianLengthOfParticipationInDaysDataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.Q22BeanModel;

public class Q22bAverageAndMedianLengthOfParticipationInDaysDataBeanMaker extends BaseBeanMaker {
	
	public static List<Q22bAverageAndMedianLengthOfParticipationInDaysDataBean> getQ22bAverageAndMedianLengthOfParticipationInDaysList(ReportData data){
		
		Q22bAverageAndMedianLengthOfParticipationInDaysDataBean q22bAverageAndMedianLengthOfParticipationInDaysTable =new Q22bAverageAndMedianLengthOfParticipationInDaysDataBean();
		try {
			if(data.isLiveMode()) {
				List<Q22BeanModel> leaversLengthofStay = data.getLeaversLengthofStay();
				if(CollectionUtils.isNotEmpty(leaversLengthofStay)) {
					long count =0;
					for(Q22BeanModel model : leaversLengthofStay) {
						count = count + model.getNumberOfDays();
					}
					q22bAverageAndMedianLengthOfParticipationInDaysTable.setQ22bAverageLengthInDaysLeavers(BigInteger.valueOf(count/leaversLengthofStay.size()));
					Comparator<Q22BeanModel> numberOfDaysComparator 
				      = Comparator.comparingLong(Q22BeanModel::getNumberOfDays);
					leaversLengthofStay.sort(numberOfDaysComparator);
					 int median = (leaversLengthofStay.size()/2) + 1;
					Q22BeanModel q22BeanModel = leaversLengthofStay.get(median);
					q22bAverageAndMedianLengthOfParticipationInDaysTable.setQ22bMedianLengthInDaysLeavers(BigInteger.valueOf(q22BeanModel.getNumberOfDays()));
				}
				List<Q22BeanModel> stayersLengthofStay = data.getStayersLengthofStay();
				if(CollectionUtils.isNotEmpty(stayersLengthofStay)) {
					long count =0;
					for(Q22BeanModel model : stayersLengthofStay) {
						count = count + model.getNumberOfDays();
					}
					q22bAverageAndMedianLengthOfParticipationInDaysTable.setQ22bAverageLengthInDaysStayers(BigInteger.valueOf(count/leaversLengthofStay.size()));
					Comparator<Q22BeanModel> numberOfDaysComparator 
				      = Comparator.comparingLong(Q22BeanModel::getNumberOfDays);
					leaversLengthofStay.sort(numberOfDaysComparator);
					 int median = (leaversLengthofStay.size()/2) + 1;
					Q22BeanModel q22BeanModel = leaversLengthofStay.get(median);
					q22bAverageAndMedianLengthOfParticipationInDaysTable.setQ22bMedianLengthInDaysLeavers(BigInteger.valueOf(q22BeanModel.getNumberOfDays()));
					q22bAverageAndMedianLengthOfParticipationInDaysTable.setQ22bMedianLengthInDaysStayers(BigInteger.valueOf(q22BeanModel.getNumberOfDays()));
				}
			}
		}catch(Exception e){
			logger.error("Error in Q22bAverageAndMedianLengthOfParticipationInDaysDataBeanMaker:" + e);
		}
		
		return Arrays.asList(q22bAverageAndMedianLengthOfParticipationInDaysTable);
		
	}

}
