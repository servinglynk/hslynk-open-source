package com.servinglynk.hmis.warehouse.core.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("vashExitReason")
public class VashExitReason extends ClientModel{
	private UUID vashExitReasonId;
	private UUID exitId;
	private Integer cmExitReason;
	/**
	 * @return the vashExitReasonId
	 */
	public UUID getVashExitReasonId() {
		return vashExitReasonId;
	}
	/**
	 * @param vashExitReasonId the vashExitReasonId to set
	 */
	public void setVashExitReasonId(UUID vashExitReasonId) {
		this.vashExitReasonId = vashExitReasonId;
	}
	/**
	 * @return the exitId
	 */
	public UUID getExitId() {
		return exitId;
	}
	/**
	 * @param exitId the exitId to set
	 */
	public void setExitId(UUID exitId) {
		this.exitId = exitId;
	}
	/**
	 * @return the cmExitReason
	 */
	public Integer getCmExitReason() {
		return cmExitReason;
	}
	/**
	 * @param cmExitReason the cmExitReason to set
	 */
	public void setCmExitReason(Integer cmExitReason) {
		this.cmExitReason = cmExitReason;
	}
	
}
