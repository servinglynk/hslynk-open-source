package com.servinglynk.hmis.warehouse.model.v2017;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.solr.analysis.LowerCaseTokenizerFactory;
import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.annotations.Type;
import org.hibernate.proxy.HibernateProxy;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Analyzer;
import org.hibernate.search.annotations.AnalyzerDef;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;
import org.hibernate.search.annotations.TokenizerDef;

import com.servinglynk.hmis.warehouse.enums.ClientDobDataQualityEnum;
import com.servinglynk.hmis.warehouse.enums.ClientEthnicityEnum;
import com.servinglynk.hmis.warehouse.enums.ClientGenderEnum;
import com.servinglynk.hmis.warehouse.enums.ClientNameDataQualityEnum;
import com.servinglynk.hmis.warehouse.enums.ClientRaceEnum;
import com.servinglynk.hmis.warehouse.enums.ClientSsnDataQualityEnum;
import com.servinglynk.hmis.warehouse.enums.ClientVeteranStatusEnum;


/**
 * Object mapping for hibernate-handled table: client.
 *
 *
 * @author Sandeep Dolia
 */
@Entity (name = "client")
@Table(name = "client", catalog = "hmis", schema = "v2017")
/*@Indexed
@AnalyzerDef(name="clientAnalyzer", tokenizer=@TokenizerDef(factory=LowerCaseTokenizerFactory.class))*/
public class Client extends HmisBaseModel implements Cloneable, Serializable {

	/** Serial Version UID. */
	private static final long serialVersionUID = 6304318647555713317L;

	/** Use a WeakHashMap so entries will be garbage collected once all entities
		referring to a saved hash are garbage collected themselves. */
	private static final Map<Serializable, java.util.UUID> SAVED_HASHES =
		Collections.synchronizedMap(new WeakHashMap<Serializable, java.util.UUID>());

	/** hashCode temporary storage. */
	private volatile java.util.UUID hashCode;
	/** Field mapping. */
	private java.util.UUID dedupClientId;
	/** Field mapping. */
	private LocalDateTime dob;
	/** Field mapping. */
	private ClientDobDataQualityEnum dobDataQuality;
	/** Field mapping. */
	private ClientEthnicityEnum ethnicity;
	/** Field mapping. */
	private String firstName;
	/** Field mapping. */
	private ClientGenderEnum gender;
	/** Field mapping. */
	private java.util.UUID id;
	/** Field mapping. */
	private String lastName;
	/** Field mapping. */
	private String middleName;
	/** Field mapping. */
	private ClientNameDataQualityEnum nameDataQuality;
	/** Field mapping. */
	private String nameSuffix;
	/** Field mapping. */
	private ClientRaceEnum race;
	/** Field mapping. */
	private String ssn;
	/** Field mapping. */
	private ClientSsnDataQualityEnum ssnDataQuality;

	/** Field mapping. */
	private Set<ClientVeteranInfo> veteranInfoes = new HashSet<ClientVeteranInfo>();
	/** Field mapping. */
	private Set<Enrollment> enrollments = new HashSet<Enrollment>();

	/** Field mapping. */
	private ClientVeteranStatusEnum veteranStatus;
	/**
	 * Default constructor, mainly for hibernate use.
	 */
	public Client() {
		// Default constructor
	}

	/** Constructor taking a given ID.
	 * @param id to set
	 */
	public Client(java.util.UUID id) {
		this.id = id;
	}


	 /**
		 * Return the value associated with the column: dedupClientId.
		 * @return A java.util.UUID object (this.dedupClientId)
		 */
		@Basic( optional = true )
		@Column( name = "dedup_client_id"  ) @org.hibernate.annotations.Type(type="org.hibernate.type.PostgresUUIDType")
		public java.util.UUID getDedupClientId() {
			return this.dedupClientId;

		}



		 /**
		 * Set the value related to the column: dedupClientId.
		 * @param dedupClientId the dedupClientId value you wish to set
		 */
		public void setDedupClientId(final java.util.UUID dedupClientId) {
			this.dedupClientId = dedupClientId;
		}

