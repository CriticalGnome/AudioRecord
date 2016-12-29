/*
 * Project AudioRecord
 * @author Sergey Kalinovsky
 * @version 1.0
 */
package com.criticalgnome.audio;

// TODO Реализовать в итоговом проекте модуля custom exceptions и их корректную обработку
// TODO Реализовать +List+, Set, Map в итоговом проекте
// TODO Реализовать сериализацию в итоговом проекте (иерархия, static, transient)
// TODO Использовать ListIterator в итоговом проекте
// TODO Реализовать перечисления в итоговом проекте
// TODO Реализовать параметризацию (generics) в итоговом проекте 

import java.awt.Toolkit;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
	 * @throws CollectionEmptyEx
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
		try {
			FileInputStream is = new FileInputStream("Files/Collection.bin");
			ObjectInputStream ois = new ObjectInputStream(is);
			myCollection = (Collection) ois.readObject();
			ois.close();
			System.out.println("\nПредыдущая сессия успешно импротирована.");
		} catch (FileNotFoundException e) {
			System.out.println("\nПредыдущая сессия не найдена. Используем пустую коллекцию.");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}


		while (true) {
			// Main menu
			MainMenu.mainMenu();
			switch (Keyboard.inputNumber()) {

			case Variables.ADD_TRACK:
				// Add file to collection
				myCollection = AddTrack.addTrack(myCollection);
				break;
			case Variables.REMOVE_TRACK:
				// Remove file from collection
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
				// Program exit
				try {
					FileOutputStream os = new FileOutputStream("Files/Collection.bin");
					ObjectOutputStream oos = new ObjectOutputStream(os);
					oos.writeObject(myCollection);
					oos.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println("Работа завершена...");
				System.exit(0);
			default:
				System.out.println(Variables.INVALID_INPUT);
				Toolkit.getDefaultToolkit().beep();
			}
		}
	}
}
