/*
 * Project AudioRecord
 * @author Sergey Kalinovsky
 * @version 1.0
 */
package com.criticalgnome.audio;

import com.criticalgnome.audio.classes.Collection;
import com.criticalgnome.audio.classes.Track;

public class AudioRecordRunner {

	/**
	 * Главный метод. Точка входа.
	 *
	 * @param args
	 *            аргументы
	 */
	public static void main(String[] args) {
		
		Track[] tracks = new Track[2];

		tracks[0] = new Track("Californication", 322, "Rock", "RHCP");
		tracks[1] = new Track("Nothing else matters", 385, "Heavy Metal", "Metallica");

		Collection collection1 = new Collection("My Collection", 0);
		// FIXME Реализовать добавление треков в коллекцию

		// Вывод первичного списка
		System.out.println("Музыкальная коллекция \"" + collection1.getName() + "\".");
		System.out.println("------------------------------------------------------------------");
		int collectionDuration = 0;
		for (int i = 0; i < tracks.length; i++) {
			if (i < 10) {
				System.out.print("0");
			}
			System.out.print((i + 1) + ". ");
			System.out.print(tracks[i].getAuthor() + " - ");
			System.out.print(tracks[i].getName() + " [");
			System.out.print(tracks[i].getStyle() + "] (");
			System.out.println(toMinAndSec(tracks[i].getDuration()) + ")");
			collectionDuration += tracks[i].getDuration();
		}
		collection1.setDuration(collectionDuration);
		System.out.println("------------------------------------------------------------------");
		System.out.println("Суммарная длительность коллекции: " + toMinAndSec(collectionDuration));

		// TODO Здесь будет сортировка

		// TODO Здесь будет вывод треков, соответствующих заданным параметрам
		// (длительность)

		// TODO Коллекция collection1 содержит список треков. Записываем ее на
		// диск
	}

	/**
	 * Переводит секунды в минуты и секунды
	 *
	 * @param durationInSec
	 *            время в секундах
	 * @return string : "n мин. n сек."
	 */
	static String toMinAndSec(int durationInSec) {
		String str = (durationInSec / 60) + " мин. " + (durationInSec % 60) + " сек.";
		return str;
	}
}
