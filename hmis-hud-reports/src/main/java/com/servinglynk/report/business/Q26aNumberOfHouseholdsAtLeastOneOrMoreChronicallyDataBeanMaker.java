package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import com.servinglynk.report.bean.Q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyDataBean;

public class Q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyDataBeanMaker {
	
	public static List<Q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyDataBean> getQ26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyList(){
		
		Q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyDataBean q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable = new Q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyDataBean();
		
		q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aChronicallyHomelessTotal(BigInteger.valueOf(0));
		q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aChronicallyHomelessWithoutChild(BigInteger.valueOf(0));
		q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aChronicallyHomelessWithChildAndAdults(BigInteger.valueOf(0));
		q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aChronicallyHomelessWithOnlyChild(BigInteger.valueOf(0));
		q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aChronicallyHomelessUnknownHouseholdType(BigInteger.valueOf(0));

		q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aNotChronicallyHomelessTotal(BigInteger.valueOf(0));
		q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aNotChronicallyHomelessWithoutChild(BigInteger.valueOf(0));
		q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aNotChronicallyHomelessWithChildAndAdults(BigInteger.valueOf(0));
		q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aNotChronicallyHomelessWithOnlyChild(BigInteger.valueOf(0));
		q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aNotChronicallyHomelessUnknownHouseholdType(BigInteger.valueOf(0));

		q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aClientRefusedTotal(BigInteger.valueOf(0));
		q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aClientRefusedWithoutChild(BigInteger.valueOf(0));
		q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aClientRefusedWithChildAndAdults(BigInteger.valueOf(0));
		q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aClientRefusedWithOnlyChild(BigInteger.valueOf(0));
		q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aClientRefusedUnknownHouseholdType(BigInteger.valueOf(0));

		q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aDataNotCollectedTotal(BigInteger.valueOf(0));
		q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aDataNotCollectedWithoutChild(BigInteger.valueOf(0));
		q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aDataNotCollectedWithChildAndAdults(BigInteger.valueOf(0));
		q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aDataNotCollectedWithOnlyChild(BigInteger.valueOf(0));
		q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aDataNotCollectedUnknownHouseholdType(BigInteger.valueOf(0));

		q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aTotTotal(BigInteger.valueOf(0));
		q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aTotWithoutChild(BigInteger.valueOf(0));
		q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aTotWithChildAndAdults(BigInteger.valueOf(0));
		q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aTotWithOnlyChild(BigInteger.valueOf(0));
		q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aTotUnknownHouseholdType(BigInteger.valueOf(0));
		
		return Arrays.asList(q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable); 
		
	}

}
