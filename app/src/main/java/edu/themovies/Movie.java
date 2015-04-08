/**
 * The Movies Movie.java
 *
 * @author Sumanth Mudiyam
 */

package edu.themovies;

import java.io.Serializable;

public class Movie implements Serializable {

	private static final long serialVersionUID = 1L;
	String title, thumbnail, mpaa_rating;
	String detailed, release_date, audience_rating, critics_rating, alternate;
	int year, runtime;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getMpaa_rating() {
		return mpaa_rating;
	}

	public void setMpaa_rating(String mpaa_rating) {
		this.mpaa_rating = mpaa_rating;
	}

	public String getDetailed() {
		return detailed;
	}

	public void setDetailed(String detailed) {
		this.detailed = detailed;
	}

	public String getRelease_date() {
		return release_date;
	}

	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}

	public String getAudience_rating() {
		return audience_rating;
	}

	public void setAudience_rating(String audience_rating) {
		this.audience_rating = audience_rating;
	}

	public String getCritics_rating() {
		return critics_rating;
	}

	public void setCritics_rating(String critics_rating) {
		this.critics_rating = critics_rating;
	}

	public String getAlternate() {
		return alternate;
	}

	public void setAlternate(String alternate) {
		this.alternate = alternate;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getRuntime() {
		return runtime;
	}

	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}

	@Override
	public String toString() {
		return "Movie [title=" + title + ", thumbnail=" + thumbnail
				+ ", mpaa_rating=" + mpaa_rating + ", detailed=" + detailed
				+ ", release_date=" + release_date + ", audience_rating="
				+ audience_rating + ", critics_rating=" + critics_rating
				+ ", alternate=" + alternate + ", year=" + year + ", runtime="
				+ runtime + "]";
	}
}