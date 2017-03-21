package dagger2simple.android.vogella.com.bigmovie;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.RefWatcher;

import dagger.ObjectGraph;
import dagger2simple.android.vogella.com.bigmovie.ApplicationModule;

/**
 * Created by khoalevan on 3/18/2017.
 */

public final class BigMoviesApplication extends Application {
    ObjectGraph objectGraph;
    RefWatcher refWatcher;

    public static BigMoviesApplication get(Context context) {
        return (BigMoviesApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        refWatcher = installLeakCanary();
        objectGraph = initializeObjectGraph();
    }

    public RefWatcher getRefWatcher() {return refWatcher;}

    protected RefWatcher installLeakCanary() {
        return RefWatcher.DISABLED;
    }

    public ObjectGraph buildScopeObjectGraph(Object... modules) {
        return objectGraph.plus(modules);
    }

    public void inject(Object o) {
        objectGraph.inject(o);
    }

    private ObjectGraph initializeObjectGraph() {
        return buildInitialObjectGraph(new ApplicationModule(this));
    }

    private ObjectGraph buildInitialObjectGraph(Object... modules) {
        return ObjectGraph.create(modules);
    }
}
