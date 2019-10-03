package com.servinglynk.hmis.warehouse.enums;

import java.util.HashMap;
import java.util.Map;

public enum PrioritizationStatusEnum {
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
	PrioritizationStatusEnum(final String state) {
		this.status = state;
	}
	
	/** Construct a map for reverse lookup. */
	private static Map<String, PrioritizationStatusEnum> valueMap = new HashMap<String, PrioritizationStatusEnum>();

    static {
    	// construct hashmap for later possible use.
        for (PrioritizationStatusEnum unit : values()) {
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
    public static PrioritizationStatusEnum lookupEnum(String value) {
        return PrioritizationStatusEnum.valueMap.get(value);
    }

}
