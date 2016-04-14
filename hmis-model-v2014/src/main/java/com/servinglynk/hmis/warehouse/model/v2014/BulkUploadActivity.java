package com.servinglynk.hmis.warehouse.model.v2014;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Map;
import java.util.UUID;
import java.util.WeakHashMap;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;


@Entity (name = "bulk_upload_activity")
@Table(name = "bulk_upload_activity", catalog = "hmis", schema = "v2014")
public class BulkUploadActivity implements Cloneable, Serializable {


	/** Serial Version UID. */
	private static final long serialVersionUID = -3243148389368176233L;

	/** Use a WeakHashMap so entries will be garbage collected once all entities 
		referring to a saved hash are garbage collected themselves. */
	private static final Map<Serializable, java.util.UUID> SAVED_HASHES =
		Collections.synchronizedMap(new WeakHashMap<Serializable, java.util.UUID>());
	
	private Long id;
	/** Field mapping. */
	private Export export;
	
	private Long bulkUploadId;
	private String tableName;
	private Long recordsProcessed;
	private String description;
	 /**
	 * Return the value associated with the column: export.
	 * @return A Export object (this.export)
	 */
	@ManyToOne( cascade = { CascadeType.PERSIST, CascadeType.REMOVE }, fetch = FetchType.LAZY)
//	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.REMOVE})
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
	
	 /**
		 * Return the value associated with the column: export.
		 * @return A Export object (this.export)
		 */
		@Column(name = "bulk_upload_id", nullable = true )
		public Long getBulkUploadId() {
			return this.bulkUploadId;
			
		}
		 /**  
		 * Set the value related to the column: export.
		 * @param export the export value you wish to set
		 */
		public void setBulkUploadId(final Long bulkUpload) {
			this.bulkUploadId = bulkUpload;
		}
	
	@Id
	@SequenceGenerator(allocationSize=1, initialValue=1, sequenceName="v2015.bulk_upload_activity_id_seq", name="v2015.bulk_upload_activity_id_seq" , catalog = "hmis", schema = "v2014")
	@GeneratedValue(generator="v2015.bulk_upload_activity_id_seq", strategy=GenerationType.SEQUENCE )
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	@Column(name = "table_name")
	public String getTableName() {
		return tableName;
	}
	
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	@Column(name = "records_processed")
	public Long getRecordsProcessed() {
		return recordsProcessed;
	}
	
	public void setRecordsProcessed(Long recordsProcessed) {
		this.recordsProcessed = recordsProcessed;
	}
	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	/** Field mapping. */
	protected LocalDateTime dateCreated;
	/** Field mapping. */
	protected LocalDateTime dateUpdated;
	/** Field mapping. */
	protected String projectGroupCode;
	/** Field mapping. */
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
	
		@Column(name="project_group_code")
			public String getProjectGroupCode() {
				return projectGroupCode;
			}
			public void setProjectGroupCode(String projectGroupCode) {
				this.projectGroupCode = projectGroupCode;
			}
			
			
			
			private boolean deleted;
			private boolean sync;
			
			
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

			private UUID parentId;
			
			@Basic( optional = true )
			@Column( name = "parent_id", nullable = true  ) @org.hibernate.annotations.Type(type="org.hibernate.type.PostgresUUIDType")
			public UUID getParentId() {
				return parentId;
			}

			public void setParentId(UUID parentId) {
				this.parentId = parentId;
			}
			
			private Long version;
			@Basic( optional = true )
			@Column( name = "version", nullable = true  )
			public Long getVersion() {
				return version;
			}

			public void setVersion(Long version) {
				this.version = version;
			}
			
}
