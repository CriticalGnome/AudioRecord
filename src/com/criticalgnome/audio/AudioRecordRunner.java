/*
 * Project AudioRecord
 * @author Sergey Kalinovsky
 * @version 1.0
 */
package com.criticalgnome.audio;

import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import com.criticalgnome.audio.beans.*;
import com.criticalgnome.audio.exceptions.CollectionEmptyEx;
import com.criticalgnome.audio.utils.*;

public class AudioRecordRunner {

	/**
	 * Main method. Entry point.
	 *
	 * @param args
	 *            Command line arguments
	 * @throws CollectionEmptyEx Custom exception
	 */
	public static void main(String[] args) throws CollectionEmptyEx {
		
		List<Track> tracks = new ArrayList<Track>();
		
		Collection myCollection = new Collection("My Collection", 0, tracks);
		myCollection = FileOperations.loadSession(myCollection);

		CalendarOperations.printCurrentDateAndTime();

		while (true) {
			MainMenu.mainMenu();
			switch (Keyboard.inputNumber()) {

			case Variables.ADD_TRACK:
				myCollection = AddTrack.addTrack(myCollection);
				break;
			case Variables.REMOVE_TRACK:
				myCollection = RemoveTrack.removeTrack(myCollection);
				break;
			case Variables.SORT_COLLECTION:
				myCollection = SortCollection.sortByStyle(myCollection);
				break;
			case Variables.TAKE_BY_DURATION:
				SelectTracks.selectByDuration(myCollection);
				break;
			case Variables.RECORD_DISK:
				WriteCollection.writeToDisk(myCollection);
				break;
			case Variables.EXIT:
				FileOperations.saveSession(myCollection);
				System.out.println("Работа завершена...");
				System.exit(0);
			default:
				System.out.println(Variables.INVALID_INPUT);
				Toolkit.getDefaultToolkit().beep();
			}
		}
	}
}
