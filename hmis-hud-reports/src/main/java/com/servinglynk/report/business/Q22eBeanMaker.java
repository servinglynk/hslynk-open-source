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
import com.servinglynk.report.bean.Q22eDataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.EnrollmentModel;
import com.servinglynk.report.model.Q22BeanModel;

public class Q22eBeanMaker extends BaseBeanMaker {
	
	public static List<Q22eDataBean> getQ22eDataBeanList(ReportData data){
	
		String query = "select  e.dedup_client_id ,p.projecttype,p.trackingmethod,e.datetostreetessh,ext.exitdate,e.entrydate,mid.moveindate from %s.enrollment e join %s.project p  on (e.projectid = p.id %p %e ) "+
				" left outer join  %s.exit ext  on  (ext.enrollmentid = e.id and (ext.exitdate is null  or ext.exitdate > :endDate) ) "+
				" left outer join  %s.moveindate mid  on  (mid.enrollmentid = e.id) ";

		
		Q22eDataBean q22deDataBean =new Q22eDataBean();
		
		try {
			if(data.isLiveMode()) {
				
				List<Q22BeanModel> allData = getQ22EBeanLengthOfStay(data, query, null,true,false);
				List<Q22BeanModel> withoutChildren = getQ22EBeanLengthOfStay(data, query, data.getProjectsHHWithOutChildren(),false,false);
				List<Q22BeanModel> withChildAndAdults = getQ22EBeanLengthOfStay(data, query, data.getProjectsHHWithOneAdultChild(),false,false);
				List<Q22BeanModel> withChildren = getQ22EBeanLengthOfStay(data, query, data.getProjectsHHWithChildren(),false,false);
				List<Q22BeanModel> unknown = getQ22EBeanLengthOfStay(data, query, data.getProjectsUnknownHouseHold(),false,false);
				
				List<Q22BeanModel>  q22Bean7DaysOrLessAllData = allData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() <= 7 && q22BeanModel.getNumberOfDays() != -999 ).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean7DaysOrLessWithoutChildren = withoutChildren.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() <= 7  && q22BeanModel.getNumberOfDays() != -999).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean7DaysOrLessWithChildAndAdults = withChildAndAdults.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() <= 7  && q22BeanModel.getNumberOfDays() != -999).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean7DaysOrLessWithChildren = withChildren.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() <= 7  && q22BeanModel.getNumberOfDays() != -999).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean7DaysOrLessUnknown = unknown.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() <= 7  && q22BeanModel.getNumberOfDays() != -999).collect(Collectors.toList());
					
				int q22Bean7DaysOrLessAllDataSize = q22Bean7DaysOrLessAllData != null ? q22Bean7DaysOrLessAllData.size() :0;
				int q22Bean7DaysOrLessWithoutChildrenSize = q22Bean7DaysOrLessWithoutChildren != null ? q22Bean7DaysOrLessWithoutChildren.size() : 0;
				int q22Bean7DaysOrLessWithChildAndAdultsSize = q22Bean7DaysOrLessWithChildAndAdults != null ? q22Bean7DaysOrLessWithChildAndAdults.size() :0;
				int q22Bean7DaysOrLessWithChildrenSize =  q22Bean7DaysOrLessWithChildren != null ? q22Bean7DaysOrLessWithChildren.size() : 0;
				int q22Bean7DaysOrLessUnknownSize = q22Bean7DaysOrLessUnknown != null ? q22Bean7DaysOrLessUnknown.size() : 0;
				
				q22deDataBean.setQ22e7DaysLessTotal(BigInteger.valueOf(q22Bean7DaysOrLessAllDataSize));
				q22deDataBean.setQ22e7DaysLessWithoutChildren(BigInteger.valueOf(q22Bean7DaysOrLessWithoutChildrenSize));
				q22deDataBean.setQ22e7DaysLessWithChildAndAdults(BigInteger.valueOf(q22Bean7DaysOrLessWithChildAndAdultsSize));
				q22deDataBean.setQ22e7DaysLessWithOnlychildren(BigInteger.valueOf(q22Bean7DaysOrLessWithChildrenSize));
				q22deDataBean.setQ22e7DaysLessUnknowHousehold(BigInteger.valueOf(q22Bean7DaysOrLessUnknownSize));
				
				List<Q22BeanModel>  q22Bean8To14DaysOrLessAllData = allData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 8 && q22BeanModel.getNumberOfDays() <= 14).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean8To14DaysOrLessWithoutChildren = withoutChildren.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 8 && q22BeanModel.getNumberOfDays() <= 14).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean8To14DaysOrLessWithChildAndAdults = withChildAndAdults.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 8 && q22BeanModel.getNumberOfDays() <= 14).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean8To14DaysOrLessWithChildren = withChildren.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 8 && q22BeanModel.getNumberOfDays() <= 14).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean8To14DaysOrLessUnknown = unknown.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 8 && q22BeanModel.getNumberOfDays() <= 14).collect(Collectors.toList());
				
				int q22Bean8To14DaysOrLessAllDataSize = q22Bean8To14DaysOrLessAllData !=null ? q22Bean8To14DaysOrLessAllData.size() :0;
				int q22Bean8To14DaysOrLessWithoutChildrenSize = q22Bean8To14DaysOrLessWithoutChildren != null ? q22Bean8To14DaysOrLessWithoutChildren.size() : 0;
				int q22Bean8To14DaysOrLessWithChildAndAdultsSize = q22Bean8To14DaysOrLessWithChildAndAdults != null ? q22Bean8To14DaysOrLessWithChildAndAdults.size() : 0;
				int q22Bean8To14DaysOrLessWithChildrenSize = q22Bean8To14DaysOrLessWithChildren != null ? q22Bean8To14DaysOrLessWithChildren.size() : 0;
				int q22Bean8To14DaysOrLessUnknownSize = q22Bean8To14DaysOrLessUnknown != null ? q22Bean8To14DaysOrLessUnknown.size() : 0;
				
				q22deDataBean.setQ22e8To14DaysTotal(BigInteger.valueOf(q22Bean8To14DaysOrLessAllDataSize));
				q22deDataBean.setQ22e8To14DaysWithoutChildren(BigInteger.valueOf(q22Bean8To14DaysOrLessWithoutChildrenSize));
				q22deDataBean.setQ22e8To14DaysWithChildAndAdults(BigInteger.valueOf(q22Bean8To14DaysOrLessWithChildAndAdultsSize));
				q22deDataBean.setQ22e8To14DaysWithOnlychildren(BigInteger.valueOf(q22Bean8To14DaysOrLessWithChildrenSize));
				q22deDataBean.setQ22e8To14DaysUnknowHousehold(BigInteger.valueOf(q22Bean8To14DaysOrLessUnknownSize));
				
				List<Q22BeanModel>  q22Bean15To21DaysOrLessAllData = allData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 15 && q22BeanModel.getNumberOfDays() <= 21).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean15To21DaysOrLessWithoutChildren = withoutChildren.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 15 && q22BeanModel.getNumberOfDays() <= 21).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean15To21DaysOrLessWithChildAndAdults = withChildAndAdults.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 15 && q22BeanModel.getNumberOfDays() <= 21).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean15To21DaysOrLessWithChildren = withChildren.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 15 && q22BeanModel.getNumberOfDays() <= 21).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean15To21DaysOrLessUnknown = unknown.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 15 && q22BeanModel.getNumberOfDays() <= 21).collect(Collectors.toList());
				
				int q22Bean15To21DaysOrLessAllDataSize = q22Bean15To21DaysOrLessAllData != null ? q22Bean15To21DaysOrLessAllData.size() : 0;
				int q22Bean15To21DaysOrLessWithoutChildrenSize = q22Bean15To21DaysOrLessWithoutChildren != null ? q22Bean15To21DaysOrLessWithoutChildren.size() : 0;
				int q22Bean15To21DaysOrLessWithChildAndAdultsSize = q22Bean15To21DaysOrLessWithChildAndAdults != null ? q22Bean15To21DaysOrLessWithChildAndAdults.size() : 0;
				int q22Bean15To21DaysOrLessWithChildrenSize = q22Bean15To21DaysOrLessWithChildren != null ? q22Bean15To21DaysOrLessWithChildren.size() : 0;
				int q22Bean15To21DaysOrLessUnknownSize = q22Bean15To21DaysOrLessUnknown != null ? q22Bean15To21DaysOrLessUnknown.size() : 0;
				
				q22deDataBean.setQ22e15To21DaysTotal(BigInteger.valueOf(q22Bean15To21DaysOrLessAllDataSize));
				q22deDataBean.setQ22e15To21DaysWithoutChildren(BigInteger.valueOf(q22Bean15To21DaysOrLessWithoutChildrenSize));
				q22deDataBean.setQ22e15To21DaysWithChildAndAdults(BigInteger.valueOf(q22Bean15To21DaysOrLessWithChildAndAdultsSize));
				q22deDataBean.setQ22e15To21DaysWithOnlychildren(BigInteger.valueOf(q22Bean15To21DaysOrLessWithChildrenSize));
				q22deDataBean.setQ22e15To21DaysUnknowHousehold(BigInteger.valueOf(q22Bean15To21DaysOrLessUnknownSize));
				
				List<Q22BeanModel>  q22Bean22To30DaysOrLessAllData = allData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 22 && q22BeanModel.getNumberOfDays() <= 30).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean22To30DaysOrLessWithoutChildren = withoutChildren.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 22 && q22BeanModel.getNumberOfDays() <= 30).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean22To30DaysOrLessWithChildAndAdults = withChildAndAdults.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 22 && q22BeanModel.getNumberOfDays() <= 30).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean22To30DaysOrLessWithChildren = withChildren.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 22 && q22BeanModel.getNumberOfDays() <= 30).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean22To30DaysOrLessUnknown = unknown.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 22 && q22BeanModel.getNumberOfDays() <= 30).collect(Collectors.toList());
				
				int q22Bean22To30DaysOrLessAllDataSize = q22Bean22To30DaysOrLessAllData != null ? q22Bean22To30DaysOrLessAllData.size(): 0;
				int q22Bean22To30DaysOrLessWithoutChildrenSize = q22Bean22To30DaysOrLessWithoutChildren != null ? q22Bean22To30DaysOrLessWithoutChildren.size(): 0;
				int q22Bean22To30DaysOrLessWithChildAndAdultsSize = q22Bean22To30DaysOrLessWithChildAndAdults !=null ? q22Bean22To30DaysOrLessWithChildAndAdults.size() : 0;
				int q22Bean22To30DaysOrLessWithChildrenSize = q22Bean22To30DaysOrLessWithChildren != null ? q22Bean22To30DaysOrLessWithChildren.size() : 0;
				int q22Bean22To30DaysOrLessUnknownSize = q22Bean22To30DaysOrLessUnknown !=null ? q22Bean22To30DaysOrLessUnknown.size() : 0;
				
				q22deDataBean.setQ22e22To30DaysTotal(BigInteger.valueOf(q22Bean22To30DaysOrLessAllDataSize));
				q22deDataBean.setQ22e22To30DaysWithoutChildren(BigInteger.valueOf(q22Bean22To30DaysOrLessWithoutChildrenSize));
				q22deDataBean.setQ22e22To30DaysWithChildAndAdults(BigInteger.valueOf(q22Bean22To30DaysOrLessWithChildAndAdultsSize));
				q22deDataBean.setQ22e22To30DaysWithOnlychildren(BigInteger.valueOf(q22Bean22To30DaysOrLessWithChildrenSize));
				q22deDataBean.setQ22e22To30DaysUnknowHousehold(BigInteger.valueOf(q22Bean22To30DaysOrLessUnknownSize));
				
				List<Q22BeanModel>  q22Bean31To60DaysOrLessAllData = allData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 31 && q22BeanModel.getNumberOfDays() <= 60).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean31To60DaysOrLessWithoutChildren = withoutChildren.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 31 && q22BeanModel.getNumberOfDays() <= 60).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean31To60DaysOrLessWithChildAndAdults = withChildAndAdults.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 31 && q22BeanModel.getNumberOfDays() <= 60).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean31To60DaysOrLessWithChildren = withChildren.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 31 && q22BeanModel.getNumberOfDays() <= 60).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean31To60DaysOrLessUnknown = unknown.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 31 && q22BeanModel.getNumberOfDays() <= 60).collect(Collectors.toList());
				
				int q22Bean31To60DaysOrLessAllDataSize = q22Bean31To60DaysOrLessAllData != null ? q22Bean31To60DaysOrLessAllData.size() : 0;
				int q22Bean31To60DaysOrLessWithoutChildrenSize = q22Bean31To60DaysOrLessWithoutChildren != null ? q22Bean31To60DaysOrLessWithoutChildren.size() : 0;
				int q22Bean31To60DaysOrLessWithChildAndAdultsSize = q22Bean31To60DaysOrLessWithChildAndAdults != null ? q22Bean31To60DaysOrLessWithChildAndAdults.size() :0;
				int q22Bean31To60DaysOrLessWithChildrenSize = q22Bean31To60DaysOrLessWithChildren != null ? q22Bean31To60DaysOrLessWithChildren.size() : 0;
				int q22Bean31To60DaysOrLessUnknownSize = q22Bean31To60DaysOrLessUnknown != null ? q22Bean31To60DaysOrLessUnknown.size() : 0;
				
				q22deDataBean.setQ22e31To60DaysTotal(BigInteger.valueOf(q22Bean31To60DaysOrLessAllDataSize));
				q22deDataBean.setQ22e31To60DaysWithoutChildren(BigInteger.valueOf(q22Bean31To60DaysOrLessWithoutChildrenSize));
				q22deDataBean.setQ22e31To60DaysWithChildAndAdults(BigInteger.valueOf(q22Bean31To60DaysOrLessWithChildAndAdultsSize));
				q22deDataBean.setQ22e31To60DaysWithOnlychildren(BigInteger.valueOf(q22Bean31To60DaysOrLessWithChildrenSize));
				q22deDataBean.setQ22e31To60DaysUnknowHousehold(BigInteger.valueOf(q22Bean31To60DaysOrLessUnknownSize));
				
				List<Q22BeanModel>  q22Bean61To180DaysOrLessAllData = allData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 61 && q22BeanModel.getNumberOfDays() <= 180).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean61To180DaysOrLessWithoutChildren = withoutChildren.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 61 && q22BeanModel.getNumberOfDays() <= 180).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean61To180DaysOrLessWithChildAndAdults = withChildAndAdults.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 61 && q22BeanModel.getNumberOfDays() <= 180).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean61To180DaysOrLessWithChildren = withChildren.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 61 && q22BeanModel.getNumberOfDays() <= 180).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean61To180DaysOrLessUnknown = unknown.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 61 && q22BeanModel.getNumberOfDays() <= 180).collect(Collectors.toList());
			
				int q22Bean61To180DaysOrLessAllDataSize = q22Bean61To180DaysOrLessAllData != null ? q22Bean61To180DaysOrLessAllData.size() : 0;
				int q22Bean61To180DaysOrLessWithoutChildrenSize = q22Bean61To180DaysOrLessWithoutChildren != null ? q22Bean61To180DaysOrLessWithoutChildren.size() : 0;
				int q22Bean61To180DaysOrLessWithChildAndAdultsSize = q22Bean61To180DaysOrLessWithChildAndAdults != null ? q22Bean61To180DaysOrLessWithChildAndAdults.size() : 0;
				int q22Bean61To180DaysOrLessWithChildrenSize = q22Bean61To180DaysOrLessWithChildren != null ? q22Bean61To180DaysOrLessWithChildren.size() : 0;
				int q22Bean61To180DaysOrLessUnknownSize = q22Bean61To180DaysOrLessUnknown != null ? q22Bean61To180DaysOrLessUnknown.size() : 0;
				
				q22deDataBean.setQ22e61To180DaysTotal(BigInteger.valueOf(q22Bean61To180DaysOrLessAllDataSize));
				q22deDataBean.setQ22e61To180DaysWithoutChildren(BigInteger.valueOf(q22Bean61To180DaysOrLessWithoutChildrenSize));
				q22deDataBean.setQ22e61To180DaysWithChildAndAdults(BigInteger.valueOf(q22Bean61To180DaysOrLessWithChildAndAdultsSize));
				q22deDataBean.setQ22e61To180DaysWithOnlychildren(BigInteger.valueOf(q22Bean61To180DaysOrLessWithChildrenSize));
				q22deDataBean.setQ22e61To180DaysUnknowHousehold(BigInteger.valueOf(q22Bean61To180DaysOrLessUnknownSize));
				
				List<Q22BeanModel>  q22Bean181To365DaysOrLessAllData = allData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 181 && q22BeanModel.getNumberOfDays() <= 365).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean181To365DaysOrLessWithoutChildren = withoutChildren.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 181 && q22BeanModel.getNumberOfDays() <= 365).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean181To365DaysOrLessWithChildAndAdults = withChildAndAdults.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 181 && q22BeanModel.getNumberOfDays() <= 365).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean181To365DaysOrLessWithChildren = withChildren.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 181 && q22BeanModel.getNumberOfDays() <= 365).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean181To365DaysOrLessUnknown = unknown.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 181 && q22BeanModel.getNumberOfDays() <= 365).collect(Collectors.toList());
				
				int q22Bean181To365DaysOrLessAllDataSize = q22Bean181To365DaysOrLessAllData != null ? q22Bean181To365DaysOrLessAllData.size() : 0;
				int q22Bean181To365DaysOrLessWithoutChildrenSize = q22Bean181To365DaysOrLessWithoutChildren != null ? q22Bean181To365DaysOrLessWithoutChildren.size() :0;
				int q22Bean181To365DaysOrLessWithChildAndAdultsSize = q22Bean181To365DaysOrLessWithChildAndAdults != null ? q22Bean181To365DaysOrLessWithChildAndAdults.size() :0;
				int q22Bean181To365DaysOrLessWithChildrenSize = q22Bean181To365DaysOrLessWithChildren != null ? q22Bean181To365DaysOrLessWithChildren.size() : 0;
				int q22Bean181To365DaysOrLessUnknownSize = q22Bean181To365DaysOrLessUnknown != null ? q22Bean181To365DaysOrLessUnknown.size() : 0;
				
				q22deDataBean.setQ22e181To365DaysTotal(BigInteger.valueOf(q22Bean181To365DaysOrLessAllDataSize));
				q22deDataBean.setQ22e181To365DaysWithoutChildren(BigInteger.valueOf(q22Bean181To365DaysOrLessWithoutChildrenSize));
				q22deDataBean.setQ22e181To365DaysWithChildAndAdults(BigInteger.valueOf(q22Bean181To365DaysOrLessWithChildAndAdultsSize));
				q22deDataBean.setQ22e181To365DaysWithOnlychildren(BigInteger.valueOf(q22Bean181To365DaysOrLessWithChildrenSize));
				q22deDataBean.setQ22e181To365DaysUnknowHousehold(BigInteger.valueOf(q22Bean181To365DaysOrLessUnknownSize));
				
				List<Q22BeanModel>  q22Bean366To730DaysOrLessAllData = allData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 366 && q22BeanModel.getNumberOfDays() <= 730).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean366To730DaysOrLessWithoutChildren = withoutChildren.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 366 && q22BeanModel.getNumberOfDays() <= 730).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean366To730DaysOrLessWithChildAndAdults = withChildAndAdults.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 366 && q22BeanModel.getNumberOfDays() <= 730).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean366To730DaysOrLessWithChildren = withChildren.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 366 && q22BeanModel.getNumberOfDays() <= 730).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean366To730DaysOrLessUnknown = unknown.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 366 && q22BeanModel.getNumberOfDays() <= 730).collect(Collectors.toList());
			
				int q22Bean366To730DaysOrLessAllDataSize = q22Bean366To730DaysOrLessAllData != null ? q22Bean366To730DaysOrLessAllData.size() : 0;
				int q22Bean366To730DaysOrLessWithoutChildrenSize = q22Bean366To730DaysOrLessWithoutChildren != null ? q22Bean366To730DaysOrLessWithoutChildren.size() : 0;
				int q22Bean366To730DaysOrLessWithChildAndAdultsSize = q22Bean366To730DaysOrLessWithChildAndAdults != null ? q22Bean366To730DaysOrLessWithChildAndAdults.size() : 0;
				int q22Bean366To730DaysOrLessWithChildrenSize = q22Bean366To730DaysOrLessWithChildren != null ? q22Bean366To730DaysOrLessWithChildren.size() : 0;
				int q22Bean366To730DaysOrLessUnknownSize = q22Bean366To730DaysOrLessUnknown != null ? q22Bean366To730DaysOrLessUnknown.size() : 0;
				
				q22deDataBean.setQ22e366To730DaysTotal(BigInteger.valueOf(q22Bean366To730DaysOrLessAllDataSize));
				q22deDataBean.setQ22e366To730DaysWithoutChildren(BigInteger.valueOf(q22Bean366To730DaysOrLessWithoutChildrenSize));
				q22deDataBean.setQ22e366To730DaysWithChildAndAdults(BigInteger.valueOf(q22Bean366To730DaysOrLessWithChildAndAdultsSize));
				q22deDataBean.setQ22e366To730DaysWithOnlychildren(BigInteger.valueOf(q22Bean366To730DaysOrLessWithChildrenSize));
				q22deDataBean.setQ22e366To730DaysUnknowHousehold(BigInteger.valueOf(q22Bean366To730DaysOrLessUnknownSize));
				
				List<Q22BeanModel>  q22Bean731To1095DaysOrLessAllData = allData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 731 ).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean731To1095DDaysOrLessWithoutChildren = withoutChildren.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 731 ).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean731To1095DDaysOrLessWithChildAndAdults = withChildAndAdults.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 731 ).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean731To1095DDaysOrLessWithChildren = withChildren.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 731 ).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean731To1095DDaysOrLessUnknown = unknown.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 731 ).collect(Collectors.toList());
				
				int q22Bean731To1095DaysOrLessAllDataSize = q22Bean731To1095DaysOrLessAllData != null ? q22Bean731To1095DaysOrLessAllData.size() : 0;
				int q22Bean731To1095DDaysOrLessWithoutChildrenSize = q22Bean731To1095DDaysOrLessWithoutChildren != null ? q22Bean731To1095DDaysOrLessWithoutChildren.size() : 0;
				int q22Bean731To1095DDaysOrLessWithChildAndAdultsSize = q22Bean731To1095DDaysOrLessWithChildAndAdults != null ? q22Bean731To1095DDaysOrLessWithChildAndAdults.size() : 0;
				int q22Bean731To1095DDaysOrLessWithChildrenSize = q22Bean731To1095DDaysOrLessWithChildren != null ? q22Bean731To1095DDaysOrLessWithChildren.size() : 0;
				int q22Bean731To1095DDaysOrLessUnknownSize = q22Bean731To1095DDaysOrLessUnknown != null ? q22Bean731To1095DDaysOrLessUnknown.size() : 0;
				
				q22deDataBean.setQ22e731To1095DaysTotal(BigInteger.valueOf(q22Bean731To1095DaysOrLessAllDataSize));
				q22deDataBean.setQ22e731To1095DaysWithoutChildren(BigInteger.valueOf(q22Bean731To1095DDaysOrLessWithoutChildrenSize));
				q22deDataBean.setQ22e731To1095DaysWithChildAndAdults(BigInteger.valueOf(q22Bean731To1095DDaysOrLessWithChildAndAdultsSize));
				q22deDataBean.setQ22e731To1095DaysWithOnlychildren(BigInteger.valueOf(q22Bean731To1095DDaysOrLessWithChildrenSize));
				q22deDataBean.setQ22e731To1095DaysUnknowHousehold(BigInteger.valueOf(q22Bean731To1095DDaysOrLessUnknownSize));
				
				int totalAllDataSize = q22Bean7DaysOrLessAllDataSize + q22Bean8To14DaysOrLessAllDataSize+q22Bean15To21DaysOrLessAllDataSize+ q22Bean22To30DaysOrLessAllDataSize+q22Bean31To60DaysOrLessAllDataSize+q22Bean61To180DaysOrLessAllDataSize+q22Bean181To365DaysOrLessAllDataSize+q22Bean366To730DaysOrLessAllDataSize+q22Bean731To1095DaysOrLessAllDataSize;
				int totalWithoutChildrenSize = q22Bean7DaysOrLessWithoutChildrenSize+q22Bean8To14DaysOrLessWithoutChildrenSize+q22Bean15To21DaysOrLessWithoutChildrenSize+q22Bean22To30DaysOrLessWithoutChildrenSize+q22Bean31To60DaysOrLessWithoutChildrenSize+q22Bean61To180DaysOrLessWithoutChildrenSize+q22Bean181To365DaysOrLessWithoutChildrenSize+q22Bean366To730DaysOrLessWithoutChildrenSize+q22Bean731To1095DDaysOrLessWithoutChildrenSize;
				int totalChildAndAdultsSize =q22Bean7DaysOrLessWithChildAndAdultsSize+q22Bean8To14DaysOrLessWithChildAndAdultsSize+q22Bean15To21DaysOrLessWithChildAndAdultsSize+q22Bean22To30DaysOrLessWithChildAndAdultsSize+q22Bean31To60DaysOrLessWithChildAndAdultsSize+q22Bean61To180DaysOrLessWithChildAndAdultsSize+q22Bean181To365DaysOrLessWithChildAndAdultsSize+q22Bean366To730DaysOrLessWithChildAndAdultsSize+q22Bean731To1095DDaysOrLessWithChildAndAdultsSize;
				int totalWithChildrenSize = q22Bean7DaysOrLessWithChildrenSize+q22Bean8To14DaysOrLessWithChildrenSize+q22Bean15To21DaysOrLessWithChildrenSize+q22Bean22To30DaysOrLessWithChildrenSize+q22Bean31To60DaysOrLessWithChildrenSize+q22Bean61To180DaysOrLessWithChildrenSize+q22Bean181To365DaysOrLessWithChildrenSize+q22Bean366To730DaysOrLessWithChildrenSize+q22Bean731To1095DDaysOrLessWithChildrenSize;
				int totalUnknownSize = q22Bean7DaysOrLessUnknownSize+q22Bean8To14DaysOrLessUnknownSize+q22Bean15To21DaysOrLessUnknownSize+q22Bean22To30DaysOrLessUnknownSize+q22Bean31To60DaysOrLessUnknownSize+q22Bean61To180DaysOrLessUnknownSize+q22Bean181To365DaysOrLessUnknownSize+q22Bean366To730DaysOrLessUnknownSize+q22Bean731To1095DDaysOrLessUnknownSize;
	
				q22deDataBean.setQ22ePersonsMovedIntoHousingTotal(BigInteger.valueOf(totalAllDataSize));
				q22deDataBean.setQ22ePersonsMovedIntoHousingWithOnlychildren(BigInteger.valueOf(totalWithChildrenSize));
				q22deDataBean.setQ22ePersonsMovedIntoHousingWithoutChildren(BigInteger.valueOf(totalWithoutChildrenSize));
				q22deDataBean.setQ22ePersonsMovedIntoHousingWithChildAndAdults(BigInteger.valueOf(totalChildAndAdultsSize));
				q22deDataBean.setQ22ePersonsMovedIntoHousingUnknowHousehold(BigInteger.valueOf(totalUnknownSize));
				
				List<Q22BeanModel>  notYetMovedIntoHousingAllData = allData.parallelStream().filter(q22BeanModel -> q22BeanModel.isNotYetMovedIntoHousing() ).collect(Collectors.toList());
				List<Q22BeanModel>  notYetMovedIntoHousingWithoutChildren = withoutChildren.parallelStream().filter(q22BeanModel ->  q22BeanModel.isNotYetMovedIntoHousing()).collect(Collectors.toList());
				List<Q22BeanModel>  notYetMovedIntoHousingWithChildAndAdults = withChildAndAdults.parallelStream().filter(q22BeanModel -> q22BeanModel.isNotYetMovedIntoHousing()).collect(Collectors.toList());
				List<Q22BeanModel>  notYetMovedIntoHousingWithChildren = withChildren.parallelStream().filter(q22BeanModel -> q22BeanModel.isNotYetMovedIntoHousing()).collect(Collectors.toList());
				List<Q22BeanModel>  notYetMovedIntoHousingLessUnknown = unknown.parallelStream().filter(q22BeanModel -> q22BeanModel.isNotYetMovedIntoHousing()).collect(Collectors.toList());
					
				int notYetMovedIntoHousingAllDataSize = getSize(notYetMovedIntoHousingAllData);
				int notYetMovedIntoHousingWithoutChildrenSize = getSize(notYetMovedIntoHousingWithoutChildren);
				int notYetMovedIntoHousingWithChildAndAdultsSize = getSize(notYetMovedIntoHousingWithChildAndAdults);
				int notYetMovedIntoHousingWithChildrenSize =  getSize(notYetMovedIntoHousingWithChildren);
				int notYetMovedIntoHousingLessUnknownSize = getSize(notYetMovedIntoHousingLessUnknown);
				
				q22deDataBean.setQ22eNotYetMovedIntoHousingTotal(BigInteger.valueOf(notYetMovedIntoHousingAllDataSize));
				q22deDataBean.setQ22eNotYetMovedIntoHousingWithOnlychildren(BigInteger.valueOf(notYetMovedIntoHousingWithoutChildrenSize));
				q22deDataBean.setQ22eNotYetMovedIntoHousingWithoutChildren(BigInteger.valueOf(notYetMovedIntoHousingWithChildAndAdultsSize));
				q22deDataBean.setQ22eNotYetMovedIntoHousingWithChildAndAdults(BigInteger.valueOf(notYetMovedIntoHousingWithChildrenSize));
				q22deDataBean.setQ22eNotYetMovedIntoHousingUnknowHousehold(BigInteger.valueOf(notYetMovedIntoHousingLessUnknownSize));
				
				
				List<Q22BeanModel>  dncAllData = allData.parallelStream().filter(q22BeanModel -> q22BeanModel.isDataNotCollected() ).collect(Collectors.toList());
				List<Q22BeanModel>  dncWithoutChildren = withoutChildren.parallelStream().filter(q22BeanModel ->  q22BeanModel.isDataNotCollected()).collect(Collectors.toList());
				List<Q22BeanModel>  dncWithChildAndAdults = withChildAndAdults.parallelStream().filter(q22BeanModel -> q22BeanModel.isDataNotCollected()).collect(Collectors.toList());
				List<Q22BeanModel>  dncWithChildren = withChildren.parallelStream().filter(q22BeanModel -> q22BeanModel.isDataNotCollected()).collect(Collectors.toList());
				List<Q22BeanModel>  dncUnknown = unknown.parallelStream().filter(q22BeanModel -> q22BeanModel.isDataNotCollected()).collect(Collectors.toList());
					
				int dncAllDataSize = dncAllData != null ? dncAllData.size() :0;
				int dncWithoutChildrenSize = dncWithoutChildren != null ? dncWithoutChildren.size() : 0;
				int dncWithChildAndAdultsSize = dncWithChildAndAdults != null ? dncWithChildAndAdults.size() :0;
				int dncWithChildrenSize =  dncWithChildren != null ? dncWithChildren.size() : 0;
				int dncUnknownSize = dncUnknown != null ? dncUnknown.size() : 0;
			
				q22deDataBean.setQ22eDNCTotal(BigInteger.valueOf(dncAllDataSize));
				q22deDataBean.setQ22eDNCWithoutChildren(BigInteger.valueOf(dncWithoutChildrenSize));
				q22deDataBean.setQ22eDNCWithChildAndAdults(BigInteger.valueOf(dncWithChildAndAdultsSize));
				q22deDataBean.setQ22eDNCWithOnlychildren(BigInteger.valueOf(dncWithChildrenSize));
				q22deDataBean.setQ22eDNCUnknowHousehold(BigInteger.valueOf(dncUnknownSize));
				
				
				int overallSize = totalAllDataSize + notYetMovedIntoHousingAllDataSize + dncAllDataSize;
				int overallWithoutChildrenSize = totalWithoutChildrenSize + notYetMovedIntoHousingWithoutChildrenSize + dncWithoutChildrenSize;
				int overallChildAndAdultsSize = totalChildAndAdultsSize + notYetMovedIntoHousingWithChildAndAdultsSize + dncWithChildAndAdultsSize;
				int overallWithChildrenSize = totalWithChildrenSize + notYetMovedIntoHousingWithChildrenSize + dncWithChildrenSize ;
				int overallUnknownSize = totalUnknownSize + notYetMovedIntoHousingLessUnknownSize + dncUnknownSize ;
				
				q22deDataBean.setQ22eTotTotal(BigInteger.valueOf(getSize(data.getClients()))); 
				q22deDataBean.setQ22eTotWithoutChildren(BigInteger.valueOf(overallWithoutChildrenSize));
				q22deDataBean.setQ22eTotWithChildAndAdults(BigInteger.valueOf(overallChildAndAdultsSize));
				q22deDataBean.setQ22eTotWithOnlychildren(BigInteger.valueOf(overallWithChildrenSize));
				q22deDataBean.setQ22eTotUnknowHousehold(BigInteger.valueOf(overallUnknownSize));
			}
		}catch(Exception e){
			logger.error("Error in Q22eLengthOfParticipationByHouseholdTypeDataBeanMaker:" + e);
		}	
		
		return Arrays.asList(q22deDataBean);
	}
	
    
    public static List<Q22BeanModel> getQ22EBeanLengthOfStay(ReportData data,String query,List<String> filteredProjectIds, boolean allProjects,boolean withDestination) {
		 List<Q22BeanModel> q22Beans = new ArrayList<Q22BeanModel>();
		 List<EnrollmentModel> enrollments = data.getAdultLeavers();
		 if(CollectionUtils.isEmpty(filteredProjectIds) && !allProjects)
		 {
			 return q22Beans;
		 }
		 if(CollectionUtils.isEmpty(enrollments)) {
			 return q22Beans;
		 }
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
				 if(CollectionUtils.isNotEmpty(filteredProjectIds)) {
					 newQuery = query.replace("%p", builder.toString());
				 }else {
					 newQuery = query.replace("%p", " ");
				 }
				
				 StringBuilder enrollmentBuilder = new StringBuilder(" and e.id in  ( ");
					 if(CollectionUtils.isNotEmpty(enrollments)) {
						 int index = 0;
						 for(EnrollmentModel enrollment : enrollments) {
							 enrollmentBuilder.append("'"+enrollment.getProjectEntryID()+"'");
							 if(index != enrollments.size()) {
								 enrollmentBuilder.append(",");
							 }
						 }
					 }
					 enrollmentBuilder.deleteCharAt(enrollmentBuilder.length() -1);
					 enrollmentBuilder.append(" ) ");
					String finalQuery = newQuery.replace("%e", enrollmentBuilder.toString());
				statement = connection.createStatement();
				resultSet = statement.executeQuery(formatQuery(finalQuery,data.getSchema(),data));
				
			 while(resultSet.next()) {
				 Date entryDate = resultSet.getDate("entrydate");
				 Date moveinDate = resultSet.getDate("moveindate");
				 
				 Q22BeanModel bean = new Q22BeanModel(resultSet.getString("dedup_client_id"), resultSet.getString("trackingmethod"),resultSet.getString("projecttype"), 
						 resultSet.getDate("datetostreetessh"),resultSet.getDate("exitdate"),entryDate,moveinDate,null);
				 populateLengthOfStay(bean, data);
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


	private static void populateLengthOfStay(Q22BeanModel bean, ReportData data) {
		Date datetostreetessh = bean.getOperatingStartDate();
		Date entrydate = bean.getEntrydate();
		Date moveInDate = bean.getMoveInDate();
		if(datetostreetessh != null) {
			if(entrydate != null) {
				long lengthOfStay = subtractDate(datetostreetessh, entrydate);
				bean.setNumberOfDays(lengthOfStay);
			}
			if(StringUtils.equals("3",bean.getProjectType()) || StringUtils.equals("9",bean.getProjectType()) || StringUtils.equals("13",bean.getProjectType())) {
				if(moveInDate != null) {
					long lengthOfStay = subtractDate(moveInDate, entrydate);
					bean.setNumberOfDays(lengthOfStay);
				}else {
					bean.setNotYetMovedIntoHousing(true);
				}
			}
		} else {
			bean.setDataNotCollected(true); // for 13
		}
	}	
}
