/*
 * Project AudioRecord
 * @author Sergey Kalinovsky
 * @version 1.0
 */
package com.criticalgnome.audio;

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
			System.out.println("\nПредыдущая сессия не найдена. Будем использовать пустую коллекцию.");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}


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
				try {
					FileOutputStream os = new FileOutputStream("Files/Collection.bin");
					ObjectOutputStream oos = new ObjectOutputStream(os);
					oos.writeObject(myCollection);
					oos.close();
					System.out.println("Сессия успешно сохранена.");
				} catch (FileNotFoundException e) {
					System.out.println("Не удалось сохранить сессию. Скорее всего в текущем каталоге отсутствует папка \"Files\".");
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println("Работа завершена.");
				System.exit(0);
			default:
				System.out.println(Variables.INVALID_INPUT);
				Toolkit.getDefaultToolkit().beep();
			}
		}
	}
}