		/** Field mapping. */
		protected Export export;
		 /**
		 * Return the value associated with the column: export.
		 * @return A Export object (this.export)
		 */
		@ManyToOne( cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY )
		@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
		@Basic( optional = true )
		@JoinColumn(name = "export_id", nullable = true )
		public Export getExport() {
			return this.export;

		}



		 /**
		 * Set the value related to the column: export.
		 * @param export the export value you wish to set
		 */
		public void setExport(final Export export) {
			this.export = export;
		}
	/** Return the type of this class. Useful for when dealing with proxies.
	* @return Defining class.
	*/
	@Transient
	public Class<?> getClassType() {
		return Client.class;
	}


	 /**
	 * Return the value associated with the column: dob.
	 * @return A LocalDateTime object (this.dob)
	 */
	@Type(type="org.jadira.usertype.dateandtime.threeten.PersistentLocalDateTime")
	@Basic( optional = true )
	@Column
	@ColumnTransformer(
			read="convert_from(dob_decrypt(dob),'UTF-8')",
			write="dob_encrypt(?)")
	public LocalDateTime getDob() {
		return this.dob;

	}



	 /**
	 * Set the value related to the column: dob.
	 * @param dob the dob value you wish to set
	 */
	public void setDob(final LocalDateTime dob) {
		this.dob = dob;
	}

	 /**
	 * Return the value associated with the column: dobDataQuality.
	 * @return A ClientDobDataQualityEnum object (this.dobDataQuality)
	 */
	@Type(type="com.servinglynk.hmis.warehouse.enums.ClientDobDataQualityEnumType")
	@Basic( optional = true )
	@Column( name = "dob_data_quality"  )
	public ClientDobDataQualityEnum getDobDataQuality() {
		return this.dobDataQuality;

	}



	 /**
	 * Set the value related to the column: dobDataQuality.
	 * @param dobDataQuality the dobDataQuality value you wish to set
	 */
	public void setDobDataQuality(final ClientDobDataQualityEnum dobDataQuality) {
		this.dobDataQuality = dobDataQuality;
	}

	 /**
	 * Return the value associated with the column: ethnicity.
	 * @return A ClientEthnicityEnum object (this.ethnicity)
	 */
	@Column
	@Basic( optional = true )
	@Type(type="com.servinglynk.hmis.warehouse.enums.ClientEthnicityEnumType")
	public ClientEthnicityEnum getEthnicity() {
		return this.ethnicity;

	}



	 /**
	 * Set the value related to the column: ethnicity.
	 * @param ethnicity the ethnicity value you wish to set
	 */
	public void setEthnicity(final ClientEthnicityEnum ethnicity) {
		this.ethnicity = ethnicity;
	}

	 /**
	 * Return the value associated with the column: firstName.
	 * @return A String object (this.firstName)
	 */
	@Basic( optional = true )
	@Column( name = "first_name", length = 50  )
	public String getFirstName() {
		return this.firstName;

	}



	 /**
	 * Set the value related to the column: firstName.
	 * @param firstName the firstName value you wish to set
	 */
	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	 /**
	 * Return the value associated with the column: gender.
	 * @return A ClientGenderEnum object (this.gender)
	 */
	@Basic( optional = true )
	@Column
	@Type(type="com.servinglynk.hmis.warehouse.enums.ClientGenderEnumType")
	public ClientGenderEnum getGender() {
		return this.gender;

	}



	 /**
	 * Set the value related to the column: gender.
	 * @param gender the gender value you wish to set
	 */
	public void setGender(final ClientGenderEnum gender) {
		this.gender = gender;
	}

	 /**
	 * Return the value associated with the column: id.
	 * @return A java.util.UUID object (this.id)
	 */

    @Id
	@Basic( optional = false )
	@Column( name = "id", nullable = false  ) @org.hibernate.annotations.Type(type="org.hibernate.type.PostgresUUIDType")
	public java.util.UUID getId() {
		return this.id;

	}



	 /**
	 * Set the value related to the column: id.
	 * @param id the id value you wish to set
	 */
	public void setId(final java.util.UUID id) {
		// If we've just been persisted and hashCode has been
		// returned then make sure other entities with this
		// ID return the already returned hash code
		if ( (this.id == null ) &&
				(id != null) &&
				(this.hashCode != null) ) {
		SAVED_HASHES.put( id, this.hashCode );
		}
		this.id = id;
	}

