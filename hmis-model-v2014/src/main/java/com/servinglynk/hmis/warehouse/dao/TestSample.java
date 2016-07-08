package com.servinglynk.hmis.warehouse.dao;

public class TestSample {
	public static void main(String args[]) {
		Data data = new Data();
		increment(data);
		System.out.println("Value of i::"+data.i);
	}
	
	public static void increment(Data data) {
		for(int j=0;j<10;j++) {
			++data.i;
			System.out.println("::::Value of i::"+data.i);
		}
	}
}


