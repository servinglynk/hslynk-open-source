package com.servinglynk.hmis.warehouse.model.live;

import com.servinglynk.hmis.warehouse.enums.ExitplansactionsAssistancemainstreambenefitsEnum;
import com.servinglynk.hmis.warehouse.enums.ExitplansactionsExitcounselingEnum;
import com.servinglynk.hmis.warehouse.enums.ExitplansactionsFurtherfollowupservicesEnum;
import com.servinglynk.hmis.warehouse.enums.ExitplansactionsOtheraftercareplanoractionEnum;
import com.servinglynk.hmis.warehouse.enums.ExitplansactionsPermanenthousingplacementEnum;
import com.servinglynk.hmis.warehouse.enums.ExitplansactionsResourcepackageEnum;
import com.servinglynk.hmis.warehouse.enums.ExitplansactionsScheduledfollowupcontactsEnum;
import com.servinglynk.hmis.warehouse.enums.ExitplansactionsTemporaryshelterplacementEnum;
import com.servinglynk.hmis.warehouse.enums.ExitplansactionsWrittenaftercareplanEnum;

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
 * Object mapping for hibernate-handled table: exitplansactions.
 *
 *
 * @author Sandeep Dolia
 */
@Entity(name = "exitplansactions")
@Table(name = "exitplansactions", catalog = "hmis", schema = "v2014")
public class Exitplansactions extends HmisBaseModel  implements Cloneable, Serializable {

	/** Serial Version UID. */
	private static final long serialVersionUID = 1785915543624160768L;

	/** Use a WeakHashMap so entries will be garbage collected once all entities
		referring to a saved hash are garbage collected themselves. */
	private static final Map<Serializable, java.util.UUID> SAVED_HASHES =
		Collections.synchronizedMap(new WeakHashMap<Serializable, java.util.UUID>());

	/** hashCode temporary storage. */
	private volatile java.util.UUID hashCode;


	/** Field mapping. */
	private ExitplansactionsAssistancemainstreambenefitsEnum assistancemainstreambenefits;
	/** Field mapping. */
	private ExitplansactionsExitcounselingEnum exitcounseling;
	/** Field mapping. */
	private Exit exitid;
	/** Field mapping. */
	private ExitplansactionsFurtherfollowupservicesEnum furtherfollowupservices;
	/** Field mapping. */
	private java.util.UUID id;
	/** Field mapping. */
	private ExitplansactionsOtheraftercareplanoractionEnum otheraftercareplanoraction;
	/** Field mapping. */
	private ExitplansactionsPermanenthousingplacementEnum permanenthousingplacement;
	/** Field mapping. */
	private ExitplansactionsResourcepackageEnum resourcepackage;
	/** Field mapping. */
	private ExitplansactionsScheduledfollowupcontactsEnum scheduledfollowupcontacts;
	/** Field mapping. */
	private ExitplansactionsTemporaryshelterplacementEnum temporaryshelterplacement;
	/** Field mapping. */
	private ExitplansactionsWrittenaftercareplanEnum writtenaftercareplan;
	/**
	 * Default constructor, mainly for hibernate use.
	 */
	public Exitplansactions() {
		// Default constructor
	}

	/** Constructor taking a given ID.
	 * @param id to set
	 */
	public Exitplansactions(java.util.UUID id) {
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
		return Exitplansactions.class;
	}


	 /**
	 * Return the value associated with the column: assistancemainstreambenefits.
	 * @return A ExitplansactionsAssistancemainstreambenefitsEnum object (this.assistancemainstreambenefits)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.ExitplansactionsAssistancemainstreambenefitsEnumType")
	@Basic( optional = true )
	@Column
	public ExitplansactionsAssistancemainstreambenefitsEnum getAssistancemainstreambenefits() {
		return this.assistancemainstreambenefits;

	}



	 /**
	 * Set the value related to the column: assistancemainstreambenefits.
	 * @param assistancemainstreambenefits the assistancemainstreambenefits value you wish to set
	 */
	public void setAssistancemainstreambenefits(final ExitplansactionsAssistancemainstreambenefitsEnum assistancemainstreambenefits) {
		this.assistancemainstreambenefits = assistancemainstreambenefits;
	}

