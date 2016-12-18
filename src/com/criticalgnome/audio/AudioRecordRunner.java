/*
 * Project AudioRecord
 * @author Sergey Kalinovsky
 * @version 1.0
 */
package com.criticalgnome.audio;

import java.awt.Toolkit;

//import java.awt.Toolkit;

import com.criticalgnome.audio.utils.*;

public class AudioRecordRunner {

	/**
	 * Main method. Entry point.
	 *
	 * @param args
	 *            Command line arguments
	 * @throws CommandOutOfRange 
	 */
	public static void main(String[] args) {

		// Fill files list by fabricated evidence
		Variables.fillFilesList();
		
		while (true) {
			// Main menu
			MenuItems.mainMenu();
			switch (Keyboard.inputNumber()) {

			case Variables.ADD_TRACK:
				// Add file to collection
				MenuItems.addTrack();
				break;
			case Variables.DEL_TRACK:
				// Remove file from collection
				MenuItems.delTrack();
				break;
			case Variables.SORT_COLLECTION:
				MenuItems.sortByStyle();
				break;
			case Variables.TAKE_BY_DURATION:
				MenuItems.selectByDuration();
				break;
			case Variables.RECORD_DISK:
				MenuItems.writeToDisk();
				break;
			case Variables.EXIT:
				// Выход
				System.out.println("Работа завершена...");
				System.exit(0);
			default:
				System.out.println(Variables.INVALID_INPUT);
				Toolkit.getDefaultToolkit().beep();
			}
		}
	}
}
