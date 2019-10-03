package com.servinglynk.hmis.warehouse.enums;

import java.util.HashMap;
import java.util.Map;

public enum EventTypeEnum {
	/**
	Header: Access Events
				1 = Referral to Prevention Assistance project
				2 = Problem Solving/Diversion/Rapid Resolution intervention or service
				3 = Referral to scheduled Coordinated Entry Crisis Needs Assessment 
				4 = Referral to scheduled Coordinated Entry Housing Needs Assessment 
				
				Header:	Referral Events
				5 = Referral to post-placement/follow-up case management
				6 = Referral to Street Outreach project or services
				7 = Referral to Housing Navigation project or services
				8 = Referral to Non-continuum services: Ineligible for continuum services
				9 = Referral to Non continuum services: No availability in continuum services
				10 = Referral to Emergency Shelter bed opening
				11 = Referral to Transitional Housing bed/unit opening
				12 = Referral to Joint TH-RRH project/unit/resource opening
				13 = Referral to RRH project resource opening
				14 = Referral to PSH project resource opening
				15 = Referral to Other PH project/unit/resource opening
	 */
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
	SEVEN("7"),
	/** Enum Constant. */
	EIGHT("8"),
	/** Enum Constant. */
	NINE("9"),
	/** Enum Constant. */
	TEN("10"),
	/** Enum Constant. */
	ELEVEN("11"),
	TWELVE("12"),
	THIRTEEN("13"),
	FOURTEEN("14"),
	FIFTEEN("15");
	/**
	 * Internal storage of status field value, see the Enum spec for
 	 * clarification.
 	 */
	private final String status;
	
	/**
	 * Enum constructor for ActiveState.
	 * @param state Value.
	 */
	EventTypeEnum(final String state) {
		this.status = state;
	}
	
	/** Construct a map for reverse lookup. */
	private static Map<String, EventTypeEnum> valueMap = new HashMap<String, EventTypeEnum>();

    static {
    	// construct hashmap for later possible use.
        for (EventTypeEnum unit : values()) {
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
    public static EventTypeEnum lookupEnum(String value) {
        return EventTypeEnum.valueMap.get(value);
    }

}
