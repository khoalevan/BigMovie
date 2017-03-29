package dagger2simple.android.vogella.com.bigmovie.data.repository;

import android.graphics.Movie;

/**
 * Created by khoalevan on 3/29/2017.
 */

public interface MoviesRepository {

    void saveMovie(Movie movie);

    void deleteMovie(Movie movie);
}
