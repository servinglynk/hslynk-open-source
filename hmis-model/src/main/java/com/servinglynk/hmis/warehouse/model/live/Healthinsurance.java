package com.servinglynk.hmis.warehouse.model.live;

import com.servinglynk.hmis.warehouse.enums.HealthinsuranceInsurancefromanysourceEnum;
import com.servinglynk.hmis.warehouse.enums.HealthinsuranceMedicaidEnum;
import com.servinglynk.hmis.warehouse.enums.HealthinsuranceMedicareEnum;
import com.servinglynk.hmis.warehouse.enums.HealthinsuranceNocobrareasonEnum;
import com.servinglynk.hmis.warehouse.enums.HealthinsuranceNoemployerprovidedreasonEnum;
import com.servinglynk.hmis.warehouse.enums.HealthinsuranceNomedicaidreasonEnum;
import com.servinglynk.hmis.warehouse.enums.HealthinsuranceNomedicarereasonEnum;
import com.servinglynk.hmis.warehouse.enums.HealthinsuranceNoprivatepayreasonEnum;
import com.servinglynk.hmis.warehouse.enums.HealthinsuranceNoschipreasonEnum;
import com.servinglynk.hmis.warehouse.enums.HealthinsuranceNostatehealthinsreasonEnum;
import com.servinglynk.hmis.warehouse.enums.HealthinsuranceNovamedreasonEnum;
import com.servinglynk.hmis.warehouse.enums.HealthinsurancePrivatepayEnum;
import com.servinglynk.hmis.warehouse.enums.HealthinsuranceSchipEnum;
import com.servinglynk.hmis.warehouse.enums.HealthinsuranceStatehealthinsEnum;
import com.servinglynk.hmis.warehouse.enums.HealthinsuranceVamedicalservicesEnum;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.hibernate.proxy.HibernateProxy;


/**
 * Object mapping for hibernate-handled table: healthinsurance.
 *
 *
 * @author Sandeep Dolia
 */
@Entity(name = "healthinsurance")
@Table(name = "healthinsurance", catalog = "hmis", schema = "v2014")
public class Healthinsurance extends HmisBaseModel  implements Cloneable, Serializable{

	/** Serial Version UID. */
	private static final long serialVersionUID = 1945597065165620993L;

	/** Use a WeakHashMap so entries will be garbage collected once all entities
		referring to a saved hash are garbage collected themselves. */
	private static final Map<Serializable, java.util.UUID> SAVED_HASHES =
		Collections.synchronizedMap(new WeakHashMap<Serializable, java.util.UUID>());

	/** hashCode temporary storage. */
	private volatile java.util.UUID hashCode;


	/** Field mapping. */
	private Integer cobra;
	/** Field mapping. */
	private Integer employerprovided;
	/** Field mapping. */
	private Enrollment enrollmentid;
	/** Field mapping. */
	private java.util.UUID id;
	/** Field mapping. */
	private HealthinsuranceInsurancefromanysourceEnum insurancefromanysource;
	/** Field mapping. */
	private HealthinsuranceMedicaidEnum medicaid;
	/** Field mapping. */
	private HealthinsuranceMedicareEnum medicare;
	/** Field mapping. */
	private HealthinsuranceNocobrareasonEnum nocobrareason;
	/** Field mapping. */
	private HealthinsuranceNoemployerprovidedreasonEnum noemployerprovidedreason;
	/** Field mapping. */
	private HealthinsuranceNomedicaidreasonEnum nomedicaidreason;
	/** Field mapping. */
	private HealthinsuranceNomedicarereasonEnum nomedicarereason;
	/** Field mapping. */
	private HealthinsuranceNoprivatepayreasonEnum noprivatepayreason;
	/** Field mapping. */
	private HealthinsuranceNoschipreasonEnum noschipreason;
	/** Field mapping. */
	private HealthinsuranceNostatehealthinsreasonEnum nostatehealthinsreason;
	/** Field mapping. */
	private HealthinsuranceNovamedreasonEnum novamedreason;
	/** Field mapping. */
	private HealthinsurancePrivatepayEnum privatepay;
	/** Field mapping. */
	private HealthinsuranceSchipEnum schip;
	/** Field mapping. */
	private HealthinsuranceStatehealthinsEnum statehealthins;
	/** Field mapping. */
	private HealthinsuranceVamedicalservicesEnum vamedicalservices;
	/**
	 * Default constructor, mainly for hibernate use.
	 */
	public Healthinsurance() {
		// Default constructor
	}

