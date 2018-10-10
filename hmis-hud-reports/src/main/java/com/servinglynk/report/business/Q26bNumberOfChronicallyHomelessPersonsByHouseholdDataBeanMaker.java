package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import com.servinglynk.report.bean.Q26bNumberOfChronicallyHomelessPersonsByHouseholdDataBean;
import com.servinglynk.report.bean.ReportData;

public class Q26bNumberOfChronicallyHomelessPersonsByHouseholdDataBeanMaker extends BaseBeanMaker {
	
public static List<Q26bNumberOfChronicallyHomelessPersonsByHouseholdDataBean> getQ26bNumberOfChronicallyHomelessPersonsByHouseholdList(ReportData data){
		
	Q26bNumberOfChronicallyHomelessPersonsByHouseholdDataBean q26bNumberOfChronicallyHomelessPersonsByHouseholdTable = new Q26bNumberOfChronicallyHomelessPersonsByHouseholdDataBean();
	try {
		if(data.isLiveMode()) {
			List<String> projectsHHWithChildren = data.getProjectsHHWithChildren();
			List<String> projectsHHWithOneAdultChild = data.getProjectsHHWithOneAdultChild();
			List<String> projectsHHWithOutChildren = data.getProjectsHHWithOutChildren();
			List<String> projectsUnknownHouseHold = data.getProjectsUnknownHouseHold();
			
			String chronicHomelessQuery ="select distinct(dedup_client_id) from %s.enrollment e,%s.client c,%.project p  where c.id =e.client_id and c.veteran_status ='1' and e.chronichomeless='true' and e.projectid = p.id %p";
			String noChronicHomelessQuery ="select distinct(dedup_client_id) from enrollment e,%s.client c,%.project p  where c.id =e.client_id and c.veteran_status ='1' and e.chronichomeless='false' and e.projectid = p.id %p";
			String dnKChHomelessQuery ="select distinct(dedup_client_id) from enrollment e,%s.client c,%.project p  where c.id =e.client_id and c.veteran_status ='1' and e.disablingcondition in ('8','9') and e.projectid = p.id %p";
			String dnCChHomelessQuery ="select distinct(dedup_client_id) from enrollment e,%s.client c,%.project p  where c.id =e.client_id and c.veteran_status ='1' and e.disablingcondition ='99' and e.projectid = p.id %p";
			
			int chSize = getSize(getClients(data, chronicHomelessQuery, null, true));
			int chWithoutChildSize = getSize(getClients(data, chronicHomelessQuery, projectsHHWithOutChildren, false));
			int chChildAndAdultsSize = getSize(getClients(data, chronicHomelessQuery, projectsHHWithOneAdultChild, false));
			int chWithOnlyChildSize = getSize(getClients(data, chronicHomelessQuery, projectsHHWithChildren, false));
			int chUnknownHouseHoldSize = getSize(getClients(data, chronicHomelessQuery, projectsUnknownHouseHold, false));
			
			q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bChronicallyHomelessTotal(BigInteger.valueOf(chSize));
			q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bChronicallyHomelessWithoutChild(BigInteger.valueOf(0));
			q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bChronicallyHomelessWithChildAndAdults(BigInteger.valueOf(0));
			q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bChronicallyHomelessWithOnlyChild(BigInteger.valueOf(0));
			q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bChronicallyHomelessUnknownHouseholdType(BigInteger.valueOf(0));

			q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bNotChronicallyHomelessTotal(BigInteger.valueOf(0));
			q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bNotChronicallyHomelessWithoutChild(BigInteger.valueOf(0));
			q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bNotChronicallyHomelessWithChildAndAdults(BigInteger.valueOf(0));
			q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bNotChronicallyHomelessWithOnlyChild(BigInteger.valueOf(0));
			q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bNotChronicallyHomelessUnknownHouseholdType(BigInteger.valueOf(0));

			q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bClientRefusedTotal(BigInteger.valueOf(0));
			q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bClientRefusedWithoutChild(BigInteger.valueOf(0));
			q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bClientRefusedWithChildAndAdults(BigInteger.valueOf(0));
			q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bClientRefusedWithOnlyChild(BigInteger.valueOf(0));
			q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bClientRefusedUnknownHouseholdType(BigInteger.valueOf(0));

			q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bDataNotCollectedTotal(BigInteger.valueOf(0));
			q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bDataNotCollectedWithoutChild(BigInteger.valueOf(0));
			q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bDataNotCollectedWithChildAndAdults(BigInteger.valueOf(0));
			q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bDataNotCollectedWithOnlyChild(BigInteger.valueOf(0));
			q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bDataNotCollectedUnknownHouseholdType(BigInteger.valueOf(0));

			q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bTotTotal(data.getNoOfChronicallyHomelessPersons());
			q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bTotWithoutChild(BigInteger.valueOf(0));
			q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bTotWithChildAndAdults(BigInteger.valueOf(0));
			q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bTotWithOnlyChild(BigInteger.valueOf(0));
			q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bTotUnknownHouseholdType(BigInteger.valueOf(0));
			
		}
		}catch(Exception e) {
			logger.error("Error in Q26bBeanMaker:" + e);
		}
		
		return Arrays.asList(q26bNumberOfChronicallyHomelessPersonsByHouseholdTable); 
		
	}


}
