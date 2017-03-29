package dagger2simple.android.vogella.com.bigmovie.ui.fragment;

import android.content.Context;
import android.graphics.Movie;
import android.view.View;

/**
 * Created by khoalevan on 3/29/2017.
 */

public abstract class MoviesFragment extends BaseFragment {

    protected Listener listener;

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
    }
}
