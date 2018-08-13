package com.servinglynk.hmis.warehouse;

public class DedupClientDob {

	private String dedupClientId;
	private int age;
	
	public DedupClientDob(String dedupClientId, int age) {
		super();
		this.dedupClientId = dedupClientId;
		this.age = age;
	}
	/**
	 * @return the dedupClientId
	 */
	public String getDedupClientId() {
		return dedupClientId;
	}
	/**
	 * @param dedupClientId the dedupClientId to set
	 */
	public void setDedupClientId(String dedupClientId) {
		this.dedupClientId = dedupClientId;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
}
