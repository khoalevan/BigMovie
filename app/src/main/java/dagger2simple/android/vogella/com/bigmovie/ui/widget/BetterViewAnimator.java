package dagger2simple.android.vogella.com.bigmovie.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ViewAnimator;

/**
 * Created by khoalevan on 3/29/17.
 */

public class BetterViewAnimator extends ViewAnimator {

    public BetterViewAnimator(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setDisplayChildId(int id) {
        if (getDisplayChildId() == id) {
            return;
        }
        for (int i = 0, count = getChildCount(); i < count; i++) {
            if (getChildAt(i).getId() == getDisplayChildId()) {
                setDisplayedChild(i);
                return;
            }
        }
        String name = getResources().getResourceEntryName(id);
        throw new IllegalArgumentException("No view with ID: " + name);
    }

    public int getDisplayChildId() {
        return getChildAt(getDisplayedChild()).getId();
    }
}
