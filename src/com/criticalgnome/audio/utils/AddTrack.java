/*
 * Project AudioRecord
 * @author Sergey Kalinovsky
 * @version 1.0
 */
package com.criticalgnome.audio.utils;

import java.awt.Toolkit;
import java.util.List;

import com.criticalgnome.audio.beans.Collection;
import com.criticalgnome.audio.beans.Track;

public class AddTrack {

	/**
	 * Adds the track to collection.
	 * @param myCollection Current Collection
	 * @return edited Collection
	 */
	public static Collection addTrack(Collection myCollection) {
		
		List<Track> files = TracksList.fillTracksList();
		
		int number = -1;
		while (number != Constants.EXIT) {
			System.out.println(Constants.THICK_LINE);
			System.out.println("Список файлов на жёстком диске");
			System.out.println(Constants.THIN_LINE);
			PrintFiles.printFiles(myCollection, files);
			System.out.print("Какой трек добавить? (0 - отмена): ");
			number = Keyboard.inputNumber();
			if (number == Constants.EXIT) {
				break;
			}
			if (number < 1 || number - 1 >= files.size()) {
				System.out.println(Constants.INVALID_INPUT);
				Toolkit.getDefaultToolkit().beep();
				continue;
			}
			if (((Constants.DISK_DURATION - myCollection.getDuration())
					- files.get(number - 1).getDuration()) < 0) {
				System.out.println("Недостаточно свободного времени в коллекции.");
				Toolkit.getDefaultToolkit().beep();
				continue;
			}
			myCollection.getTracks().add(files.get(number - 1));
			myCollection.setDuration(
					myCollection.getDuration() + files.get(number - 1).getDuration());
			System.out.println("Композиция " + files.get(number - 1).getName()
					+ " успешно добавлена в коллекцию.");
		}
		return myCollection;
	}

}
