/*
 * Project AudioRecord
 * @author Sergey Kalinovsky
 * @version 1.0
 */
package com.criticalgnome.audio.utils;

import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import com.criticalgnome.audio.beans.*;

/**
 * The Class MenuItems.
 */
/**
 * @author lords
 *
 */
public class MenuItems {
	
	/**
	 * Main menu.
	 */
	public static void mainMenu() {
		System.out.println(Variables.THICK_LINE);
		System.out.println("1. Добавить файл в коллекцию");
		System.out.println("2. Удалить файл из коллекции");
		System.out.println("3. Отсортировать коллекцию по музыкальному стилю");
		System.out.println("4. Вывести список файлов с заданной длительностью");
		System.out.println("5. Записать коллекцию на диск");
		System.out.println("0. Выход");
		System.out.println(Variables.THIN_LINE);
		System.out.print("Введите команду: ");

	}
	/**
	 * Adds the track to collection.
	 * @param myCollection Current Collection
	 * @param files Files at current directory
	 * @return edited Collection
	 */
	public static Collection addTrack(Collection myCollection) {
		
		// Fill files list by fabricated evidence
		List<Track> files = new ArrayList<Track>();
		files.add(new Track("TWIST", 215, "Rock-n-Roll", "Chubby Checker"));
		files.add(new Track("SMOOTH", 253, "Latin Pop", "Santana Featuring Rob Thomas"));
		files.add(new Track("MACK THE KNIFE", 192, "jazz", "Bobby Darin"));
		files.add(new Track("HOW DO I LIVE", 268, "Pop", "LeAnn Rimes"));
		files.add(new Track("PARTY ROCK ANTHEM", 263, "Electro House", "LMFAO Featuring Lauren Bennett & GoonRock"));
		files.add(new Track("I GOTTA FEELING", 291, "Dance", "The Black Eyed Peas"));
		files.add(new Track("MACARENA (BAYSIDE BOYS MIX)", 237, "Dance", "Los Del Rio"));
		files.add(new Track("PHYSICAL", 223, "Dance", "Olivia Newton-John"));
		files.add(new Track("YOU LIGHT UP MY LIFE", 209, "Pop", "Debby Boone"));
		files.add(new Track("HEY JUDE", 428, "Pop-Rock", "The Beatles"));
		files.add(new Track("WE BELONG TOGETHER", 200, "R&B", "Mariah Carey"));
		files.add(new Track("UPTOWN FUNK!", 270, "Funk", "Mark Ronson Featuring Bruno Mars"));
		files.add(new Track("UN-BREAK MY HEART", 272, "Pop", "Toni Braxton"));
		files.add(new Track("YEAH!", 250, "Hip-Hop", "Usher Featuring Lil Jon & Ludacris"));
		files.add(new Track("BETTE DAVIS EYES", 228, "Soft Rock", "Kim Carnes"));
		files.add(new Track("ENDLESS LOVE", 268, "Pop", "Diana Ross & Lionel Richie"));
		files.add(new Track("TONIGHT\'S THE NIGHT (GONNA BE ALRIGHT)", 236, "Soft Rock", "Rod Stewart"));
		files.add(new Track("FOOLISH GAMES / YOU WERE MEANT FOR ME", 253, "Folk", "Jewel"));
		files.add(new Track("(EVERYTHING I DO) I DO IT FOR YOU", 394, "Soft Rock", "Bryan Adams"));
		files.add(new Track("I'LL MAKE LOVE TO YOU", 244, "R&B", "Boyz II Men"));
		files.add(new Track("THE THEME FROM \"A SUMMER PLACE\"", 145, "Easy Listening", "Percy Faith And His Orchestra"));
		files.add(new Track("LE FREAK", 323, "Disco", "Chic"));
		files.add(new Track("HOW DEEP IS YOUR LOVE", 246, "Pop", "Bee Gees"));
		files.add(new Track("EYE OF THE TIGER", 246, "Rock", "Survivor"));
		files.add(new Track("WE FOUND LOVE", 205, "Electro House", "Rihanna Featuring Calvin Harris"));
		
		int number = -1;
		while (number != Variables.EXIT) {
			System.out.println(Variables.THICK_LINE);
			System.out.println("Список файлов на жёстком диске");
			System.out.println(Variables.THIN_LINE);

			// Print list of available files
			for (int i = 0; i < files.size(); i++) {
				if (i < 9) {
					System.out.print("0");
				}
				System.out.print((i + 1) + ". ");
				System.out.print(files.get(i).getAuthor() + " - ");
				System.out.print(files.get(i).getName() + " [");
				System.out.print(files.get(i).getStyle() + "] (");
				System.out.println(Convert.toMinAndSec(files.get(i).getDuration()) + ")");
			}
			System.out.println(Variables.THIN_LINE);
			System.out.println("Свободное место в коллекции: " + Convert
					.toMinAndSec(Variables.DISK_DURATION - myCollection.getDuration()));
			System.out.print("Какой трек добавить? (0 - отмена): ");
			number = Keyboard.inputNumber();
			if (number == Variables.EXIT) {
				break;
			}
			if (number < 1 || number - 1 >= files.size()) {
				System.out.println(Variables.INVALID_INPUT);
				Toolkit.getDefaultToolkit().beep();
				continue;
			}
			if (((Variables.DISK_DURATION - myCollection.getDuration())
					- files.get(number - 1).getDuration()) < 0) {
				System.out.println("Недостаточно свободного времени в коллекции.");
				Toolkit.getDefaultToolkit().beep();
				continue;
			}
			myCollection.getTracks().add(files.get(number - 1));
			myCollection.setDuration(
					myCollection.getDuration() + files.get(number - 1).getDuration());
			System.out.println("Композиция " + files.get(number - 1).getName()
					+ " успешно добавлена в коллекцию.");
		}
		return myCollection;
	}

