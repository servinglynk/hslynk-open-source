package com.servinglynk.hmis.warehouse.model.v2016;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.servinglynk.hmis.warehouse.BaseModel;
	

@Entity
public class Exitpath extends BaseModel{

	@Column( name = "connection_with_soar")
	private Integer connection_with_soar;
	
	@Column(name = "exitid")
	private Exit exitid;
	
	@Column( name = "id")
	private java.util.UUID id;

	

	public Integer getConnection_with_soar() {
		return connection_with_soar;
	}

	public void setConnection_with_soar(Integer connection_with_soar) {
		this.connection_with_soar = connection_with_soar;
	}

	public Exit getExitid() {
		return exitid;
	}

	public void setExitid(Exit exitid) {
		this.exitid = exitid;
	}

	public java.util.UUID getId() {
		return id;
	}

	public void setId(java.util.UUID id) {
		this.id = id;
	}
	
	
	
}
