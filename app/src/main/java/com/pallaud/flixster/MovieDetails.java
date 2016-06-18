package com.pallaud.flixster;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.squareup.picasso.Picasso;

import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

public class MovieDetails extends AppCompatActivity {

    private boolean marked;
    Movie movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        // Gets movie information from intent, uses it to populate views
        movie = (Movie) getIntent().getSerializableExtra("movie");

        ((RatingBar) findViewById(R.id.rbVoteAvg)).setRating(movie.getRating());
        Picasso.with(getApplicationContext()).load(movie.getBackdropPath()).transform(new RoundedCornersTransformation(10, 10)).into(((ImageView) findViewById(R.id.ivImage)));
        ((TextView) findViewById(R.id.tvTitle)).setText(movie.getOriginalTitle());
        ((TextView) findViewById(R.id.tvOverview)).setText(movie.getOverview());

    }

    public void onSubmit(View view) {
        Intent data = new Intent();
        setResult(RESULT_OK, data);
        finish();
    }

}
