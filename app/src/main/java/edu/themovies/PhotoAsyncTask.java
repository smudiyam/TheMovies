/**
 * The Movies PhotoAsyncTask.java
 *
 * @author Sumanth Mudiyam
 */

package edu.themovies;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class PhotoAsyncTask extends AsyncTask<String, Void, Drawable> {

	Context context;
	ImageView imageView;

	public PhotoAsyncTask(Context context, ImageView imageView) {
		super();
		this.context = context;
		this.imageView = imageView;
	}

	@Override
	protected Drawable doInBackground(String... params) {
		Drawable drawable = null;
		Bitmap bitmap, bitmapResized;
		BitmapDrawable bitmapDrawable;
		int height, width;

		try {
			InputStream in = (InputStream) new URL(params[0]).getContent();
			drawable = Drawable.createFromStream(in, "Source Name");
			if (drawable == null)
				drawable = context.getResources().getDrawable(
						R.drawable.poster_not_found);
			else {
				bitmapDrawable = (BitmapDrawable) context.getResources()
						.getDrawable(R.drawable.poster_not_found);
				height = bitmapDrawable.getBitmap().getHeight();
				width = bitmapDrawable.getBitmap().getWidth();
				bitmap = ((BitmapDrawable) drawable).getBitmap();
				bitmapResized = Bitmap.createScaledBitmap(bitmap, width,
                        height, true);
				drawable = new BitmapDrawable(context.getResources(),
						bitmapResized);
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return drawable;
	}

	@Override
	protected void onPostExecute(Drawable result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		imageView.setImageDrawable(result);
	}
}