package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import com.servinglynk.report.bean.Q20aTypeOfNonCashBenefitSourcesDataBean;
import com.servinglynk.report.bean.Q20bNumberOfNonCashBenefitSourcesDataBean;
import com.servinglynk.report.bean.ReportData;

public class Q20bBeanMaker extends BaseBeanMaker {
	
	public static List<Q20bNumberOfNonCashBenefitSourcesDataBean> getQ20bNumberOfNonCashBenefitSourcesList(ReportData data){
		
		Q20bNumberOfNonCashBenefitSourcesDataBean q20bNumberOfNonCashBenefitSourcesTable = new Q20bNumberOfNonCashBenefitSourcesDataBean();
		Q20aTypeOfNonCashBenefitSourcesDataBean q20aTypeOfNonCashBenefitSourcesTable = new Q20aTypeOfNonCashBenefitSourcesDataBean();
		String entryQuery = " select  nb.snap,nb.wic,nb.tanfchildcare,nb.tanftransportation,nb.othertanf,nb.benefitsfromanysource from incomeandsources i, enrollment e,noncashbenefits nb where e.id=i.enrollmentid  "+
		      "   and nb.enrollmentid = e.id "+
			  " and i.information_date = e.entrydate and i.information_date <= ? and i.information_date >= ? "+
			  " and e.ageatentry >=18  and i.datacollectionstage = ? ";
		       
		String exitQuery = "  select  nb.snap,nb.wic,nb.tanfchildcare,nb.tanftransportation,nb.othertanf,nb.benefitsfromanysource  from incomeandsources i, enrollment e,noncashbenefits nb,exit ext where e.id=i.enrollmentid  "+
			      "   and nb.enrollmentid = e.id and e.id = ext.enrollmentid"+
				  " and i.information_date = ext.extdate and i.information_date <= ? and i.information_date >= ? "+
				  " and e.ageatentry >=18  and i.datacollectionstage = ? ";
			       
		String stayersQuery = " select  nb.snap,nb.wic,nb.tanfchildcare,nb.tanftransportation,nb.othertanf,nb.benefitsfromanysource  from incomeandsources i, enrollment e where   e.id=i.enrollmentid "+
					" and i.information_date >= e.entrydate and i.information_date >= ? and i.information_date <= ? and e.ageatentry >= 18 "+
					" and   e.id not in ( select enrollmentid from exit  where  exitdate >= ?  )   "+
					" and   e.id not in ( select enrollmentid from enrollment_coc where datacollectionstage=? and datediff(now(),information_date) < 365 ) ";
			try {
				if(data.isLiveMode()) {
					q20bNumberOfNonCashBenefitSourcesTable.setQ20bNosourcesAtEntry(BigInteger.valueOf(0));
					q20bNumberOfNonCashBenefitSourcesTable.setQ20bNosourcesAtLatestStayers(BigInteger.valueOf(0));
					q20bNumberOfNonCashBenefitSourcesTable.setQ20bNosourcesAtExitLeavers(BigInteger.valueOf(0));
							
					q20bNumberOfNonCashBenefitSourcesTable.setQ20b1PlusSourcesAtEntry(BigInteger.valueOf(0));
					q20bNumberOfNonCashBenefitSourcesTable.setQ20b1PlusSourcesAtLatestStayers(BigInteger.valueOf(0));
					q20bNumberOfNonCashBenefitSourcesTable.setQ20b1PlusSourcesAtExitLeavers(BigInteger.valueOf(0));

					q20bNumberOfNonCashBenefitSourcesTable.setQ20bDKRAtEntry(BigInteger.valueOf(0));
					q20bNumberOfNonCashBenefitSourcesTable.setQ20bDKRAtLatestStayers(BigInteger.valueOf(0));
					q20bNumberOfNonCashBenefitSourcesTable.setQ20bDKRAtExitLeavers(BigInteger.valueOf(0));

					q20bNumberOfNonCashBenefitSourcesTable.setQ20bMissingInfoAtEntry(BigInteger.valueOf(0));
					q20bNumberOfNonCashBenefitSourcesTable.setQ20bMissingInfoAtLatestStayers(BigInteger.valueOf(0));
					q20bNumberOfNonCashBenefitSourcesTable.setQ20bMissingInfoAtExitLeavers(BigInteger.valueOf(0));

					q20bNumberOfNonCashBenefitSourcesTable.setQ20bTotalClientsAtEntry(data.getNumOfAdults());
					q20bNumberOfNonCashBenefitSourcesTable.setQ20bTotalClientsAtLatestStayers(data.getTotNoOfAdultStayers());
					q20bNumberOfNonCashBenefitSourcesTable.setQ20bTotalClientsAtExitLeavers(data.getTotNoOfAdultLeavers());
						
				}
			}catch(Exception e) {
				logger.error("Error in Q20bBeanMaker:" + e);
			}
		
		return Arrays.asList(q20bNumberOfNonCashBenefitSourcesTable);
	}

}
