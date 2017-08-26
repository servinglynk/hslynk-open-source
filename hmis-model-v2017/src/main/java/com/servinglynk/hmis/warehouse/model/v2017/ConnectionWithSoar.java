package com.servinglynk.hmis.warehouse.model.v2017;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity (name = "ConnectionWithSoar_v2017")
@Table(name = "ConnectionWithSoar", catalog = "hmis", schema = "v2017")
public class ConnectionWithSoar extends HmisBaseModel  implements Cloneable, Serializable {

	private java.util.UUID id;
	private LocalDateTime informationDate;
	private Integer connectionWithSoar;
	/**
	 * @return the id
	 */
	@Id
	@Basic( optional = false )
	@Column( name = "id", nullable = false  ) @org.hibernate.annotations.Type(type="org.hibernate.type.PostgresUUIDType")
	public java.util.UUID getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(java.util.UUID id) {
		this.id = id;
	}
	/**
	 * @return the informationDate
	 */
	@Basic( optional = true )
	@Column(name = "information_date")
	public LocalDateTime getInformationDate() {
		return informationDate;
	}
	/**
	 * @param informationDate the informationDate to set
	 */
	public void setInformationDate(LocalDateTime informationDate) {
		this.informationDate = informationDate;
	}
	/**
	 * @return the connectionWithSoar
	 */
	@Basic( optional = true )
	@Column(name = "connection_with_soar")
	public Integer getConnectionWithSoar() {
		return connectionWithSoar;
	}
	/**
	 * @param connectionWithSoar the connectionWithSoar to set
	 */
	public void setConnectionWithSoar(Integer connectionWithSoar) {
		this.connectionWithSoar = connectionWithSoar;
	}
	/**
	 * @param id
	 * @param informationDate
	 * @param connectionWithSoar
	 */
	public ConnectionWithSoar(UUID id, LocalDateTime informationDate,
			Integer connectionWithSoar) {
		super();
		this.id = id;
		this.informationDate = informationDate;
		this.connectionWithSoar = connectionWithSoar;
	}
	
	
}
