package com.servinglynk.hmis.warehouse.report.business.exception;

public class ReportFontNotFound extends ReportCreationException {

	public static final String DEFAULT_MESSAGE = "May be One of the Font Used in Report not avaialable";

	public ReportFontNotFound() {
		super(DEFAULT_MESSAGE);
	}

	public ReportFontNotFound(String message) {
		super(message);
	}

	public ReportFontNotFound(Throwable cause) {
		super(DEFAULT_MESSAGE, cause);
	}

	public ReportFontNotFound(String message, Throwable cause) {
		super(message, cause);
	}
	
	
	
}
