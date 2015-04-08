/**
 * The Movies MainActivity.java
 *
 * @author Sumanth Mudiyam
 */

package edu.themovies;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    public static String MOVIE_TYPE = "MovieType";
    public static String LIMIT_PAGE = "20";
    ArrayList<Url> url;
    ListView myListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        url = new ArrayList<Url>();
        url.add(new Url(
                "Box Office Movies",
                "http://api.rottentomatoes.com/api/public/v1.0/lists/movies/box_office.json?apikey=da8cszax78esw2xhvvtzuvrv"
                        + "&limit=" + LIMIT_PAGE));
        url.add(new Url(
                "In Theatres Movies",
                "http://api.rottentomatoes.com/api/public/v1.0/lists/movies/in_theaters.json?apikey=da8cszax78esw2xhvvtzuvrv"
                        + "&page_limit=" + LIMIT_PAGE));
        url.add(new Url(
                "Opening Movies",
                "http://api.rottentomatoes.com/api/public/v1.0/lists/movies/opening.json?apikey=da8cszax78esw2xhvvtzuvrv"
                        + "&limit=" + LIMIT_PAGE));
        url.add(new Url(
                "Upcoming Movies",
                "http://api.rottentomatoes.com/api/public/v1.0/lists/movies/upcoming.json?apikey=da8cszax78esw2xhvvtzuvrv"
                        + "&page_limit=" + LIMIT_PAGE));

        myListView = (ListView) findViewById(R.id.listView1);
        UrlAdapter adapter = new UrlAdapter(this, url);
        myListView.setAdapter(adapter);
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent intent = new Intent(MainActivity.this,
                        MoviesActivity.class);
                intent.putExtra(MOVIE_TYPE,
                        ((Url) parent.getItemAtPosition(position)).getUrl());
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
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
