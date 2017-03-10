package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import com.servinglynk.report.bean.Q27bParentingYouthDataBean;

public class Q27bParentingYouthDataBeanMaker {
	
	public static List<Q27bParentingYouthDataBean> getQ27bParentingYouthList(){
		
		Q27bParentingYouthDataBean q27bParentingYouthTable = new Q27bParentingYouthDataBean();
		
				q27bParentingYouthTable.setQ27bParentYouthLeassThan18TotalParentingYouth(BigInteger.valueOf(0));
				q27bParentingYouthTable.setQ27bParentYouthLeassThan18TotalChildrenOfParentingYouth(BigInteger.valueOf(0));
				q27bParentingYouthTable.setQ27bParentYouthLeassThan18TotalPersons(BigInteger.valueOf(0));
				q27bParentingYouthTable.setQ27bParentYouthLeassThan18TotalHouseholds(BigInteger.valueOf(0));

				q27bParentingYouthTable.setQ27bParentYouth18To24TotalParentingYouth(BigInteger.valueOf(0));
				q27bParentingYouthTable.setQ27bParentYouth18To24TotalChildrenOfParentingYouth(BigInteger.valueOf(0));
				q27bParentingYouthTable.setQ27bParentYouth18To24TotalPersons(BigInteger.valueOf(0));
				q27bParentingYouthTable.setQ27bParentYouth18To24TotalHouseholds(BigInteger.valueOf(0));
		
		
		return Arrays.asList(q27bParentingYouthTable);
		
	}

}
