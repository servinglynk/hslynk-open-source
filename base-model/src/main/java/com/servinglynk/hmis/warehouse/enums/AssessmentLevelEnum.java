package com.servinglynk.hmis.warehouse.enums;

import java.util.HashMap;
import java.util.Map;

public enum AssessmentLevelEnum {
	/** Enum Constant. */
	ONE("1"),
	/** Enum Constant. */
	TWO("2");
	/**
	 * Internal storage of status field value, see the Enum spec for
 	 * clarification.
 	 */
	private final String status;
	
	/**
	 * Enum constructor for ActiveState.
	 * @param state Value.
	 */
	AssessmentLevelEnum(final String state) {
		this.status = state;
	}
	
	/** Construct a map for reverse lookup. */
	private static Map<String, AssessmentLevelEnum> valueMap = new HashMap<String, AssessmentLevelEnum>();

    static {
    	// construct hashmap for later possible use.
        for (AssessmentLevelEnum unit : values()) {
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
    public static AssessmentLevelEnum lookupEnum(String value) {
        return AssessmentLevelEnum.valueMap.get(value);
    }

}
