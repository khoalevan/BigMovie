package dagger2simple.android.vogella.com.bigmovie.data.repository;

import android.content.ContentResolver;

import com.squareup.sqlbrite.BriteContentResolver;

import java.util.List;
import java.util.Set;

import dagger2simple.android.vogella.com.bigmovie.data.api.MoviesApi;
import dagger2simple.android.vogella.com.bigmovie.data.api.Sort;
import dagger2simple.android.vogella.com.bigmovie.data.model.Movie;
import dagger2simple.android.vogella.com.bigmovie.data.model.Review;
import dagger2simple.android.vogella.com.bigmovie.data.model.Video;
import rx.Observable;

/**
 * Created by khoalevan on 3/29/17.
 */

public final class MoviesRepositoryImpl implements MoviesRepository {

    private final MoviesApi mMoviesApi;
    private final ContentResolver mContentResolver;
    private final BriteContentResolver mBriteContentResolver;
    private final GenresRepository mGenreRepository;

    public MoviesRepositoryImpl(MoviesApi moviesApi, ContentResolver contentResolver,
                                BriteContentResolver briteContentResolver, GenresRepository repository) {
        mMoviesApi = moviesApi;
        mContentResolver = contentResolver;
        mBriteContentResolver = briteContentResolver;
        mGenreRepository = repository;
    }

    @Override
    public Observable<List<Movie>> discoverMovies(Sort sort, int page) {
        return null;
    }

    @Override
    public Observable<List<Movie>> savedMovies() {
        return null;
    }

    @Override
    public Observable<Set<Long>> savedMovieIds() {
        return null;
    }

    @Override
    public void saveMovie(Movie movie) {

    }

    @Override
    public void deleteMovie(Movie movie) {

    }

    @Override
    public Observable<List<Video>> videos(long movieId) {
        return null;
    }

    @Override
    public Observable<List<Review>> reviews(long movieId) {
        return null;
    }
}
