package dagger2simple.android.vogella.com.bigmovie.data.api;

import dagger2simple.android.vogella.com.bigmovie.data.model.Genre;
import dagger2simple.android.vogella.com.bigmovie.data.model.Movie;
import dagger2simple.android.vogella.com.bigmovie.data.model.Review;
import dagger2simple.android.vogella.com.bigmovie.data.model.Video;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by khoalevan on 3/29/2017.
 */

public interface MoviesApi {

    @GET("/genre/movie/list")
    Observable<Genre.Response> genres();

    @GET("discover/movie")
    Observable<Movie.Response> discoverMovies(
            @Query("sort_by") Sort sort,
            @Query("page") int page
    );

    @GET("/movie/{id}/videos") Observable<Video.Response> videos(
            @Path("id") long movieId
    );

    @GET("/movie/{id}/reviews") Observable<Review.Response> reviews(
            @Path("id") long movieId,
            @Query("page") int page
    );
}
