package com.servinglynk.hmis.warehouse.enums;

import java.util.HashMap;
import java.util.Map;

public enum LivingSituationEnum {
	/**
	 * 			1 = Emergency shelter, including hotel or motel paid for with emergency shelter voucher
				2 = Transitional housing for homeless persons (including homeless youth)
				3 = Permanent housing (other than RRH) for formerly homeless persons
				4 = Psychiatric hospital or other psychiatric facility
				5 = Substance abuse treatment facility or detox center
				6 = Hospital or other residential non-psychiatric medical facility
				7 = Jail, prison or juvenile detention facility
				8 = Client doesn’t know
				9 = Client refused
				12 = Staying or living in a family member’s room, apartment or house          
				13 = Staying or living in a friend’s room, apartment or house
				14 = Hotel or motel paid for without emergency shelter voucher 
				15 = Foster care home or foster care group home				s
				16 = Place not meant for habitation (e.g., a vehicle, an abandoned building, bus/train/subway station/airport or anywhere outside)
				17 = Other
				18 = Safe Haven
				19 = Rental by client, with VASH subsidy
				20 = Rental by client, with other housing subsidy (including RRH)
				21 = Owned by client, with ongoing housing subsidy 
				22 = Rental by client, no ongoing housing subsidy
				23 = Owned by client, no ongoing housing subsidy 
				24 = Long-term care facility or nursing home
				25 = Rental by client, with GPD TIP subsidy
				26 = Residential project or halfway house with no homeless criteria
				27 = Interim housing
				99 = Data not collected
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
	TEN("10"),
	ELEVEN("11"),
	TWELVE("12"),
	THIRTEEN("13"),
	FOURTEEN("14"),
	FIFTEEN("15"),
	SIXTEEN("16"),
	SEVENTEEN("17"),
	EIGHTEEN("18"),
	NINETEEN("19"),
	TWENTY("20"),
	TWENTY_ONE("21"),
	TWENTY_TWO("22"),
	TWENTY_THREE("23"),
	TWENTY_FOUR("24"),
	TWENTY_FIVE("25"),
	TWENTY_SIX("26"),
	TWENTY_SEVEN("27"),
	TWENTY_EIGHT("28"),
	TWENTY_NINE("29"),
	THIRTY("30"),
	THIRTY_ONE("31"),
	THIRTY_TWO("32"),
	THIRTY_THREE("33"),
	THIRTY_FOUR("34"),
	THIRTY_FIVE("35"),
	THIRTY_SIX("36"),
	THIRTY_SEVEN("37"),
	/** Enum Constant. */
	/*
	19 = Rental by client, with VASH subsidy
	20 = Rental by client, with other housing subsidy (including RRH)
	21 = Owned by client, with ongoing housing subsidy 
	22 = Rental by client, no ongoing housing subsidy
	23 = Owned by client, no ongoing housing subsidy 
	24 = Long-term care facility or nursing home
	25 = Rental by client, with GPD TIP subsidy
	26 = Residential project or halfway house with no homeless criteria
	27 = Interim housing
	99 = Data not collected
	*/
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
	LivingSituationEnum(final String state) {
		this.status = state;
	}
	
	/** Construct a map for reverse lookup. */
	private static Map<String, LivingSituationEnum> valueMap = new HashMap<String, LivingSituationEnum>();

    static {
    	// construct hashmap for later possible use.
        for (LivingSituationEnum unit : values()) {
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
    public static LivingSituationEnum lookupEnum(String value) {
        return LivingSituationEnum.valueMap.get(value);
    }

}
