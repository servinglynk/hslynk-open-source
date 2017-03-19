package com.servinglynk.hmis.warehouse.domain;

import java.io.Serializable;

/**
 * LinkSource entity.
 * 
 */
public class LinkSource extends BaseObject implements Serializable
{
	private static final long serialVersionUID = -6737992702585965810L;
	public static final Integer MANUAL_MATCHING_SOURCE = 1;
	public static final Integer EXACT_MATCHING_ALGORITHM_SOURCE = 2;
	public static final Integer PROBABILISTIC_MATCHING_ALGORITHM_SOURCE = 3;
	
	private Integer linkSourceId;
	private String sourceName;
	private String sourceDescription;

	public LinkSource() {
	}

	public LinkSource(Integer linkSourceId) {
		this.linkSourceId = linkSourceId;
	}

	public Integer getLinkSourceId() {
		return linkSourceId;
	}

	public void setLinkSourceId(Integer linkSourceId) {
		this.linkSourceId = linkSourceId;
	}

	public String getSourceName() {
		return sourceName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	public String getSourceDescription() {
		return sourceDescription;
	}

	public void setSourceDescription(String sourceDescription) {
		this.sourceDescription = sourceDescription;
	}

	@Override
	public String toString() {
		return "LinkSource [linkSourceId=" + linkSourceId + ", sourceName=" + sourceName + ", sourceDescription="
				+ sourceDescription + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LinkSource other = (LinkSource) obj;
		if (linkSourceId == null) {
			if (other.linkSourceId != null)
				return false;
		} else if (!linkSourceId.equals(other.linkSourceId))
			return false;
		if (sourceDescription == null) {
			if (other.sourceDescription != null)
				return false;
		} else if (!sourceDescription.equals(other.sourceDescription))
			return false;
		if (sourceName == null) {
			if (other.sourceName != null)
				return false;
		} else if (!sourceName.equals(other.sourceName))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((linkSourceId == null) ? 0 : linkSourceId.hashCode());
		result = prime * result + ((sourceDescription == null) ? 0 : sourceDescription.hashCode());
		result = prime * result + ((sourceName == null) ? 0 : sourceName.hashCode());
		return result;
	}
}
