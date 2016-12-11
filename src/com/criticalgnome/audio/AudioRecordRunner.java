/*
 * Project AudioRecord
 * @author Sergey Kalinovsky
 * @version 1.0
 */
package com.criticalgnome.audio;

import java.awt.Toolkit;

import com.criticalgnome.audio.classes.*;
import com.criticalgnome.audio.utils.*;

public class AudioRecordRunner {

	/**
	 * Главный метод. Точка входа.
	 *
	 * @param args
	 *            Аргументы командной строки
	 */
	public static void main(String[] args) {

		String notRealized = "Пока не реализовано.";
		
		Collection collection = new Collection("My Collection", 0);
		Track[] tracks = new Track[25];

		// Тестовый блок
		tracks[0] = new Track("Californication", 322, "Rock", "RHCP");
		tracks[1] = new Track("Nothing else matters", 385, "Heavy Metal", "Metallica");
		// Конец тестового блока

		while (true) {
			System.out.println("==================================================================");
			System.out.println("1. Добавить файл в коллекцию");
			System.out.println("2. Удалить файл из коллекции");
			System.out.println("3. Отсортировать коллекцию");
			System.out.println("4. Вывести список файлов с заданной длительностью");
			System.out.println("5. записать коллекцию на диск");
			System.out.println("0. Выход");
			System.out.println("------------------------------------------------------------------");

			switch (Keyboard.inputNumber()) {
			case 1:
				// TODO Тут будет добавление файла в коллекцию
				System.out.println(notRealized);
				break;
			case 2:
				// Удаление файла из коллекции
				int number = -1;
				while (number != 0) {
					if (tracks[0] == null) {
						System.out.println("------------------------------------------------------------------");
						System.out.println("Коллекция пуста!");
						break;
					}
					System.out.println("==================================================================");
					System.out.println("Музыкальная коллекция \"" + collection.getName() + "\".");
					System.out.println("------------------------------------------------------------------");
					int collectionDuration = 0;
					int collectionTracks = 0;
					// Вывод списка треков в коллекции
					for (int i = 0; i < tracks.length; i++) {
						if (tracks[i]==null) {
							break;
						}
						if (i < 10) {
							System.out.print("0");
						}
						System.out.print((i + 1) + ". ");
						System.out.print(tracks[i].getAuthor() + " - ");
						System.out.print(tracks[i].getName() + " [");
						System.out.print(tracks[i].getStyle() + "] (");
						System.out.println(Convert.toMinAndSec(tracks[i].getDuration()) + ")");
						collectionDuration += tracks[i].getDuration();
						collectionTracks++;
					}
					collection.setDuration(collectionDuration);
					System.out.println("------------------------------------------------------------------");
					System.out.println("Всего треков: " + collectionTracks + ". Суммарная длительность: " + Convert.toMinAndSec(collectionDuration));
					System.out.print("Какой трек удалить? (0 - отмена): ");
					number = Keyboard.inputNumber();
					if (number == 0) {
						break;
					}
					if (tracks[number-1] != null) {
						// Сдвигаем массив
						collectionTracks--;
						for (int i = number-1; i < tracks.length; i++) {
							if (tracks[i+1] == null) {
								tracks[i] = null;
								break;
							}
							else {
								tracks[i] = tracks[i+1];
							}
						}
						System.out.println("Удаляем трек номер " + number);
					}
				} ;
				break;
			case 3:
				// TODO Тут будет сортировка коллекции
				System.out.println(notRealized);
				break;
			case 4:
				// TODO Тут будет вывод выборки по критерию длительности
				System.out.println(notRealized);
				break;
			case 5:
				// TODO Тут будет запись на диск
				System.out.println(notRealized);
				break;
			case 0:
				// Выход
				System.out.println("------------------------------------------------------------------");
				System.out.println("Работа завершена...");
				System.exit(0);
			default:
				System.out.println("------------------------------------------------------------------");
				System.out.println("Неверный ввод. Попробуйте еще раз");
				Toolkit.getDefaultToolkit().beep();
			}
		}
	}

}
