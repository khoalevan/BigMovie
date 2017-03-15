package dagger2simple.android.vogella.com.bigmovie.ui.activity;

import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import butterknife.Bind;
import dagger2simple.android.vogella.com.bigmovie.R;

/**
 * Created by khoalevan on 3/15/17.
 */

public class BaseActivity extends AppCompatActivity {
    @Nullable @Bind(R.id.toolbar) Toolbar mToolbar;
}