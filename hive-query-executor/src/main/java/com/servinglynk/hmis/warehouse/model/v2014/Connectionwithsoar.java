package com.servinglynk.hmis.warehouse.model.v2014;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.servinglynk.hmis.warehouse.BaseModel;

@Entity
public class Connectionwithsoar extends BaseModel{
	
	@Column(name="connectionwithsoar")
	public String connectionwithsoar;
	@Column(name="exitid")			
	public UUID exitid;
	/**
	 * @return the connectionwithsoar
	 */
	public String getConnectionwithsoar() {
		return connectionwithsoar;
	}
	/**
	 * @param connectionwithsoar the connectionwithsoar to set
	 */
	public void setConnectionwithsoar(String connectionwithsoar) {
		this.connectionwithsoar = connectionwithsoar;
	}
	/**
	 * @return the exitid
	 */
	public UUID getExitid() {
		return exitid;
	}
	/**
	 * @param exitid the exitid to set
	 */
	public void setExitid(UUID exitid) {
		this.exitid = exitid;
	}

}
