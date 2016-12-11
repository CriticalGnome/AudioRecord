package com.criticalgnome.audio.tests;

import com.criticalgnome.audio.classes.Files;
import com.criticalgnome.audio.classes.Track;
import com.criticalgnome.audio.utils.*;

public class AudioRecordTest {
	public static void main(String[] args) {
		System.out.println("Continue testing!");
		
		Files f = new Track("Name", 100, "POP", "Author");
		System.out.println(f);
		
		// 3 минуты 22 секунды. Конвертировать и вывести:
		System.out.println(Convert.toSeconds(3,22));
	}
}
