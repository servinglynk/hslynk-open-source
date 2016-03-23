package com.servinglynk.hmis.warehouse.domain;


/**
 * AuditEventType entity.
 * 
 */
public class MessageType extends BaseObject implements java.io.Serializable
{
	private static final long serialVersionUID = 6170253797278224912L;

	public static final String UNKNOWN_MESSAGE_TYPE_CODE = "UNKNOWN";
	
	private Integer messageTypeCd;
	private String messageTypeName;
	private String messageTypeDescription;
	private String messageTypeCode;
	
	/** default constructor */
	public MessageType() {
	}

	public Integer getMessageTypeCd() {
		return messageTypeCd;
	}

	public void setMessageTypeCd(Integer messageTypeCd) {
		this.messageTypeCd = messageTypeCd;
	}

	public String getMessageTypeName() {
		return messageTypeName;
	}

	public void setMessageTypeName(String messageTypeName) {
		this.messageTypeName = messageTypeName;
	}

	public String getMessageTypeDescription() {
		return messageTypeDescription;
	}

	public void setMessageTypeDescription(String messageTypeDescription) {
		this.messageTypeDescription = messageTypeDescription;
	}

	public String getMessageTypeCode() {
		return messageTypeCode;
	}

	public void setMessageTypeCode(String messageTypeCode) {
		this.messageTypeCode = messageTypeCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((messageTypeCd == null) ? 0 : messageTypeCd.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MessageType other = (MessageType) obj;
		if (messageTypeCd == null) {
			if (other.messageTypeCd != null)
				return false;
		} else if (!messageTypeCd.equals(other.messageTypeCd))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MessageType [messageTypeCd=" + messageTypeCd + ", messageTypeName=" + messageTypeName
				+ ", messageTypeDescription=" + messageTypeDescription + ", messageTypeCode=" + messageTypeCode + "]";
	}
}