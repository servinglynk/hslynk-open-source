package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import com.servinglynk.report.bean.Q27aAgeOfYouthDataBean;
import com.servinglynk.report.bean.ReportData;

public class Q27aAgeOfYouthDataBeanMaker {

	public static List<Q27aAgeOfYouthDataBean> getQ27aAgeOfYouthList(ReportData data){
		
		Q27aAgeOfYouthDataBean q27aAgeOfYoutTable = new Q27aAgeOfYouthDataBean();
		
				q27aAgeOfYoutTable.setQ27a12To17Total(BigInteger.valueOf(0));
				q27aAgeOfYoutTable.setQ27a12To17WithoutChild(BigInteger.valueOf(0));
				q27aAgeOfYoutTable.setQ27a12To17WithChildAndAdults(BigInteger.valueOf(0));
				q27aAgeOfYoutTable.setQ27a12To17WithChildOnly(BigInteger.valueOf(0));
				q27aAgeOfYoutTable.setQ27a12To17UnknownHouseHoldtype(BigInteger.valueOf(0));

				q27aAgeOfYoutTable.setQ27a18To24Total(BigInteger.valueOf(0));
				q27aAgeOfYoutTable.setQ27a18To24WithoutChild(BigInteger.valueOf(0));
				q27aAgeOfYoutTable.setQ27a18To24WithChildAndAdults(BigInteger.valueOf(0));
				q27aAgeOfYoutTable.setQ27a18To24WithChildOnly(BigInteger.valueOf(0));
				q27aAgeOfYoutTable.setQ27a18To24UnknownHouseHoldtype(BigInteger.valueOf(0));

				q27aAgeOfYoutTable.setQ27aDKRTotal(BigInteger.valueOf(0));
				q27aAgeOfYoutTable.setQ27aDKRWithoutChild(BigInteger.valueOf(0));
				q27aAgeOfYoutTable.setQ27aDKRWithChildAndAdults(BigInteger.valueOf(0));
				q27aAgeOfYoutTable.setQ27aDKRWithChildOnly(BigInteger.valueOf(0));
				q27aAgeOfYoutTable.setQ27aDKRUnknownHouseHoldtype(BigInteger.valueOf(0));

				q27aAgeOfYoutTable.setQ27aInformationMissingTotal(BigInteger.valueOf(0));
				q27aAgeOfYoutTable.setQ27aInformationMissingWithoutChild(BigInteger.valueOf(0));
				q27aAgeOfYoutTable.setQ27aInformationMissingWithChildAndAdults(BigInteger.valueOf(0));
				q27aAgeOfYoutTable.setQ27aInformationMissingWithChildOnly(BigInteger.valueOf(0));
				q27aAgeOfYoutTable.setQ27aInformationMissingUnknownHouseHoldtype(BigInteger.valueOf(0));

				q27aAgeOfYoutTable.setQ27aTotTotal(BigInteger.valueOf(data.getNumOfYouthUnderAge25()));
				q27aAgeOfYoutTable.setQ27aTotWithoutChild(BigInteger.valueOf(0));
				q27aAgeOfYoutTable.setQ27aTotWithChildAndAdults(BigInteger.valueOf(0));
				q27aAgeOfYoutTable.setQ27aTotWithChildOnly(BigInteger.valueOf(0));
				q27aAgeOfYoutTable.setQ27aTotUnknownHouseHoldtype(BigInteger.valueOf(0));
						
		
		return Arrays.asList(q27aAgeOfYoutTable);
	}
	
}
