package com.servinglynk.hmis.warehouse.restful.model;

import javax.xml.bind.annotation.XmlRootElement;

import com.servinglynk.hmis.warehouse.domain.Person;

@XmlRootElement
public class PersonPagedRequest
{
	private Person person;
	private int firstResult;
	private int maxResults;

	public PersonPagedRequest() {
	}

	public PersonPagedRequest(Person person, int firstResult, int maxResults) {
		this.person = person;
		this.firstResult = firstResult;
		this.maxResults = maxResults;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public int getFirstResult() {
		return firstResult;
	}

	public void setFirstResult(int firstResult) {
		this.firstResult = firstResult;
	}

	public int getMaxResults() {
		return maxResults;
	}

	public void setMaxResults(int maxResults) {
		this.maxResults = maxResults;
	}

	@Override
	public String toString() {
		return "PersonPagedRequest [person=" + person + ", firstResult="
				+ firstResult + ", maxResults=" + maxResults + "]";
	}
}
