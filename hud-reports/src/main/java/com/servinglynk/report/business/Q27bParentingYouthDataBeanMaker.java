package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import com.servinglynk.report.bean.Q27bParentingYouthDataBean;
import com.servinglynk.report.bean.ReportData;

public class Q27bParentingYouthDataBeanMaker extends BaseBeanMaker{
	
	public static List<Q27bParentingYouthDataBean> getQ27bParentingYouthList(ReportData data){
		
		Q27bParentingYouthDataBean q27bParentingYouthTable = new Q27bParentingYouthDataBean();
		try {
			if(data.isLiveMode()) {
				String parent18To24YouthQuery = " select distinct(e.dedup_client_id) from %s.enrollment e, %s.enrollment e1,%s.project p where e.householdid = e1.householdid and  e.ageatentry >=18 and e.ageatentry <= 24 and e.relationshiptohoh='1' and e.entrydate >= :startDate and e.entrydate <=:endDate and e1.relationshiptohoh='2' and e1.projectid=p.id  %p ";
			
				int parent18To24Size= getSize(getClients(data, parent18To24YouthQuery, null, true));
				
				String parentlessThan18YouthQuery = " select distinct(e.dedup_client_id) from %s.enrollment e, %s.enrollment e1,%s.project p where e.householdid = e1.householdid and  e.ageatentry<18  and e.relationshiptohoh='1' and e.entrydate >= :startDate and e.entrydate <=:endDate and e1.relationshiptohoh='2' and e1.projectid=p.id  %p ";
				int parentLessThan18Size= getSize(getClients(data, parentlessThan18YouthQuery, null, true));
				
				String households18To24YouthQuery = " select distinct(e.householdid) from %s.enrollment e ,%s.project p where  e.ageatentry <= 18  and e.ageatentry >=24 and e.entrydate >= :startDate and e.entrydate <=:endDate  and e.projectid=p.id   %p ";
				String householdsLessThan18YouthQuery =" select distinct(e.householdid) from %s.enrollment e ,%s.project p where  e.ageatentry <= 18  and e.ageatentry >=24 and e.entrydate >= :startDate and e.entrydate <=:endDate  and e.projectid=p.id  %p ";
				
				int householdId18To24Size= getSize(getClients(data, households18To24YouthQuery, null, true));
				int householdLessThanSize= getSize(getClients(data, householdsLessThan18YouthQuery, null, true));
				
				String persons18To24YouthQuery = " select distinct(e.dedup_client_id) from %s.enrollment e ,%s.project p where  e.ageatentry <= 18  and e.ageatentry >=24 and e.entrydate >= :startDate and e.entrydate <=:endDate  and e.projectid=p.id  %p ";
				String personsLessThan18YouthQuery =" select distinct(e.dedup_client_id) from %s.enrollment e ,%s.project p where  e.ageatentry <= 18  and e.ageatentry >=24 and e.entrydate >= :startDate and e.entrydate <=:endDate  and e.projectid=p.id  %p ";
				
				int persons18To24Size= getSize(getClients(data, persons18To24YouthQuery, null, true));
				int personsLessThanSize= getSize(getClients(data, personsLessThan18YouthQuery, null, true));
				
				
				String children18To24YouthQuery = " select distinct(e1.dedup_client_id) from %s.enrollment e, %s.enrollment e1,%s.project p where e.householdid = e1.householdid and  e.ageatentry >=18 and e.ageatentry <= 24 and e.entrydate >= :startDate and e.entrydate <=:endDate and e.relationshiptohoh='1' and e1.relationshiptohoh='2' and   e1.projectid=p.id and e1.ageatentry <=11 %p ";
				int children18To24Size= getSize(getClients(data, children18To24YouthQuery, null, true));
				
				String childrenlessThan18YouthQuery = " select distinct(e1.dedup_client_id) from %s.enrollment e, %s.enrollment e1,%s.project p where e.householdid = e1.householdid and  e.ageatentry<18  and e.relationshiptohoh='1' and e.entrydate >= :startDate and e.entrydate <=:endDate and e1.relationshiptohoh='2'  and e1.projectid=p.id and e1.ageatentry <=11 %p ";
				int childrenLessThan18Size= getSize(getClients(data, childrenlessThan18YouthQuery, null, true));
			
				
				q27bParentingYouthTable.setQ27bParentYouthLeassThan18TotalParentingYouth(BigInteger.valueOf(parentLessThan18Size));
				q27bParentingYouthTable.setQ27bParentYouthLeassThan18TotalChildrenOfParentingYouth(BigInteger.valueOf(childrenLessThan18Size));
				q27bParentingYouthTable.setQ27bParentYouthLeassThan18TotalPersons(BigInteger.valueOf(personsLessThanSize));
				q27bParentingYouthTable.setQ27bParentYouthLeassThan18TotalHouseholds(BigInteger.valueOf(householdLessThanSize));

				q27bParentingYouthTable.setQ27bParentYouth18To24TotalParentingYouth(BigInteger.valueOf(parent18To24Size) );
				q27bParentingYouthTable.setQ27bParentYouth18To24TotalChildrenOfParentingYouth(BigInteger.valueOf(children18To24Size));
				q27bParentingYouthTable.setQ27bParentYouth18To24TotalPersons(BigInteger.valueOf(persons18To24Size));
				q27bParentingYouthTable.setQ27bParentYouth18To24TotalHouseholds(BigInteger.valueOf(householdId18To24Size));
			}
		}catch(Exception e) {
			logger.error("Error in Q27bhBeanMaker:" + e);
		}
		return Arrays.asList(q27bParentingYouthTable);
	}

}
