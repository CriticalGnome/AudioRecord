/*
 * Project AudioRecord
 * @author Sergey Kalinovsky
 * @version 1.0
 */
package com.criticalgnome.audio.utils;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarOperations {

	/**
	 * Print current Date and Time to console
	 */
	public static void printCurrentDateAndTime() {
		Calendar calendar = new GregorianCalendar();
		System.out.print("Добро пожаловать. Сегодня "
		+ calendar.get(Calendar.DATE) + "." 
		+ (calendar.get(Calendar.MONTH) + 1) + "." 
		+ calendar.get(Calendar.YEAR) + ", местное время "
		+ calendar.get(Calendar.HOUR_OF_DAY) + ":"
		+ calendar.get(Calendar.MINUTE));
	}

}
