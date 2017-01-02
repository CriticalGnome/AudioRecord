/*
 * Project AudioRecord
 * @author Sergey Kalinovsky
 * @version 1.0
 */
package com.criticalgnome.audio.utils;

import java.awt.Toolkit;

import com.criticalgnome.audio.beans.Collection;

public class WriteCollection {

	/**
	 * Write collection to disk.
	 * 
	 * @param myCollection
	 *            Current Collection
	 */
	public static void writeToDisk(Collection myCollection) {
		if (myCollection.getTracks().isEmpty()) {
			System.out.println("Коллекция пуста!");
			Toolkit.getDefaultToolkit().beep();
			return;
		}
		System.out.println("Коллекция записана на диск.");
	}

}
