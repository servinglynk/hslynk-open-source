package com.servinglynk.hmis.warehouse.model.v2015;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.Type;

@SuppressWarnings("serial")
@MappedSuperclass
public abstract class HmisBaseModelV2015 implements Entity{
	
	/** Field mapping. */
	protected LocalDateTime dateCreated;
	/** Field mapping. */
	protected LocalDateTime dateUpdated;
	/** Field mapping. */
	protected LocalDateTime dateCreatedFromSource;
	/** Field mapping. */
	protected LocalDateTime dateUpdatedFromSource;
	/** Field mapping. */
	protected String projectGroupCode;
	protected UUID userId;
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
	
		
		@Type(type="org.jadira.usertype.dateandtime.threeten.PersistentLocalDateTime")
		@Basic( optional = true )
		@Column( name = "date_created_from_source"  )
		  public LocalDateTime getDateCreatedFromSource() {
			return dateCreatedFromSource;
		}
		public void setDateCreatedFromSource(LocalDateTime dateCreatedFromSource) {
			this.dateCreatedFromSource = dateCreatedFromSource;
		}
		@Type(type="org.jadira.usertype.dateandtime.threeten.PersistentLocalDateTime")
		@Basic( optional = true )
		@Column( name = "date_updated_from_source"  )
		public LocalDateTime getDateUpdatedFromSource() {
			return dateUpdatedFromSource;
		}
		public void setDateUpdatedFromSource(LocalDateTime dateUpdatedFromSource) {
			this.dateUpdatedFromSource = dateUpdatedFromSource;
		}
		@Column(name="project_group_code")
			public String getProjectGroupCode() {
				return projectGroupCode;
			}
			public void setProjectGroupCode(String projectGroupCode) {
				this.projectGroupCode = projectGroupCode;
			}
			
			
			
			protected boolean deleted;
			protected boolean sync;
			
			
			@Column(name="sync")
			public boolean isSync() {
				return sync;
			}
			public void setSync(boolean sync) {
				this.sync = sync;
			}
			@Column(name="deleted")
			public boolean isDeleted() {
				return deleted;
			}

			public void setDeleted(boolean deleted) {
				this.deleted = deleted;
			}

			protected UUID parentId;
			
			@Basic( optional = true )
			@Column( name = "parent_id", nullable = true  ) @org.hibernate.annotations.Type(type="org.hibernate.type.PostgresUUIDType")
			public UUID getParentId() {
				return parentId;
			}

			public void setParentId(UUID parentId) {
				this.parentId = parentId;
			}
			
			protected Long version;
			@Basic( optional = true )
			@Column( name = "version", nullable = true  )
			public Long getVersion() {
				return version;
			}

			public void setVersion(Long version) {
				this.version = version;
			}
			@Basic( optional = true )
			@Column( name = "user_id", nullable = true  ) @org.hibernate.annotations.Type(type="org.hibernate.type.PostgresUUIDType")
			public UUID getUserId() {
				return userId;
			}

			public void setUserId(UUID userId) {
				this.userId = userId;
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
}