package dagger2simple.android.vogella.com.bigmovie.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import dagger2simple.android.vogella.com.bigmovie.data.model.Movie;

/**
 * Created by khoalevan on 3/31/2017.
 */

public class MoviesAdapter extends EndlessAdapter<Movie, MoviesAdapter.MovieHolder> {

    @NonNull private final Fragment mFragment;

    public MoviesAdapter(@NonNull Fragment fragment, List<Movie> movies) {
        super(fragment.getActivity(), movies == null ? new ArrayList<Movie>() : movies);
        mFragment = fragment;
        setHasStableIds(true);
    }

    @Override
    public long getItemId(int position) {
        return !(isLoadMore(position)) ? mItems.get(position).getId() : -1;
    }

    @Override
    protected MovieHolder onCreateItemHolder(ViewGroup parent, int viewType) {
        return new MovieHolder(mInflater.inflate(), parent, false);
    }

    final class MovieHolder extends RecyclerView.ViewHolder {
        public MovieHolder(View view) {
            super(view);
        }
    }
}
