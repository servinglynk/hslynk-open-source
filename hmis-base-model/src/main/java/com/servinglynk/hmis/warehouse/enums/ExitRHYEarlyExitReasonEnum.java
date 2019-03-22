package com.servinglynk.hmis.warehouse.enums;
import java.util.HashMap;
import java.util.Map;
/**
 * Defines the ExitRHYEarlyExitReasonEnum enumeration.
 * 
 * @author Sandeep Dolia
 *
 */
public enum ExitRHYEarlyExitReasonEnum {
	

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
	SIX("6"),
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
	ExitRHYEarlyExitReasonEnum(final String state) {
		this.status = state;
	}
	
	/** Construct a map for reverse lookup. */
	private static Map<String, ExitRHYEarlyExitReasonEnum> valueMap = new HashMap<String, ExitRHYEarlyExitReasonEnum>();

    static {
    	// construct hashmap for later possible use.
        for (ExitRHYEarlyExitReasonEnum unit : values()) {
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
    public static ExitRHYEarlyExitReasonEnum lookupEnum(String value) {
        return ExitRHYEarlyExitReasonEnum.valueMap.get(value);
    }

}
