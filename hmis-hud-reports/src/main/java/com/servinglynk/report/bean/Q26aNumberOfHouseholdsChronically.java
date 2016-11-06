package com.servinglynk.report.bean;

import java.math.BigInteger;

public class Q26aNumberOfHouseholdsChronically {
	
	/*public int countTotalChronicallyHomeless;
	public int countChronicallyHomelessWithOutChildren;
	public int countChronicallyHomelessWithChildrenAndAdults;
	public int countChronicallyHomelessWithOnlyChildren;
	public int countChronicallyHomelessWithUnknownHouseHoldType;
	
	public int countTotalNotChronicallyHomeless;
	public int countNotChronicallyHomelessWithOutChildren;
	public int countNotChronicallyHomelessWithChildrenAndAdults;
	public int countNotChronicallyHomelessWithOnlyChildren;
	public int countNotChronicallyHomelessWithUnknownHouseHoldType;
	
	public int countTotalClientRefused;
	public int countClientRefusedWithOutChildren;
	public int countClientRefusedWithChildrenAndAdults;
	public int countClientRefusedWithOnlyChildren;
	public int countClientRefusedWithUnknownHouseHoldType;
	
	public int countTotalDataNotCollected;
	public int countDataNotCollectedWithOutChildren;
	public int countDataNotCollectedWithChildrenAndAdults;
	public int countDataNotCollectedWithOnlychildren;
	public int countDataNotCollectedWithUnknownHouseHoldType;
	
	public int totalSummedValue;
	public int totalWithOutChildren;
	public int totalWithChildrenAndAdults;
	public int totalWithOnlychildren;
	public int totalUnknownHouseHoldType;
	
	
	private BigInteger q12aWhiteTotal;
	private BigInteger q12aWhiteWithoutChildren;
	private BigInteger q12aWhiteWithChildrenAndAdults;
	private BigInteger q12aWhiteWithOnlyChildren;
	private BigInteger q12aWhiteWithUnkownhouseholdtype;
	
	private BigInteger q12aBlckAfrnAmrnTotal;
	private BigInteger q12aBlckAfrnAmrnWithoutChildren;
	private BigInteger q12aBlckAfrnAmrnWithChildrenAndAdults;
	private BigInteger q12aBlckAfrnAmrnWithOnlyChildren;
	private BigInteger q12aBlckAfrnAmrnWithUnkownhouseholdtype;
	
	private BigInteger q12aAsianTotal;
	private BigInteger q12aAsianWithoutChildren;
	private BigInteger q12aAsianWithChildrenAndAdults;
	private BigInteger q12aAsianWithOnlyChildren;
	private BigInteger q12aAsianUnkownhouseholdtype;
	
	private BigInteger q12aAmericanIndianTotal;
	private BigInteger q12aAmericanIndianWithoutChildren;
	private BigInteger q12aAmericanIndianWithChildrenAndAdults;
	private BigInteger q12aAmericanIndianWithOnlyChildren;
	private BigInteger q12aAmericanIndianUnkownhouseholdtype;
	
	private BigInteger q12aNativeHawalianTotal;
	private BigInteger q12aNativeHawalianWithoutChildren;
	private BigInteger q12aNativeHawalianWithChildrenAndAdults;
	private BigInteger q12aNativeHawalianWithOnlyChildren;
	private BigInteger q12aNativeHawalianUnkownhouseholdtype;
	
	private BigInteger q12aMultipleRacesTotal;
	private BigInteger q12aMultipleRacesWithoutChildren;
	private BigInteger q12aMultipleRacesWithChildrenAndAdults;
	private BigInteger q12aMultipleRacesWithOnlyChildren;
	private BigInteger q12aMultipleRacesUnkownhouseholdtype;
	
	private BigInteger q12aDontKnowRacesTotal;
	private BigInteger q12aDontKnowRacesWithoutChildren;
	private BigInteger q12aDontKnowRacesWithChildrenAndAdults;
	private BigInteger q12aDontKnowRacesWithOnlyChildren;
	private BigInteger q12aDontKnowRacesUnkownhouseholdtype;
	
	private BigInteger q12aInformationMissingTotal;
	private BigInteger q12aInformationMissingWithoutChildren;
	private BigInteger q12aInformationMissingWithChildrenAndAdults;
	private BigInteger q12aInformationMissingWithOnlyChildren;
	private BigInteger q12aInformationMissingUnkownhouseholdtype;
	
	private BigInteger q12aTotalSummed;
	private BigInteger q12aTotalWithoutChildren;
	private BigInteger q12aTotalWithChildrenAndAdults;
	private BigInteger q12aTotalWithOnlyChildren;
	private BigInteger q12aTotalUnkownhouseholdtype;
	
	
	
	public Q26aNumberOfHouseholdsChronically(int countTotalChronicallyHomeless,
			int countChronicallyHomelessWithOutChildren,
			int countChronicallyHomelessWithChildrenAndAdults,
			int countChronicallyHomelessWithOnlyChildren,
			int countChronicallyHomelessWithUnknownHouseHoldType,
			int countTotalNotChronicallyHomeless,
			int countNotChronicallyHomelessWithOutChildren,
			int countNotChronicallyHomelessWithChildrenAndAdults,
			int countNotChronicallyHomelessWithOnlyChildren,
			int countNotChronicallyHomelessWithUnknownHouseHoldType,
			int countTotalClientRefused, int countClientRefusedWithOutChildren,
			int countClientRefusedWithChildrenAndAdults,
			int countClientRefusedWithOnlyChildren,
			int countClientRefusedWithUnknownHouseHoldType,
			int countTotalDataNotCollected,
			int countDataNotCollectedWithOutChildren,
			int countDataNotCollectedWithChildrenAndAdults,
			int countDataNotCollectedWithOnlychildren,
			int countDataNotCollectedWithUnknownHouseHoldType,
			int totalSummedValue, int totalWithOutChildren,
			int totalWithChildrenAndAdults, int totalWithOnlychildren,
			int totalUnknownHouseHoldType) {
		super();
		this.countTotalChronicallyHomeless = countTotalChronicallyHomeless;
		this.countChronicallyHomelessWithOutChildren = countChronicallyHomelessWithOutChildren;
		this.countChronicallyHomelessWithChildrenAndAdults = countChronicallyHomelessWithChildrenAndAdults;
		this.countChronicallyHomelessWithOnlyChildren = countChronicallyHomelessWithOnlyChildren;
		this.countChronicallyHomelessWithUnknownHouseHoldType = countChronicallyHomelessWithUnknownHouseHoldType;
		this.countTotalNotChronicallyHomeless = countTotalNotChronicallyHomeless;
		this.countNotChronicallyHomelessWithOutChildren = countNotChronicallyHomelessWithOutChildren;
		this.countNotChronicallyHomelessWithChildrenAndAdults = countNotChronicallyHomelessWithChildrenAndAdults;
		this.countNotChronicallyHomelessWithOnlyChildren = countNotChronicallyHomelessWithOnlyChildren;
		this.countNotChronicallyHomelessWithUnknownHouseHoldType = countNotChronicallyHomelessWithUnknownHouseHoldType;
		this.countTotalClientRefused = countTotalClientRefused;
		this.countClientRefusedWithOutChildren = countClientRefusedWithOutChildren;
		this.countClientRefusedWithChildrenAndAdults = countClientRefusedWithChildrenAndAdults;
		this.countClientRefusedWithOnlyChildren = countClientRefusedWithOnlyChildren;
		this.countClientRefusedWithUnknownHouseHoldType = countClientRefusedWithUnknownHouseHoldType;
		this.countTotalDataNotCollected = countTotalDataNotCollected;
		this.countDataNotCollectedWithOutChildren = countDataNotCollectedWithOutChildren;
		this.countDataNotCollectedWithChildrenAndAdults = countDataNotCollectedWithChildrenAndAdults;
		this.countDataNotCollectedWithOnlychildren = countDataNotCollectedWithOnlychildren;
		this.countDataNotCollectedWithUnknownHouseHoldType = countDataNotCollectedWithUnknownHouseHoldType;
		this.totalSummedValue = totalSummedValue;
		this.totalWithOutChildren = totalWithOutChildren;
		this.totalWithChildrenAndAdults = totalWithChildrenAndAdults;
		this.totalWithOnlychildren = totalWithOnlychildren;
		this.totalUnknownHouseHoldType = totalUnknownHouseHoldType;
	}
	public int getCountTotalChronicallyHomeless() {
		return countTotalChronicallyHomeless;
	}
	public void setCountTotalChronicallyHomeless(int countTotalChronicallyHomeless) {
		this.countTotalChronicallyHomeless = countTotalChronicallyHomeless;
	}
	public int getCountChronicallyHomelessWithOutChildren() {
		return countChronicallyHomelessWithOutChildren;
	}
	public void setCountChronicallyHomelessWithOutChildren(
			int countChronicallyHomelessWithOutChildren) {
		this.countChronicallyHomelessWithOutChildren = countChronicallyHomelessWithOutChildren;
	}
	public int getCountChronicallyHomelessWithChildrenAndAdults() {
		return countChronicallyHomelessWithChildrenAndAdults;
	}
	public void setCountChronicallyHomelessWithChildrenAndAdults(
			int countChronicallyHomelessWithChildrenAndAdults) {
		this.countChronicallyHomelessWithChildrenAndAdults = countChronicallyHomelessWithChildrenAndAdults;
	}
	public int getCountChronicallyHomelessWithOnlyChildren() {
		return countChronicallyHomelessWithOnlyChildren;
	}
	public void setCountChronicallyHomelessWithOnlyChildren(
			int countChronicallyHomelessWithOnlyChildren) {
		this.countChronicallyHomelessWithOnlyChildren = countChronicallyHomelessWithOnlyChildren;
	}
	public int getCountChronicallyHomelessWithUnknownHouseHoldType() {
		return countChronicallyHomelessWithUnknownHouseHoldType;
	}
	public void setCountChronicallyHomelessWithUnknownHouseHoldType(
			int countChronicallyHomelessWithUnknownHouseHoldType) {
		this.countChronicallyHomelessWithUnknownHouseHoldType = countChronicallyHomelessWithUnknownHouseHoldType;
	}
	public int getCountTotalNotChronicallyHomeless() {
		return countTotalNotChronicallyHomeless;
	}
	public void setCountTotalNotChronicallyHomeless(
			int countTotalNotChronicallyHomeless) {
		this.countTotalNotChronicallyHomeless = countTotalNotChronicallyHomeless;
	}
	public int getCountNotChronicallyHomelessWithOutChildren() {
		return countNotChronicallyHomelessWithOutChildren;
	}
	public void setCountNotChronicallyHomelessWithOutChildren(
			int countNotChronicallyHomelessWithOutChildren) {
		this.countNotChronicallyHomelessWithOutChildren = countNotChronicallyHomelessWithOutChildren;
	}
	public int getCountNotChronicallyHomelessWithChildrenAndAdults() {
		return countNotChronicallyHomelessWithChildrenAndAdults;
	}
	public void setCountNotChronicallyHomelessWithChildrenAndAdults(
			int countNotChronicallyHomelessWithChildrenAndAdults) {
		this.countNotChronicallyHomelessWithChildrenAndAdults = countNotChronicallyHomelessWithChildrenAndAdults;
	}
	public int getCountNotChronicallyHomelessWithOnlyChildren() {
		return countNotChronicallyHomelessWithOnlyChildren;
	}
	public void setCountNotChronicallyHomelessWithOnlyChildren(
			int countNotChronicallyHomelessWithOnlyChildren) {
		this.countNotChronicallyHomelessWithOnlyChildren = countNotChronicallyHomelessWithOnlyChildren;
	}
	public int getCountNotChronicallyHomelessWithUnknownHouseHoldType() {
		return countNotChronicallyHomelessWithUnknownHouseHoldType;
	}
	public void setCountNotChronicallyHomelessWithUnknownHouseHoldType(
			int countNotChronicallyHomelessWithUnknownHouseHoldType) {
		this.countNotChronicallyHomelessWithUnknownHouseHoldType = countNotChronicallyHomelessWithUnknownHouseHoldType;
	}
	public int getCountTotalClientRefused() {
		return countTotalClientRefused;
	}
	public void setCountTotalClientRefused(int countTotalClientRefused) {
		this.countTotalClientRefused = countTotalClientRefused;
	}
	public int getCountClientRefusedWithOutChildren() {
		return countClientRefusedWithOutChildren;
	}
	public void setCountClientRefusedWithOutChildren(
			int countClientRefusedWithOutChildren) {
		this.countClientRefusedWithOutChildren = countClientRefusedWithOutChildren;
	}
	public int getCountClientRefusedWithChildrenAndAdults() {
		return countClientRefusedWithChildrenAndAdults;
	}
	public void setCountClientRefusedWithChildrenAndAdults(
			int countClientRefusedWithChildrenAndAdults) {
		this.countClientRefusedWithChildrenAndAdults = countClientRefusedWithChildrenAndAdults;
	}
	public int getCountClientRefusedWithOnlyChildren() {
		return countClientRefusedWithOnlyChildren;
	}
	public void setCountClientRefusedWithOnlyChildren(
			int countClientRefusedWithOnlyChildren) {
		this.countClientRefusedWithOnlyChildren = countClientRefusedWithOnlyChildren;
	}
	public int getCountClientRefusedWithUnknownHouseHoldType() {
		return countClientRefusedWithUnknownHouseHoldType;
	}
	public void setCountClientRefusedWithUnknownHouseHoldType(
			int countClientRefusedWithUnknownHouseHoldType) {
		this.countClientRefusedWithUnknownHouseHoldType = countClientRefusedWithUnknownHouseHoldType;
	}
	public int getCountTotalDataNotCollected() {
		return countTotalDataNotCollected;
	}
	public void setCountTotalDataNotCollected(int countTotalDataNotCollected) {
		this.countTotalDataNotCollected = countTotalDataNotCollected;
	}
	public int getCountDataNotCollectedWithOutChildren() {
		return countDataNotCollectedWithOutChildren;
	}
	public void setCountDataNotCollectedWithOutChildren(
			int countDataNotCollectedWithOutChildren) {
		this.countDataNotCollectedWithOutChildren = countDataNotCollectedWithOutChildren;
	}
	public int getCountDataNotCollectedWithChildrenAndAdults() {
		return countDataNotCollectedWithChildrenAndAdults;
	}
	public void setCountDataNotCollectedWithChildrenAndAdults(
			int countDataNotCollectedWithChildrenAndAdults) {
		this.countDataNotCollectedWithChildrenAndAdults = countDataNotCollectedWithChildrenAndAdults;
	}
	public int getCountDataNotCollectedWithOnlychildren() {
		return countDataNotCollectedWithOnlychildren;
	}
	public void setCountDataNotCollectedWithOnlychildren(
			int countDataNotCollectedWithOnlychildren) {
		this.countDataNotCollectedWithOnlychildren = countDataNotCollectedWithOnlychildren;
	}
	public int getCountDataNotCollectedWithUnknownHouseHoldType() {
		return countDataNotCollectedWithUnknownHouseHoldType;
	}
	public void setCountDataNotCollectedWithUnknownHouseHoldType(
			int countDataNotCollectedWithUnknownHouseHoldType) {
		this.countDataNotCollectedWithUnknownHouseHoldType = countDataNotCollectedWithUnknownHouseHoldType;
	}
	public int getTotalSummedValue() {
		return totalSummedValue;
	}
	public void setTotalSummedValue(int totalSummedValue) {
		this.totalSummedValue = totalSummedValue;
	}
	public int getTotalWithOutChildren() {
		return totalWithOutChildren;
	}
	public void setTotalWithOutChildren(int totalWithOutChildren) {
		this.totalWithOutChildren = totalWithOutChildren;
	}
	public int getTotalWithChildrenAndAdults() {
		return totalWithChildrenAndAdults;
	}
	public void setTotalWithChildrenAndAdults(int totalWithChildrenAndAdults) {
		this.totalWithChildrenAndAdults = totalWithChildrenAndAdults;
	}
	public int getTotalWithOnlychildren() {
		return totalWithOnlychildren;
	}
	public void setTotalWithOnlychildren(int totalWithOnlychildren) {
		this.totalWithOnlychildren = totalWithOnlychildren;
	}
	public int getTotalUnknownHouseHoldType() {
		return totalUnknownHouseHoldType;
	}
	public void setTotalUnknownHouseHoldType(int totalUnknownHouseHoldType) {
		this.totalUnknownHouseHoldType = totalUnknownHouseHoldType;
	}
	
*/

