package com.servinglynk.hmis.warehouse.model.v2017;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.servinglynk.hmis.warehouse.enums.CMExitReasonEnum;
@Entity(name = "vashexitreason_v2017")
@Table(name = "vashexitreason", catalog = "hmis", schema = "v2017")
public class VASHExitReason  extends HmisBaseModel implements Cloneable, Serializable {
	
	private java.util.UUID id;
	private java.util.UUID exitId;
	private CMExitReasonEnum cmExitReason;
	
	public VASHExitReason() {
		// Default constructor
	}

	/** Constructor taking a given ID.
	 * @param id to set
	 */
	public VASHExitReason(java.util.UUID id) {
		this.id = id;
	}
	/**
	 * @return the id
	 */
	@Id
	@Basic( optional = false )
	@Column( name = "id", nullable = false  ) @org.hibernate.annotations.Type(type="org.hibernate.type.PostgresUUIDType")
	public java.util.UUID getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(java.util.UUID id) {
		this.id = id;
	}
	/**
	 * @return the exitId
	 */
	@Basic( optional = false )
	@Column( name = "exitid", nullable = false  ) @org.hibernate.annotations.Type(type="org.hibernate.type.PostgresUUIDType")
	public java.util.UUID getExitId() {
		return exitId;
	}
	/**
	 * @param exitId the exitId to set
	 */
	public void setExitId(java.util.UUID exitId) {
		this.exitId = exitId;
	}
	
	/**
	 * @return the cmExitReason
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.GeographyEnum")
	@Basic(optional=true)
	@Column(name = "cm_exit_reason")
	public CMExitReasonEnum getCmExitReason() {
		return cmExitReason;
	}
	/**
	 * @param cmExitReason the cmExitReason to set
	 */
	public void setCmExitReason(CMExitReasonEnum cmExitReason) {
		this.cmExitReason = cmExitReason;
	}
	
	
	
	/**
	 * @param id
	 * @param exitId
	 * @param cmExitReason
	 */
	public VASHExitReason(UUID id, UUID exitId, CMExitReasonEnum cmExitReason) {
		super();
		this.id = id;
		this.exitId = exitId;
		this.cmExitReason = cmExitReason;
	}
	
	
}
