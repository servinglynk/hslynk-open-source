package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import com.servinglynk.report.bean.Q26dAgeOfChronicallyHomelessPersonsDataBean;
import com.servinglynk.report.bean.ReportData;

public class Q26dAgeOfChronicallyHomelessPersonsDataBeanMaker extends BaseBeanMaker {
	
	public static List<Q26dAgeOfChronicallyHomelessPersonsDataBean> getQ26dAgeOfChronicallyHomelessPersonsList(ReportData data){
		
		Q26dAgeOfChronicallyHomelessPersonsDataBean q26dAgeOfChronicallyHomelessPersonsTable = new Q26dAgeOfChronicallyHomelessPersonsDataBean();
		try {
			List<String> projectsHHWithChildren = data.getProjectsHHWithChildren();
			List<String> projectsHHWithOneAdultChild = data.getProjectsHHWithOneAdultChild();
			List<String> projectsHHWithOutChildren = data.getProjectsHHWithOutChildren();
			List<String> projectsUnknownHouseHold = data.getProjectsUnknownHouseHold();
			
			String chless17Query ="select distinct(e.dedup_client_id) from %s.enrollment e,%s.client c,%s.project p  where c.id =e.client_id and c.age < 17 and e.chronichomeless='true' and e.projectid = p.id %p  ";
			String ch18To24Query ="select distinct(e.dedup_client_id) from %s.enrollment e,%s.client c,%s.project p  where c.id =e.client_id and c.age >= 18 and c.age <= 24 and e.chronichomeless='true' and e.projectid = p.id %p  ";
			String ch25To34Query ="select distinct(e.dedup_client_id) from %s.enrollment e,%s.client c,%s.project p  where c.id =e.client_id and c.age >= 25 and c.age <= 34 and e.chronichomeless='true' and e.projectid = p.id %p ";
			String ch35To44Query ="select distinct(e.dedup_client_id) from %s.enrollment e,%s.client c,%s.project p  where c.id =e.client_id and c.age >= 35 and c.age <= 44 and e.chronichomeless='true' and e.projectid = p.id %p ";
			String ch45To54Query ="select distinct(e.dedup_client_id) from %s.enrollment e,%s.client c,%s.project p  where c.id =e.client_id and c.age >= 45 and c.age <= 54 and e.chronichomeless='true' and e.projectid = p.id %p ";
			String ch55To61Query ="select distinct(e.dedup_client_id) from %s.enrollment e,%s.client c,%s.project p  where c.id =e.client_id and c.age >= 55 and c.age <= 61 and e.chronichomeless='true' and e.projectid = p.id %p ";
			String ch62PlusQuery ="select distinct(e.dedup_client_id) from %s.enrollment e,%s.client c,%s.project p  where c.id =e.client_id and c.age >= 62 and e.chronichomeless='true' and e.projectid = p.id %p ";
			String chDKNQuery ="select distinct(e.dedup_client_id) from %s.enrollment e,%s.client c,%s.project p  where c.id =e.client_id and c.dob_data_quality in ('8','9') and e.chronichomeless='true' and e.projectid = p.id %p ";
			String chDNCQuery ="select distinct(e.dedup_client_id) from %s.enrollment e,%s.client c,%s.project p  where c.id =e.client_id and c.dob_data_quality='99' and e.chronichomeless='true' and e.projectid = p.id %p ";
			
			if(data.isLiveMode()) {
				int chless17Size = getSize(getClients(data, chless17Query, null, true));
				int chless17WithoutChildSize = getSize(getClients(data, chless17Query, projectsHHWithOutChildren, false));
				int chless17WithChildAndAdultsSize = getSize(getClients(data, chless17Query, projectsHHWithOneAdultChild, false));
				int chless17WithOnlyChildSize = getSize(getClients(data, chless17Query, projectsHHWithChildren, false));
				int chless17UnknownHouseHoldSize = getSize(getClients(data, chless17Query, projectsUnknownHouseHold, false));
				
				q26dAgeOfChronicallyHomelessPersonsTable.setQ26d0To17Total(BigInteger.valueOf(chless17Size));
				q26dAgeOfChronicallyHomelessPersonsTable.setQ26d0To17WithoutChild(BigInteger.valueOf(chless17WithoutChildSize));
				q26dAgeOfChronicallyHomelessPersonsTable.setQ26d0To17WithChildAndAdults(BigInteger.valueOf(chless17WithChildAndAdultsSize));
				q26dAgeOfChronicallyHomelessPersonsTable.setQ26d0To17WithOnlyChild(BigInteger.valueOf(chless17WithOnlyChildSize));
				q26dAgeOfChronicallyHomelessPersonsTable.setQ26d0To17UnknownHouseholdType(BigInteger.valueOf(chless17UnknownHouseHoldSize));
		
				int ch18To24Size = getSize(getClients(data, ch18To24Query, null, true));
				int ch18To24WithoutChildSize = getSize(getClients(data, ch18To24Query, projectsHHWithOutChildren, false));
				int ch18To24WithChildAndAdultsSize = getSize(getClients(data, ch18To24Query, projectsHHWithOneAdultChild, false));
				int ch18To24WithOnlyChildSize = getSize(getClients(data, ch18To24Query, projectsHHWithChildren, false));
				int ch18To24UnknownHouseHoldSize = getSize(getClients(data, ch18To24Query, projectsUnknownHouseHold, false));
				
				q26dAgeOfChronicallyHomelessPersonsTable.setQ26d18To24Total(BigInteger.valueOf(ch18To24Size));
				q26dAgeOfChronicallyHomelessPersonsTable.setQ26d18To24WithoutChild(BigInteger.valueOf(ch18To24WithoutChildSize));
				q26dAgeOfChronicallyHomelessPersonsTable.setQ26d18To24WithChildAndAdults(BigInteger.valueOf(ch18To24WithChildAndAdultsSize));
				q26dAgeOfChronicallyHomelessPersonsTable.setQ26d18To24WithOnlyChild(BigInteger.valueOf(ch18To24WithOnlyChildSize));
				q26dAgeOfChronicallyHomelessPersonsTable.setQ26d18To24UnknownHouseholdType(BigInteger.valueOf(ch18To24UnknownHouseHoldSize));

				int ch25To34Size = getSize(getClients(data, ch25To34Query, null, true));
				int ch25To34WithoutChildSize = getSize(getClients(data, ch25To34Query, projectsHHWithOutChildren, false));
				int ch25To34WithChildAndAdultsSize = getSize(getClients(data, ch25To34Query, projectsHHWithOneAdultChild, false));
				int ch25To34WithOnlyChildSize = getSize(getClients(data, ch25To34Query, projectsHHWithChildren, false));
				int ch25To34UnknownHouseHoldSize = getSize(getClients(data, ch25To34Query, projectsUnknownHouseHold, false));
				
				q26dAgeOfChronicallyHomelessPersonsTable.setQ26d25To34Total(BigInteger.valueOf(ch25To34Size));
				q26dAgeOfChronicallyHomelessPersonsTable.setQ26d25To34WithoutChild(BigInteger.valueOf(ch25To34WithoutChildSize));
				q26dAgeOfChronicallyHomelessPersonsTable.setQ26d25To34WithChildAndAdults(BigInteger.valueOf(ch25To34WithChildAndAdultsSize));
				q26dAgeOfChronicallyHomelessPersonsTable.setQ26d25To34WithOnlyChild(BigInteger.valueOf(ch25To34WithOnlyChildSize));
				q26dAgeOfChronicallyHomelessPersonsTable.setQ26d25To34UnknownHouseholdType(BigInteger.valueOf(ch25To34UnknownHouseHoldSize));

				int ch35To44Size = getSize(getClients(data, ch35To44Query, null, true));
				int ch35To44WithoutChildSize = getSize(getClients(data, ch35To44Query, projectsHHWithOutChildren, false));
				int ch35To44WithChildAndAdultsSize = getSize(getClients(data, ch35To44Query, projectsHHWithOneAdultChild, false));
				int ch35To44WithOnlyChildSize = getSize(getClients(data, ch35To44Query, projectsHHWithChildren, false));
				int ch35To44UnknownHouseHoldSize = getSize(getClients(data, ch35To44Query, projectsUnknownHouseHold, false));
				
				q26dAgeOfChronicallyHomelessPersonsTable.setQ26d35To44Total(BigInteger.valueOf(ch35To44Size));
				q26dAgeOfChronicallyHomelessPersonsTable.setQ26d35To44WithoutChild(BigInteger.valueOf(ch35To44WithoutChildSize));
				q26dAgeOfChronicallyHomelessPersonsTable.setQ26d35To44WithChildAndAdults(BigInteger.valueOf(ch35To44WithChildAndAdultsSize));
				q26dAgeOfChronicallyHomelessPersonsTable.setQ26d35To44WithOnlyChild(BigInteger.valueOf(ch35To44WithOnlyChildSize));
				q26dAgeOfChronicallyHomelessPersonsTable.setQ26d35To44UnknownHouseholdType(BigInteger.valueOf(ch35To44UnknownHouseHoldSize));

				int ch45To54Size = getSize(getClients(data, ch45To54Query, null, true));
				int ch45To54WithoutChildSize = getSize(getClients(data, ch45To54Query, projectsHHWithOutChildren, false));
				int ch45To54WithChildAndAdultsSize = getSize(getClients(data, ch45To54Query, projectsHHWithOneAdultChild, false));
				int ch45To54WithOnlyChildSize = getSize(getClients(data, ch45To54Query, projectsHHWithChildren, false));
				int ch45To54UnknownHouseHoldSize = getSize(getClients(data, ch45To54Query, projectsUnknownHouseHold, false));
				
				q26dAgeOfChronicallyHomelessPersonsTable.setQ26d45To54Total(BigInteger.valueOf(ch45To54Size));
				q26dAgeOfChronicallyHomelessPersonsTable.setQ26d45To54WithoutChild(BigInteger.valueOf(ch45To54WithoutChildSize));
				q26dAgeOfChronicallyHomelessPersonsTable.setQ26d45To54WithChildAndAdults(BigInteger.valueOf(ch45To54WithChildAndAdultsSize));
				q26dAgeOfChronicallyHomelessPersonsTable.setQ26d45To54WithOnlyChild(BigInteger.valueOf(ch45To54WithOnlyChildSize));
				q26dAgeOfChronicallyHomelessPersonsTable.setQ26d45To54UnknownHouseholdType(BigInteger.valueOf(ch45To54UnknownHouseHoldSize));
				
				int ch55To61Size = getSize(getClients(data, ch55To61Query, null, true));
				int ch55To61WithoutChildSize = getSize(getClients(data, ch55To61Query, projectsHHWithOutChildren, false));
				int ch55To61WithChildAndAdultsSize = getSize(getClients(data, ch55To61Query, projectsHHWithOneAdultChild, false));
				int ch55To61WithOnlyChildSize = getSize(getClients(data, ch55To61Query, projectsHHWithChildren, false));
				int ch55To61UnknownHouseHoldSize = getSize(getClients(data, ch55To61Query, projectsUnknownHouseHold, false));
				
				q26dAgeOfChronicallyHomelessPersonsTable.setQ26d55To61Total(BigInteger.valueOf(ch55To61Size));
				q26dAgeOfChronicallyHomelessPersonsTable.setQ26d55To61WithoutChild(BigInteger.valueOf(ch55To61WithoutChildSize));
				q26dAgeOfChronicallyHomelessPersonsTable.setQ26d55To61WithChildAndAdults(BigInteger.valueOf(ch55To61WithChildAndAdultsSize));
				q26dAgeOfChronicallyHomelessPersonsTable.setQ26d55To61WithOnlyChild(BigInteger.valueOf(ch55To61WithOnlyChildSize));
				q26dAgeOfChronicallyHomelessPersonsTable.setQ26d55To61UnknownHouseholdType(BigInteger.valueOf(ch55To61UnknownHouseHoldSize));

				int ch62PlusSize = getSize(getClients(data, ch62PlusQuery, null, true));
				int ch62PlusWithoutChildSize = getSize(getClients(data, ch62PlusQuery, projectsHHWithOutChildren, false));
				int ch62PlusWithChildAndAdultsSize = getSize(getClients(data, ch62PlusQuery, projectsHHWithOneAdultChild, false));
				int ch62PlusWithOnlyChildSize = getSize(getClients(data, ch62PlusQuery, projectsHHWithChildren, false));
				int ch62PlusUnknownHouseHoldSize = getSize(getClients(data, ch62PlusQuery, projectsUnknownHouseHold, false));
				
				q26dAgeOfChronicallyHomelessPersonsTable.setQ26d62PlusTotal(BigInteger.valueOf(ch62PlusSize));
				q26dAgeOfChronicallyHomelessPersonsTable.setQ26d62PlusWithoutChild(BigInteger.valueOf(ch62PlusWithoutChildSize));
				q26dAgeOfChronicallyHomelessPersonsTable.setQ26d62PlusWithChildAndAdults(BigInteger.valueOf(ch62PlusWithChildAndAdultsSize));
				q26dAgeOfChronicallyHomelessPersonsTable.setQ26d62PlusWithOnlyChild(BigInteger.valueOf(ch62PlusWithOnlyChildSize));
				q26dAgeOfChronicallyHomelessPersonsTable.setQ26d62PlusUnknownHouseholdType(BigInteger.valueOf(ch62PlusUnknownHouseHoldSize));

				
				int chDKNSize = getSize(getClients(data, chDKNQuery, null, true));
				int chDKNWithoutChildSize = getSize(getClients(data, chDKNQuery, projectsHHWithOutChildren, false));
				int chDKNWithChildAndAdultsSize = getSize(getClients(data, chDKNQuery, projectsHHWithOneAdultChild, false));
				int chDKNWithOnlyChildSize = getSize(getClients(data, chDKNQuery, projectsHHWithChildren, false));
				int chDKNUnknownHouseHoldSize = getSize(getClients(data, chDKNQuery, projectsUnknownHouseHold, false));
				
				q26dAgeOfChronicallyHomelessPersonsTable.setQ26dDKRTotal(BigInteger.valueOf(chDKNSize));
				q26dAgeOfChronicallyHomelessPersonsTable.setQ26dDKRWithoutChild(BigInteger.valueOf(chDKNWithoutChildSize));
				q26dAgeOfChronicallyHomelessPersonsTable.setQ26dDKRWithChildAndAdults(BigInteger.valueOf(chDKNWithChildAndAdultsSize));
				q26dAgeOfChronicallyHomelessPersonsTable.setQ26dDKRWithOnlyChild(BigInteger.valueOf(chDKNWithOnlyChildSize));
				q26dAgeOfChronicallyHomelessPersonsTable.setQ26dDKRUnknownHouseholdType(BigInteger.valueOf(chDKNUnknownHouseHoldSize));

				int chDNCSize = getSize(getClients(data, chDNCQuery, null, true));
				int chDNCWithoutChildSize = getSize(getClients(data, chDNCQuery, projectsHHWithOutChildren, false));
				int chDNCWithChildAndAdultsSize = getSize(getClients(data, chDNCQuery, projectsHHWithOneAdultChild, false));
				int chDNCWithOnlyChildSize = getSize(getClients(data, chDNCQuery, projectsHHWithChildren, false));
				int chDNCUnknownHouseHoldSize = getSize(getClients(data, chDNCQuery, projectsUnknownHouseHold, false));
				
				
				q26dAgeOfChronicallyHomelessPersonsTable.setQ26dInformationMissingTotal(BigInteger.valueOf(0));
				q26dAgeOfChronicallyHomelessPersonsTable.setQ26dInformationMissingWithoutChild(BigInteger.valueOf(0));
				q26dAgeOfChronicallyHomelessPersonsTable.setQ26dInformationMissingWithChildAndAdults(BigInteger.valueOf(0));
				q26dAgeOfChronicallyHomelessPersonsTable.setQ26dInformationMissingWithOnlyChild(BigInteger.valueOf(0));
				q26dAgeOfChronicallyHomelessPersonsTable.setQ26dInformationMissingUnknownHouseholdType(BigInteger.valueOf(0));

				
				int total = chless17Size + ch18To24Size + ch25To34Size + ch35To44Size + ch45To54Size + ch55To61Size + ch62PlusSize + chDKNSize + chDNCSize;
				int withoutChildSize = chless17WithoutChildSize + ch18To24WithoutChildSize + ch25To34WithoutChildSize + ch35To44WithoutChildSize + ch55To61WithoutChildSize + ch62PlusWithoutChildSize + chDKNWithoutChildSize + chDNCWithoutChildSize;
				int withChildAndAdultsSize = chless17WithChildAndAdultsSize + ch18To24WithChildAndAdultsSize + ch25To34WithChildAndAdultsSize + ch35To44WithChildAndAdultsSize + ch45To54WithoutChildSize + ch55To61WithChildAndAdultsSize + ch62PlusWithChildAndAdultsSize + chDKNWithChildAndAdultsSize + chDNCWithChildAndAdultsSize;
				int withOnlyChildSize = chless17WithOnlyChildSize + ch18To24WithOnlyChildSize + ch25To34WithOnlyChildSize + ch35To44WithOnlyChildSize + ch45To54WithChildAndAdultsSize + ch45To54WithOnlyChildSize + ch55To61WithOnlyChildSize + ch62PlusWithOnlyChildSize + chDKNWithOnlyChildSize + chDNCWithOnlyChildSize;
				int unknownHouseHoldSize = chless17UnknownHouseHoldSize + ch18To24UnknownHouseHoldSize + ch25To34UnknownHouseHoldSize + ch35To44UnknownHouseHoldSize + ch45To54UnknownHouseHoldSize + ch55To61UnknownHouseHoldSize + ch62PlusUnknownHouseHoldSize + chDKNUnknownHouseHoldSize + chDNCUnknownHouseHoldSize;
			
				
				q26dAgeOfChronicallyHomelessPersonsTable.setQ26dSubtotalTotal(data.getNoOfChronicallyHomelessPersons());
				q26dAgeOfChronicallyHomelessPersonsTable.setQ26dSubtotalWithoutChild(BigInteger.valueOf(withoutChildSize));
				q26dAgeOfChronicallyHomelessPersonsTable.setQ26dSubtotalWithChildAndAdults(BigInteger.valueOf(withChildAndAdultsSize));
				q26dAgeOfChronicallyHomelessPersonsTable.setQ26dSubtotalWithOnlyChild(BigInteger.valueOf(withOnlyChildSize));
				q26dAgeOfChronicallyHomelessPersonsTable.setQ26dSubtotalUnknownHouseholdType(BigInteger.valueOf(unknownHouseHoldSize));
					
			}
	}catch(Exception e) {
		logger.error("Error in Q26cBeanMaker:" + e);
	}
		
		
		return Arrays.asList(q26dAgeOfChronicallyHomelessPersonsTable);
	}

}
