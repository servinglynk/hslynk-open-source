package com.servinglynk.hmis.warehouse.model.v2014;
import javax.persistence.Column;
import javax.persistence.Entity;

public class Bedinventory extends BaseModel{
	@Column(name="bed_inventory")		
	public String bed_inventory;
	@Column(name="ch_bed_inventory")
	public String ch_bed_inventory;
	@Column(name="vet_bed_inventory")
	public String vet_bed_inventory;
	@Column(name="youth_age_group")
	public String youth_age_group;
	@Column(name="youth_bed_inventory")
	public String youth_bed_inventory;
	/**
	 * @return the bed_inventory
	 */
	public String getBed_inventory() {
		return bed_inventory;
	}
	/**
	 * @param bed_inventory the bed_inventory to set
	 */
	public void setBed_inventory(String bed_inventory) {
		this.bed_inventory = bed_inventory;
	}
	/**
	 * @return the ch_bed_inventory
	 */
	public String getCh_bed_inventory() {
		return ch_bed_inventory;
	}
	/**
	 * @param ch_bed_inventory the ch_bed_inventory to set
	 */
	public void setCh_bed_inventory(String ch_bed_inventory) {
		this.ch_bed_inventory = ch_bed_inventory;
	}
	/**
	 * @return the vet_bed_inventory
	 */
	public String getVet_bed_inventory() {
		return vet_bed_inventory;
	}
	/**
	 * @param vet_bed_inventory the vet_bed_inventory to set
	 */
	public void setVet_bed_inventory(String vet_bed_inventory) {
		this.vet_bed_inventory = vet_bed_inventory;
	}
	/**
	 * @return the youth_age_group
	 */
	public String getYouth_age_group() {
		return youth_age_group;
	}
	/**
	 * @param youth_age_group the youth_age_group to set
	 */
	public void setYouth_age_group(String youth_age_group) {
		this.youth_age_group = youth_age_group;
	}
	/**
	 * @return the youth_bed_inventory
	 */
	public String getYouth_bed_inventory() {
		return youth_bed_inventory;
	}
	/**
	 * @param youth_bed_inventory the youth_bed_inventory to set
	 */
	public void setYouth_bed_inventory(String youth_bed_inventory) {
		this.youth_bed_inventory = youth_bed_inventory;
	}
	
	
}