	/** Constructor taking a given ID.
	 * @param id to set
	 */
	public Healthinsurance(java.util.UUID id) {
		this.id = id;
	}




	/** Field mapping. */
	private Export export;
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
		return Healthinsurance.class;
	}


	 /**
	 * Return the value associated with the column: cobra.
	 * @return A Integer object (this.cobra)
	 */
	public Integer getCobra() {
		return this.cobra;

	}



	 /**
	 * Set the value related to the column: cobra.
	 * @param cobra the cobra value you wish to set
	 */
	public void setCobra(final Integer cobra) {
		this.cobra = cobra;
	}


	 /**
	 * Return the value associated with the column: employerprovided.
	 * @return A Integer object (this.employerprovided)
	 */
	public Integer getEmployerprovided() {
		return this.employerprovided;

	}



	 /**
	 * Set the value related to the column: employerprovided.
	 * @param employerprovided the employerprovided value you wish to set
	 */
	public void setEmployerprovided(final Integer employerprovided) {
		this.employerprovided = employerprovided;
	}

	 /**
	 * Return the value associated with the column: enrollmentid.
	 * @return A Enrollment object (this.enrollmentid)
	 */
	@ManyToOne( cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY )
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = true )
	@JoinColumn(name = "enrollmentid", nullable = true )
	public Enrollment getEnrollmentid() {
		return this.enrollmentid;

	}



	 /**
	 * Set the value related to the column: enrollmentid.
	 * @param enrollmentid the enrollmentid value you wish to set
	 */
	public void setEnrollmentid(final Enrollment enrollmentid) {
		this.enrollmentid = enrollmentid;
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
	 * Return the value associated with the column: insurancefromanysource.
	 * @return A HealthinsuranceInsurancefromanysourceEnum object (this.insurancefromanysource)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.HealthinsuranceInsurancefromanysourceEnumType")
	@Basic( optional = true )
	@Column
	public HealthinsuranceInsurancefromanysourceEnum getInsurancefromanysource() {
		return this.insurancefromanysource;

	}



	 /**
	 * Set the value related to the column: insurancefromanysource.
	 * @param insurancefromanysource the insurancefromanysource value you wish to set
	 */
	public void setInsurancefromanysource(final HealthinsuranceInsurancefromanysourceEnum insurancefromanysource) {
		this.insurancefromanysource = insurancefromanysource;
	}

	 /**
	 * Return the value associated with the column: medicaid.
	 * @return A HealthinsuranceMedicaidEnum object (this.medicaid)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.HealthinsuranceMedicaidEnumType")
	@Basic( optional = true )
	@Column
	public HealthinsuranceMedicaidEnum getMedicaid() {
		return this.medicaid;

	}



	 /**
	 * Set the value related to the column: medicaid.
	 * @param medicaid the medicaid value you wish to set
	 */
	public void setMedicaid(final HealthinsuranceMedicaidEnum medicaid) {
		this.medicaid = medicaid;
	}

	 /**
	 * Return the value associated with the column: medicare.
	 * @return A HealthinsuranceMedicareEnum object (this.medicare)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.HealthinsuranceMedicareEnumType")
	@Basic( optional = true )
	@Column
	public HealthinsuranceMedicareEnum getMedicare() {
		return this.medicare;

	}



	 /**
	 * Set the value related to the column: medicare.
	 * @param medicare the medicare value you wish to set
	 */
	public void setMedicare(final HealthinsuranceMedicareEnum medicare) {
		this.medicare = medicare;
	}

	 /**
	 * Return the value associated with the column: nocobrareason.
	 * @return A HealthinsuranceNocobrareasonEnum object (this.nocobrareason)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.HealthinsuranceNocobrareasonEnumType")
	@Basic( optional = true )
	@Column
	public HealthinsuranceNocobrareasonEnum getNocobrareason() {
		return this.nocobrareason;

	}



	 /**
	 * Set the value related to the column: nocobrareason.
	 * @param nocobrareason the nocobrareason value you wish to set
	 */
	public void setNocobrareason(final HealthinsuranceNocobrareasonEnum nocobrareason) {
		this.nocobrareason = nocobrareason;
	}

	 /**
	 * Return the value associated with the column: noemployerprovidedreason.
	 * @return A HealthinsuranceNoemployerprovidedreasonEnum object (this.noemployerprovidedreason)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.HealthinsuranceNoemployerprovidedreasonEnumType")
	public HealthinsuranceNoemployerprovidedreasonEnum getNoemployerprovidedreason() {
		return this.noemployerprovidedreason;

	}



	 /**
	 * Set the value related to the column: noemployerprovidedreason.
	 * @param noemployerprovidedreason the noemployerprovidedreason value you wish to set
	 */
	public void setNoemployerprovidedreason(final HealthinsuranceNoemployerprovidedreasonEnum noemployerprovidedreason) {
		this.noemployerprovidedreason = noemployerprovidedreason;
	}

	 /**
	 * Return the value associated with the column: nomedicaidreason.
	 * @return A HealthinsuranceNomedicaidreasonEnum object (this.nomedicaidreason)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.HealthinsuranceNomedicaidreasonEnumType")
	@Basic( optional = true )
	@Column
	public HealthinsuranceNomedicaidreasonEnum getNomedicaidreason() {
		return this.nomedicaidreason;

	}



	 /**
	 * Set the value related to the column: nomedicaidreason.
	 * @param nomedicaidreason the nomedicaidreason value you wish to set
	 */
	public void setNomedicaidreason(final HealthinsuranceNomedicaidreasonEnum nomedicaidreason) {
		this.nomedicaidreason = nomedicaidreason;
	}

	 /**
	 * Return the value associated with the column: nomedicarereason.
	 * @return A HealthinsuranceNomedicarereasonEnum object (this.nomedicarereason)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.HealthinsuranceNomedicarereasonEnumType")
	@Basic( optional = true )
	@Column
	public HealthinsuranceNomedicarereasonEnum getNomedicarereason() {
		return this.nomedicarereason;

	}



	 /**
	 * Set the value related to the column: nomedicarereason.
	 * @param nomedicarereason the nomedicarereason value you wish to set
	 */
	public void setNomedicarereason(final HealthinsuranceNomedicarereasonEnum nomedicarereason) {
		this.nomedicarereason = nomedicarereason;
	}

	 /**
	 * Return the value associated with the column: noprivatepayreason.
	 * @return A HealthinsuranceNoprivatepayreasonEnum object (this.noprivatepayreason)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.HealthinsuranceNoprivatepayreasonEnumType")
	@Basic( optional = true )
	@Column
	public HealthinsuranceNoprivatepayreasonEnum getNoprivatepayreason() {
		return this.noprivatepayreason;

	}



	 /**
	 * Set the value related to the column: noprivatepayreason.
	 * @param noprivatepayreason the noprivatepayreason value you wish to set
	 */
	public void setNoprivatepayreason(final HealthinsuranceNoprivatepayreasonEnum noprivatepayreason) {
		this.noprivatepayreason = noprivatepayreason;
	}

	 /**
	 * Return the value associated with the column: noschipreason.
	 * @return A HealthinsuranceNoschipreasonEnum object (this.noschipreason)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.HealthinsuranceNoschipreasonEnumType")
	@Basic( optional = true )
	@Column
	public HealthinsuranceNoschipreasonEnum getNoschipreason() {
		return this.noschipreason;

	}



	 /**
	 * Set the value related to the column: noschipreason.
	 * @param noschipreason the noschipreason value you wish to set
	 */
	public void setNoschipreason(final HealthinsuranceNoschipreasonEnum noschipreason) {
		this.noschipreason = noschipreason;
	}

	 /**
	 * Return the value associated with the column: nostatehealthinsreason.
	 * @return A HealthinsuranceNostatehealthinsreasonEnum object (this.nostatehealthinsreason)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.HealthinsuranceNostatehealthinsreasonEnumType")
	@Basic( optional = true )
	@Column
	public HealthinsuranceNostatehealthinsreasonEnum getNostatehealthinsreason() {
		return this.nostatehealthinsreason;

	}



	 /**
	 * Set the value related to the column: nostatehealthinsreason.
	 * @param nostatehealthinsreason the nostatehealthinsreason value you wish to set
	 */
	public void setNostatehealthinsreason(final HealthinsuranceNostatehealthinsreasonEnum nostatehealthinsreason) {
		this.nostatehealthinsreason = nostatehealthinsreason;
	}

	 /**
	 * Return the value associated with the column: novamedreason.
	 * @return A HealthinsuranceNovamedreasonEnum object (this.novamedreason)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.HealthinsuranceNovamedreasonEnumType")
	@Basic( optional = true )
	@Column
	public HealthinsuranceNovamedreasonEnum getNovamedreason() {
		return this.novamedreason;

	}



	 /**
	 * Set the value related to the column: novamedreason.
	 * @param novamedreason the novamedreason value you wish to set
	 */
	public void setNovamedreason(final HealthinsuranceNovamedreasonEnum novamedreason) {
		this.novamedreason = novamedreason;
	}

	 /**
	 * Return the value associated with the column: privatepay.
	 * @return A HealthinsurancePrivatepayEnum object (this.privatepay)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.HealthinsurancePrivatepayEnumType")
	@Basic( optional = true )
	@Column
	public HealthinsurancePrivatepayEnum getPrivatepay() {
		return this.privatepay;

	}



	 /**
	 * Set the value related to the column: privatepay.
	 * @param privatepay the privatepay value you wish to set
	 */
	public void setPrivatepay(final HealthinsurancePrivatepayEnum privatepay) {
		this.privatepay = privatepay;
	}

	 /**
	 * Return the value associated with the column: schip.
	 * @return A HealthinsuranceSchipEnum object (this.schip)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.HealthinsuranceSchipEnumType")
	@Basic( optional = true )
	@Column
	public HealthinsuranceSchipEnum getSchip() {
		return this.schip;

	}



	 /**
	 * Set the value related to the column: schip.
	 * @param schip the schip value you wish to set
	 */
	public void setSchip(final HealthinsuranceSchipEnum schip) {
		this.schip = schip;
	}

	 /**
	 * Return the value associated with the column: statehealthins.
	 * @return A HealthinsuranceStatehealthinsEnum object (this.statehealthins)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.HealthinsuranceStatehealthinsEnumType")
	@Basic( optional = true )
	@Column
	public HealthinsuranceStatehealthinsEnum getStatehealthins() {
		return this.statehealthins;

	}



	 /**
	 * Set the value related to the column: statehealthins.
	 * @param statehealthins the statehealthins value you wish to set
	 */
	public void setStatehealthins(final HealthinsuranceStatehealthinsEnum statehealthins) {
		this.statehealthins = statehealthins;
	}

	 /**
	 * Return the value associated with the column: vamedicalservices.
	 * @return A HealthinsuranceVamedicalservicesEnum object (this.vamedicalservices)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.HealthinsuranceVamedicalservicesEnumType")
	@Basic( optional = true )
	@Column
	public HealthinsuranceVamedicalservicesEnum getVamedicalservices() {
		return this.vamedicalservices;

	}

	 /**
	 * Set the value related to the column: vamedicalservices.
	 * @param vamedicalservices the vamedicalservices value you wish to set
	 */
	public void setVamedicalservices(final HealthinsuranceVamedicalservicesEnum vamedicalservices) {
		this.vamedicalservices = vamedicalservices;
	}


   /**
    * Deep copy.
	* @return cloned object
	* @throws CloneNotSupportedException on error
    */
    @Override
    public Healthinsurance clone() throws CloneNotSupportedException {

        final Healthinsurance copy = (Healthinsurance)super.clone();

		copy.setCobra(this.getCobra());
		copy.setDateCreated(this.getDateCreated());
		copy.setDateUpdated(this.getDateUpdated());
		copy.setEmployerprovided(this.getEmployerprovided());
		copy.setEnrollmentid(this.getEnrollmentid());
		copy.setId(this.getId());
		copy.setInsurancefromanysource(this.getInsurancefromanysource());
		copy.setMedicaid(this.getMedicaid());
		copy.setMedicare(this.getMedicare());
		copy.setNocobrareason(this.getNocobrareason());
		copy.setNoemployerprovidedreason(this.getNoemployerprovidedreason());
		copy.setNomedicaidreason(this.getNomedicaidreason());
		copy.setNomedicarereason(this.getNomedicarereason());
		copy.setNoprivatepayreason(this.getNoprivatepayreason());
		copy.setNoschipreason(this.getNoschipreason());
		copy.setNostatehealthinsreason(this.getNostatehealthinsreason());
		copy.setNovamedreason(this.getNovamedreason());
		copy.setPrivatepay(this.getPrivatepay());
		copy.setSchip(this.getSchip());
		copy.setStatehealthins(this.getStatehealthins());
		copy.setUser(this.getUser());
		copy.setVamedicalservices(this.getVamedicalservices());
		return copy;
	}



	/** Provides toString implementation.
	 * @see java.lang.Object#toString()
	 * @return String representation of this class.
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();

		sb.append("cobra: " + this.getCobra() + ", ");
		sb.append("dateCreated: " + this.getDateCreated() + ", ");
		sb.append("dateUpdated: " + this.getDateUpdated() + ", ");
		sb.append("employerprovided: " + this.getEmployerprovided() + ", ");
		sb.append("id: " + this.getId() + ", ");
		sb.append("insurancefromanysource: " + this.getInsurancefromanysource() + ", ");
		sb.append("medicaid: " + this.getMedicaid() + ", ");
		sb.append("medicare: " + this.getMedicare() + ", ");
		sb.append("nocobrareason: " + this.getNocobrareason() + ", ");
		sb.append("noemployerprovidedreason: " + this.getNoemployerprovidedreason() + ", ");
		sb.append("nomedicaidreason: " + this.getNomedicaidreason() + ", ");
		sb.append("nomedicarereason: " + this.getNomedicarereason() + ", ");
		sb.append("noprivatepayreason: " + this.getNoprivatepayreason() + ", ");
		sb.append("noschipreason: " + this.getNoschipreason() + ", ");
		sb.append("nostatehealthinsreason: " + this.getNostatehealthinsreason() + ", ");
		sb.append("novamedreason: " + this.getNovamedreason() + ", ");
		sb.append("privatepay: " + this.getPrivatepay() + ", ");
		sb.append("schip: " + this.getSchip() + ", ");
		sb.append("statehealthins: " + this.getStatehealthins() + ", ");
		sb.append("vamedicalservices: " + this.getVamedicalservices());
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

		final Healthinsurance that;
		try {
			that = (Healthinsurance) proxyThat;
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
		result = result && (((getCobra() == null) && (that.getCobra() == null)) || (getCobra() != null && getCobra().equals(that.getCobra())));
		result = result && (((getDateCreated() == null) && (that.getDateCreated() == null)) || (getDateCreated() != null && getDateCreated().equals(that.getDateCreated())));
		result = result && (((getDateUpdated() == null) && (that.getDateUpdated() == null)) || (getDateUpdated() != null && getDateUpdated().equals(that.getDateUpdated())));
		result = result && (((getEmployerprovided() == null) && (that.getEmployerprovided() == null)) || (getEmployerprovided() != null && getEmployerprovided().equals(that.getEmployerprovided())));
		result = result && (((getEnrollmentid() == null) && (that.getEnrollmentid() == null)) || (getEnrollmentid() != null && getEnrollmentid().getId().equals(that.getEnrollmentid().getId())));
		result = result && (((getInsurancefromanysource() == null) && (that.getInsurancefromanysource() == null)) || (getInsurancefromanysource() != null && getInsurancefromanysource().equals(that.getInsurancefromanysource())));
		result = result && (((getMedicaid() == null) && (that.getMedicaid() == null)) || (getMedicaid() != null && getMedicaid().equals(that.getMedicaid())));
		result = result && (((getMedicare() == null) && (that.getMedicare() == null)) || (getMedicare() != null && getMedicare().equals(that.getMedicare())));
		result = result && (((getNocobrareason() == null) && (that.getNocobrareason() == null)) || (getNocobrareason() != null && getNocobrareason().equals(that.getNocobrareason())));
		result = result && (((getNoemployerprovidedreason() == null) && (that.getNoemployerprovidedreason() == null)) || (getNoemployerprovidedreason() != null && getNoemployerprovidedreason().equals(that.getNoemployerprovidedreason())));
		result = result && (((getNomedicaidreason() == null) && (that.getNomedicaidreason() == null)) || (getNomedicaidreason() != null && getNomedicaidreason().equals(that.getNomedicaidreason())));
		result = result && (((getNomedicarereason() == null) && (that.getNomedicarereason() == null)) || (getNomedicarereason() != null && getNomedicarereason().equals(that.getNomedicarereason())));
		result = result && (((getNoprivatepayreason() == null) && (that.getNoprivatepayreason() == null)) || (getNoprivatepayreason() != null && getNoprivatepayreason().equals(that.getNoprivatepayreason())));
		result = result && (((getNoschipreason() == null) && (that.getNoschipreason() == null)) || (getNoschipreason() != null && getNoschipreason().equals(that.getNoschipreason())));
		result = result && (((getNostatehealthinsreason() == null) && (that.getNostatehealthinsreason() == null)) || (getNostatehealthinsreason() != null && getNostatehealthinsreason().equals(that.getNostatehealthinsreason())));
		result = result && (((getNovamedreason() == null) && (that.getNovamedreason() == null)) || (getNovamedreason() != null && getNovamedreason().equals(that.getNovamedreason())));
		result = result && (((getPrivatepay() == null) && (that.getPrivatepay() == null)) || (getPrivatepay() != null && getPrivatepay().equals(that.getPrivatepay())));
		result = result && (((getSchip() == null) && (that.getSchip() == null)) || (getSchip() != null && getSchip().equals(that.getSchip())));
		result = result && (((getStatehealthins() == null) && (that.getStatehealthins() == null)) || (getStatehealthins() != null && getStatehealthins().equals(that.getStatehealthins())));
		result = result && (((getUser() == null) && (that.getUser() == null)) || (getUser() != null && getUser().equals(that.getUser())));
		result = result && (((getVamedicalservices() == null) && (that.getVamedicalservices() == null)) || (getVamedicalservices() != null && getVamedicalservices().equals(that.getVamedicalservices())));
		return result;
	}
}
