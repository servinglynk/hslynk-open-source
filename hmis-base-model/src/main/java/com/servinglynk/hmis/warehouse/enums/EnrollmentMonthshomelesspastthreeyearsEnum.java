package com.servinglynk.hmis.warehouse.enums;
import java.util.Map;
import java.util.HashMap;
/**
 * Defines the EnrollmentMonthshomelesspastthreeyearsEnum enumeration.
 * 
 * @author Sandeep Dolia
 *
 */
public enum EnrollmentMonthshomelesspastthreeyearsEnum {

	/** Enum Constant. */
	HUNDRED("100"),
	/** Enum Constant. */
	SEVEN("7"),
	/** Enum Constant. */
	EIGHT("8"),
	/** Enum Constant. */
	NINE("9"),
	/** Enum Constant. */
	ONE_HUNDRED_ONE("101"),
	/** Enum Constant. */
	ONE_HUNDRED_TWO("102"),
	/** Enum Constant. */
	ONE_HUNDRED_THREE("103"),
	/** Enum Constant. */
	ONE_HUNDRED_FOUR("104"),
	/** Enum Constant. */
	ONE_HUNDRED_FIVE("105"),
	/** Enum Constant. */
	ONE_HUNDRED_SIX("106"),
	/** Enum Constant. */
	ONE_HUNDRED_SEVEN("107"),
	/** Enum Constant. */
	ONE_HUNDRED_EIGHT("108"),
	/** Enum Constant. */
	ONE_HUNDRED_NINE("109"),
	/** Enum Constant. */
	ONE_HUNDRED_TEN("110"),
	/** Enum Constant. */
	ONE_HUNDRED_TWELVE("112"),
	/** Enum Constant. */
	ONE_HUNDRED_ELEVEN("111"),
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
	EnrollmentMonthshomelesspastthreeyearsEnum(final String state) {
		this.status = state;
	}
	
	/** Construct a map for reverse lookup. */
	private static Map<String, EnrollmentMonthshomelesspastthreeyearsEnum> valueMap = new HashMap<String, EnrollmentMonthshomelesspastthreeyearsEnum>();

    static {
    	// construct hashmap for later possible use.
        for (EnrollmentMonthshomelesspastthreeyearsEnum unit : values()) {
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
    public static EnrollmentMonthshomelesspastthreeyearsEnum lookupEnum(String value) {
        return EnrollmentMonthshomelesspastthreeyearsEnum.valueMap.get(value);
    }

}
