package com.servinglynk.hmis.entity;

import java.util.UUID;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name = "bed_unit", schema =  "bed_inventory")
public class BedUnitEntity extends BaseEntity {

	@Id
	@Basic(optional = false)
	  @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid-gen")
	@Column(name = "id", nullable = false)
	@org.hibernate.annotations.Type(type = "org.hibernate.type.PostgresUUIDType")
	private UUID id;

	@Column(name = "occupancy")
	private Boolean occupancy;
	
	@Column(name = "occupancy_capacity")
	private Integer occupantCapacity;
	
	@Column(name = "overflow")
	private Boolean overflow;
	
	@Column(name = "is_Active")
	private Boolean isActive;
	
	@ManyToOne(fetch = FetchType.LAZY )
	@JoinColumn(name = "room_id", nullable = true )
	private RoomEntity room;
	
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public Boolean getOccupancy() {
		return occupancy;
	}
	public void setOccupancy(Boolean occupancy) {
		this.occupancy = occupancy;
	}
	public Integer getOccupantCapacity() {
		return occupantCapacity;
	}
	public void setOccupantCapacity(Integer occupantCapacity) {
		this.occupantCapacity = occupantCapacity;
	}
	public Boolean getOverflow() {
		return overflow;
	}
	public void setOverflow(Boolean overflow) {
		this.overflow = overflow;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public RoomEntity getRoom() {
		return room;
	}
	public void setRoom(RoomEntity room) {
		this.room = room;
	}
}