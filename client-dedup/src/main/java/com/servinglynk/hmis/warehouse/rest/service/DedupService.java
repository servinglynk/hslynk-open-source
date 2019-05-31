package com.servinglynk.hmis.warehouse.rest.service;

import com.servinglynk.hmis.warehouse.domain.Person;
import com.servinglynk.hmis.warehouse.util.AuthenticationRequest;

public interface DedupService {
	public String authenticate(AuthenticationRequest authRequest);
	public Person createUser(Person person,String sessionKey);
	public Person updateUser(Person person, String sessionKey);
	public Person dedupingLogic(Person person,String sessionKey);
	

}
