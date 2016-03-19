package com.servinglynk.hmis.warehouse.enums;
import java.util.Map;
import java.util.HashMap;
/**
 * Defines the ProjectProjecttypeEnum enumeration.
 * 
 * @author Sandeep Dolia
 *
 */
public enum ProjectProjecttypeEnum {

	/** Enum Constant. */
	ONE("1"),
	/** Enum Constant. */
	TWO("2"),
	/** Enum Constant. */
	THREE("3"),
	/** Enum Constant. */
	FOUR("4"),
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
	/** Enum Constant. */
	TWELVE("12"),
	/** Enum Constant. */
	THIRTEEN("13"),
	/** Enum Constant. */
	FOURTEEN("14");
	/**
	 * Internal storage of status field value, see the Enum spec for
 	 * clarification.
 	 */
	private final String status;
	
	/**
	 * Enum constructor for ActiveState.
	 * @param state Value.
	 */
	ProjectProjecttypeEnum(final String state) {
		this.status = state;
	}
	
	/** Construct a map for reverse lookup. */
	private static Map<String, ProjectProjecttypeEnum> valueMap = new HashMap<String, ProjectProjecttypeEnum>();

    static {
    	// construct hashmap for later possible use.
        for (ProjectProjecttypeEnum unit : values()) {
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
    public static ProjectProjecttypeEnum lookupEnum(String value) {
        return ProjectProjecttypeEnum.valueMap.get(value);
    }

}
