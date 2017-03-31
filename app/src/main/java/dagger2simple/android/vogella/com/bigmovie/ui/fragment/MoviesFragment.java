package dagger2simple.android.vogella.com.bigmovie.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger2simple.android.vogella.com.bigmovie.R;
import dagger2simple.android.vogella.com.bigmovie.data.repository.MoviesRepository;
import dagger2simple.android.vogella.com.bigmovie.ui.helper.MoviesHelper;
import rx.subscriptions.CompositeSubscription;
import dagger2simple.android.vogella.com.bigmovie.data.model.Movie;

/**
 * Created by khoalevan on 3/29/2017.
 */

public abstract class MoviesFragment extends BaseFragment {
    @Inject
    MoviesRepository mMoviesRepository;

    private static final String STATE_MOVIES = "state_movies";
    private static final String STATE_SELECTED_POSITION = "state_selected_position";

    protected Listener listener;
    protected MoviesHelper mMoviesHelper;
    protected CompositeSubscription mSubscriptions;
    protected int mSelectedPosition = -1;
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
        return inflater.inflate(R.layout.fragment_movies, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mSubscriptions = new CompositeSubscription();

        mSelectedPosition = savedInstanceState != null
                ? savedInstanceState.getInt(STATE_SELECTED_POSITION, -1)
                : -1;

        List<Movie> restoredMovies;

        if (savedInstanceState != null) {
            restoredMovies = savedInstanceState.getParcelableArrayList(STATE_MOVIES);
        } else {
            restoredMovies = new ArrayList<>();
        }


    }
}
