package com.criticalgnome.audio.tests;

import com.criticalgnome.audio.classes.File;
import com.criticalgnome.audio.classes.Track;

public class AudioRecordTest {
	public static void main(String[] args) {
		System.out.println("Testing!");
		
		File t = new Track("Name", 100, "POP", "Author");
		System.out.println(t.toString());
	}
}
