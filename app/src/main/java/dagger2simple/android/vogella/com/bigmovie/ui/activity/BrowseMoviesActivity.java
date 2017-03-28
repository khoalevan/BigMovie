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
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import dagger2simple.android.vogella.com.bigmovie.R;
import dagger2simple.android.vogella.com.bigmovie.data.api.Sort;
import dagger2simple.android.vogella.com.bigmovie.utils.PrefUtils;

/**
 * Created by khoalevan on 3/15/17.
 */

public class BrowseMoviesActivity extends BaseActivity {

    private static final String STATE_MODE = "state_mode";
    public static final String MODE_FAVORITES = "favorites";

    private String mMode;
    private boolean mTwoPane;
    private ModeSpinnerAdapter mSpinnerAdapter = new ModeSpinnerAdapter();

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

        mSpinnerAdapter.clear();
        mSpinnerAdapter.addItem(MODE_FAVORITES, "Favorites", false);
        mSpinnerAdapter.addHeader("Sorting");
        mSpinnerAdapter.addItem(Sort.POPULARITY.toString(), "Most popular", false);
        mSpinnerAdapter.addItem(Sort.VOTE_COUNT.toString(), "Most rated", false);
        mSpinnerAdapter.addItem(Sort.VOTE_AVERAGE.toString(), "Highest rated", false);

        int itemToSelect = -1;

        if (mMode.equals(MODE_FAVORITES))
            itemToSelect = 0;
        else if (mMode.equals(Sort.POPULARITY.toString()))
            itemToSelect = 2;
        else if (mMode.equals(Sort.VOTE_COUNT.toString()))
            itemToSelect = 3;
        else if (mMode.equals(Sort.VOTE_AVERAGE.toString()))
            itemToSelect = 4;

        View spinnerContainer = LayoutInflater.from(this).inflate(R.layout.widget_toolbar_spinner, toolbar, false);
        ActionBar.LayoutParams lp = new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        toolbar.addView(spinnerContainer, lp);

        Spinner spinner = (Spinner) spinnerContainer.findViewById(R.id.mode_spinner);
        spinner.setAdapter(mSpinnerAdapter);


        if (itemToSelect >= 0) {
            
        }
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

        private boolean isHeader(int position) {
            return position >= 0 && position < mItems.size() && mItems.get(position).isHeader;
        }

        @Override
        public View getDropDownView(int position, View view, ViewGroup parent) {
            if (view == null || !view.getTag().toString().equals("DROPDOWN")) {
                view = getLayoutInflater().inflate(R.layout.item_toolbar_spinner_dropdown, parent, false);
                view.setTag("DROPDOWN");
            }

            TextView headerTextView = (TextView) view.findViewById(R.id.header_text);
            View dividerView = view.findViewById(R.id.divider_view);
            TextView normalTextView = (TextView) view.findViewById(android.R.id.text1);

            if (isHeader(position)) {
                headerTextView.setText(getTitle(position));
                headerTextView.setVisibility(View.VISIBLE);
                normalTextView.setVisibility(View.GONE);
                dividerView.setVisibility(View.VISIBLE);
            } else {
                headerTextView.setVisibility(View.GONE);
                normalTextView.setVisibility(View.VISIBLE);
                dividerView.setVisibility(View.GONE);

                setUpNormalDropdownView(position, normalTextView);
            }

            return view;
        }

        private void setUpNormalDropdownView(int position, TextView textView) {
            textView.setText(getTitle(position));
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null || !view.getTag().toString().equals("NON_DROPDOWN")){
                view = getLayoutInflater().inflate(R.layout.item_toolbar_spinner, viewGroup, false);
                view.setTag("NON_DROPDOWN");
            }
            TextView textView = (TextView) view.findViewById(android.R.id.text1);
            textView.setText(getTitle(i));

            return view;
        }

        private String getTitle(int position) {
            return position >= 0 && position < mItems.size()? mItems.get(position).title : "";
        }


    }
}
