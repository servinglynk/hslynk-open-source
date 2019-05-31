package com.servinglynk.hmis.warehouse.enums;

import java.util.HashMap;
import java.util.Map;

public enum CrisisServicesUseEnum {
	/** Enum Constant. */
	ZERO("0"),
	/** Enum Constant. */
	ONE("1"),
	/** Enum Constant. */
	TWO("2"),
	/** Enum Constant. */
	THREE("3"),
	/** Enum Constant. */
	FOUR("4"),
	/** Enum Constant. */
	FIVE("5"),
	/** Enum Constant. */
	EIGHT("8"),
	/** Enum Constant. */
	NINE("9"),
	/** Enum Constant. */
	NINTY_NINE("99");
	/**
	 * Internal storage of status field value, see the Enum spec for
 	 * clarification.
 	 */
	private final String status;
	
	/**
	 * Enum constructor for ActiveState.
	 * @param state Value.
	 */
	CrisisServicesUseEnum(final String state) {
		this.status = state;
	}
	
	/** Construct a map for reverse lookup. */
	private static Map<String, CrisisServicesUseEnum> valueMap = new HashMap<String, CrisisServicesUseEnum>();

    static {
    	// construct hashmap for later possible use.
        for (CrisisServicesUseEnum unit : values()) {
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
    public static CrisisServicesUseEnum lookupEnum(String value) {
        return CrisisServicesUseEnum.valueMap.get(value);
    }

}
