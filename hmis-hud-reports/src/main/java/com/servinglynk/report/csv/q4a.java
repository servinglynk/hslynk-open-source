package com.servinglynk.report.csv;
/***
 * Coming up with Sage's format for 4a
 * @author sdolia
 *Organization name	All Practical Reporting, Inc.
Organization ID	APR
Project name	APR - Permanent Housing
Project ID	441
HMIS Project Type	3
Method of tracking ES	
If HMIS Project ID = 6 (S Only), is the Services Only (HMIS Project Type 6) affiliated with a residential project?	0
Identify the Project ID's of the housing projects this project is affiliated with	

 */
public class q4a {
private String title;
private String value;

public q4a(String title, String value) {
	super();
	this.title = title;
	this.value = value;
}
/**
 * @return the title
 */
public String getTitle() {
	return title;
}
/**
 * @param title the title to set
 */
public void setTitle(String title) {
	this.title = title;
}
/**
 * @return the value
 */
public String getValue() {
	return value;
}
/**
 * @param value the value to set
 */
public void setValue(String value) {
	this.value = value;
}
/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return this.title + " "+ this.value;
}


}
