/*
 * Project AudioRecord
 * @author Sergey Kalinovsky
 * @version 1.0
 */
package com.criticalgnome.audio.utils;

import java.util.List;

import com.criticalgnome.audio.beans.Collection;
import com.criticalgnome.audio.beans.Track;

public class PrintFiles {

	static void printFiles(Collection myCollection, List<Track> files) {
		for (int i = 0; i < files.size(); i++) {
			if (i < Constants.TWO_DIGIT_NUMBER) {
				System.out.print("0");
			}
			System.out.print((i + 1) + ". ");
			System.out.print(files.get(i).getAuthor() + " - ");
			System.out.print(files.get(i).getName() + " [");
			System.out.print(files.get(i).getStyle() + "] (");
			System.out.println(Convert.toMinAndSec(files.get(i).getDuration()) + ")");
		}
		System.out.println(Constants.THIN_LINE);
		System.out.println("Свободное место в коллекции: " + Convert
				.toMinAndSec(Constants.DISK_DURATION - myCollection.getDuration()));
	}

}
