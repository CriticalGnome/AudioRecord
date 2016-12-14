/*
 * Project AudioRecord
 * @author Sergey Kalinovsky
 * @version 1.0
 */
package com.criticalgnome.audio.utils;

import java.awt.Toolkit;

import com.criticalgnome.audio.beans.Collection;
import com.criticalgnome.audio.beans.Track;

// TODO: Auto-generated Javadoc
/**
 * The Class MenuItems.
 */
public class MenuItems {
	
	/**
	 * Main menu.
	 */
	public static void mainMenu() {
		System.out.println(Variables.THICK_LINE);
		System.out.println("\tAudio Recorder");
		System.out.println(Variables.THIN_LINE);
		System.out.println("1. Добавить трек в коллекцию");
		System.out.println("2. Удалить трек из коллекции");
		System.out.println("3. Отсортировать коллекцию");
		System.out.println("4. Вывести список треков с заданной длительностью");
		System.out.println("5. Записать коллекцию на диск");
		System.out.println("0. Выход");
		System.out.println(Variables.THIN_LINE);
		System.out.print("Введите команду: ");

	}
	/**
	 * Adds the track to collection.
	 */
	public static void addTrack() {
		int number = -1;
		while (number != Variables.EXIT) {
			System.out.println(Variables.THICK_LINE);
			System.out.println("Список файлов на жёстком диске");
			System.out.println(Variables.THIN_LINE);

			// Print list of available files
			for (int i = 0; i < Track.files.size(); i++) {
				if (i < 9) {
					System.out.print("0");
				}
				System.out.print((i + 1) + ". ");
				System.out.print(Track.files.get(i).getAuthor() + " - ");
				System.out.print(Track.files.get(i).getName() + " [");
				System.out.print(Track.files.get(i).getStyle() + "] (");
				System.out.println(Convert.toMinAndSec(Track.files.get(i).getDuration()) + ")");
			}
			System.out.println(Variables.THIN_LINE);
			System.out.println("Свободное место в коллекции: " + Convert
					.toMinAndSec(Variables.DISK_DURATION - Collection.collection.getDuration()));
			System.out.print("Какой трек добавить? (0 - отмена): ");
			number = Keyboard.inputNumber();
			if (number == Variables.EXIT) {
				break;
			}
			if (number < 1 || number - 1 >= Track.files.size()) {
				System.out.println(Variables.INVALID_INPUT);
				Toolkit.getDefaultToolkit().beep();
				continue;
			}
			if (((Variables.DISK_DURATION - Collection.collection.getDuration())
					- Track.files.get(number - 1).getDuration()) < 0) {
				System.out.println("Недостаточно свободного времени в коллекции.");
				Toolkit.getDefaultToolkit().beep();
				continue;
			}
			Track.tracks.add(Track.files.get(number - 1));
			Collection.collection.setDuration(
					Collection.collection.getDuration() + Track.files.get(number - 1).getDuration());
			System.out.println("Композиция " + Track.files.get(number - 1).getName()
					+ " успешно добавлена в коллекцию.");
		}
	}

	/**
	 * Remove the track from collection.
	 */
	public static void delTrack() {
		int number = -1;
		while (number != Variables.EXIT) {
			if (Track.tracks.size() == 0) {
				System.out.println("Коллекция пуста!");
				Toolkit.getDefaultToolkit().beep();
				break;
			}
			System.out.println(Variables.THICK_LINE);
			System.out.println("Музыкальная коллекция \"" + Collection.collection.getName() + "\".");
			System.out.println(Variables.THIN_LINE);
			// Print tracks in collection
			for (int i = 0; i < Track.tracks.size(); i++) {
				if (i < 9) {
					System.out.print("0");
				}
				System.out.print((i + 1) + ". ");
				System.out.print(Track.tracks.get(i).getAuthor() + " - ");
				System.out.print(Track.tracks.get(i).getName() + " [");
				System.out.print(Track.tracks.get(i).getStyle() + "] (");
				System.out.println(Convert.toMinAndSec(Track.tracks.get(i).getDuration()) + ")");
			}
			System.out.println(Variables.THIN_LINE);
			System.out.println("Всего треков: " + Track.tracks.size() + ". Суммарная длительность: "
					+ Convert.toMinAndSec(Collection.collection.getDuration()));
			System.out.print("Какой трек удалить? (0 - отмена): ");
			number = Keyboard.inputNumber();
			if (number == Variables.EXIT) {
				break;
			}
			if (number < 1 || number - 1 >= Track.tracks.size()) {
				System.out.println(Variables.INVALID_INPUT);
				Toolkit.getDefaultToolkit().beep();
				continue;
			}
			Collection.collection.setDuration((Collection.collection.getDuration() - Track.tracks.get(number - 1).getDuration()));
			System.out.println("Композиция " + Track.tracks.get(number - 1).getName() + " удалена из коллекции.");
			Track.tracks.remove(number - 1);
		}

	}
	
	/**
	 * Sort collection by style.
	 */
	public static void sortByStyle() {
		System.out.println(Variables.NOT_REALISED);
	}
	
	/**
	 * Select tracks by duration.
	 */
	public static void selectByDuration() {
		System.out.println(Variables.NOT_REALISED);
	}
	
	/**
	 * Write collection to disk.
	 */
	public static void writeToDisk() {
		System.out.println(Variables.NOT_REALISED);
	}
}
