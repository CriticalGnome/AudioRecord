/*
 * Project AudioRecord
 * @author Sergey Kalinovsky
 * @version 1.0
 */
package com.criticalgnome.audio.utils;

public class MainMenu {

	/**
	 * Main menu.
	 */
	public static void mainMenu() {
		System.out.println(Variables.THICK_LINE);
		System.out.println("1. Добавить трек в коллекцию");
		System.out.println("2. Удалить трек из коллекции");
		System.out.println("3. Отсортировать коллекцию по музыкальному стилю");
		System.out.println("4. Вывести список треков с заданной длительностью");
		System.out.println("5. Записать коллекцию на диск");
		System.out.println("0. Выход");
		System.out.println(Variables.THIN_LINE);
		System.out.print("Введите команду: ");
	
	}

}
