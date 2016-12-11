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
		String invalidInput = "Неверный ввод. Попробуйте ещё раз.";
		int collectionFreeSpace = 4800;
		int number;

		Collection collection = new Collection("My Collection", 0);
		Track[] tracks = new Track[25];
		Track[] files = new Track[25];

		// Список файлов
		files[0] = new Track("TWIST", 215, "Rock-n-Roll", "Chubby Checker");
		files[1] = new Track("SMOOTH", 253, "Latin Pop", "Santana Featuring Rob Thomas");
		files[2] = new Track("MACK THE KNIFE", 192, "jazz", "Bobby Darin");
		files[3] = new Track("HOW DO I LIVE", 268, "Pop", "LeAnn Rimes");
		files[4] = new Track("PARTY ROCK ANTHEM", 263, "Electro House", "LMFAO Featuring Lauren Bennett & GoonRock");
		files[5] = new Track("I GOTTA FEELING", 291, "Dance", "The Black Eyed Peas");
		files[6] = new Track("MACARENA (BAYSIDE BOYS MIX)", 237, "Dance", "Los Del Rio");
		files[7] = new Track("PHYSICAL", 223, "Dance", "Olivia Newton-John");
		files[8] = new Track("YOU LIGHT UP MY LIFE", 209, "Pop", "Debby Boone");
		files[9] = new Track("HEY JUDE", 428, "Pop-Rock", "The Beatles");
		files[10] = new Track("WE BELONG TOGETHER", 200, "R&B", "Mariah Carey");
		files[11] = new Track("UPTOWN FUNK!", 270, "Funk", "Mark Ronson Featuring Bruno Mars");
		files[12] = new Track("UN-BREAK MY HEART", 272, "Pop", "Toni Braxton");
		files[13] = new Track("YEAH!", 250, "Hip-Hop", "Usher Featuring Lil Jon & Ludacris");
		files[14] = new Track("BETTE DAVIS EYES", 228, "Soft Rock", "Kim Carnes");
		files[15] = new Track("ENDLESS LOVE", 268, "Pop", "Diana Ross & Lionel Richie");
		files[16] = new Track("TONIGHT\'S THE NIGHT (GONNA BE ALRIGHT)", 236, "Soft Rock", "Rod Stewart");
		files[17] = new Track("FOOLISH GAMES / YOU WERE MEANT FOR ME", 253, "Folk", "Jewel");
		files[18] = new Track("(EVERYTHING I DO) I DO IT FOR YOU", 394, "Soft Rock", "Bryan Adams");
		files[19] = new Track("I'LL MAKE LOVE TO YOU", 244, "R&B", "Boyz II Men");
		files[20] = new Track("THE THEME FROM \"A SUMMER PLACE\"", 145, "Easy Listening",
				"Percy Faith And His Orchestra");
		files[21] = new Track("LE FREAK", 323, "Disco", "Chic");
		files[22] = new Track("HOW DEEP IS YOUR LOVE", 246, "Pop", "Bee Gees");
		files[23] = new Track("EYE OF THE TIGER", 246, "Rock", "Survivor");
		files[24] = new Track("WE FOUND LOVE", 205, "Electro House", "Rihanna Featuring Calvin Harris");

		while (true) {
			System.out.println("==================================================================");
			System.out.println("1. Добавить файл в коллекцию");
			System.out.println("2. Удалить файл из коллекции");
			System.out.println("3. Отсортировать коллекцию");
			System.out.println("4. Вывести список файлов с заданной длительностью");
			System.out.println("5. Записать коллекцию на диск");
			System.out.println("0. Выход");
			System.out.println("------------------------------------------------------------------");

			switch (Keyboard.inputNumber()) {
			case 1:
				// TODO Добавление файла в коллекцию
				number = -1;
				while (number != 0) {
					System.out.println("==================================================================");
					System.out.println("Список файлов на жёстком диске");
					System.out.println("------------------------------------------------------------------");
					
					// Вывод списка треков в коллекции
					for (int i = 0; i < files.length; i++) {
						if (i < 9) {
							System.out.print("0");
						}
						System.out.print((i + 1) + ". ");
						System.out.print(files[i].getAuthor() + " - ");
						System.out.print(files[i].getName() + " [");
						System.out.print(files[i].getStyle() + "] (");
						System.out.println(Convert.toMinAndSec(files[i].getDuration()) + ")");
					}
					System.out.println("------------------------------------------------------------------");
					System.out.println("Свободное место в коллекции: " + Convert.toMinAndSec(collectionFreeSpace));
					System.out.print("Какой трек добавить? (0 - отмена): ");
					number = Keyboard.inputNumber();
					if (number == 0) {
						break;
					}
					if (number < 1 || number -1 > files.length) {
						System.out.println(invalidInput);
						Toolkit.getDefaultToolkit().beep();
						continue;
					}
					if ((collectionFreeSpace - files[number-1].getDuration()) < 0) {
						System.out.println("Недостаточно свободного времени в коллекции.");
						Toolkit.getDefaultToolkit().beep();
						continue;
					}
					for (int i = 0; i < tracks.length; i++) {
						if (tracks[i] == null) {
							tracks[i] = files[number-1];
							collectionFreeSpace -= files[number-1].getDuration();
							System.out.println("Композиция " + files[number-1].getName() + " успешно добавлена в коллекцию.");
							break;
						}
					}
				}

				break;
			case 2:
				// Удаление файла из коллекции
				number = -1;
				while (number != 0) {
					if (tracks[0] == null) {
						System.out.println("------------------------------------------------------------------");
						System.out.println("Коллекция пуста!");
						Toolkit.getDefaultToolkit().beep();
						break;
					}
					System.out.println("==================================================================");
					System.out.println("Музыкальная коллекция \"" + collection.getName() + "\".");
					System.out.println("------------------------------------------------------------------");
					int collectionDuration = 0;
					int collectionTracks = 0;
					// Вывод списка треков в коллекции
					for (int i = 0; i < tracks.length; i++) {
						if (tracks[i] == null) {
							break;
						}
						if (i < 9) {
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
					System.out.println("Всего треков: " + collectionTracks + ". Суммарная длительность: "
							+ Convert.toMinAndSec(collectionDuration));
					System.out.print("Какой трек удалить? (0 - отмена): ");
					number = Keyboard.inputNumber();
					if (number == 0) {
						break;
					}
					if (number < 1 || number -1 > tracks.length) {
						System.out.println(invalidInput);
						Toolkit.getDefaultToolkit().beep();
						continue;
					}
					if (tracks[number - 1] != null) {
						collectionFreeSpace += tracks[number - 1].getDuration();
						collectionTracks--;
						// Сдвигаем массив
						for (int i = number - 1; i < tracks.length; i++) {
							if (tracks[i + 1] == null) {
								tracks[i] = null;
								break;
							} else {
								tracks[i] = tracks[i + 1];
							}
						}
						System.out.println("Удаляем трек номер " + number);
					}
					else {
						System.out.println(invalidInput);
						Toolkit.getDefaultToolkit().beep();
					}
				}
				;
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
				System.out.println(invalidInput);
				Toolkit.getDefaultToolkit().beep();
			}
		}
	}

}
