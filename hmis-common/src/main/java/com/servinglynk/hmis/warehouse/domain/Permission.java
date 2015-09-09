package com.servinglynk.hmis.warehouse.domain;

import java.io.Serializable;

/**
 * Permission entity.
 * 
 */
public class Permission extends BaseObject implements Serializable
{
	private static final long serialVersionUID = 3690197650654049848L;
	
	public final static String RECORD_ADD = "RECORD_ADD";
	public final static String RECORD_DELETE = "RECORD_DELETE";
	public final static String RECORD_EDIT = "RECORD_EDIT";
	public final static String RECORD_VIEW = "RECORD_VIEW";
	public final static String IDENTIFIER_DOMAIN_ADD = "IDENTIFIER_DOMAIN_ADD";
	public final static String IDENTIFIER_DOMAIN_DELETE = "IDENTIFIER_DOMAIN_DELETE";
	public final static String IDENTIFIER_DOMAIN_EDIT = "IDENTIFIER_DOMAIN_EDIT";
	public final static String IDENTIFIER_DOMAIN_VIEW = "IDENTIFIER_DOMAIN_VIEW";
	public final static String RECORD_LINKS_REVIEW = "RECORD_LINKS_REVIEW";
	public final static String REPORT_GENERATE = "REPORT_GENERATE";
	public final static String REPORT_VIEW = "REPORT_VIEW";
	public final static String CUSTOM_FIELDS_CONFIGURE = "CUSTOM_FIELDS_CONFIGURE";
	public final static String BLOCKING_CONFIGURE = "BLOCKING_CONFIGURE";
	public final static String MATCHING_CONFIGURE = "MATCHING_CONFIGURE";
	public final static String FILE_IMPORT = "FILE_IMPORT";
	public final static String USER_ADD = "USER_ADD";
	public final static String USER_DELETE = "USER_DELETE";
	public final static String USER_EDIT = "USER_EDIT";
	public final static String USER_VIEW = "USER_VIEW";
	public final static String EVENT_CONFIGURATION_EDIT = "EVENT_CONFIGURATION_EDIT";
	public final static String GLOBAL_IDENTIFIERS_EDIT = "GLOBAL_IDENTIFIERS_EDIT";
	public final static String PIXPDQ_MANAGE = "PIXPDQ_MANAGE";
	  
	private Integer permissionId;
	private String name;
	private String description;

    /**
     * Default constructor - creates a new instance with no values set.
     */
    public Permission() {
    }
    
    public Permission(int permissionId, String name, String description) {
    	this.permissionId = permissionId;
    	this.name = name;
    	this.description = description;
    }

	public Integer getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(Integer permissionId) {
		this.permissionId = permissionId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuthority() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((permissionId == null) ? 0 : permissionId.hashCode());
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
		Permission other = (Permission) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (permissionId == null) {
			if (other.permissionId != null)
				return false;
		} else if (!permissionId.equals(other.permissionId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Permission [permissionId=" + permissionId + ", name=" + name + ", description=" + description + "]";
	}

	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
