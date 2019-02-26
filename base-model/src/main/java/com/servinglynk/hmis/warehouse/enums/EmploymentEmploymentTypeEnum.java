package com.servinglynk.hmis.warehouse.enums;
import java.util.Map;
import java.util.HashMap;
/**
 * Defines the EmploymentEmploymentTypeEnum enumeration.
 * 
 * @author Sandeep Dolia
 *
 */
public enum EmploymentEmploymentTypeEnum {

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
	EmploymentEmploymentTypeEnum(final String state) {
		this.status = state;
	}
	
	/** Construct a map for reverse lookup. */
	private static Map<String, EmploymentEmploymentTypeEnum> valueMap = new HashMap<String, EmploymentEmploymentTypeEnum>();

    static {
    	// construct hashmap for later possible use.
        for (EmploymentEmploymentTypeEnum unit : values()) {
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
    public static EmploymentEmploymentTypeEnum lookupEnum(String value) {
        return EmploymentEmploymentTypeEnum.valueMap.get(value);
    }

}
