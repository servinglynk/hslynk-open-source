package com.servinglynk.hmis.warehouse.model.base;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@SuppressWarnings("serial")
@Entity
@Table(name="CLIENT_DATA_ELEMENTS",schema="base",catalog="hmis")
public class ClientDataElementsEntity extends BaseModel {
	
	@Id
    @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid-gen")
    @org.hibernate.annotations.Type(type="pg-uuid")
	@Column(name = "ID")
	private UUID id;
	
	@Id
    @org.hibernate.annotations.Type(type="pg-uuid")
	@Column(name = "client_id")
	private UUID clientId;
	
	@Column(name="DATA_ELEMENT_NAME")
	private String dataElementName;
	
	@Column(name="DATA_ELEMENT_VALUE")
	private boolean dataElementValue;
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public UUID getClientId() {
		return clientId;
	}
	public void setClientId(UUID clientId) {
		this.clientId = clientId;
	}
	public String getDataElementName() {
		return dataElementName;
	}
	public void setDataElementName(String dataElementName) {
		this.dataElementName = dataElementName;
	}
	public boolean getDataElementValue() {
		return dataElementValue;
	}
	public void setDataElementValue(boolean dataElementValue) {
		this.dataElementValue = dataElementValue;
	}
}