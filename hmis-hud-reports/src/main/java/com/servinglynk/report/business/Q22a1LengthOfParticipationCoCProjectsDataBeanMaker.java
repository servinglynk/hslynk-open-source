package com.servinglynk.report.business;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.servinglynk.hive.connection.ImpalaConnection;
import com.servinglynk.report.bean.Q22a1LengthOfParticipationCoCProjectsDataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.Q22BeanModel;

public class Q22a1LengthOfParticipationCoCProjectsDataBeanMaker extends BaseBeanMaker {

  	
	public static List<Q22a1LengthOfParticipationCoCProjectsDataBean> getQ22a1LengthOfParticipationCoCProjectsList(ReportData data){
		String allQuery = " select  e.dedup_client_id ,p.projecttype,p.trackingmethod,p.operatingstartdate,ext.exitdate,e.entrydate,mid.moveindate from %s.enrollment e join %s.project p  on (e.projectid = p.id %p"+
						" left outer join  %s.exit ext  on  (ext.enrollmentid = e.id) "+
						" left outer join  %s.moveindate mid  on  (mid.enrollmentid = e.id) "+
						" order by e.dedup_client_id,p.operatingstartdate asc ";
				
		String leaversQuery = "select  e.dedup_client_id ,p.projecttype,p.trackingmethod,p.operatingstartdate,ext.exitdate,e.entrydate,mid.moveindate from %s.enrollment e join %s.project p  on (e.projectid = p.id %p"+
						" join  %s.exit ext  on  (ext.enrollmentid = e.id and ext.exitdate >= ? and ext.exitdate <= ?) "+
						" left outer join  %s.moveindate mid  on  (mid.enrollmentid = e.id) "+
						" order by e.dedup_client_id,p.operatingstartdate asc ";
				
		String stayersQuery = "select  e.dedup_client_id ,p.projecttype,p.trackingmethod,p.operatingstartdate,ext.exitdate,e.entrydate,mid.moveindate, from %s.enrollment e join %s.project p  on (e.projectid = p.id %p"+
						" left outer join  %s.exit ext  on  (ext.enrollmentid = e.id and  e.entrydate <= ? and (ext.exitdate is null  or ext.exitdate > ?) ) "+
						" left outer join  %s.moveindate mid  on  (mid.enrollmentid = e.id) "+
						" order by e.dedup_client_id,p.operatingstartdate asc ";

		
	
	Q22a1LengthOfParticipationCoCProjectsDataBean q22a1LengthOfParticipationCoCProjectsTable = new Q22a1LengthOfParticipationCoCProjectsDataBean();
		try {
			if(data.isLiveMode()) {
				List<Q22BeanModel> allData = getQ22Bean(data, allQuery, "ALL");
				List<Q22BeanModel> allLeaversData = getQ22Bean(data, leaversQuery,"LEAVERS");
				List<Q22BeanModel> allStayersData = getQ22Bean(data, stayersQuery,"STAYERS");
				
				if(CollectionUtils.isNotEmpty(allData)) {
					allData.forEach(q22Bean -> populateBedNights(q22Bean, data));
					List<Q22BeanModel>  q22a130DaysOrLess = allData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() <= 30).collect(Collectors.toList());
					List<Q22BeanModel>  q22a1D31To60Days = allData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 31 &&  q22BeanModel.getNumberOfDays() <= 60).collect(Collectors.toList());
					List<Q22BeanModel>  q22a1D61To90Days = allData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() <= 61 && q22BeanModel.getNumberOfDays() >= 90).collect(Collectors.toList());
					List<Q22BeanModel>  q22a1D91To180Days = allData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() <= 91 && q22BeanModel.getNumberOfDays() >= 180).collect(Collectors.toList());
					List<Q22BeanModel>  q22a1E181To365Days = allData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() <= 1811 && q22BeanModel.getNumberOfDays() >= 365).collect(Collectors.toList());
					List<Q22BeanModel>  q22a1F366To730Days = allData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() <= 366 && q22BeanModel.getNumberOfDays() >= 730).collect(Collectors.toList());
					List<Q22BeanModel>  q22a1G731To1095Days = allData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() <= 731 && q22BeanModel.getNumberOfDays() >= 1095).collect(Collectors.toList());
					List<Q22BeanModel>  q22a1H1096To1460Days = allData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() <= 1096 && q22BeanModel.getNumberOfDays() >= 1460).collect(Collectors.toList());
					List<Q22BeanModel>  q22a1I1461To1825Days = allData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() <= 1461 && q22BeanModel.getNumberOfDays() >= 1825).collect(Collectors.toList());
					
					q22a1LengthOfParticipationCoCProjectsTable.setQ22a1A30DaysOrLessTotal(BigInteger.valueOf(q22a130DaysOrLess != null ? q22a130DaysOrLess.size(): 0));
					q22a1LengthOfParticipationCoCProjectsTable.setQ22a1B31To60DaysTotal(BigInteger.valueOf(q22a1D31To60Days != null ? q22a1D31To60Days.size() :0));
					q22a1LengthOfParticipationCoCProjectsTable.setQ22a1C61To90DaysTotal(BigInteger.valueOf(q22a1D61To90Days != null ? q22a1D61To90Days.size() :0));
					q22a1LengthOfParticipationCoCProjectsTable.setQ22a1D91To180DaysTotal(BigInteger.valueOf(q22a1D91To180Days != null ? q22a1D91To180Days.size() :0));
					q22a1LengthOfParticipationCoCProjectsTable.setQ22a1E181To365DaysTotal(BigInteger.valueOf(q22a1E181To365Days != null ? q22a1E181To365Days.size() :0));
					q22a1LengthOfParticipationCoCProjectsTable.setQ22a1F366To730DaysTotal(BigInteger.valueOf(q22a1F366To730Days != null ? q22a1F366To730Days.size() :0));
					q22a1LengthOfParticipationCoCProjectsTable.setQ22a1G731To1095DaysTotal(BigInteger.valueOf(q22a1G731To1095Days != null ? q22a1G731To1095Days.size() :0));
					q22a1LengthOfParticipationCoCProjectsTable.setQ22a1H1096To1460DaysTotal(BigInteger.valueOf(q22a1H1096To1460Days != null ? q22a1H1096To1460Days.size() :0));
					q22a1LengthOfParticipationCoCProjectsTable.setQ22a1I1461To1825DaysTotal(BigInteger.valueOf(q22a1I1461To1825Days != null ? q22a1I1461To1825Days.size() :0));
					q22a1LengthOfParticipationCoCProjectsTable.setQ22a1JMoreThan1825DaysTotal(BigInteger.valueOf(0));
					q22a1LengthOfParticipationCoCProjectsTable.setQ22a1KInfoMissingTotal(BigInteger.valueOf(0));
				}
				if(CollectionUtils.isNotEmpty(allLeaversData)) {
					allLeaversData.forEach(q22Bean -> populateBedNights(q22Bean, data));
					List<Q22BeanModel>  q22a130DaysOrLess = allLeaversData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() <= 30).collect(Collectors.toList());
					List<Q22BeanModel>  q22a1D31To60Days = allLeaversData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 31 &&  q22BeanModel.getNumberOfDays() <= 60).collect(Collectors.toList());
					List<Q22BeanModel>  q22a1D61To90Days = allLeaversData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() <= 61 && q22BeanModel.getNumberOfDays() >= 90).collect(Collectors.toList());
					List<Q22BeanModel>  q22a1D91To180Days = allLeaversData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() <= 91 && q22BeanModel.getNumberOfDays() >= 180).collect(Collectors.toList());
					List<Q22BeanModel>  q22a1E181To365Days = allLeaversData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() <= 1811 && q22BeanModel.getNumberOfDays() >= 365).collect(Collectors.toList());
					List<Q22BeanModel>  q22a1F366To730Days = allLeaversData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() <= 366 && q22BeanModel.getNumberOfDays() >= 730).collect(Collectors.toList());
					List<Q22BeanModel>  q22a1G731To1095Days = allLeaversData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() <= 731 && q22BeanModel.getNumberOfDays() >= 1095).collect(Collectors.toList());
					List<Q22BeanModel>  q22a1H1096To1460Days = allLeaversData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() <= 1096 && q22BeanModel.getNumberOfDays() >= 1460).collect(Collectors.toList());
					List<Q22BeanModel>  q22a1I1461To1825Days = allLeaversData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() <= 1461 && q22BeanModel.getNumberOfDays() >= 1825).collect(Collectors.toList());
				
					q22a1LengthOfParticipationCoCProjectsTable.setQ22a1A30DaysOrLessLeavers(BigInteger.valueOf(q22a130DaysOrLess != null ? q22a130DaysOrLess.size(): 0));
					q22a1LengthOfParticipationCoCProjectsTable.setQ22a1B31To60DaysLeavers(BigInteger.valueOf(q22a1D31To60Days != null ? q22a1D31To60Days.size() :0));
					q22a1LengthOfParticipationCoCProjectsTable.setQ22a1C61To90DaysLeavers(BigInteger.valueOf(q22a1D61To90Days != null ? q22a1D61To90Days.size() :0));
					q22a1LengthOfParticipationCoCProjectsTable.setQ22a1D91To180DaysLeavers(BigInteger.valueOf(q22a1D91To180Days != null ? q22a1D91To180Days.size() :0));
					q22a1LengthOfParticipationCoCProjectsTable.setQ22a1E181To365DaysLeavers(BigInteger.valueOf(q22a1E181To365Days != null ? q22a1E181To365Days.size() :0));
					q22a1LengthOfParticipationCoCProjectsTable.setQ22a1F366To730DaysLeavers(BigInteger.valueOf(q22a1F366To730Days != null ? q22a1F366To730Days.size() :0));
					q22a1LengthOfParticipationCoCProjectsTable.setQ22a1G731To1095DaysLeavers(BigInteger.valueOf(q22a1G731To1095Days != null ? q22a1G731To1095Days.size() :0));
					q22a1LengthOfParticipationCoCProjectsTable.setQ22a1H1096To1460DaysLeavers(BigInteger.valueOf(q22a1H1096To1460Days != null ? q22a1H1096To1460Days.size() :0));
					q22a1LengthOfParticipationCoCProjectsTable.setQ22a1I1461To1825DaysLeavers(BigInteger.valueOf(q22a1I1461To1825Days != null ? q22a1I1461To1825Days.size() :0));
					q22a1LengthOfParticipationCoCProjectsTable.setQ22a1JMoreThan1825DaysLeavers(BigInteger.valueOf(0));
					q22a1LengthOfParticipationCoCProjectsTable.setQ22a1KInfoMissingLeavers(BigInteger.valueOf(0));
					
					
				}
				
				if(CollectionUtils.isNotEmpty(allStayersData)) {
					allStayersData.forEach(q22Bean -> populateBedNights(q22Bean, data));
					List<Q22BeanModel>  q22a130DaysOrLess = allStayersData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() <= 30).collect(Collectors.toList());
					List<Q22BeanModel>  q22a1D31To60Days = allStayersData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 31 &&  q22BeanModel.getNumberOfDays() <= 60).collect(Collectors.toList());
					List<Q22BeanModel>  q22a1D61To90Days = allStayersData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() <= 61 && q22BeanModel.getNumberOfDays() >= 90).collect(Collectors.toList());
					List<Q22BeanModel>  q22a1D91To180Days = allStayersData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() <= 91 && q22BeanModel.getNumberOfDays() >= 180).collect(Collectors.toList());
					List<Q22BeanModel>  q22a1E181To365Days = allStayersData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() <= 1811 && q22BeanModel.getNumberOfDays() >= 365).collect(Collectors.toList());
					List<Q22BeanModel>  q22a1F366To730Days = allStayersData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() <= 366 && q22BeanModel.getNumberOfDays() >= 730).collect(Collectors.toList());
					List<Q22BeanModel>  q22a1G731To1095Days = allStayersData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() <= 731 && q22BeanModel.getNumberOfDays() >= 1095).collect(Collectors.toList());
					List<Q22BeanModel>  q22a1H1096To1460Days = allStayersData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() <= 1096 && q22BeanModel.getNumberOfDays() >= 1460).collect(Collectors.toList());
					List<Q22BeanModel>  q22a1I1461To1825Days = allStayersData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() <= 1461 && q22BeanModel.getNumberOfDays() >= 1825).collect(Collectors.toList());
				
					
					q22a1LengthOfParticipationCoCProjectsTable.setQ22a1A30DaysOrLessStayers(BigInteger.valueOf(q22a130DaysOrLess != null ? q22a130DaysOrLess.size(): 0));
					q22a1LengthOfParticipationCoCProjectsTable.setQ22a1B31To60DaysStayers(BigInteger.valueOf(q22a1D31To60Days != null ? q22a1D31To60Days.size() :0));
					q22a1LengthOfParticipationCoCProjectsTable.setQ22a1C61To90DaysStayers(BigInteger.valueOf(q22a1D61To90Days != null ? q22a1D61To90Days.size() :0));
					q22a1LengthOfParticipationCoCProjectsTable.setQ22a1D91To180DaysStayers(BigInteger.valueOf(q22a1D91To180Days != null ? q22a1D91To180Days.size() :0));
					q22a1LengthOfParticipationCoCProjectsTable.setQ22a1E181To365DaysStayers(BigInteger.valueOf(q22a1E181To365Days != null ? q22a1E181To365Days.size() :0));
					q22a1LengthOfParticipationCoCProjectsTable.setQ22a1F366To730DaysStayers(BigInteger.valueOf(q22a1F366To730Days != null ? q22a1F366To730Days.size() :0));
					q22a1LengthOfParticipationCoCProjectsTable.setQ22a1G731To1095DaysStayers(BigInteger.valueOf(q22a1G731To1095Days != null ? q22a1G731To1095Days.size() :0));
					q22a1LengthOfParticipationCoCProjectsTable.setQ22a1H1096To1460DaysStayers(BigInteger.valueOf(q22a1H1096To1460Days != null ? q22a1H1096To1460Days.size() :0));
					q22a1LengthOfParticipationCoCProjectsTable.setQ22a1I1461To1825DaysStayers(BigInteger.valueOf(q22a1I1461To1825Days != null ? q22a1I1461To1825Days.size() :0));
					q22a1LengthOfParticipationCoCProjectsTable.setQ22a1JMoreThan1825DaysStayers(BigInteger.valueOf(0));
					q22a1LengthOfParticipationCoCProjectsTable.setQ22a1KInfoMissingStayers(BigInteger.valueOf(0));
				}
				data.setLeaversLengthofStay(allLeaversData);
				data.setStayersLengthofStay(allStayersData);
				data.setAllDataLenghtofStay(allData);
				q22a1LengthOfParticipationCoCProjectsTable.setQ22a1LTotTotal(data.getTotNumOfPersonServed());
				q22a1LengthOfParticipationCoCProjectsTable.setQ22a1LTotLeavers(BigInteger.valueOf(allLeaversData != null ? allLeaversData.size() : 0));
				q22a1LengthOfParticipationCoCProjectsTable.setQ22a1LTotStayers(BigInteger.valueOf(allStayersData != null ? allStayersData.size() :0));
			}
		}catch(Exception e) {
			logger.error("Error in Q22aBeanMaker:" + e);
		}
		return Arrays.asList(q22a1LengthOfParticipationCoCProjectsTable);
	}
	
	public static void populateBedNights(Q22BeanModel model, ReportData data) {
		String[] method1 = new String[] { "2", "4", "6", "7", "8", "11", "12", "14"};
		List<String> method1List = Arrays.asList(method1);
		String[] method3 = new String[] {"3", "9", "10", "13" };
		List<String> method3List = Arrays.asList(method3);
		Date reportStartDate = data.getReportStartDate();
		Date reportEndDate = data.getReportEndDate();
		if((StringUtils.equals("1",model.getProjectType()) && StringUtils.equals(model.getTrackingMethod(), "0")) || 
			(StringUtils.isNotEmpty(model.getProjectType()) &&	method1List.contains(model.getProjectType()))) {
			    /*** Bed nights = [minimum of ( [project exit date], [report end date] + 1) ]
						– [maximum of ( [project start date], [report start date] ) ] 
			    **/
			   model.setNumberOfDays(subtractDate(getMinimumDate(model.getExitdate(),reportEndDate),getMaximumDate(model.getEntrydate(), reportStartDate)));
		}
		if(StringUtils.equals("1",model.getProjectType()) && StringUtils.equals(model.getTrackingMethod(), "3")) {
			/***
			 * [bed night date] must be:
				>= [project start date]
				and < [project exit date] or [project exit date] is null
				and >= [report start date]
				and <= [report end date]
			 */
			String bedNightsQuery = " select count(sfr.id) from enrollment e join project p  on (e.projectid = p.id and e.dedup_client_id=?  %p"+
					" join service_fa_referral sfr  on  (sfr.enrollmentid = e.id and record_type='200' and dateprovided >= e.entrydate  and dateprovided >= ? and dateprovided <= ?) "+
				    " join exit ext on (sfr.dateprovided < ext.exitdate or ext.exitdate is null) ";

			// May be have another query to get the correct bed nights count.
			model.setNumberOfDays(getBedNights(bedNightsQuery, data, model.getDedupClientId()));
		}
		
		if(StringUtils.isNotEmpty(model.getProjectType()) && method3List.contains(model.getProjectType())) {
			model.setNumberOfDays(subtractDate(getMinimumDate(model.getExitdate(),reportEndDate),getMaximumDate(model.getMoveInDate(), reportStartDate)));
		}
		
	}
	
	public static Date addDays(Date date, int days) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, days);
        return new Date(c.getTimeInMillis());
    }
	 private static Date getMinimumDate(Date date1, Date date2) {
		 if(date1.before(date1)) {
			 return addDays(date1,1);
		 }
		return addDays(date2,1);
	}
	 
	 private static Date getMaximumDate(Date date1, Date date2) {
		 if(date1.after(date1)) {
			 return date1;
		 }
		return date2;
	}
	 
	public static List<Q22BeanModel> getQ22Bean(ReportData data,String query,String reportType) {
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
						 builder.append("'"+project+"'");
						 if(count != projectIds.size()) {
							 builder.append(",");
						 }
					 }
				 }
				 builder.append(" ) ");
				String newQuery = query.replace("%p", builder.toString());
				statement = connection.prepareStatement(formatQuery(newQuery,data.getSchema()));
				if(StringUtils.equals("LEAVERS", reportType) ) {
					statement.setDate(1, data.getReportStartDate());
					statement.setDate(2, data.getReportEndDate());
				}else if(StringUtils.equals("STAYERS", reportType) ) {
					statement.setDate(1, data.getReportEndDate());
					statement.setDate(2, data.getReportEndDate());
				}
				resultSet = statement.executeQuery();
				
			 while(resultSet.next()) {
				 q22Beans.add(new Q22BeanModel(resultSet.getString("dedup_client_id"), resultSet.getString("projecttype"), resultSet.getString("trackingmethod"), 
						 resultSet.getDate("operatingstartdate"),resultSet.getDate("exitdate"),resultSet.getDate("entrydate"),resultSet.getDate("moveindate"),resultSet.getDate("dateprovided") ));
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
	
	
	    public static long getBedNights(String query, ReportData data, String dedupClientId) {
	    	long bedNights = 0;
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
						 builder.append("'"+project+"'");
						 if(count != projectIds.size()) {
							 builder.append(",");
						 }
					 }
				 }
				 builder.append(" ) ");
				String newQuery = query.replace("%p", builder.toString());
				statement = connection.prepareStatement(formatQuery(newQuery,data.getSchema()));
				statement.setString(1, dedupClientId);
				statement.setDate(2, data.getReportStartDate());
				statement.setDate(3, data.getReportEndDate());
				resultSet = statement.executeQuery();
				 while(resultSet.next()) {
					 bedNights = resultSet.getLong(1);
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
			return bedNights;
	    }
}
	
	
