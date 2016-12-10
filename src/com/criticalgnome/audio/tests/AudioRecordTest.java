package com.criticalgnome.audio.tests;

import com.criticalgnome.audio.classes.Files;
import com.criticalgnome.audio.classes.Track;

public class AudioRecordTest {
	public static void main(String[] args) {
		System.out.println("Continue testing!");
		
		Files f = new Track("Name", 100, "POP", "Author");
		System.out.println(f);
	}
}
