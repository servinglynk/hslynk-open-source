package com.servinglynk.hmis.warehouse.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * Race entity.
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class Race extends BaseObject implements java.io.Serializable
{
	private static final long serialVersionUID = -6599300349364875923L;

	private Integer raceCd;
	private String raceName;
	private String raceDescription;
	private String raceCode;
	
	/** default constructor */
	public Race() {
	}

	/** minimal constructor */
	public Race(Integer raceCd, String raceName) {
		this.raceCd = raceCd;
		this.raceName = raceName;
	}

	/** full constructor */
	public Race(Integer raceCd, String raceName, String raceDescription) {
		this.raceCd = raceCd;
		this.raceName = raceName;
		this.raceDescription = raceDescription;
	}

	@XmlElement
	public Integer getRaceCd() {
		return this.raceCd;
	}

	public void setRaceCd(Integer raceCd) {
		this.raceCd = raceCd;
	}

	@XmlElement
	public String getRaceName() {
		return this.raceName;
	}

	public void setRaceName(String raceName) {
		this.raceName = raceName;
	}

	@XmlElement
	public String getRaceDescription() {
		return this.raceDescription;
	}

	public void setRaceDescription(String raceDescription) {
		this.raceDescription = raceDescription;
	}

	@XmlElement
	public String getRaceCode() {
		return raceCode;
	}

	public void setRaceCode(String raceCode) {
		this.raceCode = raceCode;
	}

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof Race))
			return false;
		Race castOther = (Race) other;
		return new EqualsBuilder().append(raceCd, castOther.raceCd).append(raceName, castOther.raceName).append(
				raceDescription, castOther.raceDescription).append(raceCode, castOther.raceCode).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(raceCd).append(raceName).append(raceDescription).append(raceCode)
				.toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("raceCd", raceCd).append("raceName", raceName).append(
				"raceDescription", raceDescription).append("raceCode", raceCode).toString();
	}

}