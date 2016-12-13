/*
 * Project AudioRecord
 * @author Sergey Kalinovsky
 * @version 1.0
 */
package com.criticalgnome.audio;

import java.awt.Toolkit;

import com.criticalgnome.audio.utils.*;

public class AudioRecordRunner {

	/**
	 * Main method. Entry point.
	 *
	 * @param args
	 *            Command line arguments
	 */
	public static void main(String[] args) {

		// Fill files list by fabricated evidence
		Variables.fillFilesList();
		
		while (true) {
			// Main menu
			System.out.println(Variables.THICK_LINE);
			System.out.println("1. Добавить файл в коллекцию");
			System.out.println("2. Удалить файл из коллекции");
			System.out.println("3. Отсортировать коллекцию");
			System.out.println("4. Вывести список файлов с заданной длительностью");
			System.out.println("5. Записать коллекцию на диск");
			System.out.println("0. Выход");
			System.out.println(Variables.THIN_LINE);
			System.out.print("Введите команду: ");
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
				// TODO Sort collection will be there
				System.out.println(Variables.NOT_REALISED);
				break;
			case Variables.TAKE_BY_DURATION:
				// TODO Selection by duration will be there 
				System.out.println(Variables.NOT_REALISED);
				break;
			case Variables.RECORD_DISK:
				// TODO Write to CD will be there
				System.out.println(Variables.NOT_REALISED);
				break;
			case Variables.EXIT:
				// Выход
				System.out.println(Variables.THIN_LINE);
				System.out.println("Работа завершена...");
				System.exit(0);
			default:
				System.out.println(Variables.THIN_LINE);
				System.out.println(Variables.INVALID_INPUT);
				Toolkit.getDefaultToolkit().beep();
			}
		}
	}

}
