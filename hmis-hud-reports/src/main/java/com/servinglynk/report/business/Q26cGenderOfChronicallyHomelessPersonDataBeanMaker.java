package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import com.servinglynk.report.bean.Q26cGenderOfChronicallyHomelessPersonDataBean;
import com.servinglynk.report.bean.ReportData;

public class Q26cGenderOfChronicallyHomelessPersonDataBeanMaker {
	
	public static List<Q26cGenderOfChronicallyHomelessPersonDataBean> getQ26cGenderOfChronicallyHomelessPersonList(ReportData data){
		
		Q26cGenderOfChronicallyHomelessPersonDataBean q26cGenderOfChronicallyHomelessPersonTable = new Q26cGenderOfChronicallyHomelessPersonDataBean();
		
		q26cGenderOfChronicallyHomelessPersonTable.setQ26cMaleTotal(BigInteger.valueOf(0));
		q26cGenderOfChronicallyHomelessPersonTable.setQ26cMaleWithoutChild(BigInteger.valueOf(0));
		q26cGenderOfChronicallyHomelessPersonTable.setQ26cMaleWithChildAndAdults(BigInteger.valueOf(0));
		q26cGenderOfChronicallyHomelessPersonTable.setQ26cMaleWithOnlyChild(BigInteger.valueOf(0));
		q26cGenderOfChronicallyHomelessPersonTable.setQ26cMaleUnknownHouseholdType(BigInteger.valueOf(0));

		q26cGenderOfChronicallyHomelessPersonTable.setQ26cFemaleTotal(BigInteger.valueOf(0));
		q26cGenderOfChronicallyHomelessPersonTable.setQ26cFemaleWithoutChild(BigInteger.valueOf(0));
		q26cGenderOfChronicallyHomelessPersonTable.setQ26cFemaleWithChildAndAdults(BigInteger.valueOf(0));
		q26cGenderOfChronicallyHomelessPersonTable.setQ26cFemaleWithOnlyChild(BigInteger.valueOf(0));
		q26cGenderOfChronicallyHomelessPersonTable.setQ26cFemaleUnknownHouseholdType(BigInteger.valueOf(0));

		q26cGenderOfChronicallyHomelessPersonTable.setQ26cTransgenderMaleToFemaleTotal(BigInteger.valueOf(0));
		q26cGenderOfChronicallyHomelessPersonTable.setQ26cTransgenderMaleToFemaleWithoutChild(BigInteger.valueOf(0));
		q26cGenderOfChronicallyHomelessPersonTable.setQ26cTransgenderMaleToFemaleWithChildAndAdults(BigInteger.valueOf(0));
		q26cGenderOfChronicallyHomelessPersonTable.setQ26cTransgenderMaleToFemaleWithOnlyChild(BigInteger.valueOf(0));
		q26cGenderOfChronicallyHomelessPersonTable.setQ26cTransgenderMaleToFemaleUnknownHouseholdType(BigInteger.valueOf(0));

		q26cGenderOfChronicallyHomelessPersonTable.setQ26cTransgenderFemaleToMaleTotal(BigInteger.valueOf(0));
		q26cGenderOfChronicallyHomelessPersonTable.setQ26cTransgenderFemaleToMaleWithoutChild(BigInteger.valueOf(0));
		q26cGenderOfChronicallyHomelessPersonTable.setQ26cTransgenderFemaleToMaleWithChildAndAdults(BigInteger.valueOf(0));
		q26cGenderOfChronicallyHomelessPersonTable.setQ26cTransgenderFemaleToMaleWithOnlyChild(BigInteger.valueOf(0));
		q26cGenderOfChronicallyHomelessPersonTable.setQ26cTransgenderFemaleToMaleUnknownHouseholdType(BigInteger.valueOf(0));

		q26cGenderOfChronicallyHomelessPersonTable.setQ26cOtherTotal(BigInteger.valueOf(0));
		q26cGenderOfChronicallyHomelessPersonTable.setQ26cOtherWithoutChild(BigInteger.valueOf(0));
		q26cGenderOfChronicallyHomelessPersonTable.setQ26cOtherWithChildAndAdults(BigInteger.valueOf(0));
		q26cGenderOfChronicallyHomelessPersonTable.setQ26cOtherWithOnlyChild(BigInteger.valueOf(0));
		q26cGenderOfChronicallyHomelessPersonTable.setQ26cOtherUnknownHouseholdType(BigInteger.valueOf(0));

		q26cGenderOfChronicallyHomelessPersonTable.setQ26cDKRTotal(BigInteger.valueOf(0));
		q26cGenderOfChronicallyHomelessPersonTable.setQ26cDKRWithoutChild(BigInteger.valueOf(0));
		q26cGenderOfChronicallyHomelessPersonTable.setQ26cDKRWithChildAndAdults(BigInteger.valueOf(0));
		q26cGenderOfChronicallyHomelessPersonTable.setQ26cDKRWithOnlyChild(BigInteger.valueOf(0));
		q26cGenderOfChronicallyHomelessPersonTable.setQ26cDKRUnknownHouseholdType(BigInteger.valueOf(0));

		q26cGenderOfChronicallyHomelessPersonTable.setQ26cInformationMissingTotal(BigInteger.valueOf(0));
		q26cGenderOfChronicallyHomelessPersonTable.setQ26cInformationMissingWithoutChild(BigInteger.valueOf(0));
		q26cGenderOfChronicallyHomelessPersonTable.setQ26cInformationMissingWithChildAndAdults(BigInteger.valueOf(0));
		q26cGenderOfChronicallyHomelessPersonTable.setQ26cInformationMissingWithOnlyChild(BigInteger.valueOf(0));
		q26cGenderOfChronicallyHomelessPersonTable.setQ26cInformationMissingUnknownHouseholdType(BigInteger.valueOf(0));

		q26cGenderOfChronicallyHomelessPersonTable.setQ26cSubtotalTotal(data.getNoOfChronicallyHomelessPersons());
		q26cGenderOfChronicallyHomelessPersonTable.setQ26cSubtotalWithoutChild(BigInteger.valueOf(0));
		q26cGenderOfChronicallyHomelessPersonTable.setQ26cSubtotalWithChildAndAdults(BigInteger.valueOf(0));
		q26cGenderOfChronicallyHomelessPersonTable.setQ26cSubtotalWithOnlyChild(BigInteger.valueOf(0));
		q26cGenderOfChronicallyHomelessPersonTable.setQ26cSubtotalUnknownHouseholdType(BigInteger.valueOf(0));
			
			
		
		return Arrays.asList(q26cGenderOfChronicallyHomelessPersonTable);
	}

}
