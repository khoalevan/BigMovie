package dagger2simple.android.vogella.com.bigmovie.data.repository;

import android.content.ContentResolver;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger2simple.android.vogella.com.bigmovie.data.api.MoviesApi;

/**
 * Created by khoalevan on 3/29/2017.
 */
@Module(complete = false, library = true)
public final class RepositoryModule {

    @Singleton
    @Provides
    public MoviesRepository providesMoviesRepository(MoviesApi moviesApi, ContentResolver contentResolver,
                                                     ) {

    }
}
