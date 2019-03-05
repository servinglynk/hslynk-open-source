package com.servinglynk.hmis.warehouse.enums;
import java.util.Map;
import java.util.HashMap;
/**
 * Defines the HealthStatusHealthCategoryEnum enumeration.
 * 
 * @author Sandeep Dolia
 *
 */
public enum HealthStatusHealthCategoryEnum {

	/** Enum Constant. */
	TWENTY_SEVEN("27"),
	/** Enum Constant. */
	TWENTY_EIGHT("28"),
	/** Enum Constant. */
	TWENTY_NINE("29");
	/**
	 * Internal storage of status field value, see the Enum spec for
 	 * clarification.
 	 */
	private final String status;
	
	/**
	 * Enum constructor for ActiveState.
	 * @param state Value.
	 */
	HealthStatusHealthCategoryEnum(final String state) {
		this.status = state;
	}
	
	/** Construct a map for reverse lookup. */
	private static Map<String, HealthStatusHealthCategoryEnum> valueMap = new HashMap<String, HealthStatusHealthCategoryEnum>();

    static {
    	// construct hashmap for later possible use.
        for (HealthStatusHealthCategoryEnum unit : values()) {
            valueMap.put(unit.getValue(), unit);
        }
    }
    
	/**
	 * Current string value stored in the enum.
	 * 
	 * @return string value.
	 */
	public String getValue() {
		return this.status;
	}

	/**
     * Perform a reverse lookup (given a value, obtain the enum).
     * 
     * @param value to search
     * @return Enum object.
     */
    public static HealthStatusHealthCategoryEnum lookupEnum(String value) {
        return HealthStatusHealthCategoryEnum.valueMap.get(value);
    }

}
