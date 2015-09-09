package com.servinglynk.hmis.warehouse.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * AuditEventType entity.
 * 
 */
public class AuditEventType extends BaseObject implements java.io.Serializable
{
	private static final long serialVersionUID = 6170253797278224912L;
	
	public static final String ADD_PERSON_EVENT_TYPE = "ADD";
	public static final String DELETE_PERSON_EVENT_TYPE = "DEL";
	public static final String IMPORT_PERSON_EVENT_TYPE = "IMP";
	public static final String LINK_PERSONS_EVENT_TYPE = "LNK";
	public static final String MERGE_PERSON_EVENT_TYPE = "MRG";
	public static final String UNLINK_PERSONS_EVENT_TYPE = "ULK";
	public static final String UNMERGE_PERSON_EVENT_TYPE = "UMG";
	public static final String UPDATE_PERSON_EVENT_TYPE = "UPD";
	public static final String ADD_IDENTIFIER_DOMAIN_ATTRIBUTE_EVENT_TYPE = "AIA";
	public static final String OBTAIN_UNIQUE_IDENTIFIER_DOMAIN_EVENT_TYPE = "OID";
	public static final String DELETE_IDENTIFIER_DOMAIN_ATTRIBUTE_EVENT_TYPE = "DID";
	public static final String UPDATE_IDENTIFIER_DOMAIN_ATTRIBUTE_EVENT_TYPE = "UID";
	
	private Integer auditEventTypeCd;
	private String auditEventTypeName;
	private String auditEventTypeDescription;
	private String auditEventTypeCode;
	
	/** default constructor */
	public AuditEventType() {
	}

	/** minimal constructor */
	public AuditEventType(Integer auditEventTypeCd, String auditEventTypeName) {
		this.auditEventTypeCd = auditEventTypeCd;
		this.auditEventTypeName = auditEventTypeName;
	}

	/** full constructor */
	public AuditEventType(Integer auditEventTypeCd, String auditEventTypeName, String auditEventTypeDescription) {
		this.auditEventTypeCd = auditEventTypeCd;
		this.auditEventTypeName = auditEventTypeName;
		this.auditEventTypeDescription = auditEventTypeDescription;
	}

	public Integer getAuditEventTypeCd() {
		return this.auditEventTypeCd;
	}

	public void setAuditEventTypeCd(Integer auditEventTypeCd) {
		this.auditEventTypeCd = auditEventTypeCd;
	}

	public String getAuditEventTypeName() {
		return this.auditEventTypeName;
	}

	public void setAuditEventTypeName(String auditEventTypeName) {
		this.auditEventTypeName = auditEventTypeName;
	}

	public String getAuditEventTypeDescription() {
		return this.auditEventTypeDescription;
	}

	public void setAuditEventTypeDescription(String auditEventTypeDescription) {
		this.auditEventTypeDescription = auditEventTypeDescription;
	}

	public String getAuditEventTypeCode() {
		return auditEventTypeCode;
	}

	public void setAuditEventTypeCode(String auditEventTypeCode) {
		this.auditEventTypeCode = auditEventTypeCode;
	}

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof AuditEventType))
			return false;
		AuditEventType castOther = (AuditEventType) other;
		return new EqualsBuilder().append(auditEventTypeCd, castOther.auditEventTypeCd)
				.append(auditEventTypeName, castOther.auditEventTypeName)
				.append(auditEventTypeDescription, castOther.auditEventTypeDescription)
				.append(auditEventTypeCode, castOther.auditEventTypeCode).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(auditEventTypeCd).append(auditEventTypeName).append(auditEventTypeDescription).append(
				auditEventTypeCode).toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("auditEventTypeCd", auditEventTypeCd).append("auditEventTypeName", auditEventTypeName).append(
				"auditEventTypeDescription", auditEventTypeDescription).append("auditEventTypeCode", auditEventTypeCode).toString();
	}
}