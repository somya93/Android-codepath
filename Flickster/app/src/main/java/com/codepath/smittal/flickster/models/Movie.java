package com.codepath.smittal.flickster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by smittal on 5/17/16.
 */
public class Movie implements Serializable {
    String posterPath;
    String originalTitle;
    String overview;
    String releaseDate;
    String backdropPath;
    float popularity;

    public Movie(JSONObject jsonObject) throws JSONException {
        this.posterPath = jsonObject.getString("poster_path");
        this.originalTitle = jsonObject.getString("original_title");
        this.overview = jsonObject.getString("overview");
        this.releaseDate = jsonObject.getString("release_date");
        this.backdropPath = jsonObject.getString("backdrop_path");
        this.popularity = Float.parseFloat(jsonObject.getString("popularity"));
    }

    public static ArrayList<Movie> fromJSONArray(JSONArray jsonArray) {
        ArrayList<Movie> results = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                results.add(new Movie(jsonArray.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return results;
    }

    public String getPosterPath() {
        return "https://image.tmdb.org/t/p/w342" + posterPath;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getOverview() {
        return overview;
    }

    public String getReleaseDate() {
        return parseDateToddMMyyyy(releaseDate);
    }

    public String getBigBackdropPath() {
        return "https://image.tmdb.org/t/p/w1280" + backdropPath;
    }

    public String getSmallBackdropPath() {
        return "https://image.tmdb.org/t/p/w780" + backdropPath;
    }

    public Float getPopularity() {
        return popularity/20;
    }

    public String parseDateToddMMyyyy(String time) {
        String inputPattern = "yyyy-MM-dd";
        String outputPattern = "dd-MMM-yyyy";
        SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern);
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);

        Date date = null;
        String str = null;

        try {
            date = inputFormat.parse(time);
            str = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return str;
    }
}
