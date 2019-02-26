package com.servinglynk.report.bean;

import java.math.BigInteger;


public class Q06bNumberOfPersonsServedDataBean extends ReportBean{

	private BigInteger veteranStatusErrorCount=BigInteger.valueOf(0);
	private BigInteger veteranStatusErrorRate=BigInteger.valueOf(0);
	private BigInteger pedErrorCount=BigInteger.valueOf(0);
	private BigInteger pedErrorRate=BigInteger.valueOf(0);
	private BigInteger relationshipHHErrorCount=BigInteger.valueOf(0);
	private BigInteger relationshipHHErrorRate=BigInteger.valueOf(0);
	private BigInteger clientLocationErrorCount=BigInteger.valueOf(0);
	private BigInteger clientLocationErrorRate=BigInteger.valueOf(0);
	private BigInteger disablingCondErrorCount=BigInteger.valueOf(0);
	private BigInteger disablingCondErrorRate=BigInteger.valueOf(0);
	
	public BigInteger getVeteranStatusErrorCount() {
		return veteranStatusErrorCount;
	}
	public void setVeteranStatusErrorCount(BigInteger veteranStatusErrorCount) {
		this.veteranStatusErrorCount = veteranStatusErrorCount;
	}
	public BigInteger getVeteranStatusErrorRate() {
		return veteranStatusErrorRate;
	}
	public void setVeteranStatusErrorRate(BigInteger veteranStatusErrorRate) {
		this.veteranStatusErrorRate = veteranStatusErrorRate;
	}
	public BigInteger getPedErrorCount() {
		return pedErrorCount;
	}
	public void setPedErrorCount(BigInteger pedErrorCount) {
		this.pedErrorCount = pedErrorCount;
	}
	public BigInteger getPedErrorRate() {
		return pedErrorRate;
	}
	public void setPedErrorRate(BigInteger pedErrorRate) {
		this.pedErrorRate = pedErrorRate;
	}
	public BigInteger getRelationshipHHErrorCount() {
		return relationshipHHErrorCount;
	}
	public void setRelationshipHHErrorCount(BigInteger relationshipHHErrorCount) {
		this.relationshipHHErrorCount = relationshipHHErrorCount;
	}
	public BigInteger getRelationshipHHErrorRate() {
		return relationshipHHErrorRate;
	}
	public void setRelationshipHHErrorRate(BigInteger relationshipHHErrorRate) {
		this.relationshipHHErrorRate = relationshipHHErrorRate;
	}
	public BigInteger getClientLocationErrorCount() {
		return clientLocationErrorCount;
	}
	public void setClientLocationErrorCount(BigInteger clientLocationErrorCount) {
		this.clientLocationErrorCount = clientLocationErrorCount;
	}
	public BigInteger getClientLocationErrorRate() {
		return clientLocationErrorRate;
	}
	public void setClientLocationErrorRate(BigInteger clientLocationErrorRate) {
		this.clientLocationErrorRate = clientLocationErrorRate;
	}
	public BigInteger getDisablingCondErrorCount() {
		return disablingCondErrorCount;
	}
	public void setDisablingCondErrorCount(BigInteger disablingCondErrorCount) {
		this.disablingCondErrorCount = disablingCondErrorCount;
	}
	public BigInteger getDisablingCondErrorRate() {
		return disablingCondErrorRate;
	}
	public void setDisablingCondErrorRate(BigInteger disablingCondErrorRate) {
		this.disablingCondErrorRate = disablingCondErrorRate;
	}
	
}
