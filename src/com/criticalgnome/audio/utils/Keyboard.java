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
}
