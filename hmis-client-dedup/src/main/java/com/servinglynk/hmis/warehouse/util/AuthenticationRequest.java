package com.servinglynk.hmis.warehouse.util;

import com.fasterxml.jackson.annotation.JsonRootName;
@JsonRootName("AuthenticationRequest")
public class AuthenticationRequest
{
	private String username;
	private String password;
	
	public AuthenticationRequest() {
	}
		
	public AuthenticationRequest(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "AuthenticationRequest [username=" + username + ", password="
				+ password + "]";
	}
}
