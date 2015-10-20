package com.servinglynk.hmis.warehouse.report.persistence.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.servinglynk.hmis.warehouse.report.common.Constants.ReportStatus;

@Entity
@Table(name = "HMIS_REPORT_LINE" )
public class ReportLineEntity  extends ParentEntity {

	
	private Long id;
	private ReportHeaderEntity reportHeaderEntity;
	private String externalId;
	private String reportLocation;
	private Date requestTime;
	private Date completedTime;
	private String status;
	private String statusMessage;
	
	
	@Id
	@SequenceGenerator(name="pk_sequence",sequenceName="hmis_report_line_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pk_sequence")
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "external_id")
	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}



	@Column(name = "report_location")
	public String getReportLocation() {
		return reportLocation;
	}


	public void setReportLocation(String reportLocation) {
		this.reportLocation = reportLocation;
	}

	@Column(name = "request_time")
	public Date getRequestTime() {
		return requestTime;
	}


	public void setRequestTime(Date requestTime) {
		this.requestTime = requestTime;
	}

	@Column(name = "completed_time")
	public Date getCompletedTime() {
		return completedTime;
	}


	public void setCompletedTime(Date completedTime) {
		this.completedTime = completedTime;
	}


	@ManyToOne(optional = false)
	@JoinColumn(name = "REPORT_HEADER_ID", nullable = false, referencedColumnName = "id")
	public ReportHeaderEntity getReportHeaderEntity() {
		return reportHeaderEntity;
	}


	public void setReportHeaderEntity(ReportHeaderEntity reportHeaderEntity) {
		this.reportHeaderEntity = reportHeaderEntity;
	}



	@Column(name = "status")
	public String getStatus() {
		return status;
	}
	

	public void setStatus(String status) {
		this.status = status;
	}

	public void setStatus(ReportStatus status) {
		this.status = status.toString();
	}
	
	@Column(name = "STATUS_MESSAGE")
	public String getStatusMessage() {
		return statusMessage;
	}


	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}


	
}
