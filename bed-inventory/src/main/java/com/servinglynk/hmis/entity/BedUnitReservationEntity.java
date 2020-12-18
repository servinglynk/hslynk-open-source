package com.servinglynk.hmis.entity;

import java.util.Date;
import java.util.UUID;

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
@Table(name = "bed_unit_reservation", schema =  "bed_inventory")
public class BedUnitReservationEntity extends BaseEntity {

	@Id
	@Column(name = "id", nullable = false)
	  @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid-gen")
	@org.hibernate.annotations.Type(type = "org.hibernate.type.PostgresUUIDType")
	private UUID id;
	
	@Column(name = "reserved_client_id")
	@org.hibernate.annotations.Type(type = "org.hibernate.type.PostgresUUIDType")
	private UUID reservedCleintId;
	
	@Column(name = "reserved_household_id")
	@org.hibernate.annotations.Type(type = "org.hibernate.type.PostgresUUIDType")
	private UUID reservedHouseholdId;
	
	@Column(name = "reservation_start_date")
	private Date reservationStateDate; 
	
	@Column(name = "reservation_end_date")
	private Date reservationEndDateDate;
	
	@ManyToOne(fetch = FetchType.LAZY )
	@JoinColumn(name = "bed_id", nullable = true )
	private BedUnitEntity bedUnit;
	
	
	@ManyToOne(fetch = FetchType.LAZY )
	@JoinColumn(name = "room_id", nullable = true )
	private RoomEntity room;
	
	@ManyToOne(fetch = FetchType.LAZY )
	@JoinColumn(name = "area_id", nullable = true )
	private AreaEntity area;
	
	@ManyToOne(fetch = FetchType.LAZY )
	@JoinColumn(name = "shelter_id", nullable = true )
	private ShelterEntity shelter;
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public UUID getReservedCleintId() {
		return reservedCleintId;
	}
	public void setReservedCleintId(UUID reservedCleintId) {
		this.reservedCleintId = reservedCleintId;
	}
	public UUID getReservedHouseholdId() {
		return reservedHouseholdId;
	}
	public void setReservedHouseholdId(UUID reservedHouseholdId) {
		this.reservedHouseholdId = reservedHouseholdId;
	}
	public Date getReservationStateDate() {
		return reservationStateDate;
	}
	public void setReservationStateDate(Date reservationStateDate) {
		this.reservationStateDate = reservationStateDate;
	}
	public Date getReservationEndDateDate() {
		return reservationEndDateDate;
	}
	public void setReservationEndDateDate(Date reservationEndDateDate) {
		this.reservationEndDateDate = reservationEndDateDate;
	}
	public BedUnitEntity getBedUnit() {
		return bedUnit;
	}
	public void setBedUnit(BedUnitEntity bedUnit) {
		this.bedUnit = bedUnit;
	}
	public RoomEntity getRoom() {
		return room;
	}
	public void setRoom(RoomEntity room) {
		this.room = room;
	}
	public AreaEntity getArea() {
		return area;
	}
	public void setArea(AreaEntity area) {
		this.area = area;
	}
	public ShelterEntity getShelter() {
		return shelter;
	}
	public void setShelter(ShelterEntity shelter) {
		this.shelter = shelter;
	}
}