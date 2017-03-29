package dagger2simple.android.vogella.com.bigmovie.ui.fragment;

import android.content.Context;
import android.graphics.Movie;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import dagger2simple.android.vogella.com.bigmovie.data.repository.MoviesRepository;
import dagger2simple.android.vogella.com.bigmovie.ui.helper.MoviesHelper;

/**
 * Created by khoalevan on 3/29/2017.
 */

public abstract class MoviesFragment extends BaseFragment {
    @Inject
    MoviesRepository mMoviesRepository;

    protected Listener listener;
    protected MoviesHelper mMoviesHelper;
    public interface Listener {
        void onMovieSelected(Movie movie, View view);
    }

    @Override
    public void onAttach(Context activity) {
        if (!(activity instanceof Listener)) {
            throw new IllegalStateException("Activity must implement MoviesFragment.Listener");
        }
        super.onAttach(activity);

        listener = (Listener) activity;
        mMoviesHelper = new MoviesHelper(activity, mMoviesRepository);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate();
    }
}
