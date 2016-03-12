package com.servinglynk.hmis.warehouse.model.v2014;

import java.util.Date;
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
@Table(name = "hmis_developer_company")
public class DeveloperCompanyEntity extends BaseModel {

    @javax.persistence.Id
    @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid-gen")
    @org.hibernate.annotations.Type(type="pg-uuid")
	@Column(name = "id")
	private UUID id;

	@Column(name = "external_id")
	private String externalId;

	@Column(name = "name", nullable=false)
	private String name;

	@Column(name = "domain")
	private String domain;

	@Column(name = "logo_url")
	private String logoUrl;
	
	@Column(name = "expected_app_finish_date")
	private Date expectedAppFinishDate;
	
	@Column(name = "company_skill_set")
	private String companySkillSet;
	
	@Column(name = "app_experience")
	private String appExperience;
	
	@Column(name = "company_size")
	private int companySize;
	
	@Column(name = "app_platforms")
	private String appPlatforms;
	
	@Column(name = "contact_email")
	private String contactEmail;
	
	@Column(name = "status")
	private String status;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getExpectedAppFinishDate() {
		return expectedAppFinishDate;
	}
	public void setExpectedAppFinishDate(Date expectedAppFinishDate) {
		this.expectedAppFinishDate = expectedAppFinishDate;
	}
	public String getCompanySkillSet() {
		return companySkillSet;
	}
	public void setCompanySkillSet(String companySkillSet) {
		this.companySkillSet = companySkillSet;
	}
	public String getAppExperience() {
		return appExperience;
	}
	public void setAppExperience(String appExperience) {
		this.appExperience = appExperience;
	}
	public int getCompanySize() {
		return companySize;
	}
	public void setCompanySize(int companySize) {
		this.companySize = companySize;
	}
	public String getAppPlatforms() {
		return appPlatforms;
	}
	public void setAppPlatforms(String appPlatforms) {
		this.appPlatforms = appPlatforms;
	}
	public String getContactEmail() {
		return contactEmail;
	}
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	@ManyToOne
	@JoinColumn(name = "owner_user_id", nullable=false, referencedColumnName="id")
	private HmisUser account;

	@OneToMany(mappedBy = "developerCompany")
	private List<DeveloperServiceEntity> services;


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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getLogoUrl() {
		return logoUrl;
	}
	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}
	public HmisUser getAccount() {
		return account;
	}
	public void setAccount(HmisUser account) {
		this.account = account;
	}
	public List<DeveloperServiceEntity> getServices() {
		return services;
	}
	public void setServices(List<DeveloperServiceEntity> services) {
		this.services = services;
	}

}
