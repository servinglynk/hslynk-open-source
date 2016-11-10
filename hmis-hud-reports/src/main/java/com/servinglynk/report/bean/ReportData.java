package com.servinglynk.report.bean;

import java.util.ArrayList;
import java.util.List;

public class ReportData {
	private List<ClientModel> clients = new ArrayList<ClientModel>();
	private List<EnrollmentModel> enrollments = new ArrayList<EnrollmentModel>();
	private List<ExitModel> exits = new ArrayList<ExitModel>();
	/**
	 * @return the clients
	 */
	public List<ClientModel> getClients() {
		return clients;
	}
	/**
	 * @param clients the clients to set
	 */
	public void setClients(List<ClientModel> clients) {
		this.clients = clients;
	}
	/**
	 * @return the enrollments
	 */
	public List<EnrollmentModel> getEnrollments() {
		return enrollments;
	}
	/**
	 * @param enrollments the enrollments to set
	 */
	public void setEnrollments(List<EnrollmentModel> enrollments) {
		this.enrollments = enrollments;
	}
	/**
	 * @return the exits
	 */
	public List<ExitModel> getExits() {
		return exits;
	}
	/**
	 * @param exits the exits to set
	 */
	public void setExits(List<ExitModel> exits) {
		this.exits = exits;
	}
}
