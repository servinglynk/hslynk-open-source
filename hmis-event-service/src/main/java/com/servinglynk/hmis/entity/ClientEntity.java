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
public class ClientEntity {

	private java.util.UUID dedupClientId;
	private java.util.UUID id;
	private String firstName;
	private String lastName;
	private String middleName;
	private String nameSuffix;
	private String otherGender;
	private String ssn;
	private LocalDateTime dob;
	private String sourceSystemId;
	private String schemaYear;
	private String phoneNumber;
	private String emailAddress;
	private boolean deleted;
	private String projectGroupCode;
	

	@Type(type="org.jadira.usertype.dateandtime.threeten.PersistentLocalDateTime")
	@Basic( optional = true )
	@Column
	@ColumnTransformer(
			read="convert_from(dob_decrypt(dob),'UTF-8')",
			write="dob_encrypt(?)")
	public LocalDateTime getDob() {
		return this.dob;

	}

	public void setDob(final LocalDateTime dob) {
		this.dob = dob;
	}

	@Basic( optional = true )
	@Column( name = "dedup_client_id"  ) @org.hibernate.annotations.Type(type="org.hibernate.type.PostgresUUIDType")
	public java.util.UUID getDedupClientId() {
		return this.dedupClientId;

	}

	public void setDedupClientId(final java.util.UUID dedupClientId) {
		this.dedupClientId = dedupClientId;
	}

	@Basic( optional = true )
	@Column( name = "first_name", length = 50  )
	public String getFirstName() {
		return this.firstName;

	}

	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}
	  @Id
	  @Basic( optional = false )
	  @Column( name = "id", nullable = false  ) @org.hibernate.annotations.Type(type="org.hibernate.type.PostgresUUIDType")
	public java.util.UUID getId() {
		return this.id;

	}
	public void setId(final java.util.UUID id) {
		this.id = id;
	}

	@Basic( optional = true )
	@Column( name = "last_name", length = 50  )
	public String getLastName() {
		return this.lastName;
	}


	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	@Basic( optional = true )
	@Column( name = "middle_name", length = 50  )
	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(final String middleName) {
		this.middleName = middleName;
	}

	@Basic( optional = true )
	@Column( name = "name_suffix", length = 50  )
	public String getNameSuffix() {
		return this.nameSuffix;
	}

	public void setNameSuffix(final String nameSuffix) {
		this.nameSuffix = nameSuffix;
	}

	@Basic( optional = true )
	@Column( name = "other_gender" )
	public String getOtherGender() {
		return this.otherGender;

	}

	public void setOtherGender(final String otherGender) {
		this.otherGender = otherGender;
	}

	@Basic( optional = true )
	@Column
	@ColumnTransformer(
			read="convert_from(ssn_decrypt(ssn),'UTF-8')",
			write="ssn_encrypt(?)")
	public String getSsn() {
		return this.ssn;

	}

	public void setSsn(final String ssn) {
		this.ssn = ssn;
	}

	@Column(name="source_system_id")
   public String getSourceSystemId() {
		return sourceSystemId;
	}

	public void setSourceSystemId(String sourceSystemId) {
		this.sourceSystemId = sourceSystemId;
	}
	@Column(name="schema_year")
	public String getSchemaYear() {
		return schemaYear;
	}

	public void setSchemaYear(String schemaYear) {
		this.schemaYear = schemaYear;
	}
	@Column(name="phone_number")
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Column(name="email_address")
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	@Column(name="deleted")
	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	@Column(name="PROJECT_GROUP_CODE")
	public String getProjectGroupCode() {
		return projectGroupCode;
	}

	public void setProjectGroupCode(String projectGroupCode) {
		this.projectGroupCode = projectGroupCode;
	}
	
	
	
	/** Field mapping. */
	protected LocalDateTime dateCreated = LocalDateTime.now();
	/** Field mapping. */
	protected LocalDateTime dateUpdated = LocalDateTime.now();

	 /**
		 * Return the value associated with the column: dateCreated.
		 * @return A LocalDateTime object (this.dateCreated)
		 */
		@Type(type="org.jadira.usertype.dateandtime.threeten.PersistentLocalDateTime")
		@Basic( optional = true )
		@Column( name = "date_created"  )
		public LocalDateTime getDateCreated() {
			return this.dateCreated;
		}
		 /**  
		 * Set the value related to the column: dateCreated.
		 * @param dateCreated the dateCreated value you wish to set
		 */
		public void setDateCreated(final LocalDateTime dateCreated) {
			this.dateCreated = dateCreated;
		}

		 /**
		 * Return the value associated with the column: dateUpdated.
		 * @return A LocalDateTime object (this.dateUpdated)
		 */
		@Type(type="org.jadira.usertype.dateandtime.threeten.PersistentLocalDateTime")
		@Basic( optional = true )
		@Column( name = "date_updated"  )
		public LocalDateTime getDateUpdated() {
			return this.dateUpdated;
		}
		 /**  
		 * Set the value related to the column: dateUpdated.
		 * @param dateUpdated the dateUpdated value you wish to set
		 */
		public void setDateUpdated(final LocalDateTime dateUpdated) {
			this.dateUpdated = dateUpdated;
		}
	
			private UUID parentId;
			
			@Basic( optional = true )
			@Column( name = "parent_id", nullable = true  ) @org.hibernate.annotations.Type(type="org.hibernate.type.PostgresUUIDType")
			public UUID getParentId() {
				return parentId;
			}

			public void setParentId(UUID parentId) {
				this.parentId = parentId;
			}
			
	
}