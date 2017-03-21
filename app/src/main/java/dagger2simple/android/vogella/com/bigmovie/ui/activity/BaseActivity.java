package dagger2simple.android.vogella.com.bigmovie.ui.activity;

import android.app.Application;
import android.provider.MediaStore;
import android.support.annotation.CallSuper;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.Timer;

import butterknife.Bind;
import butterknife.ButterKnife;
import dagger2simple.android.vogella.com.bigmovie.BigMoviesApplication;
import dagger2simple.android.vogella.com.bigmovie.R;
import timber.log.Timber;

/**
 * Created by khoalevan on 3/15/17.
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Nullable @Bind(R.id.toolbar) Toolbar mToolbar;

    @CallSuper
    @Override
    protected void onDestroy() {
        super.onDestroy();
        BigMoviesApplication.get(this).getRefWatcher().watch(this);
    }

    @CallSuper
    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
        setupToolbar();
    }

    @Nullable
    public final Toolbar getToolbar() {
        return mToolbar;
    }

    private void setupToolbar() {
        if (mToolbar == null) {
            Timber.w("Didn't find a toolbar");
        }
        ViewCompat.setElevation(mToolbar, getResources().getDimension(R.dimen.toolbar_elevation));
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar == null) return;
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setHomeButtonEnabled(false);
    }
}