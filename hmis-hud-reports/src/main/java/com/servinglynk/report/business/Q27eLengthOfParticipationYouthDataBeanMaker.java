package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;

import com.servinglynk.report.bean.Q27eLengthOfParticipationYouthDataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.Q22BeanModel;

public class Q27eLengthOfParticipationYouthDataBeanMaker extends BaseBeanMaker {
	
	public static List<Q27eLengthOfParticipationYouthDataBean> getQ27eLengthOfParticipationYouthList(ReportData data){
		
		Q27eLengthOfParticipationYouthDataBean q27eLengthOfParticipationYouthTable = new Q27eLengthOfParticipationYouthDataBean();
		String allQuery = " select  e.dedup_client_id ,p.projecttype,p.trackingmethod,p.operatingstartdate,ext.exitdate,e.entrydate,mid.moveindate from %s.enrollment e join %s.project p  on (e.projectid = p.id %p ) "+
				" left outer join  %s.exit ext  on  (ext.enrollmentid = e.id) "+
				" left outer join  %s.moveindate mid  on  (mid.enrollmentid = e.id) "+
				" where e.ageatentry > = 18 and e.ageatentry < = 24 "+// Added age for youth.
				" order by e.dedup_client_id,p.operatingstartdate asc ";
		
		String leaversQuery = "select  e.dedup_client_id ,p.projecttype,p.trackingmethod,p.operatingstartdate,ext.exitdate,e.entrydate,mid.moveindate from %s.enrollment e join %s.project p  on (e.projectid = p.id %p ) "+
						" join  %s.exit ext  on  (ext.enrollmentid = e.id and ext.exitdate >= :startDate and ext.exitdate <= :endDate) "+
						" left outer join  %s.moveindate mid  on  (mid.enrollmentid = e.id) "+
						" where e.ageatentry > = 18 and e.ageatentry < = 24 "+// Added age for youth.
						" order by e.dedup_client_id,p.operatingstartdate asc ";
				
		String stayersQuery = "select  e.dedup_client_id ,p.projecttype,p.trackingmethod,p.operatingstartdate,ext.exitdate,e.entrydate,mid.moveindate from %s.enrollment e join %s.project p  on (e.projectid = p.id %p ) "+
						" left outer join  %s.exit ext  on  (ext.enrollmentid = e.id and  e.entrydate <= :startDate and (ext.exitdate is null  or ext.exitdate > :endDate) ) "+
						" left outer join  %s.moveindate mid  on  (mid.enrollmentid = e.id) "+
						" where e.ageatentry > = 18 and e.ageatentry < = 24 "+ // Added age for youth.
						" order by e.dedup_client_id,p.operatingstartdate asc ";
		
		try {
			if(data.isLiveMode()) {
				List<Q22BeanModel> allData = getQ22Bean(data, allQuery, "ALL");
				List<Q22BeanModel> allLeaversData = getQ22Bean(data, leaversQuery,"LEAVERS");
				List<Q22BeanModel> allStayersData = getQ22Bean(data, stayersQuery,"STAYERS");
				
				if(CollectionUtils.isNotEmpty(allData)) {
					allData.forEach(q22Bean -> populateBedNights(q22Bean, data));
					List<Q22BeanModel>  Q27e30DaysOrLess = allData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() <= 30).collect(Collectors.toList());
					List<Q22BeanModel>  Q27eD31To60Days = allData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 31 &&  q22BeanModel.getNumberOfDays() <= 60).collect(Collectors.toList());
					List<Q22BeanModel>  Q27eD61To90Days = allData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 61 && q22BeanModel.getNumberOfDays() >= 90).collect(Collectors.toList());
					List<Q22BeanModel>  Q27eD91To180Days = allData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 91 && q22BeanModel.getNumberOfDays() >= 180).collect(Collectors.toList());
					List<Q22BeanModel>  Q27eE181To365Days = allData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 181 && q22BeanModel.getNumberOfDays() >= 365).collect(Collectors.toList());
					List<Q22BeanModel>  Q27eF366To730Days = allData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 366 && q22BeanModel.getNumberOfDays() >= 730).collect(Collectors.toList());
					List<Q22BeanModel>  Q27eG731To1095Days = allData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 731 && q22BeanModel.getNumberOfDays() >= 1095).collect(Collectors.toList());
					List<Q22BeanModel>  Q27eH1096To1460Days = allData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 1096 && q22BeanModel.getNumberOfDays() >= 1460).collect(Collectors.toList());
					List<Q22BeanModel>  Q27eI1461To1825Days = allData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 1461 && q22BeanModel.getNumberOfDays() >= 1825).collect(Collectors.toList());
					
					q27eLengthOfParticipationYouthTable.setQ27e30DaysOrLessAtEntry(BigInteger.valueOf(Q27e30DaysOrLess != null ? Q27e30DaysOrLess.size(): 0));
					q27eLengthOfParticipationYouthTable.setQ27e31To60DaysAtEntry(BigInteger.valueOf(Q27eD31To60Days != null ? Q27eD31To60Days.size() :0));
					q27eLengthOfParticipationYouthTable.setQ27e61To90DaysAtEntry(BigInteger.valueOf(Q27eD61To90Days != null ? Q27eD61To90Days.size() :0));
					q27eLengthOfParticipationYouthTable.setQ27e91To180DaysAtEntry(BigInteger.valueOf(Q27eD91To180Days != null ? Q27eD91To180Days.size() :0));
					q27eLengthOfParticipationYouthTable.setQ27e181To365DaysAtEntry(BigInteger.valueOf(Q27eE181To365Days != null ? Q27eE181To365Days.size() :0));
					q27eLengthOfParticipationYouthTable.setQ27e366To730DaysAtEntry(BigInteger.valueOf(Q27eF366To730Days != null ? Q27eF366To730Days.size() :0));
					q27eLengthOfParticipationYouthTable.setQ27e731To1095DaysAtEntry(BigInteger.valueOf(Q27eG731To1095Days != null ? Q27eG731To1095Days.size() :0));
					q27eLengthOfParticipationYouthTable.setQ27e1096To1460DaysAtEntry(BigInteger.valueOf(Q27eH1096To1460Days != null ? Q27eH1096To1460Days.size() :0));
					q27eLengthOfParticipationYouthTable.setQ27e1461To1825DaysAtEntry(BigInteger.valueOf(Q27eI1461To1825Days != null ? Q27eI1461To1825Days.size() :0));
					q27eLengthOfParticipationYouthTable.setQ27eMoreThan1825DaysAtEntry(BigInteger.valueOf(0));
					q27eLengthOfParticipationYouthTable.setQ27eInformationMissingAtEntry(BigInteger.valueOf(0));
				}
				if(CollectionUtils.isNotEmpty(allLeaversData)) {
					allLeaversData.forEach(q22Bean -> populateBedNights(q22Bean, data));
					List<Q22BeanModel>  Q27e30DaysOrLess = allLeaversData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() <= 30).collect(Collectors.toList());
					List<Q22BeanModel>  Q27eD31To60Days = allLeaversData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 31 &&  q22BeanModel.getNumberOfDays() <= 60).collect(Collectors.toList());
					List<Q22BeanModel>  Q27eD61To90Days = allLeaversData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 61 && q22BeanModel.getNumberOfDays() >= 90).collect(Collectors.toList());
					List<Q22BeanModel>  Q27eD91To180Days = allLeaversData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 91 && q22BeanModel.getNumberOfDays() >= 180).collect(Collectors.toList());
					List<Q22BeanModel>  Q27eE181To365Days = allLeaversData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 1811 && q22BeanModel.getNumberOfDays() >= 365).collect(Collectors.toList());
					List<Q22BeanModel>  Q27eF366To730Days = allLeaversData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 366 && q22BeanModel.getNumberOfDays() >= 730).collect(Collectors.toList());
					List<Q22BeanModel>  Q27eG731To1095Days = allLeaversData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 731 && q22BeanModel.getNumberOfDays() >= 1095).collect(Collectors.toList());
					List<Q22BeanModel>  Q27eH1096To1460Days = allLeaversData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 1096 && q22BeanModel.getNumberOfDays() >= 1460).collect(Collectors.toList());
					List<Q22BeanModel>  Q27eI1461To1825Days = allLeaversData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 1461 && q22BeanModel.getNumberOfDays() >= 1825).collect(Collectors.toList());
				
					q27eLengthOfParticipationYouthTable.setQ27e30DaysOrLessLeavers(BigInteger.valueOf(Q27e30DaysOrLess != null ? Q27e30DaysOrLess.size(): 0));
					q27eLengthOfParticipationYouthTable.setQ27e31To60DaysLeavers(BigInteger.valueOf(Q27eD31To60Days != null ? Q27eD31To60Days.size() :0));
					q27eLengthOfParticipationYouthTable.setQ27e61To90DaysLeavers(BigInteger.valueOf(Q27eD61To90Days != null ? Q27eD61To90Days.size() :0));
					q27eLengthOfParticipationYouthTable.setQ27e91To180DaysLeavers(BigInteger.valueOf(Q27eD91To180Days != null ? Q27eD91To180Days.size() :0));
					q27eLengthOfParticipationYouthTable.setQ27e181To365DaysLeavers(BigInteger.valueOf(Q27eE181To365Days != null ? Q27eE181To365Days.size() :0));
					q27eLengthOfParticipationYouthTable.setQ27e366To730DaysLeavers(BigInteger.valueOf(Q27eF366To730Days != null ? Q27eF366To730Days.size() :0));
					q27eLengthOfParticipationYouthTable.setQ27e731To1095DaysLeavers(BigInteger.valueOf(Q27eG731To1095Days != null ? Q27eG731To1095Days.size() :0));
					q27eLengthOfParticipationYouthTable.setQ27e1096To1460DaysLeavers(BigInteger.valueOf(Q27eH1096To1460Days != null ? Q27eH1096To1460Days.size() :0));
					q27eLengthOfParticipationYouthTable.setQ27e1461To1825DaysLeavers(BigInteger.valueOf(Q27eI1461To1825Days != null ? Q27eI1461To1825Days.size() :0));
					q27eLengthOfParticipationYouthTable.setQ27eMoreThan1825DaysLeavers(BigInteger.valueOf(0));
					q27eLengthOfParticipationYouthTable.setQ27eInformationMissingLeavers(BigInteger.valueOf(0));
					
				}
				
				if(CollectionUtils.isNotEmpty(allStayersData)) {
					allStayersData.forEach(q22Bean -> populateBedNights(q22Bean, data));
					List<Q22BeanModel>  Q27e30DaysOrLess = allStayersData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() <= 30).collect(Collectors.toList());
					List<Q22BeanModel>  Q27eD31To60Days = allStayersData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 31 &&  q22BeanModel.getNumberOfDays() <= 60).collect(Collectors.toList());
					List<Q22BeanModel>  Q27eD61To90Days = allStayersData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 61 && q22BeanModel.getNumberOfDays() >= 90).collect(Collectors.toList());
					List<Q22BeanModel>  Q27eD91To180Days = allStayersData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 91 && q22BeanModel.getNumberOfDays() >= 180).collect(Collectors.toList());
					List<Q22BeanModel>  Q27eE181To365Days = allStayersData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 1811 && q22BeanModel.getNumberOfDays() >= 365).collect(Collectors.toList());
					List<Q22BeanModel>  Q27eF366To730Days = allStayersData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 366 && q22BeanModel.getNumberOfDays() >= 730).collect(Collectors.toList());
					List<Q22BeanModel>  Q27eG731To1095Days = allStayersData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 731 && q22BeanModel.getNumberOfDays() >= 1095).collect(Collectors.toList());
					List<Q22BeanModel>  Q27eH1096To1460Days = allStayersData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 1096 && q22BeanModel.getNumberOfDays() >= 1460).collect(Collectors.toList());
					List<Q22BeanModel>  Q27eI1461To1825Days = allStayersData.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() >= 1461 && q22BeanModel.getNumberOfDays() >= 1825).collect(Collectors.toList());
				
					
					q27eLengthOfParticipationYouthTable.setQ27e30DaysOrLessStayers(BigInteger.valueOf(Q27e30DaysOrLess != null ? Q27e30DaysOrLess.size(): 0));
					q27eLengthOfParticipationYouthTable.setQ27e31To60DaysStayers(BigInteger.valueOf(Q27eD31To60Days != null ? Q27eD31To60Days.size() :0));
					q27eLengthOfParticipationYouthTable.setQ27e61To90DaysStayers(BigInteger.valueOf(Q27eD61To90Days != null ? Q27eD61To90Days.size() :0));
					q27eLengthOfParticipationYouthTable.setQ27e91To180DaysStayers(BigInteger.valueOf(Q27eD91To180Days != null ? Q27eD91To180Days.size() :0));
					q27eLengthOfParticipationYouthTable.setQ27e181To365DaysStayers(BigInteger.valueOf(Q27eE181To365Days != null ? Q27eE181To365Days.size() :0));
					q27eLengthOfParticipationYouthTable.setQ27e366To730DaysStayers(BigInteger.valueOf(Q27eF366To730Days != null ? Q27eF366To730Days.size() :0));
					q27eLengthOfParticipationYouthTable.setQ27e731To1095DaysStayers(BigInteger.valueOf(Q27eG731To1095Days != null ? Q27eG731To1095Days.size() :0));
					q27eLengthOfParticipationYouthTable.setQ27e1096To1460DaysStayers(BigInteger.valueOf(Q27eH1096To1460Days != null ? Q27eH1096To1460Days.size() :0));
					q27eLengthOfParticipationYouthTable.setQ27e1461To1825DaysStayers(BigInteger.valueOf(Q27eI1461To1825Days != null ? Q27eI1461To1825Days.size() :0));
					q27eLengthOfParticipationYouthTable.setQ27eMoreThan1825DaysStayers(BigInteger.valueOf(0));
					q27eLengthOfParticipationYouthTable.setQ27eInformationMissingStayers(BigInteger.valueOf(0));
				}
				data.setLeaversLengthofStay(allLeaversData);
				data.setStayersLengthofStay(allStayersData);
				data.setAllDataLenghtofStay(allData);
				q27eLengthOfParticipationYouthTable.setQ27eTotalAtEntry(BigInteger.valueOf(getSize(allData)));
				q27eLengthOfParticipationYouthTable.setQ27eTotalLeavers(BigInteger.valueOf(allLeaversData != null ? allLeaversData.size() : 0));
				q27eLengthOfParticipationYouthTable.setQ27eTotalStayers(BigInteger.valueOf(allStayersData != null ? allStayersData.size() :0));
			}
		}catch(Exception e) {
			logger.error("Error in Q27eaBeanMaker:" + e);
		}
		return Arrays.asList(q27eLengthOfParticipationYouthTable);
		}


}