	 /**
	 * Return the value associated with the column: lastName.
	 * @return A String object (this.lastName)
	 */
	@Basic( optional = true )
	@Column( name = "last_name", length = 50  )
	public String getLastName() {
		return this.lastName;

	}



	 /**
	 * Set the value related to the column: lastName.
	 * @param lastName the lastName value you wish to set
	 */
	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	 /**
	 * Return the value associated with the column: middleName.
	 * @return A String object (this.middleName)
	 */
	@Basic( optional = true )
	@Column( name = "middle_name", length = 50  )
	public String getMiddleName() {
		return this.middleName;

	}



	 /**
	 * Set the value related to the column: middleName.
	 * @param middleName the middleName value you wish to set
	 */
	public void setMiddleName(final String middleName) {
		this.middleName = middleName;
	}

	 /**
	 * Return the value associated with the column: nameDataQuality.
	 * @return A ClientNameDataQualityEnum object (this.nameDataQuality)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.ClientNameDataQualityEnumType")
	@Basic( optional = true )
	@Column( name = "name_data_quality"  )
	public ClientNameDataQualityEnum getNameDataQuality() {
		return this.nameDataQuality;

	}



	 /**
	 * Set the value related to the column: nameDataQuality.
	 * @param nameDataQuality the nameDataQuality value you wish to set
	 */
	public void setNameDataQuality(final ClientNameDataQualityEnum nameDataQuality) {
		this.nameDataQuality = nameDataQuality;
	}

	 /**
	 * Return the value associated with the column: nameSuffix.
	 * @return A String object (this.nameSuffix)
	 */
	@Basic( optional = true )
	@Column( name = "name_suffix", length = 50  )
	public String getNameSuffix() {
		return this.nameSuffix;

	}



	 /**
	 * Set the value related to the column: nameSuffix.
	 * @param nameSuffix the nameSuffix value you wish to set
	 */
	public void setNameSuffix(final String nameSuffix) {
		this.nameSuffix = nameSuffix;
	}

	/**
	 * Return the value associated with the column: race.
	 * @return A ClientRaceEnum object (this.race)
	 */
	@Basic( optional = true )
	@Column
	@Type(type = "com.servinglynk.hmis.warehouse.enums.ClientRaceEnumType")
	public ClientRaceEnum getRace() {
		return this.race;
	}



	 /**
	 * Set the value related to the column: race.
	 * @param race the race value you wish to set
	 */
	public void setRace(final ClientRaceEnum race) {
		this.race = race;
	}

	 /**
	 * Return the value associated with the column: ssn.
	 * @return A String object (this.ssn)
	 */
	@Basic( optional = true )
	@Column
	@ColumnTransformer(
			read="convert_from(ssn_decrypt(ssn),'UTF-8')",
			write="ssn_encrypt(?)")
	public String getSsn() {
		return this.ssn;

	}



	 /**
	 * Set the value related to the column: ssn.
	 * @param ssn the ssn value you wish to set
	 */
	public void setSsn(final String ssn) {
		this.ssn = ssn;
	}

	 /**
	 * Return the value associated with the column: ssnDataQuality.
	 * @return A ClientSsnDataQualityEnum object (this.ssnDataQuality)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.ClientSsnDataQualityEnumType")
	@Basic( optional = true )
	@Column( name = "ssn_data_quality"  )
	public ClientSsnDataQualityEnum getSsnDataQuality() {
		return this.ssnDataQuality;

	}



	 /**
	 * Set the value related to the column: ssnDataQuality.
	 * @param ssnDataQuality the ssnDataQuality value you wish to set
	 */
	public void setSsnDataQuality(final ClientSsnDataQualityEnum ssnDataQuality) {
		this.ssnDataQuality = ssnDataQuality;
	}

	 /**
	 * Return the value associated with the column: veteranInfo.
	 * @return A Set&lt;VeteranInfo&gt; object (this.veteranInfo)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "client"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<ClientVeteranInfo> getVeteranInfoes() {
		return this.veteranInfoes;

	}

	/**
	 * Adds a bi-directional link of type VeteranInfo to the veteranInfoes set.
	 * @param veteranInfo item to add
	 */
	public void addVeteranInfo(ClientVeteranInfo veteranInfo) {
		veteranInfo.setClient(this);
		this.veteranInfoes.add(veteranInfo);
	}


