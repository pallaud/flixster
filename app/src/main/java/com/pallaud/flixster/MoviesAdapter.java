package com.pallaud.flixster;

import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;

import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

/**
 * Created by pallaud on 6/15/16.
 */
public class MoviesAdapter extends ArrayAdapter<Movie> {

    private final int POPULAR = 1;
    private final int NOT_POPULAR = 0;

    private static class ViewHolder {
        TextView title;
        TextView overview;
        ImageView image;
        ProgressBar popularity;
    }

    public MoviesAdapter(Context context, ArrayList<Movie> movies) {
        super(context, R.layout.item_movie, movies);
    }

    @Override
    public int getItemViewType(int position) {
        if(getItem(position).getPopularity() > 20) {
            return POPULAR;
        } else {
            return NOT_POPULAR;
        }
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Movie movie = getItem(position);
        int type = getItemViewType(position);

        ViewHolder viewHolder;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            switch (type) {
                case POPULAR:
                    convertView = LayoutInflater.from(getContext()).inflate(R.layout.popular_movie, parent, false);
                    if((getContext().getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)) {
                        viewHolder.overview = (TextView) convertView.findViewById(R.id.tvOverview);
                    } else {
                        viewHolder.overview = null;
                    }
                    viewHolder.popularity = (ProgressBar) convertView.findViewById(R.id.pbPopularity);
                    break;
                case NOT_POPULAR:
                    convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_movie, parent, false);
                    viewHolder.overview = (TextView) convertView.findViewById(R.id.tvOverview);
                    viewHolder.popularity = null;
                    break;
            }
            viewHolder.title = (TextView) convertView.findViewById(R.id.tvTitle);
            viewHolder.image = (ImageView) convertView.findViewById(R.id.ivImage);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.title.setText(movie.getOriginalTitle());
        if(viewHolder.overview != null) {
            viewHolder.overview.setText(movie.getOverview());
        } else if (viewHolder.popularity != null) {
            viewHolder.popularity.setProgress((int)movie.getPopularity()*2);
        }

        if((getContext().getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
                || (movie.getPopularity() > 20)) {
            Picasso.with(getContext()).load(movie.getBackdropPath()).transform(new RoundedCornersTransformation(10, 10)).placeholder(R.drawable.placeholder_img).into(viewHolder.image);
        } else {
            Picasso.with(getContext()).load(movie.getPosterPath()).transform(new RoundedCornersTransformation(10, 10)).placeholder(R.drawable.placeholder_img).into(viewHolder.image);
        }

        // Return the completed view to render on screen
        return convertView;

    }
}

