package com.servinglynk.hmis.warehouse.enums;
import java.util.HashMap;
import java.util.Map;
/**
 * Defines the ExitRHYPermanentHousingPlacementEnum enumeration.
 * 
 * @author Sandeep Dolia
 *
 */
public enum ExitRHYPermanentHousingPlacementEnum {
	
	/** Enum Constant. */
	ZERO("0"),
	/** Enum Constant. */
	ONE("1"),
	/** Enum Constant. */
	TWO("2"),
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
	ExitRHYPermanentHousingPlacementEnum(final String state) {
		this.status = state;
	}
	
	/** Construct a map for reverse lookup. */
	private static Map<String, ExitRHYPermanentHousingPlacementEnum> valueMap = new HashMap<String, ExitRHYPermanentHousingPlacementEnum>();

    static {
    	// construct hashmap for later possible use.
        for (ExitRHYPermanentHousingPlacementEnum unit : values()) {
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
    public static ExitRHYPermanentHousingPlacementEnum lookupEnum(String value) {
        return ExitRHYPermanentHousingPlacementEnum.valueMap.get(value);
    }

}
