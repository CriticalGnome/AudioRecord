/*
 * Project AudioRecord
 * @author Sergey Kalinovsky
 * @version 1.0
 */
package com.criticalgnome.audio.beans;

/**
 * The Class Collection.
 */
public class Collection {


	private String name; // Collection name
	private int duration; // Duration (in seconds)
	public static Collection collection = new Collection("My Collection", 0);

	/**
	 * Collection constructor.
	 *
	 * @param name String:Collection name
	 * @param duration int:Duration (in seconds)
	 */
	public Collection(String name, int duration) {
		super();
		this.name = name;
		this.duration = duration;
	}
	public Collection() {
		
	}

	@Override
	public String toString() {
		return "Collection [name=" + name + ", duration=" + duration + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Collection other = (Collection) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
