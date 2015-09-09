package com.servinglynk.hmis.warehouse.enums;
import java.util.Map;
import java.util.HashMap;
/**
 * Defines the ExitplansactionsTemporaryshelterplacementEnum enumeration.
 * 
 * @author Sandeep Dolia
 *
 */
public enum ExitplansactionsTemporaryshelterplacementEnum {

	/** Enum Constant. */
	ZERO("0"),
	/** Enum Constant. */
	ONE("1"),
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
	ExitplansactionsTemporaryshelterplacementEnum(final String state) {
		this.status = state;
	}
	
	/** Construct a map for reverse lookup. */
	private static Map<String, ExitplansactionsTemporaryshelterplacementEnum> valueMap = new HashMap<String, ExitplansactionsTemporaryshelterplacementEnum>();

    static {
    	// construct hashmap for later possible use.
        for (ExitplansactionsTemporaryshelterplacementEnum unit : values()) {
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
    public static ExitplansactionsTemporaryshelterplacementEnum lookupEnum(String value) {
        return ExitplansactionsTemporaryshelterplacementEnum.valueMap.get(value);
    }

}
