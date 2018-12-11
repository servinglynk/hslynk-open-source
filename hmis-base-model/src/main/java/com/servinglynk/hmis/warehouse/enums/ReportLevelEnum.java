package com.servinglynk.hmis.warehouse.enums;

import java.util.HashMap;
import java.util.Map;

public enum ReportLevelEnum {
	/** Enum Constant. */
	COC("COC"),
	/** Enum Constant. */
	PROJECT("PROJECT");
	
private final String status;
	
	/**
	 * Enum constructor for ActiveState.
	 * @param state Value.
	 */
ReportLevelEnum(final String state) {
		this.status = state;
	}
	
	/** Construct a map for reverse lookup. */
	private static Map<String, ReportLevelEnum> valueMap = new HashMap<String, ReportLevelEnum>();

    static {
    	// construct hashmap for later possible use.
        for (ReportLevelEnum unit : values()) {
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
    public static ReportLevelEnum lookupEnum(String value) {
        return ReportLevelEnum.valueMap.get(value);
    }
}

