package com.servinglynk.hmis.warehouse.enums;

import java.util.HashMap;
import java.util.Map;

public enum LengthOfStayEnum {
	/**
					2 = One week or more, but less than one month
					3 = One month or more, but less than 90 days
					4 = 90 days or more but less than one year
					5 = One year or longer 
					8 = Client doesn’t know 
					9 = Client refused
					10 = One night or less
					11 = Two to six nights 
					99 = Data not collected 
	 */
	/** Enum Constant. */
	TWO("2"),
	/** Enum Constant. */
	THREE("3"),
	/** Enum Constant. */
	FOUR("4"),
	/** Enum Constant. */
	FIVE("5"),
	/** Enum Constant. */
	EIGHT("8"),
	/** Enum Constant. */
	NINE("9"),
	/** Enum Constant. */
	TEN("10"),
	/** Enum Constant. */
	ELEVEN("11"),
	/** Enum Constant. */
	NINTY_NINE("99");
	
	/** Enum Constant. */
	/*
	19 = Rental by client, with VASH subsidy
	20 = Rental by client, with other housing subsidy (including RRH)
	21 = Owned by client, with ongoing housing subsidy 
	22 = Rental by client, no ongoing housing subsidy
	23 = Owned by client, no ongoing housing subsidy 
	24 = Long-term care facility or nursing home
	25 = Rental by client, with GPD TIP subsidy
	26 = Residential project or halfway house with no homeless criteria
	27 = Interim housing
	99 = Data not collected
	*/
	/**
	 * Internal storage of status field value, see the Enum spec for
 	 * clarification.
 	 */
	private final String status;
	
	/**
	 * Enum constructor for ActiveState.
	 * @param state Value.
	 */
	LengthOfStayEnum(final String state) {
		this.status = state;
	}
	
	/** Construct a map for reverse lookup. */
	private static Map<String, LengthOfStayEnum> valueMap = new HashMap<String, LengthOfStayEnum>();

    static {
    	// construct hashmap for later possible use.
        for (LengthOfStayEnum unit : values()) {
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
    public static LengthOfStayEnum lookupEnum(String value) {
        return LengthOfStayEnum.valueMap.get(value);
    }

}
