package com.servinglynk.hmis.warehouse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.thoughtworks.xstream.annotations.XStreamAlias;
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
@XStreamAlias("AuthenticationRequest")
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
