package com.servinglynk.hmis.warehouse.enums;
import java.util.HashMap;
import java.util.Map;
/**
 * Defines the EntryRHYFormerWardChildWelfareEnum enumeration.
 * 
 * @author Sandeep Dolia
 *
 */
public enum EntryRHYFormerWardChildWelfareEnum {
	
	/** Enum Constant. */
	ZERO("0"),
	/** Enum Constant. */
	ONE("1"),
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
	EntryRHYFormerWardChildWelfareEnum(final String state) {
		this.status = state;
	}
	
	/** Construct a map for reverse lookup. */
	private static Map<String, EntryRHYFormerWardChildWelfareEnum> valueMap = new HashMap<String, EntryRHYFormerWardChildWelfareEnum>();

    static {
    	// construct hashmap for later possible use.
        for (EntryRHYFormerWardChildWelfareEnum unit : values()) {
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
    public static EntryRHYFormerWardChildWelfareEnum lookupEnum(String value) {
        return EntryRHYFormerWardChildWelfareEnum.valueMap.get(value);
    }

}
