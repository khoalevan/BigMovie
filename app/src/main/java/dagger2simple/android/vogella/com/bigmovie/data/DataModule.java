package dagger2simple.android.vogella.com.bigmovie.data;

import dagger.Module;
import dagger2simple.android.vogella.com.bigmovie.data.repository.RepositoryModule;

/**
 * Created by khoalevan on 3/29/2017.
 */
@Module(
        includes = {
                RepositoryModule.class
        },
        injects = {

        },
        complete = false,
        library = true
)
public final class DataModule {
}
