package com.servinglynk.hmis.warehouse.enums;
import java.util.Map;
import java.util.HashMap;
/**
 * Defines the VeteranInfoDischargeStatusEnum enumeration.
 * 
 * @author Sandeep Dolia
 *
 */
public enum VeteranInfoDischargeStatusEnum {

	/** Enum Constant. */
	ONE("1"),
	/** Enum Constant. */
	TWO("2"),
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
	VeteranInfoDischargeStatusEnum(final String state) {
		this.status = state;
	}
	
	/** Construct a map for reverse lookup. */
	private static Map<String, VeteranInfoDischargeStatusEnum> valueMap = new HashMap<String, VeteranInfoDischargeStatusEnum>();

    static {
    	// construct hashmap for later possible use.
        for (VeteranInfoDischargeStatusEnum unit : values()) {
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
    public static VeteranInfoDischargeStatusEnum lookupEnum(String value) {
        return VeteranInfoDischargeStatusEnum.valueMap.get(value);
    }

}