	 /**
	 * Set the value related to the column: veteranInfo.
	 * @param veteranInfo the veteranInfo value you wish to set
	 */
	public void setVeteranInfoes(final Set<ClientVeteranInfo> veteranInfo) {
		this.veteranInfoes = veteranInfo;
	}

	 /**
	 * Return the value associated with the column: veteranStatus.
	 * @return A ClientVeteranStatusEnum object (this.veteranStatus)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.ClientVeteranStatusEnumType")
	@Basic( optional = true )
	@Column( name = "veteran_status"  )
	public ClientVeteranStatusEnum getVeteranStatus() {
		return this.veteranStatus;

	}



	 /**
	 * Set the value related to the column: veteranStatus.
	 * @param veteranStatus the veteranStatus value you wish to set
	 */
	public void setVeteranStatus(final ClientVeteranStatusEnum veteranStatus) {
		this.veteranStatus = veteranStatus;
	}

	 /**
		 * Return the value associated with the column: enrollment.
		 * @return A Set&lt;Enrollment&gt; object (this.enrollment)
		 */
	 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "client"  )
	 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
		@Basic( optional = false )
		@Column( nullable = false  )
		public Set<Enrollment> getEnrollments() {
			return this.enrollments;

		}

		/**
		 * Adds a bi-directional link of type Enrollment to the enrollments set.
		 * @param enrollment item to add
		 */
		public void addEnrollment(Enrollment enrollment) {
			enrollment.setClient(this);
			this.enrollments.add(enrollment);
		}


		 /**
		 * Set the value related to the column: enrollment.
		 * @param enrollment the enrollment value you wish to set
		 */
		public void setEnrollments(final Set<Enrollment> enrollment) {
			this.enrollments = enrollment;
		}


