package com.servinglynk.hmis.warehouse.model.base;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;

import com.servinglynk.hmis.warehouse.enums.NoYesEnum;
import com.servinglynk.hmis.warehouse.enums.ProjectContinuumprojectEnum;
import com.servinglynk.hmis.warehouse.enums.ProjectHousingTypeEnum;
import com.servinglynk.hmis.warehouse.enums.ProjectProjecttypeEnum;
import com.servinglynk.hmis.warehouse.enums.ProjectResidentialaffiliationEnum;
import com.servinglynk.hmis.warehouse.enums.ProjectTargetpopulationEnum;
import com.servinglynk.hmis.warehouse.enums.ProjectTrackingmethodEnum;

@Entity
@Table(name = "project", catalog = "hmis", schema = "base")
public class Project extends HmisBaseModel implements Cloneable, Serializable {

	/** Serial Version UID. */
	private static final long serialVersionUID = -7029415480218844556L;
	
	/** Field mapping. */
	private ProjectContinuumprojectEnum continuumproject;

	/** Field mapping. */
	private java.util.UUID id;
	/** Field mapping. */

	private ProjectResidentialaffiliationEnum residentialaffiliation;

	private String projectname;
	/** Field mapping. */
	private String projectcommonname;
	/** Field mapping. */
	private ProjectProjecttypeEnum projecttype;
	/** Field mapping. */
	private ProjectTargetpopulationEnum targetpopulation;
	/** Field mapping. */
	private ProjectTrackingmethodEnum trackingmethod;
	
	private String source;
	
	private String schemaYear;
	/** Field mapping. */
	/**
	 * Default constructor, mainly for hibernate use.
	 */
	public Project() {
		// Default constructor
	}

	/** Constructor taking a given ID.
	 * @param id to set
	 */
	public Project(java.util.UUID id) {
		this.id = id;
	}





	/** Return the type of this class. Useful for when dealing with proxies.
	* @return Defining class.
	*/
	@Transient
	public Class<?> getClassType() {
		return Project.class;
	}
	
	@Type(type = "com.servinglynk.hmis.warehouse.enums.ProjectContinuumprojectEnumType")
	@Basic( optional = true )
	@Column
	public ProjectContinuumprojectEnum getContinuumproject() {
		return this.continuumproject;

	}



	public void setContinuumproject(final ProjectContinuumprojectEnum continuumproject) {
		this.continuumproject = continuumproject;
	}

	@Id
	 @Basic( optional = false )
  @Column( name = "id", nullable = false  ) @org.hibernate.annotations.Type(type="org.hibernate.type.PostgresUUIDType")
	public java.util.UUID getId() {
		return this.id;

	}

	@Type(type = "com.servinglynk.hmis.warehouse.enums.ProjectResidentialaffiliationEnumType")
	@Basic( optional = true )
	@Column
	public ProjectResidentialaffiliationEnum getResidentialaffiliation() {
		return residentialaffiliation;
	}
	
	public void setResidentialaffiliation(ProjectResidentialaffiliationEnum residentialaffiliation) {
		this.residentialaffiliation = residentialaffiliation;
	}

	public void setId(final java.util.UUID id) {
		this.id = id;
	}

	 
	@Basic( optional = true )
	@Column
	public String getProjectname() {
		return this.projectname;

	}
	public void setProjectname(final String projectname) {
		this.projectname = projectname;
	}

		@Basic( optional = true )
		@Column
		public String getProjectcommonname() {
			return this.projectcommonname;

		}

		public void setProjectcommonname(final String projectcommonname) {
			this.projectcommonname = projectcommonname;
		}

		@Type(type = "com.servinglynk.hmis.warehouse.enums.ProjectProjecttypeEnumType")
		@Basic( optional = true )
		@Column
		public ProjectProjecttypeEnum getProjecttype() {
			return this.projecttype;

		}
		
	public void setProjecttype(final ProjectProjecttypeEnum projecttype) {
		this.projecttype = projecttype;
	}

	@Type(type = "com.servinglynk.hmis.warehouse.enums.ProjectTargetpopulationEnumType")
	@Basic( optional = true )
	@Column
	public ProjectTargetpopulationEnum getTargetpopulation() {
		return this.targetpopulation;

	}

	public void setTargetpopulation(final ProjectTargetpopulationEnum targetpopulation) {
		this.targetpopulation = targetpopulation;
	}

	@Type(type = "com.servinglynk.hmis.warehouse.enums.ProjectTrackingmethodEnumType")
	@Basic( optional = true )
	@Column
	public ProjectTrackingmethodEnum getTrackingmethod() {
		return this.trackingmethod;

	}

	public void setTrackingmethod(final ProjectTrackingmethodEnum trackingmethod) {
		this.trackingmethod = trackingmethod;
	}
	
	
	   @Column(name="source")
	   public String getSource() {
			return source;
		}

		public void setSource(String source) {
			this.source = source;
		}

		@Column(name="schema_year")
		public String getSchemaYear() {
			return schemaYear;
		}

		public void setSchemaYear(String schemaYear) {
			this.schemaYear = schemaYear;
		}

		
}
