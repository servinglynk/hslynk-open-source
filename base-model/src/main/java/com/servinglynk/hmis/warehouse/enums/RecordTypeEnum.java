package com.servinglynk.hmis.warehouse.enums;

import java.util.HashMap;
import java.util.Map;

public enum RecordTypeEnum {

	/*
	 * 		Contact records collected under 2014 HMIS Data Standards v5.1 (RecordType 12)
						4.12 Contact records collected under 2020 HMIS Data Standards (RecordType 13)
						4.14 Bed Night (RecordType 200)
						P1 Services Provided – PATH (RecordType 141)
						P2 Referrals Provided – PATH (RecordType 161)
						R14 RHY Service Connections (RecordType 142)
						W1 Services Provided – HOPWA (RecordType 143)
						W2 Financial Assistance – HOPWA (RecordType 151)
						V2 Services Provided – SSVF (RecordType 144)
						V3 Financial Assistance – SSVF (RecordType 152)
						V8 HUD-VASH Voucher Tracking (RecordType 210)
	 */
	
	/** Enum Constant. */
	TWELVE("12"),
	/** Enum Constant. */
	THIRTEEN("13"),
	/** Enum Constant. */
	TWO_HUNDRED("200"),
	/** Enum Constant. */
	ONE_FORTY_ONE("141"),
	/** Enum Constant. */
	ONE_SIXTY_ONE("161"),
	/** Enum Constant. */
	ONE_FORTY_TWO("142"),
	/** Enum Constant. */
	ONE_FORTY_THREE("143"),
	/** Enum Constant. */
	ONE_FORTY_FOUR("144"),
	/** Enum Constant. */
	ONE_FIFTY_ONE("151"),
	/** Enum Constant. */
	ONE_FIFTY_TWO("152"),
	/** Enum Constant. */
	TWO_HUNDRED_TEN("210");
	
	/**
	 * Internal storage of status field value, see the Enum spec for
 	 * clarification.
 	 */
	private final String status;
	
	/**
	 * Enum constructor for ActiveState.
	 * @param state Value.
	 */
	RecordTypeEnum(final String state) {
		this.status = state;
	}
	
	/** Construct a map for reverse lookup. */
	private static Map<String, RecordTypeEnum> valueMap = new HashMap<String, RecordTypeEnum>();

    static {
    	// construct hashmap for later possible use.
        for (RecordTypeEnum unit : values()) {
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
    public static RecordTypeEnum lookupEnum(String value) {
        return RecordTypeEnum.valueMap.get(value);
    }

}

