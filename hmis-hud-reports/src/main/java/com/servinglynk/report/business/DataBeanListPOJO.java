package com.servinglynk.report.business;

import java.util.ArrayList;

import com.servinglynk.report.bean.DataBean_Old;

public class DataBeanListPOJO {
	
	ArrayList<DataBean_Old> getBeanData = new ArrayList<DataBean_Old>();
	ArrayList<DataBean_Old> getbeanData5 = new ArrayList<DataBean_Old>();
	public ArrayList<DataBean_Old> getGetBeanData() {
		return getBeanData;
	}
	public void setGetBeanData(ArrayList<DataBean_Old> getBeanData) {
		this.getBeanData = getBeanData;
	}
	public ArrayList<DataBean_Old> getGetbeanData5() {
		return getbeanData5;
	}
	public void setGetbeanData5(ArrayList<DataBean_Old> getbeanData5) {
		this.getbeanData5 = getbeanData5;
	}
	
	

}
