package com.pallaud.flixster;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by pallaud on 6/15/16.
 */
public class MoviesAdapter extends ArrayAdapter<Movie> {

    public MoviesAdapter(Context context, ArrayList<Movie> movies) {
        super(context, R.layout.item_movie, movies);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Has adapter get the data item for this position
        Movie movie = getItem(position);

        // **Check if an existing view is being reused, otherwise inflate the view; giving access to XML
        // deals with recycling; if unseen, executes this line and creates new, else already has it
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_movie, parent, false);
        }

        // Lookup view for data population
        TextView tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
        TextView tvOverview = (TextView) convertView.findViewById(R.id.tvOverview);
        ImageView ivImage = (ImageView) convertView.findViewById(R.id.ivImage);
        // Clear our image from convertView
        ivImage.setImageResource(0);

        // Populate the data into the template view using the data object
        tvTitle.setText(movie.getOriginalTitle());
        tvOverview.setText(movie.getOverview());
        Picasso.with(getContext()).load(movie.getPosterPath()).into(ivImage);

        // Return the completed view to render on screen
        return convertView;

    }
}

