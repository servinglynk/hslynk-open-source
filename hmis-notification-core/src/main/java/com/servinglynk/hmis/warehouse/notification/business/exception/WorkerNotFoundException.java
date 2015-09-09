package com.servinglynk.hmis.warehouse.notification.business.exception;

@SuppressWarnings("serial")
public class WorkerNotFoundException extends NotifcationException {

		public static final String DEFAULT_MESSAGE = "The specified worker line does not exists";

		public WorkerNotFoundException() {
			super(DEFAULT_MESSAGE);
		}

		public WorkerNotFoundException(String message) {
			super(message);
		}

		public WorkerNotFoundException(Throwable cause) {
			super(DEFAULT_MESSAGE, cause);
		}

		public WorkerNotFoundException(String message, Throwable cause) {
			super(message, cause);
		}
	}
