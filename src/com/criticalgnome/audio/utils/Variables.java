/*
 * Project AudioRecord
 * @author Sergey Kalinovsky
 * @version 1.0
 */
package com.criticalgnome.audio.utils;

import com.criticalgnome.audio.beans.Track;

/**
 * The Class contains some important variables.
 */
public class Variables {

	/** Error string */
	public static final String INVALID_INPUT = "Неверный ввод. Попробуйте ещё раз.";
	/** Under construction string */
	public static final String NOT_REALISED = "Пока не реализовано.";
	/** Default duration of CD-Disk (in seconds) */
	public static final String THIN_LINE = "------------------------------------------------------------------";
	public static final String THICK_LINE = "\n==================================================================";
	public static final int DISK_DURATION = 4800; //80 min
	public static final int EXIT = 0;
	public static final int ADD_TRACK = 1;
	public static final int DEL_TRACK = 2;
	public static final int SORT_COLLECTION = 3;
	public static final int TAKE_BY_DURATION = 4;
	public static final int RECORD_DISK = 5;
	
	/**
	 * Fill files list by fabricated evidence.
	 */
	public static void fillFilesList () {
		// Generate list of files
		Track.files.add(new Track("TWIST", 215, "Rock-n-Roll", "Chubby Checker"));
		Track.files.add(new Track("SMOOTH", 253, "Latin Pop", "Santana Featuring Rob Thomas"));
		Track.files.add(new Track("MACK THE KNIFE", 192, "jazz", "Bobby Darin"));
		Track.files.add(new Track("HOW DO I LIVE", 268, "Pop", "LeAnn Rimes"));
		Track.files.add(new Track("PARTY ROCK ANTHEM", 263, "Electro House", "LMFAO Featuring Lauren Bennett & GoonRock"));
		Track.files.add(new Track("I GOTTA FEELING", 291, "Dance", "The Black Eyed Peas"));
		Track.files.add(new Track("MACARENA (BAYSIDE BOYS MIX)", 237, "Dance", "Los Del Rio"));
		Track.files.add(new Track("PHYSICAL", 223, "Dance", "Olivia Newton-John"));
		Track.files.add(new Track("YOU LIGHT UP MY LIFE", 209, "Pop", "Debby Boone"));
		Track.files.add(new Track("HEY JUDE", 428, "Pop-Rock", "The Beatles"));
		Track.files.add(new Track("WE BELONG TOGETHER", 200, "R&B", "Mariah Carey"));
		Track.files.add(new Track("UPTOWN FUNK!", 270, "Funk", "Mark Ronson Featuring Bruno Mars"));
		Track.files.add(new Track("UN-BREAK MY HEART", 272, "Pop", "Toni Braxton"));
		Track.files.add(new Track("YEAH!", 250, "Hip-Hop", "Usher Featuring Lil Jon & Ludacris"));
		Track.files.add(new Track("BETTE DAVIS EYES", 228, "Soft Rock", "Kim Carnes"));
		Track.files.add(new Track("ENDLESS LOVE", 268, "Pop", "Diana Ross & Lionel Richie"));
		Track.files.add(new Track("TONIGHT\'S THE NIGHT (GONNA BE ALRIGHT)", 236, "Soft Rock", "Rod Stewart"));
		Track.files.add(new Track("FOOLISH GAMES / YOU WERE MEANT FOR ME", 253, "Folk", "Jewel"));
		Track.files.add(new Track("(EVERYTHING I DO) I DO IT FOR YOU", 394, "Soft Rock", "Bryan Adams"));
		Track.files.add(new Track("I'LL MAKE LOVE TO YOU", 244, "R&B", "Boyz II Men"));
		Track.files.add(new Track("THE THEME FROM \"A SUMMER PLACE\"", 145, "Easy Listening", "Percy Faith And His Orchestra"));
		Track.files.add(new Track("LE FREAK", 323, "Disco", "Chic"));
		Track.files.add(new Track("HOW DEEP IS YOUR LOVE", 246, "Pop", "Bee Gees"));
		Track.files.add(new Track("EYE OF THE TIGER", 246, "Rock", "Survivor"));
		Track.files.add(new Track("WE FOUND LOVE", 205, "Electro House", "Rihanna Featuring Calvin Harris"));
	}


}
