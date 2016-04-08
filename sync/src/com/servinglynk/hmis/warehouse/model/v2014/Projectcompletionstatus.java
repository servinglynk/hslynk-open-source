package com.servinglynk.hmis.warehouse.model.v2014;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Projectcompletionstatus extends BaseModel{

	@Column(name = "earlyexitreason")
	private String earlyexitreason;
	@Column(name = "exitid")			
	private UUID exitid;
	@Column(name = "projectcompletionstatus")
	private String projectcompletionstatus;
	/**
	 * @return the earlyexitreason
	 */
	public String getEarlyexitreason() {
		return earlyexitreason;
	}
	/**
	 * @param earlyexitreason the earlyexitreason to set
	 */
	public void setEarlyexitreason(String earlyexitreason) {
		this.earlyexitreason = earlyexitreason;
	}
	/**
	 * @return the exitid
	 */
	public UUID getExitid() {
		return exitid;
	}
	/**
	 * @param exitid the exitid to set
	 */
	public void setExitid(UUID exitid) {
		this.exitid = exitid;
	}
	/**
	 * @return the projectcompletionstatus
	 */
	public String getProjectcompletionstatus() {
		return projectcompletionstatus;
	}
	/**
	 * @param projectcompletionstatus the projectcompletionstatus to set
	 */
	public void setProjectcompletionstatus(String projectcompletionstatus) {
		this.projectcompletionstatus = projectcompletionstatus;
	}
	
	
}
