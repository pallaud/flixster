package com.pallaud.flixster;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by pallaud on 6/15/16.
 */
public class Movie implements Serializable {

    public String getOriginalTitle() {
        return originalTitle;
    }
    public float getRating() { return rating; }
    public double getPopularity() { return popularity; }
    public String getOverview() {
        return overview;
    }

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterPath);
    }

    public String getBackdropPath() {
        return String.format("https://image.tmdb.org/t/p/w500/%s", backdropPath);
    }

    public String originalTitle;
    public String posterPath;
    public String overview;
    public String backdropPath;
    public float rating;
    public double popularity;

    public Movie (JSONObject jsonObject) throws JSONException {
        posterPath = jsonObject.getString("poster_path");
        originalTitle = jsonObject.getString("original_title");
        overview = jsonObject.getString("overview");
        backdropPath = jsonObject.getString("backdrop_path");
        rating = (float) jsonObject.getDouble("vote_average");
        popularity = jsonObject.getDouble("popularity");
    }

    // Takes array of JSON responses and return array of Movies created from JSON info
    public static ArrayList<Movie> fromJsonArray(JSONArray jsonArray) {
        ArrayList<Movie> results = new ArrayList<>();
        for(int i=0; i< jsonArray.length(); i++) {
            try {
                results.add(new Movie(jsonArray.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return results;
    }

}
