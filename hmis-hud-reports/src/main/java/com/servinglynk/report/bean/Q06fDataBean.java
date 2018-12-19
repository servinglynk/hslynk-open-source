package com.servinglynk.report.bean;

import java.math.BigInteger;

public class Q06fDataBean {
	
	private BigInteger contactNumberOfRecords=BigInteger.valueOf(0);
	private BigInteger contactNumberOfInactiveRecords=BigInteger.valueOf(0);
	private BigInteger contactPercentOfInactiveRecords=BigInteger.valueOf(0);
	private BigInteger bedNightNumberOfRecords=BigInteger.valueOf(0);
	private BigInteger bedNightNumberOfInactiveRecords=BigInteger.valueOf(0);
	private BigInteger bedNightPercentOfInactiveRecords=BigInteger.valueOf(0);
	public BigInteger getContactNumberOfRecords() {
		return contactNumberOfRecords;
	}
	public void setContactNumberOfRecords(BigInteger contactNumberOfRecords) {
		this.contactNumberOfRecords = contactNumberOfRecords;
	}
	public BigInteger getContactNumberOfInactiveRecords() {
		return contactNumberOfInactiveRecords;
	}
	public void setContactNumberOfInactiveRecords(
			BigInteger contactNumberOfInactiveRecords) {
		this.contactNumberOfInactiveRecords = contactNumberOfInactiveRecords;
	}
	public BigInteger getContactPercentOfInactiveRecords() {
		return contactPercentOfInactiveRecords;
	}
	public void setContactPercentOfInactiveRecords(
			BigInteger contactPercentOfInactiveRecords) {
		this.contactPercentOfInactiveRecords = contactPercentOfInactiveRecords;
	}
	public BigInteger getBedNightNumberOfRecords() {
		return bedNightNumberOfRecords;
	}
	public void setBedNightNumberOfRecords(BigInteger bedNightNumberOfRecords) {
		this.bedNightNumberOfRecords = bedNightNumberOfRecords;
	}
	public BigInteger getBedNightNumberOfInactiveRecords() {
		return bedNightNumberOfInactiveRecords;
	}
	public void setBedNightNumberOfInactiveRecords(
			BigInteger bedNightNumberOfInactiveRecords) {
		this.bedNightNumberOfInactiveRecords = bedNightNumberOfInactiveRecords;
	}
	public BigInteger getBedNightPercentOfInactiveRecords() {
		return bedNightPercentOfInactiveRecords;
	}
	public void setBedNightPercentOfInactiveRecords(
			BigInteger bedNightPercentOfInactiveRecords) {
		this.bedNightPercentOfInactiveRecords = bedNightPercentOfInactiveRecords;
	}
	
	

}
