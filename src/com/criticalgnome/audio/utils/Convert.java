package com.criticalgnome.audio.utils;

public class Convert {

	/**
	 * Converter
	 * 
	 * @param min
	 *            Minutes
	 * @param sec
	 *            Seconds
	 * @return Minutes * 60 + Seconds
	 */
	public static int toSeconds(int min, int sec) {
		return min * 60 + sec;
	}

	/**
	 * Converts seconds to minutes and seconds
	 *
	 * @param int:durationInSec
	 *            time in seconds 
	 * @return string : "n min. n sec."
	 */
	public static String toMinAndSec(int durationInSec) {
		String str = (durationInSec / 60) + " мин.";
		if ((durationInSec % 60) != 0) {
			str += " " + (durationInSec % 60) + " сек.";
		}
		return str;
	}
}
