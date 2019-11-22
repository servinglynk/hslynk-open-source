package com.servinglynk.hmis.warehouse.common.security;

import java.util.Collection;
import java.util.UUID;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class LoggedInUser implements UserDetails  {
	
	private String username;
	private String projectGroup;
	private UUID profileId;
	private UUID userId;
	private Boolean checkProjectGroup = true;
	public LoggedInUser(String username, String projectGroup,UUID profileId,UUID userId) {
		super();
		this.username = username;
		this.projectGroup = projectGroup;
		this.profileId = profileId;
		this.userId = userId;
	}

	public LoggedInUser(String username, String projectGroup, UUID profileId, UUID userId, Boolean checkProjectGroup) {
		super();
		this.username = username;
		this.projectGroup = projectGroup;
		this.profileId = profileId;
		this.userId = userId;
		this.checkProjectGroup = checkProjectGroup;
	}

	public Boolean getCheckProjectGroup() {
		return checkProjectGroup;
	}
	public void setCheckProjectGroup(Boolean checkProjectGroup) {
		this.checkProjectGroup = checkProjectGroup;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return null;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public String getProjectGroup() {
		return projectGroup;
	}

	public void setProjectGroup(String projectGroup) {
		this.projectGroup = projectGroup;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public UUID getProfileId() {
		return profileId;
	}

	public void setProfileId(UUID profileId) {
		this.profileId = profileId;
	}

	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}
}