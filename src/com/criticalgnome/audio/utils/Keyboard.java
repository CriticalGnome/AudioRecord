/*
 * Project AudioRecord
 * @author Sergey Kalinovsky
 * @version 1.0
 */
package com.criticalgnome.audio.utils;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The Class Keyboard.
 */
public class Keyboard {
	
	/** The input. */
	public static Scanner input = new Scanner(System.in);

	/**
	 * Input number.
	 *
	 * @return the int
	 */
	public static int inputNumber() {
		int number = -1;
		input = new Scanner(System.in);
		try {
			number = input.nextInt();
			return number;
		} catch (InputMismatchException e) {
			return -1;
		} finally {
			
		}
		
	}

	public static int inputRange(String str) {
		System.out.print(str);
		String range = input.next();
		range = range.trim();
		try {
			String[] rangeArray = range.split(":");
			int minutes = Integer.parseInt(rangeArray[0]);
			int seconds = Integer.parseInt(rangeArray[1]);
			if (minutes < 0 || minutes > 80 || seconds < 0 || seconds > 59) {
				System.out.print("Неверный формат! ");
				return -1;
			}
			return minutes * 60 + seconds;  
		} catch (Exception e) {
			System.out.print("Неверный формат! ");
			return -1;
		}
	}
}
