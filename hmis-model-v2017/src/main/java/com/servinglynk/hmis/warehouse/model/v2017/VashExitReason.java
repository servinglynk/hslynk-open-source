package com.servinglynk.hmis.warehouse.model.v2017;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.servinglynk.hmis.warehouse.enums.CMExitReasonEnum;
@Entity(name = "vashexitreason_v2017")
@Table(name = "vashexitreason", catalog = "hmis", schema = "v2017")
public class VashExitReason  extends HmisBaseModel implements Cloneable, Serializable {
	
	private java.util.UUID id;
	private Exit exitid;
	private CMExitReasonEnum cmExitReason;
	
	public VashExitReason() {
		// Default constructor
	}

	/** Constructor taking a given ID.
	 * @param id to set
	 */
	public VashExitReason(java.util.UUID id) {
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
	 * Return the value associated with the column: exitid.
	 * @return A Exit object (this.exitid)
	 */
	@ManyToOne( cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY )
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = true )
	@JoinColumn(name = "exitid", nullable = true )
	public Exit getExitid() {
		return this.exitid;

	}



	 /**
	 * Set the value related to the column: exitid.
	 * @param exitid the exitid value you wish to set
	 */
	public void setExitid(final Exit exitid) {
		this.exitid = exitid;
	}

	
	/**
	 * @return the cmExitReason
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.CMExitReasonEnumType")
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
	public VashExitReason(UUID id, Exit exitid, CMExitReasonEnum cmExitReason) {
		super();
		this.id = id;
		this.exitid = exitid;
		this.cmExitReason = cmExitReason;
	}
	
	
}
