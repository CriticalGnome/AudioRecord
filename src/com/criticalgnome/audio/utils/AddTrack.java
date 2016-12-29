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
		files.add(new Track("TWIST", 215, "Rock-n-Roll", "Chubby Checker"));
		files.add(new Track("SMOOTH", 253, "Latin Pop", "Santana Featuring Rob Thomas"));
		files.add(new Track("MACK THE KNIFE", 192, "jazz", "Bobby Darin"));
		files.add(new Track("HOW DO I LIVE", 268, "Pop", "LeAnn Rimes"));
		files.add(new Track("PARTY ROCK ANTHEM", 263, "Electro House", "LMFAO Featuring Lauren Bennett & GoonRock"));
		files.add(new Track("I GOTTA FEELING", 291, "Dance", "The Black Eyed Peas"));
		files.add(new Track("MACARENA (BAYSIDE BOYS MIX)", 237, "Dance", "Los Del Rio"));
		files.add(new Track("PHYSICAL", 223, "Dance", "Olivia Newton-John"));
		files.add(new Track("YOU LIGHT UP MY LIFE", 209, "Pop", "Debby Boone"));
		files.add(new Track("HEY JUDE", 428, "Pop-Rock", "The Beatles"));
		files.add(new Track("WE BELONG TOGETHER", 200, "R&B", "Mariah Carey"));
		files.add(new Track("UPTOWN FUNK!", 270, "Funk", "Mark Ronson Featuring Bruno Mars"));
		files.add(new Track("UN-BREAK MY HEART", 272, "Pop", "Toni Braxton"));
		files.add(new Track("YEAH!", 250, "Hip-Hop", "Usher Featuring Lil Jon & Ludacris"));
		files.add(new Track("BETTE DAVIS EYES", 228, "Soft Rock", "Kim Carnes"));
		files.add(new Track("ENDLESS LOVE", 268, "Pop", "Diana Ross & Lionel Richie"));
		files.add(new Track("TONIGHT\'S THE NIGHT (GONNA BE ALRIGHT)", 236, "Soft Rock", "Rod Stewart"));
		files.add(new Track("FOOLISH GAMES / YOU WERE MEANT FOR ME", 253, "Folk", "Jewel"));
		files.add(new Track("(EVERYTHING I DO) I DO IT FOR YOU", 394, "Soft Rock", "Bryan Adams"));
		files.add(new Track("I'LL MAKE LOVE TO YOU", 244, "R&B", "Boyz II Men"));
		files.add(new Track("THE THEME FROM \"A SUMMER PLACE\"", 145, "Easy Listening", "Percy Faith And His Orchestra"));
		files.add(new Track("LE FREAK", 323, "Disco", "Chic"));
		files.add(new Track("HOW DEEP IS YOUR LOVE", 246, "Pop", "Bee Gees"));
		files.add(new Track("EYE OF THE TIGER", 246, "Rock", "Survivor"));
		files.add(new Track("WE FOUND LOVE", 205, "Electro House", "Rihanna Featuring Calvin Harris"));
		
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
