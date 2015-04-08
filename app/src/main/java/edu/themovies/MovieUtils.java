/**
 * The Movies MovieUtils.java
 *
 * @author Sumanth Mudiyam
 */

package edu.themovies;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MovieUtils {
	static public class MoviesJSONParser {
		static ArrayList<Movie> parseMovie(String in) throws JSONException {
			ArrayList<Movie> movies = new ArrayList<Movie>();
			Movie movie;
			JSONObject root = new JSONObject(in);
			JSONArray moviesJSONArray = root.getJSONArray("movies");

			for (int i = 0; i < moviesJSONArray.length(); i++) {
				JSONObject movieJSONObject = moviesJSONArray.getJSONObject(i);
				movie = new Movie();
				movie.setTitle(movieJSONObject.getString("title"));
				movie.setYear(movieJSONObject.getInt("year"));
				movie.setMpaa_rating(movieJSONObject.getString("mpaa_rating"));
				if (movieJSONObject.has("runtime"))
					if (!movieJSONObject.getString("runtime").isEmpty())
						movie.setRuntime(movieJSONObject.getInt("runtime"));
				JSONObject releaseJSONObject = movieJSONObject
						.getJSONObject("release_dates");
				movie.setRelease_date(releaseJSONObject.getString("theater"));
				JSONObject ratingsJSONObject = movieJSONObject
						.getJSONObject("ratings");
				if (ratingsJSONObject.has("critics_rating"))
					movie.setCritics_rating(ratingsJSONObject
							.getString("critics_rating"));
				if (ratingsJSONObject.has("audience_rating"))
					movie.setAudience_rating(ratingsJSONObject
							.getString("audience_rating"));
				JSONObject postersJSONObject = movieJSONObject
						.getJSONObject("posters");
				movie.setThumbnail(postersJSONObject.getString("thumbnail"));
				movie.setDetailed(postersJSONObject.getString("detailed"));
				JSONObject linksJSONObject = movieJSONObject
						.getJSONObject("links");
				movie.setAlternate(linksJSONObject.getString("alternate"));
				movies.add(movie);
				movie = null;
			}
			return movies;
		}
	}
}