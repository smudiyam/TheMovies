/**
 * The Movies MoviesActivity.java
 *
 * @author Sumanth Mudiyam
 */

package edu.themovies;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class MoviesActivity extends ActionBarActivity {

    public static String MOVIE = "Movie";
    String url;
    ArrayList<Movie> movies;
    Drawable drawable;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        if (getIntent().getExtras() != null) {
            url = getIntent().getExtras().getString(MainActivity.MOVIE_TYPE);
        }
        movies = new ArrayList<Movie>();
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading Movies");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setCancelable(false);
        progressDialog.show();
        new JSONAsyncTask(this).execute(url);
    }

    public void setUpData() {

        ListView myListView = (ListView) findViewById(R.id.listView1);
        MovieAdapter adapter = new MovieAdapter(this, movies);
        progressDialog.dismiss();

        myListView.setAdapter(adapter);
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent intent = new Intent(MoviesActivity.this,
                        MovieActivity.class);
                intent.putExtra(MOVIE,
                        (Movie) parent.getItemAtPosition(position));
                // Intent intent = new
                // Intent(Intent.ACTION_VIEW,Uri.parse(((Url)
                // parent.getItemAtPosition(position)).getUrl()));
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_movies, menu);
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
