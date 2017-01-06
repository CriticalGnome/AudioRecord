/*
 * Project AudioRecord
 * @author Sergey Kalinovsky
 * @version 1.0
 */
package com.criticalgnome.audio.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * The Class Collection.
 */
public class Collection implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -660440111642085937L;
	private String name;
	private int duration;
	private List<Track> tracks = new ArrayList<Track>();

	/**
	 * New Collection Constructor 
	 * @param name Collection name
	 * @param duration Duration (in seconds)
	 * @param tracks List of added Tracks
	 */
	public Collection(String name, int duration, List<Track> tracks) {
		super();
		this.name = name;
		this.duration = duration;
		this.tracks = tracks;
	}

	public Collection() {
	}

	@Override
	public String toString() {
		return "Collection [name=" + name + ", duration=" + duration + ", tracks=" + tracks + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + duration;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((tracks == null) ? 0 : tracks.hashCode());
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
		if (duration != other.duration)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (tracks == null) {
			if (other.tracks != null)
				return false;
		} else if (!tracks.equals(other.tracks))
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

	public List<Track> getTracks() {
		return tracks;
	}

	public void setTracks(List<Track> tracks) {
		this.tracks = tracks;
	}

}
