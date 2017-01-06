/*
 * Project AudioRecord
 * @author Sergey Kalinovsky
 * @version 1.0
 */
package com.criticalgnome.audio.utils;

import com.criticalgnome.audio.beans.Collection;
import com.criticalgnome.audio.exceptions.CollectionEmptyException;

public class WriteCollection {

	/**
	 * Write collection to disk.
	 * 
	 * @param myCollection
	 *            Current Collection
	 */
	public static void writeToDisk(Collection myCollection) {
		if (myCollection.getTracks().isEmpty()) {
			try {
				throw new CollectionEmptyException();
			} catch(CollectionEmptyException e) {
				
			}
			return;
		}
		System.out.println("Коллекция записана на диск.");
	}

}
