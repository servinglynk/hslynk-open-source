package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import com.servinglynk.report.bean.Q26cGenderOfChronicallyHomelessPersonDataBean;
import com.servinglynk.report.bean.ReportData;

public class Q26cGenderOfChronicallyHomelessPersonDataBeanMaker extends BaseBeanMaker {
	
	public static List<Q26cGenderOfChronicallyHomelessPersonDataBean> getQ26cGenderOfChronicallyHomelessPersonList(ReportData data){
		
		Q26cGenderOfChronicallyHomelessPersonDataBean q26cGenderOfChronicallyHomelessPersonTable = new Q26cGenderOfChronicallyHomelessPersonDataBean();
		try {
			List<String> projectsHHWithChildren = data.getProjectsHHWithChildren();
			List<String> projectsHHWithOneAdultChild = data.getProjectsHHWithOneAdultChild();
			List<String> projectsHHWithOutChildren = data.getProjectsHHWithOutChildren();
			List<String> projectsUnknownHouseHold = data.getProjectsUnknownHouseHold();
			
			String maleCHQuery ="select distinct(dedup_client_id) from %s.enrollment e,%s.client c,%.project p  where c.id =e.client_id and c.gender = '1' and e.chronichomeless='true' and e.projectid = p.id %p";
			String femaleCHQuery ="select distinct(dedup_client_id) from enrollment e,%s.client c,%.project p  where c.id =e.client_id and c.gender = '0' and e.chronichomeless='false' and e.projectid = p.id %p";
			String transFemaleCHQuery ="select distinct(dedup_client_id) from enrollment e,%s.client c,%.project p  where c.id =e.client_id and c.gender = '2' and e.disablingcondition in ('8','9') and e.projectid = p.id %p";
			String transMaleCHQuery ="select distinct(dedup_client_id) from enrollment e,%s.client c,%.project p  where c.id =e.client_id and c.gender = '3' and e.disablingcondition ='99' and e.projectid = p.id %p";
			String genderNotConfirmingCHQuery ="select distinct(dedup_client_id) from enrollment e,%s.client c,%.project p  where c.id =e.client_id and c.gender = '4' and e.disablingcondition ='99' and e.projectid = p.id %p";
			String dkrCHQuery ="select distinct(dedup_client_id) from enrollment e,%s.client c,%.project p  where c.id =e.client_id and c.gender in ('8','9')  and e.disablingcondition ='99' and e.projectid = p.id %p";
			String dncCHQuery ="select distinct(dedup_client_id) from enrollment e,%s.client c,%.project p  where c.id =e.client_id and c.gender = '99' and e.disablingcondition ='99' and e.projectid = p.id %p";
			
			if(data.isLiveMode()) {
			
				int maleCHSize = getSize(getClients(data, maleCHQuery, null, true));
				int maleCHWithoutChildSize = getSize(getClients(data, maleCHQuery, projectsHHWithOutChildren, false));
				int maleCHChildAndAdultsSize = getSize(getClients(data, maleCHQuery, projectsHHWithOneAdultChild, false));
				int maleCHWithOnlyChildSize = getSize(getClients(data, maleCHQuery, projectsHHWithChildren, false));
				int maleCHUnknownHouseHoldSize = getSize(getClients(data, maleCHQuery, projectsUnknownHouseHold, false));
				
				q26cGenderOfChronicallyHomelessPersonTable.setQ26cMaleTotal(BigInteger.valueOf(maleCHSize));
				q26cGenderOfChronicallyHomelessPersonTable.setQ26cMaleWithoutChild(BigInteger.valueOf(maleCHWithoutChildSize));
				q26cGenderOfChronicallyHomelessPersonTable.setQ26cMaleWithChildAndAdults(BigInteger.valueOf(maleCHChildAndAdultsSize));
				q26cGenderOfChronicallyHomelessPersonTable.setQ26cMaleWithOnlyChild(BigInteger.valueOf(maleCHWithOnlyChildSize));
				q26cGenderOfChronicallyHomelessPersonTable.setQ26cMaleUnknownHouseholdType(BigInteger.valueOf(maleCHUnknownHouseHoldSize));
			
				int femaleCHSize = getSize(getClients(data, femaleCHQuery, null, true));
				int femaleCHWithoutChildSize = getSize(getClients(data, femaleCHQuery, projectsHHWithOutChildren, false));
				int femaleCHChildAndAdultsSize = getSize(getClients(data, femaleCHQuery, projectsHHWithOneAdultChild, false));
				int femaleCHWithOnlyChildSize = getSize(getClients(data, femaleCHQuery, projectsHHWithChildren, false));
				int femaleCHUnknownHouseHoldSize = getSize(getClients(data, femaleCHQuery, projectsUnknownHouseHold, false));
				
				q26cGenderOfChronicallyHomelessPersonTable.setQ26cFemaleTotal(BigInteger.valueOf(femaleCHSize));
				q26cGenderOfChronicallyHomelessPersonTable.setQ26cFemaleWithoutChild(BigInteger.valueOf(femaleCHWithoutChildSize));
				q26cGenderOfChronicallyHomelessPersonTable.setQ26cFemaleWithChildAndAdults(BigInteger.valueOf(femaleCHChildAndAdultsSize));
				q26cGenderOfChronicallyHomelessPersonTable.setQ26cFemaleWithOnlyChild(BigInteger.valueOf(femaleCHWithOnlyChildSize));
				q26cGenderOfChronicallyHomelessPersonTable.setQ26cFemaleUnknownHouseholdType(BigInteger.valueOf(femaleCHUnknownHouseHoldSize));

				
				int transFemaleCHSize = getSize(getClients(data, transFemaleCHQuery, null, true));
				int transFemaleCHWithoutChildSize = getSize(getClients(data, transFemaleCHQuery, projectsHHWithOutChildren, false));
				int transFemaleCHChildAndAdultsSize = getSize(getClients(data, transFemaleCHQuery, projectsHHWithOneAdultChild, false));
				int transFemaleCHWithOnlyChildSize = getSize(getClients(data, transFemaleCHQuery, projectsHHWithChildren, false));
				int transFemaleCHUnknownHouseHoldSize = getSize(getClients(data, transFemaleCHQuery, projectsUnknownHouseHold, false));
				
				q26cGenderOfChronicallyHomelessPersonTable.setQ26cTransgenderMaleToFemaleTotal(BigInteger.valueOf(transFemaleCHSize));
				q26cGenderOfChronicallyHomelessPersonTable.setQ26cTransgenderMaleToFemaleWithoutChild(BigInteger.valueOf(transFemaleCHWithoutChildSize));
				q26cGenderOfChronicallyHomelessPersonTable.setQ26cTransgenderMaleToFemaleWithChildAndAdults(BigInteger.valueOf(transFemaleCHChildAndAdultsSize));
				q26cGenderOfChronicallyHomelessPersonTable.setQ26cTransgenderMaleToFemaleWithOnlyChild(BigInteger.valueOf(transFemaleCHWithOnlyChildSize));
				q26cGenderOfChronicallyHomelessPersonTable.setQ26cTransgenderMaleToFemaleUnknownHouseholdType(BigInteger.valueOf(transFemaleCHUnknownHouseHoldSize));

				int transMaleCHSize = getSize(getClients(data, transMaleCHQuery, null, true));
				int transMaleCHWithoutChildSize = getSize(getClients(data, transMaleCHQuery, projectsHHWithOutChildren, false));
				int transMaleCHChildAndAdultsSize = getSize(getClients(data, transMaleCHQuery, projectsHHWithOneAdultChild, false));
				int transMaleCHWithOnlyChildSize = getSize(getClients(data, transMaleCHQuery, projectsHHWithChildren, false));
				int transMaleCHUnknownHouseHoldSize = getSize(getClients(data, transMaleCHQuery, projectsUnknownHouseHold, false));
				
				q26cGenderOfChronicallyHomelessPersonTable.setQ26cTransgenderFemaleToMaleTotal(BigInteger.valueOf(transMaleCHSize));
				q26cGenderOfChronicallyHomelessPersonTable.setQ26cTransgenderFemaleToMaleWithoutChild(BigInteger.valueOf(transMaleCHWithoutChildSize));
				q26cGenderOfChronicallyHomelessPersonTable.setQ26cTransgenderFemaleToMaleWithChildAndAdults(BigInteger.valueOf(transMaleCHChildAndAdultsSize));
				q26cGenderOfChronicallyHomelessPersonTable.setQ26cTransgenderFemaleToMaleWithOnlyChild(BigInteger.valueOf(transMaleCHWithOnlyChildSize));
				q26cGenderOfChronicallyHomelessPersonTable.setQ26cTransgenderFemaleToMaleUnknownHouseholdType(BigInteger.valueOf(transMaleCHUnknownHouseHoldSize));

				int genderNotConfirmingCHSize = getSize(getClients(data, genderNotConfirmingCHQuery, null, true));
				int genderNotConfirmingCHWithoutChildSize = getSize(getClients(data, genderNotConfirmingCHQuery, projectsHHWithOutChildren, false));
				int genderNotConfirmingCHChildAndAdultsSize = getSize(getClients(data, genderNotConfirmingCHQuery, projectsHHWithOneAdultChild, false));
				int genderNotConfirmingCHWithOnlyChildSize = getSize(getClients(data, genderNotConfirmingCHQuery, projectsHHWithChildren, false));
				int genderNotConfirmingCHUnknownHouseHoldSize = getSize(getClients(data, transMaleCHQuery, projectsUnknownHouseHold, false));
				
				q26cGenderOfChronicallyHomelessPersonTable.setQ26cOtherTotal(BigInteger.valueOf(genderNotConfirmingCHSize));
				q26cGenderOfChronicallyHomelessPersonTable.setQ26cOtherWithoutChild(BigInteger.valueOf(genderNotConfirmingCHWithoutChildSize));
				q26cGenderOfChronicallyHomelessPersonTable.setQ26cOtherWithChildAndAdults(BigInteger.valueOf(genderNotConfirmingCHChildAndAdultsSize));
				q26cGenderOfChronicallyHomelessPersonTable.setQ26cOtherWithOnlyChild(BigInteger.valueOf(genderNotConfirmingCHWithOnlyChildSize));
				q26cGenderOfChronicallyHomelessPersonTable.setQ26cOtherUnknownHouseholdType(BigInteger.valueOf(genderNotConfirmingCHUnknownHouseHoldSize));

				int dkrCHSize = getSize(getClients(data, dkrCHQuery, null, true));
				int dkrCHWithoutChildSize = getSize(getClients(data, dkrCHQuery, projectsHHWithOutChildren, false));
				int dkrCHChildAndAdultsSize = getSize(getClients(data, dkrCHQuery, projectsHHWithOneAdultChild, false));
				int dkrCHWithOnlyChildSize = getSize(getClients(data, dkrCHQuery, projectsHHWithChildren, false));
				int dkrCHUnknownHouseHoldSize = getSize(getClients(data, dkrCHQuery, projectsUnknownHouseHold, false));
				
				q26cGenderOfChronicallyHomelessPersonTable.setQ26cDKRTotal(BigInteger.valueOf(dkrCHSize));
				q26cGenderOfChronicallyHomelessPersonTable.setQ26cDKRWithoutChild(BigInteger.valueOf(dkrCHWithoutChildSize));
				q26cGenderOfChronicallyHomelessPersonTable.setQ26cDKRWithChildAndAdults(BigInteger.valueOf(dkrCHChildAndAdultsSize));
				q26cGenderOfChronicallyHomelessPersonTable.setQ26cDKRWithOnlyChild(BigInteger.valueOf(dkrCHWithOnlyChildSize));
				q26cGenderOfChronicallyHomelessPersonTable.setQ26cDKRUnknownHouseholdType(BigInteger.valueOf(dkrCHUnknownHouseHoldSize));

				int dncCHSize = getSize(getClients(data, dncCHQuery, null, true));
				int dncCHWithoutChildSize = getSize(getClients(data, dncCHQuery, projectsHHWithOutChildren, false));
				int dncCHChildAndAdultsSize = getSize(getClients(data, dncCHQuery, projectsHHWithOneAdultChild, false));
				int dncCHWithOnlyChildSize = getSize(getClients(data, dncCHQuery, projectsHHWithChildren, false));
				int dncCHUnknownHouseHoldSize = getSize(getClients(data, dncCHQuery, projectsUnknownHouseHold, false));
			
				
				q26cGenderOfChronicallyHomelessPersonTable.setQ26cInformationMissingTotal(BigInteger.valueOf(dncCHSize));
				q26cGenderOfChronicallyHomelessPersonTable.setQ26cInformationMissingWithoutChild(BigInteger.valueOf(dncCHWithoutChildSize));
				q26cGenderOfChronicallyHomelessPersonTable.setQ26cInformationMissingWithChildAndAdults(BigInteger.valueOf(dncCHChildAndAdultsSize));
				q26cGenderOfChronicallyHomelessPersonTable.setQ26cInformationMissingWithOnlyChild(BigInteger.valueOf(dncCHWithOnlyChildSize));
				q26cGenderOfChronicallyHomelessPersonTable.setQ26cInformationMissingUnknownHouseholdType(BigInteger.valueOf(dncCHUnknownHouseHoldSize));

				
				int withOutChild = maleCHWithoutChildSize +femaleCHWithoutChildSize + transFemaleCHWithoutChildSize + transMaleCHWithoutChildSize + genderNotConfirmingCHWithoutChildSize + dkrCHWithoutChildSize + dncCHWithoutChildSize ;
				int childAndAdults  = maleCHChildAndAdultsSize + femaleCHChildAndAdultsSize + transFemaleCHChildAndAdultsSize + transMaleCHChildAndAdultsSize + genderNotConfirmingCHWithoutChildSize + dncCHChildAndAdultsSize + dncCHChildAndAdultsSize ;
				int withOnlyChild = maleCHWithOnlyChildSize + femaleCHWithOnlyChildSize + transFemaleCHWithOnlyChildSize + transMaleCHWithOnlyChildSize + genderNotConfirmingCHWithOnlyChildSize + dkrCHWithOnlyChildSize + dncCHWithOnlyChildSize ;
				int unknownHouseholdType =maleCHUnknownHouseHoldSize +femaleCHUnknownHouseHoldSize + transFemaleCHUnknownHouseHoldSize +  transMaleCHUnknownHouseHoldSize + genderNotConfirmingCHUnknownHouseHoldSize + dkrCHUnknownHouseHoldSize + dncCHUnknownHouseHoldSize;
				q26cGenderOfChronicallyHomelessPersonTable.setQ26cSubtotalTotal(data.getNoOfChronicallyHomelessPersons());
				q26cGenderOfChronicallyHomelessPersonTable.setQ26cSubtotalWithoutChild(BigInteger.valueOf(withOutChild));
				q26cGenderOfChronicallyHomelessPersonTable.setQ26cSubtotalWithChildAndAdults(BigInteger.valueOf(childAndAdults));
				q26cGenderOfChronicallyHomelessPersonTable.setQ26cSubtotalWithOnlyChild(BigInteger.valueOf(withOnlyChild));
				q26cGenderOfChronicallyHomelessPersonTable.setQ26cSubtotalUnknownHouseholdType(BigInteger.valueOf(unknownHouseholdType));
					
			}
	}catch(Exception e) {
		logger.error("Error in Q26cBeanMaker:" + e);
	}
	
		return Arrays.asList(q26cGenderOfChronicallyHomelessPersonTable);
	}

}
