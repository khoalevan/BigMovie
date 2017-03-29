package dagger2simple.android.vogella.com.bigmovie.ui.helper;

import android.content.Context;

import dagger2simple.android.vogella.com.bigmovie.data.repository.MoviesRepository;

/**
 * Created by khoalevan on 3/29/17.
 */

public class MoviesHelper {
    private final Context mActivity;
    private final MoviesRepository mMoviesRepository;

    public MoviesHelper(Context activity, MoviesRepository moviesRepository) {
        mActivity = activity;
        mMoviesRepository = moviesRepository;
    }
}
