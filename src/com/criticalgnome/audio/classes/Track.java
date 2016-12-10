/*
 * Project AudioRecord
 * @author Sergey Kalinovsky
 * @version 1.0
 */
package com.criticalgnome.audio.classes;

/**
 * Класс описывает музыкальный трек.
 */
public class Track extends Files {

	private String name; // Название композиции
	private int duration; // Длительность (в секундах)
	private String style; // Музыкальный стиль
	private String author; // Автор
	
	/**
	 * Создание нового трека
	 * @param name String:Название композиции
	 * @param duration int:Длительность (в секундах)
	 * @param style the String:Музыкальынй стиль
	 * @param author the String:Автор
	 */
	public Track(String name, int duration, String style, String author) {
		super();
		this.name = name;
		this.duration = duration;
		this.style = style;
		this.author = author;
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
