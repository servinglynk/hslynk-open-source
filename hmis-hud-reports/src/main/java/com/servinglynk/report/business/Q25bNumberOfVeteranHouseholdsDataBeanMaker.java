package com.servinglynk.report.business;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.servinglynk.hive.connection.ImpalaConnection;
import com.servinglynk.report.bean.Q25bNumberOfVeteranHouseholdsDataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.ClientModel;

public class Q25bNumberOfVeteranHouseholdsDataBeanMaker extends BaseBeanMaker {
	
	public static List<Q25bNumberOfVeteranHouseholdsDataBean> getQ25bNumberOfVeteranHouseholdsList(ReportData data){
		
		String query = "select distinct(e.dedup_client_id)  from %s.enrollment e join %s.project p  on (e.projectid = p.id   %p ) "+
			     " join %s.client c on e.client_id = c.id    "+ 
			     " where e.ageatentry >=18 and e.entrydate<=:endDate " ;
				Q25bNumberOfVeteranHouseholdsDataBean q25bNumberOfVeteranHouseholdsDataBean = new Q25bNumberOfVeteranHouseholdsDataBean();
				try {
					if(data.isLiveMode()) {
						List<String> projectsHHWithOneAdultChild = data.getProjectsHHWithOneAdultChild();
						List<String> projectsHHWithOutChildren = data.getProjectsHHWithOutChildren();
						List<String> projectsUnknownHouseHold = data.getProjectsUnknownHouseHold();
						
						
						List<String> chronicHomelessVeteran = getClientsFromVeteranStatus(data, query, null, true, "1", Boolean.TRUE);
						List<String> chronicHomelessVeteranWithoutChildren = getClientsFromVeteranStatus(data, query, projectsHHWithOutChildren, false, "1", Boolean.TRUE);
						List<String> chronicHomelessVeteranWithChildAndAdults = getClientsFromVeteranStatus(data, query, projectsHHWithOneAdultChild, false, "1", Boolean.TRUE);
						List<String> chronicHomelessVeteranUnknownHouseHold = getClientsFromVeteranStatus(data, query, projectsUnknownHouseHold, false, "1", Boolean.TRUE);
						int chVeteran = chronicHomelessVeteran != null ? chronicHomelessVeteran.size() : 0;
						int chVeteranWithoutChildren = chronicHomelessVeteranWithoutChildren != null ? chronicHomelessVeteranWithoutChildren.size() : 0;
						int chVeteranWithChildAndAdults = chronicHomelessVeteranWithChildAndAdults != null ? chronicHomelessVeteranWithChildAndAdults.size() : 0;
						int chVeteranUnknownHouseHold = chronicHomelessVeteranUnknownHouseHold != null ? chronicHomelessVeteranUnknownHouseHold.size() : 0 ;
					
						q25bNumberOfVeteranHouseholdsDataBean.setQ25bChronicallyHomelessVeteranTotal(BigInteger.valueOf(chVeteran));
						q25bNumberOfVeteranHouseholdsDataBean.setQ25bChronicallyHomelessVeteranWithoutChildren(BigInteger.valueOf(chVeteranWithoutChildren));
						q25bNumberOfVeteranHouseholdsDataBean.setQ25bChronicallyHomelessVeteranWithChildAndAdults(BigInteger.valueOf(chVeteranWithChildAndAdults));
						q25bNumberOfVeteranHouseholdsDataBean.setQ25bChronicallyHomelessVeteranUnknownHouseHold(BigInteger.valueOf(chVeteranUnknownHouseHold));
		
						List<String> nonChronicHomelessVeteran = getClientsFromVeteranStatus(data, query, null, true, "1", Boolean.FALSE);
						List<String> nonChronicHomelessVeteranWithoutChildren = getClientsFromVeteranStatus(data, query, projectsHHWithOutChildren, false, "1", Boolean.FALSE);
						List<String> nonChronicHomelessVeteranWithChildAndAdults = getClientsFromVeteranStatus(data, query, projectsHHWithOneAdultChild, false, "1", Boolean.FALSE);
						List<String> nonChronicHomelessVeteranUnknownHouseHold = getClientsFromVeteranStatus(data, query, projectsUnknownHouseHold, false, "1", Boolean.FALSE);
						int nonChVeteran = nonChronicHomelessVeteran != null ? nonChronicHomelessVeteran.size() : 0 ;
						int nonChVeteranWithoutChildren = nonChronicHomelessVeteranWithoutChildren != null ? nonChronicHomelessVeteranWithoutChildren.size() : 0;
						int nonChVeteranWithChildAndAdults = nonChronicHomelessVeteranWithChildAndAdults != null ? nonChronicHomelessVeteranWithChildAndAdults.size() : 0;	
						int nonChVeteranUnknownHouseHold = nonChronicHomelessVeteranUnknownHouseHold != null ? nonChronicHomelessVeteranUnknownHouseHold.size() : 0;
						
						q25bNumberOfVeteranHouseholdsDataBean.setQ25bNonChronicallyHomelessVeteranTotal(BigInteger.valueOf(nonChVeteran));
						q25bNumberOfVeteranHouseholdsDataBean.setQ25bNonChronicallyHomelessVeteranWithoutChildren(BigInteger.valueOf(nonChVeteranWithoutChildren));
						q25bNumberOfVeteranHouseholdsDataBean.setQ25bNonChronicallyHomelessVeteranWithChildAndAdults(BigInteger.valueOf(nonChVeteranWithChildAndAdults));
						q25bNumberOfVeteranHouseholdsDataBean.setQ25bNonChronicallyHomelessVeteranUnknownHouseHold(BigInteger.valueOf(nonChVeteranUnknownHouseHold));
		
						List<String> notVeteran = getClientsFromVeteranStatus(data, query, null, true, "0", null);
						List<String> notVeteranWithoutChildren = getClientsFromVeteranStatus(data, query, projectsHHWithOutChildren, false, "0", null);
						List<String> notVeteranithChildAndAdults = getClientsFromVeteranStatus(data, query, projectsHHWithOneAdultChild, false, "0", null);
						List<String> notVeteranUnknownHouseHold = getClientsFromVeteranStatus(data, query, projectsUnknownHouseHold, false, "0", null);
						
						int notVeteranSize = notVeteran != null ? notVeteran.size() : 0 ;
						int notVeteranWithoutChildrenSize = notVeteranWithoutChildren != null ? notVeteranWithoutChildren.size() : 0 ;
						int notVeteranithChildAndAdultsSize = notVeteranithChildAndAdults != null ? notVeteranithChildAndAdults.size() :0 ;
						int notVeteranUnknownHouseHoldSize = notVeteranUnknownHouseHold != null ? notVeteranUnknownHouseHold.size() :0 ;
						
						q25bNumberOfVeteranHouseholdsDataBean.setQ25bNotVeteranTotal(BigInteger.valueOf(notVeteranSize));
						q25bNumberOfVeteranHouseholdsDataBean.setQ25bNotVeteranWithoutChildren(BigInteger.valueOf(notVeteranWithoutChildrenSize));
						q25bNumberOfVeteranHouseholdsDataBean.setQ25bNotVeteranWithChildAndAdults(BigInteger.valueOf(notVeteranithChildAndAdultsSize));
						q25bNumberOfVeteranHouseholdsDataBean.setQ25bNotVeteranUnknownHouseHold(BigInteger.valueOf(notVeteranUnknownHouseHoldSize));
						List<String> clientRefused = getClientsFromVeteranStatus(data, query, null, true, "8", null);
						List<String> clientRefusedWithoutChildren = getClientsFromVeteranStatus(data, query, projectsHHWithOutChildren, false, "8", null);
						List<String> clientRefusedChildAndAdults = getClientsFromVeteranStatus(data, query, projectsHHWithOneAdultChild, false, "8", null);
						List<String> clientRefusedUnknownHouseHold = getClientsFromVeteranStatus(data, query, projectsUnknownHouseHold, false, "8", null);
						
						int clientRefusedSize = clientRefused != null ? clientRefused.size() : 0;
						int clientRefusedWithoutChildrenSize = clientRefusedWithoutChildren != null ? clientRefusedWithoutChildren.size() :0 ;
						int clientRefusedChildAndAdultsSize = clientRefusedChildAndAdults != null ? clientRefusedChildAndAdults.size() : 0;
						int clientRefusedUnknownHouseHoldSize = clientRefusedUnknownHouseHold != null ? clientRefusedUnknownHouseHold.size() : 0;
						
						q25bNumberOfVeteranHouseholdsDataBean.setQ25bClientRefusedTotal(BigInteger.valueOf(clientRefusedSize));
						q25bNumberOfVeteranHouseholdsDataBean.setQ25bClientRefusedWithoutChildren(BigInteger.valueOf(clientRefusedWithoutChildrenSize));
						q25bNumberOfVeteranHouseholdsDataBean.setQ25bClientRefusedWithChildAndAdults(BigInteger.valueOf(clientRefusedChildAndAdultsSize));
						q25bNumberOfVeteranHouseholdsDataBean.setQ25bClientRefusedUnknownHouseHold(BigInteger.valueOf(clientRefusedUnknownHouseHoldSize));
		
						
						List<String> dnc = getClientsFromVeteranStatus(data, query, null, true, "99", null);
						List<String> dncWithoutChildren = getClientsFromVeteranStatus(data, query, projectsHHWithOutChildren, false, "99", null);
						List<String> dncChildAndAdults = getClientsFromVeteranStatus(data, query, projectsHHWithOneAdultChild, false, "99", null);
						List<String> dncUnknownHouseHold = getClientsFromVeteranStatus(data, query, projectsUnknownHouseHold, false, "99", null);
						
						int dncSize = dnc != null ? dnc.size() : 0;
						int dncWithoutChildrenSize = dncWithoutChildren != null ? dncWithoutChildren.size() :0 ;
						int dncChildAndAdultsSize = dncChildAndAdults != null ? dncChildAndAdults.size() : 0;
						int dncUnknownHouseHoldSize = dncUnknownHouseHold != null ? dncUnknownHouseHold.size() : 0;
						
						q25bNumberOfVeteranHouseholdsDataBean.setQ25bDataNotCollectedTotal(BigInteger.valueOf(dncSize));
						q25bNumberOfVeteranHouseholdsDataBean.setQ25bDataNotCollectedWithoutChildren(BigInteger.valueOf(dncWithoutChildrenSize));
						q25bNumberOfVeteranHouseholdsDataBean.setQ25bDataNotCollectedWithChildAndAdults(BigInteger.valueOf(dncChildAndAdultsSize));
						q25bNumberOfVeteranHouseholdsDataBean.setQ25bDataNotCollectedUnknownHouseHold(BigInteger.valueOf(dncUnknownHouseHoldSize));
						
						int total = chVeteran + nonChVeteran + notVeteranSize + clientRefusedSize +dncSize;
						int nonChWithoutChildren =chVeteranWithoutChildren + nonChVeteranWithoutChildren + notVeteranWithoutChildrenSize + clientRefusedWithoutChildrenSize + dncWithoutChildrenSize;
						int nonnonChVeteranWithoutChild =chVeteranWithChildAndAdults + nonChVeteranWithChildAndAdults + notVeteranithChildAndAdultsSize + clientRefusedChildAndAdultsSize + dncChildAndAdultsSize;
						int nonChVeteranUnknown= chVeteranUnknownHouseHold + nonChVeteranUnknownHouseHold + nonChVeteranWithChildAndAdults +notVeteranUnknownHouseHoldSize + clientRefusedUnknownHouseHoldSize + dncUnknownHouseHoldSize ;
						
						
						q25bNumberOfVeteranHouseholdsDataBean.setQ25bTotTotal(BigInteger.valueOf(total));
						q25bNumberOfVeteranHouseholdsDataBean.setQ25bTotWithoutChildren(BigInteger.valueOf(nonChWithoutChildren));
						q25bNumberOfVeteranHouseholdsDataBean.setQ25bTotWithChildAndAdults(BigInteger.valueOf(nonnonChVeteranWithoutChild));
						q25bNumberOfVeteranHouseholdsDataBean.setQ25bTotUnknownHouseHold(BigInteger.valueOf(nonChVeteranUnknown));
					}	}catch(Exception e){
						logger.error("Error in Q25aNumberOfVeteransDataBeanMaker:" + e);
					}
		
		return Arrays.asList(q25bNumberOfVeteranHouseholdsDataBean);
	}
	
}
