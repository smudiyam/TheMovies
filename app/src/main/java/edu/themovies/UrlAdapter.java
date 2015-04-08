/**
 * The Movies UrlAdapter.java
 *
 * @author Sumanth Mudiyam
 */

package edu.themovies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class UrlAdapter extends ArrayAdapter<Url> {
	Context context;
	ArrayList<Url> objects;

	public UrlAdapter(Context context, ArrayList<Url> objects) {
		super(context, R.layout.item_row_mainlayout, objects);
		this.context = context;
		this.objects = objects;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View itemRowView = inflater.inflate(R.layout.item_row_mainlayout,
				parent, false);

		TextView urlDisplay = (TextView) itemRowView
				.findViewById(R.id.textView1);
		urlDisplay.setText(objects.get(position).getType() + "");

		return itemRowView;
	}
}