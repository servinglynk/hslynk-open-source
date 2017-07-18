package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import com.servinglynk.report.bean.Q27eLengthOfParticipationYouthDataBean;
import com.servinglynk.report.bean.ReportData;

public class Q27eLengthOfParticipationYouthDataBeanMaker {
	
	public static List<Q27eLengthOfParticipationYouthDataBean> getQ27eLengthOfParticipationYouthList(ReportData data){
		
		Q27eLengthOfParticipationYouthDataBean q27eLengthOfParticipationYouthTable = new Q27eLengthOfParticipationYouthDataBean();
		
		q27eLengthOfParticipationYouthTable.setQ27e30DaysOrLessAtEntry(BigInteger.valueOf(0));
		q27eLengthOfParticipationYouthTable.setQ27e30DaysOrLessStayers(BigInteger.valueOf(0));
		q27eLengthOfParticipationYouthTable.setQ27e30DaysOrLessLeavers(BigInteger.valueOf(0));

		q27eLengthOfParticipationYouthTable.setQ27e31To60DaysAtEntry(BigInteger.valueOf(0));
		q27eLengthOfParticipationYouthTable.setQ27e31To60DaysStayers(BigInteger.valueOf(0));
		q27eLengthOfParticipationYouthTable.setQ27e31To60DaysLeavers(BigInteger.valueOf(0));

		q27eLengthOfParticipationYouthTable.setQ27e61To90DaysAtEntry(BigInteger.valueOf(0));
		q27eLengthOfParticipationYouthTable.setQ27e61To90DaysStayers(BigInteger.valueOf(0));
		q27eLengthOfParticipationYouthTable.setQ27e61To90DaysLeavers(BigInteger.valueOf(0));

		q27eLengthOfParticipationYouthTable.setQ27e91To180DaysAtEntry(BigInteger.valueOf(0));
		q27eLengthOfParticipationYouthTable.setQ27e91To180DaysStayers(BigInteger.valueOf(0));
		q27eLengthOfParticipationYouthTable.setQ27e91To180DaysLeavers(BigInteger.valueOf(0));

		q27eLengthOfParticipationYouthTable.setQ27e181To365DaysAtEntry(BigInteger.valueOf(0));
		q27eLengthOfParticipationYouthTable.setQ27e181To365DaysStayers(BigInteger.valueOf(0));
		q27eLengthOfParticipationYouthTable.setQ27e181To365DaysLeavers(BigInteger.valueOf(0));

		q27eLengthOfParticipationYouthTable.setQ27e366To730DaysAtEntry(BigInteger.valueOf(0));
		q27eLengthOfParticipationYouthTable.setQ27e366To730DaysStayers(BigInteger.valueOf(0));
		q27eLengthOfParticipationYouthTable.setQ27e366To730DaysLeavers(BigInteger.valueOf(0));

		q27eLengthOfParticipationYouthTable.setQ27e731To1095DaysAtEntry(BigInteger.valueOf(0));
		q27eLengthOfParticipationYouthTable.setQ27e731To1095DaysStayers(BigInteger.valueOf(0));
		q27eLengthOfParticipationYouthTable.setQ27e731To1095DaysLeavers(BigInteger.valueOf(0));

		q27eLengthOfParticipationYouthTable.setQ27e1096To1460DaysAtEntry(BigInteger.valueOf(0));
		q27eLengthOfParticipationYouthTable.setQ27e1096To1460DaysStayers(BigInteger.valueOf(0));
		q27eLengthOfParticipationYouthTable.setQ27e1096To1460DaysLeavers(BigInteger.valueOf(0));

		q27eLengthOfParticipationYouthTable.setQ27e1461To1825DaysAtEntry(BigInteger.valueOf(0));
		q27eLengthOfParticipationYouthTable.setQ27e1461To1825DaysStayers(BigInteger.valueOf(0));
		q27eLengthOfParticipationYouthTable.setQ27e1461To1825DaysLeavers(BigInteger.valueOf(0));

		q27eLengthOfParticipationYouthTable.setQ27eMoreThan1825DaysAtEntry(BigInteger.valueOf(0));
		q27eLengthOfParticipationYouthTable.setQ27eMoreThan1825DaysStayers(BigInteger.valueOf(0));
		q27eLengthOfParticipationYouthTable.setQ27eMoreThan1825DaysLeavers(BigInteger.valueOf(0));

		q27eLengthOfParticipationYouthTable.setQ27eInformationMissingAtEntry(BigInteger.valueOf(0));
		q27eLengthOfParticipationYouthTable.setQ27eInformationMissingStayers(BigInteger.valueOf(0));
		q27eLengthOfParticipationYouthTable.setQ27eInformationMissingLeavers(BigInteger.valueOf(0));

		q27eLengthOfParticipationYouthTable.setQ27eTotalAtEntry(data.getNumOfYouthUnderAge25());
		q27eLengthOfParticipationYouthTable.setQ27eTotalStayers(BigInteger.valueOf(0));
		q27eLengthOfParticipationYouthTable.setQ27eTotalLeavers(BigInteger.valueOf(0));
		
		return Arrays.asList(q27eLengthOfParticipationYouthTable);
	}

}
