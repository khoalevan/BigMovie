package dagger2simple.android.vogella.com.bigmovie;

import android.app.Application;
import android.content.Context;
import com.squareup.leakcanary.RefWatcher;
import dagger.ObjectGraph;



/**
 * Created by khoalevan on 3/16/17.
 */

public final class BigMoviesApplication extends Application {
    private ObjectGraph objectGraph;
    private RefWatcher refWatcher;

    public static BigMoviesApplication get(Context context) {
        return (BigMoviesApplication)context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        refWatcher = installLeakCanary();
    }

    protected RefWatcher installLeakCanary() {
        return RefWatcher.DISABLED;
    }
}
