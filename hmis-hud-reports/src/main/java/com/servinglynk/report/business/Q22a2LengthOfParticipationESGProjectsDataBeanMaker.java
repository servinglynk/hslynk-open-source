package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;

import com.servinglynk.report.bean.Q22a2LengthOfParticipationESGProjectsDataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.Q22BeanModel;

public class Q22a2LengthOfParticipationESGProjectsDataBeanMaker extends BaseBeanMaker {

	public static List<Q22a2LengthOfParticipationESGProjectsDataBean> getQ22a2LengthOfParticipationESGProjectsList(ReportData data){
		
		Q22a2LengthOfParticipationESGProjectsDataBean q22a2LengthOfParticipationESGProjectsTable = new Q22a2LengthOfParticipationESGProjectsDataBean();
		
		List<Q22BeanModel> allData = data.getAllDataLenghtofStay();
		List<Q22BeanModel> allLeaversData =  data.getLeaversLengthofStay();
		List<Q22BeanModel> allStayersData =  data.getStayersLengthofStay();
		try {
			if(data.isLiveMode()) {
		if(CollectionUtils.isNotEmpty(allData)) {
			List<Q22BeanModel>  q22a130DaysOrLess = allData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() <= 30).collect(Collectors.toList());
			List<Q22BeanModel>  q22a1D31To60Days = allData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 31 &&  q22BeanModel.getNumberOfDays() <= 60).collect(Collectors.toList());
			List<Q22BeanModel>  q22a1D61To90Days = allData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() <= 61 && q22BeanModel.getNumberOfDays() >= 90).collect(Collectors.toList());
			List<Q22BeanModel>  q22a1D91To180Days = allData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() <= 91 && q22BeanModel.getNumberOfDays() >= 180).collect(Collectors.toList());
			List<Q22BeanModel>  q22a1E181To365Days = allData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() <= 1811 && q22BeanModel.getNumberOfDays() >= 365).collect(Collectors.toList());
			List<Q22BeanModel>  q22a1F366To730Days = allData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() <= 366 && q22BeanModel.getNumberOfDays() >= 730).collect(Collectors.toList());
			List<Q22BeanModel>  q22a1G731To1095Days = allData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() <= 731 && q22BeanModel.getNumberOfDays() >= 1095).collect(Collectors.toList());
			List<Q22BeanModel>  q22a1H1096To1460Days = allData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() <= 1096 && q22BeanModel.getNumberOfDays() >= 1460).collect(Collectors.toList());
			List<Q22BeanModel>  q22a1I1461To1825Days = allData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() <= 1461 && q22BeanModel.getNumberOfDays() >= 1825).collect(Collectors.toList());
			
			q22a2LengthOfParticipationESGProjectsTable.setQ22a2A30DaysOrLessTotal(BigInteger.valueOf(q22a130DaysOrLess != null ? q22a130DaysOrLess.size(): 0));
			q22a2LengthOfParticipationESGProjectsTable.setQ22a2B31To60DaysTotal(BigInteger.valueOf(q22a1D31To60Days != null ? q22a1D31To60Days.size() :0));
			q22a2LengthOfParticipationESGProjectsTable.setQ22a2C61To90DaysTotal(BigInteger.valueOf(q22a1D61To90Days != null ? q22a1D61To90Days.size() :0));
			q22a2LengthOfParticipationESGProjectsTable.setQ22a2D91To180DaysTotal(BigInteger.valueOf(q22a1D91To180Days != null ? q22a1D91To180Days.size() :0));
			q22a2LengthOfParticipationESGProjectsTable.setQ22a2E181To365DaysTotal(BigInteger.valueOf(q22a1E181To365Days != null ? q22a1E181To365Days.size() :0));
			q22a2LengthOfParticipationESGProjectsTable.setQ22a2F366To730DaysTotal(BigInteger.valueOf(q22a1F366To730Days != null ? q22a1F366To730Days.size() :0));
			q22a2LengthOfParticipationESGProjectsTable.setQ22a2G731To1095DaysTotal(BigInteger.valueOf(q22a1G731To1095Days != null ? q22a1G731To1095Days.size() :0));
			q22a2LengthOfParticipationESGProjectsTable.setQ22a2H1096To1460DaysTotal(BigInteger.valueOf(q22a1H1096To1460Days != null ? q22a1H1096To1460Days.size() :0));
			q22a2LengthOfParticipationESGProjectsTable.setQ22a2I1461To1825DaysTotal(BigInteger.valueOf(q22a1I1461To1825Days != null ? q22a1I1461To1825Days.size() :0));
			q22a2LengthOfParticipationESGProjectsTable.setQ22a2JMoreThan1825DaysTotal(BigInteger.valueOf(0));
			q22a2LengthOfParticipationESGProjectsTable.setQ22a2KInfoMissingTotal(BigInteger.valueOf(0));
		}
		if(CollectionUtils.isNotEmpty(allLeaversData)) {
			List<Q22BeanModel>  q22a130DaysOrLess = allLeaversData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() <= 30).collect(Collectors.toList());
			List<Q22BeanModel>  q22a1D31To60Days = allLeaversData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 31 &&  q22BeanModel.getNumberOfDays() <= 60).collect(Collectors.toList());
			List<Q22BeanModel>  q22a1D61To90Days = allLeaversData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() <= 61 && q22BeanModel.getNumberOfDays() >= 90).collect(Collectors.toList());
			List<Q22BeanModel>  q22a1D91To180Days = allLeaversData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() <= 91 && q22BeanModel.getNumberOfDays() >= 180).collect(Collectors.toList());
			List<Q22BeanModel>  q22a1E181To365Days = allLeaversData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() <= 1811 && q22BeanModel.getNumberOfDays() >= 365).collect(Collectors.toList());
			List<Q22BeanModel>  q22a1F366To730Days = allLeaversData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() <= 366 && q22BeanModel.getNumberOfDays() >= 730).collect(Collectors.toList());
			List<Q22BeanModel>  q22a1G731To1095Days = allLeaversData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() <= 731 && q22BeanModel.getNumberOfDays() >= 1095).collect(Collectors.toList());
			List<Q22BeanModel>  q22a1H1096To1460Days = allLeaversData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() <= 1096 && q22BeanModel.getNumberOfDays() >= 1460).collect(Collectors.toList());
			List<Q22BeanModel>  q22a1I1461To1825Days = allLeaversData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() <= 1461 && q22BeanModel.getNumberOfDays() >= 1825).collect(Collectors.toList());
		
			q22a2LengthOfParticipationESGProjectsTable.setQ22a2A30DaysOrLessLeavers(BigInteger.valueOf(q22a130DaysOrLess != null ? q22a130DaysOrLess.size(): 0));
			q22a2LengthOfParticipationESGProjectsTable.setQ22a2B31To60DaysLeavers(BigInteger.valueOf(q22a1D31To60Days != null ? q22a1D31To60Days.size() :0));
			q22a2LengthOfParticipationESGProjectsTable.setQ22a2C61To90DaysLeavers(BigInteger.valueOf(q22a1D61To90Days != null ? q22a1D61To90Days.size() :0));
			q22a2LengthOfParticipationESGProjectsTable.setQ22a2D91To180DaysLeavers(BigInteger.valueOf(q22a1D91To180Days != null ? q22a1D91To180Days.size() :0));
			q22a2LengthOfParticipationESGProjectsTable.setQ22a2E181To365DaysLeavers(BigInteger.valueOf(q22a1E181To365Days != null ? q22a1E181To365Days.size() :0));
			q22a2LengthOfParticipationESGProjectsTable.setQ22a2F366To730DaysLeavers(BigInteger.valueOf(q22a1F366To730Days != null ? q22a1F366To730Days.size() :0));
			q22a2LengthOfParticipationESGProjectsTable.setQ22a2G731To1095DaysLeavers(BigInteger.valueOf(q22a1G731To1095Days != null ? q22a1G731To1095Days.size() :0));
			q22a2LengthOfParticipationESGProjectsTable.setQ22a2H1096To1460DaysLeavers(BigInteger.valueOf(q22a1H1096To1460Days != null ? q22a1H1096To1460Days.size() :0));
			q22a2LengthOfParticipationESGProjectsTable.setQ22a2I1461To1825DaysLeavers(BigInteger.valueOf(q22a1I1461To1825Days != null ? q22a1I1461To1825Days.size() :0));
			q22a2LengthOfParticipationESGProjectsTable.setQ22a2JMoreThan1825DaysLeavers(BigInteger.valueOf(0));
			q22a2LengthOfParticipationESGProjectsTable.setQ22a2KInfoMissingLeavers(BigInteger.valueOf(0));
			
			
		}
		
		if(CollectionUtils.isNotEmpty(allStayersData)) {
			List<Q22BeanModel>  q22a130DaysOrLess = allStayersData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() <= 30).collect(Collectors.toList());
			List<Q22BeanModel>  q22a1D31To60Days = allStayersData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 31 &&  q22BeanModel.getNumberOfDays() <= 60).collect(Collectors.toList());
			List<Q22BeanModel>  q22a1D61To90Days = allStayersData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() <= 61 && q22BeanModel.getNumberOfDays() >= 90).collect(Collectors.toList());
			List<Q22BeanModel>  q22a1D91To180Days = allStayersData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() <= 91 && q22BeanModel.getNumberOfDays() >= 180).collect(Collectors.toList());
			List<Q22BeanModel>  q22a1E181To365Days = allStayersData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() <= 1811 && q22BeanModel.getNumberOfDays() >= 365).collect(Collectors.toList());
			List<Q22BeanModel>  q22a1F366To730Days = allStayersData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() <= 366 && q22BeanModel.getNumberOfDays() >= 730).collect(Collectors.toList());
			List<Q22BeanModel>  q22a1G731To1095Days = allStayersData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() <= 731 && q22BeanModel.getNumberOfDays() >= 1095).collect(Collectors.toList());
			List<Q22BeanModel>  q22a1H1096To1460Days = allStayersData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() <= 1096 && q22BeanModel.getNumberOfDays() >= 1460).collect(Collectors.toList());
			List<Q22BeanModel>  q22a1I1461To1825Days = allStayersData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() <= 1461 && q22BeanModel.getNumberOfDays() >= 1825).collect(Collectors.toList());
		
			
			q22a2LengthOfParticipationESGProjectsTable.setQ22a2A30DaysOrLessStayers(BigInteger.valueOf(q22a130DaysOrLess != null ? q22a130DaysOrLess.size(): 0));
			q22a2LengthOfParticipationESGProjectsTable.setQ22a2B31To60DaysStayers(BigInteger.valueOf(q22a1D31To60Days != null ? q22a1D31To60Days.size() :0));
			q22a2LengthOfParticipationESGProjectsTable.setQ22a2C61To90DaysStayers(BigInteger.valueOf(q22a1D61To90Days != null ? q22a1D61To90Days.size() :0));
			q22a2LengthOfParticipationESGProjectsTable.setQ22a2D91To180DaysStayers(BigInteger.valueOf(q22a1D91To180Days != null ? q22a1D91To180Days.size() :0));
			q22a2LengthOfParticipationESGProjectsTable.setQ22a2E181To365DaysStayers(BigInteger.valueOf(q22a1E181To365Days != null ? q22a1E181To365Days.size() :0));
			q22a2LengthOfParticipationESGProjectsTable.setQ22a2F366To730DaysStayers(BigInteger.valueOf(q22a1F366To730Days != null ? q22a1F366To730Days.size() :0));
			q22a2LengthOfParticipationESGProjectsTable.setQ22a2G731To1095DaysStayers(BigInteger.valueOf(q22a1G731To1095Days != null ? q22a1G731To1095Days.size() :0));
			q22a2LengthOfParticipationESGProjectsTable.setQ22a2H1096To1460DaysStayers(BigInteger.valueOf(q22a1H1096To1460Days != null ? q22a1H1096To1460Days.size() :0));
			q22a2LengthOfParticipationESGProjectsTable.setQ22a2I1461To1825DaysStayers(BigInteger.valueOf(q22a1I1461To1825Days != null ? q22a1I1461To1825Days.size() :0));
			q22a2LengthOfParticipationESGProjectsTable.setQ22a2JMoreThan1825DaysStayers(BigInteger.valueOf(0));
			q22a2LengthOfParticipationESGProjectsTable.setQ22a2KInfoMissingStayers(BigInteger.valueOf(0));
		}
		data.setLeaversLengthofStay(allLeaversData);
		data.setStayersLengthofStay(allStayersData);
		data.setAllDataLenghtofStay(allData);
		q22a2LengthOfParticipationESGProjectsTable.setQ22a2LTotTotal(data.getTotNumOfPersonServed());
		q22a2LengthOfParticipationESGProjectsTable.setQ22a2LTotLeavers(BigInteger.valueOf(allLeaversData != null ? allLeaversData.size() : 0));
		q22a2LengthOfParticipationESGProjectsTable.setQ22a2LTotStayers(BigInteger.valueOf(allStayersData != null ? allStayersData.size() :0));
			}
	}catch(Exception e) {
		logger.error("Error in Q22aBeanMaker:" + e);
	}
		return Arrays.asList(q22a2LengthOfParticipationESGProjectsTable);
		
	}
	
}
