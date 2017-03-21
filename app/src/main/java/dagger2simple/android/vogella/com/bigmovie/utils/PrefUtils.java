package dagger2simple.android.vogella.com.bigmovie.utils;

/**
 * Created by khoalevan on 3/22/17.
 */

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import dagger2simple.android.vogella.com.bigmovie.data.api.Sort;

/**
 * Utilities and constants related to app preferences.
 */
public final class PrefUtils {

    /**
     * Boolean indicating whether we performed the (one-time) welcome flow.
     */
    public static final String PREF_WELCOME_DONE = "pref_welcome_done";

    public static final String PREF_FAVORED_MOVIES = "pref_favored_movies";

    public static final String PREF_BROWSE_MOVIES_MODE = "pref_browse_movies_mode";

    public static final String PREF_INCLUDE_ADULT = "pref_include_adult";

    public static String getBrowseMoviesMode(final Context context) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        return sp.getString(PREF_BROWSE_MOVIES_MODE, Sort.POPULARITY.toString());
    }
}
