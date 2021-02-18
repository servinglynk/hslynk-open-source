package com.servinglynk.hmis.warehouse.enums;

import java.util.HashMap;
import java.util.Map;

public enum ReportTypeEnum {
	/** Enum Constant. */
	APR("APR"),
	/** Enum Constant. */
	AHAR("AHAR"),
	/** Enum Constant. */
	LSA("LSA"),
	/** Enum Constant. */
	SPM("SPM"),
	/** Enum Constant. */
	CAPER("CAPER");
	
private final String status;
	
	/**
	 * Enum constructor for ActiveState.
	 * @param state Value.
	 */
ReportTypeEnum(final String state) {
		this.status = state;
	}
	
	/** Construct a map for reverse lookup. */
	private static Map<String, ReportTypeEnum> valueMap = new HashMap<String, ReportTypeEnum>();

    static {
    	// construct hashmap for later possible use.
        for (ReportTypeEnum unit : values()) {
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
    public static ReportTypeEnum lookupEnum(String value) {
        return ReportTypeEnum.valueMap.get(value);
    }
}
