/*
 * Project AudioRecord
 * @author Sergey Kalinovsky
 * @version 1.0
 */
package com.criticalgnome.audio.utils;

import java.awt.Toolkit;

import com.criticalgnome.audio.beans.Collection;
import com.criticalgnome.audio.beans.Track;

public class MenuItems {
	
	/**
	 * Adds the track to collection.
	 */
	public static void addTrack() {
		int number = -1;
		while (number != Variables.EXIT) {
			System.out.println("==================================================================");
			System.out.println("Список файлов на жёстком диске");
			System.out.println("------------------------------------------------------------------");

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
			System.out.println("------------------------------------------------------------------");
			System.out.println("Свободное место в коллекции: " + Convert
					.toMinAndSec(Variables.DISK_DURATION - Collection.collection.getDuration()));
			System.out.print("Какой трек добавить? (0 - отмена): ");
			number = Keyboard.inputNumber();
			if (number == Variables.EXIT) {
				break;
			}
			if (number < 1 || number - 1 > Track.files.size()) {
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
				System.out.println("------------------------------------------------------------------");
				System.out.println("Коллекция пуста!");
				Toolkit.getDefaultToolkit().beep();
				break;
			}
			System.out.println("==================================================================");
			System.out.println("Музыкальная коллекция \"" + Collection.collection.getName() + "\".");
			System.out.println("------------------------------------------------------------------");
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
			System.out.println("------------------------------------------------------------------");
			System.out.println("Всего треков: " + Track.tracks.size() + ". Суммарная длительность: "
					+ Convert.toMinAndSec(Collection.collection.getDuration()));
			System.out.print("Какой трек удалить? (0 - отмена): ");
			number = Keyboard.inputNumber();
			if (number == Variables.EXIT) {
				break;
			}
			if (number < 1 || number - 1 > Track.tracks.size()) {
				System.out.println(Variables.INVALID_INPUT);
				Toolkit.getDefaultToolkit().beep();
				continue;
			}
			Collection.collection.setDuration((Collection.collection.getDuration() - Track.tracks.get(number - 1).getDuration()));
			Track.tracks.remove(number - 1);
				System.out.println("Удаляем трек номер " + number);
		}

	}
}
