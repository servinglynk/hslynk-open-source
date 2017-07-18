package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import com.servinglynk.report.bean.Q27cGenderYouthDataBean;
import com.servinglynk.report.bean.ReportData;

public class Q27cGenderYouthDataBeanMaker {
	
	public static List<Q27cGenderYouthDataBean> getQ27cGenderYouthList(ReportData data){
		
		Q27cGenderYouthDataBean q27cGenderYouthTable = new Q27cGenderYouthDataBean();
		
		q27cGenderYouthTable.setQ27cMaleTotal(BigInteger.valueOf(0));
		q27cGenderYouthTable.setQ27cMaleWithoutChild(BigInteger.valueOf(0));
		q27cGenderYouthTable.setQ27cMaleWithChildAndAdults(BigInteger.valueOf(0));
		q27cGenderYouthTable.setQ27cMaleWithChildOnly(BigInteger.valueOf(0));
		q27cGenderYouthTable.setQ27cMaleUnknownHouseHoldtype(BigInteger.valueOf(0));

		q27cGenderYouthTable.setQ27cFemaleTotal(BigInteger.valueOf(0));
		q27cGenderYouthTable.setQ27cFemaleWithoutChild(BigInteger.valueOf(0));
		q27cGenderYouthTable.setQ27cFemaleWithChildAndAdults(BigInteger.valueOf(0));
		q27cGenderYouthTable.setQ27cFemaleWithChildOnly(BigInteger.valueOf(0));
		q27cGenderYouthTable.setQ27cFemaleUnknownHouseHoldtype(BigInteger.valueOf(0));

		q27cGenderYouthTable.setQ27cTransgenderMaleToFemaleTotal(BigInteger.valueOf(0));
		q27cGenderYouthTable.setQ27cTransgenderMaleToFemaleWithoutChild(BigInteger.valueOf(0));
		q27cGenderYouthTable.setQ27cTransgenderMaleToFemaleWithChildAndAdults(BigInteger.valueOf(0));
		q27cGenderYouthTable.setQ27cTransgenderMaleToFemaleWithChildOnly(BigInteger.valueOf(0));
		q27cGenderYouthTable.setQ27cTransgenderMaleToFemaleUnknownHouseHoldtype(BigInteger.valueOf(0));
					
		q27cGenderYouthTable.setQ27cTransgenderFemaleToMaleTotal(BigInteger.valueOf(0));
		q27cGenderYouthTable.setQ27cTransgenderFemaleToMaleWithoutChild(BigInteger.valueOf(0));
		q27cGenderYouthTable.setQ27cTransgenderFemaleToMaleWithChildAndAdults(BigInteger.valueOf(0));
		q27cGenderYouthTable.setQ27cTransgenderFemaleToMaleWithChildOnly(BigInteger.valueOf(0));
		q27cGenderYouthTable.setQ27cTransgenderFemaleToMaleUnknownHouseHoldtype(BigInteger.valueOf(0));

		q27cGenderYouthTable.setQ27cOtherTotal(BigInteger.valueOf(0));
		q27cGenderYouthTable.setQ27cOtherWithoutChild(BigInteger.valueOf(0));
		q27cGenderYouthTable.setQ27cOtherWithChildAndAdults(BigInteger.valueOf(0));
		q27cGenderYouthTable.setQ27cOtherWithChildOnly(BigInteger.valueOf(0));
		q27cGenderYouthTable.setQ27cOtherUnknownHouseHoldtype(BigInteger.valueOf(0));

		q27cGenderYouthTable.setQ27cDKRTotal(BigInteger.valueOf(0));
		q27cGenderYouthTable.setQ27cDKRWithoutChild(BigInteger.valueOf(0));
		q27cGenderYouthTable.setQ27cDKRWithChildAndAdults(BigInteger.valueOf(0));
		q27cGenderYouthTable.setQ27cDKRWithChildOnly(BigInteger.valueOf(0));
		q27cGenderYouthTable.setQ27cDKRUnknownHouseHoldtype(BigInteger.valueOf(0));

		q27cGenderYouthTable.setQ27cInformationMissingTotal(BigInteger.valueOf(0));
		q27cGenderYouthTable.setQ27cInformationMissingWithoutChild(BigInteger.valueOf(0));
		q27cGenderYouthTable.setQ27cInformationMissingWithChildAndAdults(BigInteger.valueOf(0));
		q27cGenderYouthTable.setQ27cInformationMissingWithChildOnly(BigInteger.valueOf(0));
		q27cGenderYouthTable.setQ27cInformationMissingUnknownHouseHoldtype(BigInteger.valueOf(0));

		q27cGenderYouthTable.setQ27cTotTotal(data.getNumOfYouthUnderAge25());
		q27cGenderYouthTable.setQ27cTotWithoutChild(BigInteger.valueOf(0));
		q27cGenderYouthTable.setQ27cTotWithChildAndAdults(BigInteger.valueOf(0));
		q27cGenderYouthTable.setQ27cTotWithChildOnly(BigInteger.valueOf(0));
		q27cGenderYouthTable.setQ27cTotUnknownHouseHoldtype(BigInteger.valueOf(0));
		
		return Arrays.asList(q27cGenderYouthTable);
		
	}

}
