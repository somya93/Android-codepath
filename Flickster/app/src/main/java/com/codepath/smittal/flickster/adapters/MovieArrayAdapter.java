package com.codepath.smittal.flickster.adapters;

import android.content.Context;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.codepath.smittal.flickster.MovieViewHolder;
import com.codepath.smittal.flickster.R;
import com.codepath.smittal.flickster.models.Movie;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

/**
 * Created by smittal on 5/17/16.
 */
public class MovieArrayAdapter extends ArrayAdapter<Movie> {

    public MovieArrayAdapter(Context context, ArrayList<Movie> movies){
        super(context, R.layout.item_movie, movies);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Movie movie = getItem(position);
        MovieViewHolder movieViewHolder;

        if(convertView == null) {
            movieViewHolder = new MovieViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_movie, parent, false);
            movieViewHolder.movieTitle = (TextView) convertView.findViewById(R.id.tvTitle);
            movieViewHolder.movieOverview = (TextView) convertView.findViewById(R.id.tvOverview);
            movieViewHolder.movieImage= (ImageView) convertView.findViewById(R.id.ivMovieImage);
            convertView.setTag(movieViewHolder);
        }

        else{
            movieViewHolder = (MovieViewHolder) convertView.getTag();
        }
        movieViewHolder.movieImage.setImageResource(0);
        movieViewHolder.movieTitle.setText(movie.getOriginalTitle());
        movieViewHolder.movieOverview.setText(movie.getOverview());
        Picasso.with(getContext()).load(movie.getPosterPath()).transform(new RoundedCornersTransformation(10, 10)).placeholder(R.drawable.cinema_film_movie_roll_video_128).into(movieViewHolder.movieImage);

        Display display = ((WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        int rotation = display.getRotation();
        if (rotation != 0) {
            Picasso.with(getContext()).load(movie.getSmallBackdropPath()).transform(new RoundedCornersTransformation(10, 10)).placeholder(R.drawable.cinema_film_movie_roll_video_128).into(movieViewHolder.movieImage);
        }
        return convertView;
    }


}
