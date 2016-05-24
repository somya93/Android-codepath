package com.codepath.smittal.flickster;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.codepath.smittal.flickster.models.Movie;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

public class MovieDetails extends AppCompatActivity {

    Movie movie;
    JSONObject jsonObject;
    ImageView ivBackdrop;
    TextView tvDetailsTitle;
    TextView tvReleaseDate;
    RatingBar rbPop;
    TextView tvDetailsOverview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        movie = (Movie)intent.getSerializableExtra("movie");
        ivBackdrop = (ImageView) findViewById(R.id.ivBackdrop);
        tvDetailsTitle = (TextView) findViewById(R.id.tvDetailsTitle);
        tvReleaseDate = (TextView) findViewById(R.id.tvReleaseDate);
        rbPop = (RatingBar) findViewById(R.id.rbPop);
        tvDetailsOverview = (TextView) findViewById(R.id.tvDetailsOverview);

        tvDetailsTitle.setText(movie.getOriginalTitle());
        tvReleaseDate.setTypeface(null, Typeface.ITALIC);
        tvReleaseDate.setText(movie.getReleaseDate());
        rbPop.setRating(movie.getPopularity());
        tvDetailsOverview.setText(movie.getOverview());

        Picasso.with(this).load(movie.getBigBackdropPath()).transform(new RoundedCornersTransformation(10, 10)).placeholder(R.drawable.cinema_film_movie_roll_video_128).into(ivBackdrop);
    }
}
