/*
 * Project AudioRecord
 * @author Sergey Kalinovsky
 * @version 1.0
 */
package com.criticalgnome.audio.utils;

import com.criticalgnome.audio.beans.Collection;

/**
 * Print collection.
 */
public class PrintCollection {
	public static void printCollection(Collection myCollection) {
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

	}
}