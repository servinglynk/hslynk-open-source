package com.servinglynk.report.business;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.servinglynk.hive.connection.ImpalaConnection;
import com.servinglynk.report.bean.Q22cLengthofTimeBetweenProjectStrtDtHousingMoveDteDataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.Q22BeanModel;

public class Q22cLengthofTimeBetweenProjectStrtDtHousingMoveDteDataBeanMaker extends BaseBeanMaker {
	
	public static List<Q22cLengthofTimeBetweenProjectStrtDtHousingMoveDteDataBean> getQ22cLengthofTimeBetweenProjectStrtDtHousingMoveDteDataBeanList(ReportData data){
		Q22cLengthofTimeBetweenProjectStrtDtHousingMoveDteDataBean q22cBean = new Q22cLengthofTimeBetweenProjectStrtDtHousingMoveDteDataBean();
		
		String query = " select distinct(e.dedup_client_id ),e.entrydate,mid.moveindate,ext.exitdate from %s.enrollment e join %s.project p  on (e.projectid = p.id  %p ) "+
				  " join  %s.enrollment e1 on  (e.householdid = e1.householdid  and e1.relationshiptohoh ='1') "+
				   "left outer join %s.exit ext on ( e.id = ext.enrollmentid ) "+
			      " left outer join %s.moveindate mid on (e1.id = mid.enrollmentid and mid.moveindate  >=  :endDate  and  mid.moveindate<= :endDate) "+
			      " where e.entrydate >= :startDate and e.entrydate <= :endDate " +
					" order by e.dedup_client_id ";
		String exitedQuery = 		  
					" select distinct(e.dedup_client_id ),e.entrydate,mid.moveindate,ext.exitdate from %s.enrollment e join %s.project p  on (e.projectid = p.id  %p ) "+
					" join %s.exit ext on ( e.id = ext.enrollmentid and ext.exitdate >= :startDate  and ext.exitdate <= :endDate) "+
					" join %s.moveindate mid on (e.id = mid.enrollmentid) "+
					" where e.entrydate >= :startDate and e.entrydate <= :endDate " +
					" order by e.dedup_client_id ";		
		try {
			if(data.isLiveMode()) {
				List<Q22BeanModel> allData = getQ22Bean(data, query, null,true);
				List<Q22BeanModel> withoutChildren = getQ22Bean(data, query, data.getProjectsHHWithOutChildren(),false);
				List<Q22BeanModel> withChildAndAdults = getQ22Bean(data, query, data.getProjectsHHWithOneAdultChild(),false);
				List<Q22BeanModel> withChildren = getQ22Bean(data, query, data.getProjectsHHWithChildren(),false);
				List<Q22BeanModel> unknown = getQ22Bean(data, query, data.getProjectsUnknownHouseHold(),false);
				
				q22cBean.setQ22cPersonsMovedIntoHousingTotal(BigInteger.valueOf(allData != null ? allData.size() :0));
				q22cBean.setQ22cPersonsMovedIntoHousingWithoutChildren(BigInteger.valueOf(withoutChildren != null ? withoutChildren.size():0));
				q22cBean.setQ22cPersonsMovedIntoHousingWithChildAndAdults(BigInteger.valueOf(0));
				q22cBean.setQ22cPersonsMovedIntoHousingWithOnlychildren(BigInteger.valueOf(withChildAndAdults != null ? withChildAndAdults.size() :0));
				q22cBean.setQ22cPersonsMovedIntoHousingUnknowHousehold(BigInteger.valueOf(unknown != null ? unknown.size():0));
				
				
				List<Q22BeanModel>  q22Bean7DaysOrLessAllData = allData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() <= 7).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean7DaysOrLessWithoutChildren = withoutChildren.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() <= 7).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean7DaysOrLessWithChildAndAdults = withChildAndAdults.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() <= 7).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean7DaysOrLessWithChildren = withChildren.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() <= 7).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean7DaysOrLessUnknown = unknown.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() <= 7).collect(Collectors.toList());
					
				q22cBean.setQ22c7DaysLessTotal(BigInteger.valueOf(q22Bean7DaysOrLessAllData != null ? q22Bean7DaysOrLessAllData.size() :0));
				q22cBean.setQ22c7DaysLessWithoutChildren(BigInteger.valueOf(q22Bean7DaysOrLessWithoutChildren != null ?q22Bean7DaysOrLessWithoutChildren.size() :0));
				q22cBean.setQ22c7DaysLessWithChildAndAdults(BigInteger.valueOf(q22Bean7DaysOrLessWithChildAndAdults != null ? q22Bean7DaysOrLessWithChildAndAdults.size() :0));
				q22cBean.setQ22c7DaysLessWithOnlychildren(BigInteger.valueOf(q22Bean7DaysOrLessWithChildren != null ? q22Bean7DaysOrLessWithChildren.size() : 0 ));
				q22cBean.setQ22c7DaysLessUnknowHousehold(BigInteger.valueOf(q22Bean7DaysOrLessUnknown != null ? q22Bean7DaysOrLessUnknown.size() : 0));
				
				List<Q22BeanModel>  q22Bean8To14DaysOrLessAllData = allData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 8 && q22BeanModel.getNumberOfDays() <= 14).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean8To14DaysOrLessWithoutChildren = withoutChildren.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 8 && q22BeanModel.getNumberOfDays() <= 14).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean8To14DaysOrLessWithChildAndAdults = withChildAndAdults.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 8 && q22BeanModel.getNumberOfDays() <= 14).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean8To14DaysOrLessWithChildren = withChildren.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 8 && q22BeanModel.getNumberOfDays() <= 14).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean8To14DaysOrLessUnknown = unknown.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 8 && q22BeanModel.getNumberOfDays() <= 14).collect(Collectors.toList());
				
				q22cBean.setQ22c8To14DaysTotal(BigInteger.valueOf(q22Bean8To14DaysOrLessAllData != null ? q22Bean8To14DaysOrLessAllData.size() :0));
				q22cBean.setQ22c8To14DaysWithoutChildren(BigInteger.valueOf(q22Bean8To14DaysOrLessWithoutChildren != null ? q22Bean8To14DaysOrLessWithoutChildren.size() :0));
				q22cBean.setQ22c8To14DaysWithChildAndAdults(BigInteger.valueOf(q22Bean8To14DaysOrLessWithChildAndAdults != null ? q22Bean8To14DaysOrLessWithChildAndAdults.size() :0));
				q22cBean.setQ22c8To14DaysWithOnlychildren(BigInteger.valueOf(q22Bean8To14DaysOrLessWithChildren != null ? q22Bean8To14DaysOrLessWithChildren.size() : 0));
				q22cBean.setQ22c8To14DaysUnknowHousehold(BigInteger.valueOf(q22Bean8To14DaysOrLessUnknown != null ? q22Bean8To14DaysOrLessUnknown.size() :0 ));
				
				List<Q22BeanModel>  q22Bean15To21DaysOrLessAllData = allData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 15 && q22BeanModel.getNumberOfDays() <= 21).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean15To21DaysOrLessWithoutChildren = withoutChildren.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 15 && q22BeanModel.getNumberOfDays() <= 21).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean15To21DaysOrLessWithChildAndAdults = withChildAndAdults.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 15 && q22BeanModel.getNumberOfDays() <= 21).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean15To21DaysOrLessWithChildren = withChildren.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 15 && q22BeanModel.getNumberOfDays() <= 21).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean15To21DaysOrLessUnknown = unknown.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 15 && q22BeanModel.getNumberOfDays() <= 21).collect(Collectors.toList());
				
				q22cBean.setQ22c15To21DaysTotal(BigInteger.valueOf(q22Bean15To21DaysOrLessAllData != null ? q22Bean15To21DaysOrLessAllData.size() :0));
				q22cBean.setQ22c15To21DaysWithoutChildren(BigInteger.valueOf(q22Bean15To21DaysOrLessWithoutChildren != null ? q22Bean15To21DaysOrLessWithoutChildren.size() :0));
				q22cBean.setQ22c15To21DaysWithChildAndAdults(BigInteger.valueOf(q22Bean15To21DaysOrLessWithChildAndAdults != null ? q22Bean15To21DaysOrLessWithChildAndAdults.size():0));
				q22cBean.setQ22c15To21DaysWithOnlychildren(BigInteger.valueOf(q22Bean15To21DaysOrLessWithChildren !=null ? q22Bean15To21DaysOrLessWithChildren.size() :0));
				q22cBean.setQ22c15To21DaysUnknowHousehold(BigInteger.valueOf(q22Bean15To21DaysOrLessUnknown !=null ?  q22Bean15To21DaysOrLessUnknown.size() :0));
				
				
				List<Q22BeanModel>  q22Bean22To30DaysOrLessAllData = allData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 22 && q22BeanModel.getNumberOfDays() <= 30).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean22To30DaysOrLessWithoutChildren = withoutChildren.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 22 && q22BeanModel.getNumberOfDays() <= 30).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean22To30DaysOrLessWithChildAndAdults = withChildAndAdults.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 22 && q22BeanModel.getNumberOfDays() <= 30).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean22To30DaysOrLessWithChildren = withChildren.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 22 && q22BeanModel.getNumberOfDays() <= 30).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean22To30DaysOrLessUnknown = unknown.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 22 && q22BeanModel.getNumberOfDays() <= 30).collect(Collectors.toList());
				
				q22cBean.setQ22c22To30DaysTotal(BigInteger.valueOf(q22Bean22To30DaysOrLessAllData !=null ? q22Bean22To30DaysOrLessAllData.size() :0));
				q22cBean.setQ22c22To30DaysWithoutChildren(BigInteger.valueOf(q22Bean22To30DaysOrLessWithoutChildren !=null ? q22Bean22To30DaysOrLessWithoutChildren.size() :0));
				q22cBean.setQ22c22To30DaysWithChildAndAdults(BigInteger.valueOf(q22Bean22To30DaysOrLessWithChildAndAdults !=null ? q22Bean22To30DaysOrLessWithChildAndAdults.size() :0));
				q22cBean.setQ22c22To30DaysWithOnlychildren(BigInteger.valueOf(q22Bean22To30DaysOrLessWithChildren !=null ? q22Bean22To30DaysOrLessWithChildren.size() :0));
				q22cBean.setQ22c22To30DaysUnknowHousehold(BigInteger.valueOf(q22Bean22To30DaysOrLessUnknown !=null ? q22Bean22To30DaysOrLessUnknown.size() :0));
				
				List<Q22BeanModel>  q22Bean31To60DaysOrLessAllData = allData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 31 && q22BeanModel.getNumberOfDays() <= 60).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean31To60DaysOrLessWithoutChildren = withoutChildren.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 31 && q22BeanModel.getNumberOfDays() <= 60).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean31To60DaysOrLessWithChildAndAdults = withChildAndAdults.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 31 && q22BeanModel.getNumberOfDays() <= 60).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean31To60DaysOrLessWithChildren = withChildren.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 31 && q22BeanModel.getNumberOfDays() <= 60).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean31To60DaysOrLessUnknown = unknown.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 31 && q22BeanModel.getNumberOfDays() <= 60).collect(Collectors.toList());
				
				q22cBean.setQ22c31To60DaysTotal(BigInteger.valueOf(q22Bean31To60DaysOrLessAllData != null ? q22Bean31To60DaysOrLessAllData.size() :0));
				q22cBean.setQ22c31To60DaysWithoutChildren(BigInteger.valueOf(q22Bean31To60DaysOrLessWithoutChildren != null ? q22Bean31To60DaysOrLessWithoutChildren.size() :0));
				q22cBean.setQ22c31To60DaysWithChildAndAdults(BigInteger.valueOf(q22Bean31To60DaysOrLessWithChildAndAdults !=null ? q22Bean31To60DaysOrLessWithChildAndAdults.size() :0));
				q22cBean.setQ22c31To60DaysWithOnlychildren(BigInteger.valueOf(q22Bean31To60DaysOrLessWithChildren != null ? q22Bean31To60DaysOrLessWithChildren.size() :0));
				q22cBean.setQ22c31To60DaysUnknowHousehold(BigInteger.valueOf(q22Bean31To60DaysOrLessUnknown != null ? q22Bean31To60DaysOrLessUnknown.size() :0));
				
				List<Q22BeanModel>  q22Bean61To180DaysOrLessAllData = allData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 61 && q22BeanModel.getNumberOfDays() <= 180).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean61To180DaysOrLessWithoutChildren = withoutChildren.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 61 && q22BeanModel.getNumberOfDays() <= 180).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean61To180DaysOrLessWithChildAndAdults = withChildAndAdults.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 61 && q22BeanModel.getNumberOfDays() <= 180).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean61To180DaysOrLessWithChildren = withChildren.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 61 && q22BeanModel.getNumberOfDays() <= 180).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean61To180DaysOrLessUnknown = unknown.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 61 && q22BeanModel.getNumberOfDays() <= 180).collect(Collectors.toList());
			
				q22cBean.setQ22c61To180DaysTotal(BigInteger.valueOf(q22Bean61To180DaysOrLessAllData != null ? q22Bean61To180DaysOrLessAllData.size() :0 ));
				q22cBean.setQ22c61To180DaysWithoutChildren(BigInteger.valueOf(q22Bean61To180DaysOrLessWithoutChildren != null ? q22Bean61To180DaysOrLessWithoutChildren.size() :0));
				q22cBean.setQ22c61To180DaysWithChildAndAdults(BigInteger.valueOf(q22Bean61To180DaysOrLessWithChildAndAdults != null ? q22Bean61To180DaysOrLessWithChildAndAdults.size() :0));
				q22cBean.setQ22c61To180DaysWithOnlychildren(BigInteger.valueOf(q22Bean61To180DaysOrLessWithChildren != null ? q22Bean61To180DaysOrLessWithChildren.size() :0));
				q22cBean.setQ22c61To180DaysUnknowHousehold(BigInteger.valueOf(q22Bean61To180DaysOrLessUnknown != null  ? q22Bean61To180DaysOrLessUnknown.size() : 0));
				
				List<Q22BeanModel>  q22Bean181To365DaysOrLessAllData = allData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 181 && q22BeanModel.getNumberOfDays() <= 365).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean181To365DaysOrLessWithoutChildren = withoutChildren.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 181 && q22BeanModel.getNumberOfDays() <= 365).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean181To365DaysOrLessWithChildAndAdults = withChildAndAdults.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 181 && q22BeanModel.getNumberOfDays() <= 365).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean181To365DaysOrLessWithChildren = withChildren.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 181 && q22BeanModel.getNumberOfDays() <= 365).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean181To365DaysOrLessUnknown = unknown.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 181 && q22BeanModel.getNumberOfDays() <= 365).collect(Collectors.toList());
			
				q22cBean.setQ22c181To365DaysTotal(BigInteger.valueOf(q22Bean181To365DaysOrLessAllData != null ? q22Bean181To365DaysOrLessAllData.size() :0));
				q22cBean.setQ22c181To365DaysWithoutChildren(BigInteger.valueOf(q22Bean181To365DaysOrLessWithoutChildren != null ? q22Bean181To365DaysOrLessWithoutChildren.size() :0));
				q22cBean.setQ22c181To365DaysWithChildAndAdults(BigInteger.valueOf(q22Bean181To365DaysOrLessWithChildAndAdults != null ? q22Bean181To365DaysOrLessWithChildAndAdults.size() :0));
				q22cBean.setQ22c181To365DaysWithOnlychildren(BigInteger.valueOf(q22Bean181To365DaysOrLessWithChildren != null ? q22Bean181To365DaysOrLessWithChildren.size() :0));
				q22cBean.setQ22c181To365DaysUnknowHousehold(BigInteger.valueOf(q22Bean181To365DaysOrLessUnknown != null ? q22Bean181To365DaysOrLessUnknown.size() :0));
				
				List<Q22BeanModel>  q22Bean366To730DaysOrLessAllData = allData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 366 && q22BeanModel.getNumberOfDays() <= 730).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean366To730DaysOrLessWithoutChildren = withoutChildren.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 366 && q22BeanModel.getNumberOfDays() <= 730).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean366To730DaysOrLessWithChildAndAdults = withChildAndAdults.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 366 && q22BeanModel.getNumberOfDays() <= 730).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean366To730DaysOrLessWithChildren = withChildren.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 366 && q22BeanModel.getNumberOfDays() <= 730).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean366To730DaysOrLessUnknown = unknown.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 366 && q22BeanModel.getNumberOfDays() <= 730).collect(Collectors.toList());
			
				
				q22cBean.setQ22c366To730DaysTotal(BigInteger.valueOf(q22Bean366To730DaysOrLessAllData != null ? q22Bean366To730DaysOrLessAllData.size() :0));
				q22cBean.setQ22c366To730DaysWithoutChildren(BigInteger.valueOf(q22Bean366To730DaysOrLessWithoutChildren != null ? q22Bean366To730DaysOrLessWithoutChildren.size() : 0));
				q22cBean.setQ22c366To730DaysWithChildAndAdults(BigInteger.valueOf(q22Bean366To730DaysOrLessWithChildAndAdults != null ? q22Bean366To730DaysOrLessWithChildAndAdults.size() :0 ));
				q22cBean.setQ22c366To730DaysWithOnlychildren(BigInteger.valueOf(q22Bean366To730DaysOrLessWithChildren != null ? q22Bean366To730DaysOrLessWithChildren.size() : 0));
				q22cBean.setQ22c366To730DaysUnknowHousehold(BigInteger.valueOf(q22Bean366To730DaysOrLessUnknown != null ? q22Bean366To730DaysOrLessUnknown.size() :0));
				
				
				if(CollectionUtils.isNotEmpty(allData)) {
					long count = 0;
					for(Q22BeanModel q22BeanModel : allData) {
						count = count + q22BeanModel.getNumberOfDays();
					}
					q22cBean.setQ22cAvgLengthTotal(BigInteger.valueOf(count/allData.size()));
				}
				
				if(CollectionUtils.isNotEmpty(withoutChildren)) {
					long count = 0;
					for(Q22BeanModel q22BeanModel : withoutChildren) {
						count = count + q22BeanModel.getNumberOfDays();
					}
					q22cBean.setQ22cAvgLengthWithoutChildren(BigInteger.valueOf(count/allData.size()));
				}
				
				if(CollectionUtils.isNotEmpty(withChildAndAdults)) {
					long count = 0;
					for(Q22BeanModel q22BeanModel : withChildAndAdults) {
						count = count + q22BeanModel.getNumberOfDays();
					}
					q22cBean.setQ22cAvgLengthWithChildAndAdults(BigInteger.valueOf(count/allData.size()));
				}
				if(CollectionUtils.isNotEmpty(withChildren)) {
					long count = 0;
					for(Q22BeanModel q22BeanModel : withChildren) {
						count = count + q22BeanModel.getNumberOfDays();
					}
					q22cBean.setQ22cAvgLengthWithOnlychildren(BigInteger.valueOf(count/allData.size()));
				}
				if(CollectionUtils.isNotEmpty(unknown)) {
					long count = 0;
					for(Q22BeanModel q22BeanModel : unknown) {
						count = count + q22BeanModel.getNumberOfDays();
					}
					q22cBean.setQ22cAvgLengthUnknowHousehold(BigInteger.valueOf(count/allData.size()));
				}
				
				List<Q22BeanModel> allExitData = getQ22Bean(data, exitedQuery, null, true);
				List<Q22BeanModel> allExitWithOutChildren = getQ22Bean(data, exitedQuery, data.getProjectsHHWithOutChildren(), false);
				List<Q22BeanModel> allExitWithChildAndAdults = getQ22Bean(data, exitedQuery, data.getProjectsHHWithOneAdultChild(), false);
				List<Q22BeanModel> allExitWithOnlychildren = getQ22Bean(data, exitedQuery, data.getProjectsHHWithChildren(), false);
				List<Q22BeanModel> allExitWithUnknowHousehold = getQ22Bean(data, exitedQuery, data.getProjectsUnknownHouseHold(), false);
				
				q22cBean.setQ22cPersonsExitedTotal(BigInteger.valueOf(allExitData != null ? allExitData.size():0)); 
				q22cBean.setQ22cPersonsExitedWithoutChildren(BigInteger.valueOf(allExitWithOutChildren != null ? allExitWithOutChildren.size() :0));
				q22cBean.setQ22cPersonsExitedWithChildAndAdults(BigInteger.valueOf(allExitWithChildAndAdults != null ? allExitWithChildAndAdults.size(): 0));
				q22cBean.setQ22cPersonsExitedWithOnlychildren(BigInteger.valueOf(allExitWithOnlychildren != null ? allExitWithOnlychildren.size() : 0));
				q22cBean.setQ22cPersonsExitedUnknowHousehold(BigInteger.valueOf(allExitWithUnknowHousehold != null ? allExitWithUnknowHousehold.size() :0));
				
				q22cBean.setQ22cTotPersonsTotal(data.getOverAllTotHouseHolds()); 
				q22cBean.setQ22cTotPersonsWithoutChildren(data.getTotHhWithoutChild());
				q22cBean.setQ22cTotPersonsWithChildAndAdults(data.getTotHhWithChildAndAdults());
				q22cBean.setQ22cTotPersonsWithOnlychildren(data.getTotHhWothOnlyChild());
				q22cBean.setQ22cTotPersonsUnknowHousehold(data.getTotHhUnknownHhType());
			}
		}catch(Exception e) {
			logger.error("Error in Q22cLengthofTimeBetweenProjectStrtDtHousingMoveDteDataBeanMaker:" + e);
		}
		return Arrays.asList(q22cBean);
		
		
	}

	public static List<Q22BeanModel> getQ22Bean(ReportData data,String query,List<String> filteredProjectIds, boolean allProjects) {
		 List<Q22BeanModel> q22Beans = new ArrayList<Q22BeanModel>();
			ResultSet resultSet = null;
			Statement statement = null;
			String projectQuery = " and p.id in ( ";
			StringBuilder builder = new StringBuilder(projectQuery);
			Connection connection = null;
			try {
				connection = ImpalaConnection.getConnection();
				 List<String> projectIds = data.getProjectIds();
				 if(CollectionUtils.isNotEmpty(projectIds)) {
					 int count = 0;
					 for(String project : projectIds) {
						 if ((filteredProjectIds !=null && filteredProjectIds.contains(project)) || allProjects) {
							 builder.append("'"+project+"'");
							 if(count != projectIds.size()) {
								 builder.append(",");
							 }
						 }
					 }
				 }
				 builder.deleteCharAt(builder.length()-1);
				 builder.append(" ) ");
				 String newQuery = query;
				 if(StringUtils.contains("%p",query)) {
					 newQuery = query.replace("%p", builder.toString());
				 }else {
					 newQuery = query.replace("%p", " ");
				 }
				statement = connection.createStatement();
				resultSet = statement.executeQuery(formatQuery(newQuery,data.getSchema(),data));
				
			 while(resultSet.next()) {
				 Date entryDate = resultSet.getDate("entrydate");
				 Date moveinDate = resultSet.getDate("moveindate");
				 
				 Q22BeanModel bean = new Q22BeanModel(resultSet.getString("dedup_client_id"), null,null, 
						 null,resultSet.getDate("exitdate"),entryDate,moveinDate, null );
				 bean.setNumberOfDays(subtractDate(entryDate, moveinDate));
				 q22Beans.add(bean);
			 
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
			return q22Beans;
		}	
	

}
