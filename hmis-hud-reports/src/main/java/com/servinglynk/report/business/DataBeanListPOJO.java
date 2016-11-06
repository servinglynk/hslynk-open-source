package com.servinglynk.report.business;

import java.util.ArrayList;

import com.servinglynk.report.bean.DataBean;

public class DataBeanListPOJO {
	
	ArrayList<DataBean> getBeanData = new ArrayList<DataBean>();
	ArrayList<DataBean> getbeanData5 = new ArrayList<DataBean>();
	public ArrayList<DataBean> getGetBeanData() {
		return getBeanData;
	}
	public void setGetBeanData(ArrayList<DataBean> getBeanData) {
		this.getBeanData = getBeanData;
	}
	public ArrayList<DataBean> getGetbeanData5() {
		return getbeanData5;
	}
	public void setGetbeanData5(ArrayList<DataBean> getbeanData5) {
		this.getbeanData5 = getbeanData5;
	}
	
	

}
