package com.servinglynk.hmis.warehouse.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Familyreunification extends BaseModel {

	@Column(name = "exitid")
	public UUID exitid;
	@Column(name = "familyreunificationachieved")
	public String familyreunificationachieved;

	/**
	 * @return the exitid
	 */
	public UUID getExitid() {
		return exitid;
	}

	/**
	 * @param exitid
	 *            the exitid to set
	 */
	public void setExitid(UUID exitid) {
		this.exitid = exitid;
	}

	/**
	 * @return the familyreunificationachieved
	 */
	public String getFamilyreunificationachieved() {
		return familyreunificationachieved;
	}

	/**
	 * @param familyreunificationachieved
	 *            the familyreunificationachieved to set
	 */
	public void setFamilyreunificationachieved(
			String familyreunificationachieved) {
		this.familyreunificationachieved = familyreunificationachieved;
	}

}
