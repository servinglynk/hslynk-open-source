package com.servinglynk.report.business;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;

import com.servinglynk.hive.connection.ImpalaConnection;
import com.servinglynk.report.bean.Q22dLengthOfParticipationByHouseholdTypeDataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.Q22BeanModel;

public class Q22dLengthOfParticipationByHouseholdTypeDataBeanMaker extends BaseBeanMaker {
	
	public static List<Q22dLengthOfParticipationByHouseholdTypeDataBean> getQ22dLengthOfParticipationByHouseholdTypeDataBeanList(ReportData data){
	
		String query = "select  e.dedup_client_id ,p.projecttype,p.trackingmethod,p.operatingstartdate,ext.exitdate,e.entrydate,mid.moveindate, from %s.enrollment e join %s.project p  on (e.projectid = p.id %p"+
				" left outer join  %s.exit ext  on  (ext.enrollmentid = e.id and  e.entrydate <= ? and (ext.exitdate is null  or ext.exitdate > ?) ) "+
				" left outer join  %s.moveindate mid  on  (mid.enrollmentid = e.id) "+
				" order by e.dedup_client_id,p.operatingstartdate asc ";

		
		Q22dLengthOfParticipationByHouseholdTypeDataBean q22dLengthOfParticipationByHouseholdTypeTable =new Q22dLengthOfParticipationByHouseholdTypeDataBean();
		
		try {
			if(data.isLiveMode()) {
				
				List<Q22BeanModel> allData = getQ22Bean(data, query, null,true);
				List<Q22BeanModel> withoutChildren = getQ22Bean(data, query, data.getProjectsHHWithOutChildren(),false);
				List<Q22BeanModel> withChildAndAdults = getQ22Bean(data, query, data.getProjectsHHWithOneAdultChild(),false);
				List<Q22BeanModel> withChildren = getQ22Bean(data, query, data.getProjectsHHWithChildren(),false);
				List<Q22BeanModel> unknown = getQ22Bean(data, query, data.getProjectsUnknownHouseHold(),false);
				
				List<Q22BeanModel>  q22Bean7DaysOrLessAllData = allData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() <= 7).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean7DaysOrLessWithoutChildren = withoutChildren.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() <= 7).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean7DaysOrLessWithChildAndAdults = withChildAndAdults.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() <= 7).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean7DaysOrLessWithChildren = withChildren.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() <= 7).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean7DaysOrLessUnknown = unknown.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() <= 7).collect(Collectors.toList());
					
				q22dLengthOfParticipationByHouseholdTypeTable.setQ22d7DaysLessTotal(BigInteger.valueOf(q22Bean7DaysOrLessAllData != null ? q22Bean7DaysOrLessAllData.size() :0));
				q22dLengthOfParticipationByHouseholdTypeTable.setQ22d7DaysLessWithoutChildren(BigInteger.valueOf(q22Bean7DaysOrLessWithoutChildren != null ? q22Bean7DaysOrLessWithoutChildren.size() : 0));
				q22dLengthOfParticipationByHouseholdTypeTable.setQ22d7DaysLessWithChildAndAdults(BigInteger.valueOf(q22Bean7DaysOrLessWithChildAndAdults != null ? q22Bean7DaysOrLessWithChildAndAdults.size() :0));
				q22dLengthOfParticipationByHouseholdTypeTable.setQ22d7DaysLessWithOnlychildren(BigInteger.valueOf(q22Bean7DaysOrLessWithChildren != null ? q22Bean7DaysOrLessWithChildren.size() : 0));
				q22dLengthOfParticipationByHouseholdTypeTable.setQ22d7DaysLessUnknowHousehold(BigInteger.valueOf(q22Bean7DaysOrLessUnknown != null ? q22Bean7DaysOrLessUnknown.size() : 0));
				
				List<Q22BeanModel>  q22Bean8To14DaysOrLessAllData = allData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 8 && q22BeanModel.getNumberOfDays() <= 14).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean8To14DaysOrLessWithoutChildren = withoutChildren.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 8 && q22BeanModel.getNumberOfDays() <= 14).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean8To14DaysOrLessWithChildAndAdults = withChildAndAdults.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 8 && q22BeanModel.getNumberOfDays() <= 14).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean8To14DaysOrLessWithChildren = withChildren.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 8 && q22BeanModel.getNumberOfDays() <= 14).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean8To14DaysOrLessUnknown = unknown.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 8 && q22BeanModel.getNumberOfDays() <= 14).collect(Collectors.toList());
				
				q22dLengthOfParticipationByHouseholdTypeTable.setQ22d8To14DaysTotal(BigInteger.valueOf(q22Bean8To14DaysOrLessAllData !=null ? q22Bean8To14DaysOrLessAllData.size() :0));
				q22dLengthOfParticipationByHouseholdTypeTable.setQ22d8To14DaysWithoutChildren(BigInteger.valueOf(q22Bean8To14DaysOrLessWithoutChildren != null ? q22Bean8To14DaysOrLessWithoutChildren.size() : 0));
				q22dLengthOfParticipationByHouseholdTypeTable.setQ22d8To14DaysWithChildAndAdults(BigInteger.valueOf(q22Bean8To14DaysOrLessWithChildAndAdults != null ? q22Bean8To14DaysOrLessWithChildAndAdults.size() : 0));
				q22dLengthOfParticipationByHouseholdTypeTable.setQ22d8To14DaysWithOnlychildren(BigInteger.valueOf(q22Bean8To14DaysOrLessWithChildren != null ? q22Bean8To14DaysOrLessWithChildren.size() : 0));
				q22dLengthOfParticipationByHouseholdTypeTable.setQ22d8To14DaysUnknowHousehold(BigInteger.valueOf(q22Bean8To14DaysOrLessUnknown != null ? q22Bean8To14DaysOrLessUnknown.size() : 0));
				
				List<Q22BeanModel>  q22Bean15To21DaysOrLessAllData = allData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 15 && q22BeanModel.getNumberOfDays() <= 21).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean15To21DaysOrLessWithoutChildren = withoutChildren.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 15 && q22BeanModel.getNumberOfDays() <= 21).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean15To21DaysOrLessWithChildAndAdults = withChildAndAdults.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 15 && q22BeanModel.getNumberOfDays() <= 21).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean15To21DaysOrLessWithChildren = withChildren.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 15 && q22BeanModel.getNumberOfDays() <= 21).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean15To21DaysOrLessUnknown = unknown.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 15 && q22BeanModel.getNumberOfDays() <= 21).collect(Collectors.toList());
				
				q22dLengthOfParticipationByHouseholdTypeTable.setQ22d15To21DaysTotal(BigInteger.valueOf(q22Bean15To21DaysOrLessAllData != null ? q22Bean15To21DaysOrLessAllData.size() : 0));
				q22dLengthOfParticipationByHouseholdTypeTable.setQ22d15To21DaysWithoutChildren(BigInteger.valueOf(q22Bean15To21DaysOrLessWithoutChildren != null ? q22Bean15To21DaysOrLessWithoutChildren.size() : 0));
				q22dLengthOfParticipationByHouseholdTypeTable.setQ22d15To21DaysWithChildAndAdults(BigInteger.valueOf(q22Bean15To21DaysOrLessWithChildAndAdults != null ? q22Bean15To21DaysOrLessWithChildAndAdults.size() : 0));
				q22dLengthOfParticipationByHouseholdTypeTable.setQ22d15To21DaysWithOnlychildren(BigInteger.valueOf(q22Bean15To21DaysOrLessWithChildren != null ? q22Bean15To21DaysOrLessWithChildren.size() : 0 ));
				q22dLengthOfParticipationByHouseholdTypeTable.setQ22d15To21DaysUnknowHousehold(BigInteger.valueOf(q22Bean15To21DaysOrLessUnknown != null ? q22Bean15To21DaysOrLessUnknown.size() : 0));
				
				List<Q22BeanModel>  q22Bean22To30DaysOrLessAllData = allData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 22 && q22BeanModel.getNumberOfDays() <= 30).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean22To30DaysOrLessWithoutChildren = withoutChildren.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 22 && q22BeanModel.getNumberOfDays() <= 30).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean22To30DaysOrLessWithChildAndAdults = withChildAndAdults.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 22 && q22BeanModel.getNumberOfDays() <= 30).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean22To30DaysOrLessWithChildren = withChildren.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 22 && q22BeanModel.getNumberOfDays() <= 30).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean22To30DaysOrLessUnknown = unknown.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 22 && q22BeanModel.getNumberOfDays() <= 30).collect(Collectors.toList());
				
				q22dLengthOfParticipationByHouseholdTypeTable.setQ22d22To30DaysTotal(BigInteger.valueOf(q22Bean22To30DaysOrLessAllData != null ? q22Bean22To30DaysOrLessAllData.size(): 0));
				q22dLengthOfParticipationByHouseholdTypeTable.setQ22d22To30DaysWithoutChildren(BigInteger.valueOf(q22Bean22To30DaysOrLessWithoutChildren != null ? q22Bean22To30DaysOrLessWithoutChildren.size(): 0));
				q22dLengthOfParticipationByHouseholdTypeTable.setQ22d22To30DaysWithChildAndAdults(BigInteger.valueOf(q22Bean22To30DaysOrLessWithChildAndAdults !=null ? q22Bean22To30DaysOrLessWithChildAndAdults.size() : 0));
				q22dLengthOfParticipationByHouseholdTypeTable.setQ22d22To30DaysWithOnlychildren(BigInteger.valueOf(q22Bean22To30DaysOrLessWithChildren != null ? q22Bean22To30DaysOrLessWithChildren.size() : 0));
				q22dLengthOfParticipationByHouseholdTypeTable.setQ22d22To30DaysUnknowHousehold(BigInteger.valueOf(q22Bean22To30DaysOrLessUnknown !=null ? q22Bean22To30DaysOrLessUnknown.size() : 0));
				
				List<Q22BeanModel>  q22Bean31To60DaysOrLessAllData = allData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 31 && q22BeanModel.getNumberOfDays() <= 60).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean31To60DaysOrLessWithoutChildren = withoutChildren.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 31 && q22BeanModel.getNumberOfDays() <= 60).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean31To60DaysOrLessWithChildAndAdults = withChildAndAdults.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 31 && q22BeanModel.getNumberOfDays() <= 60).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean31To60DaysOrLessWithChildren = withChildren.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 31 && q22BeanModel.getNumberOfDays() <= 60).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean31To60DaysOrLessUnknown = unknown.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 31 && q22BeanModel.getNumberOfDays() <= 60).collect(Collectors.toList());
				
				q22dLengthOfParticipationByHouseholdTypeTable.setQ22d31To60DaysTotal(BigInteger.valueOf(q22Bean31To60DaysOrLessAllData != null ? q22Bean31To60DaysOrLessAllData.size() : 0));
				q22dLengthOfParticipationByHouseholdTypeTable.setQ22d31To60DaysWithoutChildren(BigInteger.valueOf(q22Bean31To60DaysOrLessWithoutChildren != null ? q22Bean31To60DaysOrLessWithoutChildren.size() : 0));
				q22dLengthOfParticipationByHouseholdTypeTable.setQ22d31To60DaysWithChildAndAdults(BigInteger.valueOf(q22Bean31To60DaysOrLessWithChildAndAdults != null ? q22Bean31To60DaysOrLessWithChildAndAdults.size() :0));
				q22dLengthOfParticipationByHouseholdTypeTable.setQ22d31To60DaysWithOnlychildren(BigInteger.valueOf(q22Bean31To60DaysOrLessWithChildren != null ? q22Bean31To60DaysOrLessWithChildren.size() : 0));
				q22dLengthOfParticipationByHouseholdTypeTable.setQ22d31To60DaysUnknowHousehold(BigInteger.valueOf(q22Bean31To60DaysOrLessUnknown != null ? q22Bean31To60DaysOrLessUnknown.size() : 0));
				
				List<Q22BeanModel>  q22Bean61To180DaysOrLessAllData = allData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 61 && q22BeanModel.getNumberOfDays() <= 180).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean61To180DaysOrLessWithoutChildren = withoutChildren.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 61 && q22BeanModel.getNumberOfDays() <= 180).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean61To180DaysOrLessWithChildAndAdults = withChildAndAdults.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 61 && q22BeanModel.getNumberOfDays() <= 180).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean61To180DaysOrLessWithChildren = withChildren.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 61 && q22BeanModel.getNumberOfDays() <= 180).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean61To180DaysOrLessUnknown = unknown.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 61 && q22BeanModel.getNumberOfDays() <= 180).collect(Collectors.toList());
			
				q22dLengthOfParticipationByHouseholdTypeTable.setQ22d61To180DaysTotal(BigInteger.valueOf(q22Bean61To180DaysOrLessAllData != null ? q22Bean61To180DaysOrLessAllData.size() : 0));
				q22dLengthOfParticipationByHouseholdTypeTable.setQ22d61To180DaysWithoutChildren(BigInteger.valueOf(q22Bean61To180DaysOrLessWithoutChildren != null ? q22Bean61To180DaysOrLessWithoutChildren.size() : 0));
				q22dLengthOfParticipationByHouseholdTypeTable.setQ22d61To180DaysWithChildAndAdults(BigInteger.valueOf(q22Bean61To180DaysOrLessWithChildAndAdults != null ? q22Bean61To180DaysOrLessWithChildAndAdults.size() : 0));
				q22dLengthOfParticipationByHouseholdTypeTable.setQ22d61To180DaysWithOnlychildren(BigInteger.valueOf(q22Bean61To180DaysOrLessWithChildren != null ? q22Bean61To180DaysOrLessWithChildren.size() : 0 ));
				q22dLengthOfParticipationByHouseholdTypeTable.setQ22d61To180DaysUnknowHousehold(BigInteger.valueOf(q22Bean61To180DaysOrLessUnknown != null ? q22Bean61To180DaysOrLessUnknown.size() : 0));
				
				List<Q22BeanModel>  q22Bean181To365DaysOrLessAllData = allData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 181 && q22BeanModel.getNumberOfDays() <= 365).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean181To365DaysOrLessWithoutChildren = withoutChildren.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 181 && q22BeanModel.getNumberOfDays() <= 365).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean181To365DaysOrLessWithChildAndAdults = withChildAndAdults.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 181 && q22BeanModel.getNumberOfDays() <= 365).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean181To365DaysOrLessWithChildren = withChildren.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 181 && q22BeanModel.getNumberOfDays() <= 365).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean181To365DaysOrLessUnknown = unknown.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 181 && q22BeanModel.getNumberOfDays() <= 365).collect(Collectors.toList());
				
				q22dLengthOfParticipationByHouseholdTypeTable.setQ22d181To365DaysTotal(BigInteger.valueOf(q22Bean181To365DaysOrLessAllData != null ? q22Bean181To365DaysOrLessAllData.size() : 0));
				q22dLengthOfParticipationByHouseholdTypeTable.setQ22d181To365DaysWithoutChildren(BigInteger.valueOf(q22Bean181To365DaysOrLessWithoutChildren != null ? q22Bean181To365DaysOrLessWithoutChildren.size() :0 ));
				q22dLengthOfParticipationByHouseholdTypeTable.setQ22d181To365DaysWithChildAndAdults(BigInteger.valueOf(q22Bean181To365DaysOrLessWithChildAndAdults != null ? q22Bean181To365DaysOrLessWithChildAndAdults.size() :0));
				q22dLengthOfParticipationByHouseholdTypeTable.setQ22d181To365DaysWithOnlychildren(BigInteger.valueOf(q22Bean181To365DaysOrLessWithChildren != null ? q22Bean181To365DaysOrLessWithChildren.size() : 0));
				q22dLengthOfParticipationByHouseholdTypeTable.setQ22d181To365DaysUnknowHousehold(BigInteger.valueOf(q22Bean181To365DaysOrLessUnknown != null ? q22Bean181To365DaysOrLessUnknown.size() : 0));
				
				List<Q22BeanModel>  q22Bean366To730DaysOrLessAllData = allData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 366 && q22BeanModel.getNumberOfDays() <= 730).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean366To730DaysOrLessWithoutChildren = withoutChildren.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 366 && q22BeanModel.getNumberOfDays() <= 730).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean366To730DaysOrLessWithChildAndAdults = withChildAndAdults.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 366 && q22BeanModel.getNumberOfDays() <= 730).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean366To730DaysOrLessWithChildren = withChildren.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 366 && q22BeanModel.getNumberOfDays() <= 730).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean366To730DaysOrLessUnknown = unknown.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 366 && q22BeanModel.getNumberOfDays() <= 730).collect(Collectors.toList());
			
				q22dLengthOfParticipationByHouseholdTypeTable.setQ22d366To730DaysTotal(BigInteger.valueOf(q22Bean366To730DaysOrLessAllData != null ? q22Bean366To730DaysOrLessAllData.size() :0));
				q22dLengthOfParticipationByHouseholdTypeTable.setQ22d366To730DaysWithoutChildren(BigInteger.valueOf(q22Bean366To730DaysOrLessWithoutChildren != null ? q22Bean366To730DaysOrLessWithoutChildren.size() : 0));
				q22dLengthOfParticipationByHouseholdTypeTable.setQ22d366To730DaysWithChildAndAdults(BigInteger.valueOf(q22Bean366To730DaysOrLessWithChildAndAdults != null ? q22Bean366To730DaysOrLessWithChildAndAdults.size() : 0));
				q22dLengthOfParticipationByHouseholdTypeTable.setQ22d366To730DaysWithOnlychildren(BigInteger.valueOf(q22Bean366To730DaysOrLessWithChildren != null ? q22Bean366To730DaysOrLessWithChildren.size() : 0));
				q22dLengthOfParticipationByHouseholdTypeTable.setQ22d366To730DaysUnknowHousehold(BigInteger.valueOf(q22Bean366To730DaysOrLessUnknown != null ? q22Bean366To730DaysOrLessUnknown.size() : 0));
				
				List<Q22BeanModel>  q22Bean731To1095DaysOrLessAllData = allData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 731 && q22BeanModel.getNumberOfDays() <= 1095).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean731To1095DDaysOrLessWithoutChildren = withoutChildren.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 731 && q22BeanModel.getNumberOfDays() <= 1095).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean731To1095DDaysOrLessWithChildAndAdults = withChildAndAdults.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 731 && q22BeanModel.getNumberOfDays() <= 1095).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean731To1095DDaysOrLessWithChildren = withChildren.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 731 && q22BeanModel.getNumberOfDays() <= 1095).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean731To1095DDaysOrLessUnknown = unknown.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 731 && q22BeanModel.getNumberOfDays() <= 1095).collect(Collectors.toList());
			
				q22dLengthOfParticipationByHouseholdTypeTable.setQ22d731To1095DaysTotal(BigInteger.valueOf(q22Bean731To1095DaysOrLessAllData != null ? q22Bean731To1095DaysOrLessAllData.size() : 0));
				q22dLengthOfParticipationByHouseholdTypeTable.setQ22d731To1095DaysWithoutChildren(BigInteger.valueOf(q22Bean731To1095DDaysOrLessWithoutChildren != null ? q22Bean731To1095DDaysOrLessWithoutChildren.size() : 0));
				q22dLengthOfParticipationByHouseholdTypeTable.setQ22d731To1095DaysWithChildAndAdults(BigInteger.valueOf(q22Bean731To1095DDaysOrLessWithChildAndAdults != null ? q22Bean731To1095DDaysOrLessWithChildAndAdults.size() : 0));
				q22dLengthOfParticipationByHouseholdTypeTable.setQ22d731To1095DaysWithOnlychildren(BigInteger.valueOf(q22Bean731To1095DDaysOrLessWithChildren != null ? q22Bean731To1095DDaysOrLessWithChildren.size() : 0));
				q22dLengthOfParticipationByHouseholdTypeTable.setQ22d731To1095DaysUnknowHousehold(BigInteger.valueOf(q22Bean731To1095DDaysOrLessUnknown != null ? q22Bean731To1095DDaysOrLessUnknown.size() : 0));
				
				List<Q22BeanModel>  q22Bean1096To1460DaysOrLessAllData = allData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 1096 && q22BeanModel.getNumberOfDays() <= 1460).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean1096To1460DDaysOrLessWithoutChildren = withoutChildren.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 1096 && q22BeanModel.getNumberOfDays() <= 1460).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean1096To1460DDaysOrLessWithChildAndAdults = withChildAndAdults.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 1096 && q22BeanModel.getNumberOfDays() <= 1460).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean1096To1460DDaysOrLessWithChildren = withChildren.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 1096 && q22BeanModel.getNumberOfDays() <= 1460).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean1096To1460DDaysOrLessUnknown = unknown.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 1096 && q22BeanModel.getNumberOfDays() <= 1460).collect(Collectors.toList());
			
				q22dLengthOfParticipationByHouseholdTypeTable.setQ22d1096To1460DaysTotal(BigInteger.valueOf(q22Bean1096To1460DaysOrLessAllData != null ? q22Bean1096To1460DaysOrLessAllData.size() : 0));
				q22dLengthOfParticipationByHouseholdTypeTable.setQ22d1096To1460DaysWithoutChildren(BigInteger.valueOf(q22Bean1096To1460DDaysOrLessWithoutChildren != null ? q22Bean1096To1460DDaysOrLessWithoutChildren.size() :0));
				q22dLengthOfParticipationByHouseholdTypeTable.setQ22d1096To1460DaysWithChildAndAdults(BigInteger.valueOf(q22Bean1096To1460DDaysOrLessWithChildAndAdults != null ? q22Bean1096To1460DDaysOrLessWithChildAndAdults.size() : 0));
				q22dLengthOfParticipationByHouseholdTypeTable.setQ22d1096To1460DaysWithOnlychildren(BigInteger.valueOf(q22Bean1096To1460DDaysOrLessWithChildren != null ? q22Bean1096To1460DDaysOrLessWithChildren.size() :0));
				q22dLengthOfParticipationByHouseholdTypeTable.setQ22d1096To1460DaysUnknowHousehold(BigInteger.valueOf(q22Bean1096To1460DDaysOrLessUnknown != null ? q22Bean1096To1460DDaysOrLessUnknown.size() :0));
				
				List<Q22BeanModel>  q22Bean1461To1825DaysOrLessAllData = allData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 1461 && q22BeanModel.getNumberOfDays() <= 1825).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean1461To1825DDaysOrLessWithoutChildren = withoutChildren.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 1461 && q22BeanModel.getNumberOfDays() <= 1825).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean1461To1825DaysOrLessWithChildAndAdults = withChildAndAdults.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 1461 && q22BeanModel.getNumberOfDays() <= 1825).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean1461To1825DaysOrLessWithChildren = withChildren.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 1461 && q22BeanModel.getNumberOfDays() <= 1825).collect(Collectors.toList());
				List<Q22BeanModel>  q22Bean1461To1825DaysOrLessUnknown = unknown.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 1461 && q22BeanModel.getNumberOfDays() <= 1825).collect(Collectors.toList());
				
				q22dLengthOfParticipationByHouseholdTypeTable.setQ22d1461To1825DaysTotal(BigInteger.valueOf(q22Bean1461To1825DaysOrLessAllData != null ? q22Bean1461To1825DaysOrLessAllData.size() : 0));
				q22dLengthOfParticipationByHouseholdTypeTable.setQ22d1461To1825DaysWithoutChildren(BigInteger.valueOf(q22Bean1461To1825DDaysOrLessWithoutChildren != null ? q22Bean1461To1825DDaysOrLessWithoutChildren.size() : 0));
				q22dLengthOfParticipationByHouseholdTypeTable.setQ22d1461To1825DaysWithChildAndAdults(BigInteger.valueOf(q22Bean1461To1825DaysOrLessWithChildAndAdults != null ? q22Bean1461To1825DaysOrLessWithChildAndAdults.size() : 0));
				q22dLengthOfParticipationByHouseholdTypeTable.setQ22d1461To1825DaysWithOnlychildren(BigInteger.valueOf(q22Bean1461To1825DaysOrLessWithChildren != null ? q22Bean1461To1825DaysOrLessWithChildren.size() : 0));
				q22dLengthOfParticipationByHouseholdTypeTable.setQ22d1461To1825DaysUnknowHousehold(BigInteger.valueOf(q22Bean1461To1825DaysOrLessUnknown != null ? q22Bean1461To1825DaysOrLessUnknown.size() :0));
				
				List<Q22BeanModel>  q22BeanMoreThan1825DaysOrLessAllData = allData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 1825 ).collect(Collectors.toList());
				List<Q22BeanModel>  q22BeanMoreThan1825DaysOrLessWithoutChildren = withoutChildren.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 1825).collect(Collectors.toList());
				List<Q22BeanModel>  q22BeanMoreThan1825DaysOrLessWithChildAndAdults = withChildAndAdults.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 1461 && q22BeanModel.getNumberOfDays() <= 1825).collect(Collectors.toList());
				List<Q22BeanModel>  q22BeanMoreThan1825DaysOrLessWithChildren = withChildren.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 1825).collect(Collectors.toList());
				List<Q22BeanModel>  q22BeanMoreThan1825DaysOrLessUnknown = unknown.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 1825).collect(Collectors.toList());
				
				q22dLengthOfParticipationByHouseholdTypeTable.setQ22dMoreThan1825DaysTotal(BigInteger.valueOf(q22BeanMoreThan1825DaysOrLessAllData != null ? q22BeanMoreThan1825DaysOrLessAllData.size() : 0));
				q22dLengthOfParticipationByHouseholdTypeTable.setQ22dMoreThan1825DaysWithoutChildren(BigInteger.valueOf(q22BeanMoreThan1825DaysOrLessWithoutChildren != null ? q22BeanMoreThan1825DaysOrLessWithoutChildren.size() : 0));
				q22dLengthOfParticipationByHouseholdTypeTable.setQ22dMoreThan1825DaysWithChildAndAdults(BigInteger.valueOf(q22BeanMoreThan1825DaysOrLessWithChildAndAdults != null ? q22BeanMoreThan1825DaysOrLessWithChildAndAdults.size() : 0));
				q22dLengthOfParticipationByHouseholdTypeTable.setQ22dMoreThan1825DaysWithOnlychildren(BigInteger.valueOf(q22BeanMoreThan1825DaysOrLessWithChildren != null ? q22BeanMoreThan1825DaysOrLessWithChildren.size() : 0));
				q22dLengthOfParticipationByHouseholdTypeTable.setQ22dMoreThan1825DaysUnknowHousehold(BigInteger.valueOf(q22BeanMoreThan1825DaysOrLessUnknown != null ? q22BeanMoreThan1825DaysOrLessUnknown.size() : 0));
				
				q22dLengthOfParticipationByHouseholdTypeTable.setQ22dDNCTotal(BigInteger.valueOf(0));
				q22dLengthOfParticipationByHouseholdTypeTable.setQ22dDNCWithoutChildren(BigInteger.valueOf(0));
				q22dLengthOfParticipationByHouseholdTypeTable.setQ22dDNCWithChildAndAdults(BigInteger.valueOf(0));
				q22dLengthOfParticipationByHouseholdTypeTable.setQ22dDNCWithOnlychildren(BigInteger.valueOf(0));
				q22dLengthOfParticipationByHouseholdTypeTable.setQ22dDNCUnknowHousehold(BigInteger.valueOf(0));
				
				
				q22dLengthOfParticipationByHouseholdTypeTable.setQ22dTotTotal(data.getOverAllTotHouseHolds()); 
				q22dLengthOfParticipationByHouseholdTypeTable.setQ22dTotWithoutChildren(data.getTotHhWithoutChild());
				q22dLengthOfParticipationByHouseholdTypeTable.setQ22dTotWithChildAndAdults(data.getTotHhWithChildAndAdults());
				q22dLengthOfParticipationByHouseholdTypeTable.setQ22dTotWithOnlychildren(data.getTotHhWothOnlyChild());
				q22dLengthOfParticipationByHouseholdTypeTable.setQ22dTotUnknowHousehold(data.getTotHhUnknownHhType());
			}
		}catch(Exception e){
			logger.error("Error in Q22dLengthOfParticipationByHouseholdTypeDataBeanMaker:" + e);
		}	
		
		return Arrays.asList(q22dLengthOfParticipationByHouseholdTypeTable);
	}
	
	public static List<Q22BeanModel> getQ22Bean(ReportData data,String query,List<String> filteredProjectIds, boolean allProjects) {
		 List<Q22BeanModel> q22Beans = new ArrayList<Q22BeanModel>();
			ResultSet resultSet = null;
			PreparedStatement statement = null;
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
				 builder.append(" ) ");
				String newQuery = query.replace("%p", builder.toString());
				statement = connection.prepareStatement(formatQuery(newQuery,data.getSchema()));
				statement.setDate(1, data.getReportStartDate());
				statement.setDate(2, data.getReportEndDate());
				resultSet = statement.executeQuery();
				
			 while(resultSet.next()) {
				 Date entryDate = resultSet.getDate("entrydate");
				 Date moveinDate = resultSet.getDate("moveindate");
				 
				 Q22BeanModel bean = new Q22BeanModel(resultSet.getString("dedup_client_id"), null,null, 
						 null,resultSet.getDate("exitdate"),entryDate,moveinDate,resultSet.getDate("dateprovided") );
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
