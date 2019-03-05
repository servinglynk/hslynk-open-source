package com.servinglynk.hmis.warehouse.enums;
import java.util.Map;
import java.util.HashMap;
/**
 * Defines the ServicesRecordtypeEnum enumeration.
 * 
 * @author Sandeep Dolia
 *
 */
public enum ServicesRecordtypeEnum {

	/** Enum Constant. */
	TWELVE("12"),
	/** Enum Constant. */
	FOURTEEN("14"),
	/** Enum Constant. */
	FIFTEEN("15"),
	/** Enum Constant. */
	SIXTEEN("16"),
	/** Enum Constant. */
	ONE_FORTY_ONE("141"),
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
	ONE_SIXTY_ONE("161"),
	/** Enum Constant. */
	ONE_SIXTY_TWO("162"),
	/** Enum Constant. */
	TWO_HUNDRED("200");
	/**
	 * Internal storage of status field value, see the Enum spec for
 	 * clarification.
 	 */
	private final String status;
	
	/**
	 * Enum constructor for ActiveState.
	 * @param state Value.
	 */
	ServicesRecordtypeEnum(final String state) {
		this.status = state;
	}
	
	/** Construct a map for reverse lookup. */
	private static Map<String, ServicesRecordtypeEnum> valueMap = new HashMap<String, ServicesRecordtypeEnum>();

    static {
    	// construct hashmap for later possible use.
        for (ServicesRecordtypeEnum unit : values()) {
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
    public static ServicesRecordtypeEnum lookupEnum(String value) {
        return ServicesRecordtypeEnum.valueMap.get(value);
    }

}
