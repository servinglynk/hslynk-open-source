package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import com.servinglynk.report.bean.Q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyDataBean;
import com.servinglynk.report.bean.ReportData;

public class Q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyDataBeanMaker extends BaseBeanMaker{
	
	public static List<Q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyDataBean> getQ26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyList(ReportData data){
		
		Q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyDataBean q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable = new Q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyDataBean();
		String chronicHomelessQuery ="select distinct(dedup_client_id) from %s.enrollment e,%s.client c,%.project p  where c.id =e.client_id and c.veteran_status ='1' and e.chronichomeless='true' and e.projectid = p.id %p";
		String noChronicHomelessQuery ="select distinct(dedup_client_id) from enrollment e,%s.client c,%.project p  where c.id =e.client_id and c.veteran_status ='1' and e.chronichomeless='false' and e.projectid = p.id %p";
		String dnKChHomelessQuery ="select distinct(dedup_client_id) from enrollment e,%s.client c,%.project p  where c.id =e.client_id and c.veteran_status ='1' and e.disablingcondition in ('8','9') and e.projectid = p.id %p";
		String dnCChHomelessQuery ="select distinct(dedup_client_id) from enrollment e,%s.client c,%.project p  where c.id =e.client_id and c.veteran_status ='1' and e.disablingcondition ='99' and e.projectid = p.id %p";
		
		int chSize = getSize(getClients(data.getSchema(), chronicHomelessQuery, data));
		String chWithoutChildQuery ="select distinct(dedup_client_id) from %s.enrollment e,%s.client c,%.project p  where c.id =e.client_id and c.veteran_status ='1' and e.chronichomeless='true' and e.projectid = p.id %p";
		String chChildAndAdultsQuery="select distinct(dedup_client_id) from %s.enrollment e,%s.client c,%.project p  where c.id =e.client_id and c.veteran_status ='1' and e.chronichomeless='true' and e.projectid = p.id %p";
		String chWithOnlyChildQuery ="select distinct(dedup_client_id) from %s.enrollment e,%s.client c,%.project p  where c.id =e.client_id and c.veteran_status ='1' and e.chronichomeless='true' and e.projectid = p.id %p";
		
	
		q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aChronicallyHomelessTotal(BigInteger.valueOf(chSize));
		q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aChronicallyHomelessWithoutChild(BigInteger.valueOf(0));
		q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aChronicallyHomelessWithChildAndAdults(BigInteger.valueOf(0));
		q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aChronicallyHomelessWithOnlyChild(BigInteger.valueOf(0));
		q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aChronicallyHomelessUnknownHouseholdType(BigInteger.valueOf(0));

		int noChSize = getSize(getClients(data.getSchema(), noChronicHomelessQuery, data));
		q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aNotChronicallyHomelessTotal(BigInteger.valueOf(noChSize));
		q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aNotChronicallyHomelessWithoutChild(BigInteger.valueOf(0));
		q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aNotChronicallyHomelessWithChildAndAdults(BigInteger.valueOf(0));
		q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aNotChronicallyHomelessWithOnlyChild(BigInteger.valueOf(0));
		q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aNotChronicallyHomelessUnknownHouseholdType(BigInteger.valueOf(0));
		int clientRefusedCHSize = getSize(getClients(data.getSchema(), dnKChHomelessQuery, data));
		q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aClientRefusedTotal(BigInteger.valueOf(clientRefusedCHSize));
		q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aClientRefusedWithoutChild(BigInteger.valueOf(0));
		q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aClientRefusedWithChildAndAdults(BigInteger.valueOf(0));
		q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aClientRefusedWithOnlyChild(BigInteger.valueOf(0));
		q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aClientRefusedUnknownHouseholdType(BigInteger.valueOf(0));
		int dncCHSize = getSize(getClients(data.getSchema(), dnCChHomelessQuery, data));
		q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aDataNotCollectedTotal(BigInteger.valueOf(dncCHSize));
		q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aDataNotCollectedWithoutChild(BigInteger.valueOf(0));
		q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aDataNotCollectedWithChildAndAdults(BigInteger.valueOf(0));
		q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aDataNotCollectedWithOnlyChild(BigInteger.valueOf(0));
		q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aDataNotCollectedUnknownHouseholdType(BigInteger.valueOf(0));
		int total = chSize + noChSize + clientRefusedCHSize + dncCHSize ;
		
		q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aTotTotal(BigInteger.valueOf(total));
		q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aTotWithoutChild(BigInteger.valueOf(0));
		q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aTotWithChildAndAdults(BigInteger.valueOf(0));
		q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aTotWithOnlyChild(BigInteger.valueOf(0));
		q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aTotUnknownHouseholdType(BigInteger.valueOf(0));
		
		return Arrays.asList(q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable); 
		
	}
	

}
