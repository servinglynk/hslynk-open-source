package com.servinglynk.hmis.warehouse.model.v2014;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.servinglynk.hmis.warehouse.model.base.HMISModel;

/**
 * A GlobalHousehold.
 */
@Entity
@Table(name = "hmis_household", schema = "v2014")
public class HmisHousehold extends HMISModel implements Serializable {

	private static final long serialVersionUID = 1573515448747014869L;

	private UUID id;
	private UUID headOfHouseholdId;
	private UUID dedupClientId;
	private List<HmisHouseHoldMember> members = new ArrayList<HmisHouseHoldMember>();
	/*
	 * protected LocalDateTime dateCreated = LocalDateTime.now(); protected
	 * LocalDateTime dateUpdated = LocalDateTime.now(); protected String
	 * projectGroupCode; private UUID userId; private Boolean deleted;
	 */

	@Id
	@org.hibernate.annotations.Type(type = "org.hibernate.type.PostgresUUIDType")
	@GenericGenerator(name = "uuid-gen", strategy = "uuid2")
	@GeneratedValue(generator = "uuid-gen")
	@Column(name = "id")
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	@Column(name = "head_of_household_id")
	@org.hibernate.annotations.Type(type = "org.hibernate.type.PostgresUUIDType")
	public UUID getHeadOfHouseholdId() {
		return headOfHouseholdId;
	}

	public void setHeadOfHouseholdId(UUID headOfHouseholdId) {
		this.headOfHouseholdId = headOfHouseholdId;
	}

	@Column(name = "dedup_client_id")
	@org.hibernate.annotations.Type(type = "org.hibernate.type.PostgresUUIDType")
	public UUID getDedupClientId() {
		return dedupClientId;
	}

	public void setDedupClientId(UUID dedupClientId) {
		this.dedupClientId = dedupClientId;
	}

	@OneToMany(mappedBy = "hmisHousehold")
	public List<HmisHouseHoldMember> getMembers() {
		return members;
	}

	public void setMembers(List<HmisHouseHoldMember> members) {
		this.members = members;
	}

	/*
	 * @Type(type=
	 * "org.jadira.usertype.dateandtime.threeten.PersistentLocalDateTime")
	 * 
	 * @Basic( optional = true )
	 * 
	 * @Column( name = "date_created" ) public LocalDateTime getDateCreated() {
	 * return this.dateCreated; }
	 *//**
		 * Set the value related to the column: dateCreated.
		 * 
		 * @param dateCreated the dateCreated value you wish to set
		 */
	/*
	 * public void setDateCreated(final LocalDateTime dateCreated) {
	 * this.dateCreated = dateCreated; }
	 * 
	 *//**
		 * Return the value associated with the column: dateUpdated.
		 * 
		 * @return A LocalDateTime object (this.dateUpdated)
		 */
	/*
	 * @Type(type=
	 * "org.jadira.usertype.dateandtime.threeten.PersistentLocalDateTime")
	 * 
	 * @Basic( optional = true )
	 * 
	 * @Column( name = "date_updated" ) public LocalDateTime getDateUpdated() {
	 * return this.dateUpdated; }
	 *//**
		 * Set the value related to the column: dateUpdated.
		 * 
		 * @param dateUpdated the dateUpdated value you wish to set
		 *//*
			 * public void setDateUpdated(final LocalDateTime dateUpdated) {
			 * this.dateUpdated = dateUpdated; }
			 * 
			 * @Basic( optional = true )
			 * 
			 * @Column( name = "user_id", nullable = true
			 * ) @org.hibernate.annotations.Type(type="org.hibernate.type.PostgresUUIDType")
			 * public UUID getUserId() { return userId; }
			 * 
			 * public void setUserId(UUID user) { this.userId = user; }
			 * 
			 * @Column(name="deleted") public boolean getDeleted() { return deleted; }
			 * 
			 * public void setDeleted(boolean deleted) { this.deleted = deleted; }
			 * 
			 * @Column(name="project_group_code") public String getProjectGroupCode() {
			 * return projectGroupCode; } public void setProjectGroupCode(String
			 * projectGroupCode) { this.projectGroupCode = projectGroupCode; }
			 */
}