/**
 * The Movies MovieAdapter.java
 *
 * @author Sumanth Mudiyam
 */

package edu.themovies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieAdapter extends ArrayAdapter<Movie> {
	Context context;
	ArrayList<Movie> objects;

	public MovieAdapter(Context context, ArrayList<Movie> objects) {
		super(context, R.layout.item_row_layout, objects);
		this.context = context;
		this.objects = objects;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View itemRowView = inflater.inflate(R.layout.item_row_layout, parent,
				false);

		TextView movieTitle = (TextView) itemRowView
				.findViewById(R.id.textView1);
		TextView movieYear = (TextView) itemRowView
				.findViewById(R.id.textView2);
		TextView mpaaRating = (TextView) itemRowView
				.findViewById(R.id.textView3);
		ImageView imageView = (ImageView) itemRowView
				.findViewById(R.id.imageView1);
		imageView.setImageDrawable(null);

		movieTitle.setText(objects.get(position).getTitle() + "");
		movieYear.setText(objects.get(position).getYear() + "");
		mpaaRating.setText(objects.get(position).getMpaa_rating() + "");

		new PhotoAsyncTask(context, imageView).execute(objects.get(position)
				.getThumbnail());
		return itemRowView;
	}
}