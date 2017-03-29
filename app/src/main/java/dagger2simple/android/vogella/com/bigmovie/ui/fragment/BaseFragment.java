package dagger2simple.android.vogella.com.bigmovie.ui.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

import butterknife.ButterKnife;
import dagger.ObjectGraph;
import dagger2simple.android.vogella.com.bigmovie.BigMoviesApplication;

/**
 * Created by khoalevan on 3/29/2017.
 */

public abstract class BaseFragment extends Fragment {
    private ObjectGraph mObjectGraph;
    private Toast mToast;

    @CallSuper
    @Override public void onAttach(Context activity) {
        super.onAttach(activity);
        buildObjectGraph(activity);
    }

    @CallSuper
    @Override public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @CallSuper
    @Override public void onDestroyView() {
        ButterKnife.unbind(this);
        super.onDestroyView();
    }

    @CallSuper
    @Override public void onDestroy() {
        mObjectGraph = null;
        super.onDestroy();
        BigMoviesApplication.get(getActivity()).getRefWatcher().watch(this);
    }

    private void buildObjectGraph(Context activity) {
        Object[] modules = getModules().toArray();
        if (modules.length > 0) {
            mObjectGraph = BigMoviesApplication.get(activity).buildScopeObjectGraph(modules);
            mObjectGraph.inject(this);
        }
    }

    protected void showToast(String message) {
        if (mToast != null) mToast.cancel();
        mToast = Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT);
        mToast.show();
    }

    protected void showToast(@StringRes int resId) {
        if (mToast != null) mToast.cancel();
        mToast = Toast.makeText(getActivity(), resId, Toast.LENGTH_SHORT);
        mToast.show();
    }

    protected List<Object> getModules() {
        return Collections.emptyList();
    }
}
