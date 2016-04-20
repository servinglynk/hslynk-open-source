package com.servinglynk.hmis.warehouse.model.v2015;

import javax.persistence.Column;
import javax.persistence.Entity;
	

@Entity
public class Exitpath extends BaseModel{

	@Column( name = "connection_with_soar")
	private Integer connectionWithSoar;
	
	@Column(name = "exitid")
	private Exit exitid;
	
	@Column( name = "id")
	private java.util.UUID id;

	public Integer getConnectionWithSoar() {
		return connectionWithSoar;
	}

	public void setConnectionWithSoar(Integer connectionWithSoar) {
		this.connectionWithSoar = connectionWithSoar;
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
