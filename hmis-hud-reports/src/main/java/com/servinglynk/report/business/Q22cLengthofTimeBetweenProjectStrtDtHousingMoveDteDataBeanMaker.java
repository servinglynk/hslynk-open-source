package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import com.servinglynk.report.bean.Q22cLengthofTimeBetweenProjectStrtDtHousingMoveDteDataBean;
import com.servinglynk.report.bean.ReportData;

public class Q22cLengthofTimeBetweenProjectStrtDtHousingMoveDteDataBeanMaker extends BaseBeanMaker {
	
	public static List<Q22cLengthofTimeBetweenProjectStrtDtHousingMoveDteDataBean> getQ22cLengthofTimeBetweenProjectStrtDtHousingMoveDteDataBeanList(ReportData data){
		Q22cLengthofTimeBetweenProjectStrtDtHousingMoveDteDataBean q22cBean = new Q22cLengthofTimeBetweenProjectStrtDtHousingMoveDteDataBean();
		
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


		String query = " select distinct(e.dedup_client_id ),e.entrydate,mid.moveindate from enrollment e join project p  on (e.projectid = p.id and p.projecttype in ('13','3') and p.id ='5cc34dce-e603-4cb6-8d95-4cd3fb164098' ) "+
				  " join  enrollment e1 on  (e.householdid = e1.householdid  and e1.relationshiptohoh ='1') "+
			      " join moveindate mid on (e1.id = mid.enrollmentid and mid.moveindate  >=  '2016-06-24 00:00:00'  and  mid.moveindate<='2018-06-24 00:00:00') "+
					" order by e.dedup_client_id "+
					" union all "+    
					" select distinct(e.dedup_client_id ),e.entrydate,mid.moveindate  from enrollment e join project p  on (e.projectid = p.id and p.projecttype in ('13','3') and p.id ='5cc34dce-e603-4cb6-8d95-4cd3fb164098' ) "+
					" join exit ext on ( e.id = ext.enrollmentid and ext.exitdate >= '2016-06-24 00:00:00'  and ext.exitdate <='2018-06-24 00:00:00') "+
					" where e.id not in  (select enrollmentid from moveindate where moveindate >= '2016-06-24 00:00:00'  and moveindate <='2018-06-24 00:00:00') "+
					" order by e.dedup_client_id ";		
		         
		try {
			if(data.isLiveMode()) {
				List<String> allData = getDistinctDedupClient(data, query, "ALL");
				q22cBean.setQ22c7DaysLessTotal(BigInteger.valueOf(0));
				q22cBean.setQ22c7DaysLessWithoutChildren(BigInteger.valueOf(0));
				q22cBean.setQ22c7DaysLessWithChildAndAdults(BigInteger.valueOf(0));
				q22cBean.setQ22c7DaysLessWithOnlychildren(BigInteger.valueOf(0));
				q22cBean.setQ22c7DaysLessUnknowHousehold(BigInteger.valueOf(0));
				q22cBean.setQ22c8To14DaysTotal(BigInteger.valueOf(0));
				q22cBean.setQ22c8To14DaysWithoutChildren(BigInteger.valueOf(0));
				q22cBean.setQ22c8To14DaysWithChildAndAdults(BigInteger.valueOf(0));
				q22cBean.setQ22c8To14DaysWithOnlychildren(BigInteger.valueOf(0));
				q22cBean.setQ22c8To14DaysUnknowHousehold(BigInteger.valueOf(0));
				q22cBean.setQ22c15To21DaysTotal(BigInteger.valueOf(0));
				q22cBean.setQ22c15To21DaysWithoutChildren(BigInteger.valueOf(0));
				q22cBean.setQ22c15To21DaysWithChildAndAdults(BigInteger.valueOf(0));
				q22cBean.setQ22c15To21DaysWithOnlychildren(BigInteger.valueOf(0));
				q22cBean.setQ22c15To21DaysUnknowHousehold(BigInteger.valueOf(0));
				q22cBean.setQ22c22To30DaysTotal(BigInteger.valueOf(0));
				q22cBean.setQ22c22To30DaysWithoutChildren(BigInteger.valueOf(0));
				q22cBean.setQ22c22To30DaysWithChildAndAdults(BigInteger.valueOf(0));
				q22cBean.setQ22c22To30DaysWithOnlychildren(BigInteger.valueOf(0));
				q22cBean.setQ22c22To30DaysUnknowHousehold(BigInteger.valueOf(0));
				q22cBean.setQ22c31To60DaysTotal(BigInteger.valueOf(0));
				q22cBean.setQ22c31To60DaysWithoutChildren(BigInteger.valueOf(0));
				q22cBean.setQ22c31To60DaysWithChildAndAdults(BigInteger.valueOf(0));
				q22cBean.setQ22c31To60DaysWithOnlychildren(BigInteger.valueOf(0));
				q22cBean.setQ22c31To60DaysUnknowHousehold(BigInteger.valueOf(0));
				q22cBean.setQ22c61To180DaysTotal(BigInteger.valueOf(0));
				q22cBean.setQ22c61To180DaysWithoutChildren(BigInteger.valueOf(0));
				q22cBean.setQ22c61To180DaysWithChildAndAdults(BigInteger.valueOf(0));
				q22cBean.setQ22c61To180DaysWithOnlychildren(BigInteger.valueOf(0));
				q22cBean.setQ22c61To180DaysUnknowHousehold(BigInteger.valueOf(0));
				q22cBean.setQ22c181To365DaysTotal(BigInteger.valueOf(0));
				q22cBean.setQ22c181To365DaysWithoutChildren(BigInteger.valueOf(0));
				q22cBean.setQ22c181To365DaysWithChildAndAdults(BigInteger.valueOf(0));
				q22cBean.setQ22c181To365DaysWithOnlychildren(BigInteger.valueOf(0));
				q22cBean.setQ22c181To365DaysUnknowHousehold(BigInteger.valueOf(0));
				q22cBean.setQ22c366To730DaysTotal(BigInteger.valueOf(0));
				q22cBean.setQ22c366To730DaysWithoutChildren(BigInteger.valueOf(0));
				q22cBean.setQ22c366To730DaysWithChildAndAdults(BigInteger.valueOf(0));
				q22cBean.setQ22c366To730DaysWithOnlychildren(BigInteger.valueOf(0));
				q22cBean.setQ22c366To730DaysUnknowHousehold(BigInteger.valueOf(0));
				q22cBean.setQ22cPersonsMovedIntoHousingTotal(BigInteger.valueOf(0));
				q22cBean.setQ22cPersonsMovedIntoHousingWithoutChildren(BigInteger.valueOf(0));
				q22cBean.setQ22cPersonsMovedIntoHousingWithChildAndAdults(BigInteger.valueOf(0));
				q22cBean.setQ22cPersonsMovedIntoHousingWithOnlychildren(BigInteger.valueOf(0));
				q22cBean.setQ22cPersonsMovedIntoHousingUnknowHousehold(BigInteger.valueOf(0));
				q22cBean.setQ22cAvgLengthTotal(BigInteger.valueOf(0)); 
				q22cBean.setQ22cAvgLengthWithoutChildren(BigInteger.valueOf(0));
				q22cBean.setQ22cAvgLengthWithChildAndAdults(BigInteger.valueOf(0));
				q22cBean.setQ22cAvgLengthWithOnlychildren(BigInteger.valueOf(0));
				q22cBean.setQ22cAvgLengthUnknowHousehold(BigInteger.valueOf(0));
				q22cBean.setQ22cPersonsExitedTotal(BigInteger.valueOf(0)); 
				q22cBean.setQ22cPersonsExitedWithoutChildren(BigInteger.valueOf(0));
				q22cBean.setQ22cPersonsExitedWithChildAndAdults(BigInteger.valueOf(0));
				q22cBean.setQ22cPersonsExitedWithOnlychildren(BigInteger.valueOf(0));
				q22cBean.setQ22cPersonsExitedUnknowHousehold(BigInteger.valueOf(0));
				q22cBean.setQ22cTotPersonsTotal(BigInteger.valueOf(0)); 
				q22cBean.setQ22cTotPersonsWithoutChildren(BigInteger.valueOf(0));
				q22cBean.setQ22cTotPersonsWithChildAndAdults(BigInteger.valueOf(0));
				q22cBean.setQ22cTotPersonsWithOnlychildren(BigInteger.valueOf(0));
				q22cBean.setQ22cTotPersonsUnknowHousehold(BigInteger.valueOf(0));
			}
		}catch(Exception e) {
			logger.error("Error in Q22cLengthofTimeBetweenProjectStrtDtHousingMoveDteDataBeanMaker:" + e);
		}
		return Arrays.asList(q22cBean);
		
		
	}

	private static List<String> getDistinctDedupClient(ReportData data, String query, String string) {
		return null;
	}

}