	/**
	 * Remove the track from collection.
	 * @param myCollection Current Collection
	 * @return edited Collection
	 */
	public static Collection delTrack(Collection myCollection) {
		int number = -1;
		while (number != Variables.EXIT) {
			if (myCollection.getTracks().isEmpty()) {
				System.out.println("Коллекция пуста!");
				Toolkit.getDefaultToolkit().beep();
				break;
			}
			System.out.println(Variables.THICK_LINE);
			System.out.println("Музыкальная коллекция \"" + myCollection.getName() + "\".");
			System.out.println(Variables.THIN_LINE);
			// Print tracks in collection
			for (int i = 0; i < myCollection.getTracks().size(); i++) {
				if (i < 9) {
					System.out.print("0");
				}
				System.out.print((i + 1) + ". ");
				System.out.print(myCollection.getTracks().get(i).getAuthor() + " - ");
				System.out.print(myCollection.getTracks().get(i).getName() + " [");
				System.out.print(myCollection.getTracks().get(i).getStyle() + "] (");
				System.out.println(Convert.toMinAndSec(myCollection.getTracks().get(i).getDuration()) + ")");
			}
			System.out.println(Variables.THIN_LINE);
			System.out.println("Всего треков: " + myCollection.getTracks().size() + ". Суммарная длительность: "
					+ Convert.toMinAndSec(myCollection.getDuration()));
			System.out.print("Какой трек удалить? (0 - отмена): ");
			number = Keyboard.inputNumber();
			if (number == Variables.EXIT) {
				break;
			}
			if (number < 1 || number - 1 >= myCollection.getTracks().size()) {
				System.out.println(Variables.INVALID_INPUT);
				Toolkit.getDefaultToolkit().beep();
				continue;
			}
			myCollection.setDuration((myCollection.getDuration() - myCollection.getTracks().get(number - 1).getDuration()));
			System.out.println("Композиция " + myCollection.getTracks().get(number - 1).getName() + " удалена из коллекции.");
			myCollection.getTracks().remove(number - 1);
		}
		return myCollection;
	}
	
