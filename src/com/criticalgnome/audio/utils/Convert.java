package com.criticalgnome.audio.utils;

public class Convert {

	/**
	 * Конвертер
	 * 
	 * @param min
	 *            Минуты
	 * @param sec
	 *            Секунды
	 * @return Минуты*60+Секунды
	 */
	public static int toSeconds(int min, int sec) {
		return min * 60 + sec;
	}

	/**
	 * Переводит секунды в минуты и секунды
	 *
	 * @param durationInSec
	 *            время в секундах
	 * @return string : "n мин. n сек."
	 */
	public static String toMinAndSec(int durationInSec) {
		String str = (durationInSec / 60) + " мин.";
		if ((durationInSec % 60) != 0) {
			str += " " + (durationInSec % 60) + " сек.";
		}
		return str;
	}
}
