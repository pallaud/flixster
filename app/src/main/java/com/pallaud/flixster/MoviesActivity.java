package com.pallaud.flixster;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MoviesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        // How to populate list with data:

        // 1. Get actual movies
        ArrayList<Movie> movies = Movie.getFakeMovies();

        // 2. Get ListView we want to populate
        ListView lvMovies = (ListView) findViewById(R.id.lvMovies);

        // 3. Create ArrayAdapter
        //ArrayAdapter<Movie> adapter = new ArrayAdapter<Movie>(this, android.R.layout.simple_list_item_1, movies);
        MoviesAdapter adapter = new MoviesAdapter(this, movies);

        // 4. Associate ArrayAdapter with the ListView
        if (lvMovies != null) {
            lvMovies.setAdapter(adapter);
        }

    }
}
