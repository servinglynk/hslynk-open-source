package com.servinglynk.hmis.warehouse.enums;
import java.util.Map;
import java.util.HashMap;
/**
 * Defines the EnrollmentRelationshiptohohEnum enumeration.
 * 
 * @author Sandeep Dolia
 *
 */
public enum EnrollmentRelationshiptohohEnum {

	/** Enum Constant. */
	ONE("1"),
	/** Enum Constant. */
	TWO("2"),
	/** Enum Constant. */
	THREE("3"),
	/** Enum Constant. */
	FOUR("4"),
	/** Enum Constant. */
	FIVE("5");
	/**
	 * Internal storage of status field value, see the Enum spec for
 	 * clarification.
 	 */
	private final String status;
	
	/**
	 * Enum constructor for ActiveState.
	 * @param state Value.
	 */
	EnrollmentRelationshiptohohEnum(final String state) {
		this.status = state;
	}
	
	/** Construct a map for reverse lookup. */
	private static Map<String, EnrollmentRelationshiptohohEnum> valueMap = new HashMap<String, EnrollmentRelationshiptohohEnum>();

    static {
    	// construct hashmap for later possible use.
        for (EnrollmentRelationshiptohohEnum unit : values()) {
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
    public static EnrollmentRelationshiptohohEnum lookupEnum(String value) {
        return EnrollmentRelationshiptohohEnum.valueMap.get(value);
    }

}
