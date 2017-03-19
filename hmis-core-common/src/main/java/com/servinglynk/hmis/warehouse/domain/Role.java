package com.servinglynk.hmis.warehouse.domain;

import java.io.Serializable;
import java.util.Set;

/**
 * This class is used to represent available roles in the database.
 *
 */
public class Role extends BaseObject implements Serializable
{
	private static final long serialVersionUID = 3690197650654049848L;
    private Long id;
    private String name;
    private String description;
    private Set<Permission> permissions;
    
    /**
     * Default constructor - creates a new instance with no values set.
     */
    public Role() {
    	permissions = new java.util.HashSet<Permission>();
    }

    /**
     * Create a new instance and set the name.
     * @param name name of the role.
     */
    public Role(final String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public Set<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}

	public void addPermission(Permission permission) {
		permissions.add(permission);
	}
    
    public void removePermission(String permissionName) {
    	Permission permToRemove = null;
    	for (Permission permission : getPermissions()) {
    		if (permission.getName().equalsIgnoreCase(permissionName)) {
    			permToRemove=permission;
    			break;
    		}
    	}
    	if (permToRemove != null) {
    		getPermissions().remove(permToRemove);
    	}
    }
	
    /**
     * {@inheritDoc}
     */
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Role)) {
            return false;
        }

        final Role role = (Role) o;

        return !(name != null ? !name.equals(role.name) : role.name != null);

    }

    /**
     * {@inheritDoc}
     */
    public int hashCode() {
        return (name != null ? name.hashCode() : 0);
    }

	public int compareTo(Object o) {
        return (equals(o) ? 0 : -1);
    }

    @Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", description=" + description + ", permissions=" + permissions
				+ "]";
	}
}
