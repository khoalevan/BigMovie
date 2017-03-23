package dagger2simple.android.vogella.com.bigmovie.ui.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;

import dagger2simple.android.vogella.com.bigmovie.R;
import dagger2simple.android.vogella.com.bigmovie.data.api.Sort;
import dagger2simple.android.vogella.com.bigmovie.utils.PrefUtils;

/**
 * Created by khoalevan on 3/15/17.
 */

public class BrowseMoviesActivity extends BaseActivity {

    private static final String STATE_MODE = "state_mode";

    private String mMode;
    private boolean mTwoPane;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_browse_movies);

        mTwoPane = findViewById(R.id.movies_detail_container) != null;

        mMode = (savedInstanceState != null)?
                savedInstanceState.getString(STATE_MODE, Sort.POPULARITY.toString())
                : PrefUtils.getBrowseMoviesMode(this);

        initModeSpinner();
    }


    public void initModeSpinner() {
        Toolbar toolbar = getToolbar();
        if (toolbar == null) {
            return;
        }



    }
}
