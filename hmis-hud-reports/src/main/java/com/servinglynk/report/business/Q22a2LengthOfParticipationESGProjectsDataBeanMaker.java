package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import com.servinglynk.report.bean.Q22a2LengthOfParticipationESGProjectsDataBean;
import com.servinglynk.report.bean.ReportData;

public class Q22a2LengthOfParticipationESGProjectsDataBeanMaker {

	public static List<Q22a2LengthOfParticipationESGProjectsDataBean> getQ22a2LengthOfParticipationESGProjectsList(ReportData data){
		
		Q22a2LengthOfParticipationESGProjectsDataBean q22a2LengthOfParticipationESGProjectsTable = new Q22a2LengthOfParticipationESGProjectsDataBean();
		
				q22a2LengthOfParticipationESGProjectsTable.setQ22a2A30DaysOrLessTotal(BigInteger.valueOf(0));
				q22a2LengthOfParticipationESGProjectsTable.setQ22a2A30DaysOrLessLeavers(BigInteger.valueOf(0));
				q22a2LengthOfParticipationESGProjectsTable.setQ22a2A30DaysOrLessStayers(BigInteger.valueOf(0));

				q22a2LengthOfParticipationESGProjectsTable.setQ22a2B31To60DaysTotal(BigInteger.valueOf(0));
				q22a2LengthOfParticipationESGProjectsTable.setQ22a2B31To60DaysLeavers(BigInteger.valueOf(0));
				q22a2LengthOfParticipationESGProjectsTable.setQ22a2B31To60DaysStayers(BigInteger.valueOf(0));

				q22a2LengthOfParticipationESGProjectsTable.setQ22a2C61To90DaysTotal(BigInteger.valueOf(0));
				q22a2LengthOfParticipationESGProjectsTable.setQ22a2C61To90DaysLeavers(BigInteger.valueOf(0));
				q22a2LengthOfParticipationESGProjectsTable.setQ22a2C61To90DaysStayers(BigInteger.valueOf(0));
				
				q22a2LengthOfParticipationESGProjectsTable.setQ22a2D91To180DaysTotal(BigInteger.valueOf(0));
				q22a2LengthOfParticipationESGProjectsTable.setQ22a2D91To180DaysLeavers(BigInteger.valueOf(0));
				q22a2LengthOfParticipationESGProjectsTable.setQ22a2D91To180DaysStayers(BigInteger.valueOf(0));

				q22a2LengthOfParticipationESGProjectsTable.setQ22a2E181To365DaysTotal(BigInteger.valueOf(0));
				q22a2LengthOfParticipationESGProjectsTable.setQ22a2E181To365DaysLeavers(BigInteger.valueOf(0));
				q22a2LengthOfParticipationESGProjectsTable.setQ22a2E181To365DaysStayers(BigInteger.valueOf(0));

				q22a2LengthOfParticipationESGProjectsTable.setQ22a2F366To730DaysTotal(BigInteger.valueOf(0));
				q22a2LengthOfParticipationESGProjectsTable.setQ22a2F366To730DaysLeavers(BigInteger.valueOf(0));
				q22a2LengthOfParticipationESGProjectsTable.setQ22a2F366To730DaysStayers(BigInteger.valueOf(0));

				q22a2LengthOfParticipationESGProjectsTable.setQ22a2G731To1095DaysTotal(BigInteger.valueOf(0));
				q22a2LengthOfParticipationESGProjectsTable.setQ22a2G731To1095DaysLeavers(BigInteger.valueOf(0));
				q22a2LengthOfParticipationESGProjectsTable.setQ22a2G731To1095DaysStayers(BigInteger.valueOf(0));

				q22a2LengthOfParticipationESGProjectsTable.setQ22a2H1096To1460DaysTotal(BigInteger.valueOf(0));
				q22a2LengthOfParticipationESGProjectsTable.setQ22a2H1096To1460DaysLeavers(BigInteger.valueOf(0));
				q22a2LengthOfParticipationESGProjectsTable.setQ22a2H1096To1460DaysStayers(BigInteger.valueOf(0));

				q22a2LengthOfParticipationESGProjectsTable.setQ22a2I1461To1825DaysTotal(BigInteger.valueOf(0));
				q22a2LengthOfParticipationESGProjectsTable.setQ22a2I1461To1825DaysLeavers(BigInteger.valueOf(0));
				q22a2LengthOfParticipationESGProjectsTable.setQ22a2I1461To1825DaysStayers(BigInteger.valueOf(0));

				q22a2LengthOfParticipationESGProjectsTable.setQ22a2JMoreThan1825DaysTotal(BigInteger.valueOf(0));
				q22a2LengthOfParticipationESGProjectsTable.setQ22a2JMoreThan1825DaysLeavers(BigInteger.valueOf(0));
				q22a2LengthOfParticipationESGProjectsTable.setQ22a2JMoreThan1825DaysStayers(BigInteger.valueOf(0));

				q22a2LengthOfParticipationESGProjectsTable.setQ22a2KInfoMissingTotal(BigInteger.valueOf(0));
				q22a2LengthOfParticipationESGProjectsTable.setQ22a2KInfoMissingLeavers(BigInteger.valueOf(0));
				q22a2LengthOfParticipationESGProjectsTable.setQ22a2KInfoMissingStayers(BigInteger.valueOf(0));

				q22a2LengthOfParticipationESGProjectsTable.setQ22a2LTotTotal(data.getTotNumOfPersonServed());
				q22a2LengthOfParticipationESGProjectsTable.setQ22a2LTotLeavers(BigInteger.valueOf(0));
				q22a2LengthOfParticipationESGProjectsTable.setQ22a2LTotStayers(BigInteger.valueOf(0));
						
		
		return Arrays.asList(q22a2LengthOfParticipationESGProjectsTable);
		
	}
	
}
