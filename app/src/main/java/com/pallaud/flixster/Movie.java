package com.pallaud.flixster;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by pallaud on 6/15/16.
 */
public class Movie {

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterPath);
    }

    public String getOverview() {
        return overview;
    }

    public String originalTitle;
    public String posterPath;
    public String overview;

    public Movie(String originalTitle, String overview, String posterPath) {
        this.originalTitle = originalTitle;
        this.overview = overview;
        this.posterPath = posterPath;
    }

    public Movie (JSONObject jsonObject) throws JSONException {
        this.posterPath = jsonObject.getString("poster_path");
        this.originalTitle = jsonObject.getString("original_title");
        this.overview = jsonObject.getString("overview");
    }

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
