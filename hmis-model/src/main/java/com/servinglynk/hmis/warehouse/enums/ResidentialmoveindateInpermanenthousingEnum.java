package com.servinglynk.hmis.warehouse.enums;
import java.util.Map;
import java.util.HashMap;
/**
 * Defines the ResidentialmoveindateInpermanenthousingEnum enumeration.
 * 
 * @author Sandeep Dolia
 *
 */
public enum ResidentialmoveindateInpermanenthousingEnum {

	/** Enum Constant. */
	ZERO("0"),
	/** Enum Constant. */
	ONE("1"),
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
	ResidentialmoveindateInpermanenthousingEnum(final String state) {
		this.status = state;
	}
	
	/** Construct a map for reverse lookup. */
	private static Map<String, ResidentialmoveindateInpermanenthousingEnum> valueMap = new HashMap<String, ResidentialmoveindateInpermanenthousingEnum>();

    static {
    	// construct hashmap for later possible use.
        for (ResidentialmoveindateInpermanenthousingEnum unit : values()) {
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
    public static ResidentialmoveindateInpermanenthousingEnum lookupEnum(String value) {
        return ResidentialmoveindateInpermanenthousingEnum.valueMap.get(value);
    }

}
