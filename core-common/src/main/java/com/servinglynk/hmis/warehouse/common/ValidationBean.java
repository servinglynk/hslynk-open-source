package com.servinglynk.hmis.warehouse.common;

/* Surya Yadavalli - 05/23/2015  validations
 * To -do - Use DB to populate pre-defined lenghts for validations */

public class ValidationBean {
	
	protected int pwMaxLength;
	protected int pwMinLength;
	protected int fnMaxLength;
	protected int lnMaxLength;
	protected int mnMaxLength;
	protected int minLength;
	protected String specialChars;

	protected int maxPwattempts;
	protected String lockoutMinutes;
	protected int maxExternalDeviceIdLength;
	protected int maxFriendlyNameLength;
	

	public int getMaxPwattempts() {
		return maxPwattempts;
	}
	public void setMaxPwattempts(int maxPwattempts) {
		this.maxPwattempts = maxPwattempts;
	}
	public String getLockoutMinutes() {
		return lockoutMinutes;
	}
	public void setLockoutMinutes(String lockoutMinutes) {
		this.lockoutMinutes = lockoutMinutes;
	}

	
	public int getMnMaxLength() {
		return mnMaxLength;
	}
	public void setMnMaxLength(int mnMaxLength) {
		this.mnMaxLength = mnMaxLength;
	}
	public int getPwMaxLength() {
		return pwMaxLength;
	}
	public void setPwMaxLength(int pwMaxLength) {
		this.pwMaxLength = pwMaxLength;
	}
	public int getFnMaxLength() {
		return fnMaxLength;
	}
	public void setFnMaxLength(int fnMaxLength) {
		this.fnMaxLength = fnMaxLength;
	}
	public int getLnMaxLength() {
		return lnMaxLength;
	}
	public void setLnMaxLength(int lnMaxLength) {
		this.lnMaxLength = lnMaxLength;
	}

	public int getMinLength() {
		return minLength;
	}
	public void setMinLength(int minLength) {
		this.minLength = minLength;
	}
	public String getSpecialChars() {
		return specialChars;
	}
	public void setSpecialChars(String specialChars) {
		this.specialChars = specialChars;
	}
	public int getPwMinLength() {
		return pwMinLength;
	}
	public void setPwMinLength(int pwMinLength) {
		this.pwMinLength = pwMinLength;
	}
	protected int maxLength;
	public int getMaxLength() {
		return maxLength;
	}
	public void setMaxLength(int maxLength) {
		this.maxLength = maxLength;
	}
	public int getMaxExternalDeviceIdLength() {
		return maxExternalDeviceIdLength;
	}
	public void setMaxExternalDeviceIdLength(int maxExternalDeviceIdLength) {
		this.maxExternalDeviceIdLength = maxExternalDeviceIdLength;
	}
	public int getMaxFriendlyNameLength() {
		return maxFriendlyNameLength;
	}
	public void setMaxFriendlyNameLength(int maxFriendlyNameLength) {
		this.maxFriendlyNameLength = maxFriendlyNameLength;
	}
}
