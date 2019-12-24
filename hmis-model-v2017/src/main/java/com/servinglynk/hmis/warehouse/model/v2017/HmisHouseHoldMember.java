package com.servinglynk.hmis.warehouse.model.v2017;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.servinglynk.hmis.warehouse.model.base.HMISModel;

@Entity
@Table(name = "hmis_household_member", schema = "v2017")
public class HmisHouseHoldMember extends HMISModel implements Serializable {

	private UUID id;
	private UUID memberId;
	private String relationWithHouseHold;
	private HmisHousehold hmisHousehold;
	private UUID memberDedupId;

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

	@Column(name = "member_id")
	@org.hibernate.annotations.Type(type = "org.hibernate.type.PostgresUUIDType")
	public UUID getMemberId() {
		return memberId;
	}

	public void setMemberId(UUID memberId) {
		this.memberId = memberId;
	}

	@Column(name = "relation_with_house_hold")
	public String getRelationWithHouseHold() {
		return relationWithHouseHold;
	}

	public void setRelationWithHouseHold(String relationWithHouseHold) {
		this.relationWithHouseHold = relationWithHouseHold;
	}

	@ManyToOne
	@JoinColumn(name = "hmis_household_id", referencedColumnName = "id")
	public HmisHousehold getHmisHousehold() {
		return hmisHousehold;
	}

	public void setHmisHousehold(HmisHousehold hmisHousehold) {
		this.hmisHousehold = hmisHousehold;
	}
	

	@Column(name = "member_dedup_id")
	@org.hibernate.annotations.Type(type = "org.hibernate.type.PostgresUUIDType")
	public UUID getMemberDedupId() {
		return memberDedupId;
	}

	public void setMemberDedupId(UUID memberDedupId) {
		this.memberDedupId = memberDedupId;
	}
}