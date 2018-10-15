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
import com.servinglynk.report.bean.Q24HomelessnessPreventionHousingAssessmentAtExitDataBean;
import com.servinglynk.report.bean.ReportData;

public class Q24HomelessnessPreventionHousingAssessmentAtExitDataBeanMaker extends BaseBeanMaker {
	
	public static List<Q24HomelessnessPreventionHousingAssessmentAtExitDataBean> getQ24HomelessnessPreventionHousingAssessmentAtExitList(ReportData data){
		Q24HomelessnessPreventionHousingAssessmentAtExitDataBean q24HomelessnessPreventionHousingAssessmentAtExitTable = new Q24HomelessnessPreventionHousingAssessmentAtExitDataBean();
			
		String query ="select distinct(e.dedup_client_id)  from enrollment e join %s.project p  on (e.projectid = p.id  %p ) "+			
						" join %s.exit ext on (e.id = ext.enrollmentid and ext.exitdate  >=  :startDate and  ext.exitdate<= :endDate) "+
					    " join %s.exithousingassessment eha on (ext.id = eha.exitid %h) "+
					    " order by e.dedup_client_id  ";
		try {
			if(data.isLiveMode()) {
				List<String> projectsHHWithChildren = data.getProjectsHHWithChildren();
				List<String> projectsHHWithOneAdultChild = data.getProjectsHHWithOneAdultChild();
				List<String> projectsHHWithOutChildren = data.getProjectsHHWithOutChildren();
				List<String> projectsUnknownHouseHold = data.getProjectsUnknownHouseHold();
				
				List<String> ableToMaintainWithoutSubsidy = getClients(data, query, null, true, "1", "1");
				List<String> ableToMaintainWithoutSubsidyWithChildren = getClients(data, query, projectsHHWithChildren, false,  "1", "1");
				List<String> ableToMaintainWithoutSubsidyWithOneAdultChild = getClients(data, query, projectsHHWithOneAdultChild, false,  "1", "1");
				List<String> ableToMaintainWithoutSubsidyWithOutChildren = getClients(data, query, projectsHHWithOutChildren, false,  "1", "1");
				List<String> ableToMaintainWithoutSubsidyUnknownHouseHold = getClients(data, query, projectsUnknownHouseHold, false, "1", "1");
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24AbleToMaintainWithoutSubsidyTotal(BigInteger.valueOf(ableToMaintainWithoutSubsidy != null ? ableToMaintainWithoutSubsidy.size() : 0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24AbleToMaintainWithoutSubsidyWithoutChild(BigInteger.valueOf(ableToMaintainWithoutSubsidyWithOutChildren != null ? ableToMaintainWithoutSubsidyWithOutChildren.size() : 0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24AbleToMaintainWithoutSubsidyWithChildAndAdults(BigInteger.valueOf(ableToMaintainWithoutSubsidyWithOneAdultChild != null ? ableToMaintainWithoutSubsidyWithOneAdultChild.size() : 0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24AbleToMaintainWithoutSubsidyWithOnlyChild(BigInteger.valueOf(ableToMaintainWithoutSubsidyWithChildren != null ? ableToMaintainWithoutSubsidyWithChildren.size() : 0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24AbleToMaintainWithoutSubsidyUnknownHouseHold(BigInteger.valueOf(ableToMaintainWithoutSubsidyUnknownHouseHold != null ? ableToMaintainWithoutSubsidyUnknownHouseHold.size() : 0));
				
				List<String> ableToMaintainWithSubsidy = getClients(data, query, null, true, "1", "2");
				List<String> ableToMaintainWithSubsidyWithChildren = getClients(data, query, projectsHHWithChildren, false, "1", "2");
				List<String> ableToMaintainWithSubsidyWithOneAdultChild = getClients(data, query, projectsHHWithOneAdultChild, false, "1", "2");
				List<String> ableToMaintainWithSubsidyWithOutChildren = getClients(data, query, projectsHHWithOutChildren, false, "1", "2");
				List<String> ableToMaintainWithSubsidyUnknownHouseHold = getClients(data, query, projectsUnknownHouseHold, false, "1", "2");
				
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24AbleToMaintainWithSubsidyTotal(BigInteger.valueOf(ableToMaintainWithSubsidy != null ? ableToMaintainWithSubsidy.size() : 0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24AbleToMaintainWithSubsidyWithoutChild(BigInteger.valueOf(ableToMaintainWithSubsidyWithOutChildren != null ? ableToMaintainWithSubsidyWithOutChildren.size() : 0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24AbleToMaintainWithSubsidyWithChildAndAdults(BigInteger.valueOf(ableToMaintainWithSubsidyWithOneAdultChild != null ? ableToMaintainWithSubsidyWithOneAdultChild.size() : 0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24AbleToMaintainWithSubsidyWithOnlyChild(BigInteger.valueOf(ableToMaintainWithSubsidyWithChildren != null ? ableToMaintainWithSubsidyWithChildren.size() : 0 ));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24AbleToMaintainWithSubsidyUnknownHouseHold(BigInteger.valueOf(ableToMaintainWithSubsidyUnknownHouseHold != null ? ableToMaintainWithSubsidyUnknownHouseHold.size() : 0));
				
				List<String> ableToMaintainWithOngoingSubsidy = getClients(data, query, null, true, "1", "3");
				List<String> ableToMaintainWithOngoingSubsidyWithChildren = getClients(data, query, projectsHHWithChildren, false, "1", "3");
				List<String> ableToMaintainWithOngoingSubsidyWithOneAdultChild = getClients(data, query, projectsHHWithOneAdultChild, false, "1", "3");
				List<String> ableToMaintainWithOngoingSubsidyWithOutChildren = getClients(data, query, projectsHHWithOutChildren, false, "1", "3");
				List<String> ableToMaintainWithOngoingSubsidyUnknownHouseHold = getClients(data, query, projectsUnknownHouseHold, false, "1", "3");
				
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24AbleToMaintainOngoingSubsidyTotal(BigInteger.valueOf(ableToMaintainWithOngoingSubsidy != null ? ableToMaintainWithOngoingSubsidy.size() : 0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24AbleToMaintainOngoingSubsidyWithoutChild(BigInteger.valueOf(ableToMaintainWithOngoingSubsidyWithOutChildren != null ? ableToMaintainWithOngoingSubsidyWithOutChildren.size() : 0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24AbleToMaintainOngoingSubsidyWithChildAndAdults(BigInteger.valueOf(ableToMaintainWithOngoingSubsidyWithOneAdultChild != null ? ableToMaintainWithOngoingSubsidyWithOneAdultChild.size() : 0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24AbleToMaintainOngoingSubsidyWithOnlyChild(BigInteger.valueOf(ableToMaintainWithOngoingSubsidyWithChildren != null ? ableToMaintainWithOngoingSubsidyWithChildren.size() : 0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24AbleToMaintainOngoingSubsidyUnknownHouseHold(BigInteger.valueOf(ableToMaintainWithOngoingSubsidyUnknownHouseHold != null ? ableToMaintainWithOngoingSubsidyUnknownHouseHold.size() : 0));
				
				List<String> ableToMaintainOtherThanSubsidy = getClients(data, query, null, true, "1", "4");
				List<String> ableToMaintainOtherThanSubsidyyWithChildren = getClients(data, query, projectsHHWithChildren, false, "1", "4");
				List<String> ableToMaintainOtherThanSubsidyWithOneAdultChild = getClients(data, query, projectsHHWithOneAdultChild, false, "1", "4");
				List<String> ableToMaintainOtherThanSubsidyWithOutChildren = getClients(data, query, projectsHHWithOutChildren, false, "1", "4");
				List<String> ableToMaintainOtherThanSubsidyUnknownHouseHold = getClients(data, query, projectsUnknownHouseHold, false, "1", "4");
				
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24AbleToMaintainOtherThanSubsidyTotal(BigInteger.valueOf(ableToMaintainOtherThanSubsidy != null ? ableToMaintainOtherThanSubsidy.size() : 0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24AbleToMaintainOtherThanSubsidyWithoutChild(BigInteger.valueOf(ableToMaintainOtherThanSubsidyWithOutChildren != null ? ableToMaintainOtherThanSubsidyWithOutChildren.size() :0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24AbleToMaintainOtherThanSubsidyWithChildAndAdults(BigInteger.valueOf(ableToMaintainOtherThanSubsidyWithOneAdultChild != null ? ableToMaintainOtherThanSubsidyWithOneAdultChild.size() : 0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24AbleToMaintainOtherThanSubsidyWithOnlyChild(BigInteger.valueOf(ableToMaintainOtherThanSubsidyyWithChildren != null ? ableToMaintainOtherThanSubsidyyWithChildren.size() :0 ));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24AbleToMaintainOtherThanSubsidyUnknownHouseHold(BigInteger.valueOf(ableToMaintainOtherThanSubsidyUnknownHouseHold != null ? ableToMaintainOtherThanSubsidyUnknownHouseHold.size() : 0));
				
				List<String> movedWithOngoingSubsidy = getClients(data, query, null, true, "2", "3");
				List<String> movedWithOngoingSubsidyWithOnlyChild = getClients(data, query, projectsHHWithChildren, false, "2", "3");
				List<String> movedWithOngoingSubsidyWithChildAndAdults = getClients(data, query, projectsHHWithOneAdultChild, false, "2", "3");
				List<String> movedWithOngoingSubsidyWithoutChild = getClients(data, query, projectsHHWithOutChildren, false, "2", "3");
				List<String> movedWithOngoingSubsidyUnknownHouseHold = getClients(data, query, projectsUnknownHouseHold, false, "2", "3");
				
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24MovedWithOngoingSubsidyTotal(BigInteger.valueOf(movedWithOngoingSubsidy != null ? movedWithOngoingSubsidy.size() :0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24MovedWithOngoingSubsidyWithoutChild(BigInteger.valueOf(movedWithOngoingSubsidyWithoutChild != null ? movedWithOngoingSubsidyWithoutChild.size() : 0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24MovedWithOngoingSubsidyWithChildAndAdults(BigInteger.valueOf(movedWithOngoingSubsidyWithChildAndAdults != null ? movedWithOngoingSubsidyWithChildAndAdults.size() :0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24MovedWithOngoingSubsidyWithOnlyChild(BigInteger.valueOf(movedWithOngoingSubsidyWithOnlyChild != null ? movedWithOngoingSubsidyWithOnlyChild.size() : 0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24MovedWithOngoingSubsidyUnknownHouseHold(BigInteger.valueOf(movedWithOngoingSubsidyUnknownHouseHold != null ? movedWithOngoingSubsidyUnknownHouseHold.size() : 0));
				
				List<String> movedWithoutOngoingSubsidy = getClients(data, query, null, true, "2", "1");
				List<String> movedWithoutOngoingSubsidyWithOnlyChild = getClients(data, query, projectsHHWithChildren, false, "2", "1");
				List<String> movedWithoutOngoingSubsidyWithChildAndAdults = getClients(data, query, projectsHHWithOneAdultChild, false, "2", "1");
				List<String> movedWithoutOngoingSubsidyWithoutChild = getClients(data, query, projectsHHWithOutChildren, false, "2", "1");
				List<String> movedWithoutOngoingSubsidyUnknownHouseHold = getClients(data, query, projectsUnknownHouseHold, false, "2", "1");
				
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24MovedWithoutOngoingSubsidyTotal(BigInteger.valueOf(movedWithoutOngoingSubsidy != null ? movedWithoutOngoingSubsidy.size() : 0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24MovedWithoutOngoingSubsidyWithoutChild(BigInteger.valueOf(movedWithoutOngoingSubsidyWithoutChild != null ? movedWithoutOngoingSubsidyWithoutChild.size() :0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24MovedWithoutOngoingSubsidyWithChildAndAdults(BigInteger.valueOf(movedWithoutOngoingSubsidyWithChildAndAdults != null ? movedWithoutOngoingSubsidyWithChildAndAdults.size() : 0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24MovedWithoutOngoingSubsidyWithOnlyChild(BigInteger.valueOf(movedWithoutOngoingSubsidyWithOnlyChild != null ? movedWithoutOngoingSubsidyWithOnlyChild.size() : 0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24MovedWithoutOngoingSubsidyUnknownHouseHold(BigInteger.valueOf(movedWithoutOngoingSubsidyUnknownHouseHold != null ? movedWithoutOngoingSubsidyUnknownHouseHold.size() : 0));
				
				List<String> movedTemporaryBasis = getClients(data, query, null, true, "3", null);
				List<String> movedTemporaryBasisWithOnlyChild = getClients(data, query, projectsHHWithChildren, false, "3", null);
				List<String> movedTemporaryBasisWithChildAndAdults = getClients(data, query, projectsHHWithOneAdultChild, false, "3", null);
				List<String> movedTemporaryBasisWithoutChild = getClients(data, query, projectsHHWithOutChildren, false, "3", null);
				List<String> movedTemporaryBasisUnknownHouseHold = getClients(data, query, projectsUnknownHouseHold, false, "3", null);
				
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24MovedTemporaryBasisTotal(BigInteger.valueOf(movedTemporaryBasis != null ? movedTemporaryBasis.size() : 0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24MovedTemporaryBasisWithoutChild(BigInteger.valueOf(movedTemporaryBasisWithoutChild != null ? movedTemporaryBasisWithoutChild.size() : 0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24MovedTemporaryBasisWithChildAndAdults(BigInteger.valueOf(movedTemporaryBasisWithChildAndAdults != null ? movedTemporaryBasisWithChildAndAdults.size() : 0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24MovedTemporaryBasisWithOnlyChild(BigInteger.valueOf(movedTemporaryBasisWithOnlyChild != null ? movedTemporaryBasisWithOnlyChild.size() : 0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24MovedTemporaryBasisUnknownHouseHold(BigInteger.valueOf(movedTemporaryBasisUnknownHouseHold != null ? movedTemporaryBasisUnknownHouseHold.size() : 0));
				
				List<String> movedPermenantBasis = getClients(data, query, null, true, "4", null);
				List<String> movedPermenantBasisWithOnlyChild = getClients(data, query, projectsHHWithChildren, false, "4", null);
				List<String> movedPermenantBasisWithChildAndAdults = getClients(data, query, projectsHHWithOneAdultChild, false, "4", null);
				List<String> movedPermenantBasisWithoutChild = getClients(data, query, projectsHHWithOutChildren, false, "4", null);
				List<String> movedPermenantBasisUnknownHouseHold = getClients(data, query, projectsUnknownHouseHold, false, "4", null);
				
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24MovedPermenantBasisTotal(BigInteger.valueOf(movedPermenantBasis != null ? movedPermenantBasis.size() : 0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24MovedPermenantBasisWithoutChild(BigInteger.valueOf(movedPermenantBasisWithoutChild != null ? movedPermenantBasisWithoutChild.size() : 0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24MovedPermenantBasisWithChildAndAdults(BigInteger.valueOf(movedPermenantBasisWithChildAndAdults !=  null ? movedPermenantBasisWithChildAndAdults.size() : 0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24MovedPermenantBasisWithOnlyChild(BigInteger.valueOf(movedPermenantBasisWithOnlyChild != null ? movedPermenantBasisWithOnlyChild.size() : 0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24MovedPermenantBasisUnknownHouseHold(BigInteger.valueOf(movedPermenantBasisUnknownHouseHold != null ? movedPermenantBasisUnknownHouseHold.size() : 0));
			
				List<String> movedToTransitional = getClients(data, query, null, true, "5", null);
				List<String> movedToTransitionalWithOnlyChild = getClients(data, query, projectsHHWithChildren, false, "5", null);
				List<String> movedToTransitionalWithChildAndAdults = getClients(data, query, projectsHHWithOneAdultChild, false, "5", null);
				List<String> movedToTransitionalWithoutChild = getClients(data, query, projectsHHWithOutChildren, false, "5", null);
				List<String> movedToTransitionalUnknownHouseHold = getClients(data, query, projectsUnknownHouseHold, false, "5", null);
				
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24MovedToTransitionalTotal(BigInteger.valueOf(movedToTransitional != null ? movedToTransitional.size() : 0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24MovedToTransitionalWithoutChild(BigInteger.valueOf(movedToTransitionalWithoutChild != null ? movedToTransitionalWithoutChild.size() : 0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24MovedToTransitionalWithChildAndAdults(BigInteger.valueOf(movedToTransitionalWithChildAndAdults != null ? movedToTransitionalWithChildAndAdults.size() : 0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24MovedToTransitionalWithOnlyChild(BigInteger.valueOf(movedToTransitionalWithOnlyChild != null ? movedToTransitionalWithOnlyChild.size() : 0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24MovedToTransitionalUnknownHouseHold(BigInteger.valueOf(movedToTransitionalUnknownHouseHold != null ? movedToTransitionalUnknownHouseHold.size() : 0));
				
				List<String> clientBecameHomeless = getClients(data, query, null, true, "6", null);
				List<String> clientBecameHomelessWithOnlyChild = getClients(data, query, projectsHHWithChildren, false, "6", null);
				List<String> clientBecameHomelesslWithChildAndAdults = getClients(data, query, projectsHHWithOneAdultChild, false, "6", null);
				List<String> clientBecameHomelessWithoutChild = getClients(data, query, projectsHHWithOutChildren, false, "6", null);
				List<String> clientBecameHomelessUnknownHouseHold = getClients(data, query, projectsUnknownHouseHold, false, "6", null);
				
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24ClientBecameHomelessTotal(BigInteger.valueOf(clientBecameHomeless != null ? clientBecameHomeless.size() : 0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24ClientBecameHomelessWithoutChild(BigInteger.valueOf(clientBecameHomelessWithoutChild != null ? clientBecameHomelessWithoutChild.size() : 0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24ClientBecameHomelessWithChildAndAdults(BigInteger.valueOf(clientBecameHomelesslWithChildAndAdults != null ? clientBecameHomelesslWithChildAndAdults.size() : 0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24ClientBecameHomelessWithOnlyChild(BigInteger.valueOf(clientBecameHomelessWithOnlyChild != null ? clientBecameHomelessWithOnlyChild.size() : 0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24ClientBecameHomelessUnknownHouseHold(BigInteger.valueOf(clientBecameHomelessUnknownHouseHold != null ? clientBecameHomelessUnknownHouseHold.size() : 0));
			
				List<String> clientWenToJail = getClients(data, query, null, true, "7", null);
				List<String> clientWenToJailWithOnlyChild = getClients(data, query, projectsHHWithChildren, false, "7", null);
				List<String> clientWenToJailWithChildAndAdults = getClients(data, query, projectsHHWithOneAdultChild, false, "7", null);
				List<String> clientWenToJailWithoutChild = getClients(data, query, projectsHHWithOutChildren, false, "7", null);
				List<String> clientWenToJailUnknownHouseHold = getClients(data, query, projectsUnknownHouseHold, false, "7", null);
				
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24ClientWenToJailTotal(BigInteger.valueOf(clientWenToJail != null? clientWenToJail.size() : 0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24ClientWenToJailWithoutChild(BigInteger.valueOf(clientWenToJailWithoutChild != null ? clientWenToJailWithoutChild.size() : 0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24ClientWenToJailWithChildAndAdults(BigInteger.valueOf(clientWenToJailWithChildAndAdults != null ? clientWenToJailWithChildAndAdults.size() : 0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24ClientWenToJailWithOnlyChild(BigInteger.valueOf(clientWenToJailWithOnlyChild != null ? clientWenToJailWithOnlyChild.size() : 0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24ClientWenToJailUnknownHouseHold(BigInteger.valueOf(clientWenToJailUnknownHouseHold != null ? clientWenToJailUnknownHouseHold.size() : 0));
			
				List<String> clientDied = getClients(data, query, null, true, "10", null);
				List<String> clientDiedWithOnlyChild = getClients(data, query, projectsHHWithChildren, false, "10", null);
				List<String> clientDiedWithChildAndAdults = getClients(data, query, projectsHHWithOneAdultChild, false, "10", null);
				List<String> clientDiedWithoutChild = getClients(data, query, projectsHHWithOutChildren, false, "10", null);
				List<String> clientDiedUnknownHouseHold = getClients(data, query, projectsUnknownHouseHold, false, "10", null);
				
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24ClientDiedTotal(BigInteger.valueOf(clientDied != null ? clientDied.size() : 0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24ClientDiedWithoutChild(BigInteger.valueOf(clientDiedWithoutChild != null ? clientDiedWithoutChild.size() : 0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24ClientDiedWithChildAndAdults(BigInteger.valueOf(clientDiedWithChildAndAdults != null ? clientDiedWithChildAndAdults.size() : 0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24ClientDiedWithOnlyChild(BigInteger.valueOf(clientDiedWithOnlyChild != null ? clientDiedWithOnlyChild.size() : 0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24ClientDiedUnknownHouseHold(BigInteger.valueOf(clientDiedUnknownHouseHold != null ? clientDiedUnknownHouseHold.size() : 0));
		
				List<String> clientDoesntKnow = getClients(data, query, null, true, "8", null);
				List<String> clientDoesntKnowWithOnlyChild = getClients(data, query, projectsHHWithChildren, false, "8", null);
				List<String> clientDoesntKnowWithChildAndAdults = getClients(data, query, projectsHHWithOneAdultChild, false, "8", null);
				List<String> clientDoesntKnowWithoutChild = getClients(data, query, projectsHHWithOutChildren, false, "8", null);
				List<String> clientDoesntKnowUnknownHouseHold = getClients(data, query, projectsUnknownHouseHold, false, "8", null);
				
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24ClientDoesntKnowTotal(BigInteger.valueOf(clientDoesntKnow != null ? clientDoesntKnow.size() : 0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24ClientDoesntKnowWithoutChild(BigInteger.valueOf(clientDoesntKnowWithoutChild != null ? clientDoesntKnowWithoutChild.size() : 0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24ClientDoesntKnowWithChildAndAdults(BigInteger.valueOf(clientDoesntKnowWithChildAndAdults != null ? clientDoesntKnowWithChildAndAdults.size() : 0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24ClientDoesntKnowWithOnlyChild(BigInteger.valueOf(clientDoesntKnowWithOnlyChild != null ? clientDoesntKnowWithOnlyChild.size() : 0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24ClientDoesntKnowUnknownHouseHold(BigInteger.valueOf(clientDoesntKnowUnknownHouseHold != null ? clientDoesntKnowUnknownHouseHold.size() : 0));
			
				List<String> dataNotCollected = getClients(data, query, null, true, "99", null);
				List<String> dataNotCollectedWithOnlyChild = getClients(data, query, projectsHHWithChildren, false, "99", null);
				List<String> dataNotCollectedWithChildAndAdults = getClients(data, query, projectsHHWithOneAdultChild, false, "99", null);
				List<String> dataNotCollectedWithoutChild = getClients(data, query, projectsHHWithOutChildren, false, "99", null);
				List<String> dataNotCollectedUnknownHouseHold = getClients(data, query, projectsUnknownHouseHold, false, "99", null);
				
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24DataNotCollectedTotal(BigInteger.valueOf(dataNotCollected != null ? dataNotCollected.size() : 0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24DataNotCollectedWithoutChild(BigInteger.valueOf(dataNotCollectedWithoutChild != null ? dataNotCollectedWithoutChild.size() : 0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24DataNotCollectedWithChildAndAdults(BigInteger.valueOf(dataNotCollectedWithChildAndAdults != null ? dataNotCollectedWithChildAndAdults.size() : 0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24DataNotCollectedWithOnlyChild(BigInteger.valueOf(dataNotCollectedWithOnlyChild != null ? dataNotCollectedWithOnlyChild.size() : 0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24DataNotCollectedUnknownHouseHold(BigInteger.valueOf(dataNotCollectedUnknownHouseHold != null ? dataNotCollectedUnknownHouseHold.size() : 0));
		
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24TotTotal(BigInteger.valueOf(0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24TotWithoutChild(BigInteger.valueOf(0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24TotWithChildAndAdults(BigInteger.valueOf(0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24TotWithOnlyChild(BigInteger.valueOf(0));
				q24HomelessnessPreventionHousingAssessmentAtExitTable.setQ24TotUnknownHouseHold(BigInteger.valueOf(0));
			}
		}catch(Exception e) {
			logger.error("Error in Q24HomelessnessPreventionHousingAssessmentAtExitDataBeanMaker:" + e);
		}
				
		return Arrays.asList(q24HomelessnessPreventionHousingAssessmentAtExitTable);
	
	}
	
	public static List<String> getClients(ReportData data,String query,List<String> filteredProjectIds, boolean allProjects,String housingassessment, String  subsidyInformation) {
		 List<String> q22Beans = new ArrayList<String>();
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
					 newQuery = query.replace("%p", ")");
				 }
				if(StringUtils.isNotBlank(housingassessment) && !StringUtils.equals("8", housingassessment)) {
					newQuery = newQuery.replace("%h"," and housingassessment ='"+housingassessment+"'");
				}
				if(StringUtils.equals("8", housingassessment)) {
					newQuery = newQuery.replace("%h"," and housingassessment  in ('8','9)' ");
				}
				if(StringUtils.isNotBlank(subsidyInformation)) {
					newQuery = newQuery.replace("%h"," and subsidyinformation ='"+subsidyInformation+"'");
				}
				
				statement = connection.createStatement();
				resultSet = statement.executeQuery(formatQuery(newQuery,data.getSchema(),data));
				
			 while(resultSet.next()) {
				
				 
				 String dedupClientId = resultSet.getString("dedup_client_id");
				 q22Beans.add(dedupClientId);
			 
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