	 /**
	 * Return the value associated with the column: exitcounseling.
	 * @return A ExitplansactionsExitcounselingEnum object (this.exitcounseling)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.ExitplansactionsExitcounselingEnumType")
	@Basic( optional = true )
	@Column
	public ExitplansactionsExitcounselingEnum getExitcounseling() {
		return this.exitcounseling;

	}



	 /**
	 * Set the value related to the column: exitcounseling.
	 * @param exitcounseling the exitcounseling value you wish to set
	 */
	public void setExitcounseling(final ExitplansactionsExitcounselingEnum exitcounseling) {
		this.exitcounseling = exitcounseling;
	}

	 /**
	 * Return the value associated with the column: exitid.
	 * @return A Exit object (this.exitid)
	 */
	@ManyToOne( cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY )
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = true )
	@JoinColumn(name = "exitid", nullable = true )
	public Exit getExitid() {
		return this.exitid;

	}



	 /**
	 * Set the value related to the column: exitid.
	 * @param exitid the exitid value you wish to set
	 */
	public void setExitid(final Exit exitid) {
		this.exitid = exitid;
	}

	 /**
	 * Return the value associated with the column: furtherfollowupservices.
	 * @return A ExitplansactionsFurtherfollowupservicesEnum object (this.furtherfollowupservices)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.ExitplansactionsFurtherfollowupservicesEnumType")
	@Basic( optional = true )
	@Column
	public ExitplansactionsFurtherfollowupservicesEnum getFurtherfollowupservices() {
		return this.furtherfollowupservices;

	}



	 /**
	 * Set the value related to the column: furtherfollowupservices.
	 * @param furtherfollowupservices the furtherfollowupservices value you wish to set
	 */
	public void setFurtherfollowupservices(final ExitplansactionsFurtherfollowupservicesEnum furtherfollowupservices) {
		this.furtherfollowupservices = furtherfollowupservices;
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
	 * Return the value associated with the column: otheraftercareplanoraction.
	 * @return A ExitplansactionsOtheraftercareplanoractionEnum object (this.otheraftercareplanoraction)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.ExitplansactionsOtheraftercareplanoractionEnumType")
	@Basic( optional = true )
	@Column
	public ExitplansactionsOtheraftercareplanoractionEnum getOtheraftercareplanoraction() {
		return this.otheraftercareplanoraction;

	}



	 /**
	 * Set the value related to the column: otheraftercareplanoraction.
	 * @param otheraftercareplanoraction the otheraftercareplanoraction value you wish to set
	 */
	public void setOtheraftercareplanoraction(final ExitplansactionsOtheraftercareplanoractionEnum otheraftercareplanoraction) {
		this.otheraftercareplanoraction = otheraftercareplanoraction;
	}

	 /**
	 * Return the value associated with the column: permanenthousingplacement.
	 * @return A ExitplansactionsPermanenthousingplacementEnum object (this.permanenthousingplacement)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.ExitplansactionsPermanenthousingplacementEnumType")
	@Basic( optional = true )
	@Column
	public ExitplansactionsPermanenthousingplacementEnum getPermanenthousingplacement() {
		return this.permanenthousingplacement;

	}



	 /**
	 * Set the value related to the column: permanenthousingplacement.
	 * @param permanenthousingplacement the permanenthousingplacement value you wish to set
	 */
	public void setPermanenthousingplacement(final ExitplansactionsPermanenthousingplacementEnum permanenthousingplacement) {
		this.permanenthousingplacement = permanenthousingplacement;
	}

	 /**
	 * Return the value associated with the column: resourcepackage.
	 * @return A ExitplansactionsResourcepackageEnum object (this.resourcepackage)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.ExitplansactionsResourcepackageEnumType")
	@Basic( optional = true )
	@Column
	public ExitplansactionsResourcepackageEnum getResourcepackage() {
		return this.resourcepackage;

	}



	 /**
	 * Set the value related to the column: resourcepackage.
	 * @param resourcepackage the resourcepackage value you wish to set
	 */
	public void setResourcepackage(final ExitplansactionsResourcepackageEnum resourcepackage) {
		this.resourcepackage = resourcepackage;
	}

	 /**
	 * Return the value associated with the column: scheduledfollowupcontacts.
	 * @return A ExitplansactionsScheduledfollowupcontactsEnum object (this.scheduledfollowupcontacts)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.ExitplansactionsScheduledfollowupcontactsEnumType")
	@Basic( optional = true )
	@Column
	public ExitplansactionsScheduledfollowupcontactsEnum getScheduledfollowupcontacts() {
		return this.scheduledfollowupcontacts;

	}



	 /**
	 * Set the value related to the column: scheduledfollowupcontacts.
	 * @param scheduledfollowupcontacts the scheduledfollowupcontacts value you wish to set
	 */
	public void setScheduledfollowupcontacts(final ExitplansactionsScheduledfollowupcontactsEnum scheduledfollowupcontacts) {
		this.scheduledfollowupcontacts = scheduledfollowupcontacts;
	}

	 /**
	 * Return the value associated with the column: temporaryshelterplacement.
	 * @return A ExitplansactionsTemporaryshelterplacementEnum object (this.temporaryshelterplacement)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.ExitplansactionsTemporaryshelterplacementEnumType")
	@Basic( optional = true )
	@Column
	public ExitplansactionsTemporaryshelterplacementEnum getTemporaryshelterplacement() {
		return this.temporaryshelterplacement;

	}



	 /**
	 * Set the value related to the column: temporaryshelterplacement.
	 * @param temporaryshelterplacement the temporaryshelterplacement value you wish to set
	 */
	public void setTemporaryshelterplacement(final ExitplansactionsTemporaryshelterplacementEnum temporaryshelterplacement) {
		this.temporaryshelterplacement = temporaryshelterplacement;
	}


	 /**
	 * Return the value associated with the column: writtenaftercareplan.
	 * @return A ExitplansactionsWrittenaftercareplanEnum object (this.writtenaftercareplan)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.ExitplansactionsWrittenaftercareplanEnumType")
	@Basic( optional = true )
	@Column
	public ExitplansactionsWrittenaftercareplanEnum getWrittenaftercareplan() {
		return this.writtenaftercareplan;

	}

	 /**
	 * Set the value related to the column: writtenaftercareplan.
	 * @param writtenaftercareplan the writtenaftercareplan value you wish to set
	 */
	public void setWrittenaftercareplan(final ExitplansactionsWrittenaftercareplanEnum writtenaftercareplan) {
		this.writtenaftercareplan = writtenaftercareplan;
	}


   /**
    * Deep copy.
	* @return cloned object
	* @throws CloneNotSupportedException on error
    */
    @Override
    public Exitplansactions clone() throws CloneNotSupportedException {

        final Exitplansactions copy = (Exitplansactions)super.clone();

		copy.setAssistancemainstreambenefits(this.getAssistancemainstreambenefits());
		copy.setDateCreated(this.getDateCreated());
		copy.setDateUpdated(this.getDateUpdated());
		copy.setExitcounseling(this.getExitcounseling());
		copy.setExitid(this.getExitid());
		copy.setFurtherfollowupservices(this.getFurtherfollowupservices());
		copy.setId(this.getId());
		copy.setOtheraftercareplanoraction(this.getOtheraftercareplanoraction());
		copy.setPermanenthousingplacement(this.getPermanenthousingplacement());
		copy.setResourcepackage(this.getResourcepackage());
		copy.setScheduledfollowupcontacts(this.getScheduledfollowupcontacts());
		copy.setTemporaryshelterplacement(this.getTemporaryshelterplacement());
		copy.setUser(this.getUser());
		copy.setWrittenaftercareplan(this.getWrittenaftercareplan());
		return copy;
	}



	/** Provides toString implementation.
	 * @see java.lang.Object#toString()
	 * @return String representation of this class.
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();

		sb.append("assistancemainstreambenefits: " + this.getAssistancemainstreambenefits() + ", ");
		sb.append("dateCreated: " + this.getDateCreated() + ", ");
		sb.append("dateUpdated: " + this.getDateUpdated() + ", ");
		sb.append("exitcounseling: " + this.getExitcounseling() + ", ");
		sb.append("furtherfollowupservices: " + this.getFurtherfollowupservices() + ", ");
		sb.append("id: " + this.getId() + ", ");
		sb.append("otheraftercareplanoraction: " + this.getOtheraftercareplanoraction() + ", ");
		sb.append("permanenthousingplacement: " + this.getPermanenthousingplacement() + ", ");
		sb.append("resourcepackage: " + this.getResourcepackage() + ", ");
		sb.append("scheduledfollowupcontacts: " + this.getScheduledfollowupcontacts() + ", ");
		sb.append("temporaryshelterplacement: " + this.getTemporaryshelterplacement() + ", ");
		sb.append("writtenaftercareplan: " + this.getWrittenaftercareplan());
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

		final Exitplansactions that;
		try {
			that = (Exitplansactions) proxyThat;
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
		result = result && (((getAssistancemainstreambenefits() == null) && (that.getAssistancemainstreambenefits() == null)) || (getAssistancemainstreambenefits() != null && getAssistancemainstreambenefits().equals(that.getAssistancemainstreambenefits())));
		result = result && (((getDateCreated() == null) && (that.getDateCreated() == null)) || (getDateCreated() != null && getDateCreated().equals(that.getDateCreated())));
		result = result && (((getDateUpdated() == null) && (that.getDateUpdated() == null)) || (getDateUpdated() != null && getDateUpdated().equals(that.getDateUpdated())));
		result = result && (((getExitcounseling() == null) && (that.getExitcounseling() == null)) || (getExitcounseling() != null && getExitcounseling().equals(that.getExitcounseling())));
		result = result && (((getExitid() == null) && (that.getExitid() == null)) || (getExitid() != null && getExitid().getId().equals(that.getExitid().getId())));
		result = result && (((getFurtherfollowupservices() == null) && (that.getFurtherfollowupservices() == null)) || (getFurtherfollowupservices() != null && getFurtherfollowupservices().equals(that.getFurtherfollowupservices())));
		result = result && (((getOtheraftercareplanoraction() == null) && (that.getOtheraftercareplanoraction() == null)) || (getOtheraftercareplanoraction() != null && getOtheraftercareplanoraction().equals(that.getOtheraftercareplanoraction())));
		result = result && (((getPermanenthousingplacement() == null) && (that.getPermanenthousingplacement() == null)) || (getPermanenthousingplacement() != null && getPermanenthousingplacement().equals(that.getPermanenthousingplacement())));
		result = result && (((getResourcepackage() == null) && (that.getResourcepackage() == null)) || (getResourcepackage() != null && getResourcepackage().equals(that.getResourcepackage())));
		result = result && (((getScheduledfollowupcontacts() == null) && (that.getScheduledfollowupcontacts() == null)) || (getScheduledfollowupcontacts() != null && getScheduledfollowupcontacts().equals(that.getScheduledfollowupcontacts())));
		result = result && (((getTemporaryshelterplacement() == null) && (that.getTemporaryshelterplacement() == null)) || (getTemporaryshelterplacement() != null && getTemporaryshelterplacement().equals(that.getTemporaryshelterplacement())));
		result = result && (((getUser() == null) && (that.getUser() == null)) || (getUser() != null && getUser().equals(that.getUser())));
		result = result && (((getWrittenaftercareplan() == null) && (that.getWrittenaftercareplan() == null)) || (getWrittenaftercareplan() != null && getWrittenaftercareplan().equals(that.getWrittenaftercareplan())));
		return result;
	}

}
