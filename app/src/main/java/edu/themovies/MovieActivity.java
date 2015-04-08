/**
 * The Movies MovieActivity.java
 *
 * @author Sumanth Mudiyam
 */

package edu.themovies;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class MovieActivity extends ActionBarActivity {

    final String OLD_FORMAT = "yyyy-MM-dd";
    final String NEW_FORMAT = "MM/dd/yyyy";
    TextView movieTitle, movieRelease, movieRating, movieLength, movieAudience,
            movieCritics;
    ImageButton backButton, imageButton;
    Movie movie;
    Drawable drawable;
    RelativeLayout relativeLayout;
    int color, movieRuntime;
    String audienceRating, criticsRating;
    SimpleDateFormat dateFormat;
    Date date;

    @SuppressLint("SimpleDateFormat")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        if (getIntent().getExtras() != null) {
            movie = (Movie) getIntent().getExtras().get(MoviesActivity.MOVIE);
        }

        color = Color.WHITE;

        relativeLayout = (RelativeLayout) findViewById(R.id.container);
        relativeLayout.setBackgroundColor(color);

        movieTitle = (TextView) findViewById(R.id.textView1);
        movieRelease = (TextView) findViewById(R.id.textView2);
        movieRating = (TextView) findViewById(R.id.textView3);
        movieLength = (TextView) findViewById(R.id.textView4);
        movieAudience = (TextView) findViewById(R.id.textView7);
        movieCritics = (TextView) findViewById(R.id.textView8);

        movieTitle.setText(movie.getTitle() + "");
        dateFormat = new SimpleDateFormat(OLD_FORMAT);

        try {
            date = dateFormat.parse(movie.getRelease_date());
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        dateFormat.applyPattern(NEW_FORMAT);
        movieRelease.setText(dateFormat.format(date) + "");

        movieRating.setText(movie.getMpaa_rating() + "");

        movieRuntime = movie.getRuntime();
        movieLength.setText(movieRuntime / 60 + " hr. " + movieRuntime % 60
                + "min.");

        if ((audienceRating = movie.getAudience_rating()) == null)
            audienceRating = "Unrated";
        movieAudience.setText(audienceRating + "");

        if ((criticsRating = movie.getCritics_rating()) == null)
            criticsRating = "Unrated";
        movieCritics.setText(criticsRating + "");

        backButton = (ImageButton) findViewById(R.id.imageButton1);
        backButton.setBackgroundColor(color);
        backButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                finish();
            }
        });

        imageButton = (ImageButton) findViewById(R.id.imageButton2);
        imageButton.setBackgroundColor(color);
        imageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(movie
                        .getAlternate()));
                finish();
                startActivity(intent);
            }
        });

        ImageView imageView = (ImageView) findViewById(R.id.imageView1);
        imageView.setImageDrawable(null);
        new PhotoAsyncTask(this, imageView).execute(movie.getDetailed());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_movie, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
