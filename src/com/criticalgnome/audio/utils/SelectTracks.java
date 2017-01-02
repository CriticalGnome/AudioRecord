/*
 * Project AudioRecord
 * @author Sergey Kalinovsky
 * @version 1.0
 */
package com.criticalgnome.audio.utils;

import com.criticalgnome.audio.beans.Collection;

public class SelectTracks {

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

}
