package com.servinglynk.report.business;

import java.math.BigInteger;

import com.servinglynk.report.bean.Q11AgeTableBean;

public class Q11AgeTableBeanMaker {

	public Q11AgeTableBean q11AgeTableBean(BigInteger totAgeUnder5, BigInteger totAge5to12,
			BigInteger totAge13to17, BigInteger totAge18to24,
			BigInteger totAge25to34, BigInteger totAge35to44,
			BigInteger totAge45to54, BigInteger totAge55to61,
			BigInteger totAge62Plus, BigInteger totAgeDKR,
			BigInteger totAgeInfoMissing, BigInteger totOverallTotal,
			BigInteger ageUnder5WOC, BigInteger ageUnder5WCA,
			BigInteger ageUnder5WithOnlyChild, BigInteger ageUnder5UHHT,
			BigInteger age5to12woc, BigInteger age5to12wca,
			BigInteger age5to12WithOnlyChild, BigInteger age5to12uhht,
			BigInteger age13to17woc, BigInteger age13to17wca,
			BigInteger age13to17WithOnlyChild, BigInteger age13to17uhht,
			BigInteger age18to24woc, BigInteger age18to24wca,
			BigInteger age18to24WithOnlyChild, BigInteger age18to24uhht,
			BigInteger age25to34woc, BigInteger age25to34wca,
			BigInteger age25to34WithOnlyChild, BigInteger age25to34uhht,
			BigInteger age35to44woc, BigInteger age35to44wca,
			BigInteger age35to44WithOnlyChild, BigInteger age35to44uhht,
			BigInteger age45to54woc, BigInteger age45to54wca,
			BigInteger age45to54WithOnlyChild, BigInteger age45to54uhht,
			BigInteger age55to61woc, BigInteger age55to61wca,
			BigInteger age55to61WithOnlyChild, BigInteger age55to61uhht,
			BigInteger age62PlusWOC, BigInteger age62PlusWCA,
			BigInteger age62PlusWithOnlyChild, BigInteger age62PlusUHHT,
			BigInteger ageDKRWOC, BigInteger ageDKRWCA,
			BigInteger ageDKRWithOnlyChild, BigInteger ageDKRUHHT,
			BigInteger ageInfoMissingWOC, BigInteger ageInfoMissingWCA,
			BigInteger ageInfoMissingWithOnlyChild,
			BigInteger ageInfoMissingUHHT, BigInteger ageOverallTotalWOC,
			BigInteger ageOverallTotalWCA,
			BigInteger ageOverallTotalWithOnlyChild,
			BigInteger ageOverallTotalUHHT/*,
			Q11AgeTableBean q11AgeTableBean*/) {
 	
		Q11AgeTableBean q11AgeTableBean = new Q11AgeTableBean(ageOverallTotalUHHT, ageOverallTotalUHHT, ageOverallTotalUHHT, ageOverallTotalUHHT, ageOverallTotalUHHT, ageOverallTotalUHHT, ageOverallTotalUHHT, ageOverallTotalUHHT, ageOverallTotalUHHT, ageOverallTotalUHHT, ageOverallTotalUHHT, ageOverallTotalUHHT, ageOverallTotalUHHT, ageOverallTotalUHHT, ageOverallTotalUHHT, ageOverallTotalUHHT, ageOverallTotalUHHT, ageOverallTotalUHHT, ageOverallTotalUHHT, ageOverallTotalUHHT, ageOverallTotalUHHT, ageOverallTotalUHHT, ageOverallTotalUHHT, ageOverallTotalUHHT, ageOverallTotalUHHT, ageOverallTotalUHHT, ageOverallTotalUHHT, ageOverallTotalUHHT, ageOverallTotalUHHT, ageOverallTotalUHHT, ageOverallTotalUHHT, ageOverallTotalUHHT, ageOverallTotalUHHT, ageOverallTotalUHHT, ageOverallTotalUHHT, ageOverallTotalUHHT, ageOverallTotalUHHT, ageOverallTotalUHHT, ageOverallTotalUHHT, ageOverallTotalUHHT, ageOverallTotalUHHT, ageOverallTotalUHHT, ageOverallTotalUHHT, ageOverallTotalUHHT, ageOverallTotalUHHT, ageOverallTotalUHHT, ageOverallTotalUHHT, ageOverallTotalUHHT, ageOverallTotalUHHT, ageOverallTotalUHHT, ageOverallTotalUHHT, ageOverallTotalUHHT, ageOverallTotalUHHT, ageOverallTotalUHHT, ageOverallTotalUHHT, ageOverallTotalUHHT, ageOverallTotalUHHT, ageOverallTotalUHHT, ageOverallTotalUHHT, ageOverallTotalUHHT);
		/*q11AgeTableBean.setAge13to17UHHT(age13to17uhht);
		q11AgeTableBean.setAge13to17WCA(age13to17wca);
		q11AgeTableBean.setAge13to17WithOnlyChild(age13to17WithOnlyChild);
		q11AgeTableBean.setAge13to17WOC(age13to17woc);
		q11AgeTableBean.setAge18to24UHHT(age18to24uhht);
		q11AgeTableBean.setAge18to24WCA(age18to24wca);
		q11AgeTableBean.setAge18to24WithOnlyChild(age18to24WithOnlyChild);
		q11AgeTableBean.setAge18to24WOC(age18to24woc);
		q11AgeTableBean.setAge25to34UHHT(age25to34uhht);
		q11AgeTableBean.setAge25to34WCA(age25to34wca);
		q11AgeTableBean.setAge25to34WithOnlyChild(age25to34WithOnlyChild);
		q11AgeTableBean.setAge25to34WOC(age25to34woc);
		q11AgeTableBean.setAge35to44UHHT(age35to44uhht);
		q11AgeTableBean.setAge35to44WCA(age35to44wca);
		q11AgeTableBean.setAge35to44WithOnlyChild(age35to44WithOnlyChild);
		q11AgeTableBean.setAge35to44WOC(age35to44woc);
		q11AgeTableBean.setAge45to54UHHT(age45to54uhht);
		q11AgeTableBean.setAge45to54WCA(age45to54wca);
		q11AgeTableBean.setAge45to54WithOnlyChild(age45to54WithOnlyChild);
		q11AgeTableBean.setAge45to54WOC(age45to54woc);
		q11AgeTableBean.setAge55to61UHHT(age55to61uhht);
		q11AgeTableBean.setAge55to61WCA(age55to61wca);
		q11AgeTableBean.setAge55to61WithOnlyChild(age55to61WithOnlyChild);
		q11AgeTableBean.setAge55to61WOC(age55to61woc);
		q11AgeTableBean.setAge62PlusUHHT(age62PlusUHHT);
		q11AgeTableBean.setAge62PlusWCA(age62PlusWCA);
		q11AgeTableBean.setAge62PlusWithOnlyChild(age62PlusWithOnlyChild);
		q11AgeTableBean.setAge62PlusWOC(age62PlusWOC);
		q11AgeTableBean.setAgeDKRUHHT(ageDKRUHHT);
		q11AgeTableBean.setAgeDKRWCA(ageDKRWCA);
		q11AgeTableBean.setAgeDKRWithOnlyChild(ageDKRWithOnlyChild);
		q11AgeTableBean.setAgeDKRWOC(ageDKRWOC);
		q11AgeTableBean.setAgeInfoMissingUHHT(ageInfoMissingUHHT);
		q11AgeTableBean.setAgeInfoMissingWCA(ageInfoMissingWCA);
		q11AgeTableBean.setAgeInfoMissingWithOnlyChild(ageInfoMissingWithOnlyChild);
		q11AgeTableBean.setAgeInfoMissingWOC(ageInfoMissingWOC);
		q11AgeTableBean.setAgeUnder5UHHT(ageUnder5UHHT);
		q11AgeTableBean.setAgeUnder5WCA(ageUnder5WCA);
		q11AgeTableBean.setAgeUnder5WithOnlyChild(ageUnder5WithOnlyChild);
		q11AgeTableBean.setAgeUnder5WOC(ageUnder5WOC);
		q11AgeTableBean.setAgeOverallTotalUHHT(ageOverallTotalUHHT);
		q11AgeTableBean.setAgeOverallTotalWCA(ageOverallTotalWCA);
		q11AgeTableBean.setAgeOverallTotalWithOnlyChild(ageOverallTotalWithOnlyChild);
		q11AgeTableBean.setAgeOverallTotalWOC(ageOverallTotalWOC);
		q11AgeTableBean.setTotOverallTotal(totOverallTotal);
		q11AgeTableBean.setTotAge13to17(totAge13to17);
		q11AgeTableBean.setTotAge18to24(totAge18to24);
		q11AgeTableBean.setTotAge25to34(totAge25to34);
		q11AgeTableBean.setTotAge35to44(totAge35to44);
		q11AgeTableBean.setTotAge45to54(totAge45to54);
		q11AgeTableBean.setTotAge55to61(totAge55to61);
		q11AgeTableBean.setTotAge5to12(totAge5to12);
		q11AgeTableBean.setTotAge62Plus(totAge62Plus);
		q11AgeTableBean.setTotAgeDKR(totAgeDKR);
		q11AgeTableBean.setTotAgeInfoMissing(totAgeInfoMissing);
		q11AgeTableBean.setTotAgeUnder5(totAgeUnder5);
		q11AgeTableBean.setTotOverallTotal(totOverallTotal);
		q11AgeTableBean.setAge5to12UHHT(age5to12uhht);
		q11AgeTableBean.setAge5to12WCA(age5to12wca);
		q11AgeTableBean.setAge5to12WithOnlyChild(age5to12WithOnlyChild);
		q11AgeTableBean.setAge5to12WOC(age5to12woc);*/
		
     	
     	return q11AgeTableBean;
     }
}
