package com.servinglynk.hmis.warehouse.enums;

import java.util.HashMap;
import java.util.Map;

public enum StateEnum {

	AK("AK"),
	AL("AL"),
	AR("AR"),
	AZ("AZ"),
	CA("CA"),
	CO("CO"),
	CT("CT"),
	DE("DE"),
	FL("FL"),
	GA("GA"),
	HI("HI"),
	IA("IA"),
	ID("ID"),
	IL("IL"),
	IN("IN"),
	KS("KS"),
	KY("KY"),
	LA("LA"),
	MA("MA"),
	MD("MD"),
	ME("ME"),
	MI("MI"),
	MN("MN"),
	MO("MO"),
	MS("MS"),
	MT("MT"),
	NC("NC"),
	ND("ND"),
	NE("NE"),
	NH("NH"),
	NJ("NJ"),
	NM("NM"),
	NV("NV"),
	NY("NY"),
	OH("OH"),
	OK("OK"),
	OR("OR"),
	PA("PA"),
	RI("RI"),
	SC("SC"),
	SD("SD"),
	TN("TN"),
	TX("TX"),
	UT("UT"),
	VA("VA"),
	VT("VT"),
	WA("WA"),
	WI("WI"),
	WV("WV"),
	WY("WY"),
	DC("DC"),
	AS("AS"),
	FM("FM"),
	GU("GU"),
	MH("MH"),
	MP("MP"),
	PR("PR"),
	PW("PW"),
	VI("VI"),
	AA("AA"),
	AE("AE"),
	AP("AP");
	/**
	 * Internal storage of status field value, see the Enum spec for
 	 * clarification.
 	 */
	private final String status;
	
	/**
	 * Enum constructor for ActiveState.
	 * @param state Value.
	 */
	StateEnum(final String state) {
		this.status = state;
	}
	
	/** Construct a map for reverse lookup. */
	private static Map<String, StateEnum> valueMap = new HashMap<String, StateEnum>();

    static {
    	// construct hashmap for later possible use.
        for (StateEnum unit : values()) {
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
    public static StateEnum lookupEnum(String value) {
        return StateEnum.valueMap.get(value);
    }


}
