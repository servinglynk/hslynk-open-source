package com.servinglynk.hmis.household.enums;

import java.util.HashMap;
import java.util.Map;


public enum RelationshipToHOfHEnum {

	/** Enum Constant. */
	SELF_HEAD_OF_HOUSEHOLD("1"),
	/** Enum Constant. */
	HEAD_OF_HOUSEHOLDS_CHILD("2"),
	/** Enum Constant. */
	HEAD_OF_HOUSEHOLDS_SPOUSE_OR_PARTNER("3"),
	/** Enum Constant. */
	HEAD_OF_HOUSEHOLDS_OTHER_RELATION_MEMBER("4"),
	/** Enum Constant. */
	OTHER_NON_RELATION_MEMBER("5"),
	/** Enum Constant. */
	DATA_NOT_COLLECTED("99");
	/**
	 * Internal storage of status field value, see the Enum spec for
 	 * clarification.
 	 */
	private final String status;
	
	/**
	 * Enum constructor for ActiveState.
	 * @param state Value.
	 */
	RelationshipToHOfHEnum(final String state) {
		this.status = state;
	}
	
	/** Construct a map for reverse lookup. */
	private static Map<String, RelationshipToHOfHEnum> valueMap = new HashMap<String, RelationshipToHOfHEnum>();

    static {
    	// construct hashmap for later possible use.
        for (RelationshipToHOfHEnum unit : values()) {
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
    public static RelationshipToHOfHEnum lookupEnum(String value) {
        return RelationshipToHOfHEnum.valueMap.get(value);
    }

}