	private BigInteger q14bYesTotal;
	private BigInteger q14bYesWithoutChildren;
	private BigInteger q14bYesWithChildAndAdults;
	private BigInteger q14bYesWithOnlyChildren;
	private BigInteger q14bYesUnknownHouseholdType;
	
	private BigInteger q14bNoTotal;
	private BigInteger q14bNoWithoutChildren;
	private BigInteger q14bNoWithChildAndAdults;
	private BigInteger q14bNoWithOnlyChildren;
	private BigInteger q14bNoUnknownHouseholdType;
	
	private BigInteger q14bDKRTotal;
	private BigInteger q14bDKRWithoutChildren;
	private BigInteger q14bDKRWithChildAndAdults;
	private BigInteger q14bDKRWithOnlyChildren;
	private BigInteger q14bDKRUnknownHouseholdType;

	private BigInteger q14bInformationMissingTotal;
	private BigInteger q14bInformationMissingWithoutChildren;
	private BigInteger q14bInformationMissingWithChildAndAdults;
	private BigInteger q14bInformationMissingWithOnlyChildren;
	private BigInteger q14bInformationMissingUnknownHouseholdType;
	
	private BigInteger q14bTotalSummed;
	private BigInteger q14bTotalWithoutChildren;
	private BigInteger q14bTotalWithChildAndAdults;
	private BigInteger q14bTotalWithOnlychildren;
	private BigInteger q14bTotalUnknowHousehold;
	public Q26aNumberOfHouseholdsChronically(BigInteger q14bYesTotal,
			BigInteger q14bYesWithoutChildren,
			BigInteger q14bYesWithChildAndAdults,
			BigInteger q14bYesWithOnlyChildren,
			BigInteger q14bYesUnknownHouseholdType, BigInteger q14bNoTotal,
			BigInteger q14bNoWithoutChildren,
			BigInteger q14bNoWithChildAndAdults,
			BigInteger q14bNoWithOnlyChildren,
			BigInteger q14bNoUnknownHouseholdType, BigInteger q14bDKRTotal,
			BigInteger q14bDKRWithoutChildren,
			BigInteger q14bDKRWithChildAndAdults,
			BigInteger q14bDKRWithOnlyChildren,
			BigInteger q14bDKRUnknownHouseholdType,
			BigInteger q14bInformationMissingTotal,
			BigInteger q14bInformationMissingWithoutChildren,
			BigInteger q14bInformationMissingWithChildAndAdults,
			BigInteger q14bInformationMissingWithOnlyChildren,
			BigInteger q14bInformationMissingUnknownHouseholdType,
			BigInteger q14bTotalSummed, BigInteger q14bTotalWithoutChildren,
			BigInteger q14bTotalWithChildAndAdults,
			BigInteger q14bTotalWithOnlychildren,
			BigInteger q14bTotalUnknowHousehold) {
		super();
		this.q14bYesTotal = q14bYesTotal;
		this.q14bYesWithoutChildren = q14bYesWithoutChildren;
		this.q14bYesWithChildAndAdults = q14bYesWithChildAndAdults;
		this.q14bYesWithOnlyChildren = q14bYesWithOnlyChildren;
		this.q14bYesUnknownHouseholdType = q14bYesUnknownHouseholdType;
		this.q14bNoTotal = q14bNoTotal;
		this.q14bNoWithoutChildren = q14bNoWithoutChildren;
		this.q14bNoWithChildAndAdults = q14bNoWithChildAndAdults;
		this.q14bNoWithOnlyChildren = q14bNoWithOnlyChildren;
		this.q14bNoUnknownHouseholdType = q14bNoUnknownHouseholdType;
		this.q14bDKRTotal = q14bDKRTotal;
		this.q14bDKRWithoutChildren = q14bDKRWithoutChildren;
		this.q14bDKRWithChildAndAdults = q14bDKRWithChildAndAdults;
		this.q14bDKRWithOnlyChildren = q14bDKRWithOnlyChildren;
		this.q14bDKRUnknownHouseholdType = q14bDKRUnknownHouseholdType;
		this.q14bInformationMissingTotal = q14bInformationMissingTotal;
		this.q14bInformationMissingWithoutChildren = q14bInformationMissingWithoutChildren;
		this.q14bInformationMissingWithChildAndAdults = q14bInformationMissingWithChildAndAdults;
		this.q14bInformationMissingWithOnlyChildren = q14bInformationMissingWithOnlyChildren;
		this.q14bInformationMissingUnknownHouseholdType = q14bInformationMissingUnknownHouseholdType;
		this.q14bTotalSummed = q14bTotalSummed;
		this.q14bTotalWithoutChildren = q14bTotalWithoutChildren;
		this.q14bTotalWithChildAndAdults = q14bTotalWithChildAndAdults;
		this.q14bTotalWithOnlychildren = q14bTotalWithOnlychildren;
		this.q14bTotalUnknowHousehold = q14bTotalUnknowHousehold;
	}
	
	
	
	
	
	
	
	
	
/*	public int age;
	public int year;
	
	
	public Q26aNumberOfHouseholdsChronically(int age, int year) {
		super();
		this.age = age;
		this.year = year;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
*/	
	

}
