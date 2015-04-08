/**
 * The Movies Url.java
 *
 * @author Sumanth Mudiyam
 */

package edu.themovies;

public class Url {
	String type, url;

	public Url(String type, String url) {
		super();
		this.type = type;
		this.url = url;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return type;
	}

	public String toString1() {
		return "Url [type=" + type + ", url=" + url + "]";
	}
}