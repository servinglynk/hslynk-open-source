package com.servinglynk.hmis.warehouse.service.exception;

public class BulkUploadServiceException extends RuntimeException {

	/**
	 * Default exception message
	 */
	public static final String DEFAULT_MESSAGE = "Bulk Upload Service issues";

	public BulkUploadServiceException() {
		super(DEFAULT_MESSAGE);
	}

	public BulkUploadServiceException(String message) {
		super(message);
	}

	public BulkUploadServiceException(Throwable cause) {
		super(DEFAULT_MESSAGE, cause);
	}

	public BulkUploadServiceException(String message, Throwable cause) {
		super(message, cause);
	}

}

