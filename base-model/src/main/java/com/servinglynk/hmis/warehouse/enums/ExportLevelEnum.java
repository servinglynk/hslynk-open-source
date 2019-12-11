package com.servinglynk.hmis.warehouse.enums;

import java.util.HashMap;
import java.util.Map;

public enum ExportLevelEnum {
	/** Enum Constant. */
	COC("COC"),
	/** Enum Constant. */
	PROJECT("PROJECT");
	
private final String status;
	
	/**
	 * Enum constructor for ActiveState.
	 * @param state Value.
	 */
ExportLevelEnum(final String state) {
		this.status = state;
	}
	
	/** Construct a map for reverse lookup. */
	private static Map<String, ExportLevelEnum> valueMap = new HashMap<String, ExportLevelEnum>();

    static {
    	// construct hashmap for later possible use.
        for (ExportLevelEnum unit : values()) {
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
    public static ExportLevelEnum lookupEnum(String value) {
        return ExportLevelEnum.valueMap.get(value);
    }
}

