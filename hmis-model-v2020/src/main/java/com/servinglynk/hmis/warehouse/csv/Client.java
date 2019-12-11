package com.servinglynk.hmis.warehouse.csv;

import org.beanio.annotation.Record;

import com.googlecode.jcsv.annotations.MapToColumn;


@Record(minOccurs=0, maxOccurs=-1)
public class Client extends BaseCSV {
	//PersonalID	FirstName	MiddleName	LastName	NameSuffix	NameDataQuality	
	// SSN	SSNDataQuality	DOB	DOBDataQuality	AmIndAKNative	Asian	
	// BlackAfAmerican	NativeHIOtherPacific	White	RaceNone	
	// Ethnicity	Gender	OtherGender	VeteranStatus	YearEnteredService	
	//YearSeparated	WorldWarII	KoreanWar	VietnamWar	DesertStorm	AfghanistanOEF	
	//IraqOIF	IraqOND	OtherTheater	MilitaryBranch	DischargeStatus	
	//DateCreated	DateUpdated	UserID	DateDeleted	ExportID
	
	@MapToColumn(column=0)
    protected String personalID;
	@MapToColumn(column=1)
    protected String firstName;
	@MapToColumn(column=2)
    protected String middleName;
	@MapToColumn(column=3)
    protected String lastName;
	@MapToColumn(column=4)
    protected String nameSuffix;
	@MapToColumn(column=5)
    protected String nameDataQuality;
	@MapToColumn(column=6)
    protected String ssn;
	@MapToColumn(column=7)
    protected String ssnDataQuality;
	@MapToColumn(column=8)
    protected String dob;
	@MapToColumn(column=9)
    protected String dobDataQuality;
	@MapToColumn(column=10)
    protected String AmIndAKNative;
	@MapToColumn(column=11)
    protected String Asian;
	@MapToColumn(column=12)
    protected String BlackAfAmerican;
	@MapToColumn(column=13)
    protected String NativeHIOtherPacific;
	@MapToColumn(column=14)
    protected String White;
	@MapToColumn(column=15)
    protected String RaceNone;
	@MapToColumn(column=16)
    protected String Ethnicity;
	@MapToColumn(column=17)
    protected String Gender;
	@MapToColumn(column=18)
    protected String VeteranStatus;
	@MapToColumn(column=19)
    protected String YearEnteredService;
	@MapToColumn(column=20)
    protected String YearSeparated;
	@MapToColumn(column=21)
    protected String WorldWarII;
	@MapToColumn(column=22)
    protected String KoreanWar;
	@MapToColumn(column=23)
    protected String VietnamWar;
	@MapToColumn(column=24)
    protected String DesertStorm;
	@MapToColumn(column=25)
    protected String AfghanistanOEF;
	//IraqOIF	IraqOND	OtherTheater	MilitaryBranch	DischargeStatus	
	//DateCreated	DateUpdated	UserID	DateDeleted	ExportID
	@MapToColumn(column=26)
    protected String IraqOIF;
	@MapToColumn(column=27)
    protected String IraqOND;
	@MapToColumn(column=28)
    protected String OtherTheater;
	@MapToColumn(column=29)
    protected String MilitaryBranch;
	@MapToColumn(column=30)
    protected String DischargeStatus;
	@MapToColumn(column=31)
    protected String DateCreated;
	@MapToColumn(column=32)
    protected String DateUpdated;
	@MapToColumn(column=33)
    protected String UserID;
	@MapToColumn(column=34)
    protected String DateDeleted;
	@MapToColumn(column=35)
    protected String ExportID;
	public String getPersonalID() {
		return personalID;
	}
	public void setPersonalID(String personalID) {
		this.personalID = personalID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getNameSuffix() {
		return nameSuffix;
	}
	public void setNameSuffix(String nameSuffix) {
		this.nameSuffix = nameSuffix;
	}
	public String getNameDataQuality() {
		return nameDataQuality;
	}
	public void setNameDataQuality(String nameDataQuality) {
		this.nameDataQuality = nameDataQuality;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getSsnDataQuality() {
		return ssnDataQuality;
	}
	public void setSsnDataQuality(String ssnDataQuality) {
		this.ssnDataQuality = ssnDataQuality;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getDobDataQuality() {
		return dobDataQuality;
	}
	public void setDobDataQuality(String dobDataQuality) {
		this.dobDataQuality = dobDataQuality;
	}
	public String getAmIndAKNative() {
		return AmIndAKNative;
	}
	public void setAmIndAKNative(String amIndAKNative) {
		AmIndAKNative = amIndAKNative;
	}
	public String getAsian() {
		return Asian;
	}
	public void setAsian(String asian) {
		Asian = asian;
	}
	public String getBlackAfAmerican() {
		return BlackAfAmerican;
	}
	public void setBlackAfAmerican(String blackAfAmerican) {
		BlackAfAmerican = blackAfAmerican;
	}
	public String getNativeHIOtherPacific() {
		return NativeHIOtherPacific;
	}
	public void setNativeHIOtherPacific(String nativeHIOtherPacific) {
		NativeHIOtherPacific = nativeHIOtherPacific;
	}
	public String getWhite() {
		return White;
	}
	public void setWhite(String white) {
		White = white;
	}
	public String getRaceNone() {
		return RaceNone;
	}
	public void setRaceNone(String raceNone) {
		RaceNone = raceNone;
	}
	public String getEthnicity() {
		return Ethnicity;
	}
	public void setEthnicity(String ethnicity) {
		Ethnicity = ethnicity;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getVeteranStatus() {
		return VeteranStatus;
	}
	public void setVeteranStatus(String veteranStatus) {
		VeteranStatus = veteranStatus;
	}
	public String getYearEnteredService() {
		return YearEnteredService;
	}
	public void setYearEnteredService(String yearEnteredService) {
		YearEnteredService = yearEnteredService;
	}
	public String getYearSeparated() {
		return YearSeparated;
	}
	public void setYearSeparated(String yearSeparated) {
		YearSeparated = yearSeparated;
	}
	public String getWorldWarII() {
		return WorldWarII;
	}
	public void setWorldWarII(String worldWarII) {
		WorldWarII = worldWarII;
	}
	public String getKoreanWar() {
		return KoreanWar;
	}
	public void setKoreanWar(String koreanWar) {
		KoreanWar = koreanWar;
	}
	public String getVietnamWar() {
		return VietnamWar;
	}
	public void setVietnamWar(String vietnamWar) {
		VietnamWar = vietnamWar;
	}
	public String getDesertStorm() {
		return DesertStorm;
	}
	public void setDesertStorm(String desertStorm) {
		DesertStorm = desertStorm;
	}
	public String getAfghanistanOEF() {
		return AfghanistanOEF;
	}
	public void setAfghanistanOEF(String afghanistanOEF) {
		AfghanistanOEF = afghanistanOEF;
	}
	public String getIraqOIF() {
		return IraqOIF;
	}
	public void setIraqOIF(String iraqOIF) {
		IraqOIF = iraqOIF;
	}
	public String getIraqOND() {
		return IraqOND;
	}
	public void setIraqOND(String iraqOND) {
		IraqOND = iraqOND;
	}
	public String getOtherTheater() {
		return OtherTheater;
	}
	public void setOtherTheater(String otherTheater) {
		OtherTheater = otherTheater;
	}
	public String getMilitaryBranch() {
		return MilitaryBranch;
	}
	public void setMilitaryBranch(String militaryBranch) {
		MilitaryBranch = militaryBranch;
	}
	public String getDischargeStatus() {
		return DischargeStatus;
	}
	public void setDischargeStatus(String dischargeStatus) {
		DischargeStatus = dischargeStatus;
	}
	public String getDateCreated() {
		return DateCreated;
	}
	public void setDateCreated(String dateCreated) {
		DateCreated = dateCreated;
	}
	public String getDateUpdated() {
		return DateUpdated;
	}
	public void setDateUpdated(String dateUpdated) {
		DateUpdated = dateUpdated;
	}
	public String getUserID() {
		return UserID;
	}
	public void setUserID(String userID) {
		UserID = userID;
	}
	public String getDateDeleted() {
		return DateDeleted;
	}
	public void setDateDeleted(String dateDeleted) {
		DateDeleted = dateDeleted;
	}
	public String getExportID() {
		return ExportID;
	}
	public void setExportID(String exportID) {
		ExportID = exportID;
	}
	
	
	

}
