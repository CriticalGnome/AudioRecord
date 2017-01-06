/*
 * Project AudioRecord
 * @author Sergey Kalinovsky
 * @version 1.0
 */
package com.criticalgnome.audio.beans;

import java.io.Serializable;

import com.criticalgnome.audio.utils.Style;

/**
 * This class describes the musical track
 */
public class Track extends File implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3193721823729996955L;
	private String name;
	private int duration;
	private Style style;
	private String author;
	
	/**
	 * New track constructor
	 * @param name Track name
	 * @param duration Duration (in seconds)
	 * @param style Track style
	 * @param author Track author
	 */
	public Track(String name, int duration, Style style, String author) {
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

	public Style getStyle() {
		return style;
	}

	public void setStyle(Style style) {
		this.style = style;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
}
