package dagger2simple.android.vogella.com.bigmovie.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import dagger2simple.android.vogella.com.bigmovie.data.model.Movie;

/**
 * Created by khoalevan on 3/31/2017.
 */

public class MoviesAdapter extends EndlessAdapter<Movie, MoviesAdapter.MovieHolder> {

    final class MovieHolder extends RecyclerView.ViewHolder {
        public MovieHolder(View view) {
            super(view);
        }
    }
}
