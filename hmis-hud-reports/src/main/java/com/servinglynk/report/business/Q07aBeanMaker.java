package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import com.servinglynk.report.bean.Q07aHouseholdsServedDataBean;

public class Q07aBeanMaker {
	
        public static List<Q07aHouseholdsServedDataBean> getQ07aHouseholdsServeList() {
    	
        	Q07aHouseholdsServedDataBean q07aHouseholdsServed = new Q07aHouseholdsServedDataBean();
                
        	q07aHouseholdsServed.setOverAllTotHouseHolds(BigInteger.valueOf(0));
        	q07aHouseholdsServed.setTotHhWithoutChild(BigInteger.valueOf(0));
        	q07aHouseholdsServed.setTotHhUnknownHhType(BigInteger.valueOf(0));
        	q07aHouseholdsServed.setTotHhWothOnlyChild(BigInteger.valueOf(0));
        	q07aHouseholdsServed.setTotHhWithChildAndAdults(BigInteger.valueOf(0));
        	
        	return Arrays.asList(q07aHouseholdsServed);
        }
        
        
}