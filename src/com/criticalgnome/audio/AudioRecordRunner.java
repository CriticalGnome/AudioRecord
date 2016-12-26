/*
 * Project AudioRecord
 * @author Sergey Kalinovsky
 * @version 1.0
 */
package com.criticalgnome.audio;

// TODO Реализовать в итоговом проекте счетчик объектов через static
// TODO Реализовать в итоговом проекте модуля custom exceptions и их корректную обработку
// TODO Реализовать +List+, Set, Map в итоговом проекте
// TODO Реализовать запись/чтение символьной и байтовой информации в файл в итоговом проекте
// TODO Реализовать сериализацию в итоговом проекте (иерархия, static, transient)
// TODO Использовать ListIterator в итоговом проекте

import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import com.criticalgnome.audio.beans.*;
import com.criticalgnome.audio.utils.*;

public class AudioRecordRunner {

	/**
	 * Main method. Entry point.
	 *
	 * @param args
	 *            Command line arguments
	 */
	public static void main(String[] args) {
		
		Calendar calendar = new GregorianCalendar();
		System.out.print("Добро пожаловать. Сегодня "
		+ calendar.get(Calendar.DATE) + "." 
		+ (calendar.get(Calendar.MONTH) + 1) + "." 
		+ calendar.get(Calendar.YEAR) + ", местное время "
		+ calendar.get(Calendar.HOUR_OF_DAY) + ":"
		+ calendar.get(Calendar.MINUTE));

		List<Track> tracks = new ArrayList<Track>();
		
		Collection myCollection = new Collection("My Collection", 0, tracks);

		while (true) {
			// Main menu
			MenuItems.mainMenu();
			switch (Keyboard.inputNumber()) {

			case Variables.ADD_TRACK:
				// Add file to collection
				myCollection = MenuItems.addTrack(myCollection);
				break;
			case Variables.DEL_TRACK:
				// Remove file from collection
				myCollection = MenuItems.delTrack(myCollection);
				break;
			case Variables.SORT_COLLECTION:
				myCollection = MenuItems.sortByStyle(myCollection);
				break;
			case Variables.TAKE_BY_DURATION:
				MenuItems.selectByDuration(myCollection);
				break;
			case Variables.RECORD_DISK:
				MenuItems.writeToDisk(myCollection);
				break;
			case Variables.EXIT:
				// Program exit
				System.out.println("Работа завершена...");
				System.exit(0);
			default:
				System.out.println(Variables.INVALID_INPUT);
				Toolkit.getDefaultToolkit().beep();
			}
		}
	}
}
