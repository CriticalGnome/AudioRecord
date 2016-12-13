/*
 * Project AudioRecord
 * @author Sergey Kalinovsky
 * @version 1.0
 */
package com.criticalgnome.audio.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * This class describes the musical track
 */
public class Track extends File {

	private String name; // Track name
	private int duration; // Duration (in seconds)
	private String style; // Style
	private String author; // Author
	/** This list contains some files, located at HDD drive */
	public static List<Track> files = new ArrayList<Track>();
	/** This list contains some tracks, added to musical collection */
	public static List<Track> tracks = new ArrayList<Track>();
	
	/**
	 * New track constructor
	 * @param name String:Track name
	 * @param duration int:Duration (in seconds)
	 * @param style the String:Style
	 * @param author the Author
	 */
	public Track(String name, int duration, String style, String author) {
		super();
		this.name = name;
		this.duration = duration;
		this.style = style;
		this.author = author;
	}
	public Track() {
		
	}

	@Override
	public String toString() {
		return "Track [name=" + name + ", duration=" + duration + ", style=" + style + ", author=" + author + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + duration;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((style == null) ? 0 : style.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Track other = (Track) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (duration != other.duration)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (style == null) {
			if (other.style != null)
				return false;
		} else if (!style.equals(other.style))
			return false;
		return true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
}
