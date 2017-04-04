package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import com.servinglynk.report.bean.Q07aHouseholdsServedDataBean;

public class Q07aBeanMaker {
	
        public static List<Q07aHouseholdsServedDataBean> getQ07aHouseholdsServeList() {
    	
        	Q07aHouseholdsServedDataBean q07aHouseholdsServed = new Q07aHouseholdsServedDataBean();
                
        	q07aHouseholdsServed.setAdultsTotal(BigInteger.valueOf(0));
        	q07aHouseholdsServed.setAdultsWithOutChildren(BigInteger.valueOf(0));
        	q07aHouseholdsServed.setAdultsWithChildAndAdults(BigInteger.valueOf(0));
        	q07aHouseholdsServed.setAdultsWithOnlychildren(BigInteger.valueOf(0));
        	q07aHouseholdsServed.setAdultsUnknownHousehold(BigInteger.valueOf(0));
        	q07aHouseholdsServed.setChildTotal(BigInteger.valueOf(0));
        	q07aHouseholdsServed.setChildWithOutChildren(BigInteger.valueOf(0));
        	q07aHouseholdsServed.setChildWithChildAndAdults(BigInteger.valueOf(0));
        	q07aHouseholdsServed.setChildWithOnlychildren(BigInteger.valueOf(0));
        	q07aHouseholdsServed.setChildUnknownHousehold(BigInteger.valueOf(0));
        	q07aHouseholdsServed.setClientDKRTotal(BigInteger.valueOf(0));
        	q07aHouseholdsServed.setClientDKRWithOutChildren(BigInteger.valueOf(0));
        	q07aHouseholdsServed.setClientDKRWithChildAndAdults(BigInteger.valueOf(0));
        	q07aHouseholdsServed.setClientDKRWithOnlychildren(BigInteger.valueOf(0));
        	q07aHouseholdsServed.setClientDKRUnknownHousehold(BigInteger.valueOf(0));
        	q07aHouseholdsServed.setDncTotal(BigInteger.valueOf(0));
        	q07aHouseholdsServed.setDncWithOutChildren(BigInteger.valueOf(0));
        	q07aHouseholdsServed.setDncWithChildAndAdults(BigInteger.valueOf(0));
        	q07aHouseholdsServed.setDncWithOnlychildren(BigInteger.valueOf(0));
        	q07aHouseholdsServed.setDncUnknownHousehold(BigInteger.valueOf(0));
        	q07aHouseholdsServed.setTotTotal(BigInteger.valueOf(0));
        	q07aHouseholdsServed.setTotWithOutChildren(BigInteger.valueOf(0));
        	q07aHouseholdsServed.setTotWithChildAndAdults(BigInteger.valueOf(0));
        	q07aHouseholdsServed.setTotWithOnlychildren(BigInteger.valueOf(0));
        	q07aHouseholdsServed.setTotUnknownHousehold(BigInteger.valueOf(0));
        		
        	return Arrays.asList(q07aHouseholdsServed);
        }
        
        
}