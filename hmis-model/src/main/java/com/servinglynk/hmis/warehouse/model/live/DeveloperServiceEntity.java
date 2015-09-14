package com.servinglynk.hmis.warehouse.model.live;

import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@SuppressWarnings("serial")
@Entity
@Table(name = "hmis_service")
public class DeveloperServiceEntity extends BaseModel {

    @javax.persistence.Id
    @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid-gen")
    @org.hibernate.annotations.Type(type="pg-uuid")
	@Column(name = "id")
	private UUID id;

	@Column(name = "external_id")
	private String externalId;

	@Column(name = "friendly_name")
	private String friendlyName;

	@Column(name = "description")
	private String description;

	@Column(name = "status")
	private String status;
	
	@Column(name = "license_type", nullable=false)
	private String licenseType;

	@ManyToOne
	@JoinColumn(name = "developer_company_id", nullable=false, referencedColumnName="id")
	private DeveloperCompanyEntity developerCompany;

	@Column(name = "external_product_id")
	private String externalProductId;

	@OneToMany(mappedBy = "service")
	private List<TrustedAppEntity> trustedApps;

	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getExternalId() {
		return externalId;
	}
	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}
	public String getFriendlyName() {
		return friendlyName;
	}
	public void setFriendlyName(String friendlyName) {
		this.friendlyName = friendlyName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLicenseType() {
		return licenseType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setLicenseType(String licenseType) {
		this.licenseType = licenseType;
	}
	public DeveloperCompanyEntity getDeveloperCompany() {
		return developerCompany;
	}
	public void setDeveloperCompany(DeveloperCompanyEntity developerCompany) {
		this.developerCompany = developerCompany;
	}
	public String getExternalProductId() {
		return externalProductId;
	}
	public void setExternalProductId(String externalProductId) {
		this.externalProductId = externalProductId;
	}
	public List<TrustedAppEntity> getTrustedApps() {
		return trustedApps;
	}
	public void setTrustedApps(List<TrustedAppEntity> trustedApps) {
		this.trustedApps = trustedApps;
	}


}
