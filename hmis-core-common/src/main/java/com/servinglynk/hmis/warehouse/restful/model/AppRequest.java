package com.servinglynk.hmis.warehouse.restful.model;

import javax.xml.bind.annotation.XmlRootElement;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XmlRootElement
public class AppRequest {
	@XStreamAlias("AuthenticationRequest")
	private AuthenticationRequest AuthenticationRequest;

	public AuthenticationRequest getAuthenticationRequest() {
		return AuthenticationRequest;
	}

	public void setAuthenticationRequest(AuthenticationRequest authenticationRequest) {
		AuthenticationRequest = authenticationRequest;
	}

	
	
}
