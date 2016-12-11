package com.criticalgnome.audio.utils;

import java.util.Scanner;

public class Keyboard {
	public static Scanner input = new Scanner(System.in);

	public static int inputNumber() {
		int number = -1;
		input = new Scanner(System.in);
		number = input.nextInt();
		return number;
	}
}
