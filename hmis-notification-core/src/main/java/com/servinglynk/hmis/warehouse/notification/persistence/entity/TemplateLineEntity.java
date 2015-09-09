package com.servinglynk.hmis.warehouse.notification.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;



@Entity
@Table(name = "HMIS_TEMPLATE_LINE" )
public class TemplateLineEntity extends ParentEntity {

	
	private Long id;
	private TemplateHeaderEntity templateHeader;
	private int version;
	private String externalId;
	private String location;
	private String subject;
	
	@Id
	@SequenceGenerator(name="pk_sequence",sequenceName="hmis_template_line_id_seq", allocationSize=1)
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

	@ManyToOne(optional = false)
	@JoinColumn(name = "TEMPLATE_HEADER_ID", nullable = false, referencedColumnName = "id")
	public TemplateHeaderEntity getTemplateHeader() {
		return templateHeader;
	}


	public void setTemplateHeader(TemplateHeaderEntity templateHeader) {
		this.templateHeader = templateHeader;
	}


	@Column(name = "version")
	public int getVersion() {
		return version;
	}



	public void setVersion(int version) {
		this.version = version;
	}

	@Column(name = "body_location")
	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}

	@Column(name = "subject")
	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	


	
}
