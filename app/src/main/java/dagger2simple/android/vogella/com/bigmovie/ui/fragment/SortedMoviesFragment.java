package dagger2simple.android.vogella.com.bigmovie.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;

import dagger2simple.android.vogella.com.bigmovie.data.api.Sort;

/**
 * Created by khoalevan on 3/29/2017.
 */

public final class SortedMoviesFragment extends MoviesFragment {
    private static final String ARG_SORT = "state_sort";

    public static SortedMoviesFragment newInstance(@NonNull Sort sort) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_SORT, sort);

        SortedMoviesFragment fragment = new SortedMoviesFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
