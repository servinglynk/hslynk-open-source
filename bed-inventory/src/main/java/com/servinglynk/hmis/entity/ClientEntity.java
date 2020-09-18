package com.servinglynk.hmis.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.annotations.Type;


@Entity
@Table(name = "client", catalog = "hmis", schema = "base")
public class ClientEntity extends BaseEntity {

	@Basic(optional = true)
	@Column(name = "dedup_client_id")
	@org.hibernate.annotations.Type(type = "org.hibernate.type.PostgresUUIDType")
	private java.util.UUID dedupClientId;
	@Id
	@Basic(optional = false)
	@Column(name = "id", nullable = false)
	@org.hibernate.annotations.Type(type = "org.hibernate.type.PostgresUUIDType")
	private java.util.UUID id;
	@Basic(optional = true)
	@Column(name = "first_name", length = 50)
	private String firstName;
	@Basic(optional = true)
	@Column(name = "last_name", length = 50)
	private String lastName;
	@Basic(optional = true)
	@Column(name = "middle_name", length = 50)
	private String middleName;
	@Basic(optional = true)
	@Column(name = "name_suffix", length = 50)
	private String nameSuffix;
	@Basic(optional = true)
	@Column(name = "other_gender")
	private String otherGender;

	@Basic(optional = true)
	@Column
	@ColumnTransformer(read = "convert_from(ssn_decrypt(ssn),'UTF-8')", write = "ssn_encrypt(?)")
	private String ssn;
	@Type(type = "org.jadira.usertype.dateandtime.threeten.PersistentLocalDateTime")
	@Basic(optional = true)
	@Column
	@ColumnTransformer(read = "convert_from(dob_decrypt(dob),'UTF-8')", write = "dob_encrypt(?)")
	private LocalDateTime dob;
	@Column(name = "source_system_id")
	private String sourceSystemId;
	@Column(name = "schema_year")
	private String schemaYear;
	@Column(name = "phone_number")
	private String phoneNumber;
	@Column(name = "email_address")
	private String emailAddress;

	@Basic(optional = true)
	@Column(name = "parent_id", nullable = true)
	@org.hibernate.annotations.Type(type = "org.hibernate.type.PostgresUUIDType")
	private UUID parentId;

	public LocalDateTime getDob() {
		return this.dob;

	}

	public void setDob(final LocalDateTime dob) {
		this.dob = dob;
	}

	public java.util.UUID getDedupClientId() {
		return this.dedupClientId;

	}

	public void setDedupClientId(final java.util.UUID dedupClientId) {
		this.dedupClientId = dedupClientId;
	}

	public String getFirstName() {
		return this.firstName;

	}

	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	public java.util.UUID getId() {
		return this.id;

	}

	public void setId(final java.util.UUID id) {
		this.id = id;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(final String middleName) {
		this.middleName = middleName;
	}

	public String getNameSuffix() {
		return this.nameSuffix;
	}

	public void setNameSuffix(final String nameSuffix) {
		this.nameSuffix = nameSuffix;
	}

	public String getOtherGender() {
		return this.otherGender;

	}

	public void setOtherGender(final String otherGender) {
		this.otherGender = otherGender;
	}

	public String getSsn() {
		return this.ssn;

	}

	public void setSsn(final String ssn) {
		this.ssn = ssn;
	}

	public String getSourceSystemId() {
		return sourceSystemId;
	}

	public void setSourceSystemId(String sourceSystemId) {
		this.sourceSystemId = sourceSystemId;
	}

	public String getSchemaYear() {
		return schemaYear;
	}

	public void setSchemaYear(String schemaYear) {
		this.schemaYear = schemaYear;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public UUID getParentId() {
		return parentId;
	}

	public void setParentId(UUID parentId) {
		this.parentId = parentId;
	}

}