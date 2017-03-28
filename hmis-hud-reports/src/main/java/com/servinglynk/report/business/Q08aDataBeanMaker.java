package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import com.servinglynk.report.bean.Q08aDataBean;

public class Q08aDataBeanMaker {
	
        public static List<Q08aDataBean> getQ08aDataBeanList() {
    	
        	Q08aDataBean q08aDataBean = new Q08aDataBean();
                
        	q08aDataBean.setOverAllTotHouseHolds(BigInteger.valueOf(0));
        	q08aDataBean.setTotHhWithoutChild(BigInteger.valueOf(0));
        	q08aDataBean.setTotHhUnknownHhType(BigInteger.valueOf(0));
        	q08aDataBean.setTotHhWothOnlyChild(BigInteger.valueOf(0));
        	q08aDataBean.setTotHhWithChildAndAdults(BigInteger.valueOf(0));
        	
        	return Arrays.asList(q08aDataBean);
        }
        
        
}