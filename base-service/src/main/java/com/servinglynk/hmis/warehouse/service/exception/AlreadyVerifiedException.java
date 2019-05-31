package com.servinglynk.hmis.warehouse.service.exception;

@SuppressWarnings("serial")
public class AlreadyVerifiedException extends RuntimeException{


		/**

		 * Default exception message

		 */

		public static final String DEFAULT_MESSAGE = "account already verified";



		public AlreadyVerifiedException() {

			super(DEFAULT_MESSAGE);

		}



		public AlreadyVerifiedException(String message) {

			super(message);

		}



		public AlreadyVerifiedException(Throwable cause) {

			super(DEFAULT_MESSAGE, cause);

		}



		public AlreadyVerifiedException(String message, Throwable cause) {

			super(message, cause);

		}



	}



