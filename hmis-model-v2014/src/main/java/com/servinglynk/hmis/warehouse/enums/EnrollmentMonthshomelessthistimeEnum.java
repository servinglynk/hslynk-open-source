package com.servinglynk.hmis.warehouse.enums;
import java.util.Map;
import java.util.HashMap;
/**
 * Defines the EnrollmentMonthshomelessthistimeEnum enumeration.
 * 
 * @author Sandeep Dolia
 *
 */
public enum EnrollmentMonthshomelessthistimeEnum {

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
	EnrollmentMonthshomelessthistimeEnum(final String state) {
		this.status = state;
	}
	
	/** Construct a map for reverse lookup. */
	private static Map<String, EnrollmentMonthshomelessthistimeEnum> valueMap = new HashMap<String, EnrollmentMonthshomelessthistimeEnum>();

    static {
    	// construct hashmap for later possible use.
        for (EnrollmentMonthshomelessthistimeEnum unit : values()) {
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
    public static EnrollmentMonthshomelessthistimeEnum lookupEnum(String value) {
        return EnrollmentMonthshomelessthistimeEnum.valueMap.get(value);
    }

}
