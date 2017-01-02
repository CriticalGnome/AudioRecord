/*
 * Project AudioRecord
 * @author Sergey Kalinovsky
 * @version 1.0
 */
package com.criticalgnome.audio.utils;

import java.awt.Toolkit;

import com.criticalgnome.audio.beans.Collection;

public class RemoveTrack {

	/**
	 * Remove the track from collection.
	 * @param myCollection Current Collection
	 * @return edited Collection
	 */
	public static Collection removeTrack(Collection myCollection) {
		int number = -1;
		while (number != Variables.EXIT) {
			if (myCollection.getTracks().isEmpty()) {
				System.out.println("Коллекция пуста!");
				Toolkit.getDefaultToolkit().beep();
				break;
			}
			System.out.println(Variables.THICK_LINE);
			System.out.println("Музыкальная коллекция \"" + myCollection.getName() + "\".");
			System.out.println(Variables.THIN_LINE);
			PrintCollection.printCollection(myCollection);
			System.out.print("Какой трек удалить? (0 - отмена): ");
			number = Keyboard.inputNumber();
			if (number == Variables.EXIT) {
				break;
			}
			if (number < 1 || number - 1 >= myCollection.getTracks().size()) {
				System.out.println(Variables.INVALID_INPUT);
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
