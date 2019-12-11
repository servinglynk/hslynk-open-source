package com.servinglynk.hmis.warehouse.enums;

import java.util.HashMap;
import java.util.Map;

public enum ExportTypeEnum {
	/** Enum Constant. */
	HMIS("HMIS"),
	/** Enum Constant. */
	GENERIC("GENERIC");
	
private final String status;
	
	/**
	 * Enum constructor for ActiveState.
	 * @param state Value.
	 */
ExportTypeEnum(final String state) {
		this.status = state;
	}
	
	/** Construct a map for reverse lookup. */
	private static Map<String, ExportTypeEnum> valueMap = new HashMap<String, ExportTypeEnum>();

    static {
    	// construct hashmap for later possible use.
        for (ExportTypeEnum unit : values()) {
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
    public static ExportTypeEnum lookupEnum(String value) {
        return ExportTypeEnum.valueMap.get(value);
    }
}
