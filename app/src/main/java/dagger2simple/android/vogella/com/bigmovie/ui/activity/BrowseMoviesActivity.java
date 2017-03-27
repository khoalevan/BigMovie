package dagger2simple.android.vogella.com.bigmovie.ui.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

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

        View spinnerContainer = LayoutInflater.from(this).inflate(R.layout.widget_toolbar_spinner, toolbar, false);
        ActionBar.LayoutParams lp = new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        toolbar.addView(spinnerContainer, lp);
        Spinner spinner = (Spinner) spinnerContainer.findViewById(R.id.mode_spinner);

    }

    private class ModeSpinnerItem {
        boolean isHeader;
        String mode, title;
        boolean indented;

        ModeSpinnerItem(boolean isHeader, String mode, String title, boolean indented) {
            this.isHeader = isHeader;
            this.mode = mode;
            this.title = title;
            this.indented = indented;
        }
    }

    private class ModeSpinnerAdapter extends BaseAdapter {
        private ArrayList<ModeSpinnerItem> mItems = new ArrayList<ModeSpinnerItem>();

        private ModeSpinnerAdapter() {}

        public void clear() {
            mItems.clear();
        }

        public void addItem(String tag, String title, boolean indented) {
            mItems.add(new ModeSpinnerItem(false, tag, title, indented));
        }

        public void addHeader(String title) {
            mItems.add(new ModeSpinnerItem(true, "", title, false));
        }

        @Override
        public int getCount() {
            return mItems.size();
        }

        @Override
        public Object getItem(int i) {
            return mItems.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }



        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null || !view.getTag().toString().equals("NON_DROPDOWN")){
                view = getLayoutInflater().inflate()
            }


            return null;
        }
    }
}
