package com.servinglynk.hmis.warehouse.model.base;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "report_config_param",schema="base")
public class ReportConfigParamEntity {
	/** Serial Version UID. */
	private static final long serialVersionUID = 5515655458223886905L;

	/** Use a WeakHashMap so entries will be garbage collected once all entities 
		referring to a saved hash are garbage collected themselves. */
	private static final Map<Serializable, Long> SAVED_HASHES =
		Collections.synchronizedMap(new WeakHashMap<Serializable, Long>());
	
	/** hashCode temporary storage. */
	private volatile Long hashCode;
	
	/** Field mapping. */
	private Long id;
	private ReportConfigEntity reportConfig;
	private String key;
	private String value;
	private String status;
	private LocalDateTime dateCreated;
	private LocalDateTime dateUpdated;
	private String createdBy;
	private String updatedBy;
	private boolean deleted;
	
	@Id
	@SequenceGenerator(allocationSize=1, initialValue=1, sequenceName="base.report_config_param_id_seq", name="base.report_config_param_id_seq" , catalog = "hmis", schema = "base")
	@GeneratedValue(generator="base.report_config_param_id_seq", strategy=GenerationType.SEQUENCE )
	public Long getId() {
		return id;
	}
	 /**  
		 * Set the value related to the column: id.
		 * @param id the id value you wish to set
		 */
		public void setId(final Long id) {
			// If we've just been persisted and hashCode has been
			// returned then make sure other entities with this
			// ID return the already returned hash code
			if ( (this.id == null || this.id == 0L) &&
					(id != null) &&
					(this.hashCode != null) ) {
			SAVED_HASHES.put( id, this.hashCode );
			}
			this.id = id;
		}
	
	@ManyToOne
	@JoinColumn(name = "report_config_id", nullable=false, referencedColumnName="id")
	public ReportConfigEntity getReportConfig() {
		return reportConfig;
	}
	public void setReportConfig(ReportConfigEntity reportConfig) {
		this.reportConfig = reportConfig;
	}
	@Column(name="key")
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	@Column(name="value")
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Column(name="status")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Column(name="date_created")
	@Type(type="org.jadira.usertype.dateandtime.threeten.PersistentLocalDateTime")
	@Basic( optional = true )
	public LocalDateTime getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}
	@Column(name="date_updated")
	@Type(type="org.jadira.usertype.dateandtime.threeten.PersistentLocalDateTime")
	@Basic( optional = true )
	public LocalDateTime getDateUpdated() {
		return dateUpdated;
	}
	public void setDateUpdated(LocalDateTime dateUpdated) {
		this.dateUpdated = dateUpdated;
	}
	@Column(name="created_by")
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	@Column(name="updated_by")
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	@Column(name="deleted")
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
}