	/**
	 * Sort collection by style.
	 * @param myCollection Current Collection
	 * @return sorted Collection
	 */
	public static Collection sortByStyle(Collection myCollection) {
		if (myCollection.getTracks().isEmpty()) {
			System.out.println("Коллекция пуста!");
			Toolkit.getDefaultToolkit().beep();
			return myCollection;
		}
		Track tempTrack = new Track();
		for (int i = myCollection.getTracks().size() - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (myCollection.getTracks().get(j).getStyle().compareToIgnoreCase(myCollection.getTracks().get(j + 1).getStyle()) > 0) {
					tempTrack = myCollection.getTracks().get(j);
					myCollection.getTracks().set(j, myCollection.getTracks().get(j + 1));
					myCollection.getTracks().set(j + 1, tempTrack);
				}
			}
		}
		System.out.println(Variables.THICK_LINE);
		System.out.println("Коллекция \"" + myCollection.getName() + "\" отсортирована по музыкальному стилю.");
		System.out.println(Variables.THIN_LINE);
		// Print tracks in collection
		for (int i = 0; i < myCollection.getTracks().size(); i++) {
			if (i < 9) {
				System.out.print("0");
			}
			System.out.print((i + 1) + ". ");
			System.out.print(myCollection.getTracks().get(i).getAuthor() + " - ");
			System.out.print(myCollection.getTracks().get(i).getName() + " [");
			System.out.print(myCollection.getTracks().get(i).getStyle() + "] (");
			System.out.println(Convert.toMinAndSec(myCollection.getTracks().get(i).getDuration()) + ")");
		}
		System.out.println(Variables.THIN_LINE);
		System.out.println("Всего треков: " + myCollection.getTracks().size() + ". Суммарная длительность: "
				+ Convert.toMinAndSec(myCollection.getDuration()));
		return myCollection;
	}
	
	/**
	 * Select tracks by duration.
	 * @param myCollection Current Collection
	 */
	public static void selectByDuration(Collection myCollection) {
		System.out.println(Variables.THICK_LINE);
		System.out.println("Подбор треков, соответствующих заданному временному диапазону");
		int rangeBegin = -1;
		int rangeEnd = -1;
		while (rangeEnd - rangeBegin <= 0) {
			while (rangeBegin == -1) {
				rangeBegin = Keyboard.inputRange("Введите начало дипазона в формате min:sec ");
			}
			while (rangeEnd == -1) {
				rangeEnd = Keyboard.inputRange("Введите конец дипазона в формате min:sec ");
			}
			if (rangeEnd - rangeBegin < 0) {
				System.out.println("Конец диапазона не может быть меньше начала!");
			}
			if (rangeBegin != -1 && rangeEnd != -1) {
				break;
			}
		}
		boolean isPrinted = false;
		System.out.println(Variables.THICK_LINE);
		System.out.println("Треки в диапазоне от " + Convert.toMinAndSec(rangeBegin) + " и до "
				+ Convert.toMinAndSec(rangeEnd) + ":");
		for (int i = 0; i < myCollection.getTracks().size(); i++) {
			if (myCollection.getTracks().get(i).getDuration() >= rangeBegin
					&& myCollection.getTracks().get(i).getDuration() <= rangeEnd) {
				isPrinted = true;
				if (i < 9) {
					System.out.print("0");
				}
				System.out.print((i + 1) + ". ");
				System.out.print(myCollection.getTracks().get(i).getAuthor() + " - ");
				System.out.print(myCollection.getTracks().get(i).getName() + " [");
				System.out.print(myCollection.getTracks().get(i).getStyle() + "] (");
				System.out.println(Convert.toMinAndSec(myCollection.getTracks().get(i).getDuration()) + ")");
			}
		}
		if (isPrinted) {
			System.out.println(Variables.THIN_LINE);
		} else {
			System.out.println("Не найдены. Попробуйте расширить диапазон поиска!");
		}
	}
	
	/**
	 * Write collection to disk.
	 */
	public static void writeToDisk(Collection myCollection) {
		//TODO
		System.out.println(Variables.NOT_REALISED);
	}
}
