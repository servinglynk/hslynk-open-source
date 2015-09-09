
package com.servinglynk.hmis.warehouse.domain;

import java.beans.Transient;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class DataProfileAttribute extends BaseObject
{
	private static final long serialVersionUID = -5805814946755578692L;

	public static final int INTEGER_DATA_TYPE = 0;
	public static final int STRING_DATA_TYPE = 1;
	public static final int DATE_DATA_TYPE = 2;
	public static final int LONG_DATA_TYPE = 3;
	public static final int FLOAT_DATA_TYPE = 4;
	public static final int DOUBLE_DATA_TYPE = 5;
	
	private Integer attributeId;
	private String attributeName;
	private Integer datatypeId;
	private Double averageLength;
	private Integer minimumLength;
	private Integer maximumLength;
	private Double averageValue;
	private Double minimumValue;
	private Double maximumValue;
	private Double variance;
	private Double standardDeviation;
	private Integer rowCount;
	private Integer distinctCount;
	private Integer duplicateCount;
	private Integer uniqueCount;
	private Integer nullCount;
	private Double nullRate;
	private Double entropy;
	private Double maximumEntropy;
	private Double uValue;
	private Double averageTokenFrequency;
	private Integer blockingPairs;
	private Integer dataSourceId;

	private Set<DataProfileAttributeValue> attributeValues = new HashSet<DataProfileAttributeValue>();

	public DataProfileAttribute() {
	}
	
	public DataProfileAttribute(Integer attributeId) {
		this.attributeId = attributeId;
	}
	
	public DataProfileAttribute(String attributeName, int datatypeId) {
		this.attributeName = attributeName;
		this.datatypeId = dataSourceId;
	}
	
	public DataProfileAttribute(Integer attributeId, Integer datatypeId) {
		this.attributeId = attributeId;
		this.datatypeId = datatypeId;
	}
	
	@XmlElement
	public Integer getAttributeId() {
		return attributeId;
	}

	public void setAttributeId(Integer attributeId) {
		this.attributeId = attributeId;
	}

	@XmlElement
	public String getAttributeName() {
		return attributeName;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}

	@XmlElement
	public Integer getDatatypeId() {
		return datatypeId;
	}

	public void setDatatypeId(Integer datatypeId) {
		this.datatypeId = datatypeId;
	}

	@XmlElement
	public Double getAverageLength() {
		return averageLength;
	}

	public void setAverageLength(Double averageLength) {
		this.averageLength = averageLength;
	}

	@XmlElement
	public Integer getMinimumLength() {
		return minimumLength;
	}

	public void setMinimumLength(Integer minimumLength) {
		this.minimumLength = minimumLength;
	}

	@XmlElement
	public Integer getMaximumLength() {
		return maximumLength;
	}

	public void setMaximumLength(Integer maximumLength) {
		this.maximumLength = maximumLength;
	}

	@XmlElement
	public Double getAverageValue() {
		return averageValue;
	}

	public void setAverageValue(Double averageValue) {
		this.averageValue = averageValue;
	}

	@XmlElement
	public Double getMinimumValue() {
		return minimumValue;
	}

	public void setMinimumValue(Double minimumValue) {
		this.minimumValue = minimumValue;
	}

	@XmlElement
	public Double getMaximumValue() {
		return maximumValue;
	}

	public void setMaximumValue(Double maximumValue) {
		this.maximumValue = maximumValue;
	}

	@XmlElement
	public Double getVariance() {
		return variance;
	}

	public void setVariance(Double variance) {
		this.variance = variance;
	}

	@XmlElement
	public Double getStandardDeviation() {
		return standardDeviation;
	}

	public void setStandardDeviation(Double standardDeviation) {
		this.standardDeviation = standardDeviation;
	}

	@XmlElement
	public Integer getRowCount() {
		return rowCount;
	}

	public void setRowCount(Integer rowCount) {
		this.rowCount = rowCount;
	}

	@XmlElement
	public Integer getDistinctCount() {
		return distinctCount;
	}

	public void setDistinctCount(Integer distinctCount) {
		this.distinctCount = distinctCount;
	}

	@XmlElement
	public Integer getDuplicateCount() {
		return duplicateCount;
	}

	public void setDuplicateCount(Integer duplicateCount) {
		this.duplicateCount = duplicateCount;
	}

	@XmlElement
	public Integer getUniqueCount() {
		return uniqueCount;
	}

	public void setUniqueCount(Integer uniqueCount) {
		this.uniqueCount = uniqueCount;
	}

	@XmlElement
	public Integer getNullCount() {
		return nullCount;
	}

	public void setNullCount(Integer nullCount) {
		this.nullCount = nullCount;
	}
	
	@XmlElement
	public Double getNullRate() {
		return nullRate;
	}

	public void setNullRate(Double nullRate) {
		this.nullRate = nullRate;
	}

	@XmlElement
	public Double getEntropy() {
		return entropy;
	}

	public void setEntropy(Double entropy) {
		this.entropy = entropy;
	}

	@XmlElement
	public Double getMaximumEntropy() {
		return maximumEntropy;
	}

	public void setMaximumEntropy(Double maximumEntropy) {
		this.maximumEntropy = maximumEntropy;
	}

	@XmlElement
	public Double getuValue() {
		return uValue;
	}

	public void setuValue(Double uValue) {
		this.uValue = uValue;
	}

	@XmlElement
	public Double getAverageTokenFrequency() {
		return averageTokenFrequency;
	}

	public void setAverageTokenFrequency(Double averageTokenFrequency) {
		this.averageTokenFrequency = averageTokenFrequency;
	}

	@XmlElement
	public Integer getBlockingPairs() {
		return blockingPairs;
	}

	public void setBlockingPairs(Integer blockingPairs) {
		this.blockingPairs = blockingPairs;
	}

	@XmlElement
	public Integer getDataSourceId() {
		return dataSourceId;
	}

	public void setDataSourceId(Integer dataSourceId) {
		this.dataSourceId = dataSourceId;
	}
	
	@Transient
	public Set<DataProfileAttributeValue> getAttributeValues() {
		return attributeValues;
	}

	public void setAttributeValues(Set<DataProfileAttributeValue> attributeValues) {
		this.attributeValues = attributeValues;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DataProfileAttribute other = (DataProfileAttribute) obj;
		if (attributeId == null) {
			if (other.attributeId != null)
				return false;
		} else if (!attributeId.equals(other.attributeId))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((attributeId == null) ? 0 : attributeId.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "DataProfileAttribute [attributeId=" + attributeId + "attributeName=" + attributeName + ", datatypeId=" + datatypeId + ", averageLength="
				+ averageLength + ", minimumLength=" + minimumLength + ", maximumLength=" + maximumLength
				+ ", averageValue=" + averageValue + ", minimumValue=" + minimumValue + ", maximumValue="
				+ maximumValue + ", variance=" + variance + ", standardDeviation=" + standardDeviation 
				+ ", rowCount=" + rowCount
				+ ", distinctCount=" + distinctCount + ", duplicateCount=" + duplicateCount + ", uniqueCount="
				+ uniqueCount + ", nullCount=" + nullCount + ", dataSourceId=" + dataSourceId + ", attributeValues="
				+ attributeValues + "]";
	}

}
