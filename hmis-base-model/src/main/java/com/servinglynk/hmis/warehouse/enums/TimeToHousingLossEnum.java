package com.servinglynk.hmis.warehouse.enums;

import java.util.HashMap;
import java.util.Map;

public enum TimeToHousingLossEnum {
	/** Enum Constant. */
	ZERO("0"),
	/** Enum Constant. */
	ONE("1"),
	/** Enum Constant. */
	TWO("2"),
	/** Enum Constant. */
	THREE("3"),
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
	TimeToHousingLossEnum(final String state) {
		this.status = state;
	}
	
	/** Construct a map for reverse lookup. */
	private static Map<String, TimeToHousingLossEnum> valueMap = new HashMap<String, TimeToHousingLossEnum>();

    static {
    	// construct hashmap for later possible use.
        for (TimeToHousingLossEnum unit : values()) {
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
    public static TimeToHousingLossEnum lookupEnum(String value) {
        return TimeToHousingLossEnum.valueMap.get(value);
    }

}
