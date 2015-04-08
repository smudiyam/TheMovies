/**
 * The Movies JSONAsyncTask.java
 *
 * @author Sumanth Mudiyam
 */

package edu.themovies;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class JSONAsyncTask extends AsyncTask<String, Void, ArrayList<Movie>> {

	MoviesActivity activity;

	public JSONAsyncTask(MoviesActivity activity) {
		super();
		this.activity = activity;
	}

	@Override
	protected ArrayList<Movie> doInBackground(String... params) {
		URL url = null;
		try {
			url = new URL(params[0]);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.connect();
			int responseCode = con.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) {
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(con.getInputStream()));
				StringBuilder builder = new StringBuilder();
				String line = reader.readLine();

				while (line != null) {
					builder.append(line);
					line = reader.readLine();
				}
				Log.d("Movies", builder.toString());
				return MovieUtils.MoviesJSONParser.parseMovie(builder
						.toString());
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	protected void onPostExecute(ArrayList<Movie> result) {
		super.onPostExecute(result);
		activity.movies = result;
		activity.setUpData();
	}
}