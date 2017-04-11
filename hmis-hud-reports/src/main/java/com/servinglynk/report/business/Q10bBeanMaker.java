package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import com.servinglynk.report.bean.Q10bGenderOfChildrenDataBean;
import com.servinglynk.report.bean.ReportData;

public class Q10bBeanMaker {

	public static List<Q10bGenderOfChildrenDataBean> getQ10bGenderOfChildrenList(ReportData data){
    	
		Q10bGenderOfChildrenDataBean q10bGenderOfChildren = new Q10bGenderOfChildrenDataBean();
		
		q10bGenderOfChildren.setTotChildMale(BigInteger.valueOf(0));
		q10bGenderOfChildren.setTotChildFemale(BigInteger.valueOf(0));
		q10bGenderOfChildren.setTotChildTransgenderMF(BigInteger.valueOf(0));
		q10bGenderOfChildren.setTotChildOther(BigInteger.valueOf(0));
		q10bGenderOfChildren.setTotChildDontKnowRefused(BigInteger.valueOf(0));
		q10bGenderOfChildren.setTotChildInfoMissing(BigInteger.valueOf(0));
		q10bGenderOfChildren.setTotChildSubtotal(BigInteger.valueOf(data.getNumOfChildren()));
		q10bGenderOfChildren.setChildMaleWOC(BigInteger.valueOf(0));
		q10bGenderOfChildren.setChildMaleWCA(BigInteger.valueOf(0));
		q10bGenderOfChildren.setChildMaleUHHT(BigInteger.valueOf(0));
		q10bGenderOfChildren.setChildFemaleWOC(BigInteger.valueOf(0));
		q10bGenderOfChildren.setChildFemaleWCA(BigInteger.valueOf(0));
		q10bGenderOfChildren.setChildFemaleUHHT(BigInteger.valueOf(0));
		q10bGenderOfChildren.setChildTransgenderMFWOC(BigInteger.valueOf(0));
		q10bGenderOfChildren.setChildTransgenderMFWCA(BigInteger.valueOf(0));
		q10bGenderOfChildren.setChildTransgenderMFUHHT(BigInteger.valueOf(0));
		q10bGenderOfChildren.setChildOtherWOC(BigInteger.valueOf(0));
		q10bGenderOfChildren.setChildOtherWCA(BigInteger.valueOf(0));
		q10bGenderOfChildren.setChildOtherUHHT(BigInteger.valueOf(0));
		q10bGenderOfChildren.setChildDkrWOC(BigInteger.valueOf(0));
		q10bGenderOfChildren.setChildDkrWCA(BigInteger.valueOf(0));
		q10bGenderOfChildren.setChildDkrUHHT(BigInteger.valueOf(0));
		q10bGenderOfChildren.setChildInfomiisingWOC(BigInteger.valueOf(0));
		q10bGenderOfChildren.setChildInfomiisingWCA(BigInteger.valueOf(0));
		q10bGenderOfChildren.setChildInfomiisingUHHT(BigInteger.valueOf(0));
		q10bGenderOfChildren.setChildSubtotalWOC(BigInteger.valueOf(0));
		q10bGenderOfChildren.setChildSubtotalWCA(BigInteger.valueOf(0));
		q10bGenderOfChildren.setChildSubtotalUHHT(BigInteger.valueOf(0));
		q10bGenderOfChildren.setTotChildTransgenderFM(BigInteger.valueOf(0));
		q10bGenderOfChildren.setChildTransgenderFMWOC(BigInteger.valueOf(0));
		q10bGenderOfChildren.setChildTransgenderFMWCA(BigInteger.valueOf(0));
		q10bGenderOfChildren.setChildTransgenderFMUHHT(BigInteger.valueOf(0));
		
    	return Arrays.asList(q10bGenderOfChildren);
    	
    }
    


}
