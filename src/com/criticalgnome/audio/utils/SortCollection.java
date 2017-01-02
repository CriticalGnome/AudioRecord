/*
 * Project AudioRecord
 * @author Sergey Kalinovsky
 * @version 1.0
 */
package com.criticalgnome.audio.utils;

import java.awt.Toolkit;

import com.criticalgnome.audio.beans.Collection;
import com.criticalgnome.audio.beans.Track;

public class SortCollection {

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
		PrintCollection.printCollection(myCollection);
		return myCollection;
	}

}
