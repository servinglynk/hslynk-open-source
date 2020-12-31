package com.servinglynk.hmis.warehouse.enums;
import java.util.Map;
import java.util.HashMap;
/**
 * Defines the ExitDestinationEnum enumeration.
 * 
 * @author Sandeep Dolia
 *
 */
public enum ExitDestinationEnum {

	/** Enum Constant. */
	TWENTY_FOUR("24"),
	/** Enum Constant. */
	ONE("1"),
	/** Enum Constant. */
	FIFTEEN("15"),
	/** Enum Constant. */
	SIX("6"),
	/** Enum Constant. */
	FOURTEEN("14"),
	/** Enum Constant. */
	SEVEN("7"),
	/** Enum Constant. */
	TWENTY_FIVE("25"),
	/** Enum Constant. */
	TWENTY_SIX("26"),
	/** Enum Constant. */
	TWENTY_SEVEN("27"),
	/** Enum Constant. */
	ELEVEN("11"),
	/** Enum Constant. */
	TWENTY_ONE("21"),
	/** Enum Constant. */
	THREE("3"),
	/** Enum Constant. */
	SIXTEEN("16"),
	/** Enum Constant. */
	FOUR("4"),
	/** Enum Constant. */
	TEN("10"),
	/** Enum Constant. */
	NINTEEN("19"),
	/** Enum Constant. */
	TWENTY_EIGHT("28"),
	/** Enum Constant. */
	TWENTY("20"),
	/** Enum Constant. */
	TWENTY_NINE("29"),
	/** Enum Constant. */
	EIGHTEEN("18"),
	/** Enum Constant. */
	TWENTY_TWO("22"),
	/** Enum Constant. */
	TWELVE("12"),
	/** Enum Constant. */
	TWENTY_THREE("23"),
	/** Enum Constant. */
	THIRTEEN("13"),
	/** Enum Constant. */
	FIVE("5"),
	/** Enum Constant. */
	TWO("2"),
	/** Enum Constant. */
	SEVENTEEN("17"),
	/** Enum Constant. */
	THIRTY("30"),
	/** Enum Constant. */
	THIRTY_ONE("31"),
	/** Enum Constant. */
	THIRTY_TWO("32"),
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
	ExitDestinationEnum(final String state) {
		this.status = state;
	}
	
	/** Construct a map for reverse lookup. */
	private static Map<String, ExitDestinationEnum> valueMap = new HashMap<String, ExitDestinationEnum>();

    static {
    	// construct hashmap for later possible use.
        for (ExitDestinationEnum unit : values()) {
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
    public static ExitDestinationEnum lookupEnum(String value) {
        return ExitDestinationEnum.valueMap.get(value);
    }

}
