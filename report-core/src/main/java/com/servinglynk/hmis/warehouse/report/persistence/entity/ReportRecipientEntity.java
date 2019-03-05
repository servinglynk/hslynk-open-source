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
@Table(name = "HMIS_REPORT_RECIPIENT" )
public class ReportRecipientEntity  extends ParentEntity {

	
	private Long id;
	private ReportHeaderEntity reportHeaderEntity;
	private String externalId;
	private String recipentEmail;

	
	@Id
	@SequenceGenerator(name="pk_sequence",sequenceName="hmis_report_recipient_id_seq", allocationSize=1)
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



	@Column(name = "recipient_email")
	public String getRecipentEmail() {
		return recipentEmail;
	}


	public void setRecipentEmail(String recipentEmail) {
		this.recipentEmail = recipentEmail;
	}


	@ManyToOne(optional = false)
	@JoinColumn(name = "REPORT_HEADER_ID", nullable = false, referencedColumnName = "id")
	public ReportHeaderEntity getReportHeaderEntity() {
		return reportHeaderEntity;
	}


	public void setReportHeaderEntity(ReportHeaderEntity reportHeaderEntity) {
		this.reportHeaderEntity = reportHeaderEntity;
	}




	
}
