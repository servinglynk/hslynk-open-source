package com.servinglynk.hmis.warehouse.enums;
import java.util.Map;
import java.util.HashMap;
/**
 * Defines the HealthinsuranceNomedicaidreasonEnum enumeration.
 * 
 * @author Sandeep Dolia
 *
 */
public enum HealthinsuranceNomedicaidreasonEnum {

	/** Enum Constant. */
	ONE("1"),
	/** Enum Constant. */
	TWO("2"),
	/** Enum Constant. */
	THREE("3"),
	/** Enum Constant. */
	FOUR("4"),
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
	HealthinsuranceNomedicaidreasonEnum(final String state) {
		this.status = state;
	}
	
	/** Construct a map for reverse lookup. */
	private static Map<String, HealthinsuranceNomedicaidreasonEnum> valueMap = new HashMap<String, HealthinsuranceNomedicaidreasonEnum>();

    static {
    	// construct hashmap for later possible use.
        for (HealthinsuranceNomedicaidreasonEnum unit : values()) {
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
    public static HealthinsuranceNomedicaidreasonEnum lookupEnum(String value) {
        return HealthinsuranceNomedicaidreasonEnum.valueMap.get(value);
    }

}
