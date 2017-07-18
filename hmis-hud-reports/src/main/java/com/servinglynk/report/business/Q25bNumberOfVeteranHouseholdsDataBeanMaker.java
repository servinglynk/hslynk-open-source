package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import com.servinglynk.report.bean.Q25bNumberOfVeteranHouseholdsDataBean;

public class Q25bNumberOfVeteranHouseholdsDataBeanMaker {
	
	public static List<Q25bNumberOfVeteranHouseholdsDataBean> getQ25bNumberOfVeteranHouseholdsList(){
		
		Q25bNumberOfVeteranHouseholdsDataBean q25bNumberOfVeteranHouseholdsTable = new Q25bNumberOfVeteranHouseholdsDataBean();
		
		q25bNumberOfVeteranHouseholdsTable.setQ25bChronicallyHomelessVeteranTotal(BigInteger.valueOf(0));
		q25bNumberOfVeteranHouseholdsTable.setQ25bChronicallyHomelessVeteranWithoutChildren(BigInteger.valueOf(0));
		q25bNumberOfVeteranHouseholdsTable.setQ25bChronicallyHomelessVeteranWithChildAndAdults(BigInteger.valueOf(0));
		q25bNumberOfVeteranHouseholdsTable.setQ25bChronicallyHomelessVeteranUnknownHouseHold(BigInteger.valueOf(0));

		q25bNumberOfVeteranHouseholdsTable.setQ25bNonChronicallyHomelessVeteranTotal(BigInteger.valueOf(0));
		q25bNumberOfVeteranHouseholdsTable.setQ25bNonChronicallyHomelessVeteranWithoutChildren(BigInteger.valueOf(0));
		q25bNumberOfVeteranHouseholdsTable.setQ25bNonChronicallyHomelessVeteranWithChildAndAdults(BigInteger.valueOf(0));
		q25bNumberOfVeteranHouseholdsTable.setQ25bNonChronicallyHomelessVeteranUnknownHouseHold(BigInteger.valueOf(0));

		q25bNumberOfVeteranHouseholdsTable.setQ25bNotVeteranTotal(BigInteger.valueOf(0));
		q25bNumberOfVeteranHouseholdsTable.setQ25bNotVeteranWithoutChildren(BigInteger.valueOf(0));
		q25bNumberOfVeteranHouseholdsTable.setQ25bNotVeteranWithChildAndAdults(BigInteger.valueOf(0));
		q25bNumberOfVeteranHouseholdsTable.setQ25bNotVeteranUnknownHouseHold(BigInteger.valueOf(0));

		q25bNumberOfVeteranHouseholdsTable.setQ25bClientRefusedTotal(BigInteger.valueOf(0));
		q25bNumberOfVeteranHouseholdsTable.setQ25bClientRefusedWithoutChildren(BigInteger.valueOf(0));
		q25bNumberOfVeteranHouseholdsTable.setQ25bClientRefusedWithChildAndAdults(BigInteger.valueOf(0));
		q25bNumberOfVeteranHouseholdsTable.setQ25bClientRefusedUnknownHouseHold(BigInteger.valueOf(0));

		q25bNumberOfVeteranHouseholdsTable.setQ25bDataNotCollectedTotal(BigInteger.valueOf(0));
		q25bNumberOfVeteranHouseholdsTable.setQ25bDataNotCollectedWithoutChildren(BigInteger.valueOf(0));
		q25bNumberOfVeteranHouseholdsTable.setQ25bDataNotCollectedWithChildAndAdults(BigInteger.valueOf(0));
		q25bNumberOfVeteranHouseholdsTable.setQ25bDataNotCollectedUnknownHouseHold(BigInteger.valueOf(0));

		q25bNumberOfVeteranHouseholdsTable.setQ25bTotTotal(BigInteger.valueOf(0));
		q25bNumberOfVeteranHouseholdsTable.setQ25bTotWithoutChildren(BigInteger.valueOf(0));
		q25bNumberOfVeteranHouseholdsTable.setQ25bTotWithChildAndAdults(BigInteger.valueOf(0));
		q25bNumberOfVeteranHouseholdsTable.setQ25bTotUnknownHouseHold(BigInteger.valueOf(0));
		
		return Arrays.asList(q25bNumberOfVeteranHouseholdsTable);
		
	}
	

}
