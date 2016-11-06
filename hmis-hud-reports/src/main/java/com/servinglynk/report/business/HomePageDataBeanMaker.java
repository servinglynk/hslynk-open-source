package com.servinglynk.report.business;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.servinglynk.report.bean.HomePageDataBean;

public class HomePageDataBeanMaker {
	
		public static List<HomePageDataBean> getHomePageDataList(){
	       
			HomePageDataBean homePageDataBean = new HomePageDataBean();
			
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date date = new Date();
             
			homePageDataBean.setHomePageStartDate(dateFormat.format(date/*"1/1/2015"*/));
			homePageDataBean.setHomePageEndDate(dateFormat.format(date/*"11/10/2016"*/));
			homePageDataBean.setHomePageProjects("APR - Services Only");
			homePageDataBean.setHomePageHomeLess("Everyone");
			homePageDataBean.setHomePageGrants("all grants");
			homePageDataBean.setHomePageView("Aggregate / summary");
			
			homePageDataBean.setQ04aOrgName("All Practical Reporting, Inc.");
			homePageDataBean.setQ04aOrgId("APR");
			homePageDataBean.setQ04aProjectName("APR - Services Only");
			homePageDataBean.setQ04aProjectId(BigInteger.valueOf(0));
			homePageDataBean.setQ04aHmisProjectType(BigInteger.valueOf(6));
			homePageDataBean.setQ04aMethodOfTracking(BigInteger.valueOf(0));
			homePageDataBean.setQ04aHmisProjectIdService(BigInteger.valueOf(240));
			homePageDataBean.setQ04aIdentityProjectId(BigInteger.valueOf(0));
			
			homePageDataBean.setQ05aHMISComparableDBDataQualityDataBean(Q05aHMISComparableDBDataQualityDataBeanMaker.getQ05aHMISCDDQDataList());
			homePageDataBean.setQ06aReportValidationsTableDataBean(Q06aReportValidationsTableDataBeanMaker.getQ06aReportValidationsTableList());
			homePageDataBean.setQ06bNumberOfPersonsServedDataBean(Q06bNumberOfPersonsServedDataBeanMaker.getQ06bNumberOfPersonsServedTableList());
			homePageDataBean.setQ06cPointInTimeCountPersonsLastWednesdayDataBean(Q06cPointInTimeCountPersonsLastWednesdayDataBeanMaker.getQ06cPointInTimeCountPersonsLastWednesdayList());
			homePageDataBean.setQ07aHouseholdsServedDataBean(Q07aHouseHoldsDataBeanMaker.getQ07aHouseholdsServeList());
			homePageDataBean.setQ07bPointInTimeCountHouseholdsLastWednesdayDataBean(Q07bPointInTimeCountHouseholdsLastWednesdayDataBeanMaker.getQ07bPointInTimeCountHouseholdsLastWednesdayList());
			homePageDataBean.setqQ09aNumberPersonsContactedDataBean(Q09aNumberPersonsContactedDataBeanMaker.getQ09aNumberPersonsContactedList());
			homePageDataBean.setQ09bNumberofPersonsEngagedDataBean(Q09bNumberofPersonsEngagedDataBeanMaker.getQ09bNumberofPersonsEngagedList());
			
			
	        return Arrays.asList(homePageDataBean);
	    }
		

}
