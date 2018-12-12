package com.servinglynk.hmis.warehouse.model.base;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.WeakHashMap;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.servinglynk.hmis.warehouse.enums.ReportLevelEnum;
import com.servinglynk.hmis.warehouse.enums.ReportTypeEnum;

@Entity
@Table(name = "report_config",schema="base")
public class ReportConfigEntity {

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
	private String name;
	private ReportTypeEnum reportType;
	private ReportLevelEnum reportLevel;
	private String status;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private UUID cocId;
	private LocalDateTime dateCreated;
	private LocalDateTime dateUpdated;
	private String createdBy;
	private String updatedBy;
	private boolean emailSent;
	private boolean deleted;
	private String projectGroupCode;


	 /**
	 * Return the value associated with the column: id.
	 * @return A Long object (this.id)
	 */
	@Id
	@SequenceGenerator(allocationSize=1, initialValue=1, sequenceName="base.report_config_id_seq", name="base.report_config_id_seq" , catalog = "hmis", schema = "base")
	@GeneratedValue(generator="base.report_config_id_seq", strategy=GenerationType.SEQUENCE )
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
	@Column(name = "name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Type(type = "com.servinglynk.hmis.warehouse.enums.ReportTypeEnumType")
	@Basic( optional = true )
	@Column( name = "report_type"  )
	public ReportTypeEnum getReportType() {
		return reportType;
	}
	public void setReportType(ReportTypeEnum reportType) {
		this.reportType = reportType;
	}
	 /**
	 * Return the value associated with the column: reportLevel.
	 * @return A Integer object (this.reportLevel)
	*/
	@Type(type = "com.servinglynk.hmis.warehouse.enums.ReportLevelEnumType")
	@Basic( optional = true )
	@Column( name = "report_level"  )
	public ReportLevelEnum getReportLevel() {
		return reportLevel;
	}
	public void setReportLevel(ReportLevelEnum reportLevel) {
		this.reportLevel = reportLevel;
	}
	public String getStatus() {
		return status;
	}
	@Column(name = "status")
	public void setStatus(String status) {
		this.status = status;
	}
	@Column(name = "start_date")
	@Type(type="org.jadira.usertype.dateandtime.threeten.PersistentLocalDateTime")
	@Basic( optional = true )
	public LocalDateTime getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}
	@Column(name = "end_date")
	@Type(type="org.jadira.usertype.dateandtime.threeten.PersistentLocalDateTime")
	@Basic( optional = true )
	public LocalDateTime getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}
	@Column(name = "coc_id")
	public UUID getCocId() {
		return cocId;
	}
	public void setCocId(UUID cocId) {
		this.cocId = cocId;
	}
	@Column(name = "date_created")
	@Type(type="org.jadira.usertype.dateandtime.threeten.PersistentLocalDateTime")
	@Basic( optional = true )
	public LocalDateTime getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}
	@Column(name = "date_updated")
	@Type(type="org.jadira.usertype.dateandtime.threeten.PersistentLocalDateTime")
	@Basic( optional = true )
	public LocalDateTime getDateUpdated() {
		return dateUpdated;
	}
	public void setDateUpdated(LocalDateTime dateUpdated) {
		this.dateUpdated = dateUpdated;
	}
	@Column(name = "created_by")
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	@Column(name = "updated_by")
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	@Column(name = "email_sent")
	public boolean isEmailSent() {
		return emailSent;
	}
	public void setEmailSent(boolean emailSent) {
		this.emailSent = emailSent;
	}
	@Column(name = "deleted")
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	@Column(name = "project_group_code")
	public String getProjectGroupCode() {
		return projectGroupCode;
	}
	public void setProjectGroupCode(String projectGroupCode) {
		this.projectGroupCode = projectGroupCode;
	}
	

	
	private List<ReportConfigParamEntity> reportConfigParams;

	@OneToMany(mappedBy = "reportConfig")
	public List<ReportConfigParamEntity> getReportConfigParams() {
		return reportConfigParams;
	}

	public void setReportConfigParams(List<ReportConfigParamEntity> reportConfigParams) {
		this.reportConfigParams = reportConfigParams;
	}
	
	
	
}