/**
    * Deep copy.
	* @return cloned object
	* @throws CloneNotSupportedException on error
    */
    @Override
    public Client clone() throws CloneNotSupportedException {

        final Client copy = (Client)super.clone();

		copy.setDateCreated(this.getDateCreated());
		copy.setDateUpdated(this.getDateUpdated());
		copy.setDob(this.getDob());
		copy.setDobDataQuality(this.getDobDataQuality());
		copy.setEthnicity(this.getEthnicity());
		copy.setFirstName(this.getFirstName());
		copy.setGender(this.getGender());
		copy.setId(this.getId());
		copy.setLastName(this.getLastName());
		copy.setMiddleName(this.getMiddleName());
		copy.setNameDataQuality(this.getNameDataQuality());
		copy.setNameSuffix(this.getNameSuffix());
		copy.setRace(this.getRace());
		copy.setSsn(this.getSsn());
		copy.setSsnDataQuality(this.getSsnDataQuality());
		copy.setUserId(this.getUserId());
		if (this.getVeteranInfoes() != null) {
			copy.getVeteranInfoes().addAll(this.getVeteranInfoes());
		}
		if (this.getEnrollments() != null) {
			copy.getEnrollments().addAll(this.getEnrollments());
		}
		copy.setVeteranStatus(this.getVeteranStatus());
		return copy;
	}



	/** Provides toString implementation.
	 * @see java.lang.Object#toString()
	 * @return String representation of this class.
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();

		sb.append("dateCreated: " + this.getDateCreated() + ", ");
		sb.append("dateUpdated: " + this.getDateUpdated() + ", ");
		sb.append("dob: " + this.getDob() + ", ");
		sb.append("dobDataQuality: " + this.getDobDataQuality() + ", ");
		sb.append("ethnicity: " + this.getEthnicity() + ", ");
		sb.append("firstName: " + this.getFirstName() + ", ");
		sb.append("gender: " + this.getGender() + ", ");
		sb.append("id: " + this.getId() + ", ");
		sb.append("lastName: " + this.getLastName() + ", ");
		sb.append("middleName: " + this.getMiddleName() + ", ");
		sb.append("nameDataQuality: " + this.getNameDataQuality() + ", ");
		sb.append("nameSuffix: " + this.getNameSuffix() + ", ");
		sb.append("race: " + this.getRace() + ", ");
		sb.append("ssn: " + this.getSsn() + ", ");
		sb.append("ssnDataQuality: " + this.getSsnDataQuality() + ", ");
		sb.append("veteranStatus: " + this.getVeteranStatus());
		sb.append("sourceSystemId: "+this.getSourceSystemId());
		return sb.toString();
	}


	/** Equals implementation.
	 * @see java.lang.Object#equals(java.lang.Object)
	 * @param aThat Object to compare with
	 * @return true/false
	 */
	@Override
	public boolean equals(final Object aThat) {
		Object proxyThat = aThat;

		if ( this == aThat ) {
			 return true;
		}


		if (aThat instanceof HibernateProxy) {
 			// narrow down the proxy to the class we are dealing with.
 			try {
				proxyThat = ((HibernateProxy) aThat).getHibernateLazyInitializer().getImplementation();
			} catch (org.hibernate.ObjectNotFoundException e) {
				return false;
		   	}
		}
		if (aThat == null)  {
			 return false;
		}

		final Client that;
		try {
			that = (Client) proxyThat;
			if ( !(that.getClassType().equals(this.getClassType()))){
				return false;
			}
		} catch (org.hibernate.ObjectNotFoundException e) {
				return false;
		} catch (ClassCastException e) {
				return false;
		}


		boolean result = true;
		result = result && (((this.getId() == null) && ( that.getId() == null)) || (this.getId() != null  && this.getId().equals(that.getId())));
		result = result && (((getDateCreated() == null) && (that.getDateCreated() == null)) || (getDateCreated() != null && getDateCreated().equals(that.getDateCreated())));
		result = result && (((getDateUpdated() == null) && (that.getDateUpdated() == null)) || (getDateUpdated() != null && getDateUpdated().equals(that.getDateUpdated())));
		result = result && (((getDob() == null) && (that.getDob() == null)) || (getDob() != null && getDob().equals(that.getDob())));
		result = result && (((getDobDataQuality() == null) && (that.getDobDataQuality() == null)) || (getDobDataQuality() != null && getDobDataQuality().equals(that.getDobDataQuality())));
		result = result && (((getEthnicity() == null) && (that.getEthnicity() == null)) || (getEthnicity() != null && getEthnicity().equals(that.getEthnicity())));
		result = result && (((getFirstName() == null) && (that.getFirstName() == null)) || (getFirstName() != null && getFirstName().equals(that.getFirstName())));
		result = result && (((getGender() == null) && (that.getGender() == null)) || (getGender() != null && getGender().equals(that.getGender())));
		result = result && (((getLastName() == null) && (that.getLastName() == null)) || (getLastName() != null && getLastName().equals(that.getLastName())));
		result = result && (((getMiddleName() == null) && (that.getMiddleName() == null)) || (getMiddleName() != null && getMiddleName().equals(that.getMiddleName())));
		result = result && (((getNameDataQuality() == null) && (that.getNameDataQuality() == null)) || (getNameDataQuality() != null && getNameDataQuality().equals(that.getNameDataQuality())));
		result = result && (((getNameSuffix() == null) && (that.getNameSuffix() == null)) || (getNameSuffix() != null && getNameSuffix().equals(that.getNameSuffix())));
		result = result && (((getRace() == null) && (that.getRace() == null)) || (getRace() != null && getRace().equals(that.getRace())));
		result = result && (((getSsn() == null) && (that.getSsn() == null)) || (getSsn() != null && getSsn().equals(that.getSsn())));
		result = result && (((getSsnDataQuality() == null) && (that.getSsnDataQuality() == null)) || (getSsnDataQuality() != null && getSsnDataQuality().equals(that.getSsnDataQuality())));
		result = result && (((getUserId() == null) && (that.getUserId() == null)) || (getUserId() != null && getUserId().equals(that.getUserId())));
		result = result && (((getVeteranStatus() == null) && (that.getVeteranStatus() == null)) || (getVeteranStatus() != null && getVeteranStatus().equals(that.getVeteranStatus())));
		result = result && (((getSourceSystemId() == null) && (that.getSourceSystemId() == null)) || (getSourceSystemId() != null && getSourceSystemId().equals(that.getSourceSystemId())));
		return result;
	}


}
