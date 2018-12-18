package com.servinglynk.report.bean;

import java.math.BigInteger;

public class Q08aDataBean {

	private BigInteger overAllTotHouseHolds=BigInteger.valueOf(0);
	private BigInteger totHhWithoutChild=BigInteger.valueOf(0);
	private BigInteger totHhWithChildAndAdults=BigInteger.valueOf(0);
	private BigInteger totHhWothOnlyChild=BigInteger.valueOf(0);
	private BigInteger totHhUnknownHhType=BigInteger.valueOf(0);
	public BigInteger getOverAllTotHouseHolds() {
		return overAllTotHouseHolds;
	}
	public void setOverAllTotHouseHolds(BigInteger overAllTotHouseHolds) {
		this.overAllTotHouseHolds = overAllTotHouseHolds;
	}
	public BigInteger getTotHhWithoutChild() {
		return totHhWithoutChild;
	}
	public void setTotHhWithoutChild(BigInteger totHhWithoutChild) {
		this.totHhWithoutChild = totHhWithoutChild;
	}
	public BigInteger getTotHhWithChildAndAdults() {
		return totHhWithChildAndAdults;
	}
	public void setTotHhWithChildAndAdults(BigInteger totHhWithChildAndAdults) {
		this.totHhWithChildAndAdults = totHhWithChildAndAdults;
	}
	public BigInteger getTotHhWothOnlyChild() {
		return totHhWothOnlyChild;
	}
	public void setTotHhWothOnlyChild(BigInteger totHhWothOnlyChild) {
		this.totHhWothOnlyChild = totHhWothOnlyChild;
	}
	public BigInteger getTotHhUnknownHhType() {
		return totHhUnknownHhType;
	}
	public void setTotHhUnknownHhType(BigInteger totHhUnknownHhType) {
		this.totHhUnknownHhType = totHhUnknownHhType;
	}
	
		
	
}
