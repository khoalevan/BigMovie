package dagger2simple.android.vogella.com.bigmovie.ui.widget;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;

/**
 * Created by khoalevan on 3/29/17.
 */

public class MultiSwipeRefreshLayout extends SwipeRefreshLayout {
    private CanChildScrollUpCallBack canChildScrollUpCallBack;

    public MultiSwipeRefreshLayout(Context context) {
        this(context, null);
    }

    public MultiSwipeRefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setCanChildScrollUpCallBack(CanChildScrollUpCallBack canChildScrollUpCallBack) {
        this.canChildScrollUpCallBack = canChildScrollUpCallBack;
    }

    public interface CanChildScrollUpCallBack {
        boolean canSwipeRefrestScrollUp();
    }

    @Override
    public boolean canChildScrollUp() {
        if (canChildScrollUpCallBack != null) {
            return canChildScrollUpCallBack.canSwipeRefrestScrollUp();
        }
        return super.canChildScrollUp();
    }
}
