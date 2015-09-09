package com.servinglynk.hmis.warehouse.domain;

import java.beans.Transient;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.NONE)
public class User extends BaseObject implements Serializable
{
    private static final long serialVersionUID = 3832626162173359411L;

    private Long id;
    private String username;                    // required
    private String password;                    // required
    private String confirmPassword;
    private String passwordHint;
    private String firstName;                   // required
    private String lastName;                    // required
    private String email;                       // required; unique
    private String phoneNumber;
    private String website;
    private Address address = new Address();
    private Integer version;
    private Set<Role> roles = new HashSet<Role>();
    private boolean enabled;
    private boolean accountExpired;
    private boolean accountLocked;
    private boolean credentialsExpired;

    /**
     * Default constructor - creates a new instance with no values set.
     */
    public User() {}

    /**
     * Create a new instance and set the username.
     * @param username login name for user.
     */
    public User(final String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    @XmlElement
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Transient
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public String getPasswordHint() {
        return passwordHint;
    }

    @XmlElement
    public String getFirstName() {
        return firstName;
    }

    @XmlElement
    public String getLastName() {
        return lastName;
    }

    @XmlElement
    public String getEmail() {
        return email;
    }

    @XmlElement
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @XmlElement
    public String getWebsite() {
        return website;
    }

    /**
     * Returns the full name.
     * @return firstName + ' ' + lastName
     */
    @Transient
    public String getFullName() {
        return firstName + ' ' + lastName;
    }

    @XmlElement
    public Address getAddress() {
        return address;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    /**
     * Convert user roles to LabelValue objects for convenience.
     * @return a list of LabelValue objects with role information
     */
    @Transient
    public List<LabelValue> getRoleList() {
        List<LabelValue> userRoles = new ArrayList<LabelValue>();

        if (this.roles != null) {
            for (Role role : roles) {
                // convert the user's roles to LabelValue Objects
                userRoles.add(new LabelValue(role.getName(), role.getName()));
            }
        }

        return userRoles;
    }

    /**
     * Adds a role for the user
     * @param role the fully instantiated role
     */
    public void addRole(Role role) {
        getRoles().add(role);
    }
    
    public void removeRole(String roleName) {
    	Role roleToRemove = null;
    	for (Role role : getRoles()) {
    		if (role.getName().equalsIgnoreCase(roleName)) {
    			roleToRemove=role;
    			break;
    		}
    	}
    	if (roleToRemove != null) {
    		getRoles().remove(roleToRemove);
    	}
    }
    
    /**
     * @see org.springframework.security.userdetails.UserDetails#getAuthorities()
     * @return GrantedAuthority[] an array of roles.
     */
  
    public Integer getVersion() {
        return version;
    }
    
    @XmlElement
    public boolean isEnabled() {
        return enabled;
    }
    
    @XmlElement
    public boolean isAccountExpired() {
        return accountExpired;
    }
    
    /**
     * @see org.springframework.security.userdetails.UserDetails#isAccountNonExpired()
     */
    @Transient
    public boolean isAccountNonExpired() {
        return !isAccountExpired();
    }

    @XmlElement
    public boolean isAccountLocked() {
        return accountLocked;
    }
    
    /**
     * @see org.springframework.security.userdetails.UserDetails#isAccountNonLocked()
     */
    @Transient
    public boolean isAccountNonLocked() {
        return !isAccountLocked();
    }

    @XmlElement
    public boolean isCredentialsExpired() {
        return credentialsExpired;
    }
    
    /**
     * @see org.springframework.security.userdetails.UserDetails#isCredentialsNonExpired()
     */
    @Transient
    public boolean isCredentialsNonExpired() {
        return !credentialsExpired;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public void setPasswordHint(String passwordHint) {
        this.passwordHint = passwordHint;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
    
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setAccountExpired(boolean accountExpired) {
        this.accountExpired = accountExpired;
    }
    
    public void setAccountLocked(boolean accountLocked) {
        this.accountLocked = accountLocked;
    }

    public void setCredentialsExpired(boolean credentialsExpired) {
        this.credentialsExpired = credentialsExpired;
    }
    
    /**
     * {@inheritDoc}
     */
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }

        final User user = (User) o;

        return !(username != null ? !username.equals(user.getUsername()) : user.getUsername() != null);

    }

    /**
     * {@inheritDoc}
     */
    public int hashCode() {
        return (username != null ? username.hashCode() : 0);
    }

	@Override
	public String toString() {
		return "User [username=" + username + ", firstName=" + firstName + ", lastName=" + lastName + ", enabled="
				+ enabled + ", accountExpired=" + accountExpired + ", accountLocked=" + accountLocked + "]";
	}

}
