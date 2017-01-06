/*
 * Project AudioRecord
 * @author Sergey Kalinovsky
 * @version 1.0
 */
package com.criticalgnome.audio.utils;

import java.awt.Toolkit;

import com.criticalgnome.audio.beans.Collection;
import com.criticalgnome.audio.exceptions.CollectionEmptyException;

public class RemoveTrack {

	/**
	 * Remove the track from collection.
	 * @param myCollection Current Collection
	 * @return edited Collection
	 * @throws CollectionEmptyException custom exception
	 */
	public static Collection removeTrack(Collection myCollection) throws CollectionEmptyException {
		int number = -1;
		while (number != Constants.EXIT) {
			if (myCollection.getTracks().isEmpty()) {
				try {
					throw new CollectionEmptyException();
				} catch(CollectionEmptyException e) {
					
				}
				break;
			}
			System.out.println(Constants.THICK_LINE);
			System.out.println("Музыкальная коллекция \"" + myCollection.getName() + "\".");
			System.out.println(Constants.THIN_LINE);
			PrintCollection.printCollection(myCollection);
			System.out.print("Какой трек удалить? (0 - отмена): ");
			number = Keyboard.inputNumber();
			if (number == Constants.EXIT) {
				break;
			}
			if (number < 1 || number - 1 >= myCollection.getTracks().size()) {
				System.out.println(Constants.INVALID_INPUT);
				Toolkit.getDefaultToolkit().beep();
				continue;
			}
			myCollection.setDuration((myCollection.getDuration() - myCollection.getTracks().get(number - 1).getDuration()));
			System.out.println("Композиция " + myCollection.getTracks().get(number - 1).getName() + " удалена из коллекции.");
			myCollection.getTracks().remove(number - 1);
		}
		return myCollection;
	}

}
