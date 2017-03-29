package dagger2simple.android.vogella.com.bigmovie;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger2simple.android.vogella.com.bigmovie.BigMoviesApplication;
import dagger2simple.android.vogella.com.bigmovie.data.DataModule;

/**
 * Created by khoalevan on 3/20/2017.
 */

@Module (
        includes = DataModule.class,
        injects = BigMoviesApplication.class,
        library = true
)
public final class ApplicationModule {
    private final BigMoviesApplication application;

    public ApplicationModule(BigMoviesApplication application) {
        this.application = application;
    }

    @Provides @Singleton
    Application provideApplication() {
        return application;
    }
}
