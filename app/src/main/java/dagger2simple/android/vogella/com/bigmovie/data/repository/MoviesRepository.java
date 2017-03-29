package dagger2simple.android.vogella.com.bigmovie.data.repository;


import java.util.List;
import java.util.Set;

import dagger2simple.android.vogella.com.bigmovie.data.api.Sort;
import dagger2simple.android.vogella.com.bigmovie.data.model.Movie;
import dagger2simple.android.vogella.com.bigmovie.data.model.Review;
import dagger2simple.android.vogella.com.bigmovie.data.model.Video;
import rx.Observable;

/**
 * Created by khoalevan on 3/29/2017.
 */

public interface MoviesRepository {

    Observable<List<Movie>> discoverMovies(Sort sort, int page);

    Observable<List<Movie>> savedMovies();

    Observable<Set<Long>> savedMovieIds();

    void saveMovie(Movie movie);

    void deleteMovie(Movie movie);

    Observable<List<Video>> videos(long movieId);

    Observable<List<Review>> reviews(long movieId);
}
