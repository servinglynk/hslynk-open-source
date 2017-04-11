package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import com.servinglynk.report.bean.Q22a1LengthOfParticipationCoCProjectsDataBean;
import com.servinglynk.report.bean.ReportData;

public class Q22a1LengthOfParticipationCoCProjectsDataBeanMaker {

	public static List<Q22a1LengthOfParticipationCoCProjectsDataBean> getQ22a1LengthOfParticipationCoCProjectsList(ReportData data){
		
		Q22a1LengthOfParticipationCoCProjectsDataBean q22a1LengthOfParticipationCoCProjectsTable = new Q22a1LengthOfParticipationCoCProjectsDataBean();
		
				q22a1LengthOfParticipationCoCProjectsTable.setQ22a1A30DaysOrLessTotal(BigInteger.valueOf(0));
				q22a1LengthOfParticipationCoCProjectsTable.setQ22a1A30DaysOrLessLeavers(BigInteger.valueOf(0));
				q22a1LengthOfParticipationCoCProjectsTable.setQ22a1A30DaysOrLessStayers(BigInteger.valueOf(0));

				q22a1LengthOfParticipationCoCProjectsTable.setQ22a1B31To60DaysTotal(BigInteger.valueOf(0));
				q22a1LengthOfParticipationCoCProjectsTable.setQ22a1B31To60DaysLeavers(BigInteger.valueOf(0));
				q22a1LengthOfParticipationCoCProjectsTable.setQ22a1B31To60DaysStayers(BigInteger.valueOf(0));

				q22a1LengthOfParticipationCoCProjectsTable.setQ22a1C61To90DaysTotal(BigInteger.valueOf(0));
				q22a1LengthOfParticipationCoCProjectsTable.setQ22a1C61To90DaysLeavers(BigInteger.valueOf(0));
				q22a1LengthOfParticipationCoCProjectsTable.setQ22a1C61To90DaysStayers(BigInteger.valueOf(0));
				
				q22a1LengthOfParticipationCoCProjectsTable.setQ22a1D91To180DaysTotal(BigInteger.valueOf(0));
				q22a1LengthOfParticipationCoCProjectsTable.setQ22a1D91To180DaysLeavers(BigInteger.valueOf(0));
				q22a1LengthOfParticipationCoCProjectsTable.setQ22a1D91To180DaysStayers(BigInteger.valueOf(0));

				q22a1LengthOfParticipationCoCProjectsTable.setQ22a1E181To365DaysTotal(BigInteger.valueOf(0));
				q22a1LengthOfParticipationCoCProjectsTable.setQ22a1E181To365DaysLeavers(BigInteger.valueOf(0));
				q22a1LengthOfParticipationCoCProjectsTable.setQ22a1E181To365DaysStayers(BigInteger.valueOf(0));

				q22a1LengthOfParticipationCoCProjectsTable.setQ22a1F366To730DaysTotal(BigInteger.valueOf(0));
				q22a1LengthOfParticipationCoCProjectsTable.setQ22a1F366To730DaysLeavers(BigInteger.valueOf(0));
				q22a1LengthOfParticipationCoCProjectsTable.setQ22a1F366To730DaysStayers(BigInteger.valueOf(0));

				q22a1LengthOfParticipationCoCProjectsTable.setQ22a1G731To1095DaysTotal(BigInteger.valueOf(0));
				q22a1LengthOfParticipationCoCProjectsTable.setQ22a1G731To1095DaysLeavers(BigInteger.valueOf(0));
				q22a1LengthOfParticipationCoCProjectsTable.setQ22a1G731To1095DaysStayers(BigInteger.valueOf(0));

				q22a1LengthOfParticipationCoCProjectsTable.setQ22a1H1096To1460DaysTotal(BigInteger.valueOf(0));
				q22a1LengthOfParticipationCoCProjectsTable.setQ22a1H1096To1460DaysLeavers(BigInteger.valueOf(0));
				q22a1LengthOfParticipationCoCProjectsTable.setQ22a1H1096To1460DaysStayers(BigInteger.valueOf(0));

				q22a1LengthOfParticipationCoCProjectsTable.setQ22a1I1461To1825DaysTotal(BigInteger.valueOf(0));
				q22a1LengthOfParticipationCoCProjectsTable.setQ22a1I1461To1825DaysLeavers(BigInteger.valueOf(0));
				q22a1LengthOfParticipationCoCProjectsTable.setQ22a1I1461To1825DaysStayers(BigInteger.valueOf(0));

				q22a1LengthOfParticipationCoCProjectsTable.setQ22a1JMoreThan1825DaysTotal(BigInteger.valueOf(0));
				q22a1LengthOfParticipationCoCProjectsTable.setQ22a1JMoreThan1825DaysLeavers(BigInteger.valueOf(0));
				q22a1LengthOfParticipationCoCProjectsTable.setQ22a1JMoreThan1825DaysStayers(BigInteger.valueOf(0));

				q22a1LengthOfParticipationCoCProjectsTable.setQ22a1KInfoMissingTotal(BigInteger.valueOf(0));
				q22a1LengthOfParticipationCoCProjectsTable.setQ22a1KInfoMissingLeavers(BigInteger.valueOf(0));
				q22a1LengthOfParticipationCoCProjectsTable.setQ22a1KInfoMissingStayers(BigInteger.valueOf(0));

				q22a1LengthOfParticipationCoCProjectsTable.setQ22a1LTotTotal(BigInteger.valueOf(data.getTotNumOfPersonServed()));
				q22a1LengthOfParticipationCoCProjectsTable.setQ22a1LTotLeavers(BigInteger.valueOf(0));
				q22a1LengthOfParticipationCoCProjectsTable.setQ22a1LTotStayers(BigInteger.valueOf(0));
						
		
		return Arrays.asList(q22a1LengthOfParticipationCoCProjectsTable);
		
	}
	
}
