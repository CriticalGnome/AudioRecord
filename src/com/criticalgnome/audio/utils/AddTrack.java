/*
 * Project AudioRecord
 * @author Sergey Kalinovsky
 * @version 1.0
 */
package com.criticalgnome.audio.utils;

import java.awt.Toolkit;
import java.util.ArrayList;
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
		
		// Fill files list by fabricated evidence
		List<Track> files = new ArrayList<Track>();
		files.add(new Track("TWIST", 215, Style.ROCKNROLL, "Chubby Checker"));
		files.add(new Track("SMOOTH", 253, Style.LATINPOP, "Santana Featuring Rob Thomas"));
		files.add(new Track("MACK THE KNIFE", 192, Style.JAZZ, "Bobby Darin"));
		files.add(new Track("HOW DO I LIVE", 268, Style.POP, "LeAnn Rimes"));
		files.add(new Track("PARTY ROCK ANTHEM", 263, Style.ELECTROHOUSE, "LMFAO Featuring Lauren Bennett & GoonRock"));
		files.add(new Track("I GOTTA FEELING", 291, Style.DANCE, "The Black Eyed Peas"));
		files.add(new Track("MACARENA (BAYSIDE BOYS MIX)", 237, Style.DANCE, "Los Del Rio"));
		files.add(new Track("PHYSICAL", 223, Style.DANCE, "Olivia Newton-John"));
		files.add(new Track("YOU LIGHT UP MY LIFE", 209, Style.POP, "Debby Boone"));
		files.add(new Track("HEY JUDE", 428, Style.POPROCK, "The Beatles"));
		files.add(new Track("WE BELONG TOGETHER", 200, Style.RNB, "Mariah Carey"));
		files.add(new Track("UPTOWN FUNK!", 270, Style.FUNK, "Mark Ronson Featuring Bruno Mars"));
		files.add(new Track("UN-BREAK MY HEART", 272, Style.POP, "Toni Braxton"));
		files.add(new Track("YEAH!", 250, Style.HIPHOP, "Usher Featuring Lil Jon & Ludacris"));
		files.add(new Track("BETTE DAVIS EYES", 228, Style.SOFTROCK, "Kim Carnes"));
		files.add(new Track("ENDLESS LOVE", 268, Style.POP, "Diana Ross & Lionel Richie"));
		files.add(new Track("TONIGHT\'S THE NIGHT (GONNA BE ALRIGHT)", 236, Style.SOFTROCK, "Rod Stewart"));
		files.add(new Track("FOOLISH GAMES / YOU WERE MEANT FOR ME", 253, Style.FOLK, "Jewel"));
		files.add(new Track("(EVERYTHING I DO) I DO IT FOR YOU", 394, Style.SOFTROCK, "Bryan Adams"));
		files.add(new Track("I'LL MAKE LOVE TO YOU", 244, Style.RNB, "Boyz II Men"));
		files.add(new Track("THE THEME FROM \"A SUMMER PLACE\"", 145, Style.EASYLISTENING, "Percy Faith And His Orchestra"));
		files.add(new Track("LE FREAK", 323, Style.DISCO, "Chic"));
		files.add(new Track("HOW DEEP IS YOUR LOVE", 246, Style.POP, "Bee Gees"));
		files.add(new Track("EYE OF THE TIGER", 246, Style.ROCK, "Survivor"));
		files.add(new Track("WE FOUND LOVE", 205, Style.ELECTROHOUSE, "Rihanna Featuring Calvin Harris"));
		
		int number = -1;
		while (number != Variables.EXIT) {
			System.out.println(Variables.THICK_LINE);
			System.out.println("Список файлов на жёстком диске");
			System.out.println(Variables.THIN_LINE);
	
			// Print list of available files
			for (int i = 0; i < files.size(); i++) {
				if (i < 9) {
					System.out.print("0");
				}
				System.out.print((i + 1) + ". ");
				System.out.print(files.get(i).getAuthor() + " - ");
				System.out.print(files.get(i).getName() + " [");
				System.out.print(files.get(i).getStyle() + "] (");
				System.out.println(Convert.toMinAndSec(files.get(i).getDuration()) + ")");
			}
			System.out.println(Variables.THIN_LINE);
			System.out.println("Свободное место в коллекции: " + Convert
					.toMinAndSec(Variables.DISK_DURATION - myCollection.getDuration()));
			System.out.print("Какой трек добавить? (0 - отмена): ");
			number = Keyboard.inputNumber();
			if (number == Variables.EXIT) {
				break;
			}
			if (number < 1 || number - 1 >= files.size()) {
				System.out.println(Variables.INVALID_INPUT);
				Toolkit.getDefaultToolkit().beep();
				continue;
			}
			if (((Variables.DISK_DURATION - myCollection.getDuration())
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
