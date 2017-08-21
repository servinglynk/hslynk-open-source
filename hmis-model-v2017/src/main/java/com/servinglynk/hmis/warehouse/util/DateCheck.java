package com.servinglynk.hmis.warehouse.util;

import java.time.LocalDateTime;

public class DateCheck {

	public static void main(String args[]) {
		LocalDateTime currentTime = LocalDateTime.now();
		LocalDateTime  fiveMinutesAgo = LocalDateTime.now().minusMinutes(5);
		LocalDateTime fiveMinutesLater = LocalDateTime.now().plusMinutes(5);
		
			if( currentTime.compareTo(currentTime) == 0) {
				System.out.println("Time matches");
			} if( currentTime.compareTo(fiveMinutesAgo) > 0) {
				System.out.println("Current Time was "+currentTime+"Time matches Five years ago"+fiveMinutesAgo +" and the val is "+currentTime.compareTo(fiveMinutesAgo));
			} if( currentTime.compareTo(fiveMinutesLater) < 0) {
				System.out.println("Current Time was "+currentTime+"Time matches fiveMinutesLater"+fiveMinutesLater+" val is "+currentTime.compareTo(fiveMinutesLater));
			}
	}
}
